--제약조건 
--테이블 생성시 동시에 설정하기


-- t_dept2.dcode 참조 예정
SELECT * FROM t_dept2;  -- dcode : 0001, 1000...1011

-- #9001
-- 제약조건명을 명시하지 않는 방법
DROP TABLE t_emp3 CASCADE CONSTRAINT;
CREATE TABLE t_emp3(
	NO NUMBER(4) PRIMARY KEY,
	name VARCHAR2(10) NOT NULL,
	jumin VARCHAR2(13)NOT NULL UNIQUE,
	area NUMBER(1) CHECK(area <5),
	deptno VARCHAR2(6) REFERENCES t_dept2(dcode)
);

-- 별도의 항목으로 제약조건 정의가능 
DROP TABLE t_emp4 CASCADE CONSTRAINT;
CREATE TABLE t_emp4(
	NO NUMBER(4) ,
	name VARCHAR2(10) NOT NULL, --not null은 아래처럼 별도로 지정불가
	jumin VARCHAR2(13)NOT NULL,
	area NUMBER(1) ,
	deptno VARCHAR2(6),
	PRIMARY KEY(NO),
	unique(jumin),
	CHeck(area < 5 ),
	FOREIGN KEY(deptno) REFERENCES t_dept2(dcode)
);

--#9002) 
--제약조건명을 명시하여 정의

DROP TABLE t_emp3 CASCADE CONSTRAINT;

CREATE TABLE t_emp3(
	NO NUMBER(4) CONSTRAINT emp3_no_pk PRIMARY KEY,
	name VARCHAR2(10) CONSTRAINT emp3_name_nn NOT NULL,
	jumin VARCHAR2(13)
		CONSTRAINT emp3_jumin_nn NOT NULL 
		CONSTRAINT emp3_jumin_uk UNIQUE,
	area NUMBER(1) CONSTRAINT emp3_area_ck CHECK(area <5),
	deptno VARCHAR2(6) CONSTRAINT emp3_deptno_fk REFERENCES t_dept2(dcode)
);
--이렇게 제약조건을 명시해두면 emp3_no_pk처럼 이름 을가지고 사용할수있다.


DROP TABLE t_emp3 CASCADE CONSTRAINT;
CREATE TABLE t_emp3 (
	no NUMBER(4),
	name VARCHAR2(10) CONSTRAINT emp3_name_nn NOT NULL,
	jumin VARCHAR2(13) CONSTRAINT emp3_jumin_nn NOT NULL,
	area NUMBER(1),
	deptno VARCHAR2(6),
	CONSTRAINT emp3_no_pk PRIMARY KEY(no),
	CONSTRAINT emp3_jumin_uk UNIQUE(jumin),
	CONSTRAINT emp3_area_ck CHECK(area < 5),
	CONSTRAINT emp3_deptno_fk FOREIGN KEY(deptno) REFERENCES t_dept2(dcode)
);


--#9003 제약조건 조회하기
SELECT OWNER ,CONSTRAINT_name,CONSTRAINT_type,STATUS 
FROM user_CONSTRAINTS
WHERE table_name = 'T_EMP4'; --테이블명 대문자로
--제약조건이름을 안붙여주어서 힘들다 

--이름을 붙여주었을때 
SELECT OWNER ,CONSTRAINT_name,CONSTRAINT_type,STATUS 
FROM user_CONSTRAINTS
WHERE table_name = 'T_EMP3'; 


-- #9005 : 제약조건에 맞는 /위배되는 DML 시도해보기 
INSERT INTO t_emp3 VALUES(1, '오라클', '1234561234567',4,1000);
-- 두번 실행하면 오류!   ORA-00001: unique constraint (SCOTT0316.EMP3_NO_PK) violated


INSERT INTO t_emp3 VALUES(2, '오라클', '1234561234567',4,1000);
--오류!! 주민번호가 똑같다 ORA-00001: unique constraint (SCOTT0316.EMP3_JUMIN_UK) violated

INSERT INTO t_emp3 VALUES(2, '오라클', '2222222211111111',4,1000);
--오류 길이!! ORA-12899: value too large for column "SCOTT0316"."T_EMP3"."JUMIN" (actual: 16, maximum: 13)

INSERT INTO t_emp3 VALUES(2, '오라클', '2222222222222',10,1000);
--5보다 작아야한다 SQL Error [1438] [22003]: ORA-01438: value larger than specified precision allowed for this column

INSERT INTO t_emp3 VALUES(2, '오라클', '2222222222222',3,2000);
--참조하는 곳에 2000이란 값이 없다 SQL Error [2291] [23000]: ORA-02291: integrity constraint (SCOTT0316.EMP3_DEPTNO_FK) violated - parent key not found

INSERT INTO t_emp3 (NO,jumin, area, deptno ) VALUES (2, '3333333333333',4,1001);
--name오류 : SQL Error [1400] [23000]: ORA-01400: cannot insert NULL into ("SCOTT0316"."T_EMP3"."NAME")

--INSERT뿐 아니라 update/delete 에서도 오류 발생가능 

UPDATE t_emp3 SET area =10 WHERE NO =1; --check 값 오류  :SQL Error [1438] [22003]: ORA-01438: value larger than specified precision allowed for this column

SELECT * FROM T_DEPT2;
--자식이먼저 삭제 되어야한다. 
DELETE FROM t_dept2 WHERE dcode =1000;
-- 오류 : SQL Error [2292] [23000]: ORA-02292: integrity constraint (SCOTT0316.EMP3_DEPTNO_FK) violated - child record found





--#9005) 테이블 생성후에 ALTER 명령 사용하여 제약조건 추가가능!
--t_emp4 의 name 컬럼 UNIQUE 제약조건 추가 
--ALTER ~ADD
--ALTER ~MODIFY
--ALTER ~DROP

ALTER TABLE t_emp4 ADD CONSTRAINT emp4_name_uk UNIQUE(name);

--#9006
--t_mep4 테이블의 area 컬럼에 not null 제약조건 추가
ALTER TABLE t_emp4 ADD CONSTRAINT emp4_area_nn NOT NULL(area); 
--not null은 이미 지정 (default) 되어있기때문에 add로 추가할수없다 modify로 수정해야한다!!!!!!
ALTER TABLE t_emp4 MODIFY(area CONSTRAINT emp4_area_nn NOT NULL);



--#9007
SELECT * FROM t_emp2;
ALTER TABLE t_emp4 ADD CONSTRAINT emp4_name_fk FOREIGN KEY(name) REFERENCES t_emp2(name);
--SQL Error [2270] [42000]: ORA-02270: no matching unique or primary key for this column-lis
--참조되는 부모테이블의 컬럼은 PRIMARY KEy이거나 UNIQUE 해야 한다!!!


--일단 부모테이블의 name을 UNIQUE로 바꾼뒤 위의 쿼리를 다시 실행
ALTER TABLE t_emp2 ADD CONSTRAINT emp2_name_uk UNIQUE(name);
ALTER TABLE t_emp4 ADD CONSTRAINT emp4_name_fk FOREIGN KEY(name) REFERENCES t_emp2(name);




--#9008 

DROP TABLE t_emp3 CASCADE CONSTRAINT;

CREATE TABLE t_emp3(
	NO NUMBER(4) CONSTRAINT emp3_no_pk PRIMARY KEY,
	name VARCHAR2(10) CONSTRAINT emp3_name_nn NOT NULL,
	jumin VARCHAR2(13)
		CONSTRAINT emp3_jumin_nn NOT NULL 
		CONSTRAINT emp3_jumin_uk UNIQUE,
	area NUMBER(1) CONSTRAINT emp3_area_ck CHECK(area <5),
	deptno VARCHAR2(6) CONSTRAINT emp3_deptno_fk REFERENCES t_dept2(dcode)
	ON DELETE CASCADE -- 부모 삭제되면 자식도 삭제 --부모가 삭제되면 자기도 같이 삭제되게하기위한 조건
	--ON DELETE SET null 부모삭제되면 null값으로
);

--#9009
--t_emp4 테이블의 name 필드의 제약조건 예
--부모테이블이 삭제되면 null 이 되도록 설정하기(ALTER사용)

ALTER TABLE t_emp4 DROP CONSTRAINT emp4_name_fk;--잃일단 기존 제약조건 삭제 drop으러
ALTER TABLE t_emp4 ADD CONSTRAINT emp4_name_fk FOREIGN KEY(name) REFERENCES t_emp2(name)
		ON DELETE SET NULL --부모삭제되면 자식은 null로 변환
;



--------------------------------------------------------
--DISABLE NOVALIDATE

--- #9010
SELECT * FROM t_novalidate;
SELECT * FROM t_validate;

SELECT OWNER, CONSTRAINT_NAME , CONSTRAINT_TYPE, STATUS 
FROM USER_CONSTRAINTS
WHERE table_name = 'T_VALIDATE';

SELECT OWNER, CONSTRAINT_NAME , CONSTRAINT_TYPE, STATUS 
FROM USER_CONSTRAINTS
WHERE table_name = 'T_NOVALIDATE'; --primary key존재해서 

INSERT INTO t_novalidate VALUES(1, 'DDD'); --처음에는 에러!  두번쨰 실행시 성공

ALTER TABLE T_NOVALIDATE
DISABLE NOVALIDATE CONSTRAINT SYS_C007031; --PRIMARY KEY를 disable시킨후  , 다시 인에이블 시킬수없다  이미 PK에 1이 2개 들어있기때문에 데이터를 정리시켜주어야한다.

SELECT * FROM T_NOVALIDATE ;

DELETE FROM t_novalidate WHERE name = 'DDD'; --DATA 삭제

ALTER TABLE T_NOVALIDATE
ENABLE NOVALIDATE CONSTRAINT SYS_C007031;--  data삭제후  

SELECT OWNER, CONSTRAINT_NAME , CONSTRAINT_TYPE, STATUS 
FROM USER_CONSTRAINTS
WHERE table_name = 'T_NOVALIDATE';--다시 실행시 enable로바뀜!!!