package step4.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import step4.vo.User;

// Database 처리하는 코드
// 2개의 method를 작성
// 사용자 입력, 조회
public class UserDao {
	
	SimpleMakeConnection simpleMakeConnection;
	
	public UserDao() {
		simpleMakeConnection = new SimpleMakeConnection();
	}
	
	public void insert(User user) throws Exception{
		// pure JDBC를 이용해서 Database처리
		// 6단계로 처리
		// 1. Driver Loading
		
		
		Connection con= simpleMakeConnection.getConnection();
		// 3. PreparedStatement를 생성
		String sql="INSERT INTO users VALUES (?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getName());
		// 4. SQL구문 실행
		int result = pstmt.executeUpdate();
		// 5. 결과처리
		if(result==1) {
			System.out.println("정상적으로 입력");
		}
		// 6. 자원해제
		pstmt.close();
		con.close();
	}
	
	public User select(String userid) throws Exception{
		// pure JDBC를 이용해서 Database처리
		// 6단계로 처리
		// 1. Driver Loading
		
		Connection con = simpleMakeConnection.getConnection();
		// 3. PreparedStatement를 생성
		String sql = "SELECT * FROM users WHERE id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, userid);
		// 4. SQL구문 실행
		ResultSet result = pstmt.executeQuery();
		// 5. 결과처리
		result.next();
		User user = new User(result.getString("id"),result.getString("password"),result.getString("name"));
		if (result != null) {
			System.out.println("정상적으로 처리");
		}
		// 6. 자원해제
		result.close();
		pstmt.close();
		con.close();
		
		return user;
	}
}
