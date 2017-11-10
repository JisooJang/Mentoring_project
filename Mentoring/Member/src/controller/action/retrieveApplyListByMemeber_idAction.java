package controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.Apply;
import model.ApplyManager;

public class retrieveApplyListByMemeber_idAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String member_id = (String)session.getAttribute("mbId");
		
		ApplyManager manager =ApplyManager.getInstance();
		List<Apply> applyList = manager.retrieveApplyListByMemeber_id(member_id);
		
		request.setAttribute("applyList", applyList);
		
		ActionForward forward = new ActionForward();
		
		forward.setPath("team_requesting.jsp");
		
		return forward;
	}

}
