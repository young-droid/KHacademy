SELECT * FROM TB_STUDENT ;

-- 1. 
SELECT STUDENT_NO 학번, STUDENT_NAME 이름, ENTRANCE_DATE 입학년도
FROM TB_STUDENT 
WHERE DEPARTMENT_NO = 002
ORDER BY ENTRANCE_DATE DESC;

-- 2. 
SELECT PROFESSOR_NAME , PROFESSOR_SSN 
FROM TB_PROFESSOR 
WHERE LENGTH (PROFESSOR_NAME) != 3;

-- 3. -- 생일에 따른 만나이 고려? 
SELECT PROFESSOR_NAME 교수이름, FLOOR((SYSDATE - TO_DATE('19'||SUBSTR(PROFESSOR_SSN,1,6),'YYYYMMDD'))/365) "나이" 
--SELECT PROFESSOR_NAME 교수이름, MONTHS_BETWEEN(SYSDATE,SUBSTR(PROFESSOR_SSN,1,6)) "나이" 
FROM TB_PROFESSOR 
WHERE SUBSTR(PROFESSOR_SSN,8,1) = 1
ORDER BY "나이"
; 

-- 4. 
SELECT SUBSTR(PROFESSOR_NAME , 2 ) 
FROM TB_PROFESSOR ;

-- 5. 
--SELECT ENTRANCE_DATE , EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM ENTRANCE_DATE) "몇년 전 입학" ,
--	EXTRACT(YEAR FROM ENTRANCE_DATE ) - (SUBSTR(STUDENT_SSN,1,2)+1900) "몇살이었나"
SELECT STUDENT_NO , STUDENT_NAME, EXTRACT(YEAR FROM ENTRANCE_DATE ) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(STUDENT_SSN,1,6),'RRMMDD'))
FROM TB_STUDENT 
WHERE EXTRACT(YEAR FROM ENTRANCE_DATE ) - 
	EXTRACT(YEAR FROM TO_DATE(SUBSTR(STUDENT_SSN,1,6),'RRMMDD')) != 19;
--	(SUBSTR(STUDENT_SSN,1,2)+1900) > 19;


-- 6. 
SELECT TO_CHAR(TO_DATE('2020-12-25'),'YYYY-MM-DD "은 " DAY')
FROM DUAL;

-- 7. 
SELECT TO_DATE('99/10/11','YY/MM/DD') , TO_DATE('49/10/11','YY/MM/DD') , TO_DATE('99/10/11','RR/MM/DD'), TO_DATE('49/10/11','RR/MM/DD')
FROM DUAL;

-- 8. 
SELECT STUDENT_NO , STUDENT_NAME 
FROM TB_STUDENT 
--WHERE SUBSTR(STUDENT_NO,1,1) != 'A';
WHERE STUDENT_NO NOT LIKE 'A%';

-- 9. 
SELECT ROUND(AVG(POINT),1) 평점
FROM TB_GRADE 
WHERE STUDENT_NO = 'A517178';

-- 10.
SELECT DEPARTMENT_NO 학과번호, COUNT(*) "학생수(명)"
FROM TB_STUDENT 
GROUP BY DEPARTMENT_NO 
ORDER BY DEPARTMENT_NO ; 

-- 11.
SELECT COUNT(*)
FROM TB_STUDENT 
WHERE COACH_PROFESSOR_NO IS NULL;

-- 12.
SELECT SUBSTR(TERM_NO,1,4) "년도", ROUND(AVG(POINT),1) "년도 별 평점" 
FROM TB_GRADE 
WHERE STUDENT_NO = 'A112113'
GROUP BY SUBSTR(TERM_NO,1,4)
ORDER BY SUBSTR(TERM_NO,1,4);

-- 13. -- 수정 필요 - COUNT에 0 이 없음
SELECT DEPARTMENT_NO , SUM(DECODE(ABSENCE_YN,'Y',1,'N',0))
FROM TB_STUDENT 
GROUP BY DEPARTMENT_NO 
ORDER BY DEPARTMENT_NO ;

-- 14.
SELECT STUDENT_NAME "동일이름", COUNT(*) "동명인 수" 
FROM TB_STUDENT 
GROUP BY STUDENT_NAME 
HAVING COUNT(*)>1 
ORDER BY STUDENT_NAME ;

-- 15. NVL 사용?
SELECT NVL(SUBSTR(TERM_NO,1,4), ' ') 년도, NVL(SUBSTR(TERM_NO,5,2),' ') 학기, ROUND(AVG(POINT),1) 평점
FROM TB_GRADE 
WHERE STUDENT_NO = 'A112113'
GROUP BY ROLLUP (SUBSTR(TERM_NO,1,4),SUBSTR(TERM_NO,5,2))
ORDER BY SUBSTR(TERM_NO,1,4); 