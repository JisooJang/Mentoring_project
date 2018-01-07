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
<input type="checkbox" name="region" value="i1">강서구
<input type="checkbox" name="region" value="i2">경성대, 광안
<input type="checkbox" name="region" value="i3">남포, 영도
<input type="checkbox" name="region" value="i4">부산대, 동래
<input type="checkbox" name="region" value="i5">사상, 북구
<input type="checkbox" name="region" value="i6">서구, 사하
<input type="checkbox" name="region" value="i7">서면, 동구
<input type="checkbox" name="region" value="i8">연산, 거제
<input type="checkbox" name="region" value="i9">해운대, 기장
<br>
<input type="submit" value="검색">
</form>
</center>
</body>
</html>