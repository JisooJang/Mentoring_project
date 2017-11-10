package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.Member;
import model.MemberManager;
import model.TeamManager;

public class MemberInfoAction implements Action{
	public ActionForward execute(
			HttpServletRequest request,	HttpServletResponse response)
			throws Exception{
		HttpSession session = request.getSession();
		String mbId = (String)session.getAttribute("mbId");
		
		MemberManager manager = MemberManager.getInstance();
		TeamManager tmanager = TeamManager.getInstance();
		Member mb = manager.findMember(mbId);
		request.setAttribute("mb", mb);
		
		ActionForward forward = new ActionForward();
		forward.setPath("mypage.jsp");
		return forward;
	}

}
