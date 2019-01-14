<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="assets/css/petStyle.css">
<title>Pets!</title>
</head>
<body>
	<h3>Make a dog!</h3>
	<div class="dogbox">
		
		<form action="dogProcess" method=get >
			<h5>Dog</h5>
			<input name="name" placeholder="Name">
			<br>
			<input name="breed" placeholder="Breed">
			<br>
			<input name="weight" placeholder="Weight (lb)">
			<br>
			<button type="submit">Make a Dog!</button>
			 
		</form>
	</div>
	
	<h3>Make a cat!</h3>
	<div class="dogbox">
		
		<form action="catProcess" method=get >
			<h5>Dog</h5>
			<input name="name" placeholder="Name">
			<br>
			<input name="breed" placeholder="Breed">
			<br>
			<input name="weight" placeholder="Weight (lb)">
			<br>
			<button type="submit">Make a cat!</button>
			 
		</form>
	</div>

</body>
</html>