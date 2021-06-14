-- 2021.06.11
-- Join의 필요성

-- 원하는 정보가 두개이상의 테이블에 나누어져 있다면 두개이상의 테이블을 결합할 수 있음
-- 각 테이블의 스키마를 이어줌

select *
from emp, dept
where emp.deptno = dept.deptno -- equi join
;

-- Join : 스키마의 합
-- Cross join
-- 스키마의 합 : 집합의 곱연산과 같음 (모든 경우의 수)
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


-- outer join
-- emp -> mgr 컬럼이 emp.empno 참조
select e.empno, e.ename, e.mgr, m.ename
from emp e, emp m
where e.mgr = m.empno(+) -- 표현하고자 하는 컬럼이 테이블의 반대쪽, null 값을 가지는 위치에 (+)
;

--[left | right | full] outer join 출력하고자 하는 테이블 방향 설정
select e.ename, e.mgr, m.ename as "관리자"
from emp m right outer join emp e
on e.mgr = m.empno
;


-- non equi join
-- 동등 비교가 아닌 크가 작다와 같은 비교로 조인의 조건을 작성
select * from salgrade;

select e.ename, e.sal, s.grade, s.losal, s.hisal
from emp e, salgrade s
--where e.sal >= s.losal and e.sal <= s.hisal
where e.sal between s.losal and s.hisal
order by e.ename;


-- ansi cross join
select * 
from emp cross join dept
;

-- ansi inner join
-- 오라클 equi join = 같은 컬럼 비교
select *
from emp e inner join dept d -- inner 생략가능
on e.deptno = d.deptno -- 조건은 on
where e.ename = 'SCOTT'
;

-- on절을 생략하고 using절을 이용하면 조건식을 간략하게 처리
-- 비교하는 컬럼의 이름이 같을 때
select *
from emp e inner join dept d -- inner 생략가능
--on e.deptno = d.deptno
using (deptno)
where e.ename = 'SCOTT'
;
-- 이름이 같고 속성이 같다면
-- natural join
select *
from emp natural join dept
;




select * from orders;
select * from customer;
select * from book;
-- 구매내역(orders), 구매자이름(customer), 책이름(book)
select o.orderid, c.name, b.bookname
from orders o, customer c, book b
where o.custid = c.custid and o.bookid = b.bookid
order by o.orderid
;

-- 회원별 구매내역 출력
select c.name, count(o.orderid) as "구매횟수", avg(saleprice)
from orders o, customer c
where o.custid(+) = c.custid
group by c.name
order by c.name
;

