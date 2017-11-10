package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.Team;
import model.TeamManager;

public class TeamMainAction implements Action {

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      // TODO Auto-generated method stub
      HttpSession session = request.getSession();
      String team_id = (String)session.getAttribute("team_id");
      ActionForward forward = new ActionForward();
      TeamManager manager = TeamManager.getInstance();
      
      Team team = manager.getTeam(team_id);
      request.setAttribute("team", team);
      
      forward.setPath("team_main.jsp");
      forward.setRedirect(false);

      return forward;
   }

}
