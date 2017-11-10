package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;

public class LogoutAction implements Action{
	public ActionForward execute(
			HttpServletRequest request,	HttpServletResponse response)
			throws Exception{
		
		HttpSession session = request.getSession();
		session.removeAttribute("mbId");
		session.invalidate();
		
		ActionForward forward = new ActionForward();
		forward.setPath("index.jsp");
		forward.setRedirect(true);
		
		return forward;
	}
}
