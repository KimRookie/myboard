package myboard;

public class Board {
	
	private String boardid;
	private String title;
	private String text;
	private String userid;
	
	public Board(String boardid, String title, String text, String userid) {
		this.boardid = boardid;
		this.title = title;
		this.text = text;
		this.userid = userid;
	}

	public String getBoardid() {
		return boardid;
	}

	public void setBoardid(String boardid) {
		this.boardid = boardid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
}