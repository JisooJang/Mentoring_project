package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import model.BoardManager;

public class updateReplycountAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String board_code = request.getParameter("board_code");
		
		BoardManager manager = BoardManager.getInstance();
		
		manager.updateReplycount(board_code);
		
		ActionForward forward = new ActionForward();
		forward.setPath("board_view.m2?command=retrieveBoardIn");
		return forward;
	}

}
