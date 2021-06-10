-- 2021.06.10

-- 특정 데이터 검색 : 행 검색 -> 컬럼 선택

-- 10번 부서의 사원 리스트를 출력
-- 10번 부서 -> where deptno=10
select *
from emp
where deptno=30
;

-- 데이터 - 문자열 검샘
-- 명령어들은 대소문자 구분이 없지만
-- 작은 따옴표 안에 들어가는 데이터는 대소문자를 구분
select *
from emp
where ename = 'SCOTT'
;
select *
from emp
where ename = 'scott'
;

-- 날짜타입의 데이터 비교시에도 작은 따옴표를 이용해야함
select *
from emp
where hiredate = '96/11/17' -- 96/11/17 X
;

-- 논리연산자 : and or not
-- 10번 부서의 관리자를 찾아 출력
select *
from emp
where deptno=10 and job='MANAGER'
;

-- 10번 부서의 직원들과 관리자 출력
select *
from emp
where deptno=10 or job='MANAGER'
;

-- 10번 부서의 직원을 제외한 나머지 직원
select *
from emp
where not deptno=10
;

-- 범위 연산 - 논리연산자 이용, between a and b
-- between a and b : a이상 b이하
-- 2000이상 3000이하 급여를 받는 직원의 리스트
select ename, sal, job, sal*1.2 as upsal
from emp
--where sal >= 2000 and sal <= 3000
where sal between 2000 and 3000
;

-- between 날짜도 연산 가능
-- 1981년에 입사한 사원 리스트
SELECT *
FROM emp
--where hiredate >= '81/01/01' and hiredate <= '81/12/31'
where hiredate between '81/01/01' and '81/12/31'
order by hiredate -- desc
;

-- IN 연산자 : 여러개의 or 연산 사용시 대체가능
-- 컬럼명 in(a,b,c,) a 또는 b 또는 c
select *
from emp
--where comm = 300 or comm = 500 or comm = 1400
where comm in(300,500,1400)
;

-- 와일드카드 _, %
-- 패턴 검색 : 키워드 검색시 많이 사용 - 게시판
-- 컬럼 like '%'
-- ename like 'F%' - F로 시작하는 문자열
-- ename like '%F' - F로 끝나는 문자열
-- ename like '%F%' - F를 포함하는 문자열
-- 'java' 단어를 포함하는지 - title like '%java%'

-- F로 시작하는 이름
select *
from emp
where ename like 'F%'
;
-- S로 끝나는 이름
select *
from emp
where ename like '%E%'
;

-- 두번째자리 A
select *
from emp
--where ename like'_A%'
-- 세번째자리 A
--where ename like '__A%'
-- not like : 제외
where ename not like '__A%'
;

-- null 값을 확인하는 연산자 -> is null, is not null
-- 커미션이 등록되어있지않은 사원의 리스트
select *
from emp
--where comm is null
where comm is not null
order by comm
;

-- 결과 행의 정렬 : order by 컬럼 [asc오름|desc내림]
-- 급여가 작은 사원부터 출력 : 오름
select *
from emp
--order by sal asc
order by sal -- 정렬의 기본값은 오름차순
;
-- 급여가 큰 사원
select ename, sal
from emp
order by sal desc
;

-- 급여가 큰 사원부터 출력, 급여가 같은 사원은 이름을 오름차순
select ename, sal
from emp
order by sal desc, ename
;







