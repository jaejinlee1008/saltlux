package step6;

import step6.dao.ConnectionMaker;
import step6.dao.SimpleMakeConnection;
import step6.dao.UserDao;
import step6.vo.User;

public class UserDaoTest {
	public static void main(String[] args) throws Exception{
		// 1. 사용자VO 생성
		User user = new User();
		user.setId("kang");
		user.setPassword("1234");
		user.setName("강감찬");
		
		
		ConnectionMaker connectionMaker = new SimpleMakeConnection();
		UserDao dao = new UserDao(connectionMaker);
		dao.insert(user);
		System.out.println("사용자 등록성공");
		
		User result = dao.select("kang");
		System.out.println(result.getName());
	}
}
