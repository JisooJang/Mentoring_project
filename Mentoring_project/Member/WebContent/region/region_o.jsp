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
<input type="checkbox" name="region" value="o1">�, ����
<input type="checkbox" name="region" value="o2">����, ����, ����
<input type="checkbox" name="region" value="o3">����, �ž�
<input type="checkbox" name="region" value="o4">����, ����, ȭ��
<input type="checkbox" name="region" value="o5">����, ��õ, ����
<input type="checkbox" name="region" value="o6">����, �强, ���
<input type="checkbox" name="region" value="o7">����, ����, ����
<input type="checkbox" name="region" value="o8">�س�, ����, �ϵ� 
<br>
<input type="submit" value="�˻�">
</form>
</center>
</body>
</html>