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
				<span class="header-title">�� ��û�� ���</span><br />
				<span class="header-subtitle">applicant list</span><br /><hr />
			</div>
		</div> 

<div class='table-container'>
<table>
<%
	Iterator<Apply> applyIter = applyList.iterator();

	if(!(applyIter.hasNext())) {
		out.println("��û�ڰ� �����ϴ�.");
	}
	else {
		%>
		<tr>
		<td>�����ھ��̵�</td>
		<td>����</td>
		<td>�����̵�</td>
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
		<td><a href="team_member_list.m2?team_id=<%=apply.getTeam_id()%>&member_id=<%=apply.getMember_id()%>&command=teamMemberCreate" class="apply">����-- ������ applyList���� ������� (remove) ������� �߰� ... �������� ������� �˸���?</a></td>
		<td><a href="apply_list.m2?team_id=<%=apply.getTeam_id()%>&member_id=<%=apply.getMember_id()%>&command=applyRemove" class="apply">����-- ������ applyList���� ������� (remove) ... �������� ������� �˸���?</a></td>
		</tr>	
		<%
		}
		
	}
%>
</table>
</div>
</body>
</html>