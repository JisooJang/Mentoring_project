package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import model.ApplyManager;

public class applyRemoveAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String member_id = request.getParameter("member_id");
		String team_id = request.getParameter("team_id");

		
		ApplyManager manager = ApplyManager.getInstance();
		ActionForward forward = new ActionForward();
		
		
			manager.remove(team_id, member_id);
			forward.setPath("apply_list.m2?command=RetrieveApplyList&team_id="+team_id+"&member_id="+member_id);

			forward.setRedirect(true);
		
		
		return forward;
	}

}
