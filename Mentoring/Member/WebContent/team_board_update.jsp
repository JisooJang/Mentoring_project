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
<font color="#6d6d6d"> <h2><%= (String)session.getAttribute("team_name")%>팀 공지, 활동 게시판 수정</h2></font>
<img src="images/team/clipboard.png" width="100" height="100">
<table>

		<tr>
		<td width="800" align="center" bgcolor="#a3caad">제목 : <input type="text" name="title" value="${board.title }"></td>
		</tr>

		<tr>
		<td width="800" align="center" bgcolor="#a3caad">작성자 : <input type="text" name="writer_id" value="${board.writer_id }"><br></td>
		</tr>

		<tr>
		<td width="800" align="center" bgcolor="#a3caad">내용</td>
		</tr>		

		<tr>
		<td height="400" align="center" bgcolor="#a3caad"><textarea name="b_content" style="width: 100%; height: 100%;">${board.b_content }</textarea></td>
		</tr>

		<tr>
		<th align="right" bgcolor="#a3caad"><input type="submit" value="수정">
		<input type="button" value="취소" onclick="history.back()"></th>
		</tr>


</table>
</center>
</form>
</body>
</html>