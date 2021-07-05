
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/userlog.css">
</head>
<style>
select {
	color:black;
}
</style>
<body>

<div class="row">

    <div class="col-md-6 mx-auto p-0">
        <div class="card">
            <div class="login-box">
                <div class="login-snip">
                <h2>USER</h2>
                 <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Login</label> <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Sign Up</label>
                    <div class="login-space">
                        <div class="login">
                        <c:out value="${error}"/>
                        <form:form action="/login" method="post" modelAttribute="userlog">
                        
                        
                        <div class="group">
                        <form:label for="user" class="label" path="email">Email:</form:label>
                        <form:input id="pass"  class="input"  path="email"/> 
                        <form:errors path="email"/>
                        </div>
                        
                        
                     
                        
                        <div class="group">
                        <form:label for="user" class="label" path="password">password</form:label>
                        <form:input id="pass" type="password" class="input" data-type="password" path="password"/>
                        <form:errors path="password"/>
                        </div>
                        
                       
                        
                      
                        
                        <div class="group"> <input type="submit" class="button" value="Sign In"> </div>
                        
                        </form:form>
                      
                    
                        </div>
                        <div class="sign-up-form">
                        <form:form action="/loginasuser" method="post" modelAttribute="userlog" >
                        
                        <div class="group">
                        <form:label for="user" class="label" path="name">name</form:label>
                        <form:input id="pass"  class="input"  path="name"/>
                        <form:errors path="name"/>
                        </div>
                        <div class="group">
                        <form:label for="user" class="label" path="email">email</form:label>
                        <form:input id="pass" type="email" class="input"  path="email"/>
                        <form:errors path="email"/>
                        </div>
                        
                        
                        <div class="group">
                        <form:label for="user" class="label" path="password">password</form:label>
                        <form:input id="pass" type="password" class="input" data-type="password" path="password"/>
                        <form:errors path="password"/>
                        </div>
                        
                        <div class="group">
                        <form:label for="user" class="label" path="passwordConfirmation">passwordConfirmation</form:label>
                        <form:input id="pass" type="password" class="input" data-type="password" path="passwordConfirmation"/>
                        <form:errors path="passwordConfirmation"/>
                        </div>
                        
                         <div class="group">
                        <form:label for="user" class="label" path="phonenum">phone number:</form:label>
                        <form:input id="pass"  class="input"  path="phonenum"/>
                        <form:errors path="phonenum"/>
                        </div>
                     
                        <form:select id="pass" class="input"  path="city">
   		
   								<c:forEach items="${city}" var="c">
     							<form:option value="${c}"><c:out value="${c.name}"/> </form:option>
        						</c:forEach>
								</form:select>
								
								<div class="group"> <input type="submit" class="button" value="Sign Up"> </div>
                            <div class="hr"></div>
								
                        </form:form>
        
                             </div>
                            
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>