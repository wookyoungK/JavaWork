SELECT *FROM T_STUDENT ;
SELECT *FROM  T_DEPARTMENT ;

SELECT a.NAME 학생이름,a.DEPTNO1 학과번호,b.DNAME 
FROM T_STUDENT a,T_DEPARTMENT b
WHERE a.DEPTNO1 =b.DEPTNO ;

SELECT a.NAME 학생이름,a.DEPTNO1 학과번호,b.DNAME 
FROM T_STUDENT a JOIN T_DEPARTMENT b
on a.DEPTNO1 =b.DEPTNO ;
------------------------------------------
SELECT *FROM T_STUDENT ;
SELECT *FROM T_PROFESSOR ;

SELECT a.NAME 이름, a.PROFNO 지도교수,b.NAME 교수이름
FROM T_STUDENT a,T_PROFESSOR b
WHERE a.PROFNO =b.PROFNO ;

SELECT a.NAME 이름, a.PROFNO 지도교수,b.NAME 교수이름
FROM T_STUDENT a join T_PROFESSOR b
on a.PROFNO =b.PROFNO ;
----------------------------
SELECT *FROM T_STUDENT ;
SELECT *FROM T_DEPARTMENT ;
SELECT *FROM T_PROFESSOR ;

SELECT a.NAME 학생이름,b.DNAME 학과,c.NAME 교수이름
FROM T_STUDENT a,T_DEPARTMENT b,T_PROFESSOR c
WHERE a.DEPTNO1 =b.DEPTNO AND a.PROFNO =c.PROFNO ;

SELECT a.NAME 학생이름,b.DNAME 학과,c.NAME 교수이름
FROM T_STUDENT a JOIN T_DEPARTMENT b ON a.DEPTNO1 =b.DEPTNO
	JOIN T_PROFESSOR c ON a.PROFNO =c.PROFNO ;
--------------------------------------------

SELECT *FROM t_emp2;
SELECT *FROM T_POST;

SELECT a.NAME 사원이름, a.POST 현재,a.PAY 현재연봉,
		b.S_PAY 하한금액,b.E_PAY 상한금액
FROM t_emp2 a ,T_POST b
WHERE a.POST = b.POST;

SELECT a.NAME 사원이름, a.POST 현재,a.PAY 현재연봉,
		b.S_PAY 하한금액,b.E_PAY 상한금액
FROM t_emp2 a JOIN T_POST b
on a.POST = b.POST;
----------------------------------------

SELECT * FROM T_STUDENT ;
SELECT * FROM T_PROFESSOR ;

SELECT a.NAME 학생이름,b.NAME 교수이름
FROM T_STUDENT a,T_PROFESSOR b
WHERE DEPTNO1 =101 AND a.PROFNO =b.PROFNO ;

-------------------------------------
SELECT * FROM T_CUSTOMER ;
SELECT * FROM T_GIFT ;

SELECT a.C_NAME ,a.C_POINT ,b.G_NAME 
FROM T_CUSTOMER a, T_GIFT b
WHERE a.C_POINT BETWEEN b.G_START AND b.G_END ;

SELECT a.C_NAME ,a.C_POINT ,b.G_NAME 
FROM T_CUSTOMER a join T_GIFT b
on a.C_POINT BETWEEN b.G_START AND b.G_END ;

------------------------------------------
SELECT b.G_NAME, COUNT(b.G_NAME) 
FROM T_CUSTOMER a, T_GIFT b
WHERE a.C_POINT BETWEEN b.G_START AND b.G_END
GROUP BY b.G_NAME;


SELECT b.G_NAME, COUNT(b.G_NAME) 
FROM T_CUSTOMER a join T_GIFT b
on a.C_POINT BETWEEN b.G_START AND b.G_END
GROUP BY b.G_NAME;


------------------------------------------

SELECT * FROM T_STUDENT;
SELECT * FROM T_EXAM01 ;
SELECT * FROM T_CREDIT ;

SELECT a.NAME ,b.TOTAL ,c.GRADE 
FROM T_STUDENT a,T_EXAM01 b, T_CREDIT c
WHERE a.STUDNO =b.STUDNO AND b.TOTAL BETWEEN c.MIN_POINT AND c.MAX_POINT; 

SELECT a.NAME ,b.TOTAL ,c.GRADE 
FROM T_STUDENT a JOIN T_EXAM01 b ON a.STUDNO =b.STUDNO
	JOIN  T_CREDIT c ON b.TOTAL BETWEEN c.MIN_POINT AND c.MAX_POINT;

---------------------------------

SELECT *FROM T_CUSTOMER ;
SELECT * FROM  T_GIFT ;

SELECT a.C_NAME,a.C_POINT ,b.G_NAME 
FROM T_CUSTOMER a, T_GIFT b
WHERE b.G_NAME = '산악용자전거' AND a.C_POINT >= b.G_START;

------------------------------------

SELECT * FROM t_emp2;
SELECT * FROM t_post;

SELECT a.NAME ,((TO_CHAR(SYSDATE,'YYYY')-TO_CHAR(BIRTHDAY,'YYYY'))+1) 현재나이, 
		nvl(a.POST,' '), b.POST 
from t_emp2 a JOIN T_POST b 
on ((TO_CHAR(SYSDATE,'YYYY')-TO_CHAR(BIRTHDAY,'YYYY'))+1)
	BETWEEN b.S_AGE AND b.E_AGE ;

---------------------------------

SELECT 
	s.name "학생이름", 
	p.name "교수이름"
FROM 
	t_student s 
	FULL JOIN t_professor p
	ON s.profno = p.profno;
------------------------------------

SELECT * FROM T_DEPT2;

SELECT b.DNAME ,a.DNAME 
FROM T_DEPT2 a,T_DEPT2 b
WHERE a.DCODE =b.PDEPT ;

--------------------------------------
SELECT * FROM T_PROFESSOR ;

SELECT a.PROFNO ,a.NAME ,to_char(a.HIREDATE,'yyyy:mm:dd') 입사일,COUNT(b.HIREDATE) 
FROM T_PROFESSOR a left JOIN T_PROFESSOR b
ON a.HIREDATE >b.HIREDATE
GROUP BY a.PROFNO ,a.NAME ,a.HIREDATE 
ORDER BY a.HIREDATE ASC;



