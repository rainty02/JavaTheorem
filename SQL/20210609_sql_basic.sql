-- 2021.06.09
-- SQL

-- Describe 칼럼명
-- 칼럼의 정보
describe emp;
desc dept;

-- Select 컬럼명, 컬럼명 from 테이블명;
-- 사원의 사원 번호와 사원 이름을 출력
select ename, empno, sal, deptno
from emp
;

-- Select 컬럼의 산술연산 가능 : 컬럼과 숫자, 컬럼과 컬럼 연산가능
-- 사원이름, 월 급여, 연봉계산결과값 (sal * 12)
select ename, sal, sal*12 as ysal
from emp
;

select sal, comm, sal*comm, sal*12, sal/10, sal+100, sal-100
from emp
;

-- 사원의 이름, 직급, 급여, 커미션, 연봉(급여*12), 연봉(급여*12*커미션)
select ename, job, sal, comm, sal*12 as ysal1, sal*12+comm as ysal2
from emp
;

-- 개선 : null 값을 0으로 치환해서 연산
-- nvl(컬럼명, 기본값) : 컬럼의 값이 null일 때 기본값으로 치환
select ename, job, sal, nvl(comm, 0), sal*12 as ysal1, sal*12+nvl(comm, 0) as ysal2
from emp
;

-- 컬럼과 문자열을 붙이는 연산 || 이용
-- sql에서 문자열을 표현 -> '작은 따옴표' 이용
select ename ||' is a '|| job
from emp
;

-- 결과 리스트에서 중복된 값을 제거 : Distinct
select deptno
from emp
;

select distinct deptno
from emp
;

select distinct deptno, job
from emp
order by job -- order by 정렬 : 행의 정렬
;

-- select문 특정값 찾기
-- where 컬럼명 비교연산자 값;
-- 사원이름, 번호, 급여
select ename, empno, sal
from emp
where sal >= 3000;