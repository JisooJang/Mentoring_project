package model;

import java.sql.SQLException;
import java.util.List;

public class MessageManager {
	private static MessageManager messageMan = new MessageManager();
	private MessageDAO messageDAO;
	private MessageAnalysis messageAnalysis;
	
	private MessageManager() {
		try{
			messageDAO = new MessageDAO();
			messageAnalysis = new MessageAnalysis(messageDAO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static MessageManager getInstance() {
		return messageMan;
	}
	
	public int create(Message message) throws SQLException {
		return messageDAO.create(message);
	}
	
	public List<Message> retrieveMessageList(String rec_member_id) throws SQLException {
		return messageDAO.retrieveMessageList(rec_member_id);
	}
	
	public int updateMessageInfo() throws SQLException {
		return messageDAO.updateMessageInfo();
	}
	
	public int remove(String messge_id) throws SQLException {
		return messageDAO.remove(messge_id);
	}
		
	public Message retrieveMessage(String message_id) throws SQLException {
		return messageDAO.retrieveMessage(message_id);
	}
}
