--SEQUENCE : 순차적으로 정수 값을 자동으로 생성하는 객체로 자동 번호 발생기 역할을 함

DROP SEQUENCE SEQ_TEST;
CREATE SEQUENCE SEQ_TEST
		    START WITH 300
		INCREMENT BY     5
		 MAXVALUE 	   310
		 MINVALUE      290
		    CYCLE --최대값 까지 증가 완료시 CYCLE은 다시 MINVALUE로 돌아간다.
		  NOCACHE;
		 
SELECT SEQ_TEST.CURRVAL FROM DUAL;
--현재 카운트수 알아보기

SELECT SEQ_TEST.NEXTVAL FROM DUAL;
--다음 번호 매기기
--NEXTVAL 먼저 사용해야한다 무조건

SELECT NVL(NULL, '0') FROM DUAL; 

CREATE SEQUENCE SEQ_TEST NOCACHE;
--일반적으로 이정도만 쓴다.	
	 	