--숫자 관련 단일행 함수들.

--ROUND() 소수점 첫재짜리 
SELECT 
	'ROUND',
	ROUND(12.34) "(12.34)",
	ROUND(12.55) "(12.55)", 
	ROUND(12.556, 2) "(12.556,2)", --소수점 3째자리에서 반올림 
	ROUND(16.345, -1) "(16.345, -1)" --1의 자리에서 반올림 
FROM 
	DUAL;
	
-- TRUNC() 함수
SELECT
	'TRUNC',
	TRUNC(12.345) "(12.345)",         -- 소수점 자름 (디폴트)
	TRUNC(12.345, 2) "(12.345, 2)",   -- 소수점 3자리부터 자름
	TRUNC(12.345, -1) "(12.345, -1)"  -- 1의 자리부터 자름
FROM
	dual;

-- ROUND() ,TRUNC(), CEIL(),FLOOR()
SELECT
	'12.5'  "12.5",
	ROUND(12.5)	"ROUND",
	TRUNC(12.5) "TRUNC",
	CEIL(12.5) "CEIL", --12.5보다 큰수 중 가장작은 정수
	FLOOR(12.5) "FLOOR" --12.5보다 작은수 중 가장큰정수 
FROM
	dual;

SELECT
	'-12.5'  "-12.5",
	ROUND(-12.5)	"ROUND",
	TRUNC(-12.5) "TRUNC",
	CEIL(-12.5) "CEIL",
	FLOOR(-12.5) "FLOOR"
FROM
	dual;

--오라클은 % 연산자 없뜸.
--MOD() : 나머지 연산
SELECT 
	MOD(12,10) "MOD(12,10)",
	MOD(12.6,4.1) "MOD(12.6,4.1)"
FROM dual;

--POWER() 제곱
SELECT 
	POWER(2,3) "POWER(2,4)",
	POWER(-3,3) "POWER(-3,3)",
	POWER(10,-2) "POWER(10,-2)", 
	POWER(2, 1/2) "POWER(2,1/2)" 
FROM dual;


