package controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.Message;
import model.MessageManager;

public class retrieveMessageListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String rec_message_id = (String)session.getAttribute("mbId");
		
		MessageManager manager = MessageManager.getInstance();
		
		List<Message> msgList = manager.retrieveMessageList(rec_message_id);
		
		ActionForward forward = new ActionForward();
		request.setAttribute("msgList", msgList);
		
		forward.setPath("message_list.jsp");
		return forward;
	}

}
