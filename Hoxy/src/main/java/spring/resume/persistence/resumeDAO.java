package com.lec.spring.resume.persistence;


import com.lec.spring.resume.domain.resumeListDTO;
import com.lec.spring.resume.domain.resumeUpdateDTO;
import com.lec.spring.resume.domain.resumeViewDTO;
import com.lec.spring.resume.domain.resumeWriteVO;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan
public interface resumeDAO {
   int filesave(final int uid, final String source);
   int deleteFile(final int uid);
   int resumeWrite(final int uid, final String subject, final String name, final int gender, final String birth, final String email, final String phonenum, final String address1, final String address2, final String status, final String education, final String schoolname, final String schoolarea, final String schoolperiod, final String major, final String uniyear, final String uniname, final String uniperiod, final String unimajor, final String unidep, final String uniarea, final String finaledu, final String career, final String comname, final String comperiod, final String composition, final String comjobtype, final String comincome, final String totalcareer, final String servicetype, final String hopeincome, final String workarea, final String joptype, final String introduction, final String introdTtile, final String toeic, final String port);
   List<resumeListDTO> selectAll(int uid);
   int resumeDelete(final int uid);

   int resumeUpdate(final String subject, final String name, final int gender, final String birth, final String email, final String phonenum, final String address1, final String address2, final String status,final String servicetype, final String hopeincome, final String workarea, final String joptype, final int uid);

   resumeViewDTO select(final int uid);
   resumeUpdateDTO updateSelect(int uid);
}
