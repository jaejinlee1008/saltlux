package my.spring.springweb.sample01.vo;

// JavaBean 규약
// 1. 기본생성자 존재
// 2. 모든 field private이어야 함
// 3. 각 field를 사용하기 위한 public타입의 setter, getter 존재
// 이렇게 JavaBean규약을 지켜서 만든 클래스의 객체를 생성했을때의
// field를 property라고 부른다.
public class User {
	private String userName;
	private int userAge;
	
	public User() {
		
	}

	public User(String userName, int userAge) {
		super();
		this.userName = userName;
		this.userAge = userAge;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	
}
