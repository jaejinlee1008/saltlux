package step3;

import step3.dao.NUserDao;
import step3.dao.UserDao;
import step3.vo.User;

public class UserDaoTest {
	public static void main(String[] args) throws Exception{
		// 1. 사용자VO 생성
		User user = new User();
		user.setId("kang");
		user.setPassword("1234");
		user.setName("강감찬");
		
		UserDao dao = new NUserDao();
		dao.insert(user);
		System.out.println("사용자 등록성공");
		
		User result = dao.select("kang");
		System.out.println(result.getName());
	}
}
