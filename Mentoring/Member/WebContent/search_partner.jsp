<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">
a { text-decoration:none }
select { width:100px ; height:40px }
</style>
</head>
<script>
function selectR(r) {
	var sum = 0;
	var count = f.field.length;
	for(var i=0 ; i<count ; i++) {
		if(f.field[i].checked == true) {
			sum += 1;
		}
	}
	
	if(sum == 0) {
		alert("�о߸� �������ּ���");
		return;
	}
	if(f.age.value=="1"){
		alert("���̸� �������ּ���");
	}else{
		if(r=="a"){
			f.action="./region/region_a.jsp";
			f.submit();
		}else if(r=="b"){
			f.action="./region/region_b.jsp";
			f.submit();
		}else if(r=="c"){
			f.action="./region/region_c.jsp";
			f.submit();
		}else if(r=="d"){
			f.action="./region/region_d.jsp";
			f.submit();
		}else if(r=="e"){
			f.action="./region/region_e.jsp";
			f.submit();
		}else if(r=="f"){
			f.action="./region/region_f.jsp";
			f.submit();
		}else if(r=="g"){
			f.action="./region/region_g.jsp";
			f.submit();
		}else if(r=="h"){
			f.action="./region/region_h.jsp";
			f.submit();
		}else if(r=="i"){
			f.action="./region/region_i.jsp";
			f.submit();
		}else if(r=="j"){
			f.action="./region/region_j.jsp";
			f.submit();
		}else if(r=="k"){
			f.action="./region/region_k.jsp";
			f.submit();
		}else if(r=="l"){
			f.action="./region/region_l.jsp";
			f.submit();
		}else if(r=="m"){
			f.action="./region/region_m.jsp";
			f.submit();
		}else if(r=="n"){
			f.action="./region/region_n.jsp";
			f.submit();
		}else if(r=="o"){
			f.action="./region/region_o.jsp";
			f.submit();
		}else if(r=="p"){
			f.action="./region/region_p.jsp";
			f.submit();
		}else if(r=="q"){
			f.action="./region/region_q.jsp";
			f.submit();
		}
	}
}
</script>
<body>
<form name="f" method="post" target="2">
<table align="center" width=800>
<tr align="center">
<td><font color="gray" size=4>����</font></td><td width=10></td>
<td><font color="gray" size=4>Ȱ������</font></td><td width=10></td>
<td><font color="gray" size=4>�о�</font></td></tr>
<tr>
<td>
<select name="age">
<option value="1">���� ����</option>
<option value="20">20��</option>
<option value="30">30��</option>
<option value="40">40��</option>
<option value="50">50�� �̻�</option>
</select> </td><td width=10></td>
<td>
<select name="r" onchange="selectR(this.options[this.selectedIndex].value)">
<option value="1">���� ����</option>
<option value="a">����</option>
<option value="b">���</option>
<option value="c">��õ</option>
<option value="d">����</option>
<option value="e">����</option>
<option value="f">����</option>
<option value="g">�泲</option>
<option value="i">�λ�</option>
<option value="j">���</option>
<option value="k">�泲</option>
<option value="l">���</option>
<option value="m">�뱸</option>
<option value="n">����</option>
<option value="o">����</option>
<option value="p">����</option>
<option value="q">����</option>

</select> </td><td width=20></td>
<td>
			<input type="checkbox" name="field" value='01'><font size=3>������
           	<input type="checkbox" name="field" value='02'>IT/���α׷���
            <input type="checkbox" name="field" value='03'>�/������
            <input type="checkbox" name="field" value='04'>�ƿ�����/����
            <input type="checkbox" name="field" value='05'>���/�ܱ���
            <input type="checkbox" name="field" value='06'>����
            <input type="checkbox" name="field" value='07'>��Ƽ
            <input type="checkbox" name="field" value='08'>�ǰ�/����
            <input type="checkbox" name="field" value='09'>����/å
            <input type="checkbox" name="field" value='10'>����/�Ǳ�
            <input type="checkbox" name="field" value='11'>��
            <input type="checkbox" name="field" value='12'>����<br>
            <input type="checkbox" name="field" value='13'>����/����
            <input type="checkbox" name="field" value='14'>�丮
            <input type="checkbox" name="field" value='15'>����/�ֽ�</font>
</td>
</tr>
</table>
</form>
</body>
</html>