DECLARE
	TYPE MY_TYPE_RECORD IS RECORD (
		ID	EMPLOYEES.EMPLOYEE_ID%TYPE
	  , FNAME EMPLOYEES.FIRST_NAME%TYPE
	  , LNAME EMPLOYEES.LAST_NAME%TYPE
	  , SALARY EMPLOYEES.SALARY%TYPE
	);

	RECORD_DATA 	MY_TYPE_RECORD;
BEGIN
	SELECT EMPLOYEE_ID
		 , FIRST_NAME
		 , LAST_NAME
		 , SALARY
	  INTO RECORD_DATA
	  FROM EMPLOYEES
	 WHERE EMPLOYEE_ID = 100;
	
	DBMS_OUTPUT.PUT_LINE(RECORD_DATA.ID);
	DBMS_OUTPUT.PUT_LINE(RECORD_DATA.FNAME);
	DBMS_OUTPUT.PUT_LINE(RECORD_DATA.LNAME);
	DBMS_OUTPUT.PUT_LINE(RECORD_DATA.SALARY);
END;



DECLARE
	TYPE MY_TYPE_RECORD IS RECORD (
		ID	EMPLOYEES.EMPLOYEE_ID%TYPE
	  , FNAME EMPLOYEES.FIRST_NAME%TYPE
	  , LNAME EMPLOYEES.LAST_NAME%TYPE
	  , SALARY EMPLOYEES.SALARY%TYPE
	  , DEPT_NAME DEPARTMENTS.DEPARTMENT_NAME%TYPE
	);

	RECORD_DATA 	MY_TYPE_RECORD;
BEGIN
	SELECT E.EMPLOYEE_ID
		 , E.FIRST_NAME
		 , E.LAST_NAME
		 , E.SALARY
		 , D.DEPARTMENT_NAME
	  INTO RECORD_DATA
	  FROM EMPLOYEES E JOIN DEPARTMENTS D 
	    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
	 WHERE EMPLOYEE_ID = 100;
	
	DBMS_OUTPUT.PUT_LINE(RECORD_DATA.ID);
	DBMS_OUTPUT.PUT_LINE(RECORD_DATA.FNAME);
	DBMS_OUTPUT.PUT_LINE(RECORD_DATA.LNAME);
	DBMS_OUTPUT.PUT_LINE(RECORD_DATA.SALARY);
    DBMS_OUTPUT.PUT_LINE(RECORD_DATA.DEPT_NAME);
END;




DECLARE
	TYPE MY_TYPE_TABLE IS TABLE OF EMPLOYEES.EMPLOYEE_ID%TYPE INDEX BY BINARY_INTEGER;

	TABLE_DATA 	MY_TYPE_TABLE;
	IDX		NUMBER := 1;
BEGIN
	FOR D IN (SELECT EMPLOYEE_ID FROM EMPLOYEES) LOOP
		TABLE_DATA(IDX) := D.EMPLOYEE_ID;
		IDX := IDX + 1;
	END LOOP;

	FOR I IN 1..TABLE_DATA.COUNT LOOP
		DBMS_OUTPUT.PUT_LINE(TABLE_DATA(I));
	END LOOP;
END;






DECLARE
	TYPE MY_TYPE_TABLE IS TABLE OF EMPLOYEES.MANAGER_ID%TYPE INDEX BY BINARY_INTEGER;

	TABLE_DATA 	MY_TYPE_TABLE;
	IDX		NUMBER := 1;
BEGIN
	FOR D IN (SELECT MANAGER_ID FROM EMPLOYEES) LOOP
		TABLE_DATA(IDX) := D.MANAGER_ID;
		IDX := IDX + 1;
	END LOOP;

	FOR I IN 2..10 LOOP
		DBMS_OUTPUT.PUT_LINE(TABLE_DATA(I));
	END LOOP;
END;


SELECT MANAGER_ID FROM EMPLOYEES;




DECLARE
	TYPE MY_TYPE_TABLE IS TABLE OF EMPLOYEES%ROWTYPE INDEX BY BINARY_INTEGER;

	TABLE_DATA 	MY_TYPE_TABLE;
	IDX		NUMBER := 1;
BEGIN
	FOR D IN (SELECT * FROM EMPLOYEES) LOOP
		TABLE_DATA(IDX) := D;
		IDX := IDX + 1;
	END LOOP;

	FOR I IN 1..TABLE_DATA.COUNT LOOP
		DBMS_OUTPUT.PUT_LINE(TABLE_DATA(I).EMPLOYEE_ID);
	END LOOP;
END;




DECLARE
    TYPE MY_TYPE_RECORD IS RECORD (
         ID        EMPLOYEES.EMPLOYEE_ID%TYPE
       , FNAME     EMPLOYEES.FIRST_NAME%TYPE
       , LNAME     EMPLOYEES.LAST_NAME%TYPE
       , SALARY    EMPLOYEES.SALARY%TYPE
       , DEPT_NAME DEPARTMENTS.DEPARTMENT_NAME%TYPE
    );
    TYPE MY_TYPE_TABLE IS TABLE OF MY_TYPE_RECORD INDEX BY BINARY_INTEGER;
    
    TABLE_DATA    MY_TYPE_TABLE;
    IDX    NUMBER := 1;
BEGIN
    FOR D IN (SELECT E.EMPLOYEE_ID
                   , E.FIRST_NAME
                   , E.LAST_NAME
                   , E.SALARY
                   , D.DEPARTMENT_NAME
                FROM EMPLOYEES E JOIN DEPARTMENTS D
                  ON E.DEPARTMENT_ID = D.DEPARTMENT_ID) LOOP
    	TABLE_DATA(IDX) := D;
        IDX := IDX + 1;
    END LOOP;
	
    IDX := TABLE_DATA.FIRST;
    WHILE (IDX IS NOT NULL) LOOP
        DBMS_OUTPUT.PUT_LINE(TABLE_DATA(IDX).ID || '/' || TABLE_DATA(IDX).FNAME);
        IDX := TABLE_DATA.NEXT(IDX);
    END LOOP;
    
    /*
    FOR I IN 1..TABLE_DATA.COUNT LOOP
       DBMS_OUTPUT.PUT_LINE(TABLE_DATA(I).ID);
    END LOOP;
    */
END;


	
