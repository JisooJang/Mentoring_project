<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ page import="java.util.Calendar" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<center>
<font color="#6d6d6d"> <h2> <%= (String)session.getAttribute("team_name") %>팀 공지, 활동 게시판</h2></font>
<img src="images/team/clipboard.png" width="100" height="100">

<form name="f" method="post" action="team_board_list.m2?command=team_board_write">

<table>
		<tr>
		<td width="800" align="center" bgcolor="#a3caad">제목 &nbsp; <input type="text" size="100" name="title"></td>
		</tr>	

		<tr>
		<td width="800" align="center" bgcolor="#a3caad">내용</td>
		</tr>

		<tr>
		<td  height="400" align="center" bgcolor="#a3caad"><textarea name="b_content" style="width: 100%; height: 100%;"></textarea></td>
		</tr>

		<tr>
		<th align="right" bgcolor="#a3caad"><input type="submit" value="확인"></th>
</tr>
</table>
</center>
</form>

</body>
</html>