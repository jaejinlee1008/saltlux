package library.jdbc.VO;

import java.sql.Date;

public class RentVO {
	private String bisbn;
	private String ID;
	private Date date;
	private char isreturn_YN;
	
	public RentVO() {
		// TODO Auto-generated constructor stub
	}

	public RentVO(String bisbn, String iD, Date date, char isreturn_YN) {
		super();
		this.bisbn = bisbn;
		ID = iD;
		this.date = date;
		this.isreturn_YN = isreturn_YN;
	}

	public String getBisbn() {
		return bisbn;
	}

	public void setBisbn(String bisbn) {
		this.bisbn = bisbn;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public char getIsreturn_YN() {
		return isreturn_YN;
	}

	public void setIsreturn_YN(char isreturn_YN) {
		this.isreturn_YN = isreturn_YN;
	}
	
	
}
