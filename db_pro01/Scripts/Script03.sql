-- DEPARTMENTS 테이블에서 DEPARTMENT_NAME 이 Marketing 인 데이터 조회
SELECT *
  FROM DEPARTMENTS
 WHERE DEPARTMENT_NAME = 'Marketing';

-- DEPARTMENTS 테이블에서 DEPARTMENT_NAME 에 IT 가 포함된 데이터 조회

SELECT *
  FROM DEPARTMENTS
 WHERE DEPARTMENT_NAME LIKE '%IT%';

-- LOCATIONS 테이블에서 COUNTRY_ID 가 US 인 데이터 조회할 때
-- STREET_ADDRESS, POSTAL_CODE, CITY 컬럼만 조회한다.

SELECT STREET_ADDRESS
	,  POSTAL_CODE
	,  CITY 
  FROM LOCATIONS
 WHERE COUNTRY_ID = 'US'; 

-- LOCATIONS 테이블에서 POSTAL_CODE 가 5 자리인 데이터 조회

SELECT *
  FROM LOCATIONS
 WHERE POSTAL_CODE LIKE '_____';

-- EMPLOYEES 테이블에서 MANAGER_ID 가 100 이고 DEPARTMENT_ID 가 50 인 데이터 조회

SELECT *
  FROM EMPLOYEES
 WHERE MANAGER_ID = 100
   AND DEPARTMENT_ID = 50;

-- EMPLOYEES 테이블에서 COMMISSION_PCT 가 NULL 이 아니면서 SALARY 가 10000 이상인
-- 데이터를 조회 할 때 COMMISSION_PCT 가 포함된 급여로 조회
-- SALARY, COMMISSION_PCT, TOTAL_SALARY 컬럼명으로 결과가 나오게 한다.
-- TOTAL_SALARY 는 SALARY * (1 + COMMISSION_PCT) 계산 결과로 나오게 한다.
 
SELECT SALARY
	 , COMMISSION_PCT
	 , SALARY * (1 + COMMISSION_PCT) AS TOTAL_SALARY 
  FROM EMPLOYEES
 WHERE COMMISSION_PCT IS NOT NULL
   AND SALARY >= 10000;

-- EMPLOYEES 테이블에서 MANAGER_ID 가 100, 101, 102, 200, 201, 202 인 데이터 조회
-- FIRST_NAME, LAST_NAME 은 하나의 컬럼(EMP_NAME)으로 조회되도록 한다.
 
SELECT FIRST_NAME || ' ' || LAST_NAME AS "EMP_NAME"
  FROM EMPLOYEES
 WHERE MANAGER_ID IN (100,101,102,200,201,202);

SELECT FIRST_NAME || ' ' || LAST_NAME AS "EMP_NAME"
  FROM EMPLOYEES
 WHERE MANAGER_ID IN (100,101,102)
	OR MANAGER_ID IN (200,201,202);

SELECT FIRST_NAME || ' ' || LAST_NAME AS "EMP_NAME"
  FROM EMPLOYEES
 WHERE MANAGER_ID = 100
 	OR MANAGER_ID = 101
 	OR MANAGER_ID = 102
 	OR MANAGER_ID = 200
	OR MANAGER_ID = 201
	OR MANAGER_ID = 202;

-- EMPLOYEES 테이블에서 EMAIL 컬럼을 조회할 때 EMAIL@JOB_ID.employee.com 형식으로 조회
-- 되도록 한다.
-- 예) EMPLOYEE_ID 가 100 인 사원은 EMAIL 이 SKING, JOB_ID 가 AD_PRES 이다 이를 문제에서
--     제시하는 형식으로 조회하면 SKING@AD_PRES.employee.com 으로 조회가 된다.
SELECT EMAIL || '@' || JOB_ID || '.emplyoee.com' AS EMAIL
  FROM EMPLOYEES;

