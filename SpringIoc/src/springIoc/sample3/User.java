package springIoc.sample3;

public class User {
	
	private String userName;
	
	public User() {
		System.out.println("User의 기본생성자 호출");
	}

	public User(String userName) {
		super();
		this.userName = userName;
		System.out.println("User의 생성자 호출 - " + userName);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
