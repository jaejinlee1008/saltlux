package step3.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class NUserDao extends UserDao {
	@Override
	protected Connection getConnection() throws Exception {
		// UserDao를 구입한 회사에서
		// 자신의 회사의 DB에 맞는 DB연결코드를 작성
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 2. 연결
		String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/spring?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
		String id="root";
		String pw="test1234";
		
		Connection con=DriverManager.getConnection(jdbcUrl,id,pw);
		return con;
	}
}
