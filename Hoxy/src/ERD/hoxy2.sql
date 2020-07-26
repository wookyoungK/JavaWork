SELECT * FROM Hire;

CREATE TABLE Hire
(

    h_uid number NOT NULL,
    C_UID number not null,
    h_name varchar2(200) NOT NULL,
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
    h_regDate varchar2(100) not null,
    PRIMARY KEY (h_uid)
);

DROP TABLE Hire CASCADE CONSTRAINTS;
DROP SEQUENCE hire_seq;
CREATE SEQUENCE hire_seq;
CREATE SEQUENCE company_seq;
DROP SEQUENCE company_seq;

INSERT INTO Hire (h_uid,C_UID,h_name,h_title,h_content,h_salary,h_position1,h_position2,h_part,h_career,h_degree,h_workform,h_upDate,h_regDate)VALUES
(hire_seq.nextval,1,'LG',
 '코리아it아카데미','첫번째','2000~3000','수원시','강남역','대리','사원','학력무관','인턴',sysdate,sysdate);
INSERT INTO Hire (h_uid,C_UID,h_name,h_title,h_content,h_salary,h_position1,h_position2,h_part,h_career,h_degree,h_workform,h_upDate,h_regDate)VALUES
(hire_seq.nextval,2,'SK','케이티뱅크','첫번째','2000~3000','서울시',
 '강남역','인턴','사원','초대졸','인턴',sysdate,sysdate);

commit;

select to_date(h_regDate, 'YYYY-MM-DD')-round(sysdate) from Hire;


SELECT h_uid "uid",h_title title, h_career career,to_date(h_regDate, 'YYYY-MM-DD')-round(sysdate) remain
FROM
    HIRE
ORDER
    BY
    h_uid DESC;