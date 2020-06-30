
/* Drop Tables */

DROP TABLE board CASCADE CONSTRAINTS;
DROP TABLE test_write CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE board
(
	b_uid number NOT NULL,
	b_subject varchar2(200) NOT NULL,
	b_content clob NOT NULL,
	b_name varchar2(20),
	b_viewcnt number DEFAULT 0,
	b_regdate date DEFAULT SYSDATE,
	PRIMARY KEY (b_uid)
);


CREATE TABLE test_write
(
	b_uid number NOT NULL,
	b_subject varchar2(200) NOT NULL,
	b_content clob,
	b_name varchar2(20) NOT NULL,
	b_viewcnt number DEFAULT 0,
	b_regdate date DEFAULT SYSDATE,
	PRIMARY KEY (b_uid)
);



