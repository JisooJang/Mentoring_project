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
<input type="checkbox" name="region" value="g1">논산, 금산, 계룡
<input type="checkbox" name="region" value="g2">당진
<input type="checkbox" name="region" value="g3">보령, 서천
<input type="checkbox" name="region" value="g4">부여, 공주
<input type="checkbox" name="region" value="g5">서산, 태안
<input type="checkbox" name="region" value="g6">천안, 아산
<input type="checkbox" name="region" value="g7">홍성, 예산, 청양
<br>
<input type="submit" value="검색">
</form>
</center>
</body>
</html>