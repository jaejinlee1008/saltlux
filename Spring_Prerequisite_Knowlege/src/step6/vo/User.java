package step6.vo;

// JavaBeans라는 규약이 있다.
// class를 작성하는 규칙
// 3가지
// 1. 인자가 없는 기본 생성자가 존재해야한다.
// 2. field는 private으로 설정
// 3. getter와 setter가 존재해야 하고 public으로 설정되어야 한다.
public class User {

	private String id;
	private String password;
	private String name;
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}


	public User(String id, String password, String name) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
