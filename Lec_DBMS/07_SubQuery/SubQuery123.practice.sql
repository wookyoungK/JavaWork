--#7101) t_emp 테이블에서 scott 보다 급여를 많이 받는 사람의 이름과 급여 출력
SELECT * FROM t_emp;

SELECT sal FROM t_emp WHERE ENAME ='SCOTT';

SELECT ENAME,SAL 
FROM T_EMP 
WHERE sal > (SELECT sal FROM t_emp WHERE ENAME ='SCOTT');


SELECT * FROM T_STUDENT ;

SELECT max(HEIGHT ) FROM T_STUDENT; 
SELECT NAME ,HEIGHT 
FROM T_STUDENT 
WHERE HEIGHT =(SELECT max(HEIGHT ) FROM T_STUDENT);

--단일행 Sub Query
--다중행 Sub Query
--다중칼럼 Sub Query
--상호연관 Sub Query

--#7103) t_student, t_department 테이블 사용하여 이윤나 학생과 1전공이 동일한 학생들의 이름과 1전공 이름을 출력하세요
SELECT * FROM T_STUDENT ;
SELECT * FROM T_DEPARTMENT ;

SELECT DEPTNO1 FROM T_STUDENT WHERE NAME = '이윤나';

SELECT a.NAME ,b.DNAME 
FROM T_STUDENT a , T_DEPARTMENT b	
WHERE a.DEPTNO1 =b.DEPTNO AND a.DEPTNO1 = (SELECT DEPTNO1 FROM T_STUDENT WHERE NAME = '이윤나');

--#7104) t_professor, t_department 테이블 : 입사일이 송도권 교수보다 나중에 입사한 사람의 이름과 입사일, 학과명을 출력하세요

SELECT * FROM T_PROFESSOR;
SELECT * FROM T_DEPARTMENT;

SELECT HIREDATE FROM T_PROFESSOR WHERE name='송도권';

SELECT a.NAME , a.HIREDATE ,b.DNAME 
FROM T_PROFESSOR a,T_DEPARTMENT b
WHERE a.DEPTNO =b.DEPTNO AND HIREDATE >(SELECT HIREDATE FROM T_PROFESSOR WHERE name='송도권');

--#7105) t_student 테이블 : 1전공이 101번인 학과의 평균 몸무게보다 몸무게가 많은 학생들의 이름과 몸무게를 출력하세요

SELECT * FROM T_STUDENT;

SELECT avg(WEIGHT ) FROM T_STUDENT WHERE DEPTNO1 =101;

SELECT NAME , WEIGHT 
FROM T_STUDENT
WHERE WEIGHT >(SELECT avg(WEIGHT ) FROM T_STUDENT WHERE DEPTNO1 =101);


--#7106) t_professor 테이블에서 심슨 교수와 같은 입사일에 입사한 교수 중, 조인형 교수보다 월급을 적게 받는 교수의 이름과 급여, 입사일을 출력하세요

SELECT * FROM T_PROFESSOR ;

SELECT HIREDATE FROM T_PROFESSOR WHERE name='심슨';
SELECT pay FROM T_PROFESSOR WHERE name='조인형';

SELECT NAME ,pay,HIREDATE 
FROM T_PROFESSOR 
WHERE HIREDATE =(SELECT HIREDATE FROM T_PROFESSOR WHERE name='심슨')
AND PAY < (SELECT pay FROM T_PROFESSOR WHERE name='조인형');

--#7107) t_emp2, t_dept2 테이블 : 근무지역 (t_dept2.area) 이 서울 지사인 모든 사원들의 사번(empno)과 이름(name), 부서번호(deptno)를 출력하세요

SELECT * FROM T_EMP2;
SELECT * FROM T_DEPT2;

SELECT DCODE FROM t_dept2 WHERE area='서울지사'; 

SELECT a.EMPNO ,a.NAME ,a.DEPTNO 
FROM T_EMP2 a
WHERE a.DEPTNO in(SELECT DCODE FROM t_dept2 WHERE area='서울지사');

--#7108) t_emp2 테이블 : 전체직원중 과장 직급의 최소연봉자보다 연봉이 높은 사람의 이름(name)과 직급(post)
--, 연봉(pay)을 출력하세요.  단, 연봉 출력 형식은 천 단위 구분 기호와 원 표시를 하세요

SELECT * FROM t_emp2;

SELECT pay FROM t_emp2 WHERE post ='과장';

SELECT name , post , to_char(pay,'999,999,999')
FROM t_emp2
WHERE pay >ANY(SELECT pay FROM t_emp2 WHERE post ='과장');

--#7109) t_student 테이블 : 전체학생중에서 체중이 4학년 학생들의 체중에서 가장 적게 나가는 학생보다 몸무게가 적은 학생의 이름과 학년과 몸무게를 출력하세요
SELECT * FROM T_STUDENT;

SELECT WEIGHT FROM T_STUDENT WHERE grade=4;

SELECT name, grade,WEIGHT 
FROM T_STUDENT 
WHERE WEIGHT <ALL (SELECT WEIGHT FROM T_STUDENT WHERE grade=4);


--#7201) t_student 테이블을 조회하여 각 학년별로 최대 키를 가진 학생들의 학년과 이름과 키를 출력하세요,  학년 오름차순으로 출력

SELECT * FROM T_STUDENT ;

SELECT grade,max(HEIGHT) FROM T_STUDENT GROUP BY GRADE;

SELECT GRADE ,name,HEIGHT FROM T_STUDENT WHERE (grade,HEIGHT)in(sELECT grade,max(HEIGHT) FROM T_STUDENT GROUP BY GRADE);

--#7202) t_professor , t_department 테이블 :  각 학과별로 입사일이 가장 오래된 교수의 교수번호와 이름, 학과명을 출력하세요.  단 학과이름 순으로 오름차순 정렬하세요
SELECT * FROM T_PROFESSOR ;
SELECT * FROM T_DEPARTMENT ;

SELECT DEPTNO,TO_char(min(HIREDATE) ,'YYYY:MM:DD') FROM T_PROFESSOR GROUP BY DEPTNO;

SELECT a.PROFNO ,a.NAME , a.HIREDATE ,b.DNAME FROM T_PROFESSOR a,T_DEPARTMENT b
WHERE (b.DEPTNO ,a.HIREDATE )
IN (SELECT DEPTNO,TO_char(min(HIREDATE) ,'YYYY:MM:DD') FROM T_PROFESSOR GROUP BY DEPTNO)
ORDER BY 4 ASC;


--#7203)  t_emp2 테이블 : 직급별로 해당직급에서 최대 연봉을 받는 직원의 이름과 직급, 연봉을 출력하세요,  단, 연봉순으로 오름차순 정렬하세요

SELECT * FROM t_emp2;
SELECT post,max(pay) FROM T_EMP2 GROUP BY POST;

SELECT NAME , POST ,PAY FROM T_EMP2 WHERE (post,pay) in(SELECT post,max(pay) FROM T_EMP2 GROUP BY POST) ORDER BY 3;

-- t_emp2, t_dept2 테이블 : 각 부서별 평균 연봉을 구하고 그 중에서 평균 연봉이 가장 적은 부서의 평균연봉보다 적게 받는 직원들의 부서명, 직원명, 연봉을 출력 하세요
SELECT * FROM t_emp2;
SELECT * FROM t_dept2;

SELECT avg(pay) FROM T_EMP2 a GROUP BY a.DEPTNO;

SELECT b.DNAME , a.NAME , PAY FROM t_emp2 a,T_DEPT2 b WHERE a.DEPTNO =b.DCODE AND pay <ALL (SELECT avg(pay) FROM T_EMP2 a GROUP BY a.DEPTNO);

