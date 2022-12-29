package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
	public static void main(String[] args) {
		
		// 1. JDBC Driver Loading 단계
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩 성공");
			String jdbc_url = "jdbc:mysql://127.0.0.1:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			String id="root";
			String pw="test1234";
			
			// 2.Database 접속
			Connection con = DriverManager.getConnection(jdbc_url, id, pw);
			System.out.println("데이터베이스 접속 성공");
			
			/*
			 * // 3.일반 Statement 생성 Statement stmt = con.createStatement();
			 * 
			 * // 4.Query를 작성해서 실행 String keyword="자바"; String
			 * sql="select bisbn, btitle, bauthor,bprice FROM book WHERE btitle LIKE '%'"
			 * +keyword+"%'"; ResultSet rs = stmt.executeQuery(sql);
			 */
			
			// PreparedStatement로 사용
			// PreparedStatement는 sql을 가지고 생성
			// PreparedStatement는 IN Parameter를 이용할 수 있다 -> ?로 표현
			// keyword 부분에는 ?(IN Parameter) 사용불가
			String keyword="여행";
			String sql="select bisbn, btitle, bauthor,bprice FROM book WHERE btitle LIKE ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			// 실행하기 전 ?를 채워야 한다
			pstmt.setString(1, "%"+keyword+"%");
			ResultSet rs = pstmt.executeQuery();
			// 5.결과처리
			//rs.next();
			//String title = rs.getString("btitle");
			//String title = rs.getString(2); index를 이용해도 된다 단, index 1부터 시작
			//int price = rs.getInt("bprice");
			//System.out.println("책 제목은 : "+title);
			String title="";
			while(rs.next())
			{
				title = rs.getString(2);
				System.out.println("책 제목은 : "+title);
			}
			
			// 6.사용한 자원 해제
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
