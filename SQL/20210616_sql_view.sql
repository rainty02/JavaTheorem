-- 20210616

-- view

-- 자주 사용되는
-- 30번 부서에 소속된 사원들의 부서번호를 출력하기 위한
-- select문을 하나의 뷰로 정의

create or replace view emp_view30
as
select empno, ename, deptno
from emp
where deptno = 30
;

select * from emp_view30
where ename = 'JAMES'
;

-- 삭제
drop view emp_view30;


-- 인라인 뷰를 이용한 top3 구하기
select rownum, ename
from emp
--order by hiredate
;

-- 입사일이 빠른 사람 5명만 얻어오기
select rownum, ename, hiredate
from (select * from emp order by hiredate)
where rownum < 6
;

create or replace view view_hir
as
select * from emp order by hiredate;

select rownum, ename, hiredate from view_hir;

select rownum, ename, hiredate
from view_hir
where rownum < 6
order by ename;


