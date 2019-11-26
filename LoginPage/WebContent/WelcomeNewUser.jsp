<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
request.getSession(false);
if (session == null) { %>
  <a href="http://ec2-13-59-57-224.us-east-2.compute.amazonaws.com:8080/LoginPage/home.jsp"> Home</a>
  <a href="http://ec2-13-59-57-224.us-east-2.compute.amazonaws.com:8080/LoginPage/login.jsp"> Login</a>
  <% 
} else {
    // Already created.
    %>
  <a href="http://ec2-13-59-57-224.us-east-2.compute.amazonaws.com:8080/LoginPage/logout.jsp"> Logout</a><% 
}
String name = request.getParameter("name");
%>
<br><br>
<%
out.println("Welcome New: "+name);
%>
</body>
</html>