<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%@ page import="model.*" %>
   <%@ page import="java.util.*" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% List<Apply> applyList = (List<Apply>)request.getAttribute("applyList"); %>

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
				<span class="header-title">���� ������ �� ���(���ο�û ��)</span><br />
				<span class="header-subtitle">requesting team</span><br /><hr />
			</div>
		</div> 

<div class='table-container'>
<table>
<%
	Iterator<Apply> applyIter = applyList.iterator();

	if(!(applyIter.hasNext())) {
		out.println("��û������ �����ϴ�.<br>");
	}
	else {
		%>
		<tr>
		<td width="200px" align="center">����</td>
		<td width="500px" align="center">�����̵�</td>
		</tr>
		<%
		while(applyIter.hasNext()) {
			Apply apply = (Apply)applyIter.next();
		%>
		<tr>
		<td align="center"><%=apply.getState() %></td>
		<td align="center"><%=apply.getTeam_id() %></td>
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