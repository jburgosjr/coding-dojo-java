<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1> Hello <c:out value="${firstName}"/> <c:out value="${lastName }"/> </h1>
	<br>
	<br>
	<h4> Welcome to SpringBoot!</h4>
</body>
</html>