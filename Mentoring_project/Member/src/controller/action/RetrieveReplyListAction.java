package controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import model.Reply;
import model.ReplyManager;


public class RetrieveReplyListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		
		String board_code = request.getParameter("board_code");
		
		

		
		ReplyManager manager = ReplyManager.getInstance();
		
		List<Reply> replyList = manager.retrieveReplyList(board_code);
		

		ActionForward forward = new ActionForward();
		
		

		request.setAttribute("replyList", replyList);
			
		//이동할 페이지 결정
		forward.setPath("board_all.jsp");
		
		
		return forward;
	}

}
