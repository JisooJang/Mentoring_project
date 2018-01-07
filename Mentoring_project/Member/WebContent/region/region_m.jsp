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
<input type="checkbox" name="region" value="m1">달서구, 서구 
<input type="checkbox" name="region" value="m2">달성군
<input type="checkbox" name="region" value="m3">동구, 팔공
<input type="checkbox" name="region" value="m4">북구, 칠곡
<input type="checkbox" name="region" value="m5">수성구
<input type="checkbox" name="region" value="m6">중구, 남구
<br>
<input type="submit" value="검색">
</form>
</center>
</body>
</html>