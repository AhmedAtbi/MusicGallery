<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.musicgallery.dao.ArtisteDao"%>
<%@page import="com.musicgallery.dao.CategorieDao"%>
<%@page import="com.musicgallery.metier.Album"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Albums</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
</head>
<body>

	<%@ include file="../header.jsp"%>
	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">Recherche des Album</div>
			<div class="panel-body">

				<form action="album.php" method="GET">
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
				<a href="AjoutAlb.php">Ajouter Album</a>
				<%}%>



				<table class="table table-striped">
					<tr>

						<th>Nom</th>
						
						<th>Artiste</th>
						<th>Categorie</th>



					</tr>
					<c:forEach items="${modelAlbum.albums}" var="album">

						<%
							ArtisteDao metierArt = new ArtisteDao();
						CategorieDao metierCat = new CategorieDao();
						Album resp = (Album) pageContext.getAttribute("album");
						String nom_artiste = metierArt.getArtisteNomById((long) resp.getArtiste());
						String nom_categorie = metierCat.getCategorieNomById((long) resp.getCategorie());
						%>

						<tr>
							<%
								if (!metierLogin.is_role_user(metierUser.getUser(id))) {
							%>
							
							<%}%>
							<td><a href="AlbumDetails.php?id=${album.id}">${album.nom}</a></td>
							
							<td><%=nom_artiste%></td>
							<td><%=nom_categorie%></td>

							<%
								if (!metierLogin.is_role_user(metierUser.getUser(id))) {
							%>
							<td><a
								onclick="return confirm('Confirmation de suppression ?')"
								href="SupprimerAlbum.php?id=${album.id}">Supprimer</a></td>
							<td><a href="ModifierAlbum.php?id=${album.id}">Modifier</a></td>
							<%}%>

						</tr>
					</c:forEach>
				</table>

			</div>
		</div>
	</div>
</body>
</html>