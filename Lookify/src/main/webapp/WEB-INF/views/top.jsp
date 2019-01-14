<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="assets/css/.css">
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<title>Top Ten</title>
</head>
<body class="bg-secondary">

		<nav class="navbar navbar-dark bg-light pt-0 pb-0">
                        <a class="navbar-brand" href="/dashboard">
                                <img src="/images/lookify_main.png" width="100" height="52" class="d-inline-block align-top " alt="">
                        </a>
                        <div class="right_align_nav">
                                <span class="navbar-text " style="color: purple;">
                                        Build 1.0
                                </span>
                        </div>
       </nav>
       
       <div class="container bg-light text-center mt-5">
       		<h1><u>Top Ten Songs</u></h1>
       		<ol>
       			<c:forEach items="${top}" var="top">
	       			<li><h5>${top.rating}- <a href="/songs/${top.id }">${top.name}</a>-${top.artist}</h5></li>	
	       		</c:forEach>
       		</ol>
	       		
       </div>


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</body>
</html>