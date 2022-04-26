-- 문자 처리 함수

SELECT FIRST_NAME 
	 , LENGTH(FIRST_NAME) --글자수 알아보기 
	 -- 단일행 함수라서 리턴 값이 각자 나온다.
  FROM EMPLOYEES;
  
SELECT LENGTH('HELLO') AS Col1
	 , LENGTH('안녕') AS Col2
	 , LENGTHB('HELLO') Col3
	 , LENGTHB('안녕') Col4
	 --LENGTHB 바이트수 구하기
  FROM DUAL; --임시 테이블
  
SELECT INSTR('sample@example.com', '@') AS Col1
	 , INSTR('sample@example.com', '@', -1) AS Col2
	 , INSTR('sample@example.com', 'e') AS Col3 --6 앞에서 부터 검색
	 , INSTR('sample@example.com', 'e', -1) AS Col4 --14 뒤에서부터 검색
	 , INSTR('sample@example.com', 'e', 1, 2) AS Col4
	 , INSTR('sample@example.com', 'e', -1, 3) AS Col5
  FROM DUAL;
  --DB는 인덱스가 1번 부터
 
 SELECT LTRIM('-----sample@example.com    ', '-aelmnpsx') AS Col1
 	  , RTRIM('    sample@example.com    ', ' ') AS Col2
 	  , TRIM('    sample@example.com    ') AS Col3
 	  , TRIM('Z' FROM 'ZZZKHZZZ') AS "기본은 양쪽 삭제"
 	  , TRIM(LEADING '-' FROM '-----sample@example.com-----') AS Col4
 	  , TRIM(TRAILING '-' FROM '-----sample@example.com-----') AS Col5
 	  , TRIM(BOTH '-' FROM '-----sample@example.com-----') AS Col6
 	  , LTRIM('ACABACCKH', 'ABC') AS Col7
 	  , LTRIM('5782KH', '0123456789') AS Col8
 	  --LTRIM 왼쪽 기준으로 입력한 문자열 제거
 	  --RTRIM 오른쪽 기준으로 문자열 제거
 	  --TRIM 양쪽 공백 제거
   FROM DUAL;
  
 SELECT '!' || LPAD('A', 4, 's') || '!' AS Col1
 	  , '!' || LPAD('AB', 4) || '!'  AS Col2
 	  , '!' || LPAD('ABC', 4) || '!'  AS Col3
 	  , '!' || RPAD('A', 4) || '!' AS Col4
 	  , '!' || RPAD('AB', 4) || '!'  AS Col5
 	  , '!' || RPAD('ABC', 4) || '!' AS Co6
 	  , '!' || RPAD('A', 4, '0') || '!' AS Co7
 	  , '!' || RPAD('ABCDE', 4) || '!' AS C8
 	  --LPAD 왼쪽에 여백주기
 	  --RPAD 오른쪽에 여백주기
 	  --입력한 여백수 -1 만큼만 여백이 생긴다.
   FROM DUAL;
  
SELECT SUBSTR('sample@example.com', 1, 6) AS Col1
 	 , SUBSTR('sample@example.com', 8, 7) AS Col2
 	  --SUBSTR 글자 위치, 글자수만 잘라내기
 	 , SUBSTR('sample@example.com', -18, 6) AS Col3
 	 , SUBSTR('sample@example.com', -11, 7) AS Col4
 	 , SUBSTR('sample@example.com', -11) AS Col5
 	 , SUBSTR('sample@example.com', 7) AS Col6
 	 , SUBSTR('문자 처리 함수', 2, 6) AS Col7
   FROM DUAL;
  
SELECT LOWER('SAMPLE@example.com') --소문자로만
     , UPPER('sample@example.com')	--대문자로만
     , INITCAP('sample@example.com') --단어들 첫글자만 대문자로
   FROM DUAL;
 
SELECT CONCAT('sample', '@example.com') AS CoL1 --CONCAT 문자열 결합
	 , '가나다라' || 'ABCD' AS Col2
	 , CONCAT('가나다라', 'ABCD') AS Col3
   FROM DUAL;
   
 --                  원본문자열             찾을 문자열        변경할 문자열
SELECT REPLACE('sample@example.com', 'example.com', 'example.co.kr') AS Col1
   FROM DUAL;

  
 -- 숫자 처리 함수
  
SELECT ABS(10) AS Col1
 	 , ABS(-10) AS Col2 
 	 -- ABS : 절대 값 리턴
   FROM DUAL;
  
SELECT MOD(10, 3) AS Col1
 	 , MOD(-10, 3) AS Col2
 	 , MOD(10.5, 3) AS Col2
 	 , MOD(-10.5, 3) AS Col2 
 	 --MOD : 입력 받은 수를 나눈 나머지 값 반환
   FROM DUAL;
  
SELECT ROUND(10.4) AS Col1
 	 , ROUND(10.5) AS Col2
     , ROUND(10.45) AS Col3 --소수점 첫번째자리를 기준으로 하기때문에 반올림 되지 않는다.
  	 , ROUND(10.45, 1) AS Col4 --1번째 자리까지 표시하는데 그 뒤의 소수점자리를 보고 반올림해서 출력.
  	 , ROUND(10.456, 2) AS Col5
     , ROUND(1847.5, -2) AS Col6 --정수는 입력한 자리수를 보고 반올림
     , ROUND(1857.5, -2) AS Col7 --정수는 입력한 자리수를 보고 반올림
     -- ROUND : 특정 자릿수에서 반올림
   FROM DUAL;
  
SELECT FLOOR(10.34) AS Col1	--내림
     , CEIL(10.34) AS Col2	--올림
     , FLOOR(-10.34) AS Col3	--음수 내림은 0에서 멀어진다.
     , CEIL(-10.34) AS Col4	--음수 올림은 0에 가까워진다.
     -- FLOOR : 버림(소수점 아래를 잘라냄)
     -- CEIL : 올림(소수점 아래에서 올림)
   FROM DUAL;
  
SELECT TRUNC(10.34) AS Col1	--절사
 	 , TRUNC(10.34, 1) AS Col2
 	 , TRUNC(10.3456, 1) AS Col3
 	 , TRUNC(10.3456, 2) AS Col4
 	 , TRUNC(1234, -1) AS Col5 --정수는 음수로 절삭가능하다.
 	 , TRUNC(1234, -2) AS Col6
 	 , TRUNC(1234, -3) AS Col7
 	 , TRUNC(1234, -4) AS Col8
 	 , TRUNC(1234.5678, -1) AS Col9
 	  -- TRUNC : 특정 자릿수에서 잘라냄
   FROM DUAL;

 
--날짜 처리 함수
  
SELECT SYSDATE --시스템 날짜 함수
  FROM DUAL;
 
SELECT SYSDATE AS Col1
 	 , ADD_MONTHS(SYSDATE, 2) AS Col2 --개월수 더하기, 빼기
 	 , ADD_MONTHS(SYSDATE, -2) AS Col3
 	 , LAST_DAY(SYSDATE) AS Col4 --마지막 날짜 알아보기
 	 , NEXT_DAY(SYSDATE, 6) AS Col5 --금요일이 언제인지 묻는 것
 	  --1:일요일, 2:월요일, 3:화요일,... 6:금요일, 7:토요일
 	 , NEXT_DAY(SYSDATE, '금') AS CoL6
  FROM DUAL;
 
SELECT MONTHS_BETWEEN(SYSDATE, ADD_MONTHS(SYSDATE, 2)) AS Col1
 	 , MONTHS_BETWEEN(ADD_MONTHS(SYSDATE, 2), SYSDATE) AS Col2
 	  --몇개월 차이가 있는지. 왼쪽 날짜와 오른쪽 날짜의 차이를 구하라. 두달의 차이가 있다
  FROM DUAL;
 
SELECT EXTRACT(YEAR FROM SYSDATE) AS Col1 --연도 추출
	 , EXTRACT(MONTH FROM SYSDATE) AS Col2 --월 추출
	 , EXTRACT(DAY FROM SYSDATE) AS Col3 --일수 추출
	 , EXTRACT(HOUR FROM SYSTIMESTAMP) AS Col4 --시간 추출
	 , EXTRACT(MINUTE FROM SYSTIMESTAMP) AS Col5 --분 추출
	 , EXTRACT(SECOND FROM SYSTIMESTAMP) AS Col6 --초 추출
  FROM DUAL;
 
SELECT SYSDATE + 1 AS Col1 --날짜 가감하기
	 , SYSDATE + 2 AS Col2
 	 , SYSDATE - 2 AS Col3
	 , SYSDATE - 1 AS Col4
	 , SYSDATE + INTERVAL '1' DAY  AS Col5 --날짜 가감하기
	 , SYSDATE + INTERVAL '2' DAY AS Col6
	 , SYSDATE - INTERVAL '1' DAY  AS Col7
	 , SYSDATE - INTERVAL '2' DAY AS Col8
	 , SYSDATE + INTERVAL '1' MONTH AS Col9
	 , SYSDATE + INTERVAL '1' HOUR AS Col11
	 , SYSDATE + INTERVAL '1' MINUTE AS Col2
	 , SYSDATE + INTERVAL '1' SECOND AS Col3
	 , SYSDATE + INTERVAL '3' YEAR AS Col4
  FROM DUAL;
 
 SELECT SYSTIMESTAMP  AS Col1
     , SYSTIMESTAMP + INTERVAL '3' DAY AS Col2
     , SYSTIMESTAMP + INTERVAL '3' MONTH AS Col3
     , SYSTIMESTAMP + INTERVAL '3' YEAR AS Col4
     , SYSTIMESTAMP + INTERVAL '30' SECOND AS Col5
     , SYSTIMESTAMP + INTERVAL '30' MINUTE AS Col6
     , SYSTIMESTAMP + INTERVAL '3' HOUR AS Col7
     , SYSTIMESTAMP - INTERVAL '30' SECOND AS Col8
     , SYSTIMESTAMP - INTERVAL '30' MINUTE AS Col9
     , SYSTIMESTAMP - INTERVAL '3' HOUR AS Col10
  FROM DUAL;
 
 
 --형 변환 함수
 
 --TO_CHAT : 날짜 혹은 숫자형 데이터를 문자형 데이터로 변환하여 반환
 SELECT 1234
 	  , TO_CHAR(1234) AS Col2 --숫자 타입을 문자 타입으로 변환
 	  -- , '' AS Col3
 	  , TO_CHAR(1000000, 'L999,999,999') AS Col3 --숫자 단위 설정, L은 통화 단위이다.
 	  , TO_CHAR(1000000, '000,000,000') AS Col4 --앞에를 0으로 채우고 싶을 때
 	  , TO_CHAR(SYSDATE) AS Col5	--날짜 타입을 문자 타입으로 변환
 	  , TO_CHAR(SYSDATE, 'YYYYMMDD') AS Col6
 	  , TO_CHAR(SYSDATE, 'YYYY/MM/DD') AS Col7
 	  , TO_CHAR(SYSDATE, 'YYYY-MM-DD') AS Col8
 	  , TO_CHAR(SYSDATE, 'YYYY.MM.DD.') AS Col9
 	  , TO_CHAR(SYSDATE, 'YYYY"년" MM"월" DD"일"') AS Col10
 	  , TO_CHAR(SYSDATE, 'YYYY-MM-DD AM HH:MI:SS') AS Col11
      , TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') AS Col12
      , TO_CHAR(SYSTIMESTAMP, 'YYYY-MM-DD AM HH:MI:SS.FF3') AS Col13
   FROM DUAL;
   
  
 --TO_DATE : 숫자 혹은 문자형 데이터를 날짜형 데이터로 변환하여 반환
 SELECT TO_DATE(20220425) AS Col1 --숫자 타입을 날짜 타입으로 변환
 	  , TO_DATE('20220425') AS Col2 --문자열 타입을 날짜타입으로 변환
 	  , TO_DATE('2022/04/25') AS Col3 --문자열 타입을 날짜타입으로 변환
 	  , TO_DATE('2022-04-25') AS Col4 --문자열 타입을 날짜타입으로 변환
 	  , TO_DATE('2022.04.25') AS Col5 --문자열 타입을 날짜타입으로 변환
 	  , TO_DATE('2022년 04월 25일', 'YYYY"년" MM"월" DD"일"') AS Col6 --문자열 타입을 날짜타입으로 변환
   FROM DUAL;
  
 --TO_NUMBER : 날짜 혹은 문자형 데이터를 숫자형 데이터로 변환하여 반환
SELECT TO_NUMBER('12345') AS Col1 --문자열을 숫자 타입으로 변환
	 , TO_NUMBER('123.45') AS Col2
	 , TO_NUMBER('123,456', '999,999') AS Col3 --'999,999' 숫자 형식 설정 / 타입이 문자열이 아니라서 ,(콤마)가 안보인다.
	 , TO_NUMBER('ABCD', 'XXXX') AS Col4 --16진수 -> 10진수로 변환
	 , TO_NUMBER('FF', 'XX') AS Col5 --16진수 -> 10진수로 변환
  FROM DUAL;
 
SELECT TO_NUMBER(TO_CHAR(SYSDATE, 'YYYYMMDD')) AS Col1 --날짜를 숫자로 변환
	 , TO_NUMBER(TO_CHAR(SYSDATE, 'YYYY')) AS Col2
	 , TO_NUMBER(TO_CHAR(SYSDATE, 'MMDD')) AS Col3
	 , TO_NUMBER(TO_CHAR(SYSDATE, 'MM')) AS Col4
	 , TO_NUMBER(TO_CHAR(SYSDATE, 'DD')) AS Col5
	--쉼표가 보이지만 원래 없는 것이므로 주의!
  FROM DUAL;
