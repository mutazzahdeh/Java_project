<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
     <%@ page isErrorPage="true" %>  
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
 <div class="col-md-6 mx-auto p-0">
        <div class="card">
            <div class="login-box">
                <div class="login-snip">
                  <select id="pass" class="input" >
                <c:forEach items="${city}" var="c">
     							<option value="${c}"><c:out value="${c.name}"/> </option>
        						</c:forEach>
								</select>
                 <table>
                    <thead>
                            <th>Position</th>
                            <th>Direction</th>
                            <th>status</th>
                     </thead>        
                     <tbody>
                     <tr>
                     <c:forEach items="${trip}" var="c">
     							<td><c:out value="${c.postion}"/> </td>
     							<td><c:out value="${c.direction}"/></td>
     							<td><c:out value="${c.cost}"/></td>
     							<td><c:out value="${c.time}"/></td>
        						</c:forEach>
                     </tr>
                         
                     </tbody>
                   </table>        
                        </div>
                    </div>
                </div>
            </div>
 
</body>
</html>