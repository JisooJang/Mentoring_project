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
<input type="checkbox" name="region" value="k1">����, ����
<input type="checkbox" name="region" value="k2">�о�, ���
<input type="checkbox" name="region" value="k3">�Ƿ�, â��, �Ծ�
<input type="checkbox" name="region" value="k4">����, ��û
<input type="checkbox" name="region" value="k5">â��, ����, ����
<input type="checkbox" name="region" value="k6">�뿵, ����
<input type="checkbox" name="region" value="k7">�ϵ�, ����
<input type="checkbox" name="region" value="k8">��õ, ��â ��
<br>
<input type="submit" value="�˻�">
</form>
</center>
</body>
</html>