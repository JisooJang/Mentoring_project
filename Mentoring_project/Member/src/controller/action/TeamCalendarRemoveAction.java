package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.TeamManager;

public class TeamCalendarRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		TeamManager manager = TeamManager.getInstance();
		HttpSession session = request.getSession();
		String team_id = (String)session.getAttribute("team_id");
		String id = (String)session.getAttribute("mbId");
		String writer_id = request.getParameter("writer_id");
		int calendar_id = Integer.parseInt(request.getParameter("calendar_id"));
		
		if(id.equals(writer_id)) {
			manager.calendar_remove(calendar_id, team_id);
		}
		else {
			request.setAttribute("delete_cal_fail", "0");
		}
		
		forward.setPath("team_calendar_list.m2?command=team_calendar_list");
		forward.setRedirect(false);
		return forward;
	}

}
