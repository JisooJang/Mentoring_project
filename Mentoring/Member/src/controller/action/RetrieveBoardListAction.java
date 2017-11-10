package controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import model.Board;
import model.BoardManager;

public class RetrieveBoardListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String currentPageStr = request.getParameter("currentPage");
		
		System.out.println("REtrieveBoardListAction      :    in    && currentPageStr:   "  + currentPageStr);
		
		
		int currentPage = 1;
		if ( (currentPageStr != null) && (!currentPageStr.equals("")) ) {
			currentPage = Integer.parseInt(currentPageStr);
		}
		
		int countPerPage = 10000;
		
		BoardManager manager = BoardManager.getInstance();
		
		List<Board> boardList = manager.retrieveBoardList(currentPage, countPerPage);
		
		//boardList ��ü�� response�� �����Ͽ� ����.
		request.setAttribute("boardList", boardList);
		
		//�̵��� ������ ����
		ActionForward forward = new ActionForward();
		forward.setPath("board_list.jsp");
		
		return forward;
	}

}
