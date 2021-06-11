-- 2021.06.10
-- function : 단일행 함수, 집합(다중행)함수
-- 단일행 함수 : 하나의 행이 포함하는 특정 컬럼의 값 하나를 처리, 반환
-- 다중행(집합) 함수 : 여러 행의 특정 컬럼값들을 대상으로 연산, 반환


-- 숫자 함수
select abs(10), abs(-10)
from dual
;
-- Floor 소수점이하 절사
select FLOOR(15.7)
from dual;
-- Round 반올림 (소수점 기준으로 양수는 소수방향, 음수는 정수방향)
select ROUND(15.193,1), ROUND(15.193,-1), ROUND(15.193)
from dual;
-- Trunc 소수점이하 절사 (,숫자로 절사부분 지정)
select TRUNC(15.79,1)
from dual;
-- Mod 나머지연산 (컬럼/값, 나누려는값)
select MOD(11,4)
from dual;
select sal, mod(sal, 4)
from emp;

-- 문자 함수
-- concat(문자, 문자) -> ''||'' 연산과 같음, 문자 합침
select concat('abc', 'efg'), 'abc'||'efg'
from dual;
-- substr : 문자열 추출
-- substr(문자열, 시작위치, 길이)
select SUBSTR('ABCDEFG',3,4)
from dual;
-- replace : 특정 문자열(패턴) 다른 문자열(패털)으로 변경
select REPLACE('JACK and JUE','J','BL')
from dual;

select sysdate
from dual;

-- 2021.06.11

-- 날짜 -> 문자
-- to_char(날짜 데이터(컬럼), '출력형식')
-- 날짜 YYYY 4자리 / YY 2자리 / MM 월-숫자 / MON 월-알파벳 / DAY 요일 / DY 요일약어
-- 시간 출력형식 AM, A.M / PM, P.B / HH(12시간) HH24(24시간) / MI / SS
select SYSDATE, to_char(sysdate, 'YYYY-MM-DD'), to_char(sysdate, 'YYYY.MM.DD. HH24:MI:SS')
from dual
;
select ename, to_char(hiredate, 'YYYY.MM.DD.') as hiredate
from emp
;
select orderid, orderdate, to_char(orderdate, 'YY.MM.DD')
from orders
;

-- 숫자 -> 문자
-- to_char(숫자, 포맷)
-- 0(자릿수가 맞지 않을 경우 0으로 출력), 9(자릿수가 맞지 않아도 채우지 않음)
-- L(통화, 설치된 언어에 따라 기본값이 달라짐) ,.(소수점) ,,(천단위)
select to_char(123456, '0,000,000,000'), to_char(123456, 'L9,999,999,999')
from dual;

select ename, to_char(sal*1100, 'L999,999,999')
from emp;

-- 문자 -> 숫자
-- to_number(문자열, 패턴)
select  to_number('1,000,000', '9,999,999'),
        to_number('1,000,000', '9,999,999')+100000
from dual;

-- 문자 -> 날짜
-- to_date(문자열, 패턴)
select  to_date('2012-05-17', 'YYYY-MM-DD'),
        trunc(sysdate - to_date('2012-05-17', 'YYYY-MM-DD'))
from dual;

-- decode : 분기를 위해 사용, 자바 swicth-case 유사
-- decode(컬럼, 조건1 값, '조건1이 참일 때 반환값'
--           , 조건2 값, '조건2가 참일 때 반환값'
--           , ...........................)
-- emp 테이블에서 부서번호에 맞는 부서이름 출력
select * from dept;
-- 10	ACCOUNTING
-- 20	RESEARCH
-- 30	SALES
-- 40	OPERATIONS
select ename, deptno, decode(deptno, 10, 'ACCOUNTING',
                                     20, 'RESEARCH',
                                     30, 'SALES',
                                     40, 'OPERATIONS') as dname
from emp
order by ename
;

-- 직급에 따른 급여를 인상하도록하자
-- 직급이 'ANALYST' 5%, 'SALESMAN' 10%, 'MANAGER' 15%, 'CLERK' 20%
select ename, sal,
       decode(job, 'ANALYST', sal*1.05,
                   'SALESMAN', sal*1.1,
                   'MANAGER', sal*1.15,
                   'CLERK', sal*1.2) as upsal
from emp
;

-- case 함수 : 분기할 때 사용
-- case when 조건식 then 참일 때 값
select ename, deptno,
       case when deptno = 10 then 'ACCOUNTING'
            when deptno = 20 then 'RESEARCH'
            when deptno = 30 then 'SALES'
            when deptno = 40 then 'OPERATIONS'
       END AS DEPTNAME
from emp
order by deptname desc, ename;
