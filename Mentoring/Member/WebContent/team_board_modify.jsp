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
function modify() {
	var result = confirm("정말 수정하시겠습니까?");
	
	if(result == true) {
		f.command.value = "team_board_modify";
		f.action = "team_board_view.m2?writer_id=${board.writer_id }&board_num=${board.board_num }";
		f.submit();
	}
}

</script>
</head>
<body>

<center>
<font color="#6d6d6d"> <h2> <%= (String)session.getAttribute("team_name") %>팀 공지, 활동 게시판 수정</h2></font>
<img src="images/team/clipboard.png" width="100" height="100">
<form name="f" method="post">
	<input type="hidden" name="command"/>
	
	<table>
		<tr>
		<td colspan="2" width="800" align="center" bgcolor="#a3caad">제목 : 
		<input type="text" name="title" size="100" value="${board.title }"> </td>
		</tr>		

		<tr>
		<td colspan="2" width="800" align="center" bgcolor="#a3caad">작성자: ${board.writer_id }
		</tr>		
				
		<tr>
		<th colspan="2" width="800" align="center" bgcolor="#a3caad">내용
		</tr>		

		<tr>
		<th colspan="2" height="400" align="center" bgcolor="#a3caad">
		<textarea name="b_content" style="width: 100%; height: 100%;">${board.b_content }</textarea>
		</th>
		</tr>

		

		<tr>
		<td colspan="1" align="left" bgcolor="skyblue"></td>
		<td colspan="1" align="right" bgcolor="skyblue"></td>
		</tr>

		<tr>
			<th colspan="2" align="right" width="100">
			<input type="button" value="목록" onclick="location.href='team_board_list.m2?command=team_board_list'">
			<input type="button" value="수정" onClick="modify()">
 			</th>	
		</tr>

	</table>
	</form>
</center>
</body>
</html>