package controller.action;

import controller.*;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.*;

 public class NotiBoardModifyAction implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		 request.setCharacterEncoding("euc-kr");
		 ActionForward forward = new ActionForward();
		 boolean result = false;

		 int num=Integer.parseInt(request.getParameter("NOTI_NUM"));
		 
		 NBoardDAO boarddao=new NBoardDAO();
		 NBoardBean boarddata=new NBoardBean();
		 HttpSession session = request.getSession();
		 
		   	if(!(session.getAttribute("mbId").toString().equals("dongduk1234"))){
		   		response.setContentType("text/html;charset=euc-kr");
		   		PrintWriter out=response.getWriter();
		   		out.println("<script>");
		   		out.println("alert('수정할 권한이 없습니다.');");
		   		out.println("location.href='NotiBoardList.m2?command=NotiBoardList';");
		   		out.println("</script>");
		   		out.close();
		   		return null;
		   	}
		   	
		 
		 try{
			 boarddata.setNOTI_NUM(num);
			 boarddata.setNOTI_SUBJECT(request.getParameter("NOTI_SUBJECT"));
			 boarddata.setNOTI_CONTENT(request.getParameter("NOTI_CONTENT"));
			 
			 result = boarddao.boardModify(boarddata);
			 if(result==false){
		   		System.out.println("게시판 수정 실패");
		   		return null;
		   	 }
		   	 System.out.println("게시판 수정 완료");
		   	 
		   	 forward.setRedirect(true);
		   	 forward.setPath("NotiBoardDetailAction.m2?command=NotiBoardDetailAction&num="+boarddata.getNOTI_NUM());
		   	 return forward;
	   	 }catch(Exception ex){
	   			ex.printStackTrace();	 
		 }
		 
		 return null;
	 }
}