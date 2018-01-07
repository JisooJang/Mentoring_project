package controller.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import controller.ActionForward;
import model.Board;
import model.BoardManager;


public class BoardCreateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		if (request.getMethod().equals("GET")) {	// request an insert form
			ActionForward forward = new ActionForward();
			forward.setPath("board_write.jsp");
			forward.setRedirect(true);
			return forward;
	}
	
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd-hh:mm:ss");
		String datetime = sdf.format(cal.getTime());
		
		HttpSession session = request.getSession();
		String writer = (String)session.getAttribute("mbId");
		
		Board board = new Board();
		board.setBoard_code(request.getParameter("board_code"));
		board.setWriter(writer);
		board.setPw(request.getParameter("pw"));
		board.setSubject(request.getParameter("subject"));
		board.setContent(request.getParameter("content"));
		board.setRegdate(datetime);
		board.setReadcount(0);
		board.setReccount(0);
		
		ActionForward forward = new ActionForward();
		
		
			BoardManager manager = BoardManager.getInstance();
			manager.create(board);

			forward.setPath("board_list.m2?command=retrieveBoardList");
			forward.setRedirect(true);
					
		
			
		return forward;
	}

}
