<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<script language="javascript">
function delete_post() {
	var result = confirm("���� �����Ͻðڽ��ϱ�?");
	if(result == true) {
		location.href='team_board_list.m2?command=team_board_remove&writer_id=${board.writer_id }&board_num=${board.board_num}';
	}
}

</script>
</head>

<body
<%
String result = (String)(request.getAttribute("result"));
 if(result != null) {
	 out.println("onLoad=\"alert('�ۼ��ڸ� ���� �����մϴ�.')\">");
 }
 else {
%>
>
<% } %>
<center>

<font color="#6d6d6d"> <h2> <%= (String)session.getAttribute("team_name") %>�� ����, Ȱ�� �Խ���</h2></font>
<img src="images/team/clipboard.png" width="100" height="100">
	<table>

		<tr>
		<td width="100" align="center" bgcolor="#a3caad"><b>����</b></td>
		<td>${board.title} </td>
		</tr>		

		<tr>
		<td width="100" align="center" bgcolor="#a3caad"><b>�ۼ���</b> </td>
		<td>${board.writer_id} </td>
		</tr>
		
		<tr>
		<td width="100" align="center" bgcolor="#a3caad"><b>�ۼ���</b></td>
		<td>${board.b_date}</td>
		</tr>		
				
		<tr>
		<th colspan="2" width="800" align="center" bgcolor="#a3caad"><b>����</b></th>
		</tr>		

		<tr>
		<th colspan="2" height="400" align="center">
		${board.b_content}	
		</th>
		</tr>

		

		

		<tr>

			<th colspan="2" align="center" width="100">

			<input type="button" value="���"

 			onclick="location.href='team_board_list.m2?command=team_board_list'">

 			<input type="button" value="����"

 			onclick="delete_post()">

 			<input type="button" value="����"

 			onclick="location.href='team_board_modify.m2?command=team_board_update&writer_id=${board.writer_id }&board_num=${board.board_num}'">
 			</th>	
		</tr>

	</table>
</center>
</body>
</html>