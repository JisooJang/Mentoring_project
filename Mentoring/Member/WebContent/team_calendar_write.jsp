<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<center>
<%
	HttpSession s = request.getSession();
	
	String month = request.getParameter("month");
	String day = request.getParameter("day");
	
	s.setAttribute("month", month);
	s.setAttribute("day", day);
	//request.setAttribute("month", month);
	//request.setAttribute("day", day);
%>
<br><br><br>
<font color="#317190"><H3><%= (String)session.getAttribute("team_name") %>팀&nbsp;<%=month %>월&nbsp;<%=day %>일 일정 추가</h3></font><br>

<form name="f" method="post" action="team_calendar_list.m2?command=team_calendar_write">
<table align="center" bgcolor="#f4f3f3"><tr><td>
일정 내용 : <input type="text" name="c_content"> <br></td>
<tr><td>시간 :
<select name="c_time1">
<option value="--" selected>--</option>
<option value="01">01</option>
<option value="02">02</option>
<option value="03">03</option>
<option value="04">04</option>
<option value="05">05</option>
<option value="06">06</option>
<option value="07">07</option>
<option value="08">08</option>
<option value="09">09</option>
<option value="10">10</option>
<option value="11">11</option>
<option value="12">12</option>
<option value="13">13</option>
<option value="14">14</option>
<option value="15">15</option>
<option value="16">16</option>
<option value="17">17</option>
<option value="18">18</option>
<option value="19">19</option>
<option value="20">20</option>
<option value="21">21</option>
<option value="22">22</option>
<option value="23">23</option>
</select> 시

<select name="c_time2">
<option value="--" selected>--</option>
<option value="00">00</option>
<option value="10">10</option>
<option value="20">20</option>
<option value="30">30</option>
<option value="40">40</option>
<option value="50">50</option>
</select>분
<br></td></tr>
<tr><td>
장소:&nbsp;<input type="text" name="c_spot">
<input type="submit" value="추가">
</td></tr>
</table>
</form>
</center>
</body>
</html>