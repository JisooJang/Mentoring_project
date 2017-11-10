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

public class ReplyDAO {
	private DataSource ds;
	
	public ReplyDAO() throws Exception {
		Context init = new InitialContext();
		ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
	}
	
	/**reply table 생성**/
	public int create(Reply reply) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			StringBuffer insertQuery = new StringBuffer();
			insertQuery.append("INSERT INTO TB_REPLY_INFO VALUES ");
			insertQuery.append("('REPLY000' || REPLY_SEQ.NEXTVAL, ?, ?, ?, ?)");
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(insertQuery.toString());
			pstmt.setString(1, reply.getBoard_code());
			pstmt.setString(2, reply.getReplywriter());
			pstmt.setString(3, reply.getReplycontent());
			pstmt.setString(4, reply.getReplyregdate());
			
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
	
	
	
	/**replyList 보여주기**/
	public List<Reply> retrieveReplyList(String board_code) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			StringBuffer findQuery = new StringBuffer();
			findQuery.append("SELECT reply_code, replywriter, replycontent, replyregdate ");
			findQuery.append("FROM TB_REPLY_INFO ");
			findQuery.append("WHERE board_code=? ");
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(findQuery.toString());
			pstmt.setString(1, board_code);
			
			rs = pstmt.executeQuery();
		
			
			List<Reply> replyList =  new ArrayList<Reply>();
			while(rs.next()) {
				Reply reply = new Reply();
				
				reply.setBoard_code(board_code);
				reply.setReply_code(rs.getString("reply_code"));
				reply.setReplywriter(rs.getString("replywriter"));
				reply.setReplycontent(rs.getString("replycontent"));
				reply.setReplyregdate(rs.getString("replyregdate"));
				
				replyList.add(reply);	
			}
			
			
			return replyList;
		} finally {
			if ( pstmt != null ){
				pstmt.close();
			}			
			if ( con != null ){
				con.close();
			}
		}	
			
			
	}
}
