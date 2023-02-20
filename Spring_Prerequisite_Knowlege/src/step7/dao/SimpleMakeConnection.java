package step7.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SimpleMakeConnection implements ConnectionMaker{
	
	@Override
	public Connection getConnection() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 2. 연결
		String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/spring?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
		String id="root";
		String pw="test1234";
		
		Connection con=DriverManager.getConnection(jdbcUrl,id,pw);
		return con;
	}
}
