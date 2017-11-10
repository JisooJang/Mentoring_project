<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Calendar"%>
<%@ page import="java.util.List, java.util.ArrayList" %>
<%@ page import="model.TeamCalendar" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="teamproject.css">
<style type="text/css">
a { text-decoration:none }
</style>

</head>
<body
<%

 if(request.getAttribute("delete_cal_fail") != null) {
	 out.println("onLoad=\"alert('작성자만 삭제 가능합니다.')\">");
 }
 else {
%>
>
<% } %> 

<form name="f" method="get">
<center>
<font color="#317190"><h3><%= (String)session.getAttribute("team_name") %>팀 일정 스케쥴러 </h3></font> <br><br>
<%
List<TeamCalendar> list = (List<TeamCalendar>)request.getAttribute("list");


List<TeamCalendar> this_month_list = new ArrayList<TeamCalendar>();

Calendar cal = Calendar.getInstance();
int y = cal.get(Calendar.YEAR);
int m = cal.get(Calendar.MONTH);
int d = cal.get(Calendar.DATE);
int sunday_check = 0;
int y2 = y, m2 = m, d2 = d;
int start, end;
int br = 0;
String startDay;
String sYear = request.getParameter("year"), sMonth = request.getParameter("month");

if(sYear != null && sMonth != null) {
	y = Integer.parseInt(sYear);
	m = Integer.parseInt(sMonth);
	
	if(m < 0) {
		m = 0;
	}
	if(m > 11) {
		m = 11;
	}
}



cal.set(y, m, 1);

if(list != null) {
for(int index=0 ; index<list.size() ; index++) {		// 현재 해당하는 월에 대한 팀 일정 리스트만 새로 추가함
	TeamCalendar t_cal = list.get(index);
	String month = (t_cal.getC_date()).substring(0, 2);	
	String day = (t_cal.getC_date()).substring(3);

	boolean result = month.equals(Integer.toString(m+1));
	
	if(result == true) {
		this_month_list.add(t_cal);
	}
}

}

	
start = cal.get(Calendar.DAY_OF_WEEK);
end = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

out.println("<font size='5' color='#626363'>");
out.println("<table width='650' align='center' border='0 cellspacing='0' cellpadding='0'><tr><td align='left'><b>"
+ "<a href='team_calendar_list.m2?command=team_calendar_list&year=" + (y-1) + "&month=" + m + "'>◀ </a>" + y + "년 ");

out.println("<a href='team_calendar_list.m2?command=team_calendar_list&year=" + (y+1) + "&month=" + m + "'>▶</a>" + 
"</b></td> <td align='center'>");
out.println("<b><a href='team_calendar_list.m2?command=team_calendar_list&year=" + y + "&month=" + (m-1) + "'>◀ </a> "); 
out.println((m+1) + "월 "
+ "<a href='team_calendar_list.m2?command=team_calendar_list&year=" + y + "&month=" + (m+1) + "'>▶</a>" + "</b></td>");
out.println("<td align='right'><b>" + y2 + "-" + (m2+1) + "-" + d2 + "</b></td></tr></table>");

out.println("</font>");

out.println("<table align='center' border='0' cellspacing='0' cellpadding='0' width='1000'>" +
"<tr align='center' height='40' bgcolor='#97c3d0'><td width='90'><font color='white'><b>SUN</b></font></td>"
+"<td width='90'><font color='white'><b>MON</b></font></td><td width='90'><font color='white'><b>TUE</b></font></td><td width='90'><font color='white'><b>WED</b></font></td>"
+"<td width='90'><font color='white'><b>THU</b></font></td><td width='90'><font color='white'><b>FRI</b></font></td><td width='90'><font color='white'><b>SAT</b></font></td></tr><tr align='center' height='50'>");


switch(start)
{
case 1:
	startDay = "일요일";
	break;
case 2:
	startDay = "월요일";	
	break;
case 3:
	startDay = "화요일";
	break;
case 4:
	startDay = "수요일";
	break;
case 5:
	startDay = "목요일";
	break;
case 6:
	startDay = "금요일";
	break;
case 7:
	startDay = "토요일";
	break;
}	

	
for(int i=1 ; i<start ; i++)
{
	out.println("<td height='100'>&nbsp;</td>");
	br++;
	sunday_check++;
}
	

for(int i=1 ; i<=end ; i++)
{
	if(br % 7 == 0)
		out.println("</tr><tr align='center' height='100'>");
	
	if(sunday_check % 7 == 0) {
		out.println("<td valign='top' align='left'>"+"<a href='team_calendar_write.jsp?month=" + (m+1) + "&day=" + i + "'>"
		+ "<font color='red' size='5', style='bold'>"+ i + "</font></a>");
	}
	else {
		out.println("<td valign='top' align='left'>"+"<a href='team_calendar_write.jsp?month=" + (m+1) + "&day=" + i + "'>"
	    + "<font color='black' size='5', style='bold'>"+ i + "</font></a>");
	} 
	
	for(int j=0 ; j<this_month_list.size() ; j++) {		
		TeamCalendar t_cal2 = this_month_list.get(j);
		String month = (t_cal2.getC_date()).substring(0, 2);
		String day = (t_cal2.getC_date()).substring(3);
		
		if(month.equals(Integer.toString(m+1)) && day.equals(Integer.toString(i))) {
			out.println("<br><a href='team_calendar_view.m2?command=team_calendar_view&calendar_id=" + t_cal2.getCalendar_id() + "'>" 
		+ "<font color='#747474'>" + t_cal2.getC_content() + "</font></a>");
		
		}
	
	}
			
	out.println("</td>");
	br++;
	sunday_check++;
}


while(true)
{
	if(br % 7 == 0)
		break;
	out.println("<td>&nbsp;</td>");
	br++;
	
}

%>
</table><br>
</center>	
</form>
</body>
</html>