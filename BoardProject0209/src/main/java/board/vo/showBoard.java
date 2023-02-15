package board.vo;

public class showBoard {
	private int boardNum;
	private String boardTitle;
	private String memberName;
	private String boardDate;
	private int commentCount;
	private int boardLike;
	
	public showBoard() {
		// TODO Auto-generated constructor stub
	}
	
	
	public showBoard(int boardNum, String boardTitle, String memberName, String boardDate, int commentCount,
			int boardLike) {
		super();
		this.boardNum = boardNum;
		this.boardTitle = boardTitle;
		this.memberName = memberName;
		this.boardDate = boardDate;
		this.commentCount = commentCount;
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
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	
	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public int getBoardLike() {
		return boardLike;
	}
	public void setBoardLike(int boardLike) {
		this.boardLike = boardLike;
	}
	
	
}
