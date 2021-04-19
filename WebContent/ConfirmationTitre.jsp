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
	<div class="container col-md-8 col-md-offset-2">
		<div class="panel panel-primary">
			<div class="panel-heading">Confirmation</div>
			<div class="panel-body">
				<div class="form-group">
					<label>ID :</label> <label>${titre.id}</label>

					<div class="form-group">
						<label>Nom :</label> <label>${titre.nom}</label>
					</div>
					<div class="form-group">
						<label>Url :</label> <label>${titre.url}</label>
					</div>
					<div class="form-group">
						<label>Duree :</label> <label>${titre.duree}</label>
					</div>
					<div class="form-group">
						<label>Album :</label> <label>${titre.album}</label>
					</div>

					<div class="form-group">
						<label>Artitste :</label> <label>${titre.artiste}</label>
					</div>
					<div class="form-group">
						<label>Categorie :</label> <label>${titre.categorie}</label>
					</div>
					<div class="form-group">
						<a href="titre.php">Retour</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>