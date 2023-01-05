package library.jdbc.VO;

import java.util.Date;

public class LogVO {
	private String btitle;
	private String bisbn;
	private String ID;
	private String name;
	private Date date;
	private String rentORreturn;
	private int point;
	private Date duedate;
	public LogVO(String btitle, String bisbn, String ID, String name, Date date, String rentORreturn, int point, Date duedate) {
		super();
		this.btitle = btitle;
		this.bisbn = bisbn;
		this.ID = ID;
		this.name = name;
		this.date = date;
		this.rentORreturn = rentORreturn;
		this.point = point;
		this.duedate = duedate;
	}
	public Date getDuedate() {
		return duedate;
	}
	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getRentORreturn() {
		return rentORreturn;
	}
	public void setRentORreturn(String rentORreturn) {
		this.rentORreturn = rentORreturn;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	
}
