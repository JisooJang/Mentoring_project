package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import model.Board;
import model.BoardManager;

public class retrieveBoardInAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String board_code = request.getParameter("board_code");
		
		BoardManager manager = BoardManager.getInstance();
		Board board = manager.retrieveBoardIn(board_code);
		
		request.setAttribute("board", board);
		
		ActionForward forward = new ActionForward();
		
		System.out.println("retrieveBoardInAction           " + forward);
		//forward.setPath("board_view.jsp");
		forward.setPath("reply_list.m2?board_code="+board_code+"&command=retrieveReplyList");
		
		
		
		System.out.println("retrieveBoardInAction           " + forward);
		
		
		return forward;
	}

}
