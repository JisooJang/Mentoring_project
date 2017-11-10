package model;

import java.sql.SQLException;
import java.util.List;

public class TeamMemberManager {
	private static TeamMemberManager teamMemMan = new TeamMemberManager();
	private TeamMemberDAO teamMemDAO;
	private TeamMemberAnalysis teamMemAnalysis;
	
	private TeamMemberManager() {
		try {
			teamMemDAO = new TeamMemberDAO();
			teamMemAnalysis = new TeamMemberAnalysis(teamMemDAO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static TeamMemberManager getInstance() {
		return teamMemMan;
	}
	
	public int create(TeamMember team_member) throws SQLException {
		return teamMemDAO.create(team_member);
	}
	
	public List<TeamMember> retrieveTeamMemberList(String team_id) throws SQLException {
		return teamMemDAO.retrieveTeamMemberList(team_id);
	}
	
}
