<%@ page language="java" contentType="text/html; charset=euc-kr"%>
<%@ page import="model.*" %>
<%
	NBoardBean board = (NBoardBean)request.getAttribute("boarddata");
%>

<html>
<head>
	<title>공지사항 게시판</title>
</head>
<link rel="stylesheet" href="./css/board2.css" type="text/css" />
<body>
<div class="pagewidth">
	<div class="page-wrap">
		<div class="content">
<table cellpadding="3" cellspacing="3" padding-top="5">
	<tr align="center" valign="middle">
		<td colspan="5"><h2>공지사항</h2></td>
	</tr>
	
	<tr>
		<td  style="font-family:돋음; font-size:15" width="50" align="center" >제 목</td>
		<td style="font-family:돋음; font-size:15; font-weight:bold"><%=board.getNOTI_SUBJECT()%></td>
	</tr>
	
	<tr bgcolor="cccccc">
		<td colspan="2" style="height:3px;" >
		</td>
	</tr>
	
	<tr>
		<td width="50" style="font-family:돋음; font-size:15" align="center">내 용</td>
		<td style="font-family:돋음; font-size:12">
			<table border=0 width=490 height=250 style="table-layout:fixed" >
				<tr>
					<td valign=top style="font-family:돋음; font-size:14" bgcolor="#ffffff">
					<font color="#191919"><%=board.getNOTI_CONTENT() %></font>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	
	<tr bgcolor="cccccc">
		<td colspan="2" style="height:1px;"></td>
	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
	
	<tr align="center" valign="middle">
		<td colspan="5">
			<font size=2>
			<a href="NotiBoardModify.m2?command=NotiBoardModify&num=<%=board.getNOTI_NUM() %>" style="text-decoration:none">
			[수정]
			</a>&nbsp;&nbsp;
			<a href="NotiBoardDelete.m2?command=NotiBoardDeleteAction&num=<%=board.getNOTI_NUM() %>" style="text-decoration:none">
			[삭제]
			</a>&nbsp;&nbsp;
			<a href="NotiBoardList.m2?command=NotiBoardList" style="text-decoration:none">[목록]</a>&nbsp;&nbsp;
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
<!-- 게시판 수정 -->
</body>
</html>