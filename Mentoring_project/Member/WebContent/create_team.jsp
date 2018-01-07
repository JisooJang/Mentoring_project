<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script>
function teamCreate() {
	if ( f.team_name.value == "" ) {
		alert("팀명을 입력하십시요.");
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
		alert('분야는 최대 1개까지 선택 가능합니다.');
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
<tr bgcolor="#F7F7F7"><td colspan=2 align="center"><font color="gray"><b>팀 개설</b></font></td></tr>
<tr>
<td align="center"><br><font color="gray">팀명</font></td>
<td align="left"><br><input type="text" style="width: 240;" name="team_name"></td>
</tr>
<tr height="40">
			<td width="150" align="center"><br><font color="gray">분야</font></td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10"><br>
				<input type="checkbox" name="field" value='01'>디자인
				<input type="checkbox" name="field" value='02'>IT/프로그래밍<br>
				<input type="checkbox" name="field" value='03'>운동/스포츠
				<input type="checkbox" name="field" value='04'>아웃도어/여행<br>
				<input type="checkbox" name="field" value='05'>언어/외국어
				<input type="checkbox" name="field" value='06'>봉사
				<input type="checkbox" name="field" value='07'>뷰티<br>
				<input type="checkbox" name="field" value='08'>건강/의학
				<input type="checkbox" name="field" value='09'>문학/책
				<input type="checkbox" name="field" value='10'>음악/악기<br>
				<input type="checkbox" name="field" value='11'>댄스
				<input type="checkbox" name="field" value='12'>사진
				<input type="checkbox" name="field" value='13'>게임/오락<br>
				<input type="checkbox" name="field" value='14'>요리
				<input type="checkbox" name="field" value='15'>경제/주식
			</td>
</tr>
<tr align="center"><td colspan=2><br><input type="button" value="등록" onClick="teamCreate()"></td></tr>
</table>
</form>
</body>
</html>