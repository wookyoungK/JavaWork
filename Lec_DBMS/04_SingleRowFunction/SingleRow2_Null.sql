SELECT *FROM T_PROFESSOR;

--NULL 값 과의 연산 결과는 NULL 이다. 시험 잘나옴
SELECT name,pay,bonus,pay+bonus
FROM  T_PROFESSOR;

--그룹 함수에서는 동작  , null은 연산에서 제외되어 동작. 시험 잘나옴
SELECT sum(pay),sum(BONUS) FROM T_PROFESSOR; --5920,보너스에는 null값이잇지만 그룹에서는 상관없이 계산되어서 나온다.!

--NVL()함수 --> null값인경우 내가 지정해준값으로 변환하여 표시하여라

SELECT name,pay,bonus,
		pay+bonus 총지급액,
		pay+NVL(BONUS ,0) 총지급액
FROM  T_PROFESSOR;

--#4201,4202 --> NVL2() --> null값을 원하는것으로 바꾸어라
SELECT NAME ,PAY,NVL2(BONUS,bonus,0) BONUS,PAY*12+NVL(BONUS, 0) 연봉 FROM T_PROFESSOR WHERE DEPTNO=101;
SELECT NAME ,PAY,NVL(BONUS,0),PAY*12+NVL(BONUS,0) 연봉 FROM T_PROFESSOR WHERE DEPTNO=101;
