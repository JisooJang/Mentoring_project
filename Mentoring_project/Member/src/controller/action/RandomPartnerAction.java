package controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.Member;
import model.MemberManager;

public class RandomPartnerAction implements Action{
	public ActionForward execute(
			HttpServletRequest request,	HttpServletResponse response)
			throws Exception{
		MemberManager manager = MemberManager.getInstance();
		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();
		List<Member> list=null;
		
		if(manager.RandomList(session.getAttribute("mbId").toString())!=null){
			list = manager.RandomList(session.getAttribute("mbId").toString());
		}
		request.setAttribute("randomList", list);
		forward.setPath("random_partner.jsp");
		
		return forward;
	}

}
