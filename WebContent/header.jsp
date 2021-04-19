<link rel="stylesheet" type="text/css" href="./css/bootstrap.css" />
<%@page import="com.musicgallery.dao.UserDao"%>
<div class="navbar">
	<ul>
		<li><a href="categorie.jsp">Home</a></li>
	</ul>
	<ul>
		<li><a href="categorie.php"> Categorie</a></li>
	</ul>
	<ul>
		<li><a href="artiste.php"> Artiste</a></li>
	</ul>
	<ul>
		<li><a href="album.php"> Album</a></li>
	</ul>
	<ul>
		<li><a href="titre.php"> Titre</a></li>
	</ul>

	<%
		if (request.getSession().getAttribute("email") == null) {
	%>
	<ul>
		<li><a href="login.jsp"> Login</a></li>
	</ul>
	<ul>
		<li><a href="register.jsp"> Register</a></li>
	</ul>


	<%
		} else {
	String email = (String) request.getSession().getAttribute("email");
	UserDao metierUser = new UserDao();
	int id = metierUser.getUserId(email);
	session.setAttribute("id", id);
	%>
	<ul>
		<li><a href="ModifierUser.php?id=" <%=id%>>${email} </a></li>
	</ul>
	
	<ul>
		<li><a href="favoris.php"> Favoris</a></li>
	</ul>

	<ul>
		<li><a href="logout.php">Logout</a></li>
	</ul>
	<%
		}
	%>




</div>