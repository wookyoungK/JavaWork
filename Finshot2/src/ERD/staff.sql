
/* Drop Tables */

DROP TABLE test_staff CASCADE CONSTRAINTS;




/* Create Tables */

SELECT * FROM test_staff;

CREATE TABLE test_staff
(
	wr_uid number NOT NULL,
	wr_name varchar2(20) NOT NULL,
	wr_position varchar2(50) NOT NULL,
	wr_phone varchar2(50) NOT NULL,
	wr_email varchar2(50) NOT NULL,
	PRIMARY KEY (wr_uid)
);

INSERT INTO test_staff(wr_uid,wr_name,wr_position,wr_phone,wr_email) values(441,'손오공','대리','010-2312-2132','pk@naver.com');
INSERT INTO test_staff(wr_uid,wr_name,wr_position,wr_phone,wr_email) values(112,'홍길동','경리','010-1313-1423','p3@gamil.com');
INSERT INTO test_staff(wr_uid,wr_name,wr_position,wr_phone,wr_email) values(223,'김아나','사원','010-3333-3333','prqw@daum.net');
INSERT INTO test_staff(wr_uid,wr_name,wr_position,wr_phone,wr_email) values(423,'김하나','사원','010-2222-2222','asd2@nate.com');
INSERT INTO test_staff(wr_uid,wr_name,wr_position,wr_phone,wr_email) values(233,'김사나','사원','010-1111-1111','pdw@naver.com');
