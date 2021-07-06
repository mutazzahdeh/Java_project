<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
     <%@ page isErrorPage="true" %>  
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" href="/css/userlog.css">
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

<div class="row">


    <div class="col-md-6 mx-auto p-0">
    
        <div class="card">
            <div class="login-box">
                <div class="login-snip">
                
                
                
               
                 <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab"></label> <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab"></label>
                    <div class="login-space">
                    
                        <div class="login">
                        
                       
                        <form action="/confirm/${trip.id}/edit/${user}" method="post" >
                        
                         <div class="group">
                        <label for="user" class="label" cost:</label>
                        <input type="number" class="input" name="cost" required="required " />
                     
                        </div>
                        
                        
                         <div class="group">
                        <label for="user" class="label" >Time</label>
                        <input class="input" type="number"name="time" required="required " />
                       
                        </div>
                    
                        
                        <div class="group">
                        <input type="submit" class="button" value="Confirm Requist">
                        </div>
                        
                        </form>
                        
                   <a href="/show" class="button">Show</a>
                   <a href="/logout" class="button">logout</a>
                   
                        </div>
                     
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
