package controller.action;

import controller.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NBoardDAO;
import model.NBoardBean;

public class NotiBoardModifyView implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 	ActionForward forward = new ActionForward();
		 	request.setCharacterEncoding("euc-kr");
	   		
			NBoardDAO boarddao=new NBoardDAO();
		   	NBoardBean boarddata=new NBoardBean();
		   	
			int num=Integer.parseInt(request.getParameter("num"));
		   	boarddata=boarddao.getDetail(num);
		   	
		   	if(boarddata==null){
		   		System.out.println("(수정)상세보기 실패");
		   		return null;
		   	}
		   	System.out.println("(수정)상세보기 성공");
		   	
		   	request.setAttribute("boarddata", boarddata);
		   	forward.setRedirect(false);
	   		forward.setPath("./board/qna_board_modify.jsp");
	   		return forward;
	 }
}