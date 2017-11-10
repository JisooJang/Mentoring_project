package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MessageDAO {
private DataSource ds;
	
	public MessageDAO() throws Exception {
		Context init = new InitialContext();
		ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
	}
	
	/**메세지 테이블 생성**/
	public int create(Message message) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			StringBuffer insertQuery = new StringBuffer();
			insertQuery.append("INSERT INTO message VALUES ");
			insertQuery.append("('MSG' || message_seq.nextval, ?, ?, ?, ?, ?, ? )");
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(insertQuery.toString());
			pstmt.setString(1, message.getSend_member_id());
			pstmt.setString(2, message.getRec_member_id());
			pstmt.setString(3, message.getMessage_content());
			pstmt.setString(4, message.getMessage_send_time());
			pstmt.setString(5, message.getMessage_info());
			pstmt.setString(6, message.getMessage_subject());
			
			int result = pstmt.executeUpdate();
			return result;
		} finally {
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			}
		}
	}
	
	/**받은 사람 아이디를 통해 메세지리스트를 가져온다.**/
	public List<Message> retrieveMessageList(String rec_member_id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			StringBuffer findQuery = new StringBuffer();
			findQuery.append("SELECT ");
			findQuery.append("message_id, send_member_id, message_content, message_send_time, message_info, message_subject ");
			findQuery.append("FROM message ");
			findQuery.append("WHERE rec_member_id=? ");
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(findQuery.toString());
			pstmt.setString(1, rec_member_id);
			
			rs = pstmt.executeQuery();
			
			List<Message> MessageList = new ArrayList<Message>();
			while(rs.next()) {
				Message msg = new Message();
				
				msg.setMessag_id(rs.getString("message_id"));
				msg.setSend_member_id(rs.getString("send_member_id"));
				msg.setMessage_content(rs.getString("message_content"));
				msg.setMessage_info(rs.getString("message_info"));
				msg.setMessage_send_time(rs.getString("message_send_time"));
				msg.setRec_member_id(rec_member_id);
				msg.setMessage_subject(rs.getString("message_subject"));
				
				MessageList.add(msg);
			}
			
			return MessageList;
			
			
			
		} finally {
			if ( pstmt != null ){
				pstmt.close();
			}			
			if ( con != null ){
				con.close();
			}
		}
	}
	/**메세지 상세보기**/
	public Message retrieveMessage(String message_id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			StringBuffer findQuery = new StringBuffer();
			findQuery.append("SELECT ");
			findQuery.append("* ");
			findQuery.append("FROM message ");
			findQuery.append("WHERE message_id=? ");
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(findQuery.toString());
			pstmt.setString(1, message_id);
			
			rs = pstmt.executeQuery();
			
			Message msg = null;
			if ( rs.next() ) {
				msg = new Message();
				msg.setMessag_id(message_id);
				msg.setMessage_content(rs.getString("message_content"));
				msg.setMessage_info(rs.getString("message_info"));
				msg.setMessage_send_time(rs.getString("message_send_time"));
				msg.setMessage_subject(rs.getString("message_subject"));
				msg.setRec_member_id(rs.getString("rec_member_id"));
				msg.setSend_member_id(rs.getString("send_member_id"));
			}
			
			return msg;
		} finally {
			if ( pstmt != null ){
				pstmt.close();
			}			
			if ( con != null ){
				con.close();
			}
		}
	}
	
	/**메세지 상태변호ㅏ**/
	public int updateMessageInfo() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			StringBuffer updateQuery = new StringBuffer();
			updateQuery.append("UPDATE MESSAGE SET ");
			updateQuery.append("message_info = Y ");
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(updateQuery.toString());
			
			int result = pstmt.executeUpdate();
			
			return result;
			
		} finally {
			if ( pstmt != null ){
				pstmt.close();
			}			
			if ( con != null ){
				con.close();
			}
		}
	}
	
	
	
	
	/**메세지 삭제**/
	public int remove(String messge_id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			
			
			
		} finally {
			if ( pstmt != null ){
				pstmt.close();
			}			
			if ( con != null ){
				con.close();
			}
		}
		return 0;
	}

}
