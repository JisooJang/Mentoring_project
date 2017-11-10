<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form name="f">
<center>
<h2><font color="#6d6d6d">${team_name}팀 주소록</font></h2> <img src="images/team/curriculum.png" width="100" height="100"><br><br>

<table>
   <tr>
      <td colspan="6" bgcolor="#a3caad"></td>

   </tr>

   <tr>

      <th align="center" width="150">프로필이미지</th>
      
      <th align="center" width="100">아이디</th>

      <th align="center" width="100">이름</th>

      <th align="center" width="100">나이</th>

      <th align="center" width="150">이메일</th>

      <th align="center" width="150">연락처</th>

   </tr>

   <tr>

      <td colspan="6" bgcolor="#a3caad"></td>

   </tr>

   <c:forEach var="member" items="${list}">
   
   <tr>

      <td align="center"><img src = "${member.img}" width=100 height=100/></td>
      <td align="center">${member.mbID}</td> 

      <td align="center">${member.mbName}</td>

      <td align="center">${member.age}</td>

      <td align="center">${member.email[0]}@${member.email[1]} </td>
      
      <td align="center">${member.phone[0]}-${member.phone[1]}-${member.phone[2]}</td>

   </tr>
   
   
   </c:forEach>
   
</table>
</center>
</form>
</body>
</html>