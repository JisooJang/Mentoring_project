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
<input type="checkbox" name="region" value="l1">���, û��
<input type="checkbox" name="region" value="l2">����, ���׳���
<input type="checkbox" name="region" value="l3">���, ����, ĥ��
<input type="checkbox" name="region" value="l4">��õ, ����
<input type="checkbox" name="region" value="l5">����, ��õ, ����
<input type="checkbox" name="region" value="l6">����
<input type="checkbox" name="region" value="l7">�ȵ�, �Ǽ�, û��
<input type="checkbox" name="region" value="l8">����, ���׺ϱ�
<input type="checkbox" name="region" value="l9">����, ����, ��ȭ
<input type="checkbox" name="region" value="l10">��õ, ����
<br>
<input type="submit" value="�˻�">
</form>
</center>
</body>
</html>