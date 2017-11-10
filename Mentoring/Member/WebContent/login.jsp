<%@page contentType="text/html; charset=euc-kr" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html> 
<head>
<title>Login</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">

<script>
function memberCreate() {
	f.command.value = "insertForm";
	f.action = "join.m2";
	f.target = "center";
	f.submit();
}

function login() {
	if ( f.mbId.value == "" ) {
		alert("���̵� �Է��Ͻʽÿ�.");
		f.mbId.focus();
		return false;
	} 
	if ( f.pwd.value == "" ) {
		alert("��й�ȣ�� �Է��Ͻʽÿ�.");
		f.pwd.focus();
		return false;
	}	
	
	f.command.value = "login";
	f.action = "login.m2";
	f.submit();
}
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0></body>
<br>
<!-- write Form  -->
<form name="f" method="POST">
  <input type="hidden" name="command"/>
  <table style="width:100%">
	<tr>
	  <td width="20"></td>
	  <td>
	  
	  <!--  exception ��ü�� ���޵� ��� �����޽����� ��� -->
	  <c:if test="${not empty exception}">
	  	<font color="red"><c:out value="${exception.getMessage()}" /></font>
	  </c:if>
	  <br>
	  <br><br>
	  <table>
	  	  <tr height="40">
	  	  <td valign="middle"><img src="images/id.PNG" width=50></td>
			<td width="250" style="padding-left:10">
				<input type="text" style="width:220 ; height:40" name="mbId">
			</td>
		  </tr>
	  	  <tr height="40">
	  	  <td valign="middle"><img src="images/pwd.PNG" width=50></td>
			<td width="250" style="padding-left:10">
				<input type="password" style="width:220 ; height:40" name="pwd">
			</td>
		  </tr>
	  </table>
	  <br>
	  
	  <table style="width:100%">
		  <tr>
			<td align=center>
			<input type="button" value="GO" onClick="login()" style="width:80 ; height:30"> &nbsp;
			<input type="button" value="JOIN" onClick="memberCreate()" style="width:80 ; height:30">
			</td>
		  </tr>
	  </table>

	  </td>
	</tr>
  </table>  
</form>
</body>
</html>