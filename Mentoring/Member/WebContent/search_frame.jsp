<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="model.Member" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<frameset rows="25%,15%,15%,*" border=0 frameborder=0>
<frame src="random_partner.m2?command=random" name="a" noresize/>
<frame src="search_partner.jsp" name="1" noresize/>
<frame src="empty.jsp" name="2" noresize/>
<%
if(request.getAttribute("searchList")==null){
	  out.println("<frame src=\"empty.jsp\" name=\"3\" noresize/>");
}else{
	  session.setAttribute("searchList", (List<Member>)request.getAttribute("searchList"));
	  out.println("<frame src=\"SearchList.jsp\" name=\"3\" noresize/>");
}
%>
</frameset>
</html>