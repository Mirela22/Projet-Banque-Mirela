package com.ib.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ib.BDD.FonctionListeComptesClient;
import com.ib.BDD.FonctionRecuperationDonnees;
import com.ib.beans.BeanUser;


@WebServlet("/ListeComptes")
public class ListeComptes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public static final String LISTECOMPTESCLIENT = "listeComptesClient";
	 public static final String VUE          = "/WEB-INF/Client/listeC.jsp";
       

    public ListeComptes() {
        super();
       
    }

  //on souhaite ici afficher la liste des comptes d'un client
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* On recupère le personnal id correspond au person_external_id entré par le client */
		
		String person_external_id ="63758986";//= request.getParameter("clientIdLogin");
		
		BeanUser NewUser = new BeanUser();
		
		//on applique la fonction qui permet de recuperer les données de la table sac_personn, ici on veut l'id a partir de l'external id
		NewUser = FonctionRecuperationDonnees.recupererUN_Utilisateur(person_external_id);
		int idClient = NewUser.getPerson_id();
		
		System.out.println(idClient);
		
		/* Initialisation de l'objet Java et récupération des comptes */
		
		FonctionListeComptesClient ObjetListeComptesClient = new FonctionListeComptesClient();
        List<String> listeComptesClient = ObjetListeComptesClient.afficherListeComptesClient( idClient );

        /* Enregistrement de la liste des messages dans l'objet requête */
        request.setAttribute( LISTECOMPTESCLIENT, listeComptesClient );

        /* Transmission vers la page en charge de l'affichage des résultats */
        
        
		this.getServletContext().getRequestDispatcher(VUE).forward( request, response );		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
