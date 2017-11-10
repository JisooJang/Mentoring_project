package model;

public class TeamBoard {
	private int board_num;
	private String team_id;
	private String title;
	private String b_date;
	private String b_content;
	private int comment_count;
	private int hits;
	private String writer_id;
	private String admin_id;
	
	public int getBoard_num() {
		return board_num;
	}
	public String getTeam_id() {
		return team_id;
	}
	public String getTitle() {
		return title;
	}
	public String getB_date() {
		return b_date;
	}
	public String getB_content() {
		return b_content;
	}
	public int getComment_count() {
		return comment_count;
	}
	public int getHits() {
		return hits;
	}
	public String getWriter_id() {
		return writer_id;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setB_date(String b_date) {
		this.b_date = b_date;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	
	
}
