package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.TeamCalendar;
import model.TeamManager;

public class TeamCalendarUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		TeamManager manager = TeamManager.getInstance();
		int calendar_id = Integer.parseInt(request.getParameter("calendar_id"));
		String writer_id = request.getParameter("writer_id");
		HttpSession session = request.getSession();
		String team_id = (String)session.getAttribute("team_id");
		TeamCalendar cal = new TeamCalendar();
		ActionForward forward = new ActionForward();
		
		String team_name = manager.getTeam_name(team_id);
		request.setAttribute("team_name", team_name);
		
		if(((String)session.getAttribute("mbId")).equals(writer_id)) {
			
			cal = manager.getCalendar(calendar_id, team_id);
			
			String month = (cal.getC_date()).substring(0, 2);
			String day = (cal.getC_date()).substring(3);
			
			request.setAttribute("calendar", cal);
			request.setAttribute("month", month);
			request.setAttribute("day", day);
			
		}
		else {
			request.setAttribute("cal_update_fail", "0");
			
			forward.setPath("team_calendar_view.m2?command=team_calendar_view");
			forward.setRedirect(false);
			return forward;
		}
		
		
		forward.setPath("team_calendar_update.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
