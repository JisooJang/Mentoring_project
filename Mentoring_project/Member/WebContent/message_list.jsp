<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%List<Message> msgList = (List<Message>)request.getAttribute("msgList"); %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>

<link rel=stylesheet href="${pageContext.request.contextPath}/css/boardinfo.css" type="text/css">


<body>

<div align="center" class="flexbox" style="margin-top: 30px;">
			<div class="outer-container">
				<span class="header-title">쪽지보관함</span><br />
				<span class="header-subtitle">message-box</span><br /><hr />
			</div>
		</div> 

<div class='table-container'>
<table border='1' cellspacing=0 align=center>
<%
	Iterator<Message> messageIter = msgList.iterator();

	if(!messageIter.hasNext()) {
		out.println("쪽지가 없습니다");
	} else {
		%>
		<tr>
			<td></td>
			 <td width="500" size="500" align="center">제목</td>
			 <td width="300" align="center">받은날짜</td>
			 <td align="center">확인상태</td>
			 <br><br>
		</tr>
		<%
		while (messageIter.hasNext()) {
			Message msg = (Message)messageIter.next();
		%>
		<tr bordercolor=#9FC93C  align = center>
			<td></td>
			<td><a href="message_view.m2?message_id=<%=msg.getMessag_id() %>&command=RetrieveMessage"><%=msg.getMessage_subject() %></a></td>
			<td><%=msg.getMessage_send_time() %></td>
			<td><%=msg.getMessage_info() %></td>
			</tr>
		
	<%
	} }
%>
</table>
</div>
</body>
</html>