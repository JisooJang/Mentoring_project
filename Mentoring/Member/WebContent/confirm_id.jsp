<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
   String id=(request.getParameter("id"));
   MemberManager m = MemberManager.getInstance();
   if(m.existedMember(id) == true){
	   pageContext.forward("join.jsp?cid=0"); //아이디 존재.
   }else{
	   pageContext.forward("join.jsp?cid=1"); //사용가능 아이디.
   }
%>
</body>
</html>