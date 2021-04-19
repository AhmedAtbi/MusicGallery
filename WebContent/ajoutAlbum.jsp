<%@page import="com.musicgallery.dao.SingletonConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>
<%@page import="com.musicgallery.dao.LoginDao"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajouter un Album</title>
<%@ include file="../header.jsp"%>
<link rel="stylesheet" type="text/css" href="./css/bootstrap.css" />
<style type="text/css">
</style>
</head>
<body>
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
			<div class="panel-heading">Ajout d'un album</div>
			<div class="panel-body">
				<form action="AjoutAlbum.php" method="post">
					<div class="form-group">
						<label class="control-label">Nom</label> <input type="text"
							name="nom" class="form-control" value="${album.nom}" /> <span></span>

					</div>
					<div class="form-group">
						<label class="control-label">Image</label> <input type="text"
							name="image" class="form-control" value="${album.image}" /> <span></span>

					</div>
				



					<!-- Changing dropdown value will call javascript method populateCustomerId() -->
					<select name="id_artiste" id="id_artiste"
						onchange="populateArtisteId();">
						
						<c:forEach items="${modelArtiste.artistes}" var="artiste">
						<!-- rs.getString(1) would be your customerId set as option value -->
						<option value="${artiste.id}">${artiste.nom}</option>
						</c:forEach>
					</select>



				
					<!-- Changing dropdown value will call javascript method populateCustomerId() -->
					<select name="id_categorie" id="id_categorie"
						onchange="populateCategorieId();">
						<c:forEach items="${modelCategorie.categories}" var="categorie">
						<!-- rs.getString(1) would be your customerId set as option value -->
						<option value="${categorie.id}">${categorie.nom}</option>
						</c:forEach>
					</select>

					<div>
						<button type="submit" class="btn btn-primary">Ajouter</button>
					</div>

				</form>


				<script type="text/javascript">
        function populateArtisteId(){
            var selectBox = document.getElementById('id_artiste');

            /* selected value of dropdown */
            var selectedCategorieId = selectBox1.options[id_artiste.selectedIndex].value;

            /* selected value set to input field */
            document.getElementById('categorieId').value = selectedCategorieId; 
        }</script>
				<script type="text/javascript">
        function populateCategorieId(){
            var selectBox = document.getElementById('id_categrie');

            /* selected value of dropdown */
            var selectedCategorieId = selectBox.options[id_categrie.selectedIndex].value;

            /* selected value set to input field */
            document.getElementById('categorieId').value = selectedCategorieId; 
        }</script>
			</div>
		</div>
	</div>

</body>
</html>