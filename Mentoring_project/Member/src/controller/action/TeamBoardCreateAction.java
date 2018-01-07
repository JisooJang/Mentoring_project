package controller.action;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.TeamBoard;
import model.TeamManager;

public class TeamBoardCreateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		TeamManager manager = TeamManager.getInstance();
		TeamBoard board = new TeamBoard();

		HttpSession session = request.getSession();
		String team_id = (String)session.getAttribute("team_id");
		String id = (String)session.getAttribute("mbId");
		
		Calendar c = Calendar.getInstance();
		String date = Integer.toString(c.get(Calendar.YEAR)) + "-" 
				+ Integer.toString((c.get(Calendar.MONTH) + 1)) + "-" 
				+ Integer.toString(c.get(Calendar.DAY_OF_MONTH)) + " "
				+ Integer.toString(c.get(Calendar.AM_PM)) + " " 
				+ Integer.toString(c.get(Calendar.HOUR)) + ":" 
				+ Integer.toString(c.get(Calendar.MINUTE));


		board.setTeam_id(team_id);
		board.setTitle(request.getParameter("title"));
		board.setB_date(date);		
		board.setB_content(request.getParameter("b_content"));
		board.setWriter_id(id);

		manager.write(board);
		
		ActionForward forward = new ActionForward();
		forward.setPath("team_board_list.m2?command=team_board_list");
		forward.setRedirect(true);

		return forward;
	}

}
