-- 32. EQUI 조인을 사용하여 SCOTT 사원의 부서번호와 부서 이름을 출력하시오.
SELECT E.ENAME, D.DEPTNO, D.DNAME
FROM EMP E, DEPT D
WHERE E.ENAME = 'SCOTT' AND E.DEPTNO = D.DEPTNO
;


-- 33. INNER JOIN과 ON 연산자를 사용하여
-- 사원 이름과 함께 그 사원이 소속된 부서이름과 지역 명을 출력하시오.
SELECT E.ENAME, D.DNAME, D.LOC
FROM EMP E INNER JOIN DEPT D
ON E.DEPTNO = D.DEPTNO
;

-- 36. 조인과 WildCARD를 사용하여
-- 이름에 ‘A’가 포함된 모든 사원의 이름과 부서명을 출력하시오.
SELECT E.ENAME, D.DNAME
FROM EMP E JOIN DEPT D
USING (DEPTNO)
WHERE E.ENAME LIKE '%A%'
;
SELECT E.ENAME, D.DNAME
FROM EMP E, DEPT D
WHERE E.ENAME LIKE '%A%' AND E.DEPTNO = D.DEPTNO
;

-- 37. JOIN을 이용하여
-- NEW YORK에 근무하는
-- 모든 사원의 이름, 업무, 부서번호 및 부서명을 출력하시오.
SELECT E.ENAME, E.JOB, E.DEPTNO, D.DNAME
FROM EMP E JOIN DEPT D
ON D.LOC = 'NEW YORK'
ORDER BY E.DEPTNO, E.JOB, E.ENAME
;

-- 38. SELF JOIN을 사용하여
-- 사원의 이름 및 사원번호, 관리자 이름을 출력하시오.
SELECT E.ENAME, E.EMPNO, M.ENAME AS "MANAGER"
FROM EMP E, EMP M
WHERE E.MGR = M.EMPNO
ORDER BY MANAGER
;

-- 39. OUTER JOIN, SELF JOIN을 사용하여
-- 관리자가 없는 사원을 포함하여
-- 사원번호를 기준으로 내림차순 정렬하여 출력하시오.
SELECT E.EMPNO, E.ENAME, E.MGR
FROM EMP E, EMP M
WHERE E.MGR = M.EMPNO(+)
;

-- 40. SELF JOIN을 사용하여
-- 지정한 사원의 이름, 부서번호, 지정한 사원과
-- 동일한 부서에서 근무하는 사원을 출력하시오. ( SCOTT )
SELECT E.ENAME, E.DEPTNO, M.ENAME
FROM EMP E, EMP M
WHERE E.DEPTNO = M.DEPTNO AND E.ENAME = 'SCOTT' AND M.ENAME != 'SCOTT'
;

-- 41. SELF JOIN을 사용하여
-- WARD 사원보다 늦게 입사한 사원의 이름과 입사일을 출력하시오.
SELECT M.ENAME, M.HIREDATE
FROM EMP E, EMP M
WHERE  E.ENAME = 'WARD' AND E.HIREDATE < M.HIREDATE
ORDER BY HIREDATE
;

-- 42. SELF JOIN 을 사용하여
-- 관리자보다 먼저 입사한 모든 사원
-- 의 이름 및 입사일을 관리자의 이름 및 입사일과 함께 출력하시오.
SELECT E.ENAME, E.HIREDATE, M.ENAME, M.HIREDATE
FROM EMP E, EMP M
WHERE E.HIREDATE < M.HIREDATE AND E.MGR = M.EMPNO 
;​
