<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% Message msg = (Message)request.getAttribute("message"); %>

<link rel=stylesheet href="${pageContext.request.contextPath}/css/boardinfo.css" type="text/css">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<div align="center" class="flexbox" style="margin-top: 30px;">
			<div class="outer-container">
				<span class="header-title">메세지 상세보기</span><br />
				<span class="header-subtitle">message</span><br /><hr />
			</div>
		</div> 
		
	<div class='table-container'>
	<table border='0' cellspacing=0 align=center width=650px;>
		<tr bordercolor=#9FC93C  align = center>
			 <td>제목</td>
			 <td colspan="3"><%=msg.getMessage_subject() %></td>
		</tr> 
		<tr bordercolor=#9FC93C  align = center>
			<td>보낸사람</td>
			<td><%=msg.getSend_member_id() %></td>
			<td>보낸시간</td>
			<td><%=msg.getMessage_send_time() %></td>
		</tr>
	</table>
	<br><br>
	<center>
		<div  style="border: 1px solid #48BAE4; height: 300px; width: 650px;"><br>
		<%=msg.getMessage_content() %>
		</div>
			</div>
			</center>
</body>
</html>