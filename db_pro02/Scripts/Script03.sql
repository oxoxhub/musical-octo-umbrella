SELECT *
  FROM EMPLOYEES;

/*
 * EMPLOYEES 테이블의 구조를 복사한 새로운 테이블 2개를 만든다.
 *		- EMP_COMMISSION 테이블을 만든다. 이 테이블은 EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY,COMMISSION_PCT 컬럼을 가진다.
 *		- EMP_NO_COMMISSION 테이블을 만든다. 이 테이블은 EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY 컬럼을 가진다.
 */

CREATE TABLE EMP_COMMISSION1 (
	   EMPLOYEE_ID NUMBER
	 , FIRST_NAME VARCHAR(50)
	 , LAST_NAME VARCHAR(50)
	 , SALARY NUMBER
	 , COMMISSION_PCT NUMBER
);

CREATE TABLE EMP_NO_COMMISSION1 (
       EMPLOYEE_ID NUMBER
	 , FIRST_NAME VARCHAR(50)
	 , LAST_NAME VARCHAR(50)
	 , SALARY NUMBER
);

SELECT * FROM EMP_COMMISSION1;
SELECT * FROM EMP_NO_COMMISSION1;

INSERT INTO EMP_COMMISSION1 (
	   SELECT EMPLOYEE_ID
	   	    , FIRST_NAME
	   	    , LAST_NAME
	   	    , SALARY
	   	    , COMMISSION_PCT
	   	FROM EMPLOYEES
	   WHERE COMMISSION_PCT IS NOT NULL
);
--업데이트시 Result set 화면의 Updated Rows = 행. 꼭 확인해보기
--Auto Commit 트랜젝션

INSERT INTO EMP_NO_COMMISSION1 (
	   SELECT EMPLOYEE_ID
	   		, FIRST_NAME
	   		, LAST_NAME
	   		, SALARY
	   	 FROM EMPLOYEES
	   	WHERE COMMISSION_PCT IS NULL
);


DELETE FROM EMP_COMMISSION1;
DELETE FROM EMP_NO_COMMISSION1;

/*
 * 위 작업을 통해 생성한 테이블에 EMPLOYEES 테이블이 가지고 있는 모든 행 데이터를 추가한다.
 * 		- INSERT INTO ... (SELECT ... 구문을 사용하여 추가해 본다.)
 * 		- INSERT ALL INTO ... 구문을 사용하여 추가해 본다.
 * 
 * 위의 작업을 진행 할 때 DELETE FROM EMP_COMMISSION; DELETE FROM EMP_NO_COMMISSION; 을 작업 후 진행한다.
 */

CREATE TABLE EMP_COMMISSION2
   AS SELECT EMPLOYEE_ID
	   	   , FIRST_NAME
	   	   , LAST_NAME
	   	   , SALARY
	   	   , COMMISSION_PCT
	    FROM EMPLOYEES
	   WHERE 1=0;

CREATE TABLE EMP_NO_COMMISSION2
   AS SELECT EMPLOYEE_ID
	   	   , FIRST_NAME
	   	   , LAST_NAME
	   	   , SALARY
	    FROM EMPLOYEES
	   WHERE 1=0;

--테이블 구조 만들어서 복사하기
	  
SELECT * FROM EMP_COMMISSION2;
SELECT * FROM EMP_NO_COMMISSION2;

DELETE FROM EMP_COMMISSION2;
DELETE FROM EMP_NO_COMMISSION2;

INSERT ALL
INTO EMP_COMMISSION2 VALUES(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY, COMMISSION_PCT)
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY, COMMISSION_PCT
FROM EMPLOYEES;

INSERT ALL
INTO EMP_NO_COMMISSION2 VALUES(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY)
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY
FROM EMPLOYEES;

INSERT ALL
WHEN COMMISSION_PCT IS NOT NULL THEN
	 INTO EMP_COMMISSION2 VALUES(EMPLOYEE_ID, FIRST_NAME, 이름, SALARY, COMMISSION_PCT)
WHEN COMMISSION_PCT IS NULL THEN
	 INTO EMP_NO_COMMISSION2 VALUES(EMPLOYEE_ID, FIRST_NAME, 이름, SALARY)
SELECT EMPLOYEE_ID, LOWER(FIRST_NAME) AS FIRST_NAME, LOWER(LAST_NAME) AS 이름, SALARY, COMMISSION_PCT
FROM EMPLOYEES;
--SELECT절과 VALUES의 이름은 똑같아야한다 혹은 별칭이 같거나

COMMIT; --저장


/*
 * EMP_COMMISSION2 테이블에서 모든 사원에 대해 COMMISSION_PCT 를 0.02 증가 시킨다.
 */

UPDATE EMP_COMMISSION2
   SET COMMISSION_PCT = COMMISSION_PCT + 0.02;
 
SELECT * FROM EMP_COMMISSION2;
COMMIT;

/*
 * EMP_NO_COMMISSION2 테이블에서 SALARY 가 4000 이하인 사원들에 대해 SALARY 를 200 증가 시킨다.
 */
SELECT * FROM EMP_NO_COMMISSION2 WHERE SALARY <= 4200;

UPDATE EMP_NO_COMMISSION2
   SET SALARY = SALARY + 200
 WHERE SALARY <= 4000;

ROLLBACK;
COMMIT;


SELECT * FROM DEPARTMENTS;

SELECT * 
  FROM EMP_COMMISSION2
 WHERE EMPLOYEE_ID IN (SELECT MANAGER_ID FROM DEPARTMENTS WHERE MANAGER_ID IS NOT NULL);

SELECT * 
  FROM EMP_NO_COMMISSION2
 WHERE EMPLOYEE_ID IN (SELECT MANAGER_ID FROM DEPARTMENTS WHERE MANAGER_ID IS NOT NULL);


UPDATE EMP_COMMISSION2
   SET SALARY = SALARY + 100
 WHERE EMPLOYEE_ID IN (SELECT MANAGER_ID FROM DEPARTMENTS WHERE MANAGER_ID IS NOT NULL);

UPDATE EMP_NO_COMMISSION2
   SET SALARY = SALARY + 100
 WHERE EMPLOYEE_ID IN (SELECT MANAGER_ID FROM DEPARTMENTS WHERE MANAGER_ID IS NOT NULL);

COMMIT;

UPDATE EMP_COMMISSION2
   SET SALARY = SALARY + 100
 WHERE EMPLOYEE_ID IN (200, 201, 114, 203, ...);
