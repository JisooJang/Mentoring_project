<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% List<Reply> replyList = (List<Reply>)request.getAttribute("replyList"); %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>reply_list.jsp</title>

<link rel=stylesheet href="${pageContext.request.contextPath}/css/boardinfo.css" type="text/css">

</head>
<body>


<hr>
<br><br>
<div align="center" class="flexbox" style="margin-top: 30px;">
			<div class="outer-container">
				<span class="header-title">댓글</span><br />
				<span class="header-subtitle">reply</span><br /><hr />
			</div>
		</div> 

<br><br>
<center>
<table align="center" boarder="0">
<%
	Iterator<Reply> replyIter = replyList.iterator();

	if(!replyIter.hasNext()) {
		out.println("댓글이 없습니다.");
	}
	else {
		%>
		<tr>
			<td width="300ox">내용</td>
			<td>등록시간</td>
			<td>작성자</td><br>
		</tr>
 		<%
		while(replyIter.hasNext()) {
			Reply reply = (Reply)replyIter.next();
		%>
		 	<tr>
			<td width="300ox"><%=reply.getReplycontent() %></td>
			<td><%=reply.getReplyregdate() %></td>
			<td><%=reply.getReplywriter() %></td>
			</tr>		
		<%
		}
	}
	%>

</table>
</center>

</body>
</html>