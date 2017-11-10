<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
       <%@ page import="model.*" %>
   <%@ page import="java.util.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% List<Team> teamList = (List<Team>)request.getAttribute("teamList"); %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<link rel=stylesheet href="${pageContext.request.contextPath}/css/boardinfo.css" type="text/css">


</head>
<body>
<a href="create_team.jsp">
<center><h1>팀개설하기</h1><h7 font-color="blue">click!</h7></a><br><br>
<br>
<div align="center" class="flexbox" style="margin-top: 30px;">
			<div class="outer-container">
				<span class="header-title">내가 만든 팀 목록</span><br />
				<span class="header-subtitle">mento' teamList</span><br /><hr />
			</div>
		</div>
		
<div class='table-container'> 

<table  table border='0' cellspacing=0 align=center>
<%
	Iterator<Team> teamIter = teamList.iterator();

	if(!(teamIter.hasNext())) {
		out.println("팀을 만들지 않았습니다.");
	}
	else {
		%>
		<tr>
		<td>팀아이디</td>
		<td>참가자수</td>
		<td>팀이름</td>
		</tr>
		<%
		while(teamIter.hasNext()) {
			Team team = (Team)teamIter.next();
		%>
		<tr>
		<td><%=team.getTeam_id() %></td>
		<td><%=team.getNofp() %></td>
		<td>
		 <a href="apply_list.m2?team_id=<%=team.getTeam_id()%>&command=RetrieveApplyList" class="apply"><%=team.getTeam_name() %></td>
		 <td><a href="team_list.m2?command=deleteTeam&tid=<%=team.getTeam_id()%>">팀종료</a></td>
		</tr>
		<%
		}
	}
%>
</table>
</div>
</center>

</body>
</html>