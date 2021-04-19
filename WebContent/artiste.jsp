<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Artistes</title>
<link rel="stylesheet" type="text/css" href="./css/bootstrap.css" />
</head>
<body>

	<%@ include file="../header.jsp"%>
	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">Recherche des Artistes</div>
			<div class="panel-body">

				<form action="artiste.php" method="GET">
					<label>Rechercher</label> <input type="text" name="motCle" />
					<button type="submit">Chercher</button>
					<br><br><br>
				</form>

				<%@page import="com.musicgallery.dao.LoginDao"%>
				<%
					String email = (String) request.getSession().getAttribute("email");
				UserDao metierUser = new UserDao();
				LoginDao metierLogin = new LoginDao();

				int id =  metierUser.getUserId(email);

				if (!metierLogin.is_role_user(metierUser.getUser(id))) {
				%>
				<a href="AjoutArt.php">Ajouter Artiste</a>
				<%}%>

				<table class="table table-striped">
					<tr>
						<th>ID</th>
						<th>Nom</th>
						<th>Pays</th>
						


					</tr>
					<c:forEach items="${modelArt.artistes}" var="art">

						<tr>
							<td>${art.id}</td>
							<td><a href="ArtisteDetails.php?id=${art.id}">${art.nom}</a></td>
							<td>${art.pays}</td>
							

							<%
								if (!metierLogin.is_role_user(metierUser.getUser(id))) {
							%>
							<td><a onclick="return confirm('Confirmation de suppression ?')" href="SupprimerArt.php?id=${art.id}">Supprimer</a></td>
							<td><a href="ModifierArt.php?id=${art.id}">Modifier</a></td>
							<%}%>

						</tr>
					</c:forEach>
				</table>

			</div>
		</div>
	</div>
</body>
</html>