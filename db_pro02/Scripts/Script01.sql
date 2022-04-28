/*
 * DDL
 *  - Data Definition Language : 데이터 정의어
 * 	- 객체를 정의하기 위한 CREAT(생성), ALTER(수정), DROP(제거) 구문이 있다.
 *  - 오라클에서 사용하는 객체는 TABLE, VIEW, SEQUENCE, INDEX, FUNCTION, PROCEDUAL, USER, ...등이 있다.
 */

/*CREATE TABLE 테이블명 (
*	     컬럼명 데이터타입(크기) [CONSTRAINT(=제약조건)]
*	   , ... 
*/

CREATE TABLE sample_tb ( --외래키 테이블, 참조 테이블
       u_id NUMBER       --CONSTRAINT PK_SAMPLE_TB_U_ID PRIMARY KEY
     , jumin CHAR(13)    -- UNIQUE
     , name VARCHAR2(50) NOT NULL -- 컬럼 레벨로만 작성 가능
     , age NUMBER(3)     DEFAULT(0)
     , gender CHAR(1)    CHECK(GENDER IN ('M', 'F'))
     , birth_day DATE    DEFAULT(SYSDATE)
     , ref_col NUMBER    --CONSTRAINT FK_SAMPLE_TB_REF_COL REFERENCES ref_t(r_id)
     , CONSTRAINT PK_SAMPLE_TB_U_ID PRIMARY KEY(u_id)
     , CONSTRAINT UK_SAMPLE_TB_JUMIN UNIQUE(jumin)
     , CONSTRAINT FK_SAMPLE_TB_REF_COL FOREIGN KEY(ref_col) REFERENCES ref_tb(r_id)
	 --테이블 레벨로 설정시 소괄호로 (열 이름)을 꼭 지정해줘야한다.
	 --CONSTRAINT 제약조건명 제약조건(열 이름)
);
--	 , ref_col NUMBER	 REFERENCES 참조테이블(참조컬럼)
CREATE TABLE ref_tb ( --기준 테이블
       r_id NUMBER   PRIMARY KEY
     , note VARCHAR2(100)
);


ALTER TABLE sample_tb ADD (nickname VARCHAR2(100)); --칼럼 추가
--ALTER TABLE sample_tb ADD nickname VARCHAR2(100);
--모두 괄호 없어도 상관 없음
ALTER TABLE sample_tb MODIFY (nickname VARCHAR2(200)); --칼럼 데이터 크기 수정
--타입에 대한 크기를 줄이거나 늘리는건 상관 없으나 데이터 타입은 바꾸지 말것
ALTER TABLE sample_tb RENAME COLUMN nickname TO n_name; 
--컬럼 이름 바꾸기 / 왠만하면 쓰지 말것 SQL 명령문에서 사용하고있을때 에러날수있음
ALTER TABLE sample_tb DROP COLUMN n_name;
--컬럼 삭제 / 왠만하면 쓰지 말것 SQL 명령문에서 사용하고있을때 에러날수있음
ALTER TABLE sample_tb RENAME TO sam_t;
--테이블 이름 바꾸기 /  왠만하면 쓰지 말것 SQL 명령문에서 사용하고있을때 에러날수있음


--ALTER TABLE ref_tb ADD UNIQUE(note);
ALTER TABLE ref_tb ADD CONSTRAINT UK_REF_TB UNIQUE(note);
--제약조건 추가
ALTER TABLE ref_tb RENAME CONSTRAINT UK_REF_TB TO UK_REF_TB_NOTE;
--제약조건 이름 수정

ALTER TABLE ref_tb MODIFY note VARCHAR2(100) NOT NULL; --NOT NULL 제약으로 수정하여 제약조건 추가.
ALTER TABLE ref_tb MODIFY note VARCHAR2(100) NULL; --NULL 로 수정으로 제약조건 제거.
--수정이지만 NOT NULL은 새로 추가되어서 나온다. (NOT NULL은 ADD, DROP 불가능)
--여기서 데이터 크기도 수정가능하다.

ALTER TABLE ref_tb MODIFY note CONSTRAINT CK_NOTE CHECK(note IN ('h', 'k'));
ALTER TABLE ref_tb DROP CONSTRAINT CK_NOTE; --CHECK,NULL 삭제가능
--컬럼 레벨로만 제약 조건을 추가하는 NOT NULL, CHECK는 modify 로 추가/삭제
--테이블 레벨로 제약 조건을 추가할 수 있는 PRIMARY KEY, UNIQUE, FOREIGN KEY는 add, drop 을 사용


ALTER TABLE ref_tb DROP CONSTRAINT UK_REF_TB_NOTE DROP CONSTRAINT SYS_C007534;
ALTER TABLE ref_tb DROP CONSTRAINT SYS_C007536;
ALTER TABLE ref_tb ADD PRIMARY KEY(r_id, note);
--제약 조건을 수정하기 위해서 기존 제약조건을 삭제 후 추가


--[2273] [42000] ORA-02273: 고유/기본 키가 외부 키에 의해 참조되었습니다 경우 아래 행 실행
--ORA-02273: 키를 삭제하기 전에 키에 대한 모든 참조를 제거하십시오.
ALTER TABLE ref_tb DROP primary key cascade;


--DROP TABLE 테이블명 CASCADE CONSTRAINTS; --외래키 제약 조건이 있어도 삭제

DROP TABLE SAMPLE_TB; --지울 때 외래 키 테이블 먼저 지운다.
DROP TABLE REF_TB;


COMMENT ON COLUMN sample_tb.u_id IS '사용자 구분 아이디';
COMMENT ON COLUMN sample_tb.name IS '사용자 이름';
COMMENT ON COLUMN sample_tb.age IS '사용자 나이';
COMMENT ON COLUMN sample_tb.gender IS '사용자 성별(M:남자, F:여자)';
COMMENT ON COLUMN sample_tb.birth_day IS '사용자 생년월일';
--코멘트 각자 실행 후 확인해야함
SELECT * FROM USER_COL_COMMENTS WHERE TABLE_NAME = 'SAMPLE_TB'; --코멘트 확인

SELECT * FROM SAMPLE_TB;
SELECT * FRom sample_tb;
select * from Sample_tb;
SELECT * FROM USER_ALL_TABLES WHERE TABLE_NAME = 'SAMPLE_TB'; --테이블 확인
--USER_ALL_TABLESD에 sample_tb 테이블이 기록이 된다 (대문자로 기록된다)
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'SAMPLE_TB'; --컬럼의 테이블 확인
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'REF_TB'; --컬럼의 테이블 확인
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'REF_TB'; --제약조건 확인

 