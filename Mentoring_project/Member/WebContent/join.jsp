<%@page contentType="text/html; charset=euc-kr" %>
<html>
<head>
<title>Join</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<script>
function memberCreate() {
	if ( f.mbId.value == "" ) {
		alert("����� ���̵� �Է��Ͻʽÿ�.");
		f.userId.focus();
		return false;
	} 
	if ( f.pwd.value == "" ) {
		alert("��й�ȣ�� �Է��Ͻʽÿ�.");
		f.password.focus();
		return false;
	}
	if ( f.name.value == "" ) {
		alert("�̸��� �Է��Ͻʽÿ�.");
		f.name.focus();
		return false;
	}
	var sum = 0;
	var count = f.region.length;
	for(var i=0 ; i<count ; i++) {
		if(f.region[i].checked == true) {
			sum += 1;
		}
	}
	
	if(sum > 5) {
		alert('������ �ִ� 5������ ���� �����մϴ�.');
		return;
	}
	
	
	
	var sum2 = 0;
	var count = f.field.length;
	for(var i=0 ; i<count ; i++) {
		if(f.field[i].checked == true) {
			sum2 += 1;
		}
	}
	
	if(sum2 > 3) {
		alert('�оߴ� �ִ� 3������ ���� �����մϴ�.');
		return;
	}
	
	f.command.value = "insert";
	f.action = "join1.m2";
	f.submit();
}

function goLogin(){
	f.command.value = "loginForm";
	f.action = "login.m2";
	f.submit();
}

function check(){
	location.href="confirm_id.jsp?id=" + f.mbId.value;
}
</script>
</head>
<%
   if(request.getParameter("cid")!=null){
   if(request.getParameter("cid").equals("0")){
	   out.println("<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0 onLoad=\"alert('�̹� �����ϴ� ���̵��Դϴ�.')\">");
   }else if(request.getParameter("cid").equals("1")){
	   out.println("<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0 onLoad=\"alert('��밡���� ���̵��Դϴ�.')\">");
   }
   }else{
	   out.println("<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>");
   }
%>
<br>
<!-- write Form  -->
<form name="f" method="POST" enctype="multipart/form-data">
<input type="hidden" name="command"/>
<table width=800 border=0 bgcolor="#F7F7F7" align="center">
  <tr>
    <td width="20"></td>
	<td>
      <!--contents-->
	  <table style="width: 100%">
		  <tr align="center">
			<td height="22"><br>&nbsp;&nbsp;<font color="#636363"><b>ȸ�� ����</b></font></td>
		  </tr>
		  <tr><td><br><img src="images/hr.PNG" width=800></td></tr>
	  </table>  
	  <br>
	  
	  <table>
	  	  <tr height="40">
	  	    <td width="20"></td>
			<td width="150" align="left"><font color="gray">���̵�</font></td>
			<td width="250" style="padding-left: 10">
				<input type="text" style="width: 100;" name="mbId">
				<input type="button" value="�ߺ�Ȯ��" onClick="check()"> 
			</td>
		  </tr>
	  	  <tr height="40">
	  	    <td width="20"></td>
			<td width="150" align="left"><font color="gray">��й�ȣ</font></td>
			<td width="250" style="padding-left: 10">
				<input type="password" style="width: 240" name="pwd">
			</td>
		  </tr>
	  	  <tr height="40">
	  	    <td width="20"></td>
			<td width="150" align="left"><font color="gray">�̸�</font></td>
			<td width="250" style="padding-left: 10">
				<input type="text" style="width: 140" name="name">
			</td>
		  </tr>
	  	  <tr height="40">
	  	    <td width="20"></td>
			<td width="150" align="left"><font color="gray">�̸��� �ּ�</font></td>
			<td width="250" style="padding-left: 10">
				<input type="text" style="width: 100" name="email"> @ 
				<input type="text" style="width: 100" name="email">
			</td>
		  </tr>	
		  <tr height="40">
		    <td width="20"></td>
			<td width="150" align="left"><font color="gray">����</font></td>
			<td width="250" style="padding-left: 10">
				<input type="text" size="3" maxLength="2" name="age">
			</td>
		  </tr>
		  <tr height="40">
		    <td width="20"></td>
			<td width="150" align="left"><font color="gray">����</font></td>
			<td width="250" style="padding-left: 10">
				<input type="text" style="width: 150" name="job">
			</td>
		  </tr>	
		  <tr height="40">
		    <td width="20"></td>
			<td width="150" align="left"><font color="gray">�ּ�</font></td>
			<td width="250" style="padding-left: 10">
				<input type="text" style="width: 240" name="address">
			</td>
		  </tr>	
		  <tr height="40">
		    <td width="20"></td>
			<td width="150" align="left"><font color="gray">�������</font></td>
			<td width="250" style="padding-left: 10">
				<input type="text" name="birth" size='4' maxlength='4'>��
				<input type="text" name="birth" size='2' maxlength='2'>��
				<input type="text" name="birth" size='2' maxlength='2'>�� 
			</td>
		  </tr>				  
		  <tr height="40">
		    <td width="20"></td>
			<td width="150" align="left"><font color="gray">�ڵ�����ȣ</font></td>
			<td width="250" style="padding-left: 10">
				<input type="text" style="width: 50" name="phone" size="4" maxlength="3"> - 
				<input type="text" style="width: 50" name="phone" size="4" maxlength="4"> - 
                <input type="text" style="width: 50" name="phone" size="4" maxlength="4">
			</td>
		  </tr>	
		  <tr height="40">
		    <td width="20"></td>
			<td width="150" align="left"><font color="gray">�о�</font></td>
			<td width="305" style="padding-left: 10">
			    <br>
				<input type="checkbox" name="field" value='01'>������
				<input type="checkbox" name="field" value='02'>IT/���α׷���
				<input type="checkbox" name="field" value='03'>�/������<br>
				<input type="checkbox" name="field" value='04'>�ƿ�����/����
				<input type="checkbox" name="field" value='05'>���/�ܱ���
				<input type="checkbox" name="field" value='06'>����
				<input type="checkbox" name="field" value='07'>��Ƽ
				<input type="checkbox" name="field" value='08'>�ǰ�/����
				<input type="checkbox" name="field" value='09'>����/å<br>
				<input type="checkbox" name="field" value='10'>����/�Ǳ�
				<input type="checkbox" name="field" value='11'>��
				<input type="checkbox" name="field" value='12'>����<br>
				<input type="checkbox" name="field" value='13'>����/����
				<input type="checkbox" name="field" value='14'>�丮
				<input type="checkbox" name="field" value='15'>����/�ֽ�
			</td>
		  </tr>
		  <tr height="40">
		    <td width="20"></td>
			<td width="150" valign="top"><br><font color="gray">����</font></td>
			<td width="250" style="padding-left: 10">
			<br>
				<font color="gray"><b>����</b></font><br>
<input type="checkbox" name="region" value="a1">������
<input type="checkbox" name="region" value="a2">������
<input type="checkbox" name="region" value="a3">���ϱ�
<input type="checkbox" name="region" value="a4">������


<br><br>

<font color="gray"><b>���</b></font><br>
<input type="checkbox" name="region" value="b1">����
<input type="checkbox" name="region" value="b2">����
<input type="checkbox" name="region" value="b3">�Ϻ�


<br><br>

<font color="gray"><b>��õ</b></font><br>
<input type="checkbox" name="region" value="c1">���, ����
<input type="checkbox" name="region" value="c2">����, ����
<input type="checkbox" name="region" value="c3">������<br>
<input type="checkbox" name="region" value="c4">����
<input type="checkbox" name="region" value="c5">������
<input type="checkbox" name="region" value="c6">�߱�, ��ȭ


<br><br>
<font color="gray"><b>����</b></font><br>
<input type="checkbox" name="region" value="d1">����, ����
<input type="checkbox" name="region" value="d2">����, ��ô
<input type="checkbox" name="region" value="d3">����, �¹�
<input type="checkbox" name="region" value="d4">����, ��â
<input type="checkbox" name="region" value="d5">��õ, ȫõ
<input type="checkbox" name="region" value="d6">ȭõ, �籸



<br><br>
<font color="gray"><b>����</b></font><br>
<input type="checkbox" name="region" value="e1">�����
<input type="checkbox" name="region" value="e2">����
<input type="checkbox" name="region" value="e3">����
<input type="checkbox" name="region" value="e4">������<br>
<input type="checkbox" name="region" value="e5">�߱�, ������


<br><br>
<font color="gray"><b>����</b></font><br>
<input type="checkbox" name="region" value="f1">����



<br><br>
<font color="gray"><b>�泲</b></font><br>
<input type="checkbox" name="region" value="g1">���, �ݻ�, ���
<input type="checkbox" name="region" value="g2">����
<input type="checkbox" name="region" value="g3">����, ��õ
<input type="checkbox" name="region" value="g4">�ο�, ����
<input type="checkbox" name="region" value="g5">����, �¾�
<br>
<input type="checkbox" name="region" value="g6">õ��, �ƻ�
<input type="checkbox" name="region" value="g7">ȫ��, ����, û��



<br><br>
<font color="gray"><b>���</b></font><br>
<input type="checkbox" name="region" value="h1">����, ����
<input type="checkbox" name="region" value="h2">�ܾ�, ��õ<br>
<input type="checkbox" name="region" value="h3">����, ����, ��õ
<input type="checkbox" name="region" value="h4">��õ, ����<br>
<input type="checkbox" name="region" value="h5">û��
<input type="checkbox" name="region" value="h6">����


<br><br>
<font color="gray"><b>�λ�</b></font><br>
<input type="checkbox" name="region" value="i1">������
<input type="checkbox" name="region" value="i2">�漺��, ����
<input type="checkbox" name="region" value="i3">����, ����
<input type="checkbox" name="region" value="i4">�λ��, ����
<input type="checkbox" name="region" value="i5">���, �ϱ�
<br>
<input type="checkbox" name="region" value="i6">����, ����
<input type="checkbox" name="region" value="i7">����, ����
<input type="checkbox" name="region" value="i8">����, ����
<input type="checkbox" name="region" value="i9">�ؿ��, ����


<br><br>
<font color="gray"><b>���</b></font><br>
<input type="checkbox" name="region" value="j1">����, ����
<input type="checkbox" name="region" value="j2">����
<input type="checkbox" name="region" value="j3">�ϱ�<br>
<input type="checkbox" name="region" value="j4">�߱�, ���ֱ�


<br><br>
<font color="gray"><b>�泲</b></font><br>
<input type="checkbox" name="region" value="k1">����, ����
<input type="checkbox" name="region" value="k2">�о�, ���
<input type="checkbox" name="region" value="k4">����, ��û<br>
<input type="checkbox" name="region" value="k3">�Ƿ�, â��, �Ծ�
<input type="checkbox" name="region" value="k5">â��, ����, ����
<br>
<input type="checkbox" name="region" value="k6">�뿵, ����
<input type="checkbox" name="region" value="k7">�ϵ�, ����<br>
<input type="checkbox" name="region" value="k8">��õ, ��â ��



<br><br>
<font color="gray"><b>���</b></font><br>
<input type="checkbox" name="region" value="l1">���, û��
<input type="checkbox" name="region" value="l2">����, ���׳���<br>
<input type="checkbox" name="region" value="l3">���, ����, ĥ��
<input type="checkbox" name="region" value="l4">��õ, ����<br>
<input type="checkbox" name="region" value="l5">����, ��õ, ����
<input type="checkbox" name="region" value="l6">����<br>
<input type="checkbox" name="region" value="l7">�ȵ�, �Ǽ�, û��
<input type="checkbox" name="region" value="l8">����, ���׺ϱ�<br>
<input type="checkbox" name="region" value="l9">����, ����, ��ȭ
<input type="checkbox" name="region" value="l10">��õ, ����



<br><br>
<font color="gray"><b>�뱸</b></font><br>
<input type="checkbox" name="region" value="m1">�޼���, ���� 
<input type="checkbox" name="region" value="m2">�޼���
<input type="checkbox" name="region" value="m3">����, �Ȱ�
<input type="checkbox" name="region" value="m4">�ϱ�, ĥ��
<input type="checkbox" name="region" value="m5">������
<input type="checkbox" name="region" value="m6">�߱�, ����
 

<br><br>
<font color="gray"><b>����</b></font><br>
<input type="checkbox" name="region" value="n1">���걸 
<input type="checkbox" name="region" value="n2">����, ����
<input type="checkbox" name="region" value="n3">�ϱ�
<input type="checkbox" name="region" value="n4">���� 


<br><br>
<font color="gray"><b>����</b></font><br>
<input type="checkbox" name="region" value="o1">�, ����
<input type="checkbox" name="region" value="o2">����, ����, ����<br>
<input type="checkbox" name="region" value="o3">����, �ž�
<input type="checkbox" name="region" value="o4">����, ����, ȭ��<br>
<input type="checkbox" name="region" value="o5">����, ��õ, ����
<input type="checkbox" name="region" value="o6">����, �强, ���<br>
<input type="checkbox" name="region" value="o7">����, ����, ����
<input type="checkbox" name="region" value="o8">�س�, ����, �ϵ� 


<br><br>
<font color="gray"><b>����</b></font><br>
<input type="checkbox" name="region" value="p1">��â, �ξ�, ����
<input type="checkbox" name="region" value="p2">����, �ͻ�<br>
<input type="checkbox" name="region" value="p3">����, ��â, �ӽ�
<input type="checkbox" name="region" value="p4">����, ���, ����<br>
<input type="checkbox" name="region" value="p5">����, ����, ���� 


<br><br>
<font color="gray"><b>����</b></font><br> 
<input type="checkbox" name="region" value="q1">�������� 
<input type="checkbox" name="region" value="q2">���ֽ�
				
			</td>
		  </tr>		
		  <tr height="40">
		    <td width="20"></td>
			<td width="150" align="left"><font color="gray">����</font></td>
			<td width="100" align="left">
				<font color="gray">��</font><input type="radio" style="width: 240" name="gender" value="m"><br>
				<font color="gray">��</font><input type="radio" style="width: 240" name="gender" value="f">
			</td>
		  </tr>	
		  <tr>
		  <td width="20"></td>
		  <td width="150" align="left"> 
		  <font color="gray">������ ����</font> </td>
		  <td><input id="profile_image" type="file" style="width: 240" name="birth" size='4' maxlength='4'>
		  </td></tr>
	  </table>
	  <br>
	  
	  <table style="width: 100%">
		  <tr>
			<td align="center">
			<input type="button" value="ȸ�� ����" onClick="memberCreate()"> &nbsp;
			<input type="button" value="�α���" onClick="goLogin()">
			</td>
		  </tr>
	  </table>
	</td>
  </tr>
</table>  
</form>
</body>
</html>