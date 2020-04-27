-- SELECT 결과물중 맨 위의 5개만 출력해보고 싶으면 어케 해야 하나?
--   ex) 게시판.. 페이징

-- DBMS 마다 구현 방법 다름
--	MYSQL : LIMIT
-- 	MS SQL server : TOP
-- 	ORACLE : ROWNUM 

-- 자동적으로 오라클에서 붙여주는 행번호 객체 (ROWNUM)
SELECT ROWNUM, empno, ename, sal FROM t_emp;
-- 직원번호 역순.  그러나 ROWNUM 은 1 ~ 
SELECT ROWNUM, empno, ename, sal FROM t_emp ORDER BY empno DESC;

-- 상위 5개만!
SELECT ROWNUM, empno, ename, sal FROM t_emp
WHERE ROWNUM <=5 ORDER BY empno DESC;

-- SELECT 에 ROWNUM 없어도 동작
SELECT empno, ename, sal FROM t_emp 
WHERE ROWNUM <= 5 ORDER BY empno DESC;

--ROWNUM >5  ROWNUM 범위가 1이 포함 안되면 동작안함.
SELECT ROWNUM, empno, ename, sal FROM t_emp
WHERE ROWNUM >5 ORDER BY empno DESC;

--상위 5개 출력
--row1 ~ row5 까지 출력  (1 page)
SELECT ROWNUM, empno, ename, sal FROM T_EMP
WHERE rownum >=1 AND ROWNUM <1+5
ORDER BY empno DESC ;

SELECT ROWNUM, empno, ename, sal FROM T_EMP
WHERE rownum >=6 AND ROWNUM <6+5         
ORDER BY empno DESC ; --안나온다.. 

--phonebook 뻥튀기
SELECT * FROM PHONEBOOK ;
INSERT INTO PHONEBOOK (SELECT * FROM PHONEBOOK); --에러 Primary key 중복!!

INSERT INTO PHONEBOOK 
	(SELECT phonebook_seq.nextval,PB_NAME, PB_PHONENUM, PB_MEMO ,SYSDATE FROM PHONEBOOK );






-- ROWNUM rev.
SELECT pb_uid, pb_name, pb_phonenum FROM PHONEBOOK ORDER BY pb_uid DESC
;

SELECT T.*
FROM (SELECT pb_uid, pb_name, pb_phonenum FROM PHONEBOOK ORDER BY pb_uid DESC) T
;

SELECT ROWNUM AS RNUM, T.*
FROM (SELECT pb_uid, pb_name, pb_phonenum FROM PHONEBOOK ORDER BY pb_uid DESC) T
;


-- 한 페이지 당 5개 데이터
-- 2번째 페이지
SELECT * FROM 
(
	SELECT ROWNUM AS RNUM, T.*
	FROM (SELECT pb_uid, pb_name, pb_phonenum FROM PHONEBOOK ORDER BY pb_uid DESC) T
)
WHERE RNUM >= 6 AND RNUM < 6 + 5;


--3번째
SELECT * FROM 
(
	SELECT ROWNUM AS RNUM, T.*
	FROM (SELECT pb_uid, pb_name, pb_phonenum FROM PHONEBOOK ORDER BY pb_uid DESC) T
)
WHERE RNUM >= 11 AND RNUM < 11 + 5;


--한페이지 10개
--4번째
SELECT * FROM 
(
	SELECT ROWNUM AS RNUM, T.*
	FROM (SELECT pb_uid, pb_name, pb_phonenum FROM PHONEBOOK ORDER BY pb_uid DESC) T
)
WHERE RNUM >= 16 AND RNUM < 16+10;


