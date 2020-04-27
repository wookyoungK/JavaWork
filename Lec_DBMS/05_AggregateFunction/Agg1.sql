SELECT *
FROM T_PROFESSOR; 
SELECT count(*), COUNT(HPAGE) FROM T_PROFESSOR; --group는 null값이나오지않고 배제될뿐이다!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
SELECT COUNT(BONUS ),sum(BONUS ),avg(BONUS ) FROM T_PROFESSOR; 
SELECT max(HIREDATE), min(HIREDATE) FROM T_EMP;
--단점 평균같은경우 보너스를 받지않아도 평균이 나온다
--NULL 허용 컬럼의 그룹함수 적용시
--nvl ,nvl2 사용해야함
SELECT AVG(Bonus),avg(nvl(Bonus,0))
FROM T_PROFESSOR ;

--t_professor 테이블에서 '학과 별'로 교수들의 평균보너스
--select절에 그룹함수와 그룹함수가 아닌것과 같이올수없다!!!********************
SELECT DEPTNO,AVG(BONUS) FROM T_PROFESSOR;--x

SELECT DEPTNO,round(AVG(nvl (BONUS,0)),1) 보너스평균 FROM T_PROFESSOR GROUP BY DEPTNO; --해결방안

--#5101
SELECT DEPTNO ,POSITION , AVG(PAY ) FROM T_PROFESSOR GROUP BY DEPTNO,POSITION ORDER BY DEPTNO ASC, POSITION ASC;

--q부서별 평균급여를 출력하되, 평균그엽가 450보다 많은 학과만 출력
--그룹 함수는 where절에서 사용 불가
SELECT DEPTNO,AVG(PAY) 평균급여 FROM T_PROFESSOR WHERE AVG(PAY)>450 GROUP BY DEPTNO; --x

--HAVING 그룹함수를 사용할떄 조건절을 사용하려면 HAVING을 맨뒤에 사용하여야한다.
SELECT DEPTNO,AVG(PAY) 평균급여 FROM T_PROFESSOR GROUP BY DEPTNO HAVING avg(pay) >300; --해결방안

--순서 
--SELECT
--FROM
--WHERE
--GROUP BY
--HAVING
--ORDER BY

SELECT *FROM T_EMP;
SELECT *FROM T_PROFESSOR;

-- #5102)t_emp 테이블: 매니저별(MGR)로 관리하는 직원들의 ‘매니저’, ‘직원수’와 ‘급여총액’과 ‘급여평균’과 ‘교통비 (COMM) 평균’ 지급액 을 출력하세요. 
-- 단 사장님은 (job = president)제외
SELECT MGR 매니저,COUNT(*),SUM(sal) 급여총액,AVG(SAL) 급여평균,
		AVG(nvl(COMM,0)) 
FROM T_EMP
WHERE job != 'PRESIDENT'
GROUP BY MGR;

--#5103) t_professor 테이블 :  직위가 정교수 혹은 조교수 인 분들 중에서 ‘과별(deptno)’로 
-- 과번호, 소속교수 총수, 근속일 평균, 급여평균, 보너스 평균을 출력해보세요
SELECT DEPTNO, ROUND(avg(SYSDATE-HIREDATE),4) ,count(nvl(DEPTNO,0)), avg(PAY),AVG(nvl (BONUS,0))
FROM T_PROFESSOR
WHERE POSITION='정교수' OR POSITION='조교수'
GROUP BY DEPTNO;

--#5104) t_student 테이블 : 학과별(deptno1) 로,
-- 학과번호, 최대몸무게 - 최소몸무게 차이 값을 출력해보세요
SELECT DEPTNO1, max(WEIGHT)-min(WEIGHT)
FROM T_STUDENT
GROUP BY DEPTNO1;


--#5105) 그 차이가 30 이상인것만 출력하려면?
SELECT DEPTNO1, max(WEIGHT)-min(WEIGHT)
FROM T_STUDENT
GROUP BY DEPTNO1
HAVING (max(WEIGHT)-min(WEIGHT))>=30;
