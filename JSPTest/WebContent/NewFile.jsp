<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test</title>
</head>
<body>
	<h1>Test</h1>
	<h3><%= new Date() %></h3>
	<% String req = request.getParameter("name"); %>
	<H1><%= req %></H1>
	
</body>
</html>