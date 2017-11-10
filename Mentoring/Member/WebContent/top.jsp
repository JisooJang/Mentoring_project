<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="teamproject.css">
<style type="text/css">
a { text-decoration:none }
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="${context}/js/jquery.form.js"></script>
	<script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>


<%
	session = request.getSession();
	String mbId = (String)session.getAttribute("mbId");  %>


</head>
<body style="background-color: white;">
<a href="index.jsp">
<img src="images/title.png" width="100%">
</a>

<hr>
<table align="center">
<tr><td>
	<c:if test="mbId != null">&nbsp;&nbsp;
		<a href="board_write.m2?command=boardCreate"><font color="#292a85" size=5>글작성</font></a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="board_list.m2?command=retrieveBoardList"><font color="#292a85" size=5>게시판</font></a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="noti_list.m2?command=NotiBoardList" target="center"><font color="#292a85" size=5>공지사항</font></a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="search_frame.jsp" target="center"><font color="#292a85" size=5>멘토찾기</font></a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="char.m2?command=piechart" target="center"><font color="#292a85" size=5>통계</font></a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="team_diary.m2?command=teamDiary" target="center"><font color="#292a85" size=5>팀다이어리</font></a>&nbsp;&nbsp;
	</c:if>
	</td></tr></table>
<hr>



</body>
</html>