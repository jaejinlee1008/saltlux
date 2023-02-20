package step7;

import step7.dao.ConnectionMaker;
import step7.dao.SimpleMakeConnection;
import step7.dao.UserDao;

public class DaoFactory {
	
	public ConnectionMaker connectionMaker() {
		return new SimpleMakeConnection();
	}
	
	public UserDao userDao() {
		
		UserDao dao = new UserDao(connectionMaker());
		
		
		return dao;
	}
}
