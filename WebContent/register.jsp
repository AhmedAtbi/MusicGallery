<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel="stylesheet" type="text/css" href="./css/bootstrap.css"/>
</head>
<body>


<%@ include file="../header.jsp"%>
<% session=request.getSession(false);  
if(session.getAttribute("email")==null) 
{%>

<div class="container col-md-4 col-md-offset-2">
<div class="panel panel-primary">
<div class="panel-heading">Register</div>
<div class="panel-body">

<form action="Register.php" method="post">

<%if (request.getAttribute("email_exist")!=null) {%>

<div class="form-group">
<%out.println(request.getAttribute("email_exist"));} else{%>

<label class="control-label">Email</label><%} %>

<input type="text" name="email" class="form-control" value="${user.email}"/>
<label class="control-label">Password</label>

<input type="text" name="password" class="form-control" value="${user.password}"/>  
<label class="control-label">Confirm Password</label>

<input type="text" name="confirmpass" class="form-control"/>
<span></span>
<label class="control-label">Nom</label>
<input type="text" name="nom" class="form-control" value="${user.nom}"/>

</div>


Homme<input type="radio" name="sex" class="form-control" value="homme"/> Femme<input type="radio" name="sex" class="form-control" value="Femme"/>
 
<span></span>



<div class="form-group">
<label class="control-label">Date Of Birth</label>
<input type="text" name="date_naissance" class="form-control" value="${user.date_naissance}"/> 
<span></span>

</div>


<div>
<button type="submit" class="btn btn-primary">Register</button>
</div>
</form>
</div>
</div>
</div>
 <%}else  {
 
 response.sendRedirect("index.jsp");
 
 } %>
</body>
</html>