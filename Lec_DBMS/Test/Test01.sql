CREATE TABLE practice (
pb_uid NUMBER PRIMARY KEY,
    name VARCHAR2(10) NOT NULL,
    phone VARCHAR2(14) DEFAULT '010-0000-0000', 
    regDate DATE
);
DROp SEQUENCE practice_seq;
CREATE SEQUENCE practice_seq;

SELECT * FROM seq WHERE sequence_name = 'PRACTICE_SEQ';
SELECT * FROM PRACTICE;
INSERT INTO practice (pb_uid,name ,regDate,addr)
VALUES (practice_seq.nextval,'d',sysDate,'주소');

UPDATE PRACTICE SET name='bb' WHERE name='gg';
DELETE FROM PRACTICE WHERE pb_uid =2;

ALTER TABLE PRACTICE 
MODIFY (
		name VARCHAR2(15)
);

ALTER TABLE PRACTICE 
add (
		addr VARCHAR2(15)
);

ALTER TABLE PRACTICE DROP (addr);

DROP TABLE PRACTICE CASCADE CONSTRAINT PURGE;
DESC practice;

SELECT tname FROM tab;
--테이블구조확인