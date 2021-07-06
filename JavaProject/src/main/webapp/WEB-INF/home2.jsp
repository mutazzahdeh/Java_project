<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" href="/css/userlog.css"><link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	

</head>
<style>
img{
display: inline;
}
.row{
height: 1080px;
width: 1920px;
}
body{

background-image:url("img/back.jpg");
}
</style>
<body>
	<div class="container">
		<div class="header">
			<h1 class="display-4 logged-in">Welcome, <c:out value="${user.name}"/></h1>
			<a href="/logout">Logout</a>
		</div>
		<h4>Trips:</h4>

		<table class="table table-dark">
		  <thead class="thead-dark">
		    <tr>
		    <th scope="col">NameTrip</th>
		      <th scope="col">From</th>
		      <th scope="col">Direction</th>
		      <th scope="col">Confirm</th>
		     
		       
		    </tr>
		  </thead>
		  <tbody>
			  <c:forEach var="trip" items="${trips }">
			  <c:forEach var="users" items="${trip.user }">
			  <c:choose>
			  <c:when test="${users.city==user.city }">
			    <tr>
			      <th><c:out value="${trip.tripName}"/></th>
			      <td><c:out value="${trip.postion}"/></td>
			      <td><c:out value="${trip.direction}"/>/<c:out value="${courser.capacity}"/></td>
			     <td>  
			     <c:choose>
			      <c:when test="${trip.driver.size()==0 }">
			      <a href="/confirm/${trip.id}"> confirm</a>
			      </c:when>
			      <c:otherwise>
			      <p>it take from another taksi</p>
			      </c:otherwise>
		
			      </c:choose>
			       </td>

			      <td>
			      </c:when>
			      </c:choose>
		      		
		      </c:forEach>	
	    	  </c:forEach>
		  </tbody>
		</table>




   

</body>
</html>
