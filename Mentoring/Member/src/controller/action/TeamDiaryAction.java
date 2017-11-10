package controller.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.Team;
import model.TeamManager;

public class TeamDiaryAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		TeamManager manager = TeamManager.getInstance();
		HttpSession session = request.getSession();
		String mbId = (String)session.getAttribute("mbId");
		List<Team> list = new ArrayList<Team>();
		
		if(mbId == null) {
			response.setContentType("text/html;charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인이 필요합니다.');");
			out.println("parent.location.href=\"index.jsp\";");
			out.println("</script>");
			out.close();
			return null;
		}
		list = manager.getTeamList(mbId);
		
		request.setAttribute("list", list);
		forward.setPath("team_diary.jsp");
		forward.setRedirect(false);

		return forward;
	}

}
