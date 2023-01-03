package library.jdbc.VO;

public class UserVO {
	private String name;
	private String ID;
	private String PW;
	private String email;
	private int point;
	
	public UserVO() {
	}

	public UserVO(String name, String ID, String PW, String email,int point) {
		super();
		this.name = name;
		this.ID = ID;
		this.PW = PW;
		this.email = email;
		this.point = point;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getPW() {
		return PW;
	}

	public void setPW(String PW) {
		this.PW = PW;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	
}
