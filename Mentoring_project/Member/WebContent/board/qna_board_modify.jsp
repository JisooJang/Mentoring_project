<%@ page language="java" contentType="text/html; charset=euc-kr"%>
<%@ page import="model.*" %>
<%
	NBoardBean board = (NBoardBean)request.getAttribute("boarddata");
%>

<html>
<head>
	<title>�������� �Խ���</title>
	<script type="text/javascript">
	function modifyboard(){
		modifyform.command.value="NotiBoardModifyAction";
		modifyform.submit();
	}
	</script>
	<link rel="stylesheet" href="./css/board2.css" type="text/css" />
</head>

<body>
<!-- �Խ��� ���� -->
<form action="NotiBoardModifyAction.m2" method="post" name="modifyform">
<input type="hidden" name="command">
<input type="hidden" name="NOTI_NUM" value=<%=board.getNOTI_NUM() %>>
<div class="pagewidth">
	<div class="page-wrap">
		<div class="content">
<table cellpadding="0" cellspacing="0">

	<tr align="center" valign="middle">
		<td colspan="5"><h2>��������</h2> </td>
	</tr>
	<tr>
		<td height="16" style="font-family:����;  font-size:15" width="50" align="center" >�� ��</td>
		<td>
			<input name="NOTI_SUBJECT" size="58" maxlength="100" 
				value="<%=board.getNOTI_SUBJECT()%>">
		</td>
	</tr>
	<tr>
	<td style="font-family:����; font-size:15" width="50" align="center">�� ��</td>
		<td>
			<textarea name="NOTI_CONTENT" cols="60" rows="15"><%=board.getNOTI_CONTENT() %></textarea>
		</td>
	</tr>
	
	<tr bgcolor="cccccc">
		<td colspan="2" style="height:1px;">
		</td>
	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
	
	<tr align="center" valign="middle">
		<td colspan="5">
			<font size=2>
			<a href="javascript:modifyboard()" style="text-decoration:none">[����]</a>&nbsp;&nbsp;
			<a href="javascript:history.go(-1)" style="text-decoration:none">[�ڷ�]</a>&nbsp;&nbsp;
			</font>
		</td>
	</tr>
</table>
</div>
	<div class="sidebar"></div>
	
	<div class="clear"></div>
	</div>
	
	</div>
	<div style="font-size: 0.8em; text-align: center;">
<br />
Design downloaded from Zeroweb.org: Free website templates, layouts, and tools.<br />
<br />
</div>
</form>
<!-- �Խ��� ���� -->
</body>
</html>