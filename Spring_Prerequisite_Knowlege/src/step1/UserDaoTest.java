package step1;

import step1.dao.UserDao;
import step1.vo.User;

public class UserDaoTest {
	public static void main(String[] args) throws Exception{
		// 1. 사용자VO 생성
		User user = new User();
		user.setId("hong");
		user.setPassword("1234");
		user.setName("홍길동");
		
		UserDao dao = new UserDao();
		dao.insert(user);
		System.out.println("사용자 등록성공");
		
		User result = dao.select("hong");
		System.out.println(result.getName());
	}
}
