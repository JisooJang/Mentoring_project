<%@page contentType="text/html; charset=euc-kr" %>
<html>
<head>
<title>Join</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<script>
function memberCreate() {
	if ( f.mbId.value == "" ) {
		alert("사용자 아이디를 입력하십시요.");
		f.userId.focus();
		return false;
	} 
	if ( f.pwd.value == "" ) {
		alert("비밀번호를 입력하십시요.");
		f.password.focus();
		return false;
	}
	if ( f.name.value == "" ) {
		alert("이름을 입력하십시요.");
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
		alert('지역은 최대 5개까지 선택 가능합니다.');
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
		alert('분야는 최대 3개까지 선택 가능합니다.');
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
	   out.println("<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0 onLoad=\"alert('이미 존재하는 아이디입니다.')\">");
   }else if(request.getParameter("cid").equals("1")){
	   out.println("<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0 onLoad=\"alert('사용가능한 아이디입니다.')\">");
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
			<td height="22"><br>&nbsp;&nbsp;<font color="#636363"><b>회원 가입</b></font></td>
		  </tr>
		  <tr><td><br><img src="images/hr.PNG" width=800></td></tr>
	  </table>  
	  <br>
	  
	  <table>
	  	  <tr height="40">
	  	    <td width="20"></td>
			<td width="150" align="left"><font color="gray">아이디</font></td>
			<td width="250" style="padding-left: 10">
				<input type="text" style="width: 100;" name="mbId">
				<input type="button" value="중복확인" onClick="check()"> 
			</td>
		  </tr>
	  	  <tr height="40">
	  	    <td width="20"></td>
			<td width="150" align="left"><font color="gray">비밀번호</font></td>
			<td width="250" style="padding-left: 10">
				<input type="password" style="width: 240" name="pwd">
			</td>
		  </tr>
	  	  <tr height="40">
	  	    <td width="20"></td>
			<td width="150" align="left"><font color="gray">이름</font></td>
			<td width="250" style="padding-left: 10">
				<input type="text" style="width: 140" name="name">
			</td>
		  </tr>
	  	  <tr height="40">
	  	    <td width="20"></td>
			<td width="150" align="left"><font color="gray">이메일 주소</font></td>
			<td width="250" style="padding-left: 10">
				<input type="text" style="width: 100" name="email"> @ 
				<input type="text" style="width: 100" name="email">
			</td>
		  </tr>	
		  <tr height="40">
		    <td width="20"></td>
			<td width="150" align="left"><font color="gray">나이</font></td>
			<td width="250" style="padding-left: 10">
				<input type="text" size="3" maxLength="2" name="age">
			</td>
		  </tr>
		  <tr height="40">
		    <td width="20"></td>
			<td width="150" align="left"><font color="gray">직업</font></td>
			<td width="250" style="padding-left: 10">
				<input type="text" style="width: 150" name="job">
			</td>
		  </tr>	
		  <tr height="40">
		    <td width="20"></td>
			<td width="150" align="left"><font color="gray">주소</font></td>
			<td width="250" style="padding-left: 10">
				<input type="text" style="width: 240" name="address">
			</td>
		  </tr>	
		  <tr height="40">
		    <td width="20"></td>
			<td width="150" align="left"><font color="gray">생년월일</font></td>
			<td width="250" style="padding-left: 10">
				<input type="text" name="birth" size='4' maxlength='4'>년
				<input type="text" name="birth" size='2' maxlength='2'>월
				<input type="text" name="birth" size='2' maxlength='2'>일 
			</td>
		  </tr>				  
		  <tr height="40">
		    <td width="20"></td>
			<td width="150" align="left"><font color="gray">핸드폰번호</font></td>
			<td width="250" style="padding-left: 10">
				<input type="text" style="width: 50" name="phone" size="4" maxlength="3"> - 
				<input type="text" style="width: 50" name="phone" size="4" maxlength="4"> - 
                <input type="text" style="width: 50" name="phone" size="4" maxlength="4">
			</td>
		  </tr>	
		  <tr height="40">
		    <td width="20"></td>
			<td width="150" align="left"><font color="gray">분야</font></td>
			<td width="305" style="padding-left: 10">
			    <br>
				<input type="checkbox" name="field" value='01'>디자인
				<input type="checkbox" name="field" value='02'>IT/프로그래밍
				<input type="checkbox" name="field" value='03'>운동/스포츠<br>
				<input type="checkbox" name="field" value='04'>아웃도어/여행
				<input type="checkbox" name="field" value='05'>언어/외국어
				<input type="checkbox" name="field" value='06'>봉사
				<input type="checkbox" name="field" value='07'>뷰티
				<input type="checkbox" name="field" value='08'>건강/의학
				<input type="checkbox" name="field" value='09'>문학/책<br>
				<input type="checkbox" name="field" value='10'>음악/악기
				<input type="checkbox" name="field" value='11'>댄스
				<input type="checkbox" name="field" value='12'>사진<br>
				<input type="checkbox" name="field" value='13'>게임/오락
				<input type="checkbox" name="field" value='14'>요리
				<input type="checkbox" name="field" value='15'>경제/주식
			</td>
		  </tr>
		  <tr height="40">
		    <td width="20"></td>
			<td width="150" valign="top"><br><font color="gray">지역</font></td>
			<td width="250" style="padding-left: 10">
			<br>
				<font color="gray"><b>서울</b></font><br>
<input type="checkbox" name="region" value="a1">강남구
<input type="checkbox" name="region" value="a2">강동구
<input type="checkbox" name="region" value="a3">강북구
<input type="checkbox" name="region" value="a4">강서구


<br><br>

<font color="gray"><b>경기</b></font><br>
<input type="checkbox" name="region" value="b1">남부
<input type="checkbox" name="region" value="b2">동부
<input type="checkbox" name="region" value="b3">북부


<br><br>

<font color="gray"><b>인천</b></font><br>
<input type="checkbox" name="region" value="c1">계양, 서구
<input type="checkbox" name="region" value="c2">남구, 동구
<input type="checkbox" name="region" value="c3">남동구<br>
<input type="checkbox" name="region" value="c4">부평
<input type="checkbox" name="region" value="c5">연수구
<input type="checkbox" name="region" value="c6">중구, 강화


<br><br>
<font color="gray"><b>강원</b></font><br>
<input type="checkbox" name="region" value="d1">강릉, 속초
<input type="checkbox" name="region" value="d2">동해, 삼척
<input type="checkbox" name="region" value="d3">영월, 태백
<input type="checkbox" name="region" value="d4">원주, 평창
<input type="checkbox" name="region" value="d5">춘천, 홍천
<input type="checkbox" name="region" value="d6">화천, 양구



<br><br>
<font color="gray"><b>대전</b></font><br>
<input type="checkbox" name="region" value="e1">대덕구
<input type="checkbox" name="region" value="e2">동구
<input type="checkbox" name="region" value="e3">서구
<input type="checkbox" name="region" value="e4">유성구<br>
<input type="checkbox" name="region" value="e5">중구, 서대전


<br><br>
<font color="gray"><b>세종</b></font><br>
<input type="checkbox" name="region" value="f1">세종



<br><br>
<font color="gray"><b>충남</b></font><br>
<input type="checkbox" name="region" value="g1">논산, 금산, 계룡
<input type="checkbox" name="region" value="g2">당진
<input type="checkbox" name="region" value="g3">보령, 서천
<input type="checkbox" name="region" value="g4">부여, 공주
<input type="checkbox" name="region" value="g5">서산, 태안
<br>
<input type="checkbox" name="region" value="g6">천안, 아산
<input type="checkbox" name="region" value="g7">홍성, 예산, 청양



<br><br>
<font color="gray"><b>충북</b></font><br>
<input type="checkbox" name="region" value="h1">괴산, 증평
<input type="checkbox" name="region" value="h2">단양, 제천<br>
<input type="checkbox" name="region" value="h3">보은, 영동, 옥천
<input type="checkbox" name="region" value="h4">진천, 음성<br>
<input type="checkbox" name="region" value="h5">청주
<input type="checkbox" name="region" value="h6">충주


<br><br>
<font color="gray"><b>부산</b></font><br>
<input type="checkbox" name="region" value="i1">강서구
<input type="checkbox" name="region" value="i2">경성대, 광안
<input type="checkbox" name="region" value="i3">남포, 영도
<input type="checkbox" name="region" value="i4">부산대, 동래
<input type="checkbox" name="region" value="i5">사상, 북구
<br>
<input type="checkbox" name="region" value="i6">서구, 사하
<input type="checkbox" name="region" value="i7">서면, 동구
<input type="checkbox" name="region" value="i8">연산, 거제
<input type="checkbox" name="region" value="i9">해운대, 기장


<br><br>
<font color="gray"><b>울산</b></font><br>
<input type="checkbox" name="region" value="j1">남구, 울산대
<input type="checkbox" name="region" value="j2">동구
<input type="checkbox" name="region" value="j3">북구<br>
<input type="checkbox" name="region" value="j4">중구, 울주군


<br><br>
<font color="gray"><b>경남</b></font><br>
<input type="checkbox" name="region" value="k1">김해, 장유
<input type="checkbox" name="region" value="k2">밀양, 양산
<input type="checkbox" name="region" value="k4">진주, 사청<br>
<input type="checkbox" name="region" value="k3">의령, 창녕, 함안
<input type="checkbox" name="region" value="k5">창원, 마산, 진해
<br>
<input type="checkbox" name="region" value="k6">통영, 거제
<input type="checkbox" name="region" value="k7">하동, 남해<br>
<input type="checkbox" name="region" value="k8">합천, 거창 외



<br><br>
<font color="gray"><b>경북</b></font><br>
<input type="checkbox" name="region" value="l1">경산, 청도
<input type="checkbox" name="region" value="l2">경주, 포항남구<br>
<input type="checkbox" name="region" value="l3">고령, 성주, 칠곡
<input type="checkbox" name="region" value="l4">김천, 구미<br>
<input type="checkbox" name="region" value="l5">문경, 예천, 영주
<input type="checkbox" name="region" value="l6">상주<br>
<input type="checkbox" name="region" value="l7">안동, 의성, 청송
<input type="checkbox" name="region" value="l8">영덕, 포항북구<br>
<input type="checkbox" name="region" value="l9">영양, 울진, 봉화
<input type="checkbox" name="region" value="l10">영천, 군위



<br><br>
<font color="gray"><b>대구</b></font><br>
<input type="checkbox" name="region" value="m1">달서구, 서구 
<input type="checkbox" name="region" value="m2">달성군
<input type="checkbox" name="region" value="m3">동구, 팔공
<input type="checkbox" name="region" value="m4">북구, 칠곡
<input type="checkbox" name="region" value="m5">수성구
<input type="checkbox" name="region" value="m6">중구, 남구
 

<br><br>
<font color="gray"><b>광주</b></font><br>
<input type="checkbox" name="region" value="n1">광산구 
<input type="checkbox" name="region" value="n2">남구, 동구
<input type="checkbox" name="region" value="n3">북구
<input type="checkbox" name="region" value="n4">서구 


<br><br>
<font color="gray"><b>전남</b></font><br>
<input type="checkbox" name="region" value="o1">곡성, 구례
<input type="checkbox" name="region" value="o2">나주, 함평, 무안<br>
<input type="checkbox" name="region" value="o3">목포, 신안
<input type="checkbox" name="region" value="o4">보성, 고흥, 화순<br>
<input type="checkbox" name="region" value="o5">여수, 순천, 광양
<input type="checkbox" name="region" value="o6">영광, 장성, 담양<br>
<input type="checkbox" name="region" value="o7">영암, 강진, 장흥
<input type="checkbox" name="region" value="o8">해남, 진도, 완도 


<br><br>
<font color="gray"><b>전북</b></font><br>
<input type="checkbox" name="region" value="p1">고창, 부안, 정읍
<input type="checkbox" name="region" value="p2">군산, 익산<br>
<input type="checkbox" name="region" value="p3">남원, 순창, 임실
<input type="checkbox" name="region" value="p4">무주, 장수, 진안<br>
<input type="checkbox" name="region" value="p5">전주, 완주, 김제 


<br><br>
<font color="gray"><b>제주</b></font><br> 
<input type="checkbox" name="region" value="q1">서귀포시 
<input type="checkbox" name="region" value="q2">제주시
				
			</td>
		  </tr>		
		  <tr height="40">
		    <td width="20"></td>
			<td width="150" align="left"><font color="gray">성별</font></td>
			<td width="100" align="left">
				<font color="gray">남</font><input type="radio" style="width: 240" name="gender" value="m"><br>
				<font color="gray">여</font><input type="radio" style="width: 240" name="gender" value="f">
			</td>
		  </tr>	
		  <tr>
		  <td width="20"></td>
		  <td width="150" align="left"> 
		  <font color="gray">프로필 사진</font> </td>
		  <td><input id="profile_image" type="file" style="width: 240" name="birth" size='4' maxlength='4'>
		  </td></tr>
	  </table>
	  <br>
	  
	  <table style="width: 100%">
		  <tr>
			<td align="center">
			<input type="button" value="회원 가입" onClick="memberCreate()"> &nbsp;
			<input type="button" value="로그인" onClick="goLogin()">
			</td>
		  </tr>
	  </table>
	</td>
  </tr>
</table>  
</form>
</body>
</html>