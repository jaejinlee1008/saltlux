package board.vo;

public class Board {
	private int boardNum;
	private String boardTitle;
	private String boardContent;
	private String boardAuthor;
	private String boardDate;
	private int boardLike;
	
	
	public Board() {
		// TODO Auto-generated constructor stub
	}
	
	public Board(int boardNum, String boardTitle, String boardContent, String boardAuthor, String boardDate,
			int boardLike) {
		super();
		this.boardNum = boardNum;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardAuthor = boardAuthor;
		this.boardDate = boardDate;
		this.boardLike = boardLike;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardAuthor() {
		return boardAuthor;
	}

	public void setBoardAuthor(String boardAuthor) {
		this.boardAuthor = boardAuthor;
	}

	public String getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}

	public int getBoardLike() {
		return boardLike;
	}

	public void setBoardLike(int boardLike) {
		this.boardLike = boardLike;
	}
	

}
