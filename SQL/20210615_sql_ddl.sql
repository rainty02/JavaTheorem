-- 20210615

-- DDL 데이터 정의어

-- 테이블 생성 : CREATE TABLE
-- 테이블 수정 : ALTER TABLE
-- 테이블 삭제 : DROP TABLE

-- CREATE TABLE
--((컬럼이름 타입(사이즈), (컬럼이름 타입(사이즈) 제약조건 정의, ... ) 컬럼 타입정의와 제약조건정의를 함께
--((컬럼이름 타입(사이즈), (컬럼이름 타입(사이즈) , 제약조건 정의, ... ) 컬럼 타입정의와 제약조건정의를 별개로

-- 사원번호, 사원이름, 급여 3개의 컬럼으로 구성된 EMP01 테이블 생성
CREATE TABLE EMP01 (
    EMPNO NUMBER(4), -- 사원번호
    ENAME VARCHAR(20), -- 사원이름
    SAL NUMBER(6,2) -- 급여
);

-- 서브쿼리를 사용해 이미 존재하는 테이블과 동일한 구조와 내용을 갖는 새로운 테이블 생성가능
-- *제약조건은 제외
CREATE TABLE EMP02
AS
SELECT * FROM EMP
;

CREATE TABLE EMP03
AS
SELECT EMPNO, ENAME, SAL FROM EMP
;

CREATE TABLE EMP04
AS 
SELECT * FROM EMP WHERE DEPTNO = 30
;

CREATE TABLE EMP05
AS
SELECT * FROM EMP WHERE 1 = 2 -- TRUE, FALSE를 이용해 전체 혹은 구조만 가져올 수 있음
;

SELECT * FROM EMP05;


-- ALTER TABLE 테이블 구조 변경
-- ADD COLUMN - 새로운 칼럼 추가
-- ALTER TABLE {테이블명} ADD
-- ALTER TABLE {테이블명} MODIFY
-- ALTER TABLE {테이블명} DROP

-- ADD
-- 새로운 칼럼은 맨 마지막에 추가되므로 원하는 위치에 넣을 수 없음
-- 기존에 로우가 존재한다면 추가된 컬럼에는 NULL값이 입력됨

-- EMP01 테이블에 JOB컬럼 추가
ALTER TABLE EMP01
ADD(JOB VARCHAR2(9))
;

-- EMP01 테이블의 JOB컬럼의 사이즈 수정 9 -> 30
ALTER TABLE EMP01
MODIFY(JOB VARCHAR2(130) NOT NULL)
;
DESC EMP01;

-- EMP01 테이블의 JOB컬럼 삭제
ALTER TABLE EMP01
DROP COLUMN JOB
;

-- 테이블 삭제
DROP TABLE EMP02;

-- 새로운 테이블 생성
CREATE TABLE EMP02
AS
SELECT * FROM EMP
;

-- 모든 행을 삭제하는 TRUNCATE : *롤백이 안된다
TRUNCATE TABLE EMP02;

-- 기존에 사용하던 테이블의 이름을 변경하느 RENAME 현재이름 TO 새이름;
RENAME EMP01 TO TEST;


-- 데이터 무결성을 위한 제약조건
-- 도메인 제약
-- 개체무결성 제약(기본키 제약조건)
-- 참조무결성 제약(외래키 제약조건)

-- 부적절한 자료가 입력되는 것을 방지
-- NOT NULL : NULL값 허용하지 않음
-- UNIQUE : 중복된 값 허용X, 항상 유일한 값을 갖도록 함
-- PRIMARY KEY : NULL을 허용하지 않고 중복된 값을 허용하지 않음, NOT NULL+UNIQUE
-- FOREIGN KEY : 참조되는 테이블의 칼럼의 값이 존재하면 허용
-- CHECK : 저장가능한 데이터 값의 범위나 조건을 지정하여 설정한 값만 허용

-- 제약조건 지정하기
-- 컬럼명 데이터타입(사이즈), 제약조건
-- 컬럼명 데이터타입(사이즈) 제약조건 (NOT NULL은 컬럼레벨에서만 지정가능)

DROP TABLE EMP02;

CREATE TABLE EMP02 (
    EMPNO NUMBER(4) PRIMARY KEY,--NOT NULL UNIQUE,
    ENAME VARCHAR(20) NOT NULL,
    SAL NUMBER(6,2) CHECK (SAL > 500 AND SAL < 5000),
    JOB VARCHAR(20) DEFAULT '미지정',
    DEPTNO NUMBER REFERENCES DEPT(DEPTNO) -- 참조 테이블이름(PK컬럼)
);

CREATE TABLE EMP02 ( -- 컬럼레벨 제약조건 설정
    EMPNO NUMBER(4) CONSTRAINT EMP02_EMPNO_PK PRIMARY KEY,
    ENAME VARCHAR(20) CONSTRAINT EMP02_ENAME_NN NOT NULL,
    SAL NUMBER(6,2) CONSTRAINT EMP02_SAL_CK CHECK (SAL > 500 AND SAL < 5000),
    JOB VARCHAR(20) DEFAULT '미지정',
    DEPTNO NUMBER CONSTRAINT EMP02_DEPTNO_FK REFERENCES DEPT(DEPTNO)
);

CREATE TABLE EMP03 ( -- 테이블레벨 제약조건 설정
    EMPNO NUMBER(4),
    ENAME VARCHAR(20) CONSTRAINT EMP03_ENAME_NN NOT NULL,
    SAL NUMBER(6,2) CONSTRAINT EMP03_SAL_CK CHECK (SAL > 500 AND SAL < 5000),
    JOB VARCHAR(20),
    DEPTNO NUMBER,
    -- 제약조건 정의
    CONSTRAINT EMP03_EMPNO_PK PRIMARY KEY(EMPNO),
    CONSTRAINT EMP03_DEPTNO FOREIGN KEY (DEPTNO) REFERENCES DEPT(DEPTNO)
);

DESC DEPT;
INSERT INTO EMP02(EMPNO, ENAME, SAL, JOB, DEPTNO) VALUES (3000, 'SON', 8000, 'MANAGER', 40);
INSERT INTO EMP02 VALUES (NULL, NULL, 10000, 'MANAGER'); -- 모든 컬럼에 값을(순서대로) 넣을땐 컬럼명 생략가능
SELECT  * FROM EMP02;


