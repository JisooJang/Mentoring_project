<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="model.TeamManager" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>team_main</title>
</head>
<%
	
	TeamManager manager = TeamManager.getInstance();
	String field = manager.getTeam_name((String)session.getAttribute("team_id"));
%>
<body>
<center>
<h2><font color="#0458a5">《${team.team_name}》&nbsp;팀 정보</font>
<img src="images/team/bulb.png" width="50" height="50"></h2><hr color="#ececec">
<br><br>
<table align="center"><tr><td>
<img src="images/team_main.PNG"><br> </td>
<td>
<ul>
&nbsp;&nbsp;&nbsp;&nbsp;<li>팀 분야 : <%= field %></li> 
&nbsp;&nbsp;&nbsp;&nbsp;<li>팀 멘토 : ${team.mento_id}</li> 
&nbsp;&nbsp;&nbsp;&nbsp;<li>팀 인원 : ${team.nofp}</li> 
&nbsp;&nbsp;&nbsp;&nbsp;<li>팀 시작일 : ${team.start_date}</li>
&nbsp;&nbsp;&nbsp;&nbsp;<li>팀 종료일 : ${team.end_date}</li>
&nbsp;&nbsp;&nbsp;&nbsp;<li>팀 모집 여부 : ${team.recruit}</li> 
&nbsp;&nbsp;&nbsp;&nbsp;<li>기간 연장 여부 : ${team.extend}</li> 
</ul>
</td>
</table>

</center>
</body>
</html>