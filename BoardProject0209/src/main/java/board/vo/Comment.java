package board.vo;

import java.sql.Timestamp;

public class Comment {
	private int commentNum;
	private int postNum;
	private String CWId;
	private String commentContent;
	private Timestamp commentDate;
	private String CWName;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Comment(int postNum, String cWId, String commentContent, Timestamp commentDate, String cWName) {
		super();
		this.postNum = postNum;
		CWId = cWId;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
		CWName = cWName;
	}



	public int getCommentNum() {
		return commentNum;
	}



	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}



	public int getPostNum() {
		return postNum;
	}

	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}

	public String getCWId() {
		return CWId;
	}

	public void setCWId(String cWId) {
		CWId = cWId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Timestamp getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Timestamp commentDate) {
		this.commentDate = commentDate;
	}



	public String getCWName() {
		return CWName;
	}



	public void setCWName(String cWName) {
		CWName = cWName;
	}
	
}
