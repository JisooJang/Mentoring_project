package controller.action;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.TeamBoard;
import model.TeamManager;

public class TeamBoardModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		TeamManager manager = TeamManager.getInstance();
		TeamBoard board = new TeamBoard();
		String writer_id = request.getParameter("writer_id");	//null
		HttpSession session = request.getSession();
		String team_id = (String)session.getAttribute("team_id");
		String mbId = (String)session.getAttribute("mbId");
		ActionForward forward = new ActionForward();

		Calendar c = Calendar.getInstance();
		String date = Integer.toString(c.get(Calendar.YEAR)) + "-" 
				+ Integer.toString((c.get(Calendar.MONTH) + 1)) + "-" 
				+ Integer.toString(c.get(Calendar.DAY_OF_MONTH)) + " "
				+ Integer.toString(c.get(Calendar.AM_PM)) + " " 
				+ Integer.toString(c.get(Calendar.HOUR)) + ":" 
				+ Integer.toString(c.get(Calendar.MINUTE));

		if(mbId.equals(writer_id)) {
			board.setTeam_id(team_id);
			board.setBoard_num(Integer.parseInt(request.getParameter("board_num")));
			board.setTitle(request.getParameter("title"));	
			board.setB_date(date);
			board.setB_content(request.getParameter("b_content"));	
			
			board.setComment_count(0);
			board.setHits(0);
			
			board.setWriter_id(request.getParameter("writer_id"));

			manager.update(board);
			
			request.setAttribute("board", board);		
		}
		else {
			System.out.println("작성자만 수정이 가능합니다.");
			request.setAttribute("result", "0");
		}

		
		forward.setPath("team_board_view.jsp");
		forward.setRedirect(false);

		return forward;

	}

}
