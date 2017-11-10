package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.RecBoard;
import model.RecBoardManager;

public class recBoardCreateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String recPerson = (String)session.getAttribute("mbId");
		
		String board_code =request.getParameter("board_code");
		
		
		RecBoard recBoard = new RecBoard();
		recBoard.setBoard_code(board_code);
		recBoard.setMember_id(recPerson);
		recBoard.setRec_id(request.getParameter("rec_id"));
		
		ActionForward forward = new ActionForward();
		
		RecBoardManager manager= RecBoardManager.getInstance();
		manager.create(recBoard);
		
		forward.setPath("board_view.m2?command=updateReccount&board_code="+board_code);
		
		
		return forward;
	}

}
