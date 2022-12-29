package JDBC.VO;

//VO는 데이터를 표현하는 객체
//따라서 비지니스 로직은 여기에 쓰지 않음
//데이터베이스의 테이블은 참조해서 만듬
public class Book {

	private String bisbn;
	private String btitle;
	private String bauthor;
	private int bprice;
	
	public Book() {
		
	}

	public Book(String bisbn, String btitle, String bauthor, int bprice) {
		super();
		this.bisbn = bisbn;
		this.btitle = btitle;
		this.bauthor = bauthor;
		this.bprice = bprice;
	}

	public String getBisbn() {
		return bisbn;
	}

	public void setBisbn(String bisbn) {
		this.bisbn = bisbn;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBauthor() {
		return bauthor;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	public int getBprice() {
		return bprice;
	}

	public void setBprice(int bprice) {
		this.bprice = bprice;
	}
	
	@Override
	public String toString() {		
		return bisbn + ", " + btitle + ", " + bauthor + ", " + bprice;
		
	}
	
}

