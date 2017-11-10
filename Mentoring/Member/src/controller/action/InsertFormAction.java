package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;

public class InsertFormAction implements Action{
	public ActionForward execute(
			HttpServletRequest request,	HttpServletResponse response)
			throws Exception{
		ActionForward forward = new ActionForward();
		forward.setPath("join.jsp");
		forward.setRedirect(true);

		return forward;	
	}
}
