package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.*;

public class LoginAction implements Action{
	public ActionForward execute(
			HttpServletRequest request,	HttpServletResponse response)
			throws Exception{
		
		String mbId = request.getParameter("mbId");
		String pwd = request.getParameter("pwd");
		ActionForward forward = new ActionForward();
		
		try{
			MemberManager manager = MemberManager.getInstance();
			manager.login(mbId, pwd);
			
			HttpSession session = request.getSession();
			session.setAttribute("mbId", mbId);
			
			forward.setPath("index.m2");
			forward.setRedirect(true);	
		}catch(Exception e){
			request.setAttribute("exception", e);
			forward.setPath("login.jsp");
			forward.setRedirect(false);	
		}
		return forward;
	}
}
