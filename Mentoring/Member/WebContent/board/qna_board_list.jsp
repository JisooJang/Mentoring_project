<%@ page language="java" contentType="text/html; charset=euc-kr"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="model.*"%>

<%

	List boardList=(List)request.getAttribute("boardlist");
	int listcount=((Integer)request.getAttribute("listcount")).intValue();
	int nowpage=((Integer)request.getAttribute("page")).intValue();
	int maxpage=((Integer)request.getAttribute("maxpage")).intValue();
	int startpage=((Integer)request.getAttribute("startpage")).intValue();
	int endpage=((Integer)request.getAttribute("endpage")).intValue();
	
%>

<html>
<head>
<title>공지사항 게시판</title>
<link rel="stylesheet" href="./css/board.css" type="text/css" />
</head>

<body>
	<!-- 게시판 리스트 -->
<div class="pagewidth">
	<div class="page-wrap">
		<div class="content">
	<table width=100% border="0" cellpadding="0" cellspacing="0">
		<%
if(listcount > 0){
%>
		<tr align="center" valign="middle">
			<td colspan="4"><h2>공지사항</h2></td>
			
		</tr>

		<tr >
				<th>번호</th><th>제목</th><th>날짜</th><th>조회수</th>

		</tr>

		<%
		for(int i=0;i<boardList.size();i++){
			NBoardBean bl=(NBoardBean)boardList.get(i);
	%>
		<tr align="center" valign="middle" bordercolor="#333333"
			onmouseover="this.style.backgroundColor='F8F8F8'"
			onmouseout="this.style.backgroundColor=''">
			<td height="23" style="font-family: Tahoma; font-size: 10pt;"><%=i+1%>
			</td>

			<td style="font-family: Tahoma; font-size: 10pt;">
				<div align="left">
					<a href="NotiBoardDetailAction.m2?num=<%=bl.getNOTI_NUM()%>&command=NotiBoardDetailAction" style="text-decoration:none">
						<%=bl.getNOTI_SUBJECT()%>
					</a>
				</div>
			</td>

			<td style="font-family: Tahoma; font-size: 10pt;">
				<div align="center"><%=bl.getNOTI_DATE() %></div>
			</td>
			<td style="font-family: Tahoma; font-size: 10pt;">
				<div align="center"><%=bl.getNOTI_READCOUNT() %></div>
			</td>
		</tr>
		<%} %>
		<tr align=center height=20>
			<td colspan=7 style="font-family: Tahoma; font-size: 10pt;">
				<%if(nowpage<=1){ %> [이전]&nbsp; <%}else{ %> <a
				href="NotiBoardList.m2?command=NotiBoardList&page=<%=nowpage-1 %>">[이전]</a>&nbsp; <%} %> <%for(int a=startpage;a<=endpage;a++){
				if(a==nowpage){%>&nbsp; <%=a %> &nbsp;<%}else{ %> <a
				href="NotiBoardList.m2?command=NotiBoardList&page=<%=a %>">&nbsp;<%=a %>&nbsp;
			</a>&nbsp; <%} %> <%} %> <%if(nowpage>=maxpage){ %> [다음] <%}else{ %> <a
				href="NotiBoardList.m2?command=NotiBoardList&page=<%=nowpage+1 %>">[다음]</a> <%} %>
			</td>
		</tr>
		<%
    }
	else
	{
	%>
		<tr align="center" valign="middle">
			<td colspan="4">공지사항 게시판</td>
			<td align=right><font size=2>등록된 글이 없습니다.</font></td>
		</tr>
		<%
	}
	%>
		<tr align="right">
			<td colspan="5"><a href="NotiBoardWrite.m2?command=NotiBoardWrite" style="text-decoration:none">[글쓰기]</a></td>
		</tr>
	</table>
	
	</div>
	
	<div class="clear"></div>
	</div>
	
	</div>
	<div style="font-size: 0.8em; text-align: center;">
<br />
Design downloaded from Zeroweb.org: Free website templates, layouts, and tools.<br />
<br />
</div>

</body>
</html>