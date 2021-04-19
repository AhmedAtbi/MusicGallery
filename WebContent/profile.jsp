<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="com.musicgallery.dao.LoginDao"%>
	<%@page import="com.musicgallery.dao.UserDao"%>
	<%@page import="com.musicgallery.metier.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
<link rel="stylesheet" type="text/css" href="./css/bootstrap.css" />
</head>
<body>



	<div class="container col-md-4 col-md-offset-2">
		<div class="panel panel-primary">
			<div class="panel-heading">Modifier user</div>
			<div class="panel-body">

				<form action="EditUser.php" method="post">



					<div class="form-group">
						<label class="control-label">Email</label> <input type="text"
							name="email" class="form-control" value="${user.email}" /> <label
							class="control-label">Password</label> <input type="text"
							name="password" class="form-control" value="${user.password}" />

						<span></span> <label class="control-label">Nom</label> <input
							type="text" name="nom" class="form-control" value="${user.nom}" />

					</div>
<%
		
	int id = (int)request.getSession().getAttribute("id");
	UserDao metierUser = new UserDao();
	LoginDao metierLogin = new LoginDao();
	
	User user = metierUser.getUser(id);
	
	
	if (user.getSex().toLowerCase().equals("homme")){%>
		
	

					Homme<input type="radio" name="sex" class="form-control"
						value="homme" checked/>
						Femme<input type="radio" name="sex"
						class="form-control" value="homme" /> <span></span>
						<%} else{%>	Homme<input type="radio" name="sex" class="form-control"
						value="femme" />
						Femme<input type="radio" name="sex"
						class="form-control" value="femme" checked/> <span></span> <%} %>


					<div class="form-group">
						<label class="control-label">Date Of Birth</label> <input
							type="text" name="date_naissance" class="form-control"
							value="${user.date_naissance}" /> <span></span>

					</div>


					<div>
						<button type="submit" class="btn btn-primary">Register</button>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>