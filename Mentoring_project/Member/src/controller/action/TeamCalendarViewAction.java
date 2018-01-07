package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.TeamCalendar;
import model.TeamManager;

public class TeamCalendarViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String team_id = (String)session.getAttribute("team_id");
		String calendar_id = request.getParameter("calendar_id");
		
		TeamManager manager = TeamManager.getInstance();
		TeamCalendar calendar = manager.getCalendar(Integer.parseInt(calendar_id), team_id);
		
		String month = (calendar.getC_date()).substring(0, 2);
		String day = (calendar.getC_date()).substring(3);
		
		request.setAttribute("calendar", calendar);
		request.setAttribute("month", month);
		request.setAttribute("day", day);
		
		String team_name = manager.getTeam_name(team_id);
		request.setAttribute("team_name", team_name);
		
		if(request.getAttribute("cal_update_fail") != null) {
			request.setAttribute("cal_update_fail", "0");
		}
		
		ActionForward forward = new ActionForward();
		forward.setPath("team_calendar_view.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
