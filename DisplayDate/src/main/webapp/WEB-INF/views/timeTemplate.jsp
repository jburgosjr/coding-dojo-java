<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.Date" import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="assets/css/timeTemplateStyle.css">
    <script type="text/javascript" src="assets/javaScript/timeTempScript.js"></script>
	<meta charset="UTF-8">
	<title>Date Template</title>
</head>
<body>
	<%
		String pattern ="KK:mm aa";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	%>
	<h1 class=date><%= simpleDateFormat.format(new Date()) %></h1>
</body>
</html>