-- 1. phoneInfo_basic 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL

DESC PHONEINFO_BASIC;
SELECT * FROM PHONEINFO_BASIC;
-- INSERT
INSERT INTO PHONEINFO_BASIC (IDX, FR_NAME, FR_TEL, FR_EMAIL, FR_ADDRESS, FR_REDATE)
VALUES (1, '박지성', '010-1234-5678', 'PJS@GMAIL.COM', '서울', '2021-06-01');
-- 날짜 생략
INSERT INTO PHONEINFO_BASIC (IDX, FR_NAME, FR_TEL, FR_EMAIL, FR_ADDRESS)
VALUES (2, '손흥민', '010-9123-4567', 'SHM@NAVER.COM', '영국');
-- 컬럼 생략
INSERT INTO PHONEINFO_BASIC
VALUES (3, '이강인', '010-8912-3456', 'LGI@HANMAIL.NET', '호주', '2021-01-01');


-- SELECT 
SELECT FR_NAME, FR_TEL
FROM PHONEINFO_BASIC
WHERE IDX = 1;


-- UPDATE
UPDATE PHONEINFO_BASIC
SET FR_NAME = '박지성'
WHERE IDX = 3;

-- 컬럼
UPDATE PHONEINFO_BASIC
SET (FR_NAME, FR_TEL) = (SELECT FR_NAME, FR_TEL FROM PHONEINFO_BASIC WHERE IDX = 2)
WHERE FR_NAME = '이강인';

-- 서브쿼리
UPDATE PHONEINFO_BASIC
SET FR_NAME = '손흥민'
WHERE FR_ADDRESS = (SELECT FR_ADDRESS FROM PHONEINFO_BASIC WHERE IDX = 1);


-- DELETE
DELETE FROM PHONEINFO_BASIC
WHERE FR_NAME = '손흥민';

DELETE FROM PHONEINFO_BASIC
WHERE FR_REDATE = (SELECT FR_REDATE FROM PHONEINFO_BASIC WHERE IDX = 3);



-- 2. phoneinfo_univ 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL
DESC PHONEINFO_UNIV;
SELECT * FROM PHONEINFO_UNIV;

-- INSERT
INSERT INTO PHONEINFO_UNIV (IDX, FR_U_MAJOR, FR_U_YEAR, FR_REF) VALUES (1, '컴퓨터공학', 2, 1);
INSERT INTO PHONEINFO_UNIV VALUES (2, '사회체육', 3, 2);
INSERT INTO PHONEINFO_UNIV VALUES (3, '건축', 4, 3);


-- SELECT
SELECT B.FR_NAME, U.FR_U_MAJOR, U.FR_U_YEAR
FROM PHONEINFO_BASIC B, PHONEINFO_UNIV U
WHERE B.IDX = U.FR_REF;

SELECT B.FR_NAME, U.FR_U_MAJOR, U.FR_U_YEAR
FROM PHONEINFO_BASIC B, PHONEINFO_UNIV U
WHERE U.FR_U_MAJOR = '건축';


-- UPDATE
UPDATE PHONEINFO_UNIV
SET FR_U_YEAR = 4;

UPDATE PHONEINFO_UNIV
SET FR_U_YEAR = 1
WHERE IDX = (SELECT IDX FROM PHONEINFO_UNIV WHERE FR_U_MAJOR = '건축');

-- DELETE
DELETE FROM PHONEINFO_UNIV
WHERE IDX = 3;

DELETE FROM PHONEINFO_UNIV
WHERE FR_U_YEAR = (SELECT FR_U_YEAR FROM PHONEINFO_UNIV WHERE IDX = 2);

-- 3. phoneinfo_com 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL
DESC PHONEINFO_COM;
SELECT * FROM PHONEINFO_COM;

-- INSERT
INSERT INTO PHONEINFO_COM (IDX, FR_C_COMPANY, FR_REF) VALUES (1, '맨유', 1);
INSERT INTO PHONEINFO_COM VALUES (2, '맨시티', 2);
INSERT INTO PHONEINFO_COM (IDX, FR_REF) VALUES (3, 3);


-- SELECT
SELECT B.FR_NAME, C.FR_C_COMPANY
FROM PHONEINFO_BASIC B, PHONEINFO_COM C
WHERE B.IDX = 1;

SELECT B.FR_NAME, C.FR_C_COMPANY, U.FR_U_MAJOR
FROM PHONEINFO_BASIC B, PHONEINFO_COM C, PHONEINFO_UNIV U
WHERE B.IDX = 1 AND C.IDX = 1 AND U.IDX = 1;


-- UPDATE
UPDATE PHONEINFO_COM SET FR_C_COMPANY = (SELECT FR_C_COMPANY FROM PHONEINFO_COM WHERE FR_REF = 3) WHERE FR_REF = 2;
UPDATE PHONEINFO_COM SET FR_C_COMPANY = '맨시티' WHERE IDX = 3;

-- DELETE
DELETE FROM PHONEINFO_COM WHERE IDX = 3;
DELETE FROM PHONEINFO_COM WHERE IDX = (SELECT IDX FROM PHONEINFO_COM WHERE FR_C_COMPANY = NULL);

--------------------------------------------------------

-- BASIC INSERT : CREATE
DESC phoneinfo_basic;
insert into phoneinfo_basic
values (1, 'KING', '010-0000-0000', 'king@gmail.com', 'KOREA', sysdate)
;
insert into phoneinfo_basic (idx, fr_name, fr_phonenumber)
values (2, 'SCOTT', '010-9999-9999')
;

-- SELECT : READ
select * from phoneinfo_basic;
select * from phoneinfo_basic where idx=2;

-- UPDATE : UPDATE
-- SCOTT의 이메일을 업데이트, 주소도 업데이트
-- SCOTT 의 idx -> 2
 update phoneinfo_basic
 set fr_email='scott@naver.com', fr_address='서울'
 where idx=2 --fr_name='SCOTT'
;

-- DELETE : DELETE
delete from phoneinfo_basic
where idx=1
;


-- UNIV INSERT : CREATE 데이터 생성
-- 대학친구의 정보를 입력
-- 1 basic 정보 입력
insert into phoneinfo_basic
values (PI_IDX_PK.nextval, 'SON', '010-1111-1111', 'son@gmail.com', 'KOREA', sysdate)
;
-- 2. univ 정보 입력
insert into phoneinfo_univ
values (PI_U_IDX_PK.nextval, 'COMPUTER', 4, PI_IDX_PK.currval)
;

-- SELECT : READ   데이터 검색
select pb.idx, pu.fr_ref, pu.idx, fr_name, pu.fr_u_major, pu.fr_u_year
from phoneinfo_basic pb , phoneinfo_univ pu
where pb.idx=pu.fr_ref
;

-- UPDATE : UPDATE 데이터 수정
-- 전공과 학년을 수정, idx 또는 외래키
update phoneinfo_univ
set fr_u_major='KOR', fr_u_year=1
where idx=1
;

-- DELETE : DELETE 데이터 삭제
delete from phoneinfo_univ
where idx=1
;
delete from phoneinfo_basic
where idx=3
;


-- COM INSERT : CREATE
insert into phoneinfo_basic
values (pi_idx_pk.nextval, 'PARK', '010-7777-7777', 'park@gmail.com', 'LONDON', sysdate)
;
insert into phoneinfo_com values (PI_C_IDX_PK.nextval, 'NAVER', pi_idx_pk.currval);

-- SELECT : READ
select fr_name, pb.fr_phonenumber, pb.fr_email, pb.fr_address, pc.fr_c_company
from phoneinfo_basic pb , phoneinfo_com pc
where pb.idx=pc.fr_ref
;

-- UPDATE : UPDATE
-- 회사정보를 수정
update phoneinfo_com
set fr_c_company='GOOGLE'
where idx=1
;

-- DELETE : DELETE
delete from phoneinfo_com
where idx=1
;
delete from phoneinfo_basic
where idx=4
;

-- 전체 친구 정보
select *
from phoneinfo_basic pb , phoneinfo_univ pu, phoneinfo_com pc
where pb.idx=pu.fr_ref(+) and pb.idx=pc.fr_ref(+)
;



-- 대학친구, 회사 친구 테이블 -> 기본키(대리키) -> sequence 생성 -> insert 개선


-- SEQUENCE : 번호 재생기
create sequence pi_idx_pk;
create sequence pi_u_idx_pk start with 1 increment by 1;
create sequence pi_c_idx_pk start with 1 increment by 1;



















