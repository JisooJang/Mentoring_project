package model;
import java.sql.Date;

public class NBoardBean {

	private int NOTI_NUM;
	private String NOTI_SUBJECT;
	private String NOTI_CONTENT;
	private Date NOTI_DATE;
	private int NOTI_READCOUNT;
	private String NOTI_PWD;
	
	public String getNOTI_PWD() {
		return NOTI_PWD;
	}
	public void setNOTI_PWD(String nOTI_PWD) {
		NOTI_PWD = nOTI_PWD;
	}
	public int getNOTI_NUM() {
		return NOTI_NUM;
	}
	public void setNOTI_NUM(int nOTI_NUM) {
		NOTI_NUM = nOTI_NUM;
	}
	public String getNOTI_SUBJECT() {
		return NOTI_SUBJECT;
	}
	public void setNOTI_SUBJECT(String nOTI_SUBJECT) {
		NOTI_SUBJECT = nOTI_SUBJECT;
	}
	public String getNOTI_CONTENT() {
		return NOTI_CONTENT;
	}
	public void setNOTI_CONTENT(String nOTI_CONTENT) {
		NOTI_CONTENT = nOTI_CONTENT;
	}
	public Date getNOTI_DATE() {
		return NOTI_DATE;
	}
	public void setNOTI_DATE(Date nOTI_DATE) {
		NOTI_DATE = nOTI_DATE;
	}
	public int getNOTI_READCOUNT() {
		return NOTI_READCOUNT;
	}
	public void setNOTI_READCOUNT(int nOTI_READCOUNT) {
		NOTI_READCOUNT = nOTI_READCOUNT;
	}
	
	
}
