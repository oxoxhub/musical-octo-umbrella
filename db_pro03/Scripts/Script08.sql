--함수 FUNCTION
CREATE OR REPLACE FUNCTION FUNC_TEST1(v1 NUMBER) RETURN NUMBER
IS
BEGIN
    RETURN v1 + 10;
END;

SELECT FUNC_TEST1(5) FROM DUAL;

CREATE OR REPLACE FUNCTION FUNC_TEST2(v1 VARCHAR2) RETURN VARCHAR2
IS
BEGIN
    RETURN v1 || ' Done!!';
END;

SELECT FUNC_TEST2('Hello') FROM DUAL;


CREATE OR REPLACE FUNCTION FUNC_TEST3(v1 NUMBER, v2 NUMBER) RETURN VARCHAR2
IS
    var VARCHAR2(10) := ' Done!!';
BEGIN
	-- PL/SQL 을 활용하여 로직 작성
    RETURN v1 + v2 || var;
END;

SELECT FUNC_TEST3(10, 20) FROM DUAL;