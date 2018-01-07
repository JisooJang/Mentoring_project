package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.MemberManager;

public class DeleteAction implements Action{
	public ActionForward execute(
			HttpServletRequest request,	HttpServletResponse response)
			throws Exception{
		
		HttpSession session = request.getSession();
		String mbId = session.getAttribute("mbId").toString();
		MemberManager manager = MemberManager.getInstance();
		manager.remove(mbId);
		
		ActionForward forward = new ActionForward();
		forward.setPath("login.jsp");
		forward.setRedirect(true);
		
		return forward;
	}
}
