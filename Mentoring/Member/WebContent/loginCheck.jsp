<%
	session = request.getSession();

	if ((session == null) || (session.getAttribute("mbId") == null)) {
		response.sendRedirect("login.m2?command=loginForm");
	}
%>