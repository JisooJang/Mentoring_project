<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="model.*, java.util.*"%>
<%@ include file="loginCheck.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel=stylesheet href="../css/user.css" type="text/css">
<title>ȸ�� ���� ����</title>
<%
   Member mb=new Member();
   if(session.getAttribute("member")!=null){
	   mb = (Member)session.getAttribute("member");
   }
%>
<script>
function memberUpdate() {
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
	if(f.pwd.value != f.pwd2.value) {
		alert("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		f.pwd.focus();
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
	
	f.command.value = "update";
	f.action = "update1.m2";
	f.submit();
}
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<form name="f" method="POST" enctype="multipart/form-data">
<input type="hidden" name="command"/>
<table width=900 border=0 bgcolor="#F7F7F7" align="center">
  <tr>
    <td width="20"></td>
	<td>
      <!--contents-->
	  <table style="width: 100%">
		  <tr align="center">
			<td height="22"><br>&nbsp;&nbsp;<font color="#636363"><b>ȸ�� ���� ����</b></font></td>
		  <tr><td><br><img src="images/hr.PNG" width=900></td></tr>
		  </tr>
	  </table>  
	  <br>
	  
	  <table>
	  	  <tr height="40">
			<td width="300" align="left"><font color="gray">���̵�</font></td>
			<td width="600" style="padding-left: 10">
				<%= mb.getMbID() %>
			</td>
		  </tr>
	  	  <tr height="40">
			<td width="300" align="left"><font color="gray">��й�ȣ</font></td>
			<td width="600" style="padding-left: 10">
				<input type="password" style="width: 240" name="pwd">
			</td>
		  </tr>
	  	  <tr height="40">
			<td width="300" align="left"><font color="gray">�̸�</font></td>
			<td width="600" style="padding-left: 10">
				<input type="text" style="width: 240" name="name" value="<%= mb.getMbName() %>">
			</td>
		  </tr>
	  	  <tr height="40">
			<td width="300" align="left"><font color="gray">�̸��� �ּ�</font></td>
			<td width="600">
				<input type="text" style="width: 100" name="email" value="<%= mb.getEmail()[0] %>"> @ 
				<input type="text" style="width: 100" name="email" value="<%= mb.getEmail()[1] %>">
			</td>
		  </tr>	
		  <tr height="40">
			<td width="300" align="left"><font color="gray">����</font></td>
			<td width="600" style="padding-left: 10">
				<input type="text" style="width: 240" name="age" value="<%= mb.getAge() %>">
			</td>
		  </tr>
		  <tr height="40">
			<td width="300" align="left"><font color="gray">����</font></td>
			<td width="600" style="padding-left: 10">
				<input type="text" style="width: 240" name="job" value="<%= mb.getJob() %>">
			</td>
		  </tr>	
		  <tr height="40">
			<td width="300" align="left"><font color="gray">�ּ�</font></td>
			<td width="600" style="padding-left: 10">
				<input type="text" style="width: 240" name="address" value="<%= mb.getAddress() %>">
			</td>
		  </tr>	
		  <tr height="40">
			<td width="300" align="left"><font color="gray">����</font></td>
			<td width="600" style="padding-left: 10">
				<input type="text" name="birth" size='4' maxlength='4' value="<%= mb.getBirth()[0] %>">��
				<input type="text" name="birth" size='2' maxlength='2' value="<%= mb.getBirth()[1] %>">��
				<input type="text" name="birth" size='2' maxlength='2' value="<%= mb.getBirth()[2] %>">�� 
			</td>
		  </tr>				  
		  <tr height="40">
			<td width="300" align="left"><font color="gray">�ڵ�����ȣ</font></td>
			<td width="600" style="padding-left: 10">
				<input type="text" style="width: 50" name="phone" size="4" maxlength="3" value="<%= mb.getPhone()[0] %>"> - 
				<input type="text" style="width: 50" name="phone" size="4" maxlength="4" value="<%= mb.getPhone()[1] %>"> - 
                <input type="text" style="width: 50" name="phone" size="4" maxlength="4" value="<%= mb.getPhone()[2] %>">
			</td>
		  </tr>	
		  <tr height="40">
			<td width="300" align="left"><font color="gray">�о�</font></td>
			<td width="600" style="padding-left: 10">
			<%
			   int[] a = new int[15];
			   for(int i=0;i<15;i++){
				   a[i]=0;
			   }
			   for(int i=0;i<mb.getField().length;i++){
				   if(mb.getField()[i].equals("01")){
					   out.println("<br><input type=\"checkbox\" name=\"field\" value='01' checked>������");
					   a[0]=1;
				   }else if(a[0]==0){
					   out.println("<br><input type=\"checkbox\" name=\"field\" value='01'>������");
					   a[0]=1;
				   }
				   if(mb.getField()[i].equals("02")){
					   out.println("<input type=\"checkbox\" name=\"field\" value='02' checked>IT/���α׷���");
					   a[1]=1;
				   }else if(a[1]==0){
					   out.println("<input type=\"checkbox\" name=\"field\" value='02'>IT/���α׷���");
					   a[1]=1;
				   }
				   if(mb.getField()[i].equals("03")){
					   out.println("<input type=\"checkbox\" name=\"field\" value='03' checked>�/������");
					   a[2]=1;
				   }else if(a[2]==0){
					   out.println("<input type=\"checkbox\" name=\"field\" value='03'>�/������");
					   a[2]=1;
				   }
				   if(mb.getField()[i].equals("04")){
					   out.println("<input type=\"checkbox\" name=\"field\" value='04' checked>�ƿ�����/����");
					   a[3]=1;
				   }else if(a[3]==0){
					   out.println("<input type=\"checkbox\" name=\"field\" value='04'>�ƿ�����/����");
					   a[3]=1;				   
				   }
				   if(mb.getField()[i].equals("05")){
					   out.println("<input type=\"checkbox\" name=\"field\" value='05' checked>���/�ܱ���");
					   a[4]=1;	
				   }else if(a[4]==0){
					   out.println("<input type=\"checkbox\" name=\"field\" value='05'>���/�ܱ���");
					   a[4]=1;	
				   }
				   if(mb.getField()[i].equals("06")){
					   out.println("<input type=\"checkbox\" name=\"field\" value='06' checked>����");
					   a[5]=1;	
				   }else if(a[5]==0){
					   out.println("<input type=\"checkbox\" name=\"field\" value='06'>����");
					   a[5]=1;	
				   }
				   if(mb.getField()[i].equals("07")){
					   out.println("<input type=\"checkbox\" name=\"field\" value='07' checked>��Ƽ");
					   a[6]=1;	
				   }else if(a[6]==0){
					   out.println("<input type=\"checkbox\" name=\"field\" value='07'>��Ƽ");
					   a[6]=1;	
				   }
				   if(mb.getField()[i].equals("08")){
					   out.println("<input type=\"checkbox\" name=\"field\" value='08' checked>�ǰ�/����");
					   a[7]=1;	
				   }else if(a[7]==0){
					   out.println("<input type=\"checkbox\" name=\"field\" value='08'>�ǰ�/����");
					   a[7]=1;	
				   }
				   if(mb.getField()[i].equals("09")){
					   out.println("<input type=\"checkbox\" name=\"field\" value='09' checked>����/å");
					   a[8]=1;	
				   }else if(a[8]==0){
					   out.println("<input type=\"checkbox\" name=\"field\" value='09'>����/å");
					   a[8]=1;	
				   }
				   if(mb.getField()[i].equals("10")){
					   out.println("<input type=\"checkbox\" name=\"field\" value='10' checked>����/�Ǳ�");
					   a[9]=1;	
				   }else if(a[9]==0){
					   out.println("<input type=\"checkbox\" name=\"field\" value='10'>����/�Ǳ�");
					   a[9]=1;	
				   }
				   if(mb.getField()[i].equals("11")){
					   out.println("<input type=\"checkbox\" name=\"field\" value='11' checked>��");
					   a[10]=1;	
				   }else if(a[10]==0){
					   out.println("<input type=\"checkbox\" name=\"field\" value='11'>��");
					   a[10]=1;	
				   }
				   if(mb.getField()[i].equals("12")){
					   out.println("<input type=\"checkbox\" name=\"field\" value='12' checked>����");
					   a[11]=1;	
				   }else if(a[11]==0){
					   out.println("<input type=\"checkbox\" name=\"field\" value='12'>����");
					   a[11]=1;	
				   }
				   if(mb.getField()[i].equals("13")){
					   out.println("<input type=\"checkbox\" name=\"field\" value='13' checked>����/����");
					   a[12]=1;	
				   }else if(a[12]==0){
					   out.println("<input type=\"checkbox\" name=\"field\" value='13'>����/����");
					   a[12]=1;	
				   }
				   if(mb.getField()[i].equals("14")){
					   out.println("<input type=\"checkbox\" name=\"field\" value='14' checked>�丮");
					   a[13]=1;	
				   }else if(a[13]==0){
					   out.println("<input type=\"checkbox\" name=\"field\" value='14'>�丮");
					   a[13]=1;	
				   }
				   if(mb.getField()[i].equals("15")){
					   out.println("<input type=\"checkbox\" name=\"field\" value='15' checked>����/�ֽ�");
					   a[14]=1;	
				   }else if(a[14]==0){
					   out.println("<input type=\"checkbox\" name=\"field\" value='15'>����/�ֽ�");
					   a[14]=1;	
				   }
			   }
			%>
			</td>
		  </tr>
		  <tr height="40">
			<td width="300" valign="top"><br><font color="gray">����</font></td>
			<td width="600" style="padding-left: 10"><br>
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
<input type="checkbox" name="region" value="c3">������
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
<input type="checkbox" name="region" value="e4">������
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
<input type="checkbox" name="region" value="h2">�ܾ�, ��õ
<input type="checkbox" name="region" value="h3">����, ����, ��õ
<input type="checkbox" name="region" value="h4">��õ, ����
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
<input type="checkbox" name="region" value="j3">�ϱ�
<input type="checkbox" name="region" value="j4">�߱�, ���ֱ�


<br><br>
<font color="gray"><b>�泲</b></font><br>
<input type="checkbox" name="region" value="k1">����, ����
<input type="checkbox" name="region" value="k2">�о�, ���
<input type="checkbox" name="region" value="k4">����, ��û
<input type="checkbox" name="region" value="k3">�Ƿ�, â��, �Ծ�
<input type="checkbox" name="region" value="k5">â��, ����, ����
<br>
<input type="checkbox" name="region" value="k6">�뿵, ����
<input type="checkbox" name="region" value="k7">�ϵ�, ����
<input type="checkbox" name="region" value="k8">��õ, ��â ��



<br><br>
<font color="gray"><b>���</b></font><br>
<input type="checkbox" name="region" value="l1">���, û��
<input type="checkbox" name="region" value="l2">����, ���׳���
<input type="checkbox" name="region" value="l3">���, ����, ĥ��
<input type="checkbox" name="region" value="l4">��õ, ����
<input type="checkbox" name="region" value="l5">����, ��õ, ����
<input type="checkbox" name="region" value="l6">����
<input type="checkbox" name="region" value="l7">�ȵ�, �Ǽ�, û��
<input type="checkbox" name="region" value="l8">����, ���׺ϱ�
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
<input type="checkbox" name="region" value="o2">����, ����, ����
<input type="checkbox" name="region" value="o3">����, �ž�
<input type="checkbox" name="region" value="o4">����, ����, ȭ��
<input type="checkbox" name="region" value="o5">����, ��õ, ����
<input type="checkbox" name="region" value="o6">����, �强, ���
<input type="checkbox" name="region" value="o7">����, ����, ����
<input type="checkbox" name="region" value="o8">�س�, ����, �ϵ� 


<br><br>
<font color="gray"><b>����</b></font><br>
<input type="checkbox" name="region" value="p1">��â, �ξ�, ����
<input type="checkbox" name="region" value="p2">����, �ͻ�
<input type="checkbox" name="region" value="p3">����, ��â, �ӽ�
<input type="checkbox" name="region" value="p4">����, ���, ����
<input type="checkbox" name="region" value="p5">����, ����, ���� 


<br><br>
<font color="gray"><b>����</b></font><br> 
<input type="checkbox" name="region" value="q1">�������� 
<input type="checkbox" name="region" value="q2">���ֽ�<br><br>
				
			</td>
		  </tr>		
		  <tr height="40">
			<td width="300" align="left"><font color="gray">����</font></td>
			<td width="600" bgcolor="ffffff" style="padding-left: 10">
				��<input type="radio" style="width: 240" name="gender" value="m"><br>
				��<input type="radio" style="width: 240" name="gender" value="f">
			</td>
		  </tr>	
		  <tr>
		  <td width="150" align="left"><font color="gray"> 
		  ������ ���� </font></td>
		  <td><input id="profile_image" type="file" style="width: 240" name="img">
		  </td></tr>
	  </table>
	  <br>
	  
	  <table style="width: 100%">
		  <tr>
			<td align="center">
			<input type="button" value="����" onClick="memberUpdate()"> &nbsp;
			</td>
		  </tr>
	  </table>
	</td>
  </tr>
</table>  
</form>
</body>
</html>