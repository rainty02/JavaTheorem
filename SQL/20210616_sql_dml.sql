-- 20210616

-- DML

-- 테스트 테이블 생성
CREATE TABLE DEPT01
AS
SELECT * FROM DEPT WHERE 1=0;

-- 데이터입력 : 행단위 입력
-- INSERT INTO 테이블명 (컬럼명, ... ) VALUES (입력값, ... )
-- 입력하고자하는 컬럼과 입력값의 갯수 일치
-- 컬럼의 도메인과 입력값의 타입 일치
-- 기본키와 같이 NOT NULL인 경우 컬럼을 생략하면 안됨
SELECT * FROM DEPT01;
DESC DEPT01;

-- 1번부서 개발팀 서울
INSERT INTO DEPT01 (DEPTNO, DNAME, LOC)
            VALUES (10, '개발팀', '서울')
;

INSERT INTO DEPT01 (DEPTNO, DNAME, LOC)
            VALUES ('삼십', '개발팀', '서울')
;

INSERT INTO DEPT01 (DNAME, LOC)
            VALUES ('개발팀', '서울')
;

-- 데이터 저장할 컬럼기술을 생략 가능
-- 모든 컬럼의 데이터를 입력할 때
-- VALUES절의 데이터 순서 -> 테이블 생성시 정의된 컬럼의 순서 -> DESC 테이블명
DESC DEPT01;

INSERT INTO DEPT01 VALUES (20, '마케팅', '부산');

-- NULL 값 입력방법
-- NOT NULL 제약조건시 불가
-- 데이터를 입력하는 시점에 해당 컬럼 값을 모르거나 확정되지 않을 경우
-- 암시적 방법 : 컬럼명 리스트에 칼럼을 생략
-- 명시적 방법 : 컬럼값 리스트에 NULL 입력

DESC EMP;
INSERT INTO EMP (EMPNO, DEPTNO) VALUES (7777, 60);
SELECT * FROM EMP;
ROLLBACK;

DESC ORDERS;
INSERT INTO ORDERS (ORDERID, CUSTID, BOOKID) VALUES (11, 6, 11);


-- 서브쿼리를 이용한 데이터 입력
DROP TABLE DEPT02;
CREATE TABLE DEPT02
AS SELECT * FROM DEPT WHERE 1=0;
SELECT * FROM DEPT02;

-- 데이터 입력
INSERT INTO DEPT02
SELECT * FROM DEPT02 -- 자신의 데이터도 가능
;


-- 데이터 변경 : 행단위로 선택하고 변경하고자 하는 컬럼을 기술
-- UPDATE 테이블명 SET 컬럼명1=컬럼값1, 컬럼명2=컬럼값2, ... WHERE 행을 선택하는 조건;

CREATE TABLE DEPT03
AS SELECT * FROM DEPT;
SELECT * FROM DEPT03;

-- 모든 부서의 위치를 SEOUL로 이동
UPDATE DEPT03
SET LOC = 'SEOUL';
--WHERE
-- 10번 부서의 위치를 BUSAN으로 이동, 부서 이름도 DEV로 변경
UPDATE DEPT03
SET DNAME = NULL, LOC = 'BUSAN'
WHERE DEPTNO = 10;

-- EMP01 생성
DROP TABLE EMP01;
CREATE TABLE EMP01
AS SELECT * FROM EMP;

-- 모든 사원의 부서번호를 30번으로 수정
UPDATE EMP01
SET DEPTNO = 30;

-- 모든 사원의 급여를 10% 인상
UPDATE EMP01
SET SAL = SAL*1.1;

-- 모든 사원의 입사일을 오늘로 수정
UPDATE EMP01
SET HIREDATE = SYSDATE;
ROLLBACK;

SELECT * FROM EMP01;
-- 부서번호가 10번인 사원의 부서번호를 30번으로 수정
UPDATE EMP01
SET DEPTNO = 30
WHERE DEPTNO = 10;

-- 급여가 3000이상인 사원만 급여를 10% 이상
UPDATE EMP01
SET SAL = SAL*1.1
WHERE SAL >= 3000;

-- 1981년에 입사한 사원의 입사일을 오늘로 수정
UPDATE EMP01
SET HIREDATE = SYSDATE
WHERE SUBSTR(HIREDATE, 1, 2) = 81 -- '87' 자동형변환
;

-- SCOTT 사원의 부서번호는 30번으로 직급은 MANAGER로 한꺼번에 수정
UPDATE EMP01
SET DEPTNO = 30, JOB = 'MANAGER'
WHERE ENAME = 'SCOTT'
;

-- SCOTT 사원의 입사일자는 오늘, 급여를 50, 커미션 4000 수정
UPDATE EMP01
SET HIREDATE = SYSDATE, SAL = 50, COMM = 4000
WHERE ENAME = 'SCOTT'
;
SELECT * FROM EMP01;

-- 서브쿼리를 이용한 데이터 수정
-- 20번 부서의 지역명을 40번 부서의 지역명으로 변경
SELECT * FROM DEPT01;

TRUNCATE TABLE DEPT01;

INSERT INTO DEPT01
SELECT * FROM DEPT
;

UPDATE DEPT01
SET LOC = (SELECT LOC FROM DEPT01 WHERE DEPTNO = 40)
WHERE DEPTNO = 20;

-- 다중 컬럼 변경시 묶어서 사용 * 순서는 동일하도록
-- 20번부서의 부서명, 지역명 -> 10번과 동일 
UPDATE DEPT01
SET (DNAME, LOC) = (SELECT DNAME, LOC FROM DEPT WHERE DEPTNO = 10)
WHERE DEPTNO = 20;


-- 데이터의 삭제 : 행단위 삭제
-- DELETE FROM 테이블명 WHERE 조건;

-- DEPT01 테이블의 모든 데이터를 삭제
SELECT * FROM DEPT01;
SELECT * FROM EMP01;
DELETE FROM DEPT01;

-- 이름이 SCOTT인 사원을 삭제
DELETE FROM EMP01 WHERE ENAME = 'SCOTT';

-- 사원 테이블에서 부서명이 SALES인 사원을 모두 삭제
DELETE FROM EMP01 WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = 'SALES');

