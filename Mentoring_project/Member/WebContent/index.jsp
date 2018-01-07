<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title></title>
</head>
<body>
<div>
<%@include file="top.jsp" %>
</div>
<div>
			
		<!--<c:if test="${sessionScope.mbId != null}">-->
			<iframe style="width:75%; height: 1000px;" src="empty2.jsp" scrolling="yes" align="center" frameborder="0" name="center">
			</iframe>
		<!--</c:if>-->
		<%
		   if(session.getAttribute("mbId")==null){
			   out.println("<iframe style=\"width:20%; height: 800px;\" src=\"login.jsp\" scrolling=\"no\" align=\"right\" frameborder=\"0\" name=\"right\"></iframe>");
		   }else{
			   out.println("<iframe style=\"width:20%; height: 800px;\" src=\"login_mypage.m2\" scrolling=\"no\" align=\"right\" frameborder=\"0\" name=\"right\"></iframe>");
		   }
		%>
</div>
<!--
<div>	
		<iframe style="width:20%; height: 300px;" src="" scrolling="no" align="left" frameborder="0"></iframe>
		<iframe style="width:55%; height: 300px;" src="board_list.m2?command=bestBoardByreadcount" scrolling="no" align="center" frameborder="0"></iframe>
		<iframe style="width:20%; height: 300px;" src="" scrolling="no" align="right" frameborder="0"></iframe>
</div>

<div style="position: absolute; bottom: 0px; width: 100%; background-color: #1a1a1a; color: white; height: 50px;" frameborder="0"></div>
-->
</body>
</html>