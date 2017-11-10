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
				<span class="header-title">인기게시판</span><br />
				<span class="header-subtitle">freeboard</span><br /><hr />
			</div>
		</div> 





<div class='table-container'>
<table table border='0' cellspacing=0 align=center>
<%
	Iterator<Board> boardIter = boardList.iterator();
	
	if(!boardIter.hasNext()) {
		out.println("게시글이 없습니다.");
	}
	else {
		%>
		<tr>
			<th style='min-width: 500px'>제목</th>
			<th>날짜</th>
			<th>글쓴이</th>
			<th>열람횟수</th>
			<th>추천수</th>
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
					<a href="board_list.m2?board_code=<%=board.getBoard_code()%>&command=boardRemove">삭제</a>
					<%
				}
				%>
			</td>
			<td>
				<%
				if(board.getWriter().equals((String)session.getAttribute("mbId"))) {
					%>
					<a href="board_write.jsp?board_code=<%=board.getBoard_code()%>&pw=<%=board.getPw()%>&content=<%=board.getContent()%>&subject=<%=board.getSubject()%>&
					readcount=<%=board.getReadcount()%>&reccount=<%=board.getReccount()%>&replycount=<%=board.getReplycount()%>&regdate=<%=board.getRegdate()%>">수정</a>
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
	<a href="board_list.m2?command=bestBoardByreadcount">'조회수' 많은 게시물 보기</a>
</div>
</head>
<body>

</body>
</html>