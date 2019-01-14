<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="assets/css/homeStyle.css">
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<title>Dojo Survey</title>
</head>
<body>
	<div class=container>
		<form action="process" method="post">
			<h4 class="display-4"><small><u>Dojo Survey</u></small></h4>
			<br>
			<div class="input-group mb-3">
	  			<div class="input-group-prepend">
	    			<span class="input-group-text" id="basic-addon1">Your Name</span>
	  			</div>
	  			<input type="text" class="form-control" name="name">
			</div>
			
			<div class="input-group mb-3">
			  <div class="input-group-prepend">
			    	<label class="input-group-text" for="inputGroupSelect01">Dojo Location</label>
			  </div>
			  <select class="custom-select" id="inputGroupSelect01" name="location">
			    	<option value="Burbank">Burbank</option>
			    	<option value="San Jose">San Jose</option>
			  </select>
			</div>
			
			<div class="input-group mb-3">
			  <div class="input-group-prepend">
			    	<label class="input-group-text" for="inputGroupSelect01">Favorite Language</label>
			  </div>
			  <select class="custom-select" id="inputGroupSelect01" name="language">
			    	<option value="Python">Python</option>
			    	<option value="Java">Java</option>
			  </select>
			</div>
			
			<div class="input-group">
			  <div class="input-group-prepend">
			   	 <span class="input-group-text">Comment (Optional)</span>
			  </div>
			  <textarea class="form-control" aria-label="With textarea" name="comment"></textarea>
			</div>
			<br>
			<button type="submit" class="btn btn-outline-dark">Submit</button>
		</form>
		
	</div>


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</body>
</html>