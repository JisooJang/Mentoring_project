package controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import model.Apply;
import model.ApplyManager;

public class RetrieveApplyListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String team_id = request.getParameter("team_id");
		
		ApplyManager manager =ApplyManager.getInstance();
		List<Apply> applyList = manager.RetrieveApplyList(team_id);
		
		request.setAttribute("applyList", applyList);
		
		ActionForward forward = new ActionForward();
		
		//일단 어플리컨트리스트가 잘뜨는지확인하기위해 applyList.jsp로 갈꺼임
		forward.setPath("team_member_list.m2?team_id="+team_id+"&command=RetrieveTeamMemberList");
		return forward;
	}

}
