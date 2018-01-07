package controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.TeamManager;

public class TeamTwitterAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		String team_id = request.getParameter("team_id");	
		TeamManager manager = TeamManager.getInstance();

		List<String> idList = manager.getTeamIdList(team_id);
		
		session.setAttribute("idList", idList);
		session.setAttribute("team_id", team_id);
		
		forward.setPath("team_tweet.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
