<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
session = request.getSession();
List<Board> boardList = (List<Board>)request.getAttribute("boardList"); %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<link rel=stylesheet href="${pageContext.request.contextPath}/css/boardinfo.css" type="text/css">

<body>
<div align="center" class="flexbox" style="margin-top: 30px;">
			<div class="outer-container">
				<span class="header-title">�α�Խ���</span><br />
				<span class="header-subtitle">freeboard</span><br /><hr />
			</div>
		</div> 





<div class='table-container'>
<table table border='0' cellspacing=0 align=center>
<%
	Iterator<Board> boardIter = boardList.iterator();
	
	if(!boardIter.hasNext()) {
		out.println("�Խñ��� �����ϴ�.");
	}
	else {
		%>
		<tr>
			<th style='min-width: 500px'>����</th>
			<th>��¥</th>
			<th>�۾���</th>
			<th>����Ƚ��</th>
			<th>��õ��</th>
		</tr>
		<%
		while(boardIter.hasNext()) {
			Board board = (Board)boardIter.next();
		%>
			<tr bordercolor=#9FC93C  align = center>
			<td><a href="board_all.m2?board_code=<%=board.getBoard_code() %>&command=retrieveBoard"><%=board.getSubject() %></a><span class="reply"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(<%=board.getReplycount() %>)</span></td>
			<td><%=board.getRegdate() %></td>
			
			<td><a href="message_write.jsp?rec_message_id=<%=board.getWriter()%>" target="_blank" width=400 height=430><%=board.getWriter() %></a></td>
			<td><%=board.getReadcount() %></td>
			<td><%=board.getReccount() %></td>
			<td>
				<%
				if(board.getWriter().equals((String)session.getAttribute("mbId"))) {
					%>
					<a href="board_list.m2?board_code=<%=board.getBoard_code()%>&command=boardRemove">����</a>
					<%
				}
				%>
			</td>
			<td>
				<%
				if(board.getWriter().equals((String)session.getAttribute("mbId"))) {
					%>
					<a href="board_write.jsp?board_code=<%=board.getBoard_code()%>&pw=<%=board.getPw()%>&content=<%=board.getContent()%>&subject=<%=board.getSubject()%>&
					readcount=<%=board.getReadcount()%>&reccount=<%=board.getReccount()%>&replycount=<%=board.getReplycount()%>&regdate=<%=board.getRegdate()%>">����</a>
					<%
				}
				%>
			</td>
			</tr>
		<%
		}
	}

	%>
</table>
	<a href="board_list.m2?command=bestBoardByreadcount">'��ȸ��' ���� �Խù� ����</a>
</div>
</head>
<body>

</body>
</html>