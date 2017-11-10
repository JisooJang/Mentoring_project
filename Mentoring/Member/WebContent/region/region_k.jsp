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
<input type="checkbox" name="region" value="k1">김해, 장유
<input type="checkbox" name="region" value="k2">밀양, 양산
<input type="checkbox" name="region" value="k3">의령, 창녕, 함안
<input type="checkbox" name="region" value="k4">진주, 사청
<input type="checkbox" name="region" value="k5">창원, 마산, 진해
<input type="checkbox" name="region" value="k6">통영, 거제
<input type="checkbox" name="region" value="k7">하동, 남해
<input type="checkbox" name="region" value="k8">합천, 거창 외
<br>
<input type="submit" value="검색">
</form>
</center>
</body>
</html>