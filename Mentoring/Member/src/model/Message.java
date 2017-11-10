package model;

public class Message {
	private String messag_id;
	private String send_member_id;
	private String rec_member_id;
	private String message_content;
	private String message_send_time;
	private String message_info;
	private String message_subject;
	
	public String getMessage_subject() {
		return message_subject;
	}
	public void setMessage_subject(String message_subject) {
		this.message_subject = message_subject;
	}
	public String getMessag_id() {
		return messag_id;
	}
	public void setMessag_id(String messag_id) {
		this.messag_id = messag_id;
	}
	public String getSend_member_id() {
		return send_member_id;
	}
	public void setSend_member_id(String send_member_id) {
		this.send_member_id = send_member_id;
	}
	public String getRec_member_id() {
		return rec_member_id;
	}
	public void setRec_member_id(String rec_member_id) {
		this.rec_member_id = rec_member_id;
	}
	public String getMessage_content() {
		return message_content;
	}
	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}
	public String getMessage_send_time() {
		return message_send_time;
	}
	public void setMessage_send_time(String message_send_time) {
		this.message_send_time = message_send_time;
	}
	public String getMessage_info() {
		return message_info;
	}
	public void setMessage_info(String message_info) {
		this.message_info = message_info;
	}
}
