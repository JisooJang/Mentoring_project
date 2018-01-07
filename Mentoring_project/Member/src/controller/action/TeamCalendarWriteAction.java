package controller.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.TeamCalendar;
import model.TeamManager;

public class TeamCalendarWriteAction implements Action {

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      // TODO Auto-generated method stub
      ActionForward forward = new ActionForward();
      HttpSession session = request.getSession();
      String team_id = (String)session.getAttribute("team_id");
      TeamManager manager = TeamManager.getInstance();
      
      String month = (String)session.getAttribute("month");
      String day = (String)session.getAttribute("day");
      
      if(request.getParameter("c_time1").equals("--") || request.getParameter("c_time2").equals("--")) {
          response.setContentType("text/html;charset=euc-kr");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('시간을 선택해주세요');");
            out.println("location.href=\"team_calendar_write.jsp?month=" + month + "&day=" + day + "\";");
            out.println("</script>");
            out.close();
            
            return null;
      }
      
      String c_time = request.getParameter("c_time1") + ":" + request.getParameter("c_time2"); 
      String c_spot = request.getParameter("c_spot");
      String c_date = month + "/" + day;
      String c_content = request.getParameter("c_content");
      
      TeamCalendar calendar = new TeamCalendar();
      
      calendar.setTeam_id(team_id);
      calendar.setWriter_id((String)session.getAttribute("mbId"));
      calendar.setC_date(c_date);
      calendar.setC_content(c_content);
      calendar.setC_time(c_time);
      calendar.setC_spot(c_spot);
      
      manager.calendar_write(calendar);
      request.setAttribute("calendar", calendar);
      
      String team_name = manager.getTeam_name(team_id);
      request.setAttribute("team_name", team_name);
      
      
      
      forward.setPath("team_calendar_list.m2?command=team_calendar_list");
      forward.setRedirect(false);
      return forward;
   }

}