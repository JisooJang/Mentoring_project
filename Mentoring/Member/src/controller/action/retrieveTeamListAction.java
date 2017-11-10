package controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.Team;
import model.TeamManager;

public class retrieveTeamListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		//멘토아이디랑 세션아이디가 같은 것들은 다 보여줌.
		HttpSession session = request.getSession();
		String sessionId = (String)session.getAttribute("mbId");
		
		TeamManager manager = TeamManager.getInstance();
		
		List<Team> teamList = manager.retrieveTeamList(sessionId);
		
		request.setAttribute("teamList", teamList);
		
		ActionForward forward = new ActionForward();
		forward.setPath("team_list.jsp");
		
		
		return forward;
	}

}
