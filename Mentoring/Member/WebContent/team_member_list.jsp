<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
        <%@ page import="model.*" %>
   <%@ page import="java.util.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% List<TeamMember> teamMemberList = (List<TeamMember>)request.getAttribute("teamMemberList"); %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<link rel=stylesheet href="${pageContext.request.contextPath}/css/boardinfo.css" type="text/css">

</head>
<body>
<center>
<div align="center" class="flexbox" style="margin-top: 30px;">
			<div class="outer-container">
				<span class="header-title">나의 팀원</span><br />
				<span class="header-subtitle">my team member</span><br /><hr />
			</div>
		</div> 
<br>
<hr>
<br>
<div class='table-container'>
<table>
<%
	Iterator<TeamMember> teamMemberIter = teamMemberList.iterator();

	if(!(teamMemberIter.hasNext())) {
		out.println("팀멤버가 없습니다.");
	}
	else {
		%>
		<tr>
		<td>tm_id</td>
		<td>member_id</td>
		<td>team_id</td>
		</tr>
		<%
		while(teamMemberIter.hasNext()) {
			TeamMember teamMember = (TeamMember)teamMemberIter.next();
		%>
		<tr>
		<td><%=teamMember.getTm_id() %></td>
		<td><%=teamMember.getMember_id() %></td>
		<td><%=teamMember.getTeam_id() %></td>
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