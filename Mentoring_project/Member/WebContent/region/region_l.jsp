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
<input type="checkbox" name="region" value="l1">경산, 청도
<input type="checkbox" name="region" value="l2">경주, 포항남구
<input type="checkbox" name="region" value="l3">고령, 성주, 칠곡
<input type="checkbox" name="region" value="l4">김천, 구미
<input type="checkbox" name="region" value="l5">문경, 예천, 영주
<input type="checkbox" name="region" value="l6">상주
<input type="checkbox" name="region" value="l7">안동, 의성, 청송
<input type="checkbox" name="region" value="l8">영덕, 포항북구
<input type="checkbox" name="region" value="l9">영양, 울진, 봉화
<input type="checkbox" name="region" value="l10">영천, 군위
<br>
<input type="submit" value="검색">
</form>
</center>
</body>
</html>