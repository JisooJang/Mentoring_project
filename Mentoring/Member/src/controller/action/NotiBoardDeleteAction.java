package controller.action;

import java.io.PrintWriter;
import controller.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;


public class NotiBoardDeleteAction implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		 
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("euc-kr");
		HttpSession session = request.getSession();
	   	boolean result=false;
	   	boolean usercheck=false;
	   	int num=Integer.parseInt(request.getParameter("num"));
	   	
	   	NBoardDAO boarddao=new NBoardDAO();

	   	if(!(session.getAttribute("mbId").toString().equals("dongduk1234"))){
	   		response.setContentType("text/html;charset=euc-kr");
	   		PrintWriter out=response.getWriter();
	   		out.println("<script>");
	   		out.println("alert('������ ������ �����ϴ�.');");
	   		out.println("location.href=\"NotiBoardList.m2?command=NotiBoardList\";");
	   		out.println("</script>");
	   		out.close();
	   		return null;
	   	}
	   	
	   	result=boarddao.boardDelete(num);
	   	if(result==false){
	   		System.out.println("�Խ��� ���� ����");
	   		return null;
	   	}
	   	
	   	System.out.println("�Խ��� ���� ����");
	   	forward.setRedirect(true);
   		forward.setPath("NotiBoardList.m2?command=NotiBoardList");
   		return forward;
	 }
}