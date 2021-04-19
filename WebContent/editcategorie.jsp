<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Categories</title>
<link rel="stylesheet" type="text/css" href="./css/bootstrap.css" />
</head>
<body>

	<%@ include file="../header.jsp"%>
	<%@page import="com.musicgallery.dao.LoginDao"%>
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
			<div class="panel-heading">Modifier categorie</div>
			<div class="panel-body">

				<form action="EditCategorie.php" method="post">

					<div class="form-group">
						<label class="control-label">ID</label> <input type="text"
							name="id" class="form-control" value="${categorie.id}" /> <span></span>

						<div class="form-group">
							<label class="control-label">Nom</label> <input type="text"
								name="nom" class="form-control" value="${categorie.nom}" /> <span></span>

						</div>
						<div class="form-group">
							<label class="control-label">Description</label> <input
								type="text" name="description" class="form-control"
								value="${categorie.description}" /> <span></span>

						</div>


						<div>
							<button type="submit" class="btn btn-primary">Edit</button>
						</div>
					</div>
				</form>




			</div>
		</div>
	</div>
</body>
</html>