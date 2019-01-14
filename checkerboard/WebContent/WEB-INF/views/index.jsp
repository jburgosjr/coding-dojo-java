<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="assets/css/CheckBoardStylecss.css">
	<title>CheckerBoard</title>
</head>
<body>
	<%int width = Integer.parseInt(request.getParameter("width")); %>
	<%int height = Integer.parseInt(request.getParameter("height")); %>
	<h1>CheckerBoard: <%= width %>w X <%= height %>h </h1>
	
	<table>
		<% for(int i =0; i < width; i++ ){ %>
			<tr>
				<% for(int j = 0; j < height; j++){ %>
				<% int result = ((i+j)%2)+1; %>
					<td><div class=box<%= result %>></div></td>
				<% } %>
			<tr>
				
		<% } %>
	</table>
		
</body>
</html>