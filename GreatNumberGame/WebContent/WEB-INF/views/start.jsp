<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="assets/css/startStyle.css">
	<meta charset="UTF-8">
	<title>Great Number Game</title>
</head>
<body>
	<div class=center>
		 <h1> Welcome to the Great Number Game!</h1>
		 <h4>I am thinking of a number between 1 and 100</h4>
		 <h4>Take a guess</h4>
		 <div class=<c:out value="${box}"/>>
		 	<h3><c:out value="${text}"/></h3>
		 	<c:out value="${reset}" escapeXml="false" /> 
		 	
		 	
		 </div>
		 <form action="process" method="post" >
		 		<input type = "text" name="guess">
		 		<br>
		 		<br>
		 		<button type = "submit">Submit</button>
		 	</form>
	</div>
</body>
</html>


