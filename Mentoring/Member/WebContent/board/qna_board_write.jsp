<%@ page language="java" contentType="text/html; charset=euc-kr"%>

<html>
<head>
	<title>공지사항 게시판</title>
	<script language="javascript">
	function addboard(){
		boardform.command.value="NotiBoardAddAction";
		boardform.submit();
	}
	</script>
	<link rel="stylesheet" href="./css/board2.css" type="text/css" />
</head>
<body>
<!-- 게시판 등록 -->
<form action="NotiBoardAddAction.m2" method="post" name="boardform">
<input type="hidden" name="command">
<div class="pagewidth">
	<div class="page-wrap">
		<div class="content">
<table cellpadding="0" cellspacing="0">
	<tr align="center" valign="middle">
		<td colspan="5"><h2>공지사항 </h2></td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12" height="16">
	
		</td>
	</tr>

	<tr>
		<td style="font-family:돋음; font-size:15" width="50" align="center">제 목</td>
		<td>
			<input name="BOARD_SUBJECT" type="text" size="58" maxlength="100" value="" placeholder="제목을 입력해주세요."/>
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:15" width="50" align="center">내 용</td>
		<td>
			<textarea name="BOARD_CONTENT" cols="60" rows="15" placeholder="공지사항을 입력해주세요."></textarea>
		</td>
	</tr>
	<tr bgcolor="cccccc">
		<td colspan="2" style="height:1px;">
		</td>
	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
	<tr align="center" valign="middle">
		<td colspan="5">
			<a href="javascript:addboard()" style="text-decoration:none">[등록]</a>&nbsp;&nbsp;
			<a href="javascript:history.go(-1)" style="text-decoration:none">[뒤로]</a>
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
</body>
</html>