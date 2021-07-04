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
</style>
<body>

<div class="row">
<img alt="lol" src="img/back.jpg">

    <div class="col-md-6 mx-auto p-0">
        <div class="card">
            <div class="login-box">
                <div class="login-snip">
               
                 <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Login</label> <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab"></label>
                    <div class="login-space">
                        <div class="login">
                            <div class="group"> <label for="user" class="label">Username</label> <input id="user" type="text" class="input" placeholder="Enter your username"> </div>
                            <div class="group"> <label for="pass" class="label">Password</label> <input id="pass" type="password" class="input" data-type="password" placeholder="Enter your password"> </div>
                            <div class="group"> <input id="check" type="checkbox" class="check" checked> <label for="check"><span class="icon"></span> Keep me Signed in</label> </div>
                            <div class="group"> <input type="submit" class="button" value="Sign In"> </div>
                            <div class="hr"></div>
                            <div class="foot"> <a href="#">Forgot Password?</a> </div>
                        </div>
                     
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
