<%@ page language="java" contentType="text/html; charset=euc-kr"%>
<%
	int num=Integer.parseInt(request.getParameter("num"));
%>
<html>
<head>
<title>공지사항 게시판</title>
</head>
<body>
<form name="deleteForm" action="NotiBoardDeleteAction.m2?command=NotiBoardDeleteAction&num=<%=num %>" 
	method="post">
<table border=1>
<tr>
	<td>
		<font size=2><div align="center">해당 글을 삭제하시겠습니까?</div> </font>
	</td>
	
</tr>
<tr>
	<td colspan=2 align=center>
		<a href="javascript:deleteForm.submit()">삭제</a>
		&nbsp;&nbsp;
		<a href="javascript:history.go(-1)">돌아가기</a>
	</td>
</tr>
</table>
</form>
</body>
</html>