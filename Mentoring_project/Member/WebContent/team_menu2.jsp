<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<style type="text/css">
a { text-decoration:none }
</style>

</head>
<body>
<center>
<%
String team_id = (String)session.getAttribute("team_id");
%>
<br><br>
<table align="center" border="0" bordercolor="#2f6495" cellpadding="0" cellspacing="0" width="180">
<tr align="center"><td align="center" valign="middle"><a href="team_board_list.m2?command=team_board_list" target="team_main">
<img src="images/team/board.jpg"></a><br></td></tr>

<tr align="center"><td align="center" valign="middle"><a href="team_addr.m2?command=team_member_list" target="team_main">
<img src="images/team/addr.jpg"></a><br></td></tr>	

<tr align="center"><td align="center" valign="middle"><a href="team_calendar_list.m2?command=team_calendar_list" target="team_main">
<img src="images/team/cal.jpg"></a><br></td></tr>

<tr align="center"><td align="center" valign="middle"><a href="team_tweet.m2?command=team_twitter&team_id=<%=team_id%>" target="team_main">
<img src="images/team/tweet.jpg"></a><br></td></tr>

<tr align="center"><td align="center" valign="middle"><a href="team_diary.m2?command=teamDiary&team_id=<%=team_id%>" target="_parent">
<img src="images/team/go_menu.png"></a><br></td></tr>
</table>
</center>
</body>
</html>