package controller.action;

import controller.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NBoardDAO;
import model.NBoardBean;

 public class NotiBoardDetailAction implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{ 
		request.setCharacterEncoding("euc-kr");
   		
		NBoardDAO boarddao=new NBoardDAO();
	   	NBoardBean boarddata=new NBoardBean();
	   	
		int num=Integer.parseInt(request.getParameter("num"));
		boarddao.setReadCountUpdate(num);
	   	boarddata=boarddao.getDetail(num);
	   	
	   	if(boarddata==null){
	   		System.out.println("�󼼺��� ����");
	   		return null;
	   	}
	   	System.out.println("�󼼺��� ����");
	   	
	   	request.setAttribute("boarddata", boarddata);
	   	ActionForward forward = new ActionForward();
	   	forward.setRedirect(false);
   		forward.setPath("./board/qna_board_view.jsp");
   		return forward;

	 }
}