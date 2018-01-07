package controller.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.Reply;
import model.ReplyManager;

public class ReplyCreateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		if (request.getMethod().equals("GET")) {	// request an insert form
			ActionForward forward = new ActionForward();
			forward.setPath("reply_write.jsp");
			forward.setRedirect(true);
			return forward;
		}
		
		String board_code = request.getParameter("board_code");
				
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd-hh:mm:ss");
		String datetime = sdf.format(cal.getTime());
		
		HttpSession session = request.getSession();
		String replywriter = (String)session.getAttribute("mbId");
		
		Reply reply = new Reply();
		reply.setReply_code(request.getParameter("reply_code"));
		reply.setBoard_code(board_code);
		reply.setReplycontent(request.getParameter("replycontent"));
		reply.setReplyregdate(datetime);
		reply.setReplywriter(replywriter);
		
		ActionForward forward = new ActionForward();
		
		ReplyManager manager = ReplyManager.getInstance();
		manager.create(reply);
		
		//forward.setPath("board_view.jsp");
		forward.setPath("board_view.m2?command=retrieveBoardIn");
		
		System.out.println(forward + "                       forward replyCreateAction");
		
		forward.setRedirect(false);
		
		return forward;
		
	}

}
