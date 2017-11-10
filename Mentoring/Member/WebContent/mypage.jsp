<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Member" %>
<%@ page import="model.Team" %>
<%@ page import="java.util.*" %>
<%@ include file="loginCheck.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Page</title>
<script>
function goUpdate(){
	f.submit();
}
</script>
</head>
<body>
<br/><br/>
<%
Member mb = (Member)request.getAttribute("mb");

String email="";
if(mb.getEmail()!=null){
	   for(int i=0;i<mb.getEmail().length;i++){
		   if(i==mb.getEmail().length-1){
			   email+=mb.getEmail()[i];
		   }else{
			   email+=mb.getEmail()[i]+"@";
		   }
	   }
}
String phone="";
if(mb.getPhone()!=null){
	   for(int i=0;i<mb.getPhone().length;i++){
		   if(i==mb.getPhone().length-1){
			   phone+=mb.getPhone()[i];
		   }else{
			   phone+=mb.getPhone()[i]+"-";
		   }
	   }
}
%>
<form name="f" method="post" action="update.m2?command=updateForm" target="">
<table width = 600 height = 500 border=0 align="center">
<tr>
<td align="center">
<img src = "<%= mb.getImg() %>" width=100 height=100/><br/>
</td>
<td width=30>
</td>
<td>
<table>
<tr>
<td align="right"><img src="images/a.JPG"><br><br></td>
<td align="left"><font color="gray" size=4>이름: <%=mb.getMbName()%></font><br><br></td>
</tr>
<tr>
<td align="right"><img src="images/a.JPG"><br><br></td>
<td align="left"><font color="gray" size=4>성별: <%=mb.getGender().toUpperCase()%></font><br><br></td>
</tr>
<tr>
<td align="right"><img src="images/a.JPG"><br><br></td>
<td align="left"><font color="gray" size=4>나이: <%=mb.getAge()%></font><br><br></td>
</tr>
<tr>
<td align="right"><img src="images/a.JPG"><br><br></td>
<td align="left"><font color="gray" size=4>직업: <%=mb.getJob()%></font><br><br></td>
</tr>
<tr>
<td align="right"><img src="images/a.JPG"><br><br></td>
<td align="left"><font color="gray" size=4>핸드폰: <%=phone%></font><br><br></td>
</tr>
<tr>
<td align="right"><img src="images/a.JPG"><br><br></td>
<td align="left"><font color="gray" size=4>이메일: <%=email%></font></td>
</tr>
</table>
</td>
</tr>
</table><br>
<center><input type="button" value="수정" style="width:80 ; height:30" onClick="goUpdate()"></center>
</form>
</body>
</html>