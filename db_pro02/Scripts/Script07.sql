DROP TABLE SAMPLE_T;

CREATE TABLE SAMPLE_T(
	   ID NUMBER PRIMARY KEY
	 , NAME VARCHAR(30) NOT NULL
	 , GENDER CHAR(1) CHECK(GENDER IN('F','M'))
	 , AGE NUMBER DEFAULT(0) NOT NULL
);

INSERT INTO SAMPLE_T VALUES(1,'홍길동','M',32);
INSERT INTO SAMPLE_T VALUES(2,'김수정','F',28);
INSERT INTO SAMPLE_T VALUES(3,'박정길','M',30);

SELECT * FROM SAMPLE_T;

CREATE OR REPLACE VIEW V_SAMPLE_T
	AS SELECT ID
			, NAME
			, GENDER
			, AGE
	     FROM SAMPLE_T
	    WHERE AGE BETWEEN 30 AND 35
WITH CHECK OPTION;
--CREATE OR REPLACE VIEW : 새로 만들거나 중복시 대체하기
--AGE +1 AS AGE <- 가상열(산술표현식)
--WITH READ ONLY; 읽기만 가능.
	    
SELECT * FROM V_SAMPLE_T;

SELECT * FROM USER_VIEWS;
--텍스트 내용이 바뀌는 것 확인해보기

INSERT INTO V_SAMPLE_T VALUES(4,'이기석','M', 31);
--제약조건에 맞춰서 데이터를 삽입 할 수 있다.
--뷰의 WITH CHECK OPTION의 조건에 위배될 경우 업데이트 불가능

UPDATE V_SAMPLE_T
   SET AGE = AGE + 10;
--업데이트시 원본 테이블의 데이터 수정이 된다. (물론 VIEW도 수정된다.)
--뷰에 산술 계산식이 포함된 경우 INSERT/UPDATE 시 에러 발생. 단 DELETE는 가능
--뷰의 WITH CHECK OPTION의 조건에 위배될 경우 업데이트 불가능 
  
DELETE FROM V_SAMPLE_T;
--삭제할때 WITH CHECK OPTION이 있다면 성립되는 조건만 삭제가 되고 나머지는 원본 테이블에 살아있다.

