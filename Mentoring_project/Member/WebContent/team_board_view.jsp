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
	var result = confirm("정말 삭제하시겠습니까?");
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
	 out.println("onLoad=\"alert('작성자만 수정 가능합니다.')\">");
 }
 else {
%>
>
<% } %>
<center>

<font color="#6d6d6d"> <h2> <%= (String)session.getAttribute("team_name") %>팀 공지, 활동 게시판</h2></font>
<img src="images/team/clipboard.png" width="100" height="100">
	<table>

		<tr>
		<td width="100" align="center" bgcolor="#a3caad"><b>제목</b></td>
		<td>${board.title} </td>
		</tr>		

		<tr>
		<td width="100" align="center" bgcolor="#a3caad"><b>작성자</b> </td>
		<td>${board.writer_id} </td>
		</tr>
		
		<tr>
		<td width="100" align="center" bgcolor="#a3caad"><b>작성일</b></td>
		<td>${board.b_date}</td>
		</tr>		
				
		<tr>
		<th colspan="2" width="800" align="center" bgcolor="#a3caad"><b>내용</b></th>
		</tr>		

		<tr>
		<th colspan="2" height="400" align="center">
		${board.b_content}	
		</th>
		</tr>

		

		

		<tr>

			<th colspan="2" align="center" width="100">

			<input type="button" value="목록"

 			onclick="location.href='team_board_list.m2?command=team_board_list'">

 			<input type="button" value="삭제"

 			onclick="delete_post()">

 			<input type="button" value="수정"

 			onclick="location.href='team_board_modify.m2?command=team_board_update&writer_id=${board.writer_id }&board_num=${board.board_num}'">
 			</th>	
		</tr>

	</table>
</center>
</body>
</html>