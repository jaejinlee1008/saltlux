package lecture.jdbc.vo;

public class BookVO {
	private String bisbn;
	private String btitle;
	private String bauthor;
	private int bprice;
	
	public BookVO() {
		// TODO Auto-generated constructor stub
	}

	public BookVO(String bisbn, String btitle, String bauthor, int bprice) {
		super();
		this.bisbn = bisbn;
		this.btitle = btitle;
		this.bauthor = bauthor;
		this.bprice = bprice;
	}

	public String getBisbn() {
		return bisbn;
	}

	public String getBtitle() {
		return btitle;
	}

	public String getBauthor() {
		return bauthor;
	}

	public int getBprice() {
		return bprice;
	}

	public void setBisbn(String bisbn) {
		this.bisbn = bisbn;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	public void setBprice(int bprice) {
		this.bprice = bprice;
	}
	
	
	
}
