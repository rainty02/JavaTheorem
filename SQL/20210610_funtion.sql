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