--DML 
/*
SQL ‘명령문’과 ‘키워드’ 들은 대소문자 가리지 않습니다
문자열 은 홀따옴표 ‘ ~ ‘ 로 감쌈,  문자열 내의 내용은 대소문자 가립니다
여러줄에 걸쳐 명령문 입력 가능
하나의 명령문입력이 끝나면 반드시   ;   ←  입력 (단독 명령의 경우 ; 없이도 실행됨)
DML 은 COMMIT 명령을 실행하기 전까지는 임시저장만 되는 것임,  COMMIT; 을 해야만 데이터베이스로 내용이 업데이트 됨. 

INSERT INTO [테이블이름] VALUES  (값1, 값2... )
INSERT INTO [테이블이름] (컬럼1, 컬럼2... ) VALUES  (값1, 값2... )

ex)INSERT INTO phonebook (id, name, phone, email) 
VALUES (12, '오형돈', '010-1111-2222', 'jff@test.com');

INSERT INTO phonebook 
VALUES (23, 'jake', '010-1234-5678', 'test@test.com', 38, '', '2018-08-02');


CREATE SEQUENCE [시퀀스이름]

ex)  CREATE SEQUENCE phonebook_seq;
시퀀스 객체는 생성되면 seq 테이블에 정보가 저장된다.

생성된 시퀀스 Sequence 확인 
SELECT * FROM seq WHERE sequence_name = 'PHONEBOOK_SEQ';

시퀀스 사용한  INSERT :  시퀀스.nextval 사용
ex) INSERT INTO phonebook (id, name, phone, email, regDate)
VALUES (phonebook_seq.nextval, '김철수', '010-1111-2222', 'ssamsung@test.com',  SYSDATE);

레코드(데이터) 수정 -  UPDATE

ex)UPDATE phonebook 
     SET email = 'jake@mail.com', addr = 'Seoul, Korea' 
     WHERE id = 3;
WHERE 조건식이 없으면 모~든 레코드에 UPDATE 가 적용되니 주의!

레코드(데이터) 삭제 -  DELETE
ex)DELETE FROM phonebook WHERE uid = 3;

DISTINCT - 중복값 제거하고 출력
SELECT  DISTINCT [컬럼명 또는 표현식] FROM [테이블명, 뷰명] ;

필드,문자열 연결
SELECT name || '-' || position FROM t_professor;


----------------------------------------------------------------------------------------



2. 데이터베이스 구현
계정 생성 CREATE USER [아이디]  IDENTIFIED BY [비밀번호] ;
		ex)CREATE USER scott IDENTIFIED BY tiger;
		
		create 	user
				table
				sequence
				view

권한부여 GRANT [권한들]  TO [사용자 아이디] ;
	 	ex) GRANT connect, resource, create view, create procedure TO scott;
각 권한들 :
	connect - DB 접속을 위한 권한
	resource - 테이블 (등) 생성 권한
	create view - 뷰(view) 를 생성할수 있는 권한
	create procedure - 프로시져(procedure) 를 생성할수 있는 권한 
	
권한 확인
	 SQL> SELECT GRANTED_ROLE FROM DBA_ROLE_PRIVS 
     WHERE GRANTEE ='아이디(대문자)';    : resource  출력
     
     SQL> SELECT PRIVILEGE FROM DBA_SYS_PRIVS 
     WHERE GRANTEE ='아이디(대문자)';    : privilege , 거의 이거
     
 사용자 비밀번호 변경 
	 ALTER USER [사용자 아이디] IDENTIFIED BY [비밀번호]
	 ex) ALTER USER scott IDENTIFIED BY tiger12;
	 
사용자 삭제
  	DROP USER [사용자 아이디] CASCADE
  	ex)DROP USER scott CASCADE;
테이블 삭제
	DROP TABLE [테이블 명]  CASCADE CONSTRAINT PURGE;
테이블 생성
	CREATE TABLE [테이블이름] (
    [컬럼이름] [컬럼타입] {제약조건},
    [컬럼이름] [컬럼타입] {제약조건},
    
    SQL> CREATE TABLE phonebook (
    pb_uid NUMBER PRIMARY KEY,
    name VARCHAR2(10) NOT NULL,
    phone VARCHAR2(14) DEFAULT '010-0000-0000', 입력되지않으면 default xx로해라
    memo CLOB,
    regDate DATE
    
데이터 타입
	문자형
    varchar2(n) 가변길이
    char(n) 	고정길이
    clob	
    숫자형
    number
    날짜형
    DATE 		고정길이 날짜
      
 테이블 구조변경 
 	SQL> ALTER TABLE phonebook
MODIFY (
    name VARCHAR2(15),
    phone VARCHAR2(20)
    
테이블구조 변경 (추가)
SQL> ALTER TABLE phonebook
ADD (   
       email VARCHAR2(20),
       addr VARCHAR2(100),
       age NUMBER DEFAULT 21
       
 ALTER TABLE phonebook DROP (addr, age);
 ALTER TABLE test_member DROP primary key;

);
-------------------------------------------------------------------------------
--순서 
--SELECT
--FROM
--WHERE
--GROUP BY
--HAVING
--ORDER BY



view --------------------------------------------------------
가상의 테이블
실제 Table 에는 데이터가 있지만, View 에는 데이터는 없고 SQL만 저장
View에 접근할때는 View에 들어있던 SQL의 수행된 결과를 가져오는 것
View를 사용하는 목적
보안 : 특정 테이블의 특정 column 이 보여지면 안되는 경우
편의성 : 가령 여러개의 테이블 join 하는게 매번 귀찮을때 아예 그것을 view로 만들어 놓으면 편함.

view 를 생성하려면 GRANT 명령어로 CREATE  VIEW 가 반드시 있어야 함

--#8101) t_professor 테이블의 profno, name, email, hpage 칼럼만 사용하는 view를 생성하세요 
--view 의 이름은 v_prof로 하세요

CREATE OR REPLACE VIEW v_prof --or replace 있으면 바꿔라
AS
SELECT profno, name, email, hpage FROM T_PROFESSOR ;

SELECT * FROM v_prof;

View 생성시 별도의 컬럼이름 가능
CREATE OR REPLACE VIEW v_prof(pfno, nm, em, hp)
AS
SELECT profno, name, email, hpage FROM t_professor;


뷰 삭제
DROP VIEW v_prof;
뷰 확인
SELECT tname FROM tab;
DROP VIEW v_prof;


--INLINE View (인라인 뷰)
--View 는 한번 만들어 놓으면 계속 사용할수 있습니다.
--그러나 1회용으로만 사용할 경우는 FROM 절의 서브쿼리 형태로 만들수 있습니다. 이러한 뷰를 Inline View 라 합니다.


--#8103) t_student, t_department 테이블 : 
--학과별로 학생들의 최대키와 최대몸무게, 학과 이름을 출력하세요

SELECT 
	d.dname "학과명", 
	s.max_height "최대키", 
	s.max_weight "최대몸무게"
FROM 
	( SELECT deptno1, MAX(height) max_height, MAX(weight) max_weight 
	FROM t_student
	GROUP BY deptno1 ) s ,--t_student s를 나머지 조건과같이해준것  *** 여기에 별칭처럼 사용하여  select문이나 ,where문에 별칭.** 을사용한다
	t_department d
WHERE 
	s.deptno1 = d.deptno;
--------------------------------------------------------------------------

index ,constraint 는 ppt나 자료보기!






*/