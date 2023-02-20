package step5;

import step5.dao.UserDao;
import step5.vo.User;

public class UserDaoTest {
	public static void main(String[] args) throws Exception{
		// 1. 사용자VO 생성
		User user = new User();
		user.setId("kang");
		user.setPassword("1234");
		user.setName("강감찬");
		
		UserDao dao = new UserDao();
		dao.insert(user);
		System.out.println("사용자 등록성공");
		
		User result = dao.select("kang");
		System.out.println(result.getName());
	}
}
