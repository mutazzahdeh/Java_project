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
                        <c:out value="${error}"/>
             `			  <form action="/logdri" method="post" >
                            <div class="group"> 
                            <label for="user" class="label">Email</label> 
                            
                            <input id="user" type="text" class="input" placeholder="Enter your Email" name="email"/> 
                            </div>
                            <div class="group"> 
                            <label for="pass" class="label" >Password</label> 
                            
                            <input id="pass" type="password" class="input" data-type="password" placeholder="Enter your password" name="password"/> 
                            </div>
                            <div class="group"> 
                            <input type="submit" class="button" value="Sign In"> 
                            </div>
                            </form>
                            <div class="hr"></div>
                            
                        </div>
                        <div class="sign-up-form">
                        <form:form action="/loginasdriver" method="post" modelAttribute="driver">
                            <div class="group"> 
                            <form:label for="user" class="label" path="name">Username</form:label>
                              <form:errors path="name"/>
                             <form:input id="user" type="text" class="input" placeholder="Create your Username" path="name"/>
                              </div>
                            <div class="group"> 
                            <form:label for="pass" class="label" path="email">Email Address</form:label>
                              <form:errors path="email"/>
                             <form:input id="pass" type="text" class="input" placeholder="Enter your email address" path="email"/> 
                             </div>
                             <div class="group"> 
                            <form:label for="pass" class="label" path="phonenum">Email Address</form:label>
                              <form:errors path="phonenum"/>
                             <form:input id="pass" type="text" class="input" placeholder="Enter your email address" path="phonenum"/> 
                             </div>
                            <div class="group"> 
                  
                            <form:label for="pass" class="label" path="car">Car </form:label> 
                            <form:errors path="car"/>
                            <form:input id="pass" type="text" class="input" placeholder="Car" path="car"/> </div>
                            <div class="group"> 
                            <form:label for="pass" class="label" path="Model">Model</form:label> 
                             <form:errors path="Model"/>
                            <form:input id="pass" type="number" class="input" placeholder="Model" path="Model"/> 
                            </div>
                            <div class="group"> 
                            <form:label for="pass" class="label" path="city">City</form:label>
                              <form:errors path="city"/>
                             
                             <form:select id="pass" class="input"  path="city">
   		
   								<c:forEach items="${city}" var="c">
     							<form:option value="${c}"><c:out value="${c.name}"/> </form:option>
        						</c:forEach>
								</form:select>
                             
                             </div>
                            <div class="group"> 
                            <form:label for="pass" class="label" path="password">Password</form:label> 
                              <form:errors path="password"/>
                            <form:input id="pass" type="password" class="input" data-type="password" placeholder="Create your password" path="password"/> 
                            </div>
                            <div class="group"> 
                            <form:label for="pass" class="label" path="passwordConfirmation">Repeat Password</form:label> 
                              <form:errors path="passwordConfirmation"/>
                            <form:input id="pass" type="password" class="input" data-type="password" placeholder="Repeat your password" path="passwordConfirmation"/> 
                            </div>
                            
                            
                            <div class="group"> 
                            <input type="submit" class="button" value="Sign Up"> 
                            </div>
                            <div class="hr"></div>
                            <div class="foot"> <label for="tab-1">Already Member?</label> </div>
                            </form:form>    
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>