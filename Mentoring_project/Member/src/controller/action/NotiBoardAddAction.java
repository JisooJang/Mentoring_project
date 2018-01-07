package controller.action;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.ActionForward;
import model.NBoardDAO;
import model.NBoardBean;

public class NotiBoardAddAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		NBoardDAO boarddao = new NBoardDAO();
		NBoardBean boarddata = new NBoardBean();
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("euc-kr");
		String realFolder = "";
		String saveFolder = "boardupload";

		int fileSize = 5 * 1024 * 1024;

		realFolder = request.getRealPath(saveFolder);

		boolean result = false;
		boolean usercheck = false;

		HttpSession session = request.getSession();

		if (!(session.getAttribute("mbId").toString().equals("dongduk1234"))) {
			response.setContentType("text/html;charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록할 권한이 없습니다.');");
			out.println("location.href=\"NotiBoardList.m2?command=NotiBoardList\";");
			out.println("</script>");
			out.close();
			return null;
		}
		if (request.getParameter("BOARD_SUBJECT").equals("") || request.getParameter("BOARD_CONTENT").equals("")) 
		{
			response.setContentType("text/html;charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('올바르게 입력해주세요.');");
			out.println("location.href='NotiBoardList.m2?commmand=NotiBoardList';");
			out.println("</script>");
			out.close();
		} else {

			try {

				Map<String, String[]> dataMap = request.getParameterMap();
				Iterator<String> item = dataMap.keySet().iterator();

				boarddata.setNOTI_SUBJECT(request.getParameter("BOARD_SUBJECT"));
				boarddata.setNOTI_CONTENT(request.getParameter("BOARD_CONTENT"));

				result = boarddao.boardInsert(boarddata);

				if (result == false) {
					System.out.println("게시판 등록 실패");
					return null;
				}
				System.out.println("게시판 등록 완료");
				System.out.println(boarddata.getNOTI_SUBJECT());

				forward.setRedirect(true);
				forward.setPath("NotiBoardList.m2?command=NotiBoardList");
				return forward;

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
		return null;
	}
}