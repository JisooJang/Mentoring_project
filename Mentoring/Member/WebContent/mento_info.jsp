<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String id = request.getParameter("mbID");
	out.println(id);
	
	//d_member ���̺��� ��� ���̵� = team table�� ������̵� join�ؼ�,
	//�ش� ������ ���丵 �� ���� ���� ����
%>

<input type="button" value="���丵 ��û" onClick="">
</body>
</html>