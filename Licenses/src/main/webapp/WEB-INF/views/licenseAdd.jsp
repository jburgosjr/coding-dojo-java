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
	<title>Add License</title>
</head>
<body class="pl-5 pt-3">
	<h4 class="display-4"><u>New License</u></h4>
	<br>
	
	<form:form action="/license/new" method="POST" modelAttribute="license">
	
		<p>
			<form:label cssClass="h4 font-weight-normal" path="person">Person</form:label>
			<form:select vcssClass="custom-select col-4" path="person">
				<c:forEach items="${persons}" var="person" >
					<form:option value="${person}"> ${person.firstName} ${person.lastName} </form:option>
				</c:forEach>
			
			</form:select>
		</p>
		<p><form:errors path="state" cssClass="alert alert-danger" /></p>
		<p>
			<form:label cssClass="h4 font-weight-normal" path="state">State</form:label>
			<form:input cssClass="form-control col-2" path="state"/>
		</p>
		<p><form:errors path="expiration_date" cssClass="alert alert-danger" /></p>
		<p>
			<form:label cssClass="h4 font-weight-normal" path="expiration_date">Experiation Date</form:label>
			<form:input type="date" cssClass="form-control col-3" path="expiration_date"/>
		</p>
			<input type=hidden value=0 name=number>

		
		<button type="submit" class="btn btn-info">Create</button>
	</form:form>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</body>
</html>