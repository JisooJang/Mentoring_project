<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%@ page import="model.*" %>
   <%@ page import="java.util.*" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% List<Apply> applyList = (List<Apply>)request.getAttribute("applyList"); %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>


<link rel=stylesheet href="${pageContext.request.contextPath}/css/boardinfo.css" type="text/css">

</head>
<body>

<div align="center" class="flexbox" style="margin-top: 30px;">
			<div class="outer-container">
				<span class="header-title">팀 신청자 목록</span><br />
				<span class="header-subtitle">applicant list</span><br /><hr />
			</div>
		</div> 

<div class='table-container'>
<table>
<%
	Iterator<Apply> applyIter = applyList.iterator();

	if(!(applyIter.hasNext())) {
		out.println("신청자가 없습니다.");
	}
	else {
		%>
		<tr>
		<td>지원자아이디</td>
		<td>상태</td>
		<td>팀아이디</td>
		<td></td>
		<td></td>
		</tr>
		<%
		while(applyIter.hasNext()) {
			Apply apply = (Apply)applyIter.next();
		%>
		<tr>
		<td><%=apply.getMember_id() %></td>
		<td><%=apply.getState() %></td>
		<td><%=apply.getTeam_id() %></td>
		<td><a href="team_member_list.m2?team_id=<%=apply.getTeam_id()%>&member_id=<%=apply.getMember_id()%>&command=teamMemberCreate" class="apply">수락-- 누르면 applyList에서 사라지고 (remove) 팀멤버에 추가 ... 수락당한 멤버에게 알리기?</a></td>
		<td><a href="apply_list.m2?team_id=<%=apply.getTeam_id()%>&member_id=<%=apply.getMember_id()%>&command=applyRemove" class="apply">거절-- 누르면 applyList에서 사라지고 (remove) ... 거절당한 멤버에게 알리기?</a></td>
		</tr>	
		<%
		}
		
	}
%>
</table>
</div>
</body>
</html>