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
		alert("분야를 선택해주세요");
		return;
	}
	if(f.age.value=="1"){
		alert("나이를 선택해주세요");
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
<td><font color="gray" size=4>연령</font></td><td width=10></td>
<td><font color="gray" size=4>활동지역</font></td><td width=10></td>
<td><font color="gray" size=4>분야</font></td></tr>
<tr>
<td>
<select name="age">
<option value="1">연령 선택</option>
<option value="20">20대</option>
<option value="30">30대</option>
<option value="40">40대</option>
<option value="50">50대 이상</option>
</select> </td><td width=10></td>
<td>
<select name="r" onchange="selectR(this.options[this.selectedIndex].value)">
<option value="1">지역 선택</option>
<option value="a">서울</option>
<option value="b">경기</option>
<option value="c">인천</option>
<option value="d">강원</option>
<option value="e">대전</option>
<option value="f">세종</option>
<option value="g">충남</option>
<option value="i">부산</option>
<option value="j">울산</option>
<option value="k">경남</option>
<option value="l">경북</option>
<option value="m">대구</option>
<option value="n">광주</option>
<option value="o">전남</option>
<option value="p">전북</option>
<option value="q">제주</option>

</select> </td><td width=20></td>
<td>
			<input type="checkbox" name="field" value='01'><font size=3>디자인
           	<input type="checkbox" name="field" value='02'>IT/프로그래밍
            <input type="checkbox" name="field" value='03'>운동/스포츠
            <input type="checkbox" name="field" value='04'>아웃도어/여행
            <input type="checkbox" name="field" value='05'>언어/외국어
            <input type="checkbox" name="field" value='06'>봉사
            <input type="checkbox" name="field" value='07'>뷰티
            <input type="checkbox" name="field" value='08'>건강/의학
            <input type="checkbox" name="field" value='09'>문학/책
            <input type="checkbox" name="field" value='10'>음악/악기
            <input type="checkbox" name="field" value='11'>댄스
            <input type="checkbox" name="field" value='12'>사진<br>
            <input type="checkbox" name="field" value='13'>게임/오락
            <input type="checkbox" name="field" value='14'>요리
            <input type="checkbox" name="field" value='15'>경제/주식</font>
</td>
</tr>
</table>
</form>
</body>
</html>