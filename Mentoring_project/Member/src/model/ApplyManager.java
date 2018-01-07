package model;

import java.sql.SQLException;
import java.util.List;

public class ApplyManager {
	private static ApplyManager applyMan = new ApplyManager();
	private ApplyDAO applyDAO;
	private ApplyAnalysis applyAnalysis;
	
	private ApplyManager() {
		try{
			applyDAO = new ApplyDAO();
			applyAnalysis = new ApplyAnalysis(applyDAO);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ApplyManager getInstance() {
		return applyMan;
	}
	
	public int create(Apply apply) throws SQLException {
		return applyDAO.create(apply);
	}
	
	public List<Apply> RetrieveApplyList(String team_id) throws SQLException {
		return applyDAO.retrieveApplyList(team_id);
		
	}
	
	public int remove(String team_id, String member_id) throws SQLException {
		return applyDAO.remove(team_id, member_id);
	}
	
	public List<Apply> retrieveApplyListByMemeber_id(String member_id) throws SQLException {
		return applyDAO.retrieveApplyListByMemeber_id(member_id);
		
	}
}
