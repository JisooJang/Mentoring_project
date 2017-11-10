package controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.Team;
import model.TeamManager;

public class DeleteTeamAction implements Action{
	public ActionForward execute(
			HttpServletRequest request,	HttpServletResponse response)
			throws Exception{
		TeamManager manager = TeamManager.getInstance();
		String team_id = (String)request.getParameter("tid");
		manager.delete(team_id);
		HttpSession session = request.getSession();
		String sessionId = (String)session.getAttribute("mbId");
		List<Team> teamList = manager.retrieveTeamList(sessionId);
        request.setAttribute("teamList", teamList);
		
		ActionForward forward = new ActionForward();
		forward.setPath("team_list.jsp");
		
		
		return forward;
	}

}
