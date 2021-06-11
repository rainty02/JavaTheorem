-- 2021.06.11
-- Join의 필요성

-- 원하는 정보가 두개이상의 테이블에 나누어져 있다면 두개이상의 테이블을 결합할 수 있음
-- 각 테이블의 스키마를 이어줌

select *
from emp, dept
where emp.deptno = dept.deptno
;


-- Cross join
-- 스키마의 합 : 집합의 곱연산과 같음
-- from 테이블, 테이블;

-- *equi join : 동일칼럼을 기준으로 조인
-- 외래키 = 참조R. 기본키 / 두 테이블에서 공통적으로 존재하는 컬럼의 값
-- emp.deptno = dept.deptno

-- 이름이 SCOTT인 사람의 부서명을 출력
-- 출력해야하는 컬럼을 가지는 테이블을 확인
-- 이름 : emp, 부서명 : dept

select e.ename, d.dname, d.deptno
from emp e, dept d
where e.deptno = d.deptno --and e.ename = 'SCOTT'
order by d.dname, e.ename
;

-- non-equi join : 동일칼럼이 없이 다른 조건을 사용하여 조인

-- outer join : 조인조건에 만족하지 않는 행도 나타냄
-- self join : 자기 자신을 조인(참조)
-- emp -> mgr 컬럼이 emp.empno 참조
select e.empno, e.ename, e.mgr, m.ename
from emp e, emp m
where e.mgr = m.empno(+) -- outer join
;




