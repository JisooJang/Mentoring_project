package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.Board;
import model.BoardManager;

public class boardModifyAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String board_code = request.getParameter("board_code");
		BoardManager manager = BoardManager.getInstance();
		
		HttpSession session = request.getSession();
		String writer = (String)session.getAttribute("mbId");
		
		Board board = new Board();
		board.setBoard_code(board_code);
		board.setWriter(writer);
		board.setPw(request.getParameter("pw"));
		board.setSubject(request.getParameter("subject"));
		board.setContent(request.getParameter("content"));
		board.setRegdate(request.getParameter("regdate"));
		board.setReadcount(Integer.parseInt(request.getParameter("readcount")));
		board.setReccount(Integer.parseInt(request.getParameter("reccount")));
		
		ActionForward forward = new ActionForward();
		
		manager.boardmodify(board);
		
		
		forward.setPath("board_list.m2?command=retrieveBoardList");
		return forward;
	}

}
