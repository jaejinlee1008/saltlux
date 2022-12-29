package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class Main {
	
	private static BasicDataSource basicDS;
	
	static
	{
		// Connection Pool을 생성
		basicDS = new BasicDataSource();
		basicDS.setDriverClassName("com.mysql.cj.jdbc.Driver");
		basicDS.setUrl("jdbc:mysql://127.0.0.1:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true");
		basicDS.setUsername("root");
		basicDS.setPassword("test1234");
		basicDS.setInitialSize(10);
		basicDS.setMaxTotal(20);
	}
	
	public static DataSource getDataSource()
	{
		// BasicDataSource의 상위 interface 타입 DataSource이다.
		// 외부 클래스에서 이용할 수 있도록 public으로 하여 basicDS를 리턴한다.
		return basicDS;
	}
	
	public static void main(String[] args) {
		// DBCP사용에 대해서 알아본다
		DataSource ds = getDataSource();  // Connection Pool을 가져온다.
		Connection con = null;
		try {
			con = ds.getConnection();  // Connection Pool에서 Connection을 빌려온다.
			String sql = "SELECT btitle, bauthor FROM book";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString("btitle"));
			}
			rs.close();
			pstmt.close();
			con.close(); // 연결을 끊는 작업을 하는게 아니라 Pool에 반납한다.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
