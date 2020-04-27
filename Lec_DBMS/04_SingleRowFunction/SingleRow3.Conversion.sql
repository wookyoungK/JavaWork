--묵시적 자동 형변환 예
SELECT 1+1 FROM dual;
SELECT '1'+1 FROM dual; --문자가 숫자로 형변환 (자바와 반대이다).

SELECT TO_NUMBER('1') + 1 FROM dual;

--##############################################3
-- TO_CHAR 함수(날짜->문자)
SELECT SYSDATE, TO_CHAR(SYSDATE,'YYYY') 연도4자리, --SYSDATE 오늘날짜 가 찍힌느것  
			TO_CHAR(SYSDATE,'RRRR') 연도Y2K버그이후,
			TO_CHAR(SYSDATE, 'YY') 연도2자리,
			TO_CHAR(SYSDATE, 'YEAR') 연동영문 
FROM dual;

SELECT
		TO_CHAR(SYSDATE, 'DD' ) 일숫자2자리, 
		TO_CHAR(SYSDATE, 'DDTH' ) 몇번째날,
		TO_CHAR(SYSDATE, 'DAY' ) 요일, 
		TO_CHAR(SYSDATE, 'Dy' ) 요일앞자리
FROM DUAL;

SELECT 
TO_CHAR(SYSDATE, 'MON') 월3자리,  -- 7월
	TO_CHAR(SYSDATE, 'MONTH')  월전체,  -- 7월
	TO_CHAR(SYSDATE, 'MON', 'NLS_DATE_LANGUAGE=ENGLISH') 월영문3자리,  -- JUL
	TO_CHAR(SYSDATE, 'MONTH', 'NLS_DATE_LANGUAGE=ENGLISH')  "월영문전체(대)", -- JULY
	TO_CHAR(SYSDATE, 'month', 'NLS_DATE_LANGUAGE=ENGLISH')  "월영문전체(소)",  -- july
	TO_CHAR(SYSDATE, 'Month', 'NLS_DATE_LANGUAGE=ENGLISH')  "월영문전체(첫글자대)" -- July
FROM dual;


SELECT 
	TO_CHAR(SYSDATE, 'HH24') 시24hr,
	TO_CHAR(SYSDATE, 'HH')  시12hr,
	TO_CHAR(SYSDATE, 'MI') 분,
	TO_CHAR(SYSDATE, 'SS') 초,
	TO_CHAR(SYSDATE, 'HH:MI:SS')
	FROM dual;


--#4301
SELECT 
	TO_CHAR(SYSDATE,'YYYY/MM/DD HH24:MI:SS')
FROM dual;

--2017년10월25일 23시25분 46초 <--현재시간으로
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY"년"MM"월"DD"일 "HH24"시"MI"분"SS"초') 
FROM dual;

--#4302
SELECT name, TO_CHAR(BIRTHDAY, 'YYYY-MM-DD')생일
FROM T_STUDENT 
WHERE TO_CHAR(BIRTHDAY,'MM')='03';



-- TO_CHAR : 대소문자 지정예
SELECT
SYSDATE,
TO_CHAR(SYSDATE, 'Dy Month DD, YYYY', 'NLS_DATE_LANGUAGE=ENGLISH') AS A1,
TO_CHAR(SYSDATE, 'dy month dd, YYYY', 'NLS_DATE_LANGUAGE=ENGLISH') AS A2,
TO_CHAR(SYSDATE, 'DY MONTH DD, YYYY', 'NLS_DATE_LANGUAGE=ENGLISH') AS A3
FROM DUAl;


--##############################################3
--TO_CHAR()함수  - 숫자를 문자로 변환
SELECT 
	1234,
	TO_CHAR(1234,'99999') "9하나당 1자리",
	TO_CHAR(1234,'099999') "빈자리 0으로",
	TO_CHAR(1234,'$9999') "빈자리 $으로",
	TO_CHAR(1234.1234,'9999.99') "소수점이하2자리",
	TO_CHAR(1234213,'99,999,999') "천단위 구분기호"
FROM dual;


--#4303 
SELECT name, to_char(((pay * 12) + nvl(bonus,0)),'99,999') 연봉
FROM T_PROFESSOR 
WHERE DEPTNO =101;



--##############################################3
-- TO_number()함수 -숫자로 변환
SELECT to_number('123.44') FROM dual;

--##############################################3
--TO_DATE() 함수 -문자->날짜로 변환
SELECT To_DATE('2020-04-08', 'YYYY-MM-DD') FROM DUAL;

--#4304

SELECT NAME,to_char(HIREDATE,'YYYY-MM-DD') 입사일,TO_CHAR((pay*12), '99,999') 연봉, to_char((pay*12)+((pay*12)*0.1), '99,999') 인상후
FROM T_PROFESSOR
WHERE TO_CHAR(HIREDATE,'YYYY')<'2000'; 