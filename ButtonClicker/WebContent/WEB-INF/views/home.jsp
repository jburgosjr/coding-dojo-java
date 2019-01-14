<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Great number Game</title>
</head>
<body>
 <a href="Index"><button type="button">Click Me</button></a>
 
 <h1> You have click this button <c:out value="${count}"/> times </h1>
</body>
</html>