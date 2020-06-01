
/* Drop Tables */
drop sequence web_seq;
DROP TABLE Web CASCADE CONSTRAINTS;


CREATE TABLE Web(
	Pid number NOT NULL,
	Pname varchar2(20) NOT NULL,
	Pprice number DEFAULT 0 NOT NULL,
	Ppurchasecnt number NOT NULL,
	Pbrand varchar2(20),
	Pimage clob,
	Pcode number NOT NULL UNIQUE,
	PRIMARY KEY (Pid)
);

SELECT * FROM Web;

CREATE SEQUENCE web_seq;

SELECT * FROM seq WHERE sequence_name = 'WEB_SEQ';

INSERT INTO Web (Pid, Pname, Pprice,Ppurchasecnt, Pbrand, Pimage, Pcode)
VALUES (web_seq.nextval,'고목나무',100000,0
,'메이플스토리','https://adcr.naver.com/adcr?x=fps6Rx1137lpKEiWSh0XuqVAKEX7mPahSz8QUrNRiay4gfSkfQ==' ,
107);



SELECT * FROM test_write ORDER BY wr_uid DESC;
INSERT INTO Web(wr_uid, wr_subject, wr_content, wr_name)
	SELECT test_write_seq.nextVal, wr_subject, wr_content, wr_name FROM test_write;
/*
ALTER TABLE webtest
ADD (   
	Ppurchasecnt NUMBER
       );

SELECT * FROM webtest;	


--시퀀스
CREATE SEQUENCE WEBTEST;


--다량의 데이터 필요
SELECT * FROM test_write ORDER BY wr_uid DESC;
INSERT INTO test_write(wr_uid, wr_subject, wr_content, wr_name)
	SELECT test_write_seq.nextVal, wr_subject, wr_content, wr_name FROM test_write;

*/
