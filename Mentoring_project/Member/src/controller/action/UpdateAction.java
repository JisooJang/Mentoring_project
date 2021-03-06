package controller.action;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.ActionForward;
import model.Member;
import model.MemberManager;

public class UpdateAction implements Action{
	public ActionForward execute(
			HttpServletRequest request,	HttpServletResponse response)
			throws Exception{
		
		 MemberManager manager = MemberManager.getInstance();
		 HttpSession session = request.getSession();
		    
		    request.setCharacterEncoding("euc-kr");
			String realFolder = "";
			String image = "";
			int maxSize = 1024*1024*5;
		    String encType = "euc-kr";
			String savefile = "upload";
			ServletContext scontext = request.getServletContext();
		    realFolder = scontext.getRealPath(savefile);
		    Member mb = new Member();
		    File dir = new File(realFolder);
		      if(!dir.exists()) 
		    	  dir.mkdir();
		    
		    try{
		    	  MultipartRequest multi=new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		    	  Enumeration<?> files = multi.getFileNames();
		    	  mb.setMbID((String)session.getAttribute("mbId"));
		    	  mb.setMbName(multi.getParameter("name"));
		  		  mb.setAddress(multi.getParameter("address"));
		  		  mb.setAge(Integer.parseInt(multi.getParameter("age")));
		  		  mb.setBirth(multi.getParameterValues("birth"));
		  		  mb.setEmail(multi.getParameterValues("email"));
		  		  mb.setField(multi.getParameterValues("field"));
		  		  mb.setGender(multi.getParameter("gender"));
		  		  mb.setJob(multi.getParameter("job"));
		  		  mb.setPhone(multi.getParameterValues("phone"));
		  		  mb.setPwd(multi.getParameter("pwd"));
		  		  mb.setRegion(multi.getParameterValues("region"));
		  		  mb.setAdmin_Id("som");
		    	  String file = (String)files.nextElement();
		    	  image = multi.getFilesystemName(file);
		    } catch(Exception e) {
		    	  e.printStackTrace();
		    }
		    String fullPath = realFolder + "\\" + image;
		    mb.setImg(fullPath);
		    manager.update(mb);
		
		ActionForward forward = new ActionForward();
		forward.setPath("mypage.m2");
		forward.setRedirect(true);
				
		return forward;
	}
}
