package lecture.jdbc.di.step3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 다른 클래스 상속 못받는 문제 발생

public class KosaUserDAO extends UserDAO{
	@Override
	protected Connection getConnection() {
		// 자기 나름대로의 데이터베이스 준비코드
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String jdbc_url = "jdbc:mysql://127.0.0.1:3306/example01?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			String id = "root";
			String pw = "test1234";
			con = DriverManager.getConnection(jdbc_url,id,pw);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
}
