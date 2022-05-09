/*
 * 위치에 따른 서브쿼리 이름
 * 
 * SELECT(Sub Query) <- Scalar Sub Query
 * FROM(Sub Query) <- Inline View
 * WHERE(Sub Query) <- Sub Query
 *
 * 괄호 밖의 쿼리 = "Main Query"
 * 괄호 안의 쿼리 = "Sub Query(Inner Query)"
 * 
 * -------------------------------------
 * SELECT select_list
 *   FROM TABLE[View]
 *  WHERE 조건연산자 (SELECT select_list
 *                  FROM TABLE
 *                 WHERE 조건);
 * -------------------------------------
 * 
 * 서브쿼리 작성시 주의사항
 * - WHERE절  연산자 오른쪽에 위치 & 반드시 괄호묶기
 * - ORDER  BY절 삽입 불가(특별한 경우 제외)
 * - 단일행인지 다중행인지에 따라 연산자 선택 주의
 * 
 * 
 * WHERE절에 오는 서브쿼리 종류
 * 
 * - 단일행 서브쿼리 (Single Row Sub Query) 서브쿼리 결과 : 1개의 행
 * 		=, <>  같다/ 같지 않다 
 * 		>, <   크다/ 작다
 * 		>=, <= 크거나 같다/ 작거나 같다
 * 
 * - 다중행 서브쿼리 (Multi Row Sub Query) 서브쿼리 결과 : 2개 이상 행
 * 		IN : 서브쿼리 결과와 같은값 있는 경우 메인쿼리 수행
 * 			 → 내부적으로 중복값 제거(DISTINCT연산)
 * 		EXISTS : 서브쿼리 값이 있을 경우 메인쿼리 수행
 * 			 	 → 하나라도 존재하면 바로 빠져나옴(세미조인)
 * 		>ANY <ALL : 서브쿼리 결과 중 최소값
 * 			 		→ but 연산자방향에 따라 다른 식이 되므로 주의!
 * 		<ANY >ALL : 서브쿼리 결과 중 최대값
 * 			 		→ but 연산자방향에 따라 다른 식이 되므로 주의!
 * 
 * - 다중컬럼 서브쿼리 (Multi Column Sub Query) 서브쿼리 결과: 여러 컬럼
 * 	 : 주로 Primary Key를 여러컬럼을 합쳐서 만든 경우 한꺼번에 비교하기 위해 사용
 * - 상호연관 서브쿼리 (Multi Column Sub Query) 
 * 	 : 메인쿼리 값을 서브쿼리에 준 후 서브쿼리 수행한 후
 *     서브쿼리 결과값을 메인쿼리로 다시 반환하여 최종 수행 → 메인쿼리와 서브쿼리가 서로 데이터를 주고 받음
 */


select  first_name, job_id, salary
from EMPLOYEES
where job_id in (select JOB_ID
				   from EMPLOYEES
				  group by job_id
				 having avg(salary) < 3000);


SELECT ROWNUM
	 , FIRST_NAME
	 , LAST_NAME
	 , SALARY
	 , COMMISSION_PCT
  FROM EMPLOYEES
 WHERE COMMISSION_PCT IS NOT NULL
   AND ROWNUM <=15
 ORDER BY SALARY;

SELECT *
  FROM (SELECT FIRST_NAME
	 		 , LAST_NAME
	 		 , SALARY
	 		 , COMMISSION_PCT
  		  FROM EMPLOYEES
 		 WHERE COMMISSION_PCT IS NOT NULL
 		 ORDER BY SALARY DESC
 		 )
  WHERE ROWNUM <= 15;
  --top-n분석 : 미리 정렬된 쿼리를 조회하는 것
 
 WITH EMP_COM -- WHITH 별칭부여, 재사용 가능
   AS (SELECT FIRST_NAME
	 		 , LAST_NAME
	 		 , SALARY
	 		 , COMMISSION_PCT
  		  FROM EMPLOYEES
 		 WHERE COMMISSION_PCT IS NOT NULL
 		 ORDER BY SALARY DESC)
 SELECT * FROM EMP_COM;


SELECT FIRST_NAME
	 , LAST_NAME
	 , SALARY
	 , RANK() OVER(ORDER BY SALARY DESC) AS 순위
  FROM EMPLOYEES;
 --중복된 값만큼 플러스되어서 랭크가 매겨진다.
 
SELECT FIRST_NAME
	 , LAST_NAME
	 , SALARY
	 , DENSE_RANK() OVER(ORDER BY SALARY DESC) AS 순위
  FROM EMPLOYEES;
 --동률의 값이 나와도 차례대로 랭크가 매겨진다.
 
 SELECT *
   FROM (SELECT FIRST_NAME
	          , LAST_NAME
	          , SALARY
	          , DENSE_RANK() OVER(ORDER BY SALARY DESC) AS 순위
 	       FROM EMPLOYEES
  	     )
 WHERE 순위 <= 5;
--랭크로 특정범위의 값을 보고싶을때는 서브쿼리를 써야한다.



--JOIN
SELECT *
  FROM EMPLOYEES, DEPARTMENTS;
--두 테이블을 합쳐 조회하기
 
SELECT *
  FROM EMPLOYEES E, DEPARTMENTS D
 WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID;
--별칭부여해서 같은 컬럼을 조회하기



--ANSI 표준 구문
 SELECT *
   FROM EMPLOYEES E
   JOIN DEPARTMENTS D
     ON E.DEPARTMENT_ID = D.DEPARTMENT_ID;
     
 SELECT *
   FROM EMPLOYEES
   JOIN DEPARTMENTS USING (DEPARTMENT_ID);
 --별칭 없어도 되는듯
 
  
  
 SELECT *
   FROM EMPLOYEES E
   LEFT JOIN DEPARTMENTS D
     ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
  WHERE E.EMPLOYEE_ID = 178;
--왼쪽 테이블에는 178번이 존재하지만 오른쪽 테이블은 존재하지 않는다
 
 SELECT *
   FROM EMPLOYEES E
  RIGHT JOIN DEPARTMENTS D
     ON E.DEPARTMENT_ID = D.DEPARTMENT_ID;
--오른쪽 기준 부서는 존재하나 왼쪽은 없어서 NULL로 채워진다.
    
 SELECT *
   FROM EMPLOYEES E
   FULL JOIN DEPARTMENTS D
     ON E.DEPARTMENT_ID = D.DEPARTMENT_ID;
--양쪽 테이블 모두 보여준다
    
SELECT *
  FROM EMPLOYEES E, DEPARTMENTS D
 WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID(+);
--참고만하기 LEFT
   
SELECT *
  FROM EMPLOYEES E, DEPARTMENTS D
 WHERE E.DEPARTMENT_ID(+) = D.DEPARTMENT_ID;
--참고만 하기 RIGHT



SELECT COUNT(*)
  FROM EMPLOYEES
 CROSS JOIN DEPARTMENTS;
--CROSS JOIN : 카데시안 곱. 한 행이 다른 행과 한번씩 모두 JOIN하는 것

SELECT X*Y AS TOTAL
  FROM (SELECT (SELECT COUNT(*) FROM EMPLOYEES) AS X
             , (SELECT COUNT(*) FROM DEPARTMENTS) AS Y
          FROM DUAL
         );

        
        
SELECT *
  FROM EMPLOYEES E
  JOIN JOBS J
    ON (E.SALARY BETWEEN J.MIN_SALARY AND J.MAX_SALARY);
-- NON_EQL JOIN : 값이 같지 않아도 일정범위에 맞게 조인시켜라

   
SELECT *
  FROM EMPLOYEES E1
  JOIN EMPLOYEES E2
    ON E1.EMPLOYEE_ID = E2.MANAGER_ID;
-- SELF JOIN

SELECT * FROM JOBS;

