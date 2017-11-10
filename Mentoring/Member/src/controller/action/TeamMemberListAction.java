package controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.Member;
import model.TeamManager;

public class TeamMemberListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		String team_id = (String)session.getAttribute("team_id");
		TeamManager manager = TeamManager.getInstance();
		String team_name = manager.getTeam_name(team_id);
		List<Member> list = manager.getTeamMemberList(team_id);
		
		request.setAttribute("list", list);
		request.setAttribute("team_name", team_name);
		forward.setPath("team_addr.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
