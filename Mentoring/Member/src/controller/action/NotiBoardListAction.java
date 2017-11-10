package controller.action;

import controller.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NBoardDAO;

 public class NotiBoardListAction implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		NBoardDAO boarddao=new NBoardDAO();
		List boardlist=new ArrayList();
		request.setCharacterEncoding("euc-kr");
		int page=1;
		int limit=30; //�� ������
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		boardlist = boarddao.getBoardList(page,limit); //����Ʈ�� �޾ƿ�
		int listcount=boardlist.size(); //�� ����Ʈ ���� �޾ƿ�
		
		//�� ������ ��
 		int maxpage=(int)((double)listcount/limit+0.95); //0.95�� ���ؼ� �ø� ó��
 		//���� �������� ������ ���� ������ ��(1, 11, 21 ��...)
 		int startpage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
 		//���� �������� ������ ������ ������ ��(10, 20, 30 ��...)
		int endpage = startpage+10-1;

 		if (endpage> maxpage) endpage= maxpage;

 		
 		request.setAttribute("page", page); //���� ������ ��
 		request.setAttribute("maxpage", maxpage); //�ִ� ������ ��
 		request.setAttribute("startpage", startpage); //���� �������� ǥ���� ù ������ ��
 		request.setAttribute("endpage", endpage); //���� �������� ǥ���� �� ������ ��
		request.setAttribute("listcount",listcount); //�� ��
		request.setAttribute("boardlist", boardlist);
		
		ActionForward forward= new ActionForward();
	 	forward.setRedirect(false);
 		forward.setPath("./board/qna_board_list.jsp");
 		return forward;
	 }
 }