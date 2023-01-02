package lecture.jdbc.vo;

public class BookExtraVO {
	private String bdate;
	private int bpage;
	private String btranslator;
	private String bsupplement;
	private String bpublisher;
	
	public BookExtraVO() {
		// TODO Auto-generated constructor stub
	}

	public BookExtraVO(String bdate, int bpage, String btranslator, String bsupplement, String bpublisher) {
		super();
		this.bdate = bdate;
		this.bpage = bpage;
		this.btranslator = btranslator;
		this.bsupplement = bsupplement;
		this.bpublisher = bpublisher;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public int getBpage() {
		return bpage;
	}

	public void setBpage(int bpage) {
		this.bpage = bpage;
	}

	public String getBtranslator() {
		return btranslator;
	}

	public void setBtranslator(String btranslator) {
		this.btranslator = btranslator;
	}

	public String getBsupplement() {
		return bsupplement;
	}

	public void setBsupplement(String bsupplement) {
		this.bsupplement = bsupplement;
	}

	public String getBpublisher() {
		return bpublisher;
	}

	public void setBpublisher(String bpublisher) {
		this.bpublisher = bpublisher;
	}
	
	
}
