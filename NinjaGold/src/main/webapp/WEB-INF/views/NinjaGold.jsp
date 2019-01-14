<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="assets/css/ninjaStyle.css">
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<title>Ninja Gold</title>
</head>
<body>
       <nav class="navbar navbar-dark bg-dark">
                <a class="navbar-brand" href="#">
                  <img src="https://cdn2.codingdojo.com/images/global/coding_dojo_logo_white.png" width="90" height="30" class="d-inline-block align-top" alt="">
                     Ninja Gold
                </a>
              </nav>

        <div class="gold_count_container">
            <p>Gold:</p>
        </div>

        <div class="goldcount"><p><c:out value="${gold}"/></p></div>

        <div class="box_selection_container">
            <form action="getGold" method="post">
                
                <div class="selection_box">
                    <h4>Farm</h4>
                    <p>(earn/lose 1-8 gold)</p>
                    <button type="submit" class="btn btn-outline-dark" name="button" value="farm">Get Gold</button>
                </div>
                <div class="selection_box">
                        <h4>Cave</h4>
                        <p>(earn/lose 1-10 gold)</p>
                        <button type="submit" class="btn btn-outline-dark" name="button" value="cave">Get Gold</button>

                </div>
                <div class="selection_box">
                        <h4>Loot People</h4>
                        <p>(earn/lose 2-5 gold)</p>
                        <button type="submit" class="btn btn-outline-dark" name="button" value="loot">Get Gold</button>

                </div>
                <div class="selection_box">
                        <h4>Casino</h4>
                        <p>(earn/lose 10-100 gold)</p>
                        
                        <button type="submit" class="btn btn-outline-dark" name="button" value="casino">Get Gold</button>

                </div>
            </form>
                
        </div>
        <div class="activity_log">
                <p>Activity log:</p>
                <div id="text_area">
                  <c:forEach items="${logList}" var="event">
                  	<c:out value="${event}" escapeXml="false" />
                  </c:forEach>
                       
                </div>
                <br>
                <br>

                <a href="/reset" class="startover"><button type="button" class="btn btn-outline-danger">Start Over</button></a>

            </div> 

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</body>
</html>