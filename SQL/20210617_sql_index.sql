-- 20210617

-- INDEX
-- 빠른 검색을 위해서 사용
-- 테이블 전체가 아닌 인덱스로 설정된 값만 검색하므로 검색에 용이
-- B*트리 구조
-- 인덱스를 생성하기 위한 시간, 물리적인 추가공간 필요
-- 인덱스가 생성된 후 새로운 행을 추가하거나 삭제할 경우 인덱스로 사용된 값도 함께 변경하는 경우 발생
-- 너무 많은 인덱스(5개이상)가 있는 경우 DML 작업이 성능저하가 되므로 항상 사용되는 건 아님

-- 장점 - 검색속도가 빨라짐, 시스템에 걸리는 부하를 줄여 시스템 전체 성능을 향상
-- 단점 - 물리적인 추가공간, 인덱스 생성에 시간이 걸림, DML 작업시 성능저하

-- 인덱스는 기본키나 유일키 자동 생성

-- emp01 테이블을 복사, 로우를 계속 복사
drop table emp01;
create table emp01
as select * from emp;

insert into emp01 select * from emp01;

insert into emp01 (empno, ename) values (7777, 'KING');
insert into emp01 (empno, ename) values (7777, 'SON');

select * from emp01 where ename = 'SON';
select * from emp01;

-- emp01 테이블에 ename 컬럼을 index 설정
create index index_emp01_ename
on emp01 (ename);


