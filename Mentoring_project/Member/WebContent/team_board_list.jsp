<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<link rel="stylesheet" type="text/css" href="teamproject.css">

<style type="text/css">
a { text-decoration:none }
body { font-family:'맑은 고딕'; }

</style>

<title>Insert title here</title>
</head>

<body
<%

 if(request.getAttribute("board_remove_fail") != null) {
    out.println("onLoad=\"alert('작성자만 삭제 가능합니다.')\">");
 }
 else {
%>
>
<% } %> 

<%
   int num = Integer.parseInt(request.getAttribute("num").toString());
%>
<center>
<font color="#6d6d6d"> <h2> <%= (String)session.getAttribute("team_name") %>팀 공지, 활동 게시판</h2></font>
<img src="images/team/clipboard.png" width="100" height="100">
<br><br>
   <table>

   <tr>

      <td colspan="5" bgcolor="#a3caad"></td>

   </tr>

   <tr>

      <th align="center" width="100">번호</th>

      <th align="center" width="300">제목</th>

      <th align="center" width="200">작성자</th>

      <th align="center" width="150">등록일자</th>

   </tr>

   <tr>

      <td colspan="5" bgcolor="#a3caad"></td>

   </tr>

   <c:forEach var="board" items="${list}">

   

   <tr>

      <td align="center"><%=num %></td>

      <td align="center">
      <a href = "team_board_view.m2?command=team_board_view&board_num=${board.board_num}">
      <font color="#787a7a">${board.title}</font></a></td>

      <td align="center">${board.writer_id}</td>

      <td align="center">${board.b_date}</td>


   </tr>
   <% num++; %>
   </c:forEach>



   <tr>

      <td colspan="5" bgcolor="#a3caad"></td>

   </tr>

   

   <tr>

      <td align="right" colspan="5">
      
      <form name="f" action="team_board_write.jsp">
      <input type="submit" value="글쓰기">

      </form>

      </td>

   </tr>   

   </table>   

</center>

   
</body>

</body>
</html>