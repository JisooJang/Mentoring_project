package model;

import java.sql.SQLException;
import java.util.List;

public class ReplyManager {
	private static ReplyManager replyMan = new ReplyManager();
	private ReplyDAO replyDAO;
	private ReplyAnalysis replyAnalysis;
	
	private ReplyManager() {
		try {
			replyDAO = new ReplyDAO();
			replyAnalysis = new ReplyAnalysis(replyDAO);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ReplyManager getInstance() {
		return replyMan;
	}
	
	public int create(Reply reply) throws SQLException {
		return replyDAO.create(reply);
	}
	
	public List<Reply> retrieveReplyList(String board_code) throws SQLException {
		return replyDAO.retrieveReplyList(board_code);
	}
	
	
}
