<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
     <%@ page isErrorPage="true" %>  
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>

<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<style>
body{
background-image: url("img/deadpool.jpg");
}
</style>
<body>

<h1> you taxi orderd</h1>

<a href="/logout" class="button">logout</a>


<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">from </th>
      <th scope="col">to </th>
      <th scope="col">trip name</th>
      <th scope="col">status</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${trip}" var="t">
    <tr>
      
      <td>${t.postion}</td>
      <td>${t.direction}</td>
      <td>${t.tripName}</td>
      <td>Watting</td>
      
    </tr>
    </c:forEach>
 
  </tbody>
</table>

</body>
</html>