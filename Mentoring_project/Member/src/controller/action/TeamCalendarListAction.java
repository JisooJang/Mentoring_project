package controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.TeamCalendar;
import model.TeamManager;

public class TeamCalendarListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		TeamManager manager = TeamManager.getInstance();
		HttpSession session = request.getSession();
		String team_id = (String)session.getAttribute("team_id");
		String team_name = manager.getTeam_name(team_id);
		request.setAttribute("team_name", team_name);
		
		List<TeamCalendar> list = manager.getCalendarList(team_id);
		
		request.setAttribute("list", list);
		
		if(request.getAttribute("delete_cal_fail") != null) {
			request.setAttribute("delete_cal_fail", "0");
		}
		
		ActionForward forward = new ActionForward();
		
		forward.setPath("team_calendar_list.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
