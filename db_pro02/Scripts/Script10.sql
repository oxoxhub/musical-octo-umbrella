
/*SYNONYM : 사용자가 다른 사용자의 객체를 참조할 때 [사용자ID].[테이블명]으로
		  표시하는데 이처럼 길게 표현되는 것을 동의어(SYNONYM)로 설정 후
		  간단히 사용 가능한 객체
*/

GRANT CREATE SYNONYM TO PUSER1;
GRANT CREATE SYNONYM TO DEVADMIN;
--(SYSTEM 계정으로) 사전 작업으로 PUSER1, DEVADMIN 계정에 동의어(SYNONYM) 생성 할 수 있는 권한 부여

CREATE SYNONYM EMP1 FOR EMPLOYEES; 
--비공개 동의어(PUSER1에서 만듦.) : 객체에 대한 접근 권한을 부여 받은 사용자가 정의한 동의어로, 만든 사용자만 사용가능(기본값)
--create synonym 동의어이름 for 객체A : 기본적으로 생성되는 것은 특정 사용자가 소유한 전용 동의어입니다. 
--create or replace synonym 동의어이름 for 객체A :동의어를 새로 생성하거나, 같은 이름의 동의어를 대체(갱신) 하는 경우

CREATE PUBLIC SYNONYM EMP2 FOR PUSER1.EMPLOYEES;
--공개 동의어(관리자 계정에서만 사용 가능) : 권한을 주는 사용자(DBA)가 정의한 동의어로 모든 사용자가 사용 가능(PUBLIC)
--create public synonym 동의어이름 for 객체A :공용 동의어는 모든 사용자가 사용할 수 있는 동의어입니다.
-- * 단, PUBLIC SYNONYM을 생성하려면 이에 걸맞는 권한이 GRANT 명령어로 부여된 상태여야 합니다.

GRANT SELECT ON EMPLOYEES TO DEVADMIN;
--비공개/공개 동의어를 다른 계정에서 사용하기 위해 최소한 SELECT 권한은 필요하다.

SELECT  * FROM PUSER1.EMP1;
--PUSER1이 생성한 비공개 동의어를 DEVADMIN이 접근하여 사용.

SELECT * FROM EMP2;
--관리자가 생성한 공개 동의어를 DEVADMIN이 접근하여 사용.



SELECT * FROM ALL_SYNONYMS WHERE SYNONYM_NAME = 'ALL_SYNONYMS';

DROP SYNONYM EMP;


