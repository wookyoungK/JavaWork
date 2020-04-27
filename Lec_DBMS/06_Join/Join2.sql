-- 비등가 조인 (Non-Equi Join)
SELECT * FROM T_CUSTOMER;
SELECT * FROM T_GIFT; 

-- #6201) 
-- t_customer 테이블, t_gift 테이블을 join 하여  
-- 고객의 마일리지 포인트별로 받을수 있는 상품을 조회하여 
-- 고객의 '이름(c_name)'과 포인트(c_point) 상품명(g_name)을 출력하세요
-- BETWEEN ~ AND ~ 사용


SELECT s.C_NAME 고객명,s.C_POINT,d.G_NAME 상품명 
FROM T_CUSTOMER s,T_GIFT d
	WHERE s.C_POINT BETWEEN d.G_START AND d.G_END ;
-- ANSI
SELECT s.C_NAME 고객명,s.C_POINT,d.G_NAME 상품명 
FROM T_CUSTOMER s JOIN T_GIFT d on s.C_POINT 
BETWEEN d.G_START AND d.G_END ;
	
--  #6202) 연습 
-- 앞 예제에서 조회한 상품의 이름(gname)과 필요수량이 몇개인지 조회하세요
-- (그룹함수 동원되어야 한다)

SELECT d.G_NAME "상품명",COUNT(d.G_NAME) 
FROM T_CUSTOMER s,T_GIFT d
WHERE s.C_POINT BETWEEN d.G_START AND d.G_END 
GROUP BY d.G_NAME;


-- ANSI
SELECT g.g_name "상품명", count(*) "상품수량"
FROM t_customer c JOIN t_gift g
	ON c.c_point BETWEEN g.g_start AND g.g_end
GROUP BY g.g_name;


-- #6203) 연습
-- t_student 테이블과 t_exam01 시험성적 테이블, t_credit 학점 테이블을 조회하여 
-- 학생들의 이름과 점수와 학점을 출력하세요

SELECT * FROM T_CREDIT;
SELECT * FROM T_EXAM01 ;
SELECT * FROM T_STUDENT ;

--oracle
SELECT s.NAME 학생이름,a.TOTAL 점수,d.GRADE 학점 
FROM T_STUDENT s,T_CREDIT d,T_EXAM01 a
WHERE s.STUDNO = a.STUDNO 
AND a.TOTAL BETWEEN d.MIN_POINT AND d.MAX_POINT
ORDER BY a.TOTAL DESC;  

-- ANSI
SELECT s.NAME 학생이름, e.TOTAL 점수, c.GRADE 학점 
FROM T_STUDENT s 
	JOIN T_EXAM01 e ON s.STUDNO = e.STUDNO 
	JOIN T_CREDIT c ON e.TOTAL
BETWEEN c.MIN_POINT AND c.MAX_POINT
ORDER BY e.TOTAL DESC;

--  #6204) 연습
-- t_customer 와 t_gift 테이블 join : 
--자기 포인트(c_point) 보다 낮은 포인트의 상품 중 
--한가지를 선택할수 있다고 할때 
--'산악용자전거'를 선택할 수 있는 
--고객명(c_name)과 포인트(c_point), 
--상품명(g_name)을 출력하세요
SELECT * FROM T_CUSTOMER;
SELECT * FROM T_GIFT;

SELECT a.C_NAME 고객명, a.C_POINT "Point",b.G_NAME 상품명 
FROM T_CUSTOMER a,T_GIFT b
WHERE a.C_POINT >= b.G_START AND b.G_NAME ='산악용자전거';


SELECT a.C_NAME 고객명, a.C_POINT "Point",b.G_NAME 상품명 
FROM T_CUSTOMER a JOIN T_GIFT b on a.C_POINT >= b.G_START AND b.G_NAME ='산악용자전거';


--#6205) 연습
--t_emp2, t_post 테이블 join : 
--사원들의 이름(name)과 나이, 현재직급(post), 예상직급을 출력하세요. 
--예상직급은 나이로 계산하며 해당 나이가 받아야 하는 직급을 의미합니다. 
--나이는 오늘(SYSDATE)을 기준으로 하되 소수점 이하는 절삭하여 계산하세요
--t_emp2 의 직급(post) 은 null 허용함에 주의
--** 나이계산은 어떻게?  :  (현재연도 - 생년월일연도) + 1, 
--	SYSDATE, TO_CHAR() 사용


SELECT * FROM T_EMP2;
SELECT * FROM T_POST;

SELECT a.NAME 이름 , (TO_CHAR(SYSDATE,'YYYY') - TO_CHAR(a.BIRTHDAY, 'YYYY'))+1 현재나이,nvl(a.POST, ' ') 현재직급, b.POST 예상직급
FROM t_emp2 a, t_post b
WHERE 
	(TO_CHAR(SYSDATE,'YYYY') - TO_CHAR(a.BIRTHDAY, 'YYYY')+1)
	BETWEEN b.S_AGE AND b.E_AGE;



SELECT a.NAME 이름 , (TO_CHAR(SYSDATE,'YYYY') - TO_CHAR(a.BIRTHDAY, 'YYYY'))+1 현재나이,nvl(a.POST, ' ') 현재직급, b.POST 예상직급
FROM t_emp2 a join t_post b
on 
	(TO_CHAR(SYSDATE,'YYYY') - TO_CHAR(a.BIRTHDAY, 'YYYY')+1)
	BETWEEN b.S_AGE AND b.E_AGE;
	

-- OUTER JOIN
-- (ANSI 구문 only)

-- #6206)
--t_student 테이블과 t_professor 테이블 Join : 
--학생이름과 지도교수 이름을 출력하세요. 
--단! 지도교수가 결정되지 않은 학생의 명단도 함께 출력하세요

--** 기존의 INNER Join 방식으로 먼저 만들어 보고 OUTER Join 을 해보고 비교해보자

SELECT s.NAME ,p.NAME 
FROM T_STUDENT s join T_PROFESSOR p
on s.PROFNO =p.PROFNO ;

SELECT s.NAME ,p.NAME 
FROM T_STUDENT s LEFT OUTER JOIN T_PROFESSOR p
on s.PROFNO =p.PROFNO ;

-- #6207
SELECT s.NAME ,p.NAME 
FROM T_STUDENT s RIGHT OUTER JOIN T_PROFESSOR p
on s.PROFNO =p.PROFNO;

-- #6208
SELECT s.name "학생이름", p.name "교수이름"
FROM t_student s FULL OUTER JOIN t_professor p
	ON s.profno = p.PROFNO;

------------------------------------------------
-- self join

-- #6209) 
-- t_dept2 테이블에서 
-- 부서명 과 그 부서의 상위부서명을 출력하세요

SELECT * FROM T_DEPT2 ;

SELECT a.DNAME ,b.DNAME 
FROM T_DEPT2 a, T_DEPT2 b
WHERE a.PDEPT =b.DCODE ;

SELECT a.DNAME ,b.DNAME 
FROM T_DEPT2 a join T_DEPT2 b
on a.PDEPT =b.DCODE ;

-- #6210)
--t_professor 테이블 : 교수번호, 교수이름, 입사일, 
--그리고 자신보다 입사일 빠른 사람의 인원수를 출력하세요, 
--단 자신보다 입사일이 빠른 사람수를 오름차순으로 출력하세요
--hint: left outer 사용 
--         / 그룹함수 사용

-- left outer 를 사용하는 이유는 '조인형' 교수 때문.
-- 조인형 교수보다 먼저 입사한 사람이 없기 때문에 일반 join으론 하면 조인형 교수가 join 에서 빠져버린다.

SELECT  * FROM T_PROFESSOR ;

SELECT a.PROFNO 교수번호,a.NAME 교수명, a.HIREDATE 입사일,
		count(b.HIREDATE) 빠른입사일
FROM 
	T_PROFESSOR a LEFT OUTER join T_PROFESSOR b
	ON b.HIREDATE <a.HIREDATE
	--ON TO_CHAR(b.HIREDATE, 'YYYY/MM/DD') < TO_CHAR(a.HIREDATE, 'YYYY/MM/DD')
GROUP BY 
	a.PROFNO,a.NAME, a.HIREDATE --group by위치보기
ORDER BY 4;
-- 숫자 4는 4번째 컬럼 을 정렬한다는 뜻이다 


