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
	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">Recherche des categories</div>
			<div class="panel-body">

				<form action="categorie.php" method="GET">
					<label>Rechercher</label> <input type="text" name="motCle" />
					<button type="submit">Chercher</button>
				</form>


				<%@page import="com.musicgallery.dao.LoginDao"%>
				<%
					String email = (String) request.getSession().getAttribute("email");
				UserDao metierUser = new UserDao();
				LoginDao metierLogin = new LoginDao();

				int id = metierUser.getUserId(email);

				if (!metierLogin.is_role_user(metierUser.getUser(id))) {
				%>
				<a href="AjoutCat.php">Ajouter Categorie</a>
				<%}%>

				
				<table class="table table-striped">
					<tr>
						
						<th>Nom</th>
						<th>Description</th>


					</tr>
					<c:forEach items="${model.categories}" var="cat">

						<tr>
							
							<td><a href="CategorieDetails.php?id=${cat.id}">${cat.nom}</a></td>
							<td>${cat.description}</td>
								
				<%
					

				if (!metierLogin.is_role_user(metierUser.getUser(id))) {
				%>
				<td><a
								onclick="return confirm('Confirmation de suppression ?')"
								href="SupprimerCat.php?id=${cat.id}">Supprimer</a></td>
							<td><a href="ModifierCat.php?id=${cat.id}">Modifier</a></td>
				<%}%>
							
							
						</tr>
					</c:forEach>
				</table>

			</div>
		</div>
	</div>
</body>
</html>