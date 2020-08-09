

/* Drop Tables */

DROP TABLE Application CASCADE CONSTRAINTS;
DROP TABLE boardfile CASCADE CONSTRAINTS;
DROP TABLE reply CASCADE CONSTRAINTS;
DROP TABLE board CASCADE CONSTRAINTS;
DROP TABLE HireImage CASCADE CONSTRAINTS;
DROP TABLE referenceHire CASCADE CONSTRAINTS;
DROP TABLE Hire CASCADE CONSTRAINTS;
DROP TABLE Company CASCADE CONSTRAINTS;
DROP TABLE graphColor CASCADE CONSTRAINTS;
DROP TABLE graphList CASCADE CONSTRAINTS;
DROP TABLE HAdmin CASCADE CONSTRAINTS;
DROP TABLE ResumeFile CASCADE CONSTRAINTS;
DROP TABLE Resume CASCADE CONSTRAINTS;
DROP TABLE HUser CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_Admin_a_uid;
DROP SEQUENCE SEQ_Application_A_uid;
DROP SEQUENCE SEQ_board_b_uid;
DROP SEQUENCE SEQ_Company_c_uid;
DROP SEQUENCE SEQ_HAdmin_a_uid;
DROP SEQUENCE SEQ_Hire_h_uid;
DROP SEQUENCE SEQ_HUser_u_uid;
DROP SEQUENCE SEQ_Resume_r_uid;
DROP SEQUENCE SEQ_User_u_uid;
DROP SEQUENCE reply_seq;



/* Create Sequences */

CREATE SEQUENCE SEQ_Admin_a_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_Application_A_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_board_b_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_Company_c_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_HAdmin_a_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE hire_seq INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_HUser_u_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_Resume_r_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_User_u_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE reply_seq INCREMENT BY 1 START WITH 1;



/* Create Tables */

CREATE TABLE Application
(
    a_uid number NOT NULL,
    a_date date DEFAULT SYSDATE NOT NULL,
    -- 0 : 미열람
    -- 1 : 열람
    a_view number NOT NULL,
    u_uid number NOT NULL,
    h_uid number NOT NULL UNIQUE,
    r_uid number NOT NULL,
    PRIMARY KEY (a_uid)
);


CREATE TABLE board
(
    -- 게시글고유번호
    b_uid number NOT NULL,
    -- 글 제목
    b_subject varchar2(200) NOT NULL,
    -- 내용
    b_content clob,
    b_regdate date DEFAULT SYSDATE NOT NULL,
    b_viewcnt number DEFAULT 0 NOT NULL,
    -- 0 : 공지사항 ( 관리자 )
    -- 1 : 기업정보 공유
    -- 2 : 합격후기
    -- 3 : 면접후기
    -- 4 : 퇴사후기
    --
    b_category varchar2(20) NOT NULL,
    u_uid number NOT NULL,
    c_uid number,
    PRIMARY KEY (b_uid)
);


CREATE TABLE boardfile
(
    bf_id number NOT NULL,
    bf_imgsource varchar2(100) NOT NULL,
    bf_imgsource2 varchar2(100) NOT NULL,
    -- 게시글고유번호
    b_uid number NOT NULL,
    PRIMARY KEY (bf_id)
);


CREATE TABLE Company
(
    c_uid number NOT NULL,
    c_id varchar2(20) NOT NULL UNIQUE,
    c_pw varchar2(20) NOT NULL,
    c_name varchar2(20) NOT NULL,
    c_ceoName varchar2(10) NOT NULL,
    -- ex) 인천 계양구 도두리로74
    c_address1 varchar2(100) NOT NULL,
    -- ex) 대동아파트 525동 905호
    c_address2 varchar2(100) NOT NULL,
    c_postNum varchar2(5) NOT NULL,
    c_cnum varchar2(20) NOT NULL UNIQUE,
    c_form varchar2(12) NOT NULL,
    c_employees number NOT NULL,
    c_category varchar2(10) NOT NULL,
    c_auth varchar2(24) DEFAULT 'ROLE_COMPANY',
    enabled char(1) DEFAULT 1,
    PRIMARY KEY (c_uid)
);


CREATE TABLE graphColor
(
    gcid number NOT NULL,
    -- rgb코드
    --
    color1 varchar2(10) NOT NULL,
    color2 varchar2(10) NOT NULL,
    color3 varchar2(10) NOT NULL,
    PRIMARY KEY (gcid)
);


CREATE TABLE graphList
(
    -- 0~7 존재
    graphid number NOT NULL,
    -- 0 : 공개
    -- 1 : 비공개
    graphView1 number NOT NULL,
    graphView2 number NOT NULL,
    graphView3 number NOT NULL,
    graphView4 number NOT NULL,
    graphView5 number NOT NULL,
    graphView6 number NOT NULL,
    graphView7 number NOT NULL,
    PRIMARY KEY (graphid)
);


CREATE TABLE HAdmin
(
    a_uid number NOT NULL,
    a_id varchar2(20) NOT NULL,
    a_pw varchar2(20) NOT NULL,
    a_auth varchar2(24) DEFAULT 'ROLE_ADMIN',
    enabled char(1) default 1,
    PRIMARY KEY (a_uid)
);


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


CREATE TABLE HUser
(
    u_uid number NOT NULL,
    u_id varchar2(20) NOT NULL UNIQUE,
    u_pw varchar2(20) NOT NULL,
    u_name varchar2(10) NOT NULL,
    u_jumin varchar2(13) NOT NULL,
    u_email varchar2(50) NOT NULL UNIQUE,
    -- '-' 이거는 빼주세연
    --
    u_phoneNum varchar2(11) NOT NULL,
    -- 0 : 소셜 비인증
    -- 1 : 페이스북 인증
    -- 2 : 구글 인증
    --
    u_key varchar2(50),
    u_auth varchar2(24) DEFAULT 'ROLE_USER',
    enabled char(1) default 1,
    PRIMARY KEY (u_uid)
);


CREATE TABLE referenceHire
(
    RH_id number NOT NULL,
    h_uid number NOT NULL UNIQUE,
    PRIMARY KEY (RH_id)
);


CREATE TABLE reply
(
    rep_uid number NOT NULL,
    rep_content clob NOT NULL,
    rep_regdate date DEFAULT SYSDATE NOT NULL,
    -- 게시글고유번호
    b_uid number NOT NULL,
    u_uid number NOT NULL,
    PRIMARY KEY (rep_uid)
);


CREATE TABLE Resume
(
    r_uid number NOT NULL,
    u_uid number NOT NULL,
    r_title varchar2(50) NOT NULL,
    r_name varchar2(20) NOT NULL,
    -- 0 : 남자
    -- 1 : 여자
    r_gender number NOT NULL,
    r_dateofbirth varchar2(10) NOT NULL,
    r_email varchar2(50) NOT NULL,
    r_phonenum varchar2(20) NOT NULL,
    r_address1 varchar2(50) NOT NULL,
    r_address2 varchar2(50) NOT NULL,
    -- 구직준비중
    -- 재학생
    -- 구직중
    -- 재직중
    r_status varchar2(20) NOT NULL,
    -- 초등학교 졸업
    -- 중학교 졸업
    --  고등학교 졸업
    -- 대학, 대학원 이상 졸업
    --
    r_education varchar2(20) NOT NULL,
    -- // 최종학력
    -- (초중고)
    r_schoolname varchar2(50) NOT NULL,
    r_area varchar2(20),
    r_period varchar2(20) NOT NULL,
    -- 이공계, 인문계 등등
    --
    r_major varchar2(20),
    -- 최종학력 입력
    --
    r_universityyear varchar2(20),
    r_universityname varchar2(30),
    -- 형식yyyy-mm-yyyy-mm
    r_universityperiod varchar2(20),
    -- 인문계열, 공학 등등
    --
    r_universitymajor varchar2(20),
    r_universitydepartment varchar2(20),
    r_universityarea varchar2(10),
    r_finaledu varchar2(30) NOT NULL,
    -- 신입/경력
    r_career varchar2(20) NOT NULL,
    r_companyname varchar2(20),
    -- yyyy-mm-yyyy-mm
    --
    r_companyperiod varchar2(30),
    r_companyposition varchar2(20),
    r_companyjobtype varchar2(20),
    r_companyincome varchar2(20),
    -- 개월
    --
    r_totalcareer number,
    -- 희망근무형태
    --
    r_servicetype varchar2(30) NOT NULL,
    r_hopeincome varchar2(30) NOT NULL,
    r_workarea varchar2(30) NOT NULL,
    r_jobtype varchar2(30) NOT NULL,
    r_introduction clob,
    r_introdTtitle varchar2(50),
    r_toeic number,
    r_date date DEFAULT SYSDATE NOT NULL,
    r_portfolio varchar2(200),
    PRIMARY KEY (r_uid)
);


CREATE TABLE ResumeFile
(
    rf_uid number NOT NULL,
    r_uid number NOT NULL,
    rf_source varchar2(100) NOT NULL,
    rf_file varchar2(100) NOT NULL,
    PRIMARY KEY (rf_uid)
);



/* Create Foreign Keys */

ALTER TABLE boardfile
    ADD FOREIGN KEY (b_uid)
        REFERENCES board (b_uid)
            ON DELETE CASCADE
;


ALTER TABLE reply
    ADD FOREIGN KEY (b_uid)
        REFERENCES board (b_uid)
            ON DELETE CASCADE
;


ALTER TABLE board
    ADD FOREIGN KEY (c_uid)
        REFERENCES Company (c_uid)
            ON DELETE CASCADE
;


ALTER TABLE Hire
    ADD FOREIGN KEY (c_uid)
        REFERENCES Company (c_uid)
            ON DELETE CASCADE
;


ALTER TABLE Application
    ADD FOREIGN KEY (h_uid)
        REFERENCES Hire (h_uid)
            ON DELETE CASCADE
;


ALTER TABLE HireImage
    ADD FOREIGN KEY (h_uid)
        REFERENCES Hire (h_uid)
            ON DELETE CASCADE
;


ALTER TABLE referenceHire
    ADD FOREIGN KEY (h_uid)
        REFERENCES Hire (h_uid)
            ON DELETE CASCADE
;


ALTER TABLE Application
    ADD FOREIGN KEY (u_uid)
        REFERENCES HUser (u_uid)
            ON DELETE CASCADE
;


ALTER TABLE board
    ADD FOREIGN KEY (u_uid)
        REFERENCES HUser (u_uid)
            ON DELETE CASCADE
;


ALTER TABLE reply
    ADD FOREIGN KEY (u_uid)
        REFERENCES HUser (u_uid)
            ON DELETE CASCADE
;


ALTER TABLE Resume
    ADD FOREIGN KEY (u_uid)
        REFERENCES HUser (u_uid)
            ON DELETE CASCADE
;


ALTER TABLE Application
    ADD FOREIGN KEY (r_uid)
        REFERENCES Resume (r_uid)
            ON DELETE CASCADE
;


ALTER TABLE ResumeFile
    ADD FOREIGN KEY (r_uid)
        REFERENCES Resume (r_uid)
            ON DELETE CASCADE
;

-- HUser
INSERT INTO HUser VALUES (SEQ_HUser_u_uid.nextval, 'jiwoo', '1234', '윤지우', '0012341234567', 'lsvn1541@naver.com', '01012345678', 'Y', 'ROLE_USER', '1');
INSERT INTO HUser VALUES (SEQ_HUser_u_uid.nextval, 'suyoung', '1234', '장수영', '9912341234567', 'SY@test.com', '01022345678', 'Y', 'ROLE_USER', '1');
INSERT INTO HUser VALUES (SEQ_HUser_u_uid.nextval, 'jinyoung', '1234', '김진영', '9812341234567', 'JY@test.com', '01032345678', 'Y', 'ROLE_USER', '1');
INSERT INTO HUser VALUES (SEQ_HUser_u_uid.nextval, 'wookyoung', '1234', '김우경', '9712341234567', 'WK@test.com', '01042345678', 'Y', 'ROLE_USER', '1');
INSERT INTO HUser VALUES (SEQ_HUser_u_uid.nextval, 'yunju', '1234', '남윤주', '9612341234567', 'YJ@test.com', '01052345678', 'Y', 'ROLE_USER', '1');
INSERT INTO HUser VALUES (SEQ_HUser_u_uid.nextval, 'ji', '1234', '지성', '9612341234567', 'JI@test.com', '01052345678', 'Y', 'ROLE_USER', '1');
INSERT INTO HUser VALUES (SEQ_HUser_u_uid.nextval, 'sung', '1234', '성용', '9612341234567', 'SU@test.com', '01062345678', 'Y', 'ROLE_USER', '1');
INSERT INTO HUser VALUES (SEQ_HUser_u_uid.nextval, 'mi', '1234', '미인', '9612341234567', 'MI@test.com', '01072345678', 'Y', 'ROLE_USER', '1');
INSERT INTO HUser VALUES (SEQ_HUser_u_uid.nextval, 'ggak', '1234', '각기', '9612341234567', 'GA@test.com', '01082345678', 'Y', 'ROLE_USER', '1');
INSERT INTO HUser VALUES (SEQ_HUser_u_uid.nextval, 'banana', '1234', '과일', '9612341234567', 'BA@test.com', '01092345678', 'Y', 'ROLE_USER', '1');

--INSERT INTO HUser VALUES (SEQ_HUser_u_uid.nextval, 'test', '1234', 'test', '9512341234567', 'test@test.com', '01062345678', 'Y', 'ROLE_USER', '1');



-- Company
INSERT INTO Company VALUES (SEQ_Company_c_uid.nextval, 'SAMSUNG', '1234', 'SAMSUNG', '윤지우', '서울특별시 서초구 서초대로74길 27', '강남역 한화오벨리스크', '06621', '1', '대기업', '90000', 'IT', 'ROLE_COMPANY', '1');
INSERT INTO Company VALUES (SEQ_Company_c_uid.nextval, 'LG', '1234', 'LG', '장수영', '서울특별시 서초구 서초대로74길 51', '강남역 롯데골드로즈', '06626', '2', '대기업', '80000', 'IT', 'ROLE_COMPANY', '1');
INSERT INTO Company VALUES (SEQ_Company_c_uid.nextval, 'SK', '1234', 'SK', '김진영', '서울특별시 서초구 서초대로78길 52', '강남역 인앤인', '06626', '3', '대기업', '70000', 'IT', 'ROLE_COMPANY', '1');
INSERT INTO Company VALUES (SEQ_Company_c_uid.nextval, 'GS', '1234', 'GS', '김우경', '서울특별시 서초구 효령로77길 30', '강남역 푸르지오시티', '06627', '4', '대기업', '60000', 'IT', 'ROLE_COMPANY', '1');
--INSERT INTO Company VALUES (SEQ_Company_c_uid.nextval, 'POSCO', '1234', 'POSCO', '남윤주', '인천 계구 도로5', '아동아파트 53동 95호', '52345', '5', '대기업', '50000', 'IT', 'ROLE_COMPANY', '1');
--INSERT INTO Company VALUES (SEQ_Company_c_uid.nextval, 'KT', '1234', 'KT', '임상빈', '인천 계구 도로6', '치동아파트 53동 96호', '62345', '6', '중견기업', '40000', 'IT', 'ROLE_COMPANY', '1');
--INSERT INTO Company VALUES (SEQ_Company_c_uid.nextval, 'CJ', '1234', 'CJ', '홍성용', '인천 계구 도로7', '카동아파트 53동 97호', '72345', '7', '중견기업', '30000', 'IT', 'ROLE_COMPANY', '1');
--INSERT INTO Company VALUES (SEQ_Company_c_uid.nextval, 'LS', '1234', 'LS', '임성용', '인천 계구 도로8', '배동아파트 53동 98호', '82345', '8', '중견기업', '20000', 'IT', 'ROLE_COMPANY', '1');
--INSERT INTO Company VALUES (SEQ_Company_c_uid.nextval, 'SOIL', '1234', 'SOIL', '임성용', '인천 계구 도로9', '배동아파트 53동 99호', '92345', '9', '중소기업', '10000', 'IT', 'ROLE_COMPANY', '1');
--INSERT INTO Company VALUES (SEQ_Company_c_uid.nextval, 'KAKAO', '1234', 'KAKAO', '홍상용', '인천 계구 도로10', '배동아파트 53동 88호', '77345', '10', '중소기업', '9000', 'IT', 'ROLE_COMPANY', '1');


-- Admin
INSERT INTO HAdmin VALUES (SEQ_HAdmin_a_uid.nextval, 'ADMIN', '1234', 'ROLE_ADMIN', '1');


COMMIT;

