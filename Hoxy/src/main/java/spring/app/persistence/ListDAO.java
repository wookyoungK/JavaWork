package com.lec.spring.app.persistence;

import com.lec.spring.app.domain.ColorDTO;
import com.lec.spring.app.domain.ListDTO;

import java.util.List;

public interface ListDAO {

    List<ListDTO> select();
    int update(int graphView1,int graphView2,int graphView3,int graphView4,int graphView5,int graphView6,int graphView7);

}
