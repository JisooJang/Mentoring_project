<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<%
	
%>
<script language="javascript">
function remove() {
	var result = confirm("���� �����Ͻðڽ��ϱ�?");
	
	if(result == true) {
	location.href = 'team_board_list.m2?command=team_calendar_remove&writer_id=${calendar.writer_id}&calendar_id=${calendar.calendar_id}';
	}
}

function modify() {
	location.href = 'team_board_update.m2?command=team_calendar_update&writer_id=${calendar.writer_id}&calendar_id=${calendar.calendar_id}';	
}
</script>
</head>
<body
<%
 if(request.getAttribute("cal_update_fail") != null) {
	 out.println("onLoad=\"alert('�ۼ��ڸ� ���� �����մϴ�.')\">");
 }
 else {
%>
>
<% } %>
<center>
<form name="f">
<br><br><br>
<font color="#317190"><h3><%= (String)session.getAttribute("team_name") %>�� ${month}�� ${day}�� ���� �� ����</h3></font><br><br>

<table align="center" width="200">
<tr><td>�ۼ���</td> <td>${calendar.writer_id} </td></tr>
<tr><td>��¥</td> <td>${calendar.c_date} </td></tr>
<tr><td>���� </td> <td>${calendar.c_content} </td></tr>
<tr><td>�ð� </td> <td>${calendar.c_time} </td></tr>
<tr><td>��� </td> <td>${calendar.c_spot} </td></tr>
<tr><td colspan="2">
<input type="button" value="���" onClick="location.href='team_board_list.m2?command=team_calendar_list'">
<input type="button" value="����" onClick="modify()">
<input type="button" value="����" onClick="remove()"></td></tr>
</table>
</form>
</center>
</body>
</html>