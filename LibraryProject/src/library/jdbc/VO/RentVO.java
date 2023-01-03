package library.jdbc.VO;

import java.sql.Date;

public class RentVO {
	private String bisbn;
	private String btitle;
	private String ID;
	private Date date;
	private String isreturn_YN;
	
	public RentVO() {
		// TODO Auto-generated constructor stub
	}

	

	public String getBtitle() {
		return btitle;
	}



	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}



	public RentVO(String bisbn, String btitle, String iD, Date date, String isreturn_YN) {
		super();
		this.bisbn = bisbn;
		this.btitle = btitle;
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

	public String getIsreturn_YN() {
		return isreturn_YN;
	}

	public void setIsreturn_YN(String isreturn_YN) {
		this.isreturn_YN = isreturn_YN;
	}
	
	
}
