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
<link rel="stylesheet" href="/css/userlog.css">
</head>
<body>

<div class="row">

    <div class="col-md-6 mx-auto p-0">
        <div class="card">
            <div class="login-box">
                <div class="login-snip">
                <h2>Driver</h2>
                 <input id="tab-1" type="radio" name="tab" class="sign-in" checked>
                 <label for="tab-1" class="tab">Login</label> <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Sign Up</label>
                    <div class="login-space">
                        <div class="login">
                         
                             
                             </div>
                            <div class="group"> 
                            <input type="submit" class="button" value="Sign In"> 
                            </div>
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