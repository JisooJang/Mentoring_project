package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import model.Message;
import model.MessageManager;

public class retrieveMessageAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String message_id = request.getParameter("message_id");
		
		MessageManager manager = MessageManager.getInstance();
		
		Message message = manager.retrieveMessage(message_id);
		
		request.setAttribute("message", message);
		
		ActionForward forward = new ActionForward();
		forward.setPath("message_view.jsp");
		
		return forward;
	}

}
