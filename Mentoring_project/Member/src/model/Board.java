package model;

public class Board {
	private String board_code;	//�Խñ��ڵ�
	private String writer;	//�Խñ� �� ����� id
	private String pw;	//�Խñۿ� �Ҵ�� ��й�ȣ
	private String subject;	//�Խñ� ����
	private String content;	//�Խñ� ����
	private String regdate;	//�Խñ� ��Ͻð�
	private int readcount;	//�Խñ� ������ Ƚ��
	private int replycount; //��ۼ�
	private int reccount; //��õ��
	
	public int getReccount() {
		return reccount;
	}
	public void setReccount(int reccount) {
		this.reccount = reccount;
	}
	public String getBoard_code() {
		return board_code;
	}
	public void setBoard_code(String board_code) {
		this.board_code = board_code;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public int getReplycount() {
		return replycount;
	}
	public void setReplycount(int replycount) {
		this.replycount = replycount;
	}
	
	
}
