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
					<label>ID :</label> <label>${artiste.id}</label>

					<div class="form-group">
						<label>Nom :</label> <label>${artiste.nom}</label>
					</div>
					<div class="form-group">
						<label>Pays :</label> <label>${artiste.pays}</label>
					</div>
					<div class="form-group">
						<label>Image :</label> <label>${artiste.image}</label>
					</div>
					<div class="form-group">
						<a href="artiste.php">Retour</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>