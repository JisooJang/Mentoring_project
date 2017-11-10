package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import model.Team;
import model.TeamManager;

public class UpdateTeamNofpAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String team_id = request.getParameter("team_id");
		String member_id = request.getParameter("member_id");
		
		TeamManager manager = TeamManager.getInstance();
		manager.updateTeamNofp(team_id);
		
		request.setAttribute("team_id", team_id);
		request.setAttribute("member_id", member_id);
		
		ActionForward forward = new ActionForward();
		forward.setPath("mento_team_state.m2?command=applyRemove&member_id="+member_id+"&team_id="+team_id);
		return forward;
	}

}
