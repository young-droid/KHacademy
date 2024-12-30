/* 계정(사용자)

* 관리자 계정 : 데이터베이스의 생성과 관리를 담당하는 계정.
                모든 권한과 책임을 가지는 계정.
                ex) sys(최고관리자), system(sys에서 권한 몇개 제외된 관리자)


* 사용자 계정 : 데이터베이스에 대하여 질의, 갱신, 보고서 작성 등의
                작업을 수행할 수 있는 계정으로
                업무에 필요한 최소한의 권한만을 가지는 것을 원칙으로 한다.
                ex) KH계정(각자 이니셜 계정), workbook 등
*/

/* DCL(Data Control Language) : 계정에 DB, DB객체에 대한 접근 권한을 부여하고 회수하는 언어

- GRANT : 권한 부여
- REVOKE : 권한 회수

* 권한의 종류

1) 시스템 권한 : DB접속, 객체 생성 권한

CRETAE SESSION   : 데이터베이스 접속 권한
CREATE TABLE     : 테이블 생성 권한
CREATE VIEW      : 뷰 생성 권한
CREATE SEQUENCE  : 시퀀스 생성 권한
CREATE PROCEDURE : 함수(프로시져) 생성 권한
CREATE USER      : 사용자(계정) 생성 권한
DROP USER        : 사용자(계정) 삭제 권한
DROP ANY TABLE   : 임의 테이블 삭제 권한


2) 객체 권한 : 특정 객체를 조작할 수 있는 권한

  권한 종류                 설정 객체
    SELECT              TABLE, VIEW, SEQUENCE
    INSERT              TABLE, VIEW
    UPDATE              TABLE, VIEW
    DELETE              TABLE, VIEW
    ALTER               TABLE, SEQUENCE
    REFERENCES          TABLE
    INDEX               TABLE
    EXECUTE             PROCEDURE

*/

-- 0. SQL 구문 작성 형식을 예전(11g) 오라클 SQL형식으로 사용하도록 변경
--> 왜? 변경 하지 않으면 c##을 사용자명 앞에 붙여야함.. 번거로움
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE ;
 
-- 1. [SYS 관리자 계정] 사용자 계정 생성 
-- 사용자명 : 각자이니셜_sample / 비밀번호 : sample1234
CREATE USER cyj_sample IDENTIFIED BY sample1234;

-- 2. 생성된 계정에 접속하기 위한 접속방법 추가
-- 상단 메뉴 -> 데이터베이스 -> 새데이터베이스 연결
-- ORA-01045: 사용자 CYJ_SAMPLE는 CREATE SESSION 권한을 가지고있지 않음; 로그온이 거절되었습니다

-- 3. [SYS 관리자 계정] 생성된 샘플 계정에 DB 접속 권한 부여
GRANT CREATE SESSION TO cyj_sample;

-- 4. 다시 생성된 샘플 계정 접속 방법 추가 --> 성공

-- 5. [sample 계정]
CREATE TABLE TB_TEST(
	TEST_PK NUMBER PRIMARY KEY,
	TEST_CONNECT VARCHAR2(100)
);
-- ORA-01031: 권한이 불충분합니다
--> DB 접속 권한만 있는 상태, 테이블 생성 권한은 없음

-- 6. [SYS 관리자 계정] 테이블 생성 권한 부여 + 객체 생성 공간 할당
GRANT CREATE TABLE TO cyj_sample ;

ALTER USER cyj_sample DEFAULT TABLESPACE SYSTEM QUOTA UNLIMITED ON SYSTEM;

-- 7. [sample 계정] 다시 테이블 생성
CREATE TABLE TB_TEST(
	TEST_PK NUMBER PRIMARY KEY,
	TEST_CONNECT VARCHAR2(100)
);

SELECT * FROM TB_TEST;

-----------------------------------------------
-- ROLE : 권한의 묶음
--> 묶어둔 권한(ROLE)을 특정 계정에 부여 --> 해당 계정은 특정 권한을 가진 역할을 갖게 됨

-- ROLE을 사용하면 한번에 많은 권한을 부여하거나 회수할 수 있다.

-- 1) CONNECT : DB 접속 권한 (== CREATE SESSION)
--> 담고 있는 권한은 1개지만 의미적으로 쉽게 사용하기 위해 사용 

-- [SYS 관리자 계정] 
SELECT * FROM ROLE_SYS_PRIVS
WHERE ROLE = 'CONNECT';

-- 2) RESOURCE : DB 사용을 위한 기본 객체 생성 권한 묶음 
SELECT * FROM ROLE_SYS_PRIVS
WHERE ROLE = 'RESOURCE'; -- 테이블 생성 포함 8개

-- ROLE 을 이용해서 샘플 계정에 다시 권한 부여
-- [SYS 관리자 계정]
GRANT CONNECT, RESOURCE TO cyj_sample;

------------------------------------------------------

-- 객체 권한
--> cyj_sample 계정에서 KH_CYJ 계정의 EMPLOYEE 테이블 조회

-- 1. [sample 계정]
SELECT * FROM KH_CYJ.EMPLOYEE; --> EMPLOYEE 테이블(객체) 조회 권한 없음 

-- 2. [KH 계정] 샘플 계정에 EMPLOYEE 테이블 조회 권한 부여
GRANT SELECT ON EMPLOYEE TO cyj_sample;

-- 3. [sample 계정] 
SELECT * FROM KH_CYJ.EMPLOYEE;

-- 4. [KH 계정] 부여했던 SELECT 권한 회수
REVOKE SELECT ON EMPLOYEE FROM cyj_sample;

-- 5. [sample 계정] 다시 EMPLOYEE 테이블 조회 시도 
SELECT * FROM KH_CYJ.EMPLOYEE;
