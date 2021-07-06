<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<meta charset="windows-1256">
<title>showing details </title>
<style>

body {
background-image: url("deadpool.jpg");
color:red;
background-color: lightblue;
}
</style>

</head>


<body>





<table class="table table-bordered table-dark">
  <thead>
    <tr>
      <th scope="col">trip name</th>
      <th scope="col">postion</th>
      <th scope="col">direction</th>
      <th scope="col">cost</th>
      <th scope="col">time</th>
      
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>${show.tripName}</td>
      <td>${show.postion}</td>
      <td>${show.direction}</td>
      <td>${show.cost} shekel</td>
      <td>${show.time} minutes</td>
         
    </tr>
  
  
  </tbody>
</table>

<a href="/logout">logout</a>

<form action="/show">
<input type="submit" value="Back">
</form>

</body>
</html>