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
	<title>DashBoard</title>
</head>
<body>

	<div class="container border-bottom border-info pb-3">
		<div class=row>
			<div class="col">
			<h1 class="h2 mt-2"><small>Welcome back, ${fn:toUpperCase(fn:substring(user.firstName, 0, 1))}${fn:toLowerCase(fn:substring(user.firstName, 1,fn:length(user.firstName)))} ${fn:toUpperCase(fn:substring(user.lastName, 0, 1))}${fn:toLowerCase(fn:substring(user.lastName, 1,fn:length(user.lastName)))} !</small></h1>
			</div>
			<div class="col-2 text-right pt-3">
				<a href="/logout"><button class="btn btn-danger">Logout</button></a>
			</div>
		</div>
	</div>
	<br>
	<div class="container">
		<h4 class="h4 border-bottom border-success d-inline-block mb-2 font-weight-normal">Your Courses</h4>
		<table class="table table-sm table-success">
		  <thead>
		    <tr>
		      <th scope="col" class="bg-success">Course</th>
		      <th scope="col" class="bg-success">Instructor</th>
		      <th scope="col" class="bg-success">Atendees</th>
		      <th scope="col" class="bg-success">Action</th>
		     
		    </tr>
		  </thead>
		  <tbody class=" border border-success">
		  	<c:forEach items="${courses }" var="course">
			  	<tr>
			  		<td><a href="/courses/${course.id }">${course.name }</a></td>
			  		<td>${course.instructor }</td>
			  		<td>
			  			<c:set var="count" value="0"/>
			  			<c:forEach items="${course.joinedUsers }" var="user">
			  				<c:set var="count" value="${count+1}"/>
			  				
			  			</c:forEach>
			  			${count}/${course.capacity}
			  		</td>
			  		<td>
			  			<c:choose>
			  				<c:when test="${course.capacity == count}" >
			  					<Button class="btn btn-outline-dark btn-sm"disabled>FULL</Button>
			  				</c:when>
			  				<c:otherwise>
			  					<c:set var = "attending" value = "${false}"/>
			  					<c:forEach items="${course.joinedUsers}" var="joinedUser">
			  						
			  						<c:if test ="${joinedUser == user}">
				     					<c:set var="attending" value="${true}"/>
				     				</c:if>
				     			</c:forEach>
				     				
				     				<c:choose>
				     					<c:when test="${attending == false }">
				     						<form:form action="/home/add" method="POST" modelAttribute="userCourse">
							      				<input type="hidden" value="${course.id}" name="course">
							      				<input type="hidden" value="${user.id}" name="user">
							      				<button class="btn btn-primary btn-sm" type="submit">Add</button>
							      			</form:form>
				     					</c:when>
				     					<c:otherwise>
				     						<Button class="btn btn-outline-primary btn-sm"disabled>Already Added</Button>
				     					</c:otherwise>
				     				</c:choose>
			  					
			  					
			  				
			  				</c:otherwise>
			  			</c:choose>
			  		</td>
			  		
			  	</tr>
			</c:forEach>
		  </tbody>
		</table>
		<br>
		<a href="/courses/new"><button class="btn btn-info">Add a Course</button></a>

	</div>



	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</body>
</html>