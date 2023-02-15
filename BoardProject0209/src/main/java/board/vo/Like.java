package board.vo;

public class Like {
	private int likeNum;
	private int boardNum;
	private String likeId;
	
	public Like() {
		// TODO Auto-generated constructor stub
	}

	public Like(int likeNum, int boardNum, String likeId) {
		super();
		this.likeNum = likeNum;
		this.boardNum = boardNum;
		this.likeId = likeId;
	}

	public int getLikeNum() {
		return likeNum;
	}

	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getLikeId() {
		return likeId;
	}

	public void setLikeId(String likeId) {
		this.likeId = likeId;
	}
	
}
