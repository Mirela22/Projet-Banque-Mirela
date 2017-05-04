package com.ib.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ib.BDD.FonctionEditerInfos;
import com.ib.BDD.FonctionRecuperationDonnees;
import com.ib.beans.BeanUser;


@WebServlet("/GestionTestJDBC")
public class GestionTestJDBC extends HttpServlet {
	public static final String VUE          = "/WEB-INF/test_jdbc.jsp";
	
    public GestionTestJDBC() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 /* Initialisation de l'objet Java et récupération des messages */
		FonctionRecuperationDonnees ListesUsers2 = new FonctionRecuperationDonnees();
		BeanUser NewUser = new BeanUser();
		NewUser = FonctionRecuperationDonnees.recupererUN_Utilisateur("63758986");
		request.setAttribute("NewUser", NewUser);
		
		FonctionEditerInfos fonctionEditer = new FonctionEditerInfos();
		FonctionEditerInfos.EditerInfo("person_email", "Mirela@lskai.sw", "63758986");
		
        /* Enregistrement de la liste des messages dans l'objet requête 
		ListesUsers2.recupererToutLesUtilisateurs();
		//int a = ListesUsers2.getPerson_id();
		System.out.println(ListesUser2.get)
		request.setAttribute("ListesUsers", ListesUsers2);
		*/
	/* Transmission vers la page en charge de l'affichage des résultats */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
