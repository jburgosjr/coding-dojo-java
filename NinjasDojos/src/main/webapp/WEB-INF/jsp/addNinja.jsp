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
	<title>Add a Ninja</title>
</head>
<body>
	<h4 class="display-4"><u>New Ninja</u></h4>
	<br>
	
	<form:form action="/ninjas/new" method="POST" modelAttribute="ninja">
		<p>
			<form:label cssClass="h4 font-weight-normal" path="dojo">Dojo</form:label>
			<form:select cssClass="custom-select col-4" path="dojo">
				<c:forEach items="${dojos}" var="dojo">
					<form:option value="${dojo}"> ${dojo.name} </form:option>
				</c:forEach>
			</form:select>
		</p>
		<p><form:errors path="firstName" cssClass="alert alert-danger"/></p>
		<p>
			<form:input path="firstName" cssClass="form-control col-4" placeholder="First Name"/>
		</p>
		<p><form:errors path="lastName" cssClass="alert alert-danger"/></p>
		<p>
			<form:input path="lastName" cssClass="form-control col-4" placeholder="Last Name"/>
		</p>
		<p><form:errors path="age" cssClass="alert alert-danger"/></p>
		<p>
			<form:input path="age" cssClass="form-control col-3" placeholder="age"/>
		</p>
		<button type="submit" class="btn btn-info">Create Dojo</button>
		
	</form:form>
		


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</body>
</html>