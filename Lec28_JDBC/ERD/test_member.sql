
/* Drop Tables */

DROP TABLE test_member CASCADE CONSTRAINTS;

/* Create Tables */

CREATE TABLE test_member  -- member , mb_  알아보기쉽게하기위하여 앞에붙여준것
(
	mb_no number,
	mb_name varchar2(40) NOT NULL,
	mb_birthdate date
);

--시퀀스
DROP SEQUENCE test_member_seq; --혹시 그전에 있을경우 제거 
CREATE SEQUENCE test_member_seq;

DELETE FROM TEST_MEMBER ;

SELECT * FROM TEST_MEMBER ORDER BY mb_no DESC;


