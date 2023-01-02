package lecture.jdbc.di.step4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


// 다른 클래스 (SimpleConnectionMaker)에 강하게 의존함
public class UserDAO {
	private SimpleConnectionMaker simpleConnectionMaker;
	
	public UserDAO() {
		simpleConnectionMaker = new SimpleConnectionMaker();
	}
	
	public void insert(User user)
	{
		// 일반 JDBC Code가 나옴
		try {
			
			Connection con = simpleConnectionMaker.getConnection();
			String sql = "INSERT INTO users VALUES (?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,user.getId());
			pstmt.setString(2,user.getName());
			pstmt.setString(3,user.getPw());
			
			int count = pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public User select(String string) {
		User user = null;
		try {
			
			Connection con = simpleConnectionMaker.getConnection();
			String sql = "SELECT * FROM users WHERE id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,string);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			user =  new User(rs.getString("id"),rs.getString("name"),rs.getString("pw"));
			
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
}
