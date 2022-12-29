package JDBC.TEST;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import JDBC.VO.TestClass;

public class MySQL_Test02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String keyword = scan.next();
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			String jdbc_url = "jdbc:mysql://127.0.0.1:3306/mysql_test_db?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			String id="root";
			String pw="test1234";

			Connection con=DriverManager.getConnection(jdbc_url,id,pw);
			
			con.setAutoCommit(false);
			
			String sql="SELECT D.CATEGORY, D.DEPARTMENT_NAME, D.CAPACITY "
					+ "FROM tb_department D "
					+ "WHERE D.CATEGORY = ? AND D.CAPACITY BETWEEN 20 AND 30 "
					+ "ORDER BY D.DEPARTMENT_NAME";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,keyword);
			
			ResultSet rs=pstmt.executeQuery();
			
			ArrayList<TestClass> list = new ArrayList<TestClass>();

			while(rs.next()){ 
				TestClass testclass = new TestClass(rs.getString("D.CATEGORY"), rs.getString("D.DEPARTMENT_NAME"), rs.getInt("D.CAPACITY"));
	            list.add(testclass);
	        }
			 
			for(TestClass testclass: list) {
				System.out.println(testclass);
	        }

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
