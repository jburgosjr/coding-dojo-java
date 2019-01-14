<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="assets/css/.css">
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<title>Course Info</title>
</head>
<body>
	<div class="container text-right ">
		<div class="mt-3 pr-2">
			<a href="/home"><button class="btn btn-success shadow">Home</button></a>
			<a href="/logout"><button class="btn btn-danger">Logout</button></a>
			
		</div>
	</div>
	<div class="container">
		<h1 class="display-4 border-bottom border-info d-inline-block ">${course.name}</h1>
		<br>
		<h5>Instructor: ${course.instructor }</h5>
		<c:set var="attending" value="0"/>
		<c:forEach items="${course.joinedUsers }" var="joinedUsers">
			<c:set var="attending" value="${attending+1}"/>
		</c:forEach>
		<h5>Sign ups: ${attending }</h5>
	</div>
	<div class="container">
		<table class="table table-sm table-success">
		  <thead>
		    <tr>
		      <th scope="col" class="bg-success">Name</th>
		      <th scope="col" class="bg-success">Date Joined</th>
		 	  <th scope="col" class="bg-success">Action</th>
		     
		    </tr>
		  </thead>
		  <tbody class=" border border-success">
			<c:forEach items="${course.joinedUsers }" var="user">
				<tr>
					<td> ${fn:toUpperCase(fn:substring(user.firstName, 0, 1))}${fn:toLowerCase(fn:substring(user.firstName, 1,fn:length(user.firstName)))} ${fn:toUpperCase(fn:substring(user.lastName, 0, 1))}${fn:toLowerCase(fn:substring(user.lastName, 1,fn:length(user.lastName)))}</td>
					<td><fmt:formatDate type = "date" dateStyle = "long" timeStyle = "long" value = "${user.createdAt}" /> </td>
					<td>
						<c:choose>
							<c:when test="${user == userCheck }">
								<form action="/courses/${course.id}/remove" method="POST" class="d-inline-block">
					      				<input type="hidden" name="_method" value="delete">
					      				<input type="hidden" name="userId" value="${userCheck.id}">
					      				<input type="hidden" name="courseId" value="${course.id}">
					      				<input type="submit" class="btn btn-outline-danger btn-sm" value="remove">
					      		</form>
							</c:when>
							<c:otherwise>
								-
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		 
		</table>
	</div>
	<div class="container">
		<c:choose>
			<c:when test="${course.user == userCheck }">
				<a href="/courses/${course.id }/edit"><button class="btn btn-dark">Edit</button></a> 
				<form action="/courses/${course.id }" method="post" class="d-inline-block">
			      				<input type="hidden" name="_method" value="delete">
			      				<input type="hidden" name="userId" value="${userCheck.id}">
			      				<input type="submit" class="btn btn-danger " value="Delete">
			     </form>
			</c:when>
			
		</c:choose>	
	</div>
	


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</body>
</html>