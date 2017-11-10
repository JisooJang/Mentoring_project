<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="model.*, java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

</head>
<body>
<center><font color="gray" size=4><b>추천 멤버</b></font></center><br>
<table align="center" >
<tr>
<%
   List<Member> list = (List<Member>)request.getAttribute("randomList");
   if(list!=null){
		   for(int i=0; i<list.size(); i++){
			   out.println("<td><img src=\""+list.get(i).getImg()+"\"width=100 height=100/></td>");
			   out.println("<td>"+list.get(i).getMbID()+"<br>");
			   out.println(list.get(i).getMbName()+" </td><td>");
			   out.println("<td width=15></td>");
		   }
   }
%>
</tr>
</table>
</body>
</html>