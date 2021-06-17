-- 20210617

-- SEQUENCE
-- 연속된 숫자 생성하는 객체
-- 설정을 통해 일련번호를 생성 ->  기본키가 대리키인 경우 입력되는 값으로 사용

-- SEQUENCE : 번호 재생기
create sequence pi_idx_pk;

-- 현재 스퀀스값의 다음 값을 반환 - pk별로 각각 만들어서 사용
select pi_idx_pk.nextval
from dual;

-- 현재 시퀀스값 - fk
select pi_idx_pk.currval
from dual;

-- dept 테이블 복사 -> deptno에 들어갈 데이터 시퀀스 생성 -> insert 테스트
drop table dept03;
create table dept03
as select * from dept where 1=0;
select * from dept03;

-- sequence 생성
create sequence dept_deptno_seq
start with 10
increment by 10;

-- dept03 저장
insert into dept03 values (dept_deptno_seq.nextval, 'dev', 'seoul');
select * from dept03;



























