<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="assets/css/.css">
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<title>Edit Course</title>
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
	</div>
<div class="container">
		<div class="row">
			<div class="col">
						<h4 class="h4 border-bottom border-info d-inline-block mb-2">Edit Course</h4>
						
						<form:form action="/courses/${course.id}/edit" method="POST" modelAttribute="course">
							<input type="hidden" name="_method" value="put">
						
							<p>
								<form:label path="name" cssClass="h5 font-weight-normal">Course Name</form:label>
								<form:input path="name" cssClass="form-control  col-7 bg-info text-white"/>
							</p>
							<p>
								<form:label path="instructor" cssClass="h5 font-weight-normal">Instructor</form:label>
								<form:input path="instructor" cssClass="form-control  col-7 bg-info text-white"/>
							</p>
							<p>
								<form:label path="capacity" cssClass="h5 font-weight-normal">Capacity</form:label>
								<form:input path="capacity" cssClass="form-control  col-4 bg-info text-white"/>
							</p>
							<p>
							<br>
							<div class="text-center pr-5">
								<input class="btn btn-warning " type="submit" value="edit Course"/>
							</div>
						</form:form>
			</div>
			<div class="col">
				<form:errors path="course.*" element="p" cssClass="alert alert-danger"/>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</body>
</html>