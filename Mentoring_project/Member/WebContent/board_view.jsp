<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="model.*, java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<link href="${pageContext.request.contextPath}/css/board-look.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>board_view.jsp</title>
</head>
<body>
<center>
<div align="center" class="flexbox" style="margin-top: 30px;">
			<div class="outer-container">
				<span class="header-title">상세보기</span><br />
				<span class="header-subtitle">freeboard</span><br /><hr />
			</div>
		</div> 


<% 
Board lb = (Board)request.getAttribute("board");

out.println(
		"<hr>" + lb.getSubject() + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
		+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
		+ lb.getRegdate() + "<hr>");

out.println("<br>조회수  <b>" + lb.getReadcount() +"</b>&nbsp;&nbsp;&nbsp;&nbsp; 댓글 <b>" + lb.getReplycount() +"</b>");



out.println("<br><br><br><br><br><br><div align='center' height='500px' width='500px'>" + lb.getContent() + "</div>");



%>


<br><br><br><br><br><br><br><br><br>
-<hr>

<a href="board_view.m2?board_code=${board.board_code}&command=recBoardCreate"><img src="images/like.png" heigth="100px" width="100px"></a>
<br>
<%=lb.getReccount() %>
</center>

<br>

</body>
</html>