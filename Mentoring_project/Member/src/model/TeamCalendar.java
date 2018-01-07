package model;

public class TeamCalendar {
	private int calendar_id;
	private String team_id;
	private String writer_id;
	private String c_date;	
	private String c_content;
	private String c_time;
	private String c_spot;
	
	
	public String getWriter_id() {
		return writer_id;
	}
	public String getC_spot() {
		return c_spot;
	}
	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}
	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}
	public void setC_spot(String c_spot) {
		this.c_spot = c_spot;
	}
	public int getCalendar_id() {
		return calendar_id;
	}
	public void setCalendar_id(int calendar_id) {
		this.calendar_id = calendar_id;
	}
	public String getC_date() {
		return c_date;
	}
	public String getTeam_id() {
		return team_id;
	}
	public String getC_content() {
		return c_content;
	}
	public String getC_time() {
		return c_time;
	}
	public void setC_date(String c_date) {
		this.c_date = c_date;
	}
	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
	public void setC_time(String c_time) {
		this.c_time = c_time;
	}	
	
}
