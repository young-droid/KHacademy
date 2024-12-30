-- DDL(DATA DEFINITION LANGUAGE) : 데이터 정의 언어

-- 객체(OBJECT)를 만들고(CREATE), 수정(ALTER)하고, 삭제(DROP) 등
-- 데이터의 전체 구조를 정의하는 언어로 주로 DB관리자, 설계자가 사용함

-- 오라클에서의 객체 : 테이블(TABLE), 뷰(VIEW), 시퀀스(SEQUENCE),
--                   인덱스(INDEX), 패키지(PACKAGE), 트리거(TRIGGER)
--                   프로시져(PROCEDURE), 함수(FUNCTION),
--                   동의어(SYNONYM), 사용자(USER)

--------------------------------------------------------------------------------------------------------------------

/*
DDL : 데이터 정의 언어(객체 생성, 수정, 삭제)
DML : 데이터 조작 언어(데이터 삽입, 수정, 삭제) 
DCL : 트랜잭션 제어 언어(데이터 변경사항을 DB반영, 되돌리기)

*/


-- CREATE

-- 테이블이나 인덱스, 뷰 등 다양한 데이터베이스 객체를 생성하는 구문
-- 테이블로 생성된 객체는 DROP 구문을 통해 제거 할 수 있음 

-- 1. 테이블 생성하기
-- 테이블이란?
-- 행(row)과 열(column)으로 구성되는 가장 기본적인 데이터베이스 객체
-- 데이터 배이스 내에서 모든 데이터는 테이블을 통해서 저장된다.


-- [표현식] 
/*
    CREATE TABLE 테이블명 (
        컬럼명 자료형(크기), 
        컬럼명 자료형(크기),
        ...);
*/

/* 자료형
    NUMBER : 숫자형(정수, 실수)
    CHAR(크기) : 고정길이 문자형 (2000BYTE) 
        -> ex) CHAR(10) 컬럼에 'ABC' 3BYTE 문자열만 저장해도 10BYTE 저장공간을 모두 사용. 
        
    VARCHAR2(크기) : 가변길이 문자형 (4000 BYTE)
        -> ex) VARCHAR2(10) 컬럼에 'ABC' 3BYTE 문자열만 저장하면 나머지 7BYTE를 반환함.
        
    DATE : 날짜 타입
    BLOB : 대용량 이진 데이터 (4GB)
    CLOB : 대용량 문자 데이터 (4GB)
*/

------------------------------------------------------------------------------------
-- 데이터 딕셔너리란? 

-- 자원을 효율적으로 관리하기 위한 다양한 정보를 저장하는 시스템 테이블
-- 데이터 딕셔너리는 사용자가 테이블을 생성하거나 사용자를 변경하는 등의
-- 작업을 할 때 데이터베이스 서버에 의해 자동으로 갱신되는 테이블 

-- USER_TABLES : 자신의 계정이 소유한 객체 등에 관한 정보를 조회할 수 있는 딕셔너리 뷰


SELECT * FROM USER_TABLES;

-- 1. 테이블 생성
-- MEMBER 테이블 생성
CREATE TABLE MEMBER (
	MEMBER_ID VARCHAR2(20), -- 가변 길이 문자열 20바이트 (영어, 숫자만 작성 시 20글자)
	MEMBER_PWD VARCHAR2(20), 
	MEMBER_NAME VARCHAR2(30), -- 한글 3BYTE * 10글자 == 30BYTE
	MEMBER_SSN CHAR(14), -- 
	ENROLL_DATE DATE DEFAULT SYSDATE
);

-- DEFAULT : 입력되는 값이 없거나 'DEFAULT' 키워드 사용 시에 기록되어질 값을 지정

-- 만든 테이블 확인
SELECT * FROM MEMBER;
SELECT * FROM USER_TABLES; -- 딕셔너리 뷰(데이터 딕셔너리에서 일부분만 뽑아서 만든 가상 테이블)


-- 2. 컬럼에 주석 달기
-- [표현식]
-- COMMENT ON COLUMN 테이블명.컬럼명 IS '주석내용';
COMMENT ON COLUMN MEMBER.MEMBER_ID IS '회원 아이디';
COMMENT ON COLUMN MEMBER.MEMBER_PWD IS '회원 비밀번호';
COMMENT ON COLUMN MEMBER.MEMBER_NAME IS '회원 이름';
COMMENT ON COLUMN MEMBER.MEMBER_SSN IS '회원 주민등록번호';
COMMENT ON COLUMN MEMBER.ENROLL_DATE IS '회원가입일';

-- MEMBER 테이블에 샘플 데이터 삽입
-->  가입일 DEFAULT 활용
INSERT INTO MEMBER VALUES('MEM01','PASS01','멤버일','001126-1234567',DEFAULT);

-- 추가 샘플 데이터 삽입
--> 가입일 SYSDATE 활용
INSERT INTO MEMBER VALUES('MEM02','PASS02','멤버이','991126-2234567',SYSDATE);

--> 가입일 미작성 시
INSERT INTO MEMBER(MEMBER_ID, MEMBER_PWD, MEMBER_NAME, MEMBER_SSN)
VALUES('MEM03','PASS03','멤버삼','91126-1234567');


SELECT * FROM MEMBER;
COMMIT; 
ROLLBACK;

-- 테이블명 : MEMBER2
-- 컬럼명 : MEMBER_NAME 한글 최대 10글자
CREATE TABLE MEMBER2 (
	MEMBER_NAME VARCHAR2(30),
	MEMBER_SSN NUMBER
);

-- 주민등록번호의 데이터 타입을 NUMBER로 지정할 경우 문제점

INSERT INTO MEMBER2 VALUES('홍길동', 991126-1234567);
INSERT INTO MEMBER2 VALUES('김철수', 001126-1234567);
--> NUMBER 타입 컬럼에 데이터 삽입 시 앞에 0이 있으면 사라지는 문제점 발생
--> NUMBER 타입 컬럼에 데이터 삽입 시, - 가 있으면 빼기 진행됨

--> 테이블 삭제 
DROP TABLE MEMBER2;

SELECT * FROM MEMBER2;


------------------------------------------------------------------------------------------------

-- 제약 조건(CONSTRAINTS)
/*
    사용자가 원하는 조건의 데이터만 유지하기 위해서 특정 컬럼에 설정하는 제약.
    데이터 무결성 보장을 목적으로 함.
    -> 데이터 무결성이란? 중복 데이터 최소화, NULL 최소화 지향

    + 입력 데이터에 문제가 없는지 자동으로 검사하는 목적
    + 데이터의 수정/삭제 가능여부 검사등을 목적으로 함 
        --> 제약조건을 위배하는 DML 구문은 수행할 수 없음!
    
    제약조건 종류
    PRIMARY KEY, NOT NULL, UNIQUE, CHECK, FOREIGN KEY.
    
*/

-- 제약 조건 확인
-- USER_CONSTRAINTS : 사용자가 작성한 제약 조건을 확인하는 딕셔너리 뷰
SELECT * FROM USER_CONSTRAINTS;

-- USER_CONS_COLUMNS : 제약조건이 걸려있는 컬럼을 확인하는 딕셔너리 뷰
SELECT * FROM USER_CONS_COLUMNS;

-- 1. NOT NULL
-- 해당 컬럼에 반드시 값을 기록해야 하는 경우 사용
-- 삽입/수정 시 NULL값을 허용되지않게 컬럼레벨에서 제한 

CREATE TABLE USER_USED_NN(
	USER_NO NUMBER NOT NULL,
	USER_ID VARCHAR2(20),
	USER_PWD VARCHAR2(30),
	USER_NAME VARCHAR2(30),
	GENDER VARCHAR2(1),
	PHONE VARCHAR2(30),
	EMAIL VARCHAR2(50)
); 

INSERT INTO USER_USED_NN
VALUES (1, 'user01', 'pass01', '유저일', 'M', '010-1234-1234', 'user01@kh.or.kr');

--> 컬럼 레벨에서 제약을 건 USER_NO 에는 NULL 을 넣을 수 없다. 
INSERT INTO USER_USED_NN
VALUES (null, null,null,'유저일', 'M', '010-1234-1234', 'user01@kh.or.kr');

SELECT * FROM USER_USED_NN;

-----------------------------------------------------------------------------------

-- 2. UNIQUE 제약조건
-- 컬럼에 입력 값에 대해서 중복을 제한하는 제약조건 
-- 컬럼 레벨과 테이블 레벨에서 설정 가능
-- + UNIQUE 제약조건이 설정된 컬럼에 NULL값은 중복 삽입 가능

CREATE TABLE USER_USED_UK(
	USER_NO NUMBER,
--	USER_ID VARCHAR2(20) UNIQUE,
--	USER_ID VARCHAR2(20) CONSTRAINT USER_ID_U UNIQUE,
						-- 제약조건명 지정해줌
	USER_ID VARCHAR2(20), 
	
	USER_PWD VARCHAR2(30),
	USER_NAME VARCHAR2(30),
	GENDER VARCHAR2(1),
	PHONE VARCHAR2(30),
	EMAIL VARCHAR2(50),
	
	-- 테이블 레벨 제약조건 설정 부분
--	UNIQUE(USER_ID) -- 테이블 레벨 제약조건 설정(제약조건명 미지정)
	CONSTRAINT USER_ID_U UNIQUE(USER_ID)
); 

DROP TABLE USER_USED_UK;
-- USER_CONS_COLUMNS : 제약조건이 걸려있는 컬럼을 확인하는 딕셔너리 뷰
SELECT * FROM USER_CONS_COLUMNS;

INSERT INTO USER_USED_UK
VALUES(1, 'user01', 'pass01', '유저일', 'M', '010-1234-1234', 'user01@kh.or.kr');


INSERT INTO USER_USED_UK
VALUES(1, 'user01', 'pass01', '유저일', 'M', '010-1234-1234', 'user01@kh.or.kr');
-- ORA-00001: 무결성 제약 조건(KH_CYJ.USER_ID_U)에 위배됩니다
--> 같은 아이디인 데이터가 이미 테이블에 있으므로 UNIQUE 제약 조건에 위배되어 오류 발생

SELECT * FROM USER_USED_UK; 

INSERT INTO USER_USED_UK
VALUES(1, NULL, 'pass01', '유저일', 'M', '010-1234-1234', 'user01@kh.or.kr');

INSERT INTO USER_USED_UK
VALUES(2, NULL, 'pass01', '유저일', 'M', '010-1234-1234', 'user01@kh.or.kr');
--> 아이디에 NULL 값 중복 삽입 가능

---------------------------------------------------------------------------

-- UNIQUE 복합키 
-- 두개 이상의 컬럼을 묶어서 하나의 UNIQUE 제약조건으로 설정
--> 모든 컬럼의 값이 같아야 중복으로 취급함
--> 복합키는 테이블 레벨로만 지정 가능 

CREATE TABLE USER_USED_UK2(
	USER_NO NUMBER,
	USER_ID VARCHAR2(20), 	
	USER_PWD VARCHAR2(30) NOT NULL,
	USER_NAME VARCHAR2(30),
	GENDER VARCHAR2(1),
	PHONE VARCHAR2(30),
	EMAIL VARCHAR2(50),
	
	-- 테이블 레벨 제약조건 설정
	CONSTRAINT USER_ID_NAME_U UNIQUE(USER_ID, USER_NAME)
); 

INSERT INTO USER_USED_UK2
VALUES(1, 'user01', 'pass01', '유저일', 'M', '010-1234-1234', 'user01@kh.or.kr');

INSERT INTO USER_USED_UK2
VALUES(1, 'user02', 'pass01', '유저일', 'M', '010-1234-1234', 'user01@kh.or.kr');
--> USER_ID만 다름 --> 삽입 성공

INSERT INTO USER_USED_UK2
VALUES(1, 'user01', 'pass01', '유저일일', 'M', '010-1234-1234', 'user01@kh.or.kr');
--> USER_NAME만 다름 --> 삽입 성공

INSERT INTO USER_USED_UK2
VALUES(1, 'user01', 'pass01', '유저일', 'M', '010-1234-1234', 'user01@kh.or.kr');
-- ORA-00001: 무결성 제약 조건(KH_CYJ.USER_ID_NAME_U)에 위배됩니다
--> 여러 컬럼을 묶어서 UNIQUE 제약조건으로 설정한 경우
--> 두 컬럼이 모두 중복되는 값일 경우에만 오류 발생

SELECT * FROM USER_USED_UK2;


----------------------------------------------------------------------------------------------------------------

-- 3. PRIMARY KEY(기본키) 제약조건 

-- 테이블에서 한 행의 정보를 찾기위해 사용할 컬럼을 의미함
-- 테이블에 대한 식별자(IDENTIFIER) 역할을 함
-- NOT NULL + UNIQUE 제약조건의 의미
-- 한 테이블당 한 개만 설정할 수 있음
-- 컬럼레벨, 테이블레벨 둘다 설정 가능함
-- 한 개 컬럼에 설정할 수도 있고, 여러개의 컬럼을 묶어서 설정할 수 있음(복합키)

SELECT * FROM EMPLOYEE WHERE EMP_ID = 200;

CREATE TABLE USER_USED_PK(
	USER_NO NUMBER /*CONSTRAINT USER_NO_PK*/ /*PRIMARY KEY*/,
	USER_ID VARCHAR2(20), 
	USER_PWD VARCHAR2(30),
	USER_NAME VARCHAR2(30),
	GENDER VARCHAR2(1),
	PHONE VARCHAR2(30),
	EMAIL VARCHAR2(50),
	
	CONSTRAINT USER_NO_PK PRIMARY KEY(USER_NO) -- 테이블 레벨 PK 지정
	
); 

SELECT * FROM USER_USED_PK;

DROP TABLE USER_USED_PK;

INSERT INTO USER_USED_PK
VALUES(1, 'user01', 'pass01', '유저일', 'M', '010-1234-1234', 'user01@kh.or.kr');

INSERT INTO USER_USED_PK
VALUES(1, 'user02', 'pass02', '유저DL', 'F', '010-1234-1234', 'user01@kh.or.kr');
-- ORA-00001: 무결성 제약 조건(KH_CYJ.USER_NO_PK)에 위배됩니다
--> 기본키 중복으로 오류 

INSERT INTO USER_USED_PK
VALUES(NULL, 'user01', 'pass01', '유저일', 'M', '010-1234-1234', 'user01@kh.or.kr');
-- ORA-01400: NULL을 ("KH_CYJ"."USER_USED_PK"."USER_NO") 안에 삽입할 수 없습니다
-- == NOT NULL 오류와 같음 
--> 기본키가 NULL 이므로 오류

-------------------------------------------------------------------

-- PRIMARY KEY 복합키 (테이블 레벨에서만 가능)

CREATE TABLE USER_USED_PK2(
	USER_NO NUMBER,
	USER_ID VARCHAR2(20), 
	USER_PWD VARCHAR2(30),
	USER_NAME VARCHAR2(30),
	GENDER VARCHAR2(1),
	PHONE VARCHAR2(30),
	EMAIL VARCHAR2(50),
	
	CONSTRAINT USERNO_USERID_PK PRIMARY KEY(USER_NO, USER_ID) -- 복합키
); 

INSERT INTO USER_USED_PK2
VALUES(1, 'user01', 'pass01', '유저일', 'M', '010-1234-1234', 'user01@kh.or.kr');

INSERT INTO USER_USED_PK2
VALUES(1, 'user02', 'pass01', '유저일', 'M', '010-1234-1234', 'user01@kh.or.kr');
--> USER_ID만 다른 경우 -> 삽입 성공

INSERT INTO USER_USED_PK2
VALUES(2, 'user01', 'pass01', '유저일', 'M', '010-1234-1234', 'user01@kh.or.kr');
--> USER_NO만 다른 경우 -> 삽입 성공

INSERT INTO USER_USED_PK2
VALUES(1, 'user01', 'pass02', '유저일', 'M', '010-1234-1234', 'user01@kh.or.kr');
-- ORA-00001: 무결성 제약 조건(KH_CYJ.USERNO_USERID_PK)에 위배됩니다
--> 회원 번호와 아이디 둘 다 중복일 때만 제약조건 위배 에러 발생

INSERT INTO USER_USED_PK2
VALUES(NULL, 'user03', 'pass03', '유저일', 'M', '010-1234-1234', 'user01@kh.or.kr');
--> 복합키여도 PK(NOT NULL + UNIQUE) 이므로
-- NULL 절대 삽입 불가! 


--------------------------------------------------------------------------------------

-- 4. FOREIGN KEY(외부키 / 외래키) 제약조건 
--> 다른 테이블의 PK 또는 UNIQUE 제약조건이 설정된 컬럼

-- 참조(REFERENCES)된 다른 테이블의 컬럼이 제공하는 값만 사용할 수 있음
-- FOREIGN KEY제약조건에 의해서 테이블간의 관계(RELATIONSHIP)가 형성됨
-- 제공되는 값 외에는 NULL을 사용할 수 있음

-- 컬럼레벨일 경우
-- 컬럼명 자료형(크기) [CONSTRAINT 이름] REFERENCES 참조할 테이블명 [(참조할컬럼)] [삭제룰]

-- 테이블레벨일 경우
-- [CONSTRAINT 이름] FOREIGN KEY (적용할컬럼명) REFERENCES 참조할테이블명 [(참조할컬럼)] [삭제룰]
          --> 테이블 레벨에서만  FOREIGN KEY 단어가 사용된다!

-- * 참조될 수 있는 컬럼은 PRIMARY KEY컬럼과, UNIQUE 지정된 컬럼만 외래키로 사용할 수 있음
--참조할 테이블의 참조할 컬럼명이 생략이 되면, PRIMARY KEY로 설정된 컬럼이 자동 참조할 컬럼이 됨

-- 테이블명 : USER_GRADE
-- 컬럼명 : GRADE_CODE 숫자 기본키
-- 컬럼명 : GRADE_NAME 한글 최대 10글자 널허용 X

CREATE TABLE USER_GRADE (
	GRADE_CODE NUMBER PRIMARY KEY,
	GRADE_NAME VARCHAR2(30) NOT NULL
); 

INSERT INTO USER_GRADE VALUES(10, '일반회원');
INSERT INTO USER_GRADE VALUES(20, '우수회원');
INSERT INTO USER_GRADE VALUES(30, '특별회원');

SELECT * FROM USER_GRADE;

CREATE TABLE USER_USED_FK(
	USER_NO NUMBER PRIMARY KEY,
	USER_ID VARCHAR2(20) UNIQUE, 
	USER_PWD VARCHAR2(30) NOT NULL,
	USER_NAME VARCHAR2(30),
	GENDER VARCHAR2(1),
	PHONE VARCHAR2(30),
	EMAIL VARCHAR2(50),
	GRADE_CODE NUMBER,  -- CONSTRAINT GRADE_CODE_FK REFERENCES USER_GRADE(GRADE_CODE)
	
	CONSTRAINT GRADE_CODE_FK FOREIGN KEY(GRADE_CODE) REFERENCES USER_GRADE
													--> 참조하는 테이블의 컬럼명 생략 시 자동으로 해당 테이블의 	PK 참조
); 

INSERT INTO USER_USED_FK
VALUES(1, 'user01', 'pass01', '유저일', 'M', '010-1234-1234', 'user01@kh.or.kr', 10);

INSERT INTO USER_USED_FK
VALUES(2, 'user02', 'pass02', '유저이', 'M', '010-1234-1234', 'user01@kh.or.kr', 20);

INSERT INTO USER_USED_FK
VALUES(3, 'user03', 'pass03', '유저삼', 'M', '010-1234-1234', 'user01@kh.or.kr', NULL);

INSERT INTO USER_USED_FK
VALUES(4, 'user04', 'pass04', '유저사', 'M', '010-1234-1234', 'user01@kh.or.kr', 40);
-- ORA-02291: 무결성 제약조건(KH_CYJ.GRADE_CODE_FK)이 위배되었습니다- 부모 키가 없습니다
--> 참조 무결성 위배

-- 40 이라는 값은 USER_GRADE 테이블의 GRADE_CODE 컬럼에서 제공하는 값이 아니므로
-- 외래키 제약 조건에 위배되어 오류 발생


---------------------------------------------------------------------------------------------

-- * FOREIGN KEY 삭제 옵션
-- 부모 테이블의 데이터 삭제 시 자식 테이블의 데이터를 
-- 어떤 식으로 처리할 지에 대한 내용을 설정할 수 있다. 

SELECT * FROM USER_GRADE;  -- 참조를 당하는 테이블 == 부모 테이블
SELECT * FROM USER_USED_FK; -- 참조를 하는 테이블 == 자식 테이블

DELETE FROM USER_GRADE 
WHERE GRADE_CODE = 30;
-- ORA-02292: 무결성 제약조건(KH_CYJ.GRADE_CODE_FK)이 위배되었습니다- 자식 레코드가 발견되었습니다

-- 1) ON DELETE RESTRICTED (삭제 제한)으로 기본 지정
-- FOREIGN KEY로 지정된 컬럼에서 사용되고 있는 값일 경우
-- 제공하는 컬럼의 값은 삭제하지 못한다. 

-- GRADE_CODE 중 30은 외래키로 참조되고 있지 않으므로 삭제 가능

ROLLBACK; -- 현재 트랜잭션을 제거하고 마지막 COMMIT 상태로 돌아감

-- 2) ON DELETE SET NULL : 부모키 삭제 시 자식키를 NULL로 변경하는 옵션
CREATE TABLE USER_GRADE2 (
	GRADE_CODE NUMBER PRIMARY KEY,
	GRADE_NAME VARCHAR2(30) NOT NULL
); 

INSERT INTO USER_GRADE2 VALUES(10, '일반회원');
INSERT INTO USER_GRADE2 VALUES(20, '우수회원');
INSERT INTO USER_GRADE2 VALUES(30, '특별회원');

SELECT * FROM USER_GRADE2;

CREATE TABLE USER_USED_FK2(
	USER_NO NUMBER PRIMARY KEY,
	USER_ID VARCHAR2(20) UNIQUE, 
	USER_PWD VARCHAR2(30) NOT NULL,
	USER_NAME VARCHAR2(30),
	GENDER VARCHAR2(1),
	PHONE VARCHAR2(30),
	EMAIL VARCHAR2(50),
	GRADE_CODE NUMBER,  
	
	CONSTRAINT GRADE_CODE_FK2 FOREIGN KEY(GRADE_CODE) REFERENCES USER_GRADE2 ON DELETE SET NULL 
																			 --> 삭제 옵션 
); 

INSERT INTO USER_USED_FK2
VALUES(1, 'user01', 'pass01', '유저일', 'M', '010-1234-1234', 'user01@kh.or.kr', 10);

INSERT INTO USER_USED_FK2
VALUES(2, 'user02', 'pass02', '유저이', 'M', '010-1234-1234', 'user01@kh.or.kr', 20);

INSERT INTO USER_USED_FK2
VALUES(3, 'user03', 'pass03', '유저삼', 'M', '010-1234-1234', 'user01@kh.or.kr', 30);

INSERT INTO USER_USED_FK2
VALUES(4, 'user04', 'pass04', '유저사', 'M', '010-1234-1234', 'user01@kh.or.kr', NULL);

SELECT * FROM USER_USED_FK2;

COMMIT;

DELETE FROM USER_GRADE2 WHERE GRADE_CODE = 10;

----------------------------------------------------------------------------------------

-- 3) ON DELETE CASCADE : 부모키 삭제 시 자식키도 함께 삭제
-- 부모키 삭제 시 값을 사용하는 자식 테이블의 컬럼에 해당하는 행도 같이 삭제됨
CREATE TABLE USER_GRADE3 (
	GRADE_CODE NUMBER PRIMARY KEY,
	GRADE_NAME VARCHAR2(30) NOT NULL
); 

INSERT INTO USER_GRADE3 VALUES(10, '일반회원');
INSERT INTO USER_GRADE3 VALUES(20, '우수회원');
INSERT INTO USER_GRADE3 VALUES(30, '특별회원');

SELECT * FROM USER_GRADE3;

CREATE TABLE USER_USED_FK3(
	USER_NO NUMBER PRIMARY KEY,
	USER_ID VARCHAR2(20) UNIQUE, 
	USER_PWD VARCHAR2(30) NOT NULL,
	USER_NAME VARCHAR2(30),
	GENDER VARCHAR2(1),
	PHONE VARCHAR2(30),
	EMAIL VARCHAR2(50),
	GRADE_CODE NUMBER,  
	
	CONSTRAINT GRADE_CODE_FK3 FOREIGN KEY(GRADE_CODE) REFERENCES USER_GRADE3 ON DELETE CASCADE 
																			 --> 삭제 옵션 
); 

INSERT INTO USER_USED_FK3
VALUES(1, 'user01', 'pass01', '유저일', 'M', '010-1234-1234', 'user01@kh.or.kr', 10);

INSERT INTO USER_USED_FK3
VALUES(2, 'user02', 'pass02', '유저이', 'M', '010-1234-1234', 'user01@kh.or.kr', 20);

INSERT INTO USER_USED_FK3
VALUES(3, 'user03', 'pass03', '유저삼', 'M', '010-1234-1234', 'user01@kh.or.kr', 30);

INSERT INTO USER_USED_FK3
VALUES(4, 'user04', 'pass04', '유저사', 'M', '010-1234-1234', 'user01@kh.or.kr', NULL);

SELECT * FROM USER_USED_FK3;

-- 부모 테이블인 USER_GRADE3에서 GRADE_CODE = 30 삭제
DELETE FROM USER_GRADE3 WHERE GRADE_CODE = 30;
SELECT * FROM USER_GRADE3;  -- 부모 테이블 삭제 확인 (30 없음)
SELECT * FROM USER_USED_FK3; -- 30을 참조하던 자식 행 역시 삭제 확인 (종속 관계의 행이 모두 삭제됨)
-- ON DELETE CASCADE 옵션으로 인해 참조키를 사용하던 행이 삭제됨을 확인

------------------------------------------------------------------------------------------
-- 5. CHECK 제약조건 : 컬럼에 기록디는 값에 조건을 설정할 수 있음
-- CHECK(컬럼명 비교연산자 비교값)
-- 주의 : 비교값은 리터럴만 사용 가능, 변하는 값 또는 함수 사용 불가

CREATE TABLE USER_USED_CHECK(
	USER_NO NUMBER,
	USER_ID VARCHAR2(20), 
	USER_PWD VARCHAR2(30),
	USER_NAME VARCHAR2(30),
	GENDER VARCHAR2(1) CONSTRAINT GENDER_CHECK CHECK(GENDER IN ('M', 'F')),
	PHONE VARCHAR2(30),
	EMAIL VARCHAR2(50)
); 

INSERT INTO USER_USED_CHECK
VALUES(1, 'user01', 'pass01', '유저일', 'M', '010-1234-1234', 'user01@kh.or.kr');

INSERT INTO USER_USED_CHECK
VALUES(2, 'user02', 'pass02', '유저이', 'H', '010-1234-1234', 'user01@kh.or.kr');
-- ORA-02290: 체크 제약조건(KH_CYJ.GENDER_CHECK)이 위배되었습니다
--> GENDER 컬럼에 CHECK 제약 조건으로 'F' 또는 'M' 만 기록 가능하게 함
-- 해당 값 이외의 값이 들어와서 에러 발생 

-- CHECK 제약 조건은 범위로도 설정 가능 

-------------------------------------------------------------------------------------------------

COMMENT ON COLUMN "USER_TEST"."USER_NO" IS '회원번호';
COMMENT ON COLUMN "USER_TEST"."USER_ID" IS '회원아이디';
COMMENT ON COLUMN "USER_TEST"."USER_PWD" IS '회원비밀번호';
COMMENT ON COLUMN "USER_TEST"."PNO" IS '주민등록번호';
COMMENT ON COLUMN "USER_TEST"."GENDER" IS '성별';
COMMENT ON COLUMN "USER_TEST"."PHONE" IS '연락처';
COMMENT ON COLUMN "USER_TEST"."ADDRESS" IS '주소';
COMMENT ON COLUMN "USER_TEST"."STATUS" IS '탈퇴여부';
COMMENT ON COLUMN "USER_TEST"."AGE" IS '나이';
-- [연습문제]
-- 회원가입용 테이블 생성(USER_TEST)
-- 컬럼명 : USER_NO(회원번호) - 기본키(PK_USER_TEST), 
--         USER_ID(회원아이디) - 중복금지(UK_USER_ID),
--         USER_PWD(회원비밀번호) - NULL값 허용안함(NN_USER_PWD),
--         PNO(주민등록번호) - 중복금지(UK_PNO), NULL 허용안함(NN_PNO),
--         GENDER(성별) - '남' 혹은 '여'로 입력(CK_GENDER),
--         PHONE(연락처),
--         ADDRESS(주소),
--         STATUS(탈퇴여부) - NOT NULL(NN_STATUS), 'Y' 혹은 'N'으로 입력(CK_STATUS),
--         AGE(나이) - 20살 이상(CH_AGE)
-- 각 컬럼의 제약조건에 이름 부여할 것
-- 5명 이상 INSERT할 것

CREATE TABLE USER_TEST(
	USER_NO NUMBER CONSTRAINT PK_USER_TEST PRIMARY KEY, 
	USER_ID CHAR(12) CONSTRAINT UK_USER_ID UNIQUE, 
	USER_PWD CHAR(20) CONSTRAINT NN_USER_PWD NOT NULL, 
	PNO CHAR(19) CONSTRAINT UK_PNO UNIQUE CONSTRAINT NN_PNO NOT NULL, 
	GENDER CHAR(3) CONSTRAINT CK_GENDER CHECK (GENDER IN ('남', '여')),
	PHONE CHAR(13),
	ADDRESS VARCHAR2(100),
	STATUS CHAR(2) CONSTRAINT NN_STATUS NOT NULL CONSTRAINT CK_STATUS CHECK(STATUS IN ('Y', 'N')),
	AGE NUMBER CONSTRAINT CH_AGE CHECK(AGE >= 20)
	) ;

DROP TABLE USER_TEST;

SELECT * FROM USER_TEST;

INSERT INTO USER_TEST 
VALUES(1, 'user01', 'pass01', '991127-2012345', '여', '010-1234-5678', '서울특별시 강남대로 22-1, KH아카데미 3층 G강의실', 'N', 20);

INSERT INTO USER_TEST 
VALUES(2, 'user02', 'pass01', '991127-1234567', '남', '010-1234-5678', '서울특별시 강남대로 22-1, KH아카데미 3층 G강의실', 'N', 20);

INSERT INTO USER_TEST 
VALUES(3, 'GLINDA', 'POPULAR', '991225-2012345', '여', '010-1234-1004', '오즈특별시 에메랄드로 1004-1 스위트 2층', 'N', 21);

INSERT INTO USER_TEST 
VALUES(4, 'ELPHABA', 'NoWater', '990229-2012345', '여', '010-1234-8888', '오즈특별시 에메랄드로 8888-8 그린하우스', 'N', 22);

INSERT INTO USER_TEST 
VALUES(5, 'Fiyero', 'Dance', '980401-1012345', '남', '010-1111-1111', '오즈특별시 빈쿠스구 777 왕성 왕자방', 'N', 23);

--------------------------------------------------------------------------------------------------------

-- 6. SUBQUERY를 이용한 테이블 생성 
-- 컬럼명, 데이터 타입, 값 복사되고 제약조건은 NOT NULL만 복사됨

-- 1) 테이블 전체 복사
CREATE TABLE EMPLOYEE_COPY
AS SELECT * FROM EMPLOYEE;

SELECT * FROM EMPLOYEE_COPY;

-- 2) JOIN 후 원하는 컬럼만 테이블로 복사 
CREATE TABLE EMPLOYEE_COPY2
AS (
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE 
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE)
);

SELECT * FROM EMPLOYEE_COPY2;

-- 3) 테이블 형태(컬럼명, 데이터 타입)만 복사 (데이터 복사 X)
CREATE TABLE EMPLOYEE_COPY3
AS SELECT * FROM EMPLOYEE 
   WHERE 1 = 0; 

SELECT * FROM EMPLOYEE_COPY3; 

--------------------------------------------------------------------------------------------
-- 7. 제약조건 추가
-- ALTER TABLE 테이블명 ADD [CONSTRAINT 제약조건명] PRIMARY KEY(컬럼명)
-- ALTER TABLE 테이블명 ADD [CONSTRAINT 제약조건명] 
--  FOREIGN KEY(컬럼명) REFERENCES 참조 테이블명(참조컬럼명)
     --> 참조 테이블의 PK를 기본키를 FK로 사용하는 경우 참조컬럼명 생략 가능
                                                                                                                                                      
-- ALTER TABLE 테이블명 ADD [CONSTRAINT 제약조건명] UNIQUE(컬럼명)
-- ALTER TABLE 테이블명 ADD [CONSTRAINT 제약조건명] CHECK(컬럼명 비교연산자 비교값)
-- ALTER TABLE 테이블명 MODIFY 컬럼명 NOT NULL;

-- 테이블 제약 조건 확인
SELECT * 
FROM USER_CONSTRAINTS C1
JOIN USER_CONS_COLUMNS C2 USING(CONSTRAINT_NAME)
WHERE C1.TABLE_NAME = 'EMPLOYEE_COPY';

-- NOT NULL 제약조건만 복사된 EMPLOYEE_COPY 테이블에 
-- EMP_ID 컬럼에 PRIMARY KEY 제약조건 추가
ALTER TABLE EMPLOYEE_COPY ADD CONSTRAINT PK_EMP_ID PRIMARY KEY(EMP_ID);


-- 수업때 사용하던 테이블에는 FK 제약조건이 없는 상태이므로 추가

-- EMPLOYEE테이블의 DEPT_CODE에 외래키 제약조건 추가
-- 참조 테이블은 DEPARTMENT, 참조 컬럼은 DEPARTMENT의 기본키
ALTER TABLE EMPLOYEE ADD
FOREIGN KEY(DEPT_CODE) REFERENCES DEPARTMENT;

-- EMPLOYEE테이블의 JOB_CODE 외래키 제약조건 추가
-- 참조 테이블은 JOB, 참조 컬럼은 JOB의 기본키
ALTER TABLE EMPLOYEE ADD 
FOREIGN KEY(JOB_CODE) REFERENCES JOB (JOB_CODE);

-- EMPLOYEE테이블의 SAL_LEVEL 외래키 제약조건 추가
-- 참조 테이블은 SAL_GRADE, 참조 컬럼은 SAL_GRADE의 기본키
ALTER TABLE EMPLOYEE ADD 
FOREIGN KEY(SAL_LEVEL) REFERENCES SAL_GRADE;

SELECT * FROM EMPLOYEE;
SELECT * FROM SAL_GRADE ; 

-- DEPARTMENT테이블의 LOCATION_ID에 외래키 제약조건 추가
-- 참조 테이블은 LOCATION, 참조 컬럼은 LOCATION의 기본키
ALTER TABLE DEPARTMENT ADD 
FOREIGN KEY(LOCATION_ID) REFERENCES LOCATION;
-- LOCATION테이블의 NATIONAL_CODE에 외래키 제약조건 추가
-- 참조 테이블은 NATIONAL, 참조 컬럼은 NATIONAL의 기본키
ALTER TABLE LOCATION ADD 
FOREIGN KEY(NATIONAL_CODE) REFERENCES NATIONAL;
  ----------------------------------------------------------------
INSERT INTO USER_USED_CHECK
VALUES(1, 'user01', 'pass01', '유저일', 'M', '010-1234-1234', 'user01@kh.or.kr');
