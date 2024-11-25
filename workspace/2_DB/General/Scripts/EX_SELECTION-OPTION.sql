-- 1. 

SELECT STUDENT_NAME "학생 이름", STUDENT_ADDRESS "주소지"
FROM TB_STUDENT 
ORDER BY STUDENT_NAME ;

-- 2. 
SELECT STUDENT_NAME , STUDENT_SSN 
FROM TB_STUDENT 
WHERE ABSENCE_YN = 'Y'
ORDER BY STUDENT_SSN DESC;

-- 3. 
SELECT STUDENT_NAME "학생 이름", STUDENT_NO "학번", STUDENT_ADDRESS "거주지 주소"
FROM TB_STUDENT 
WHERE (STUDENT_ADDRESS LIKE '경기도%' OR STUDENT_ADDRESS LIKE '강원도%')
AND STUDENT_NO LIKE '9%'
ORDER BY STUDENT_NAME ;

-- 4. 
SELECT PROFESSOR_NAME , PROFESSOR_SSN 
FROM TB_PROFESSOR 
WHERE DEPARTMENT_NO = '005'
ORDER BY PROFESSOR_SSN ;

-- 5.
SELECT STUDENT_NO , TO_CHAR(POINT , '9.99')
FROM TB_GRADE 
WHERE CLASS_NO = 'C3118100' AND TERM_NO = '200402'
ORDER BY POINT DESC, STUDENT_NO ASC;

-- 6. ????????????? 정렬 순서??? 
SELECT STUDENT_NO , STUDENT_NAME , DEPARTMENT_NAME 
FROM TB_STUDENT 
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
ORDER BY STUDENT_NAME;

-- 7. 
SELECT CLASS_NAME , DEPARTMENT_NAME 
FROM TB_CLASS 
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO);

-- 8. 
SELECT CLASS_NAME , PROFESSOR_NAME
FROM TB_CLASS 
JOIN TB_CLASS_PROFESSOR USING (CLASS_NO)
JOIN TB_PROFESSOR USING (PROFESSOR_NO);

-- 9.
SELECT CLASS_NAME , PROFESSOR_NAME
FROM TB_CLASS CLASS
JOIN TB_CLASS_PROFESSOR USING (CLASS_NO)
JOIN TB_PROFESSOR USING (PROFESSOR_NO)
JOIN TB_DEPARTMENT DEPT ON (CLASS.DEPARTMENT_NO = DEPT.DEPARTMENT_NO)
WHERE CATEGORY = '인문사회' ;

-- 10. 
SELECT STUDENT_NO "학번", STUDENT_NAME "학생 이름", ROUND(AVG(POINT),1) "전체 평점"
FROM TB_STUDENT 
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
JOIN TB_GRADE USING (STUDENT_NO)
WHERE DEPARTMENT_NAME = '음악학과'
GROUP BY STUDENT_NO,STUDENT_NAME
ORDER BY STUDENT_NO; -- 실행 화면 맞춤용 정렬 (문제와 상관 x)

-- 11. 
SELECT DEPARTMENT_NAME , STUDENT_NAME , PROFESSOR_NAME 
FROM TB_STUDENT 
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
JOIN TB_PROFESSOR ON (COACH_PROFESSOR_NO = PROFESSOR_NO)
WHERE STUDENT_NO = 'A313047';

-- 12.
SELECT STUDENT_NAME, TERM_NO "TERM_NAME"
FROM TB_GRADE 
JOIN TB_STUDENT USING (STUDENT_NO)
JOIN TB_CLASS USING (CLASS_NO)
WHERE CLASS_NAME = '인간관계론' AND TERM_NO LIKE '2007%';

-- 13. 
SELECT CLASS_NAME , DEPARTMENT_NAME
FROM TB_CLASS 
LEFT JOIN TB_CLASS_PROFESSOR USING (CLASS_NO)
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
WHERE CATEGORY = '예체능' AND PROFESSOR_NO IS NULL; 

-- 14. 
SELECT ENTRANCE_DATE,STUDENT_NAME "학생이름", NVL(PROFESSOR_NAME, '지도교수 미지정') "지도교수"
FROM TB_STUDENT 
LEFT JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
LEFT JOIN TB_PROFESSOR ON (COACH_PROFESSOR_NO = PROFESSOR_NO)
WHERE DEPARTMENT_NAME = '서반아어학과'
ORDER BY ENTRANCE_DATE;

-- 15. **** 진행중
SELECT STUDENT_NO , STUDENT_NAME , DEPARTMENT_NAME
FROM TB_STUDENT
LEFT JOIN TB_GRADE USING (STUDENT_NO)
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
WHERE ABSENCE_YN = 'N';

-- 16. ?????????? 환경조경학과 AND 전공% 은 6보다 훨씬 많다? 
-- CLASS_NAME 못넣음
SELECT CLASS_NO, AVG(POINT)
FROM TB_GRADE 
WHERE CLASS_NO IN (SELECT CLASS_NO 
FROM TB_CLASS 
WHERE DEPARTMENT_NO = '034' AND CLASS_TYPE LIKE '전공%')
GROUP BY CLASS_NO;


-- 17.
SELECT STUDENT_NAME , STUDENT_ADDRESS 
FROM TB_STUDENT 
WHERE DEPARTMENT_NO = (SELECT DEPARTMENT_NO 
						FROM TB_STUDENT 
						WHERE STUDENT_NAME ='최경희');
						
					
-- 18.
--SELECT STUDENT_NO , STUDENT_NAME 
SELECT STUDENT_NO, STUDENT_NAME 
FROM (SELECT STUDENT_NO, STUDENT_NAME , AVG(POINT)
	FROM TB_GRADE G2
	JOIN TB_STUDENT USING (STUDENT_NO)
	JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
	WHERE DEPARTMENT_NAME = '국어국문학과'
	GROUP BY STUDENT_NO, STUDENT_NAME 
	ORDER BY AVG(POINT) DESC)
WHERE ROWNUM = 1;

					
					
					
SELECT POINT 
FROM TB_GRADE G1
WHERE STUDENT_NO = (SELECT AVG(POINT) 
					FROM TB_GRADE G2
					JOIN TB_STUDENT ON (STUDENT_NO)
					JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
					WHERE DEPARTMENT_NAME = '국어국문학과'
					AND G2.STUDENT_NO = G1.STUDENT_NO);
					
					
SELECT AVG(POINT) 
FROM TB_GRADE 
JOIN TB_STUDENT USING (STUDENT_NO)
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
WHERE DEPARTMENT_NAME = '국어국문학과'
	AND ;






					
SELECT MAX("평점")
FROM (SELECT STUDENT_NO , STUDENT_NAME , AVG(POINT) "평점" 
FROM TB_GRADE 
JOIN TB_STUDENT USING (STUDENT_NO)
WHERE DEPARTMENT_NO = '001'
GROUP BY STUDENT_NO , STUDENT_NAME);



-- 국어국문학과 총평점
SELECT STUDENT_NO, AVG(POINT)
FROM TB_GRADE 
WHERE CLASS_NO IN (SELECT CLASS_NO 
FROM TB_CLASS 
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
WHERE DEPARTMENT_NAME = '국어국문학과')
GROUP BY STUDENT_NO;

SELECT CLASS_NO 
FROM TB_CLASS 
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
WHERE DEPARTMENT_NAME = '국어국문학과';

SELECT * 
FROM TB_GRADE ;

-- 19. 
-- 최종_FINAL
SELECT DEPARTMENT_NAME , DEPARTMENT_NO, AVG(POINT)
FROM TB_GRADE
JOIN TB_CLASS USING (CLASS_NO)
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
WHERE DEPARTMENT_NO IN (SELECT DEPARTMENT_NO 
						FROM TB_DEPARTMENT D1
						WHERE D1.CATEGORY = (SELECT CATEGORY 
											FROM TB_DEPARTMENT D2
											WHERE DEPARTMENT_NAME = '환경조경학과'))
GROUP BY DEPARTMENT_NO, DEPARTMENT_NAME;



(SELECT CATEGORY 
FROM TB_DEPARTMENT D2
WHERE DEPARTMENT_NAME = '환경조경학과');



SELECT DEPARTMENT_NO
FROM TB_GRADE 
WHERE CLASS_NO IN (SELECT CLASS_NO FROM TB_CLASS 
				WHERE DEPARTMENT_NO IN (SELECT DEPARTMENT_NO 
										FROM TB_DEPARTMENT D1
										WHERE D1.CATEGORY = (SELECT CATEGORY 
															FROM TB_DEPARTMENT D2
															WHERE DEPARTMENT_NAME = '환경조경학과')))

;



-- 계열 학과 수업
SELECT * 
FROM TB_CLASS 
WHERE DEPARTMENT_NO IN (SELECT DEPARTMENT_NO 
						FROM TB_DEPARTMENT D1
						WHERE D1.CATEGORY = (SELECT CATEGORY 
											FROM TB_DEPARTMENT D2
											WHERE DEPARTMENT_NAME = '환경조경학과'))
;

SELECT * FROM TB_CLASS ;
SELECT * FROM TB_DEPARTMENT 
WHERE CATEGORY = '인문사회';
SELECT * FROM TB_GRADE;							

-- 같은 계열 학과 (DEPARTMENT_NO)
SELECT DEPARTMENT_NO 
FROM TB_DEPARTMENT D1
WHERE D1.CATEGORY = (SELECT CATEGORY 
FROM TB_DEPARTMENT D2
WHERE DEPARTMENT_NAME = '환경조경학과');


SELECT DEPARTMENT_NAME , DEPARTMENT_NO, AVG(POINT)
FROM TB_GRADE
JOIN TB_CLASS USING (CLASS_NO)
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
WHERE DEPARTMENT_NO IN (SELECT DEPARTMENT_NO 
						FROM TB_DEPARTMENT D1
						WHERE D1.CATEGORY = (SELECT CATEGORY 
											FROM TB_DEPARTMENT D2
											WHERE DEPARTMENT_NAME = '환경조경학과'))
GROUP BY DEPARTMENT_NO, DEPARTMENT_NAME;


