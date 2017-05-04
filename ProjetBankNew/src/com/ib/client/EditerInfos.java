package com.ib.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ib.BDD.FonctionEditerInfos;
import com.ib.BDD.FonctionRecuperationDonnees;
import com.ib.beans.BeanUser;


@WebServlet("/EditerInfos")
public class EditerInfos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public EditerInfos() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FonctionRecuperationDonnees ListesUsers = new FonctionRecuperationDonnees();
		
		BeanUser NewUser = new BeanUser();
		NewUser = FonctionRecuperationDonnees.recupererUN_Utilisateur("63758986");
		System.out.println(NewUser.getPerson_lastnam());
		System.out.println(NewUser.getPerson_firstname());
		System.out.println(NewUser.getPerson_password());
		
		request.setAttribute( "NewUser", NewUser );
		
		FonctionEditerInfos.EditerInfo("person_email", "Mirela@lskai.sw", "63758986");
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/Client/EditerInfos.jsp" ).forward( request, response );
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("person_email")!=null){
			FonctionEditerInfos.EditerInfo("person_email", request.getParameter("person_email"), request.getParameter("External_id"));
		}else if(request.getParameter("person_password")!=null){
			FonctionEditerInfos.EditerInfo("person_password", request.getParameter("person_password"), request.getParameter("External_id"));
		}else if(request.getParameter("person_dob")!=null){
			FonctionEditerInfos.EditerInfo("person_dob", request.getParameter("person_dob"), request.getParameter("External_id"));
		}else if(request.getParameter("person_phone_number")!=null){
			FonctionEditerInfos.EditerInfo("person_phone_number", request.getParameter("person_phone_number"), request.getParameter("External_id"));
		}else {
			System.out.println("Aucune modification n'est apportée");
			
		}
		this.getServletContext().getRequestDispatcher( "/WEB-INF/Client/RetourAccueil.jsp" ).forward( request, response );
	}

}
