SELECT *FROM Hire;
CREATE SEQUENCE hire_seq;
Drop table Hire cascade constraints;
DROP TABLE Hire CASCADE CONSTRAINTS;
DROP SEQUENCE hire_seq;
CREATE SEQUENCE hire_seq;
CREATE SEQUENCE company_seq;
SELECT *FROM huser;

CREATE TABLE Hire
(

    h_uid       number           NOT NULL,
    c_uid      number           not null,
    h_name      varchar2(400)    NOT NULL,
    h_title     varchar2(400)    NOT NULL,
    h_content   clob,
    h_salary    varchar2(400)    NOT NULL,
    h_position1 varchar2(200)    NOT NULL,
    h_position2 varchar2(600)    NOT NULL,
    h_part      varchar2(400),
    -- 중복되게...1011 이진수....
    h_career    varchar2(400)    NOT NULL,
    h_degree    varchar2(400)    NOT NULL,
    h_workform  varchar2(400)    NOT NULL,
    h_cnt       number default 0 NOT NULL,
    h_upDate    varchar2(400)    NOT NULL,
    h_regDate   varchar2(400)    not null,
    PRIMARY KEY (h_uid)
);

INSERT INTO Hire (h_uid,C_UID,h_name,h_title,h_content,h_salary,h_position1,h_position2,h_part,h_career,h_degree,h_workform,h_upDate,h_regDate)VALUES
(hire_seq.nextval,1,'SAMSUNG',
 '에스피테크놀리지','http://www.smilegate.com/ko/images/recruit/stoveImg/header_megaport.png','2400~2600','서울시','강남역','JAVA','경력','대졸','정규직','2020-08-04','2020-08-8');
commit;






