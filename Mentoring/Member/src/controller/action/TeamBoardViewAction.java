package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.TeamBoard;
import model.TeamManager;

public class TeamBoardViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		TeamManager manager = TeamManager.getInstance();		
		HttpSession session = request.getSession();		
		String team_id = (String)session.getAttribute("team_id");
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		TeamBoard board = manager.getBoard(board_num, team_id);
		
		request.setAttribute("board", board);
		
		ActionForward forward = new ActionForward();
		forward.setPath("team_board_view.jsp");
		forward.setRedirect(false);

		return forward;
	}

}
