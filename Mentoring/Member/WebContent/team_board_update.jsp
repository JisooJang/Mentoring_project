<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<body>
<form action="team_board_list.m2?command=team_board_update">

<input type="hidden" name="board_num" value="${board.board_num }">
<center>
<font color="#6d6d6d"> <h2><%= (String)session.getAttribute("team_name")%>�� ����, Ȱ�� �Խ��� ����</h2></font>
<img src="images/team/clipboard.png" width="100" height="100">
<table>

		<tr>
		<td width="800" align="center" bgcolor="#a3caad">���� : <input type="text" name="title" value="${board.title }"></td>
		</tr>

		<tr>
		<td width="800" align="center" bgcolor="#a3caad">�ۼ��� : <input type="text" name="writer_id" value="${board.writer_id }"><br></td>
		</tr>

		<tr>
		<td width="800" align="center" bgcolor="#a3caad">����</td>
		</tr>		

		<tr>
		<td height="400" align="center" bgcolor="#a3caad"><textarea name="b_content" style="width: 100%; height: 100%;">${board.b_content }</textarea></td>
		</tr>

		<tr>
		<th align="right" bgcolor="#a3caad"><input type="submit" value="����">
		<input type="button" value="���" onclick="history.back()"></th>
		</tr>


</table>
</center>
</form>
</body>
</html>