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
                        
                       
                        <form:form action="/gettaxi" method="post" modelAttribute="trip">
                        
                         <div class="group">
                        <form:label for="user" class="label" path="tripName">trip Name:</form:label>
                        <form:input class="input" path="tripName" required="required " />
                        <form:errors path="tripName"/>
                        </div>
                        
                        
                         <div class="group">
                        <form:label for="user" class="label" path="postion">Postion</form:label>
                        <form:input class="input" path="postion" required="required " />
                        <form:errors path="postion"/>
                        </div>
                        
                        <div class="group">
                        <form:label for="user" class="label" path="direction">direction</form:label>
                        <form:input class="input" path="direction" required="required " />
                        <form:errors path="direction"/>
                        </div>
                        
                        <div class="group">
                        <input type="submit" class="button" value="Ask Taxi">
                        </div>
                        
                        </form:form>
                        
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
