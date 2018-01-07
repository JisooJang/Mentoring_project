package controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import model.Board;
import model.BoardManager;

public class bestBoardByreadcountAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		BoardManager manager = BoardManager.getInstance();
		
		List<Board> boardList = manager.bestBoardByreadcount();
		
		request.setAttribute("boardList", boardList);
		
		ActionForward forward = new ActionForward();
		forward.setPath("best_board_list.jsp");
		
		return forward;
	}

}
