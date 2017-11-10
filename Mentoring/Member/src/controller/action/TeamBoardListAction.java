package controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.TeamBoard;
import model.TeamManager;

public class TeamBoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		TeamManager manager = TeamManager.getInstance();
		//HttpSession session = request.getSession();
		//String mbId = (String)session.getAttribute("mbId");
		/* String currentPageStr = request.getParameter("currentPage");		
		int currentPage = 1;
		if ( (currentPageStr != null) && (!currentPageStr.equals("")) ) {
			currentPage = Integer.parseInt(currentPageStr);
		}
		int countPerPage = 10; */
		HttpSession session = request.getSession();
		String team_id = (String)session.getAttribute("team_id");
		int num = 1;
		
		
		List<TeamBoard> list = manager.getBoardList(team_id);	
		
		
		if(request.getAttribute("board_remove_fail") != null) {	
			request.setAttribute("board_remove_fail", "0");		
		}
		
		//userList객체를 response에 저장하여 전달.
		request.setAttribute("list", list);	
		request.setAttribute("num", num);
		
		ActionForward forward = new ActionForward();
		forward.setPath("team_board_list.jsp");
		forward.setRedirect(false);

		return forward;
	}

}
