-- 2021.06.11

-- 다중행(복수행, 집합) 함수
-- 하나이상의 행을 그룹으로 묶어 연산
-- *해당값이 null은 제외하고 연산
-- SUM, AVG, COUNT, MAX, MIN, STDDEV, VARIANCE

-- 사원테이블에서 사원의 수, 급여 총합, 급여 평균, 최대 급여, 최소 급여 출력
select count(*) as "사원의 수",
       sum(sal) as "급여 총합",
       round(avg(sal),2) as "급여 평균",
       max(sal) as "최대 급여", 
       min(sal) as "최소 급여",
       sum(comm) as "커미션 총합", -- 그룹함수는 null 제외하고 연산
       avg(comm) as "커미션 평균",
       count(comm) as "커미션의 수"
from emp
;

-- DISTINCT 중복제외
select count(job)
from emp;

select count(distinct job)
from emp;

-- 마당서적 book 테이블의 출판사 수
select count(distinct publisher)
from book
order by publisher;

-- group by 특정 컬럼을 기준으로 컬럼의 값별로 출력할 때 사용
-- select 그룹핑할 기준의 컬럼, 그룹함수
-- from 테이블
-- where
-- group by 그룹핑할 기준의 컬럼

-- 부서별 급여 평균
select avg(sal)
from emp
where deptno=10; -- 부서별로 반복

select deptno as "부서 인원"
     , count(*) as "부서 인원 수"
     , sum(sal) as "부서 급여총합"
     , round(avg(sal)) as "부서 급여평균"
     , max(sal) as "부서 최대급여"
     , min(sal) as "부서 최소급여"
from emp
group by deptno
order by deptno
;

-- 직급별
select distinct job
from emp;

select job, count(*)
from emp
group by job
order by job
;

-- 부서별로 사원 수와 커미션을 받는 사원들의 수
select deptno, count(*) as "사원의 수", count(comm) as "커미션을 받는 수"
from emp
group by deptno
order by deptno;

select * from emp;

-- having : group by의 그룹함수의 결과를 비교시 사용
-- select
-- from
-- where
-- group by
-- having 그룹함수 연산자 값 (= != > < >= <=)

-- 부서별 평균급여 2000이상인 부서번호, 부서별 평균급여
select deptno, round(avg(sal))
from emp
group by deptno
having avg(sal) >= 2000
order by deptno
;

-- 부서의 최대값, 최소값 출력, 최대 급여가 2900이상 부서만 출력
select deptno, max(sal), min(sal)
from emp
group by deptno
having max(sal) >= 2900
order by deptno
;

