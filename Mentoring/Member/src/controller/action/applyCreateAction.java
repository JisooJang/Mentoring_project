package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.Apply;
import model.ApplyManager;

public class applyCreateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
//		//if (request.getMethod().equals("GET")) {	// request an insert form
//			//ActionForward forward = new ActionForward();
//			forward.setPath("apply_list.jsp");
//			forward.setRedirect(true);
//			return forward;
//		}
		
		HttpSession session = request.getSession();
		String applicant = (String)session.getAttribute("mbId");
		
		String test = request.getParameter("tid").toString();
		
		Apply apply = new Apply();
		apply.setTeam_id(test);
		apply.setMember_id(applicant);
		apply.setState("N");
		
		
		ActionForward forward = new ActionForward();
		
		ApplyManager manager = ApplyManager.getInstance();
		manager.create(apply);
		
		
		//어디로 가야하지...
		forward.setPath("matching.jsp");
		
		return forward;
	}

}
