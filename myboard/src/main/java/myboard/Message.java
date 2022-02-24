package myboard;

import java.sql.Date;

public class Message {
	private int boardId;
	private String messageTitle;
	private String messageText;
	private String userid;
	private Date stime;
	
	public Message() {
		
	}
	
	public Message(int boardId, String messageTitle, String messageText, String userid) {
		this(messageTitle, messageText, userid);
		this.boardId = boardId;
	}

	public Message(String messageTitle, String messageText, String userid) {
		this.messageTitle = messageTitle;
		this.messageText = messageText;
		this.userid = userid;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getMessageTitle() {
		return messageTitle;
	}

	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getStime() {
		return stime;
	}

	public void setStime(Date stime) {
		this.stime = stime;
	}
	
	
}
