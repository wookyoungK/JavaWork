
/* Drop Tables */
DROP TABLE HireImage CASCADE CONSTRAINTS;
DROP TABLE referenceHire CASCADE CONSTRAINTS;
DROP TABLE Hire CASCADE CONSTRAINTS;
DROP TABLE Company CASCADE CONSTRAINTS;


/* Drop Sequences */
DROP SEQUENCE SEQ_Admin_a_uid;
DROP SEQUENCE SEQ_Application_A_uid;
DROP SEQUENCE SEQ_board_b_uid;
DROP SEQUENCE SEQ_Company_c_uid;
DROP SEQUENCE SEQ_Hire_h_uid;
DROP SEQUENCE SEQ_Resume_r_uid;
DROP SEQUENCE SEQ_User_u_uid;



/* Create Sequences */
CREATE SEQUENCE SEQ_Admin_a_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_Application_A_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_board_b_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_Company_c_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_Hire_h_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_Resume_r_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_User_u_uid INCREMENT BY 1 START WITH 1;



CREATE SEQUENCE company_seq;

/* Create Tables */

CREATE TABLE Company
(
	c_uid number NOT NULL,
	c_name varchar2(50) NOT NULL,
	PRIMARY KEY (c_uid)
);


CREATE TABLE Hire
(
	
	h_uid number NOT NULL,
	c_uid number NOT NULL,
	h_title varchar2(200) NOT NULL,
	h_content clob,
	h_salary varchar2(50) NOT NULL,
	h_position1 varchar2(100) NOT NULL,
	h_position2 varchar2(100) NOT NULL,
	h_part varchar2(10),
	-- 중복되게...1011 이진수....
	h_career varchar2(20) NOT NULL,
	h_degree varchar2(20) NOT NULL,
	h_workform varchar2(100) NOT NULL,
	h_cnt number default 0 NOT NULL,
	h_upDate varchar2(100) NOT NULL,
	h_regDate varchar2(100),
	PRIMARY KEY (h_uid)
);


CREATE TABLE HireImage
(
	rf_uid number NOT NULL,
	h_uid number NOT NULL UNIQUE,
	rf_source varchar2(100) NOT NULL,
	rf_file varchar2(100) NOT NULL,
	-- 0 : 회사 로고
	-- 1 : 회사 상세모집내용
	-- 
	rf_status number NOT NULL,
	PRIMARY KEY (rf_uid)
);

SELECT * FROM COMPANY;
SELECT * FROM HIRE ;



CREATE TABLE referenceHire
(
	RH_id number NOT NULL,
	h_uid number NOT NULL UNIQUE,
	PRIMARY KEY (RH_id)
);


INSERT INTO COMPANY (c_uid,c_name)VALUES (company_seq.nextval,'김우경');
INSERT INTO COMPANY (c_uid,c_name)VALUES (company_seq.nextval,'남윤주');
INSERT INTO COMPANY (c_uid,c_name)VALUES (company_seq.nextval,'지우햄');
INSERT INTO COMPANY (c_uid,c_name)VALUES (company_seq.nextval,'수햄');
INSERT INTO COMPANY (c_uid,c_name)VALUES (company_seq.nextval,'진영햄');

INSERT INTO Hire (h_uid,c_uid,h_title,h_content,h_salary,h_position1,h_position2,h_part,h_career,h_degree,h_workform,h_upDate)VALUES 
(1,1,'코리아it아카데미','첫번째','2000~3000','수원시','강남역','대리','사원','학력무관','인턴','2020-07-20');













/* Create Foreign Keys */

ALTER TABLE Hire
	ADD FOREIGN KEY (c_uid)
	REFERENCES Company (c_uid)
;


ALTER TABLE HireImage
	ADD FOREIGN KEY (h_uid)
	REFERENCES Hire (h_uid)
;


ALTER TABLE referenceHire
	ADD FOREIGN KEY (h_uid)
	REFERENCES Hire (h_uid)
;





/* Comments */

COMMENT ON COLUMN Hire.h_career IS '중복되게...1011 이진수....';
COMMENT ON COLUMN HireImage.rf_status IS '0 : 회사 로고
1 : 회사 상세모집내용
';



