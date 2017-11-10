<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<%
  String age = request.getParameter("age");
  String[] field =request.getParameterValues("field");
  session.setAttribute("age", age);
  session.setAttribute("field", field);
%>
<body>
<center>
<form name="f" method="post" target="3" action="../forward_empty.jsp">
<input type="hidden" name="command" value="searchPartner">
<input type="checkbox" name="region" value="p1">고창, 부안, 정읍
<input type="checkbox" name="region" value="p2">군산, 익산
<input type="checkbox" name="region" value="p3">남원, 순창, 임실
<input type="checkbox" name="region" value="p4">무주, 장수, 진안
<input type="checkbox" name="region" value="p5">전주, 완주, 김제 
<br>
<input type="submit" value="검색">
</form>
</center>
</body>
</html>