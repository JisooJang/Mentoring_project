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
<input type="checkbox" name="region" value="c1">계양, 서구
<input type="checkbox" name="region" value="c2">남구, 동구
<input type="checkbox" name="region" value="c3">남동구
<input type="checkbox" name="region" value="c4">부평
<input type="checkbox" name="region" value="c5">연수구
<input type="checkbox" name="region" value="c6">중구, 강화
<br>
<input type="submit" value="검색">
</form>
</center>
</body>
</html>