/*
 * 지출내역서(가계부)를 위한 테이블을 만들어 본다.
 *     - 날짜, 입금액, 출금액, 비고 를 저장할 수 있는 컬럼 필요하다.
 *     - 비고의 경우 한글 150자 까지 저장 가능해야 한다.
 */

CREATE TABLE 지출내역서 (
       날짜 DATE
     , 입금액 NUMBER
     , 출금액 NUMBER
     , 비고 VARCHAR2(450)
);

/*
 * 위에서 만든 지출내역서에 다음의 컬럼 정보를 추가 및 수정 한다.
 *     - 행 데이터를 식별하기 위한 식별자용 컬럼을 추가 이 컬럼 이름은 ACCOUNT_ID 로 한다.
 *     - 비고의 데이터 저장 크기를 기존보다 2배 늘린다.
 *     - 지출내역 항목을 구분하기 위한 ACCOUNT_TYPE 컬럼을 추가하고
 *       해당 컬럼은 FK 로 만든다.
 *     - ACCOUNT_TYPE 컬럼이 참조하는 테이블은 "지출내역구분" 이라는 테이블로 만들어 둔다.
 *     - 지출내역구분 테이블에는 식별자용 컬럼, 구분명 컬럼이 있어야 한다.
 */

ALTER TABLE 지출내역서 ADD ACCOUNT_ID NUMBER CONSTRAINT PK_지출내역서_ACCOUNT_ID PRIMARY KEY;
ALTER TABLE 지출내역서 MODIFY 비고 VARCHAR2(900);

CREATE TABLE 지출내역구분 (
       구분ID NUMBER CONSTRAINT PK_지출내역구분_구분ID PRIMARY KEY
     , 구분명 VARCHAR2(100)
);

ALTER TABLE 지출내역서 ADD ACCOUNT_TYPE NUMBER CONSTRAINT FK_지출내역서_ACCOUNT_TYPE REFERENCES 지출내역구분(구분ID);


SELECT * FROM USER_ALL_TABLES;
SELECT * FROM 지출내역구분;
SELECT * FROM 지출내역서;
SELECT * FROM USER_ALL_TABLES WHERE TABLE_NAME LIKE '지출내역%';
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME LIKE '지출내역%';
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME LIKE '지출내역%';

SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = '지출내역구분';
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME  = '지출내역구분';


INSERT INTO 지출내역구분 VALUES(1, '은행예금');
INSERT INTO 지출내역구분 VALUES(2, '은행적금');
INSERT INTO 지출내역구분(구분ID, 구분명) VALUES(3, '교통비');
INSERT INTO 지출내역구분(구분명, 구분ID) VALUES('통신비', 4);

COMMIT;

UPDATE 지출내역구분
   SET 구분명 = '교통비'
 WHERE 구분ID = '1';

UPDATE 지출내역구분
   SET 구분명 = '식대'
 WHERE 구분ID = '2';

UPDATE 지출내역구분
   SET 구분명 = '수도세'
 WHERE 구분ID = '3';

UPDATE 지출내역구분
   SET 구분명 = '전기세'
 WHERE 구분ID = '4';

INSERT INTO 지출내역서(날짜, 입금액, 출금액, 비고, ACCOUNT_ID, ACCOUNT_TYPE)
	   VALUES (SYSDATE, 50000, 10000, '택시', 1, 1 );

INSERT INTO 지출내역서
	   VALUES (SYSDATE, 0, 15000, '외식', 2, 2 );
  
INSERT INTO 지출내역서 
	   VALUES(SYSDATE, 0, 8000, '수도세', 3, 3 );
	   
INSERT INTO 지출내역서(출금액, 비고, ACCOUNT_ID, ACCOUNT_TYPE)
	   VALUES (30000, '전기세', 4, 4 );
	  
UPDATE 지출내역서
   SET 입금액 = 0
 WHERE ACCOUNT_ID = 1;

UPDATE 지출내역서
   SET ACCOUNT_ID = 5
 WHERE ACCOUNT_ID = 4;

INSERT INTO 지출내역구분 VALUES (5,'용돈');
 
INSERT INTO 지출내역서
	   VALUES (SYSDATE, 200000, 0, '용돈', 5, 5);

INSERT INTO 지출내역서
	   VALUES (SYSDATE, 0, 13000, '배달음식', 6, 2);
	  
INSERT INTO 지출내역서
	   VALUES (SYSDATE, 150000, 0, '용돈', 7, 5);
	  
INSERT INTO 지출내역서
	   VALUES (SYSDATE, 0, 35000, '택시', 8, 1);
	  
COMMIT;

SELECT * FROM 지출내역서;

UPDATE 지출내역서
   SET 날짜 = '2021-03-01'
 WHERE ACCOUNT_ID = 2;
 
UPDATE 지출내역서
   SET 날짜 = '2022-04-30'
 WHERE ACCOUNT_ID = 8;
 
COMMIT;
  
UPDATE 지출내역서
   SET 출금액 = 출금액 * 1.1;

