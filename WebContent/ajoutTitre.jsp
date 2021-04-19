<%@page import="java.net.http.HttpResponse"%>
<%@page import="com.musicgallery.dao.SingletonConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>
<%@page import="com.musicgallery.dao.LoginDao"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajouter un Album</title>

<link rel="stylesheet" type="text/css" href="./css/bootstrap.css" />
<style type="text/css">
</style>
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
			<div class="panel-heading">Ajout d'un titre</div>
			<div class="panel-body">
				<form action="AjoutTitre.php" method="post">
					<div class="form-group">
						<label class="control-label">Nom</label> <input type="text"
							name="nom" class="form-control" value="${titre.nom}" /> <span></span>

					</div>
					<div class="form-group">
						<label class="control-label">Url</label> <input type="text"
							name="url" class="form-control" value="${titre.url}" /> <span></span>

					</div>
					<div class="form-group">
						<label class="control-label">Duree</label> <input type="text"
							name="duree" class="form-control" value="${titre.duree}" /> <span></span>

					</div>




					<!-- Changing dropdown value will call javascript method populateCustomerId() -->
					<label class="control-label">Album</label> <select name="id_album"
						id="id_album" onchange="populatealbumId();">
						<c:forEach items="${modelAlbum.albums}" var="album">
							<!-- rs.getString(1) would be your customerId set as option value -->
							<option value="${album.id}">${album.nom}</option>
						</c:forEach>
					</select>

					<div>
						<button type="submit" class="btn btn-primary">Ajouter</button>
					</div>

				</form>


				<script type="text/javascript">
					function populateAlbumId() {
						var selectBox = document.getElementById('id_album');

						/* selected value of dropdown */
						var selectedAlbumId = id_album.options[id_album.selectedIndex].value;

						/* selected value set to input field */
						document.getElementById('id_album').value = selectedAlbumId;
					}
				</script>

			</div>
		</div>
	</div>

</body>
</html>