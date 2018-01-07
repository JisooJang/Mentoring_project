package controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import model.TeamMember;
import model.TeamMemberManager;

public class RetrieveTeamMemberListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String team_id = request.getParameter("team_id");
		
		TeamMemberManager manager = TeamMemberManager.getInstance();
		
		List<TeamMember> teamMemberList = manager.retrieveTeamMemberList(team_id);
		
		ActionForward forward = new ActionForward();
		
		request.setAttribute("teamMemberList", teamMemberList);
		
		forward.setPath("mento_team_state.jsp");
		return forward;
	}

}
