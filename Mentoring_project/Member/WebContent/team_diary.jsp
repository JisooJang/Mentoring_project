<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
<%@ page import="model.Team" %>
<%@ page import="model.MemberManager" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

</head>
<body>
<center>
<br><br>
<font color="#123a78"><h2>가입한 팀 목록 </h2><br></font>
<table align="center" border="0" cellpadding="0" cellspacing="1"
 bgcolor="silver" width="550">

<%
	MemberManager manager = MemberManager.getInstance();
	List<Team> list = (List<Team>)request.getAttribute("list");
	Iterator<Team> userIter = list.iterator();
	
	if(!(userIter.hasNext())) {
		out.println("현재 가입한 팀이 없네요. 멘토를 검색해서 팀을 가입해보세요!"); %>
		
		<br><br> <h3>멘토 찾기</h3>
		<jsp:include page="search_frame.jsp" />
		
		<% 
	}
	
	else {
		 
	while ( userIter.hasNext()) {
		
		Team team = (Team)userIter.next();

%>		
		  	 
		  	<tr>
		  		
				<td bgcolor="white" rowspan="3" width="200" align="center" bgcolor="ffffff" height="20">
					<br><a href="team_menu.jsp?team_id=<%= team.getTeam_id()%>"><img src="images/team2.PNG" width="300"></a>
					</td>
					
					<tr><br><td bgcolor="white">
					<img src="images/team/clip.png" width="30" height="30"><font color="#535556"><b>《<%= team.getTeam_name() %>》</a>
					<br><br>
					<img src="images/team/clip.png" width="30" height="30">멘토 아이디:&nbsp;<%= team.getMento_id() %> 
					<br><br>
				
					<img src="images/team/clip.png" width="30" height="30">팀 분야 :&nbsp;<%= manager.change_keyword(team.getField()) %></b></font><br>
				</td>

		  	</tr>
		  		
<%
		}
	}
%>		  	
</table>

</center>
</body>
</html>