<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>board_write.jsp</title>

<link rel=stylesheet href="${pageContext.request.contextPath}/css/boardinfo.css" type="text/css">
</head>

<script>
function boardCreate() {
	//자세한 요구사항은 나중에~
	f.command.value="boardCreate";
	f.action="board_write.m2";
	f.submit();
}

function boardModify() {
	mf.command.value="boardModify"
	mf.action="board_list.m2"
	mf.submit();
}
</script>

<body>

<%
	String board_code = request.getParameter("board_code");
	String pw = request.getParameter("pw");
	String content = request.getParameter("content");
	String subject = request.getParameter("subject");
	String readcount = request.getParameter("readcount");
	String reccount = request.getParameter("reccount"); 
	String replycount = request.getParameter("replycount");
	String regdate = request.getParameter("regdate");
	
	
	if(board_code != null) {
		%>
		<form name="mf" method="post">
		<input type="hidden" name="command"/>
		<input type="hidden" name="board_code" value="<%=board_code%>">
		<input type="hidden" name="readcount" value="<%=readcount%>">
		<input type="hidden" name="regdate" value="<%=regdate%>">
		<input type="hidden" name="replycount" value="<%=replycount%>">
		<input type="hidden" name="reccount" value="<%=reccount%>">
		수정하시오
		<table>
		<tr>
			<td>게시글 비밀번호</td>
			<td><input type="password" name="pw" value="<%=pw%>" size=""></td>
		</tr>
		<tr>
			<td>게시글 제목</td>
			<td><input type="text" name="subject" value="<%=subject%>" size="50"></td>
		</tr>
		<tr>
			<td>게시글 내용</td>
			<td><textarea  cols="60" rows="30" name="content" value="<%=content%>"></textarea></td>
		</tr>
		
		</table>
		
		<input type="button" value="수정" onClick="boardModify()">
		
		</form>
	<%
	}
	
	else {
%>


<center>
<div align="center" class="flexbox" style="margin-top: 30px;">
			<div class="outer-container">
				<span class="header-title">후기글작성</span><br />
				<span class="header-subtitle">add freeboard</span><br /><hr />
			</div>
		</div> 

<form name="f" method="post">
<input type="hidden" name="command"/>
<table>
<tr>
	<td>게시글 비밀번호</td>
	<td><input type="password" name="pw" size="15"></td>
</tr>
<tr>
	<td>게시글 제목</td>
	<td><input type="text" name="subject" size="50"></td>
</tr>
<tr>
	<td>게시글 내용</td>
	<td><textarea name="content" cols="60" rows="30"></textarea></td>
</tr>

</table>


<input type="button" value="저장" onClick="boardCreate()">

</form>
<%} %>
</center>
</body>
</html>