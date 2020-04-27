--다중칼럼 Sub Query!!!
--Sub Query 결과가 여러 칼럼인 경우.  주로 Primary Key 를 여러 칼럼을 합쳐서 만들었을 경우 한꺼번에 비교하기 위해서 자주 사용.

--#7201) t_student 테이블을 조회하여 각 학년별로 최대 키를 가진 학생들의 학년과 이름과 키를 출력하세요,  학년 오름차순으로 출력

SELECT *FROM T_STUDENT;

SELECT GRADE ,max(HEIGHT) 
FROM T_STUDENT 
GROUP BY GRADE; --결과 : 컬럼이두개 서브 쿼리 결과가 두개이기떄문에 

SELECT GRADE ,name,HEIGHT 
FROM T_STUDENT
WHERE (GRADE ,HEIGHT ) IN (SELECT GRADE ,max(HEIGHT) FROM T_STUDENT GROUP BY GRADE)  --두개를 받는다.
ORDER BY 1 ASC;

--#7202) t_professor , t_department 테이블 :  각 학과별로 입사일이 가장 오래된 교수의 교수번호와 이름, 학과명을 출력하세요. 
-- 단 학과이름 순으로 오름차순 정렬하세요

SELECT * FROM T_PROFESSOR ;
SELECT * FROM T_DEPARTMENT ;

SELECT DEPTNO ,TO_char(min(HIREDATE),'yyyy:mm:dd') FROM T_PROFESSOR 
GROUP BY DEPTNO;

SELECT a.PROFNO ,a.NAME ,a.HIREDATE ,b.DNAME 
FROM T_PROFESSOR a, T_DEPARTMENT b
WHERE a.DEPTNO = b.DEPTNO AND (a.DEPTNO,a.HIREDATE )IN (SELECT DEPTNO ,TO_char(min(HIREDATE),'yyyy:mm:dd') 
FROM T_PROFESSOR GROUP BY DEPTNO)
ORDER BY 4 ASC;


--#7203)  t_emp2 테이블 : 직급별로 해당직급에서 최대 연봉을 받는 직원의 이름과 직급, 연봉을 출력하세요,  단, 연봉순으로 오름차순 정렬하세요

SELECT * FROM T_EMP2;

SELECT POST,MAX(pay) 
FROM T_EMP2 
GROUP BY post; 
	
SELECT NAME , POST ,PAY 
FROM T_EMP2
WHERE (post,pay) IN (SELECT POST,MAX(pay) FROM T_EMP2 GROUP BY post )
ORDER BY 3 ASC;

--#7204)  t_emp2, t_dept2 테이블 : 각 부서별 평균 연봉을 구하고 그 중에서 평균 연봉이 가장 적은 부서의 평균연봉보다 적게 받는 직원들의 부서명, 직원명, 연봉을 출력 하세요

SELECT * FROM T_EMP2;
SELECT * FROM T_DEPT2 ;

SELECT AVG(pay) 
FROM t_emp2
GROUP BY DEPTNO;


SELECT b.DNAME , a.NAME ,a.PAY 
FROM t_emp2 a, t_dept2 b
WHERE a.DEPTNO =b.DCODE AND a.PAY <ALL (SELECT AVG(pay) FROM t_emp2 GROUP BY DEPTNO)
ORDER BY 3 ASC;




--순서 
--SELECT
--FROM
--WHERE
--GROUP BY
--HAVING
--ORDER BY



--상호연관 Sub Query
--Main Query 값을 Sub Query 에 주고 Sub Query를 수행한 후 그 결과를 다시 Main Query 로 반환해서 수행하는 쿼리.
--어려워요~~ 실무에서 배울꼐용


--#7205) 연습
--t_emp2 테이블 직원들 중에서 자신의 직급의 평균연봉과  같거나 많이 받는 사람들의 
--이름과 직급, 현재 연봉을 출력하세요.


SELECT a.name "사원이름", NVL(a.post, ' ') "직급", a.pay "급여"
FROM t_emp2 a
-- WHERE a.pay >= (  a.post 직급의 평균연봉 )
WHERE a.pay >= (SELECT avg(b.pay) FROM t_emp2 b WHERE NVL(a.post, ' ') = NVL(b.post, ' '))     
;

SELECT avg(b.pay) FROM t_emp2 b WHERE '과장' = b.post;


--Scalar Sub Query (스칼라 서브쿼리)
--JOIN 과 같은 결과 나옴.  그러나 데이터 양이 적은 경우는 스칼라서브쿼리 방식이 Join 보다 낳은 성능을 보여줌
-- 이렇게하는 방법도 있다는것을 보여줌
SELECT name "사원이름", (SELECT dname FROM t_dept2 d
	WHERE e.deptno = d.dcode ) "부서이름"
FROM t_emp2 e;


