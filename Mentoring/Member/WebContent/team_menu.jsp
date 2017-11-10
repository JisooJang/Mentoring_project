<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="model.TeamManager" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	String team_id = request.getParameter("team_id");
	TeamManager manager = TeamManager.getInstance();
	String team_name = manager.getTeam_name(team_id);
	
	session.setAttribute("team_id", team_id);	//사용자가 클릭한 팀의 팀아이디가 세션에 저장되는 시점
	session.setAttribute("team_name", team_name);
	
%>


<frameset cols="15%,*"frameborder="yes" border="1" marginwidth="0" marginheight="0" noresize marginwidth="0" marginheight="0">
		<frame src="team_menu2.jsp" name="team_menu" scrolling="no">
		<frame src="team_main.m2?command=team_main" name="team_main" scrolling="no">
</frameset>

 
