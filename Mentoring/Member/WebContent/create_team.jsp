<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script>
function teamCreate() {
	if ( f.team_name.value == "" ) {
		alert("������ �Է��Ͻʽÿ�.");
		f.userId.focus();
		return false;
	} 
	var sum = 0;
	var count = f.field.length;
	for(var i=0 ; i<count ; i++) {
		if(f.field[i].checked == true) {
			sum += 1;
		}
	}
	
	if(sum > 1) {
		alert('�оߴ� �ִ� 1������ ���� �����մϴ�.');
		return;
	}
	
	f.command.value = "team_insert";
	f.action = "team.m2";
	f.submit();
}
</script>
<title>create team</title>
</head>
<body text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<form name="f" method="POST">
<input type="hidden" name="command"/>
<table style="width: 100%" align="center">
<tr bgcolor="#F7F7F7"><td colspan=2 align="center"><font color="gray"><b>�� ����</b></font></td></tr>
<tr>
<td align="center"><br><font color="gray">����</font></td>
<td align="left"><br><input type="text" style="width: 240;" name="team_name"></td>
</tr>
<tr height="40">
			<td width="150" align="center"><br><font color="gray">�о�</font></td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10"><br>
				<input type="checkbox" name="field" value='01'>������
				<input type="checkbox" name="field" value='02'>IT/���α׷���<br>
				<input type="checkbox" name="field" value='03'>�/������
				<input type="checkbox" name="field" value='04'>�ƿ�����/����<br>
				<input type="checkbox" name="field" value='05'>���/�ܱ���
				<input type="checkbox" name="field" value='06'>����
				<input type="checkbox" name="field" value='07'>��Ƽ<br>
				<input type="checkbox" name="field" value='08'>�ǰ�/����
				<input type="checkbox" name="field" value='09'>����/å
				<input type="checkbox" name="field" value='10'>����/�Ǳ�<br>
				<input type="checkbox" name="field" value='11'>��
				<input type="checkbox" name="field" value='12'>����
				<input type="checkbox" name="field" value='13'>����/����<br>
				<input type="checkbox" name="field" value='14'>�丮
				<input type="checkbox" name="field" value='15'>����/�ֽ�
			</td>
</tr>
<tr align="center"><td colspan=2><br><input type="button" value="���" onClick="teamCreate()"></td></tr>
</table>
</form>
</body>
</html>