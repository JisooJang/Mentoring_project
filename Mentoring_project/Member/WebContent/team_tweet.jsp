<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="java.util.*" %>
    <%@ page import="model.TeamManager" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String message = request.getParameter("message");
	Object id = session.getAttribute("mbId");
	ArrayList<String> messages = (ArrayList<String>)application.getAttribute("messages");
	String team_id = (String)session.getAttribute("team_id");

	if(messages == null) {
		messages = new ArrayList<String>();												//�Ķ���� ����� �̸��� team�̸��� �ҷ��ͼ� team�̸��� �ٿ��� ����
	}	

	if(message != null) {
	messages.add(team_id + "-" + id + ":: " + message + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + new java.util.Date());
	}
	
	application.setAttribute("messages", messages);
	
	response.sendRedirect("team_twitter_list.jsp");
		
%>

</body>
</html>