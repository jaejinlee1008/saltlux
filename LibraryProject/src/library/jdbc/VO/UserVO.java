package library.jdbc.VO;

import java.sql.Date;

public class UserVO {
	
	private int num;
	private String name;
	private String ID;
	private String PW;
	private String email;
	private Date indate;
	private int point;
	private String isout;
	private Date outdate;
	
	
	public UserVO() {
	}

	public UserVO(int num,String name, String ID, String PW, String email,int point) {
		super();
		this.num=num;
		this.name = name;
		this.ID = ID;
		this.PW = PW;
		this.email = email;
		this.point = point;
	}
	
	public UserVO(int num, String name, String iD, String pW, String email, Date indate, int point, String isout,
			Date outdate) {
		super();
		this.num = num;
		this.name = name;
		ID = iD;
		PW = pW;
		this.email = email;
		this.indate = indate;
		this.point = point;
		this.isout = isout;
		this.outdate = outdate;
	}
	
	public Date getIndate() {
		return indate;
	}

	public void setIndate(Date indate) {
		this.indate = indate;
	}

	public String getIsout() {
		return isout;
	}

	public void setIsout(String isout) {
		this.isout = isout;
	}

	public Date getOutdate() {
		return outdate;
	}

	public void setOutdate(Date outdate) {
		this.outdate = outdate;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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
