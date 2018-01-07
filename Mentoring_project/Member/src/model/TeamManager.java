package model;

import java.sql.SQLException;
import java.util.List;

public class TeamManager {
	private static TeamManager manager = new TeamManager();
	private TeamBoardDAO teamBoardDAO;
	private TeamDAO teamDAO;

	private TeamManager() {
		try {
			teamBoardDAO = new TeamBoardDAO();
			teamDAO = new TeamDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	public static TeamManager getInstance() {
		return manager;
	}
    public int create(Team team) throws SQLException {
    	return teamDAO.create(team);
    }
    public int update(Team team) throws SQLException {
    	return teamDAO.update(team);
    }
    public int delete(String team_id) throws SQLException{
    	return teamDAO.delete(team_id);
    }
    public List<Team> BelongToTeam(String member_id) throws SQLException{
    	return teamDAO.BelongToTeam(member_id);
    }
    public List<Team> BelongToMento(String member_id) throws SQLException{
    	return teamDAO.BelongToMento(member_id);
    }
	public int write(TeamBoard board) throws SQLException {
		return teamBoardDAO.write(board);
	}

	public int update(TeamBoard board) throws SQLException {
		return teamBoardDAO.update(board);
	}

	public int remove(int board_num, String team_id) throws SQLException {
	      return teamBoardDAO.remove(board_num, team_id);
	   }


	 public List<TeamBoard> getBoardList(String team_id) throws SQLException {
	      return teamBoardDAO.getBoardList(team_id);
	   }

	   public TeamBoard getBoard(int board_num, String team_id) throws SQLException {
	      return teamBoardDAO.getBoard(board_num, team_id);
	   }
	      
	   public String getTeam_name(String team_id) throws SQLException {
	      return teamBoardDAO.getTeam_name(team_id);
	   }
	   
	   public List<Team> getTeamList(String mbId) throws SQLException {
	      return teamBoardDAO.getTeamList(mbId);
	   }
	   
	   public Team getTeam(String team_id) throws SQLException {
	      return teamBoardDAO.getTeam(team_id);
	   }
	   
	   public int calendar_write(TeamCalendar calendar) throws SQLException {
	      return teamBoardDAO.calendar_write(calendar);
	   }
	   public int calendar_remove(int calendar_id, String team_id) throws SQLException {
	      return teamBoardDAO.calendar_remove(calendar_id, team_id);
	   }
	   public int calendar_update(TeamCalendar calendar) throws SQLException {
	      return teamBoardDAO.calendar_update(calendar);
	   }
	   public List<TeamCalendar> getCalendarList(String team_id) throws SQLException {
	      return teamBoardDAO.getCalendarList(team_id);
	   }
	   public TeamCalendar getCalendar(int calendar_id, String team_id) throws SQLException {
	      return teamBoardDAO.getCalendar(calendar_id, team_id);
	   }
	   public List<Member> getTeamMemberList(String team_id) throws SQLException {   //팀 주소록 출력
	      return teamBoardDAO.getTeamMemberList(team_id);
	   } 
	   public List<String> getTeamIdList(String team_id) throws SQLException {
		      return teamBoardDAO.getTeamIdList(team_id);
		   }

	public List<Team> retrieveTeamList(String sessionId) throws SQLException {
		return teamDAO.retrieveTeamList(sessionId);
	}
	public int updateTeamNofp(String team_id) throws SQLException {
		return teamDAO.updateTeamNofp(team_id);
	}

}
