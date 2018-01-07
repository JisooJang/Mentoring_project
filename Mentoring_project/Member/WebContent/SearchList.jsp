<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%@ page import="model.*" %>
   <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	List<Team> searchList = (List<Team>)request.getAttribute("searchList");
    List<String> imgList = (List<String>)request.getAttribute("img");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>SearchList</title>
<script>
function applyCreate(tid) {
	f.id.value=tid;
	f.action="applyCreate.m2";
	f.command.value="applyCreate";
	f.submit();
}
</script>
</head>
<body>
<center>
<form name="f" method="post">
<input type="hidden" name="command">
<input type="hidden" name="id">
<table width=1000 align="center">
<%
	if(searchList.size()==0 || searchList==null) {
		out.println("<center>"+"�˻� ����� �����ϴ�."+"</center>");
	}
	
	else {
		%> 
		<tr>
		<td align="center" bgcolor="gray">����</td>
		<td align="center" bgcolor="gray">������̵�</td>
		<td align="center" bgcolor="gray">����</td>
		<td align="center" bgcolor="gray">����</td>
		<td align="center" bgcolor="gray">���۳�¥</td>
		</tr>
		<% 
	for ( int i=0; i<searchList.size(); i++) {
		
		Team team = (Team)searchList.get(i);
		String img = imgList.get(i);
		if(((String)session.getAttribute("mbId")).equals(team.getMento_id())) {
			continue;
		}
%>		  	
		  	<tr>
		  	    <td width="180" align="center" bgcolor="ffffff" height="20">
					<img src = "<%= img %>" width=100 height=100/>
				</td>
				<td width="180" align="center" bgcolor="ffffff" height="20">
					<%= team.getMento_id() %>
				</td>
				<td width="180" align="center" bgcolor="ffffff">
					<%= team.getTeam_name() %> 
				</td>
				<td width="180" align="center" bgcolor="ffffff">
				<%
				  if(team.getField().equals("01")){
					  out.print("������");
				  }else if(team.getField().equals("02")){
					  out.println("IT/���α׷���");
				  }else if(team.getField().equals("03")){
					  out.println("�/������");
				  }else if(team.getField().equals("04")){
					  out.println("�ƿ�����/����");
				  }else if(team.getField().equals("05")){
					  out.println("���/�ܱ���");
				  }else if(team.getField().equals("06")){
					  out.println("����");
				  }else if(team.getField().equals("07")){
					  out.println("��Ƽ");
				  }else if(team.getField().equals("08")){
					  out.println("�ǰ�/����");
				  }else if(team.getField().equals("09")){
					  out.println("����/å");
				  }else if(team.getField().equals("10")){
					  out.println("����/�Ǳ�");
				  }else if(team.getField().equals("11")){
					  out.println("��");
				  }else if(team.getField().equals("12")){
					  out.println("����");
				  }else if(team.getField().equals("13")){
					  out.println("����/����");
				  }else if(team.getField().equals("14")){
					  out.println("�丮");
				  }else if(team.getField().equals("15")){
					  out.println("����/�ֽ�");
				  }
				%>
				</td>
				<td width="180" align="center" bgcolor="ffffff">
				    <%= team.getStart_date() %>
				</td>
				<td>
				<%
				  System.out.println(team.getTeam_id());
				%>
				<a href="applyCreate.m2?command=applyCreate&tid=<%=team.getTeam_id()%>">��û</a>
				</td>
		  	</tr>
<%
		}
	}
%>		  	
</table>
</form>
</center>
</body>
</html>