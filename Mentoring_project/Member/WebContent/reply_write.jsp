<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>reply_write.jsp</title>

<link rel=stylesheet href="${pageContext.request.contextPath}/css/boardinfo.css" type="text/css">


</head>
<script>
function replyCreate() {
	//�ڼ��� �䱸������ ���߿�
	f.command.value="replyCreate";
	f.action="reply_write.m2";

	f.submit();
}


</script>


<body>
<center>
<div align="center" class="flexbox" style="margin-top: 30px;">
			<div class="outer-container">
				<span class="header-title">����ۼ�</span><br />
				<span class="header-subtitle">add reply</span><br /><hr />
			</div>
		</div> 

<form name="f"	 method="post">
<input type="hidden" name="command"/>
<table>
<tr>
	<td>��� ����&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td><input type="text" name="replycontent" size="100"></td>
</tr>

</table>
<input type="hidden" name="board_code" value=${board.board_code}>
<input type="button" value="����" onClick="replyCreate()">
</form>

</center>
</body>
</html>