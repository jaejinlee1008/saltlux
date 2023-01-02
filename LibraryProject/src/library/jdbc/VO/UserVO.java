package library.jdbc.VO;

public class UserVO {
	private String name;
	private String ID;
	private String PW;
	private String email;
	private char IsRent_YN;
	private int point;
	
	public UserVO() {
	}

	public UserVO(String name, String ID, String PW, String email, char isRent_YN, int point) {
		super();
		this.name = name;
		this.ID = ID;
		this.PW = PW;
		this.email = email;
		IsRent_YN = isRent_YN;
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

	public char getIsRent_YN() {
		return IsRent_YN;
	}

	public void setIsRent_YN(char isRent_YN) {
		IsRent_YN = isRent_YN;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	
}
