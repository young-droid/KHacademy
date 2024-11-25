/* 
 * * SUBQUERY(서브 쿼리)
 * - 하나의 SQL문 안에 포함된 또다른 SQL(SELECT)문
 * - 메인쿼리(기존쿼리)를 위해 보조 역할을 하는 쿼리문
 * - SELECT, FROM, WHERE, HAVING절에서 사용 가능
 * */

-- 서브쿼리 예시 1.
-- 부서코드가 노옹철 사원과 같은 소속의
-- 직원 이름, 부서코드 조회

-- 1) 사원명이 노옹철인 사람의 부서코드 조회
SELECT DEPT_CODE FROM EMPLOYEE
WHERE EMP_NAME  = '노옹철'; -- 'D9'

 -- 2) 부서코드가 'D9'인 직원을 조회
SELECT EMP_NAME, DEPT_CODE FROM EMPLOYEE 
WHERE DEPT_CODE = 'D9';

-- 3) 부서코드가 노옹철 사원과 같은 소속의 직원 이름, 부서코드 조회
--> 1, 2 단계를 하나의 쿼리로

-- 메인쿼리
SELECT EMP_NAME, DEPT_CODE FROM EMPLOYEE 
WHERE DEPT_CODE = (SELECT DEPT_CODE FROM EMPLOYEE
WHERE EMP_NAME  = '노옹철');
-- 서브쿼리
				
-- 서브쿼리 예시 2.
-- 전 직원의 평균 급여보다 많은 급여를 받고 있는 직원의
-- 사번, 이름, 직급코드, 급여 조회
				
-- 1) 전 직원의 평균 급여 조회
SELECT AVG(SALARY)
FROM EMPLOYEE; 

-- 2) 직원들 중 급여가 평균(1의 조회결과) 이상인 사원들의 사번, 이름, 직급코드, 급여 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY 
FROM EMPLOYEE
WHERE SALARY > (3047662.60869565217391304347826086956522);

-- 3) 전 직원의 평균 급여보다 많은 급여를 받고 있는 직원의 사번, 이름, 직급코드, 급여 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY 
FROM EMPLOYEE
WHERE SALARY > (SELECT AVG(SALARY) FROM EMPLOYEE);


-------------------------------------------------------------------

/*  서브쿼리 유형

    - 단일행 (+ 단일열) 서브쿼리 : 서브쿼리의 조회 결과 값의 개수가 1개일 때 
    
    - 다중행 (+ 단일열) 서브쿼리 : 서브쿼리의 조회 결과 값의 개수가 여러개일 때
    
    - 다중열 서브쿼리 : 서브쿼리의 SELECT 절에 자열된 항목수가 여러개 일 때
    
    - 다중행 다중열 서브쿼리 : 조회 결과 행 수와 열 수가 여러개일 때 
    
    - 상관 서브쿼리 : 서브쿼리가 만든 결과 값을 메인 쿼리가 비교 연산할 때 
                     메인 쿼리 테이블의 값이 변경되면 서브쿼리의 결과값도 바뀌는 서브쿼리
                     
    - 스칼라 서브쿼리 : 상관 쿼리이면서 결과 값이 하나인 서브쿼리
    
   * 서브쿼리 유형에 따라 서브쿼리 앞에 붙은 연산자가 다름
    
*/


-- 1. 단일행 서브쿼리 (SINGLE ROW SUBQUERY)
--    서브쿼리의 조회 결과 값의 개수가 1개인 서브쿼리
--    단일행 서브쿼리 앞에는 비교 연산자 사용
--    <, >, <=, >=, =, !=/^=/<>


-- 전 직원의 급여 평균보다 많은 급여를 받는 직원의 
-- 이름, 직급, 부서, 급여를 직급 순으로 정렬하여 조회
SELECT EMP_NAME, JOB_CODE , DEPT_CODE, SALARY 
FROM EMPLOYEE
WHERE SALARY > (SELECT AVG(SALARY) FROM EMPLOYEE)
ORDER BY JOB_CODE ;

-- 가장 적은 급여를 받는 직원의
-- 사번, 이름, 직급코드, 부서코드, 급여, 입사일 조회
SELECT EMP_ID , EMP_NAME , JOB_CODE , DEPT_CODE , SAL_LEVEL , HIRE_DATE 
FROM EMPLOYEE 
WHERE SALARY = (SELECT MIN(SALARY) FROM EMPLOYEE);

-- 노옹철 사원의 급여보다 많이 받는 직원의
-- 사번, 이름, 부서코드, 직급코드, 급여 조회
SELECT EMP_ID , EMP_NAME , DEPT_CODE , JOB_CODE , SALARY 
FROM EMPLOYEE 
WHERE SALARY > (SELECT SALARY FROM EMPLOYEE WHERE EMP_NAME = '노옹철');

-- 부서별(부서가 없는 사람 포함) 급여의 합계 중 가장 큰 부서의
-- 부서명, 급여 합계 조회

-- 1) 부서 별 급여 합 중 가장 큰 값 조회 (부서별 급여 합 1등)
SELECT MAX(SUM(SALARY))
FROM EMPLOYEE 
GROUP BY DEPT_CODE;

-- 2) 부서별 급여 합이 17700000인 부서의 부서명, 급여 합 조회
SELECT DEPT_TITLE , SUM(SALARY )
FROM EMPLOYEE 
LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
GROUP BY DEPT_TITLE 
HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY))
FROM EMPLOYEE 
GROUP BY DEPT_CODE);

-----------------------------------------------------------
					
		
-- 2. 다중행 서브쿼리 (MULTI ROW SUBQUERY)
--    서브쿼리의 조회 결과 값의 개수가 여러행일 때 

/*
    >> 다중행 서브쿼리 앞에는 일반 비교연산자 사용 x
    
    - IN / NOT IN : 여러 개의 결과값 중에서 한 개라도 일치하는 값이 있다면
                    혹은 없다면 이라는 의미(가장 많이 사용!)
                    
    - > ANY, < ANY : 여러개의 결과값 중에서 한개라도 큰 / 작은 경우
                     가장 작은 값보다 큰가? / 가장 큰 값 보다 작은가?
                     
    - > ALL, < ALL : 여러개의 결과값의 모든 값보다 큰 / 작은 경우
                     가장 큰 값 보다 큰가? / 가장 작은 값 보다 작은가?
                     
    - EXISTS / NOT EXISTS : 값이 존재하는가? / 존재하지 않는가?
    
*/

-- 부서별 최고 급여를 받는 직원의 
-- 이름, 직급, 부서, 급여를 부서 순으로 정렬하여 조회			
SELECT MAX(SALARY)
FROM EMPLOYEE 
GROUP BY DEPT_CODE ; -- 7행 1열

SELECT EMP_NAME , DEPT_CODE , JOB_CODE , SALARY 
FROM EMPLOYEE 
WHERE SALARY IN (SELECT MAX(SALARY)
FROM EMPLOYEE 
GROUP BY DEPT_CODE)
ORDER BY DEPT_CODE ;


-- 사수에 해당하는 직원에 대해 조회
-- 사번, 이름, 부서명, 직급명, 구분(사수/직원)

-- 1) 사수에 해당하는 사원 번호 조회 
SELECT DISTINCT MANAGER_ID 
FROM EMPLOYEE 
WHERE MANAGER_ID IS NOT NULL;

-- 2) 직원의 사번, 이름, 부서명, 직급명 조회(부서 없는 사람 포함)
SELECT EMP_ID, EMP_NAME , DEPT_TITLE , JOB_NAME 
FROM EMPLOYEE 
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE); 

-- 3) 사수에 해당하는 직원에 대한 정보 조회(이때, 구분은 '사수'로)
SELECT EMP_ID, EMP_NAME , DEPT_TITLE , JOB_NAME , '사수' 구분
FROM EMPLOYEE 
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
WHERE MANAGER_ID IN (SELECT DISTINCT MANAGER_ID 
FROM EMPLOYEE 
WHERE EMP_ID IS NOT NULL); 

-- 4) 일반 직원에 해당하는 사원들 정보 조회(이때, 구분은 '사원'으로)
SELECT EMP_ID, EMP_NAME , DEPT_TITLE , JOB_NAME , '사원' 구분
FROM EMPLOYEE 
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
WHERE EMP_ID NOT IN (SELECT DISTINCT MANAGER_ID 
FROM EMPLOYEE 
WHERE MANAGER_ID IS NOT NULL); 

-- 5) 3, 4의 조회 결과를 하나로 합침 --> SELECT 절 SUBQUERY 사용
--> * SELECT 절에도 서브 쿼리 사용 가능!
SELECT EMP_ID, EMP_NAME , DEPT_TITLE , JOB_NAME , 
	CASE 
		WHEN EMP_ID NOT IN (SELECT DISTINCT MANAGER_ID 
					FROM EMPLOYEE 
					WHERE MANAGER_ID IS NOT NULL)
			THEN '사원'
			ELSE '사수'
	END
FROM EMPLOYEE 
LEFT JOIN DEPARTMENT ON (
DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE);


-- UNION 사용
SELECT EMP_ID, EMP_NAME , DEPT_TITLE , JOB_NAME , '사수' 구분
FROM EMPLOYEE 
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
WHERE MANAGER_ID IN (SELECT DISTINCT MANAGER_ID 
FROM EMPLOYEE 
WHERE EMP_ID IS NOT NULL) 

UNION

SELECT EMP_ID, EMP_NAME , DEPT_TITLE , JOB_NAME , '사원' 구분
FROM EMPLOYEE 
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
WHERE EMP_ID NOT IN (SELECT DISTINCT MANAGER_ID 
FROM EMPLOYEE 
WHERE MANAGER_ID IS NOT NULL); 



-- 대리 직급의 직원들 중에서 과장 직급의 최소 급여보다 많이 받는 직원의
-- 사번, 이름, 직급, 급여를 조회
-- > ANY 혹은 < ANY 연산자 사용

-- 1) 직급이 대리인 직원들의 사번, 이름, 직급명, 급여 조회
SELECT EMP_ID , EMP_NAME , JOB_NAME , SALARY 
FROM EMPLOYEE 
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '대리' ;

-- 2) 직급이 과장인 직원들의 급여 조회
SELECT SALARY 
FROM EMPLOYEE 
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '과장' ;

-- 3) 대리 직급의 직원들 중에서 과장 직급의 최소 급여보다 많이 받는 직원
-- 3-1) MIN을 이용하여 단일행 서브쿼리 만들기
SELECT EMP_ID , EMP_NAME , JOB_NAME , SALARY 
FROM EMPLOYEE 
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '대리' 
	AND SALARY >(SELECT MIN(SALARY ) 
				FROM EMPLOYEE 
				JOIN JOB USING (JOB_CODE)
				WHERE JOB_NAME = '과장');

-- 3-2) ANY를 이용하여 과장 중 가장 급여가 적은 직원을 초과하는 대리 조회
SELECT EMP_ID , EMP_NAME , JOB_NAME , SALARY 
FROM EMPLOYEE 
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '대리' 
	AND SALARY > ANY (SELECT SALARY
				FROM EMPLOYEE 
				JOIN JOB USING (JOB_CODE)
				WHERE JOB_NAME = '과장');
-- A > ANY B : A가 B의 결과 중 하나라도 크면 TRUE
				--> A가 B의 최소값 보다 큰 경우
			
-- A < ANY B : A가 B의 결과 중 하나라도 작으면 TRUE
				--> A가 B의 최대값 보다 작은 경우
			
-- 차장 직급의 급여의 가장 큰 값 보다 많이 받는 과장 직급의 직원
			-- 사번, 이름, 직급명, 급여를 조회
--> < ALL 혹은 > ALL 연산자 사용
			
SELECT EMP_ID ,EMP_NAME ,JOB_CODE , SALARY 
FROM EMPLOYEE 
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '과장'
	AND SALARY > ALL (SELECT SALARY 
					FROM EMPLOYEE 
					JOIN JOB USING(JOB_CODE)
					WHERE JOB_NAME = '차장');
					
					
					
-- 서브쿼리 중첩 사용
-- LOCATION 테이블에서 NATIONAL_CODE가 KO 인 경우의 LOCAL_CODE와
-- DEPARTMENT 테이블의 LOCATION_ID와 동일한 DEPT_ID가
-- EMPLOYEE 테이블의 DEPT_CODE와 동일한 사원을 구하시오. 

SELECT LOCAL_CODE
FROM LOCATION 
WHERE NATIONAL_CODE = 'KO';

SELECT DEPT_ID 
FROM DEPARTMENT
WHERE LOCATION_ID = (SELECT LOCAL_CODE
FROM LOCATION 
WHERE NATIONAL_CODE = 'KO');

SELECT EMP_NAME , DEPT_CODE 
FROM EMPLOYEE 
WHERE DEPT_CODE IN (SELECT DEPT_ID 
					FROM DEPARTMENT
					WHERE LOCATION_ID = (SELECT LOCAL_CODE
										FROM LOCATION 
										WHERE NATIONAL_CODE = 'KO'));
--> 한국에 있는 부서에서 일하는 사원 조회
										
----------------------------------------------------------------------

-- 3. 다중열 서브쿼리 (단일행 = 결과값은 한 행)
-- 	  서브쿼리 SELECT절에 나열된 컬럼의 수가 여러개 일 때

-- 퇴사한 여직원과 같은 부서, 같은 직급에 해당하는
-- 사원의 이름, 직급, 부서, 입사일을 조회
									
SELECT EMP_NAME , JOB_CODE , DEPT_CODE , HIRE_DATE 
FROM EMPLOYEE 
WHERE ENT_DATE IS NOT NULL AND SUBSTR(EMP_NO,8,1) = 2 ;

-- 2) 퇴사한 여직원과 같은 부서, 같은 직급
SELECT EMP_NAME , JOB_CODE , DEPT_CODE , HIRE_DATE 
FROM EMPLOYEE 
WHERE (DEPT_CODE , JOB_CODE )= (SELECT DEPT_CODE , JOB_CODE 
							FROM EMPLOYEE 
							WHERE ENT_YN = 'Y'
							AND SUBSTR(EMP_NO,8,1) = 2 );
							
------------------------------------------------------------
						
-- 4. 다중행 다중열 서브쿼리
--    서브쿼리 조회 결과 행 수와 열 수가 여러개 일 때

-- 본인 직급의 평균 급여를 받고 있는 직원의
-- 사번, 이름, 직급, 급여를 조회하세요
-- 단, 급여와 급여 평균은 만원단위로 계산하세요 TRUNC(컬럼명, -4)   

-- 1) 급여를 200만, 600만 받는 직원 (200만, 600만이 평균 급여라고 가정)
SELECT EMP_ID , EMP_NAME , JOB_CODE , SALARY 
FROM EMPLOYEE 
WHERE SALARY IN (2000000, 6000000);

-- 2) 직급별 평균 급여
SELECT JOB_CODE , TRUNC(AVG(SALARY), -4) "직급별 평균 급여"
FROM EMPLOYEE 
GROUP BY JOB_CODE;

-- 3) 본인 직급의 평균 급여를 받고 있는 직원
SELECT EMP_ID , EMP_NAME , JOB_CODE , SALARY 
FROM EMPLOYEE 
WHERE (JOB_CODE , SALARY) IN (SELECT JOB_CODE , TRUNC(AVG(SALARY), -4)
								FROM EMPLOYEE 
								GROUP BY JOB_CODE) ;

-- 연습문제: 
-- 1. 전지연 사원이 속해있는 부서원들을 조회하시오 (단, 전지연은 제외)
--    사번, 사원명, 전화번호, 고용일, 부서명
SELECT EMP_ID , EMP_NAME , PHONE , HIRE_DATE , DEPT_TITLE 
FROM EMPLOYEE 
JOIN DEPARTMENT ON(DEPT_ID = DEPT_CODE)
WHERE DEPT_CODE = (SELECT DEPT_CODE FROM EMPLOYEE WHERE EMP_NAME = '전지연')
	AND EMP_NAME != '전지연';

-- 2. 고용일이 2000년도 이후인 사원들 중 급여가 가장 높은 사원의
--	  사번, 사원명, 전화번호, 급여, 직급명을 조회하시오
SELECT EMP_ID, EMP_NAME, PHONE, SALARY, JOB_CODE 
FROM EMPLOYEE 
LEFT JOIN JOB USING(JOB_CODE)
WHERE SALARY = (SELECT MAX(SALARY) FROM EMPLOYEE WHERE HIRE_DATE >= '2000-01-01' );

-- 3. 노옹철 사원과 같은 부서, 같은 직급인 사원을 조회하시오. (단, 노옹철 사원은 제외)
--    사번, 이름, 부서코드, 직급코드, 부서명, 직급명
SELECT EMP_ID , EMP_NAME , DEPT_CODE , JOB_CODE , DEPT_TITLE , JOB_NAME
FROM EMPLOYEE 
JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
JOIN JOB USING (JOB_CODE)
WHERE (DEPT_CODE, JOB_CODE) IN (SELECT DEPT_CODE, JOB_CODE FROM EMPLOYEE WHERE EMP_NAME='노옹철')
AND EMP_NAME!='노옹철';









