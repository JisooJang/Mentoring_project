package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.TeamManager;

public class TeamBoardRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		TeamManager manager = TeamManager.getInstance();
		HttpSession session = request.getSession();
		String mbId = (String)session.getAttribute("mbId");
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String team_id = (String)session.getAttribute("team_id");
		String writer_id = request.getParameter("writer_id");
		
		if(mbId.equals(writer_id)) {
			manager.remove(board_num, team_id);
		} else {
			System.out.println("작성자만 삭제가 가능합니다.");
			request.setAttribute("board_remove_fail", "0");
		}
		
		
		
		forward.setPath("team_board_list.m2?command=team_board_list");
		forward.setRedirect(false);

		return forward;
	}

}
