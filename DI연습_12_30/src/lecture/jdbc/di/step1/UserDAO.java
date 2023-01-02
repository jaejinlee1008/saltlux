package lecture.jdbc.di.step1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// DAO는 단순 db처리 담당
public class UserDAO {
	
	
	//VO를 인자로 받아 쿼리문 및 db처리
	public void insert(User user)
	{
		// 일반 JDBC Code가 나옴
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String jdbc_url = "jdbc:mysql://127.0.0.1:3306/example01?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			String id = "root";
			String pw = "test1234";
			Connection con = DriverManager.getConnection(jdbc_url,id,pw);
			
			String sql = "INSERT INTO users VALUES (?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,user.getId());
			pstmt.setString(2,user.getName());
			pstmt.setString(3,user.getPw());
			
			int count = pstmt.executeUpdate();
			
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

	public User select(String string) {
		User user = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String jdbc_url = "jdbc:mysql://127.0.0.1:3306/example01?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			String id = "root";
			String pw = "test1234";
			Connection con = DriverManager.getConnection(jdbc_url,id,pw);
			
			String sql = "SELECT * FROM users WHERE id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,string);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			user =  new User(rs.getString("id"),rs.getString("name"),rs.getString("pw"));
			
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
		
		return user;
	}
	
}
