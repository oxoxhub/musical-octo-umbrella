SELECT 'Hello Oracle Docker' FROM DUAL;

/*
 * admin, system 은 관리자 계정이다.
 * 
 * 개발자용 사용자 계정으로 데이터베이스를 사용할 수 있도록
 * 별도의 계정을 생성.
 */
-- 계정과 패스워드 생성하는 방법
CREATE USER puser1 IDENTIFIED BY  puser1;

-- 생성한 계정에 권한 부여
GRANT RESOURCE, CONNECT TO puser1;
GRANT INSERT ANY TABLE, UPDATE ANY TABLE
	, DELETE ANY TABLE, CREATE VIEW
	, CREATE SESSION TO puser1;
	
-- 테이블 스페이스 사용 권한 및 용량 설정
ALTER USER puser1 quota 10M ON USERS;

-- 계정 목록 확인
SELECT USERNAME FROM ALL_USERS WHERE USERNAME = 'PUSER1';

-- 계정에 부여한 롤(Role) 확인 (관리자 계정으로 확인 바람)
SELECT GRANTED_ROLE FROM DBA_ROLE_PRIVS WHERE GRANTEE = 'PUSER1';

-- 계정에 부여한 권한 확인 (관리자 계정으로 확인 바람)
SELECT PRIVILEGE FROM DBA_SYS_PRIVS WHERE GRANTEE = 'PUSER1';
