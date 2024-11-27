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


SELECT * FROM USER_GRADE;
SELECT * FROM USER_USED_FK;
DROP TABLE USER_USED_FK;


INSERT INTO USER_USED_UK2
VALUES(1, 'user01', 'pass01', '유저일', 'M', '010-1234-1234', 'user01@kh.or.kr');

CREATE TABLE USER_USED_UK(
	USER_NO NUMBER,
	USER_ID VARCHAR2(20), 
	USER_PWD VARCHAR2(30),
	USER_NAME VARCHAR2(30),
	GENDER VARCHAR2(1),
	PHONE VARCHAR2(30),
	EMAIL VARCHAR2(50),
); 