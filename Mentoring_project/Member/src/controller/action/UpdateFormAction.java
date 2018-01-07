package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.MemberManager;

public class UpdateFormAction implements Action{
	public ActionForward execute(
			HttpServletRequest request,	HttpServletResponse response)
			throws Exception{
		ActionForward forward = new ActionForward();
		
		HttpSession session = request.getSession();
		MemberManager manager = MemberManager.getInstance();
		String member = (String)session.getAttribute("mbId");
		session.setAttribute("member", manager.findMember(member));
		
		forward.setPath("infoUpdate.jsp");
		forward.setRedirect(true);
		
        
		return forward;		
	}
}
