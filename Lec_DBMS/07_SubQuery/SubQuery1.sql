--#7101) t_emp 테이블에서 scott 보다 급여를 많이 받는 사람의 이름과 급여 출력
SELECT * FROM T_EMP;

SELECT sal FROM T_EMP WHERE ENAME ='SCOTT'; --이쿼리의 결과가 3000 이걸사용함  이쿼리가 하나의 변수라고 생각

SELECT ENAME ,SAL 
FROM T_EMP 
WHERE SAL > (SELECT sal FROM T_EMP WHERE ENAME ='SCOTT'); --메인쿼리에 서브쿼리를 집어넣어준다

--#7102) t_student 테이블에서 가장 키 큰 학생의 '이름'과 '키'를 출력
SELECT * FROM T_STUDENT;

SELECT MAX(HEIGHT) FROM T_STUDENT;

SELECT NAME ,hEIGHT 
FROM T_STUDENT 
WHERE hEIGHT = (SELECT MAX(HEIGHT) FROM T_STUDENT);

--Sub Query 주의사항
--1. SubQuery 는 연산자 오른쪽에 위치해야 하며 반드시 괄호로 묶어야 한다
--2. 특별한 경우를 제외하고는 SubQuery절에는 Order By 가 올수 없습니다
--3. 단일행SubQuery , 다중행SubQuery 에 따라 연산자를 잘 선택해야 한다

--#7103) t_student, t_department 테이블 사용하여 이윤나 학생과 1전공이 동일한 학생들의 이름과 1전공 이름을 출력하세요

SELECT * FROM T_STUDENT ;
SELECT * FROM T_DEPARTMENT ;

SELECT DEPTNO1 FROM T_STUDENT WHERE name='이윤나';

SELECT a.NAME ,b.DNAME 
FROM T_STUDENT a,T_DEPARTMENT b
WHERE a.DEPTNO1 =b.DEPTNO AND a.DEPTNO1 =(SELECT DEPTNO1 FROM T_STUDENT WHERE name='이윤나');

--#7104) t_professor, t_department 테이블 : 입사일이 송도권 교수보다 나중에 입사한 사람의 이름과 입사일, 학과명을 출력하세요
SELECT * FROM T_PROFESSOR ;
SELECT * FROM T_DEPARTMENT ;

SELECT HIREDATE FROM T_PROFESSOR WHERE name = '송도권';

SELECT a.NAME ,to_char(a.HIREDATE,'YYYY-MM-DD') ,b.DNAME 
FROM T_PROFESSOR a,T_DEPARTMENT b
WHERE a.DEPTNO = b.DEPTNO AND a.HIREDATE > (SELECT HIREDATE FROM T_PROFESSOR WHERE name = '송도권');

--#7105) t_student 테이블 : 1전공이 101번인 학과의 평균 몸무게보다 몸무게가 많은 학생들의 이름과 몸무게를 출력하세요

SELECT * FROM T_STUDENT ;

SELECT AVG(WEIGHT ) 
FROM T_STUDENT
WHERE DEPTNO1 =101;


SELECT NAME ,WEIGHT 
FROM T_STUDENT 
WHERE WEIGHT > (SELECT AVG(WEIGHT) FROM T_STUDENT WHERE DEPTNO1 =101);
--#7106) t_professor 테이블에서 심슨 교수와 같은 입사일에 입사한 교수 중, 조인형 교수보다 월급을 적게 받는 교수의 이름과 급여, 입사일을 출력하세요

SELECT * FROM T_PROFESSOR; 

SELECT HIREDATE FROM T_PROFESSOR WHERE name ='심슨'; 
SELECT PAY  FROM T_PROFESSOR WHERE name ='조인형'; 


SELECT NAME ,PAY ,HIREDATE 
FROM T_PROFESSOR 
WHERE HIREDATE =(SELECT HIREDATE FROM T_PROFESSOR WHERE name ='심슨')
	AND
		PAY <(SELECT PAY  FROM T_PROFESSOR WHERE name ='조인형'); 

-- 2. 다중행 쿼리
-- 다중쿼리를 사용할떄에는 일반 연산자를 사용하면 오류가난다
-- Sub Query 결과가 2건 이상 출력되는 것을 말합니다.
-- 다중행 Sub Query 와 함께 사용하는 연산자
--		 IN 같은 값을 찾음
--		>ANY 최소값을 반환함 (서브쿼리 결과중 가장작은것보다 큰)
--		<ANY 최대값을 반환함 (서브쿼리 결과중 가장큰것보다 작은)
--		<ALL 최소값을 반환함 (서브쿼리 결과중 가장작은것보다 작은)
--		>ALL 최대값을 반환함 (서브쿼리 결과중 가장큰것보다 큰)
--		EXIST Sub Query 값이 있을 경우 반환

--#7107) t_emp2, t_dept2 테이블 : 근무지역 (t_dept2.area) 
--이 서울 지사인 모든 사원들의 사번(empno)과 이름(name), 부서번호(deptno)를 출력하세요	

SELECT * FROM T_EMP2;
SELECT * FROM T_DEPT2;

SELECT DCODE FROM T_DEPT2 WHERE AREA ='서울지사';

SELECT EMPNO ,NAME ,DEPTNO 
FROM T_EMP2 
WHERE DEPTNO IN (SELECT DCODE FROM T_DEPT2 WHERE AREA ='서울지사');

--#7108) t_emp2 테이블 : 전체직원중 과장 직급의 최소연봉자보다 연봉이 높은 사람의 이름(name)과 직급(post), 연봉(pay)을 출력하세요. 
--단, 연봉 출력 형식은 천 단위 구분 기호와 원 표시를 하세요
SELECT * FROM t_emp2;
SELECT pay FROM T_EMP2 WHERE post='과장';

SELECT NAME, POST, to_char(PAY,'999,999,999') FROM T_EMP2 
WHERE pay >ANY (SELECT pay FROM T_EMP2 WHERE post='과장');

--#7109) t_student 테이블 : 전체학생중에서 체중이 4학년 학생들의 체중에서 가장 적게 나가는 학생보다 몸무게가 적은 학생의 이름과 학년과 몸무게를 출력하세요

SELECT * FROM T_STUDENT ;
SELECT WEIGHT FROM T_STUDENT WHERE GRADE =4;

SELECT name, GRADE ,WEIGHT FROM T_STUDENT WHERE WEIGHT <ALL (SELECT WEIGHT FROM T_STUDENT WHERE GRADE =4);



	