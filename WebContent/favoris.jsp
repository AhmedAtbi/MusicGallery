<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.musicgallery.dao.ArtisteDao"%>
<%@page import="java.util.*"%>
<%@page import="com.musicgallery.dao.CategorieDao"%>
<%@page import="com.musicgallery.dao.IFavorisDao"%>
<%@page import="com.musicgallery.dao.FavorisDao"%>
<%@page import="com.musicgallery.dao.AlbumDao"%>
<%@page import="com.musicgallery.metier.Titre"%>
<%@page import="com.musicgallery.metier.Album"%>
<%@page import="com.musicgallery.metier.Favoris"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Titres</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<script src="https://use.fontawesome.com/ff1c40cfb5.js"></script>
</head>
<body>

	<%@ include file="../header.jsp"%>
	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">Recherche des Titre</div>
			<div class="panel-body">

				<form action="titre.php" method="GET">
					<label>Rechercher</label> <input type="text" name="motCle" />
					<button type="submit">Chercher</button>
				</form>

				<%@page import="com.musicgallery.dao.LoginDao"%>
				<%
					String email = (String) request.getSession().getAttribute("email");
				UserDao metierUser = new UserDao();
				LoginDao metierLogin = new LoginDao();
				
				    
				    session = request.getSession();
				 

				int id = metierUser.getUserId(email);

				if (!metierLogin.is_role_user(metierUser.getUser(id))) {
				%>
				<a href="AjoutTit.php">Ajouter Titre</a>
				<%}%>
				<table class="table table-striped">
					<tr>
					  <%
    IFavorisDao metierFavoris = new FavorisDao();
    int id_user = (int)session.getAttribute("id");
    session = request.getSession();
    boolean favorit=false;
     List<Favoris> favorites = metierFavoris.getFavoris();
     for (Favoris favoris : favorites) {
			String id_fav_titre = favoris.getId_titre()+"";
			String id_fav_user = favoris.getId_user()+"";
			if(id_fav_user.equals(id_user+"")){
				favorit=true;

			}}
     
     %> 
		

						<th>Artiste</th>
						<th>Nom</th>
						<th>Duree</th>
						

						<th>Favoris</th>


					</tr>
					<c:forEach items="${modelTitre_Favoris.titres}" var="titre">
			<%
							Titre tit = (Titre) pageContext.getAttribute("titre");
						ArtisteDao metierArt = new ArtisteDao();
						CategorieDao metierCat = new CategorieDao();
						AlbumDao metierAlb = new AlbumDao();

						String nom_artiste = metierArt.getArtisteNomById((long) tit.getArtiste());
						
						%>

						<tr>

							<td><%=nom_artiste%></td>
							<td><a href="TitreDetails.php?id=${titre.id}">${titre.nom}</a></td>
							
							<td>${titre.duree}</td>
							
							
							



							<%
								if (!metierLogin.is_role_user(metierUser.getUser(id))) {
							%>
							<td><a
								onclick="return confirm('Confirmation de suppression ?')"
								href="SupprimerTitre.php?id=${titre.id}">Supprimer</a></td>
							<td><a href="ModifierTitre.php?id=${titre.id}">Modifier</a></td>
							<%}if (favorit==true){%>


 
					
		
							<td><a href="removeFavoris.php?id=${titre.id}"><i
									class="fa fa-heart" aria-hidden="true"></i></a></td>
							<%} else{ %>


							<td><a href="ajoutFavoris.php?id=${titre.id}"><i
									class="fa fa-heart-o" aria-hidden="true"></i></a></td>
							<%}%>





						</tr>
					</c:forEach>

				</table>

			</div>
		</div>
	</div>
</body>
</html>