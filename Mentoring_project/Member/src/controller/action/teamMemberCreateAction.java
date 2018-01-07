package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import model.TeamMember;
import model.TeamMemberManager;

public class teamMemberCreateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		String team_id = request.getParameter("team_id");
		String member_id = request.getParameter("member_id");
		
		TeamMember teamMember = new TeamMember();
		teamMember.setMember_id(member_id);
		teamMember.setTeam_id(team_id);
		
		ActionForward forward = new ActionForward();
		
		TeamMemberManager manager = TeamMemberManager.getInstance();
		manager.create(teamMember);
		
		forward.setPath("mento_team_state.m2?command=applyRemove&member_id="+member_id+"&team_id="+team_id);
		forward.setRedirect(false);
		return forward;
	}

}
