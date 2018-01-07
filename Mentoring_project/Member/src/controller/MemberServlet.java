package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.Action;

/**
 * @web.servlet name="member" 
 * 				display-name="Member" 
 * 
 * @web.servlet-mapping url-pattern="*.m2"
 */


@SuppressWarnings("serial")
public class MemberServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			ActionForward forward = null;
			Action action = null;
			try {
				
				MemberCommandFactory cf = MemberCommandFactory.getInstance();

				String command ="";

				if(request.getServletPath().equals("/join1.m2")){
					command = "insert";
					
				}else if(request.getServletPath().equals("/update1.m2")){
					command = "update";
				}else{
					command = request.getParameter("command");
				}
				
				if (command == null) {
					command = "view";
				}
				
				
				action = cf.getAction(command);

				forward = action.execute(request, response);
			} catch (Exception e) {
				throw new ServletException(e.getMessage());
			}

			if ( forward.isRedirect()) {
				response.sendRedirect(forward.getPath()); 
			} else {
				RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
				rd.forward(request, response);			
			}		
		}
}
