숙제
숙제
숙제
숙제
숙제
숙제
숙제
숙제
숙제

SELECT EMP_ID, EMP_NAME, SALARY, DEPT_CODE FROM EMPLOYEE; 

SELECT * FROM EMPLOYEE ;

SELECT EMP_ID, EMP_NAME, SALARY, JOB_NAME 
FROM EMPLOYEE 
JOIN JOB USING(JOB_CODE) 
WHERE SALARY > 7000000
ORDER BY SALARY DESC;


SELECT EMP_ID , EMP_NAME , SALARY 
FROM EMPLOYEE 
WHERE SALARY BETWEEN 2000000 AND 7000000
ORDER BY SALARY DESC;


SELECT DEPT_TITLE 
FROM DEPARTMENT ;

SELECT EMP_ID , EMP_NAME , DEPT_TITLE , JOB_NAME 
FROM EMPLOYEE 
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE)
WHERE DEPT_TITLE = '총무부'
ORDER BY JOB_CODE;

SELECT COUNT(*)
FROM DEPARTMENT 
WHERE DEPT_TITLE = 'input';

SELECT * 
FROM EMPLOYEE 
WHERE EMP_ID = 201;

SELECT * 
FROM EMPLOYEE2 
WHERE SALARY >= 5000000;

VALUES(empId, empName, empNo, email, phone, deptCode, jobCode );

INSERT INTO EMPLOYEE2
VALUES(999, '홍길동', '881126-1234567', 'hong_gd@kh.or.kr', '01012341234',
		'D1', 'J4', 'S1', 5000000, 0.3,201, SYSDATE, NULL, 'N');
		
COMMIT;
ROLLBACK;

DELETE FROM EMPLOYEE2 WHERE EMP_ID = 888;	

UPDATE EMPLOYEE2 
SET EMAIL = email , PHONE = phone , SALARY = salary 
WHERE EMP_ID = inputId;
	