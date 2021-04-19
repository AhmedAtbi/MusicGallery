<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.musicgallery.dao.ArtisteDao"%>
<%@page import="com.musicgallery.dao.CategorieDao"%>
<%@page import="com.musicgallery.dao.AlbumDao"%>
<%@page import="com.musicgallery.metier.Titre"%>
<%@page import="com.musicgallery.metier.Album"%>
<%@page import="java.util.*"%>
<%@page import="com.musicgallery.dao.CategorieDao"%>
<%@page import="com.musicgallery.dao.IFavorisDao"%>
<%@page import="com.musicgallery.dao.FavorisDao"%>


<%@page import="com.musicgallery.metier.Favoris"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Categories</title>
<link rel="stylesheet" type="text/css" href="./css/bootstrap.css" />
<script src="https://use.fontawesome.com/ff1c40cfb5.js"></script>
</head>
<body>

	<%@ include file="../header.jsp"%>
	<div class="container col-md-8 col-md-offset-2">
		<div class="panel panel-primary">

			<div class="panel-body">
				<div class="form-group">




					<div class="form-group">
						<label>Nom :</label> <label>${titre.nom}</label>
					</div>
					<div class="form-group">
						<label>Video :</label>
						<iframe width="560" height="315" src="${titre.url}"
							title="YouTube video player"></iframe>
					</div>
					<div class="form-group">
						<label>Duree :</label> <label>${titre.duree}</label>
					</div>
					<div class="form-group">

						<%
						String isFav = (String)request.getAttribute("isFav").toString();
						
  						 if (isFav.contains("true")){
			
	%>

						
								<div class="form-group"><a href="removeFavoris.php?id=${titre.id}"><i
								class="fa fa-heart" aria-hidden="true"></i></a></div>
						<%} else { %>

				<div class="form-group"><a href="ajoutFavoris.php?id=${titre.id}"><i
								class="fa fa-heart-o" aria-hidden="true"></i></a></div>
						
						<%}%>
					</div>
				</div>

				<!--<div class="form-group">
						<label>Album :</label> <label>${album.nom}</label>
					</div>

					<div class="form-group">
						<label>Artitste :</label> <label>${artiste.nom}</label>
					</div>
					<div class="form-group">
						<label>Categorie :</label> <label>${categorie.nom}</label>
					</div>
					<div class="form-group">
						<a href="AlbumDetails.php?id=${album.id}">Visiter tout l'album</a>
					</div>
					-->

			</div>
		</div>
	</div>

</body>
</html>