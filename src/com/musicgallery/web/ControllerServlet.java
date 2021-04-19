package com.musicgallery.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.musicgallery.dao.AlbumDao;
import com.musicgallery.dao.ArtisteDao;
import com.musicgallery.dao.CategorieDao;
import com.musicgallery.dao.FavorisDao;
import com.musicgallery.dao.IAlbumDao;
import com.musicgallery.dao.IArtisteDao;
import com.musicgallery.dao.ICategorieDao;
import com.musicgallery.dao.IFavorisDao;
import com.musicgallery.dao.ILoginDao;
import com.musicgallery.dao.ITitreDao;
import com.musicgallery.dao.IUserDao;
import com.musicgallery.dao.LoginDao;
import com.musicgallery.dao.TitreDao;
import com.musicgallery.dao.UserDao;
import com.musicgallery.metier.Album;
import com.musicgallery.metier.Artiste;
import com.musicgallery.metier.Categorie;
import com.musicgallery.metier.Favoris;
import com.musicgallery.metier.Titre;
import com.musicgallery.metier.User;


/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet(name="cs",urlPatterns= {"*.php"})
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICategorieDao metierCategorie;
	private IArtisteDao metierArtiste;
	private ILoginDao metierLogin;
	private IUserDao metierUser;
	private IAlbumDao metierAlbum;
	private ITitreDao metierTitre;
	private IFavorisDao metierFavoris;
	boolean fav = false;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public void init() throws ServletException {
		metierCategorie = new CategorieDao();
		metierArtiste = new ArtisteDao();
		metierLogin = new LoginDao();
		metierUser = new UserDao();
		metierAlbum = new AlbumDao();
		metierTitre = new TitreDao();
		metierFavoris = new FavorisDao();

	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = request.getServletPath();

		// CONTROLLEUR CATEGORIE
		//********************************************************************************************************
		if (path.equals("/categorie.php")) {
			CategorieModel modelCat = new CategorieModel();
			List<Categorie> categories = metierCategorie.categorieAffiche();
			modelCat.setCategories(categories);
			request.setAttribute("model", modelCat);
			request.getRequestDispatcher("categorie.jsp").forward(request, response);
		}
		else if (path.equals("/cherchercat.php")) {
			String motCle = request.getParameter("motCle");
			CategorieModel modelCat = new CategorieModel();
			modelCat.setMotCle(motCle);
			List<Categorie> categories = metierCategorie.categorieParMotCle("%"+motCle+"%");
			modelCat.setCategories(categories);
			request.setAttribute("model", modelCat);
			request.getRequestDispatcher("categorie.jsp").forward(request, response);
		}
		else if (path.equals("/AjoutCat.php")) {
			request.setAttribute("categorie", new Categorie());
			request.getRequestDispatcher("categorieajout.jsp").forward(request,response);
		}
		else if (path.equals("/AjoutCategorie.php") && request.getMethod().equals("POST")) {
			String nom = request.getParameter("nom");
			String description = request.getParameter("description");
			Categorie categorie = metierCategorie.ajoutCategorie(new Categorie(nom,description));
			request.setAttribute("categorie", categorie);
			request.getRequestDispatcher("ConfirmationCat.jsp").forward(request, response);
		}
		else if (path.equals("/SupprimerCat.php")){
			Long id = Long.parseLong(request.getParameter("id"));
			metierCategorie.deleteCategorie(id);
			response.sendRedirect("categorie.php");
		}
		else if (path.equals("/ModifierCat.php")){
			Long id = Long.parseLong(request.getParameter("id"));
			Categorie categorie = metierCategorie.getCategorie(id);
			request.setAttribute("categorie", categorie);
			request.getRequestDispatcher("editcategorie.jsp").forward(request,response);
		}
		else if (path.equals("/EditCategorie.php") && request.getMethod().equals("POST")) {
			Long id =  Long.parseLong(request.getParameter("id"));
			String nom = request.getParameter("nom");
			String description = request.getParameter("description");
			Categorie categorie = new Categorie(nom,description);
			categorie.setId(id);
			metierCategorie.updateCategorie(categorie);
			request.setAttribute("categorie", categorie);
			request.getRequestDispatcher("ConfirmationCat.jsp").forward(request, response);
		}

		else if (path.equals("/CategorieDetails.php")){
			int id = Integer.parseInt(request.getParameter("id"));
			List<Album> albums = metierAlbum.afficheAlbumParCategorie(id);
			AlbumModel modelAlbum = new AlbumModel();
			modelAlbum.setAlbums(albums);
			request.setAttribute("modelAlbum", modelAlbum);
			request.getRequestDispatcher("albumParCategorie.jsp").forward(request,response);
		}


		//********************************************************************************************************		
		//CONTROLLEUR ARTISTE
		//********************************************************************************************************



		else if (path.equals("/artiste.php")) {

			ArtisteModel modelArt = new ArtisteModel();
			List<Artiste> artistes = metierArtiste.artisteAffiche();
			modelArt.setArtistes(artistes);
			request.setAttribute("modelArt", modelArt);
			request.getRequestDispatcher("artiste.jsp").forward(request, response);

		}
		else if (path.equals("/ArtisteDetails.php")){
			int id = Integer.parseInt(request.getParameter("id"));
			List<Album> albums = metierAlbum.afficheAlbumParArtiste(id);
			Artiste artiste = metierArtiste.getArtiste((long)id);
			AlbumModel modelAlbum = new AlbumModel();
			modelAlbum.setAlbums(albums);
			request.setAttribute("modelAlbum", modelAlbum);
			request.setAttribute("artiste", artiste);
			request.getRequestDispatcher("albumParArtiste.jsp").forward(request,response);
		}
		else if (path.equals("/chercherart.php")) {
			String motClef = request.getParameter("motCle");
			ArtisteModel modelArt = new ArtisteModel();
			List<Artiste> artistes = metierArtiste.artisteParMotCle(motClef);
			modelArt.setArtistes(artistes);
			request.setAttribute("modelArt", modelArt);
			request.getRequestDispatcher("artiste.jsp").forward(request, response);
		}
		else if (path.equals("/AjoutArt.php")) {
			request.setAttribute("artiste", new Artiste());
			request.getRequestDispatcher("artisteajout.jsp").forward(request,response);
		}
		else if (path.equals("/AjoutArtiste.php") && request.getMethod().equals("POST")) {
			String nom = request.getParameter("nom");
			String pays = request.getParameter("pays");
			Artiste artiste = metierArtiste.ajoutArtiste(new Artiste(nom,pays));
			request.setAttribute("artiste", artiste);
			request.getRequestDispatcher("ConfirmationArt.jsp").forward(request, response);
		}
		else if (path.equals("/SupprimerArt.php")){
			Long id = Long.parseLong(request.getParameter("id"));
			metierArtiste.deleteArtiste(id);
			response.sendRedirect("artiste.php");
		}
		else if (path.equals("/ModifierArt.php")){
			Long id = Long.parseLong(request.getParameter("id"));
			Artiste artiste = metierArtiste.getArtiste(id);
			request.setAttribute("artiste", artiste);
			request.getRequestDispatcher("editartiste.jsp").forward(request,response);
		}
		else if (path.equals("/EditArtiste.php") && request.getMethod().equals("POST")) {
			Long id =  Long.parseLong(request.getParameter("id"));
			String nom = request.getParameter("nom");
			String pays = request.getParameter("pays");
			String image = request.getParameter("image");
			Artiste artiste = new Artiste(nom,pays,image);
			artiste.setId(id);
			metierArtiste.updateArtiste(artiste);
			request.setAttribute("artiste", artiste);
			request.getRequestDispatcher("ConfirmationArt.jsp").forward(request, response);
		}

		//********************************************************************************************************
		//CONTROLLEUR ALBUM
		//********************************************************************************************************


		else if (path.equals("/AjoutAlbum.php")&&request.getMethod().equals("POST")) {

			String nom = request.getParameter("nom");
			String imageAlbum = request.getParameter("image");
			int id_artiste = Integer.parseInt(request.getParameter("id_artiste"));
			int id_categorie = Integer.parseInt(request.getParameter("id_categorie"));
			Album album = metierAlbum.ajoutAlbum(new Album(nom,imageAlbum,id_artiste,id_categorie));
			request.setAttribute("album", album);
			request.getRequestDispatcher("ConfirmationAlbum.jsp").forward(request, response);

		}
		else if (path.equals("/AlbumDetails.php")){
			int id = Integer.parseInt(request.getParameter("id"));
			List<Titre> titres = metierTitre.afficheTitreParAlbum(id);
			Album album = metierAlbum.getAlbum((long)id);
			TitreModel modelTitre = new TitreModel();
			modelTitre.setTitres(titres);
			request.setAttribute("album", album);
			request.setAttribute("modelTitre", modelTitre);
			request.getRequestDispatcher("titreParAlbum.jsp").forward(request,response);
		}
		else if (path.equals("/AjoutAlb.php")) {
			request.setAttribute("album", new Album());
			ArtisteModel modelArtiste = new ArtisteModel();
			CategorieModel modelCategorie = new CategorieModel();
			List<Artiste> artistes = metierArtiste.artisteAffiche();
			List<Categorie> categories = metierCategorie.categorieAffiche();
			modelCategorie.setCategories(categories);
			modelArtiste.setArtistes(artistes);

			request.setAttribute("modelArtiste", modelArtiste);
			request.setAttribute("modelCategorie", modelCategorie);
			request.getRequestDispatcher("ajoutAlbum.jsp").forward(request,response);
		}
		else if (path.equals("/album.php")) {

			AlbumModel modelAlbum = new AlbumModel();
			ArtisteModel modelArtiste = new ArtisteModel();
			CategorieModel modelCategorie = new CategorieModel();
			List<Artiste> artistes = metierArtiste.artisteAffiche();
			List<Categorie> categories = metierCategorie.categorieAffiche();
			List<Album> albums = metierAlbum.afficheAlbum();
			modelAlbum.setAlbums(albums);
			modelCategorie.setCategories(categories);
			modelArtiste.setArtistes(artistes);

			request.setAttribute("modelArtiste", modelArtiste);
			request.setAttribute("modelCategorie", modelCategorie);
			request.setAttribute("modelAlbum", modelAlbum);
			request.getRequestDispatcher("album.jsp").forward(request, response);

		}
		else if (path.equals("/ModifierAlbum.php")){
			Long id = Long.parseLong(request.getParameter("id"));
			Album album = metierAlbum.getAlbum(id);
			ArtisteModel modelArtiste = new ArtisteModel();
			CategorieModel modelCategorie = new CategorieModel();
			List<Artiste> artistes = metierArtiste.artisteAffiche();
			List<Categorie> categories = metierCategorie.categorieAffiche();
			modelCategorie.setCategories(categories);
			modelArtiste.setArtistes(artistes);

			request.setAttribute("modelArtiste", modelArtiste);
			request.setAttribute("modelCategorie", modelCategorie);
			request.setAttribute("album", album);
			request.getRequestDispatcher("editalbum.jsp").forward(request,response);
		}

		else if (path.equals("/SupprimerAlbum.php")){
			Long id = Long.parseLong(request.getParameter("id"));
			metierAlbum.deleteAlbum(id);
			response.sendRedirect("album.php");
		}
		else if (path.equals("/EditAlbum.php") && request.getMethod().equals("POST")) {
			Long id =  Long.parseLong(request.getParameter("id"));
			String nom = request.getParameter("nom");
			String image = request.getParameter("image");
			int id_artiste = Integer.parseInt(request.getParameter("id_artiste"));
			int id_categorie = Integer.parseInt(request.getParameter("id_categorie"));
			Album album = new Album(nom,image,id_artiste,id_categorie);
			album.setId(id);
			metierAlbum.updateAlbum(album);
			request.setAttribute("album", album);
			request.getRequestDispatcher("ConfirmationAlbum.jsp").forward(request, response);
		}


		//********************************************************************************************************
		//CONTROLLEUR TITRE
		//********************************************************************************************************


		else if (path.equals("/titre.php")) {

			HttpSession session = request.getSession();
			int id_user = (int)session.getAttribute("id");
			TitreModel modelTitre = new TitreModel();
			List<Titre> titres = metierTitre.afficheTitre();
			modelTitre.setTitres(titres);
			List<Favoris> favorites = metierFavoris.getFavoris(id_user);
			FavorisModel modelFavoris = new FavorisModel();
			modelFavoris.setModelFavoris(favorites);
			request.setAttribute("modelTitre", modelTitre);
			request.setAttribute("modelFavoris", modelFavoris);
			request.getRequestDispatcher("titre.jsp").forward(request, response);

		}

		else if (path.equals("/TitreDetails.php")){
			boolean favorit=false;
			HttpSession session = request.getSession();
			int id = Integer.parseInt(request.getParameter("id"));
			int id_user = (int)session.getAttribute("id");
			Titre titre = metierTitre.getTitre(id);
			List<Favoris> favorites = metierFavoris.getFavoris();


			//			Album album = metierAlbum.getAlbum(titre.getAlbum());
			//			Artiste artiste = metierArtiste.getArtiste(titre.getArtiste());
			//			Categorie categorie = metierCategorie.getCategorie(titre.getCategorie());

			for (Favoris favoris : favorites) {
				String id_fav_titre = favoris.getId_titre()+"";
				String id_fav_user = favoris.getId_user()+"";
				if(id_fav_titre.equals(titre.getId()+"")&&id_fav_user.equals(id_user+"")){
					favorit=true;

				}

			}
			//			request.setAttribute("album", album);
			//			request.setAttribute("artiste", artiste);
			//			request.setAttribute("categorie", categorie);
			request.setAttribute("titre", titre);
			request.setAttribute("isFav", favorit);

			request.getRequestDispatcher("TitreDetails.jsp").forward(request,response);
		}

		else if (path.equals("/AjoutTit.php")) {
			request.setAttribute("titre", new Titre());
			AlbumModel modelAlbum = new AlbumModel();
			List<Album> albums = metierAlbum.afficheAlbum();
			modelAlbum.setAlbums(albums);
			request.setAttribute("modelAlbum", modelAlbum);
			request.getRequestDispatcher("ajoutTitre.jsp").forward(request,response);
		}
		else if (path.equals("/ModifierTitre.php")){
			int id = Integer.parseInt(request.getParameter("id"));
			Titre titre = metierTitre.getTitre(id);

			AlbumModel modelAlbum = new AlbumModel();
			List<Album> albums = metierAlbum.afficheAlbum();
			modelAlbum.setAlbums(albums);
			request.setAttribute("modelAlbum", modelAlbum);
			request.setAttribute("titre", titre);
			request.getRequestDispatcher("edittitre.jsp").forward(request,response);
		}
		else if (path.equals("/SupprimerTitre.php")){
			int id = Integer.parseInt(request.getParameter("id"));
			metierTitre.deleteTitre(id);
			response.sendRedirect("titre.php");
		}
		else if (path.equals("/EditTitre.php") && request.getMethod().equals("POST")) {
			int id =  Integer.parseInt(request.getParameter("id"));
			String nom = request.getParameter("nom");


			String url = request.getParameter("url");
			String duree = request.getParameter("duree");
			Long id_album = Long.parseLong(request.getParameter("id_album"));
			Album album = metierAlbum.getAlbum(id_album);
			Artiste artiste = metierArtiste.getArtiste((long) album.getArtiste());
			Long id_artiste = artiste.getId();
			Categorie categorie = metierCategorie.getCategorie((long) album.getCategorie());
			Long id_categorie = categorie.getId();
			Titre titre =new Titre(nom,duree,url,id_artiste,id_categorie,id_album);
			titre.setId((long)id);


			metierTitre.updateTitre(titre);

			request.setAttribute("titre", titre);
			request.getRequestDispatcher("ConfirmationTitre.jsp").forward(request, response);
		}

		else if (path.equals("/AjoutTitre.php")&&request.getMethod().equals("POST")) {

			String nom = request.getParameter("nom");
			String url = request.getParameter("url");
			String duree = request.getParameter("duree");
			Long id_album = Long.parseLong(request.getParameter("id_album"));
			Album album = metierAlbum.getAlbum(id_album);
			Artiste artiste = metierArtiste.getArtiste((long) album.getArtiste());
			Long id_artiste = artiste.getId();
			Categorie categorie = metierCategorie.getCategorie((long) album.getCategorie());
			Long id_categorie = categorie.getId();
			Titre titre = metierTitre.ajoutTitre(new Titre(nom,duree,url,id_artiste,id_categorie,id_album));
			request.setAttribute("titre", titre);
			request.getRequestDispatcher("ConfirmationTitre.jsp").forward(request, response);

		}

		//********************************************************************************************************
		//CONTROLLEUR USER
		//********************************************************************************************************


		else if (path.equals("/Register.php")&&request.getMethod().equals("POST")) {


			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String confirm_pass = request.getParameter("confirmpass");
			String nom = request.getParameter("nom");
			String sex = request.getParameter("sex");
			String date_naissance = request.getParameter("date_naissance");
			User user = new User(email,password,nom,sex,date_naissance,"USER");

			if (!password.equals(confirm_pass)) {
				request.setAttribute("message_confirm", "confirm password");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}else {

				List<User> users = metierUser.userParMotCle("%"+email+"%");
				for (User user2 : users) {
					if (user2.getEmail().equals(user.getEmail())) {
						request.setAttribute("email_exist", "Email existant choisissez un autre");
						request.getRequestDispatcher("register.jsp").forward(request, response);
						return;
					}
				}
			}


			User user1 = metierUser.ajoutUser(user);
			request.setAttribute("user", user1);
			request.getRequestDispatcher("ConfirmationUser.jsp").forward(request, response);


		}


		else if (path.equals("/EditUser.php") && request.getMethod().equals("POST")) {

			Long id =  (long) metierUser.getUserId(request.getParameter("email"));
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String nom = request.getParameter("nom");
			String date_naissance = request.getParameter("date_naissance");
			String sex = request.getParameter("sex");


			User user = new User(email,password,nom,sex,date_naissance);
			user.setId(id);
			if (metierLogin.is_role_user(user)) {
				user.setRole("USER");
			}else {
				user.setRole("ADMIN");
			}
			metierUser.updateUser(user);
			request.setAttribute("user", user);
			request.getRequestDispatcher("ConfirmationUser.jsp").forward(request, response);
		}


		else if (path.equals("/ModifierUser.php")){
			HttpSession session = request.getSession(true); 
			int id = (int) session.getAttribute("id");
			User user = metierUser.getUser(id);
			request.setAttribute("user", user);
			request.getRequestDispatcher("profile.jsp").forward(request,response);
		}


		else if (path.equals("/login.php")&&request.getMethod().equals("POST")) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			User user = new User();
			user.setEmail(email);
			user.setPassword(password);
			if (metierLogin.validate(user) && metierLogin.is_role_user(user)) {
				HttpSession session = request.getSession();
				session.setAttribute("email",email);
				response.sendRedirect("index.jsp");
				int id_user = metierUser.getUserId(email);
				session.setAttribute("id_user", id_user);
			} else if (metierLogin.validate(user) && !metierLogin.is_role_user(user)){
				HttpSession session = request.getSession();
				int id_user = metierUser.getUserId(email);
				session.setAttribute("id_user", id_user);
				session.setAttribute("email", email);
				response.sendRedirect("cherchercat.php");

			}
			else {
				HttpSession session = request.getSession();

				session.setAttribute("email", email);

				response.sendRedirect("login.jsp");
			}
		}

		else if (path.equals("/logout.php")) {
			HttpSession session= request.getSession(true); 
			session.removeAttribute("email");
			session.invalidate();  
			response.sendRedirect("login.jsp");
		}



		//********************************************************************************************************
		//CONTROLLEUR Favoris
		//********************************************************************************************************


		else if (path.equals("/favoris.php")) {
			HttpSession session = request.getSession();
			
			int id_user = (int)session.getAttribute("id");
			
			
			List<Favoris> favorites = metierFavoris.getFavoris();
			List<Titre> titres_favoris = new ArrayList<Titre>();


			//			Album album = metierAlbum.getAlbum(titre.getAlbum());
			//			Artiste artiste = metierArtiste.getArtiste(titre.getArtiste());
			//			Categorie categorie = metierCategorie.getCategorie(titre.getCategorie());

			for (Favoris favoris : favorites) {
				
				String id_fav_user = favoris.getId_user()+"";
				if(id_fav_user.equals(id_user+"")){

					
					titres_favoris.add(metierTitre.getTitre(favoris.getId_titre()));
				}

			}
			//			request.setAttribute("album", album);
			//			request.setAttribute("artiste", artiste);
			//			request.setAttribute("categorie", categorie);
			TitreModel modelTitre = new TitreModel();
			modelTitre.setTitres(titres_favoris);
			request.setAttribute("modelTitre_Favoris", modelTitre);
			request.getRequestDispatcher("favoris.jsp").forward(request,response);
		}


		else if (path.equals("/ajoutFavoris.php")){
			HttpSession session = request.getSession(true); 
			

			int id_user = (int) session.getAttribute("id_user");
			int id_titre = Integer.parseInt(request.getParameter("id"));
			Titre titre = metierTitre.getTitre(id_titre);
			metierFavoris.ajoutFavoris(titre, id_user);
			
			response.sendRedirect("favoris.php");
		}
		else if (path.equals("/removeFavoris.php")){
			HttpSession session = request.getSession(true); 
			
			int id_user = (int) session.getAttribute("id_user");
			int id_titre = Integer.parseInt(request.getParameter("id"));
			Titre titre = metierTitre.getTitre(id_titre);
			metierFavoris.deleteFavoris(titre, id_user);
			
			response.sendRedirect("favoris.php");
		}

		//********************************************************************************************************************************************************************************
		//NOT FOUND
		//********************************************************************************************************************************************************************************
		else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
