package com.lec.java.db03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lec.java.db.Query;

// 공통적으로 사용하는 상수들 인터페이스에 담아서 처리.
// PreparedStatement 방식************************************************************************
//statement 과  PreparedStatement 에서의 차이는 statment 자유롭다 정해진것없이 내가 만들어준것으로 변경하지만 
// PreparedStatement는 정해진 테이블에만 들어간다 
public class DB03Main implements Query {

	public static void main(String[] args) {
		System.out.println("DB 3 - PreparedStatement");

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(DRIVER);
			System.out.println("드라이버 로딩 성공");

			conn = DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("DB Connection 성공");
			
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setInt(1, 10); //첫번째 ? 는 1부터 시작! ,type 도 잘보기
			pstmt.setString(2, "헐크");   // ?개수 = index개수 인듯 , ?개수만큼 데이터추가해줘야한다. 하나라도 없으면 에러 ;
			pstmt.setString(3, "2000-10-10"); 
			int cnt = pstmt.executeUpdate(); // DML은 정수값을 리턴한다   그 이유는??
			System.out.println(cnt + " 개 행(row) INSERT성공");
			
			
			System.out.println();
			System.out.println("UPDATE");
			pstmt.close();
			pstmt =conn.prepareStatement(SQL_UPDATE_BIRTHDATE);
			pstmt.setString(1, "2020-01-01");
			pstmt.setInt(2, 10);
			cnt =pstmt.executeUpdate();
			System.out.println(cnt+ " 개 행(row) UPDATE성공");
			
//			pstmt.close();  prepareStatement는중간중간에 추가 변경하기 어렵다 그래서 만약 싸용하려면 이렇게 사용해야된다.
//			pstmt = conn.prepareStatement(SQL_UPDATE_BIRTHDATE);
			
			
			//추가 나 ,변경할때는 executeUpdate 
			//검색 조회할때에는  executeQurey
			//statement 비교해보면 ()들어가는 값이  ???으로 정해저있고 , statement는 내가원하는것을 넣어줄수있다.!!
			System.out.println();
			System.out.println("SELECT");
			pstmt.close();
			
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString(COL_LABEL_NO);
				String name = rs.getString(COL_LABEL_NAME);
				String birthdate = rs.getString(COL_LABEL_BIRTHDATE);
				System.out.println(no + " | "+name+" | "+birthdate);
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)rs.close();
				if (pstmt != null)pstmt.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	} // end main()

} // end class DB03Main
