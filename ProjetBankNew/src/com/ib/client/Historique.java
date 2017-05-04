package com.ib.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ib.BDD.FonctionHistorique;
import com.ib.beans.BeanHistorique;


@WebServlet("/Historique")
public class Historique extends HttpServlet {
	
    public Historique() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Initialisation de l'objet fonctionhistorique et d'une liste d'historique historique*/
		FonctionHistorique FonctionHistorique = new FonctionHistorique();
		
		List<BeanHistorique> historique = new ArrayList<BeanHistorique>();
		/* application de la fonction recupererHistorique qui permet de recuperer la table sac_operation dans la liste historique */
		historique = FonctionHistorique.recupererHistorique();
		request.setAttribute("Historique", historique);
	
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/Client/Historique.jsp" ).forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
