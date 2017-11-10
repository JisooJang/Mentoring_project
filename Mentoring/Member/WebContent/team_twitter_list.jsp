<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body bgcolor="#f4f3f3">

<%
	String id = (String)session.getAttribute("mbId");
	List<String> idList = (List<String>)session.getAttribute("idList");
	String team_id = (String)session.getAttribute("team_id");
	
	
	if(id == null) {
		out.println("로그인 후 이용 가능합니다.");
	}
%>
<form name="f" method="post" action="team_tweet.jsp">
<center>
<h2><font color="#4892a7">REAL-TIME team twitter!</font></h2>
<img src="images/team/team_twitter2.png"><br> <hr>
 <font color='#4a4b4b'><b>@<%= id %></b></font>&nbsp; <input type="text" name="message" size="70">
 <input type="submit" value="Tweet!"><hr><br>






<div align="center">
<UL>

<%
	ArrayList<String> messages = (ArrayList<String>)application.getAttribute("messages");
	ArrayList<String> messages2 = new ArrayList<String>();
	

	for(int i=0 ; i<messages.size() ; i++) {		
		int index2 = (messages.get(i)).indexOf("-");
		String t_id = (messages.get(i)).substring(0, index2);
		
		int index = (messages.get(i)).indexOf(":");	
		String m_id = (messages.get(i)).substring((index2+1), index);	
		
		for(int j=0 ; j<idList.size() ; j++) {
			if(m_id.equals(idList.get(j)) && t_id.equals(team_id)) {				
				messages2.add((messages.get(i)).substring((index2+1)));
			}
		}
	}


	
	if(messages != null && messages2 != null) {
		for(String msg : messages2) {
			out.println("<LI>" + msg + "</LI>");
		}
	}
	else {
		out.println("messages is null");
	}
%>

</UL>
</div>
</center>
</form>

</body>
</html>