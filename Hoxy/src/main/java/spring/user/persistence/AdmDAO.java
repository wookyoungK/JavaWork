package com.lec.spring.user.persistence;

import com.lec.spring.user.domain.AdmDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmDAO {

    int checkOverId(String a_id);
    AdmDTO loginAdm(@Param("a_id")String a_id);

}
