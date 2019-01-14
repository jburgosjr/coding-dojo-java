<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="assets/css/.css">
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<title>Info</title>
</head>
<body>
	<div class=container>
		<a href="/"><button class="btn btn-outline-dark">DashBoard</button></a>
	</div>
	<div class=container>
		<h4 class="display-4"><small>Language Name: <c:out value="${language.name}"/></small></h4>
		<h4 class="display-4"><small>Creator: <c:out value="${language.creator}"/></small></h4>
		<h4 class="display-4"><small>Version: <c:out value="${language.version}"/></small></h4>
		<br>
		<br>
		<form action="/languages/<c:out value="${language.id}"/>" method="post" class="d-inline-block">
			<input type="hidden" name="_method" value="delete">
			<input type="submit" class="btn btn-outline-danger" value="Delete">
		</form> 
		<a href="/languages/<c:out value="${language.id}"/>/edit"><button type="button" class="btn btn-outline-primary">Edit</button></a>
		
	</div>
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</body>
</html>