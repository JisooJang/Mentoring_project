package controller.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.Message;
import model.MessageManager;


public class messageCreateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd-hh:mm:ss");
		String datetime = sdf.format(cal.getTime());
		
		
		HttpSession session = request.getSession();
		String send_message_id = (String)session.getAttribute("mbId");
		String rec_message_id = request.getParameter("rec_message_id");
		String message_subject = request.getParameter("message_subject");
		String message_content = request.getParameter("message_content");
		
		Message msg = new Message();
		msg.setMessag_id(request.getParameter("message_id"));
		msg.setMessage_content(message_content);
		msg.setMessage_info("N");
		msg.setMessage_send_time(datetime);
		msg.setMessage_subject(message_subject);
		msg.setRec_member_id(rec_message_id);
		msg.setSend_member_id(send_message_id);
		
		ActionForward forward = new ActionForward();
		
		MessageManager manager = MessageManager.getInstance();
		manager.create(msg);
		
		forward.setPath("message_ok.jsp");
		
		
		return forward;
	}

}
