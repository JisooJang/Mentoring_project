package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.TeamCalendar;
import model.TeamManager;

public class TeamCalendarModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		TeamManager manager = TeamManager.getInstance();
		HttpSession session = request.getSession();
		String team_id = (String)session.getAttribute("team_id");
		TeamCalendar calendar = manager.getCalendar(Integer.parseInt(request.getParameter("calendar_id")), team_id);
		String c_time = request.getParameter("c_time1") + ":" + request.getParameter("c_time2"); 
		
		calendar.setTeam_id(team_id);
		calendar.setC_content(request.getParameter("c_content"));
		calendar.setC_time(c_time);
		calendar.setC_spot(request.getParameter("c_spot"));
		
		manager.calendar_update(calendar);
		request.setAttribute("calendar", calendar);
		
		forward.setPath("team_calendar_view.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
