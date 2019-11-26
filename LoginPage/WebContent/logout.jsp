<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Logged Out
<%

session.invalidate();

//System.out.println("Logged out");
//response.sendRedirect("home.jsp");


%>
</body>
</html>