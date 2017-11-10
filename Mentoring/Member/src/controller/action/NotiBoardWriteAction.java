package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;

public class NotiBoardWriteAction implements Action{
	public ActionForward execute(
			HttpServletRequest request,	HttpServletResponse response)
			throws Exception{
		ActionForward forward=null;
		forward=new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./board/qna_board_write.jsp");
		return forward;
	}

}
