<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<%@page import="com.musicgallery.dao.LoginDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Categories</title>
<link rel="stylesheet" type="text/css" href="./css/bootstrap.css" />
</head>
<body>

	<%@ include file="../header.jsp"%>
	
	
	<%
		
	String email = (String) request.getSession().getAttribute("email");
	UserDao metierUser = new UserDao();
	LoginDao metierLogin = new LoginDao();
	
	int id = metierUser.getUserId(email);
	
	
	if (metierLogin.is_role_user(metierUser.getUser(id))){
		response.sendRedirect("login.jsp");
		return;
	}
	
	%>
	<div class="container col-md-8 col-md-offset-2">
		<div class="panel panel-primary">
			<div class="panel-heading">Ajout d'un artiste</div>
			<div class="panel-body">

				<form action="AjoutArtiste.php" method="post">

					<div class="form-group">
						<label class="control-label">Nom</label> <input type="text"
							name="nom" class="form-control" value="${artiste.nom}" /> <span></span>

					</div>
					<div class="form-group">
						<label class="control-label">Pays</label> <input type="text"
							name="pays" class="form-control" value="${artiste.pays}" /> <span></span>

					</div>

					<div class="form-group">
						<label class="control-label">Image</label> <input type="text"
							name="image" class="form-control" value="${artiste.image}" /> <span></span>

					</div>


					<div>
						<button type="submit" class="btn btn-primary">Ajouter</button>
					</div>

				</form>



			</div>
		</div>
	</div>
</body>
</html>