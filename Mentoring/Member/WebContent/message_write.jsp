<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%String rec_message_id = request.getParameter("rec_message_id");%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>

<script>
function messageCreate() {
	f.command.value="messageCreate";
	f.action="message_create.m2";
	f.submit();
}
</script>
<body>


<form name="f" method="post" action="messageCreate.m2">
<input type="hidden" name="command" value="messageCreate">
<div>제목<input type="text" name="message_subject" size="20"/></div>
<div>내용<br>
<textarea name="message_content" rows="20" cols="50"></textarea></div>
<input type="hidden" name="rec_message_id" value=<%=rec_message_id%>>
<input type="submit" value="쪽지보내기" >
</form>

</body>
</html>