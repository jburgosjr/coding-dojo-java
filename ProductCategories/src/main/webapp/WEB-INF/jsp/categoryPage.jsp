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
	<title>Product Page</title>
</head>
<body>
<br>
	<div class="container text-center border-bottom border-dark ">
		<h1 class="display-1"><small> <c:out value="${category.name}"/> </small></h1>
	</div>
	<br>
	<div class="container">
		<div class="row">
			<div class="col">
				<h4 class="display-4"><small><u>Products</u></small></h4>
				<ul class="list-group">
					<c:forEach items="${category.products}" var="product">
						<li class="list-group-item"> -  ${product.name} </li>
					</c:forEach> 
				 
				</ul>
			</div>
			<div class="col">
				<form:form action="/categories/${category.id}" method="POST" modelAttribute="categoryProduct">
					 <p><u>Add a Category</u></p> 
					<form:select cssClass="custom-select col-6" path="product">
						<c:forEach items="${products}" var="prod">
							<form:option value="${prod.id}"> ${prod.name} </form:option>
						</c:forEach>
					</form:select>
					<button type="submit" class="btn btn-info btn-sm">Add to Category</button>
				</form:form>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</body>
</html>