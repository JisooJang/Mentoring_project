package controller.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.TeamManager;
import model.Member;
import model.MemberManager;
import model.Team;

public class TeamInsertAction  implements Action{
	public ActionForward execute(HttpServletRequest request,	HttpServletResponse response)
			throws Exception{
		 TeamManager manager = TeamManager.getInstance();
		 MemberManager m = MemberManager.getInstance();
		 Team t = new Team();
		 HttpSession session = request.getSession();
		 Calendar cal = Calendar.getInstance();
		 int year = cal.get(Calendar.YEAR);
		 int month = cal.get(Calendar.MONTH);
		 int day = cal.get(Calendar.DAY_OF_MONTH);
		 
		 t.setTeam_name(request.getParameter("team_name"));
		 t.setMento_id(session.getAttribute("mbId").toString());
		 t.setField(request.getParameterValues("field")[0]);
		 t.setStart_date(year+"-"+month+"-"+day);
		 manager.create(t);
		 
		 String id = (String)session.getAttribute("mbId");
		 Member mb = m.findMember(id);
		 request.setAttribute("mb", mb);
		 
		 ActionForward forward = new ActionForward();
		 forward.setPath("team_list.m2?command=retrieveTeamList");
		 return forward;
	}
}
