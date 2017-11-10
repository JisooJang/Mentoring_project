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
	
	//d_member 테이블의 멤버 아이디 = team table의 멘토아이디 join해서,
	//해당 멘토의 멘토링 팀 참여 정보 공개
%>

<input type="button" value="멘토링 신청" onClick="">
</body>
</html>