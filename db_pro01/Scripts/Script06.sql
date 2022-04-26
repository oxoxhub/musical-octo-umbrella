SELECT NVL(NULL, 'Default')
  FROM DUAL;
  --NULL일때 설정한 Default값이 출력된다.
SELECT NVL(COMMISSION_PCT, 0)
  FROM EMPLOYEES;
  
-- DECODE(식, 값1, 반환값1, 값2, 반환값2, 값3, 반환값3, ..., 기본값) 
-- SWITCH문과 비슷하다.
 
SELECT DECODE(DEPARTMENT_ID, 90, 'A부서', 60, 'B부서', 100, 'C부서', '그 외')
	 , DEPARTMENT_ID
  FROM EMPLOYEES;
 
SELECT DECODE(DEPARTMENT_ID, 90, 'A부서', 60, 'B부서', 100, 'C부서', '그 외')
	 , DEPARTMENT_ID
	 , COUNT(*)
  FROM EMPLOYEES
 GROUP BY DEPARTMENT_ID
 ORDER BY 1;
  
SELECT DECODE(EXTRACT(YEAR FROM HIRE_DATE), 2000, '신규사원', '기존사원')
  FROM EMPLOYEES;
  
SELECT CASE WHEN 조건식 THEN 반환값
			WHEN 조건식 THEN 반환값
			...
			ELSE 반환값
		END
--ELSE 생략가능
  FROM EMPLOYEES;
 
SELECT SALARY 
	 , CASE WHEN SALARY >= 2000 AND SALARY < 5000 THEN '하위소득'
			WHEN SALARY >= 5000 AND SALARY < 10000 THEN '중위소득'
			WHEN SALARY >= 10000 THEN '고소득'
			ELSE '미분류'
		END AS 급여분류
  FROM EMPLOYEES;

 --여기까지 단일함수

SELECT SUM(SALARY) AS 총합
	 , AVG(SALARY) AS 평균
	 , MAX(SALARY) AS 최대급여액
	 , MIN(SALARY) AS 최소급여액
	 , COUNT(SALARY) AS "수량(행수,인원수)"
  FROM EMPLOYEES; 

SELECT SUM(SALARY) AS 총합
	 , AVG(SALARY) AS 평균
	 , MAX(SALARY) AS 최대급여액
	 , MIN(SALARY) AS 최소급여액
	 , COUNT(SALARY) AS "수량(행수,인원수)"
  FROM EMPLOYEES 
 WHERE DEPARTMENT_ID = 100;

--EMPLOYEE테이블에서 DEPARTMENT_ID가 80인 직원의 보너스 포함 연봉 조회, 연봉 합계, 보너스 평균값
SELECT SUM(SALARY * 12) AS 연봉
	 , SUM(SALARY + (SALARY * NVL(COMMISSION_PCT, 0))*12) AS "연봉(보너스포함)"
	 , ROUND(AVG(NVL(COMMISSION_PCT, 0)), 2) AS "보너스 평균"
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID = '80';

SELECT *
  FROM EMPLOYEES 
 WHERE DEPARTMENT_ID = 100;

SELECT MAX(FIRST_NAME) --문자열 가장 뒤에서부터
	 , MIN(LAST_NAME) --문자열 가장 앞에서부터
  FROM EMPLOYEES;
 --문자열 사전순으로도 나열이 가능하다.
 
SELECT COUNT(*) AS 행수
--테이블 조건을 만족하는 행의 개수 반환
--어떤 컬럼이 들어가도 상관없다. 대부분 *을 쓴다.
  FROM EMPLOYEES;

--그룹함수
 