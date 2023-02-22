package springIoc.sample3;

public class UserServiceImpl implements UserService {

	private User user;
	
	public UserServiceImpl() {
		System.out.println("UserServiceImpl 기본 생성자");
	}

	public UserServiceImpl(User user) {
		this.user = user;
		System.out.println("UserServiceImpl 생성자 호출 - " + user);
	}
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void addUser(User user) {
		// 일반적인 Business Logic처리가 나오면 되요!
		System.out.println("UserServiceImpl - addUser() 메소드 호출!");
	}
}
