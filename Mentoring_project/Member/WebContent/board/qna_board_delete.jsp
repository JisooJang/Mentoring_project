<%@ page language="java" contentType="text/html; charset=euc-kr"%>
<%
	int num=Integer.parseInt(request.getParameter("num"));
%>
<html>
<head>
<title>�������� �Խ���</title>
</head>
<body>
<form name="deleteForm" action="NotiBoardDeleteAction.m2?command=NotiBoardDeleteAction&num=<%=num %>" 
	method="post">
<table border=1>
<tr>
	<td>
		<font size=2><div align="center">�ش� ���� �����Ͻðڽ��ϱ�?</div> </font>
	</td>
	
</tr>
<tr>
	<td colspan=2 align=center>
		<a href="javascript:deleteForm.submit()">����</a>
		&nbsp;&nbsp;
		<a href="javascript:history.go(-1)">���ư���</a>
	</td>
</tr>
</table>
</form>
</body>
</html>