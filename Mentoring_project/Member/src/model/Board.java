package model;

public class Board {
	private String board_code;	//게시글코드
	private String writer;	//게시글 쓴 사용자 id
	private String pw;	//게시글에 할당된 비밀번호
	private String subject;	//게시글 제목
	private String content;	//게시글 내용
	private String regdate;	//게시글 등록시간
	private int readcount;	//게시글 읽혀진 횟수
	private int replycount; //댓글수
	private int reccount; //추천수
	
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
