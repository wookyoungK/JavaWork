package com.lec.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

// DAO : Data Access Object
//   DB 에 접속하여 트랜잭션을 수행하는 객체
public class WriteDAO {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;   // SELECT 결과, executeQuery()
	
	// DAO 객체가 생성될때 Connection 도 생성된다.
	public WriteDAO() {
		
		
		
	} // 생성자

	
	
	
	
	
}










