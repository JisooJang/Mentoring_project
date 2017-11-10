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
<input type="checkbox" name="region" value="o1">곡성, 구례
<input type="checkbox" name="region" value="o2">나주, 함평, 무안
<input type="checkbox" name="region" value="o3">목포, 신안
<input type="checkbox" name="region" value="o4">보성, 고흥, 화순
<input type="checkbox" name="region" value="o5">여수, 순천, 광양
<input type="checkbox" name="region" value="o6">영광, 장성, 담양
<input type="checkbox" name="region" value="o7">영암, 강진, 장흥
<input type="checkbox" name="region" value="o8">해남, 진도, 완도 
<br>
<input type="submit" value="검색">
</form>
</center>
</body>
</html>