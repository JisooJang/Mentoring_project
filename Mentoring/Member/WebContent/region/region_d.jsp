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
<input type="checkbox" name="region" value="d1">강릉, 속초
<input type="checkbox" name="region" value="d2">동해, 삼척
<input type="checkbox" name="region" value="d4">영월, 태백
<input type="checkbox" name="region" value="d5">원주, 평창
<input type="checkbox" name="region" value="d6">춘천, 홍천
<input type="checkbox" name="region" value="d7">화천, 양구
<br>
<input type="submit" value="검색">
</form>
</center>
</body>
</html>