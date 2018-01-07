<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*, java.util.*"%>
<%@ include file="loginCheck.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="../css/user.css" type="text/css">
<title>My Page</title>
<link href="css/mypage.css" rel="stylesheet" type="text/css">

<style type="text/css">
a:link    {color:black; background-color:transparent; text-decoration:none}
a:visited {color:black; background-color:transparent; text-decoration:none}
a:hover   {color:black; background-color:transparent; text-decoration:none}
tr {
	align:center;
	
}

td {
	text-align:center;
	padding:10px;
}
table {
	boarder:1px solid black;
	align:center;
}
</style>

</head>
<body>
<br/>


<!--  <a href="SearchPartner.m2?command=searchPartner">멘토 찾기</a><br> -->


<%
   Member mb = (Member)request.getAttribute("mb"); 
%>
 <table >
 <tr>
 
 	<td colspan='3'><b><%=mb.getMbName()%></b>님, 반갑습니다.</td>
 	<td><a href="logout.m2?command=logout" target="_parent">로그아웃</a></td>
 <br>
 </tr>
 <tr>
 	<td><br><img src="images/magnifying-glass.png" heigth="50px" width="50px">
 	<br>
 	<a href="mypage.m2?command=view_info" target="center">내정보</a></td>
 	<td><br><img src="images/speech-bubble.png" heigth="50px" width="50px">
 	<br>
 	<a href="messageList.m2?command=retrieveMessageList" target="center">쪽지</a></td>
 	<td><br><img src="images/learning.png" heigth="50px" width="50px">
 	<br>
 	<a href="team_requesting.m2?command=retrieveApplyListByMemeber_id" target="center">멘티팀</a></td>
 	<td><br><img src="images/classroom.png" heigth="50px" width="50px">
 	<br>
 	<a href="team_list.m2?command=retrieveTeamList" target="center">멘토팀</a></td>
 </tr>
 </table>

<!-- 
<a href="board_list.m2?command=retrieveBoardList">게시글보기</a>
-->


</body>
</html>