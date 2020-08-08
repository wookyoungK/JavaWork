package com.lec.spring.resume.service;

import com.lec.spring.resume.domain.resumeWriteVO;
import com.lec.spring.resume.persistence.resumeDAO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class resumeWriteService {

    @Autowired
    private SqlSession sqlsession;

    public resumeDAO dao;

    public void resumeWrite( int uid,  String subject,  String name,  int gender,  String birth,  String email,  String phonenum,  String address1,  String address2,  String status,  String education,  String schoolname,  String schoolarea,  String schoolperiod ,  String major,  String uniyear,  String uniname,  String uniperiod,  String unimajor,  String unidep,  String uniarea,  String finaledu,  String career,  String comname,  String comperiod,  String composition,  String comjobtype,  String comincome,  String totalcareer,  String servicetype,  String hopeincome,  String workarea,  String joptype, String introduction,  String introdTtile, String toeic,  String port ){

        dao =  sqlsession.getMapper(resumeDAO.class);

        dao.resumeWrite(uid, subject, name, gender,  birth,  email,  phonenum,  address1,  address2,  status,  education,  schoolname,  schoolarea,  schoolperiod ,  major, uniyear,  uniname,  uniperiod, unimajor,  unidep,  uniarea,  finaledu,  career,  comname,  comperiod, composition,  comjobtype,  comincome,  totalcareer,  servicetype,  hopeincome, workarea,  joptype,  introduction,  introdTtile,  toeic,  port);
    }


}
