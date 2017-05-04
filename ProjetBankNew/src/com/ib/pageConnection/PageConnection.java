package com.ib.pageConnection;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ib.BDD.BDDClient;
import com.ib.fonctions.Utilitairefct;


@WebServlet("/PageConnection")
public class PageConnection extends HttpServlet {
	// Déclaration des variables qui vont nous permettre d'utiliser nos methodes
	private static final String PUBLIC_PATH ="/noConnect.jsp" ;
    
    public PageConnection() {
        super();
        
    }

    // cette servlet permet de se connecter sur les espaces clients et conseiller en fonction de l'ID. Les fonctions qui permettent cette redirection se trouve dans User et Utilitairesfct
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher( PUBLIC_PATH ).forward( request, response );
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*création d'une map  myCliendIDPass qui va recupérer les id et les mots de passe des utiliseurs présents dans la table sac_person 
		 grâce à la fonction getClientIDPassword présente dans la classe User
		*/
				HashMap<String, String> myClientIDPass = new HashMap<String,String>();
				myClientIDPass = BDDClient.getClientIDPassword();
				
				//Test de la correspondance entre l'ID et le mot de passe entrés par le client avec ceux de la MAP myCliendIDPass qui correspondent à ceux de la base de donnée dans la table sac_person
				if (Utilitairefct.passcheck(myClientIDPass, request.getParameter("clientIdLogin"),request.getParameter("passwordLogin"))==true){
					
					//génération d'un acces_token que l'on ajoute à la base de donnée grâce à la fonction Ajout_Access à l'id correspondant
					SecureRandom rnd = new SecureRandom();
					String Acces_token1 = new BigInteger(130, rnd).toString(32);
					BDDClient.Ajout_Access(Acces_token1, request.getParameter("clientIdLogin"));
		            
		            //création d'un Cookie qui va stocker l'acces Token pendant 24H et ajout de ce cookie à la HttpServletRespone 
			        Cookie myCookie2 = new Cookie("key", Acces_token1);
			        myCookie2.setMaxAge(24*60*60);
			        response.addCookie(myCookie2);
					

			        //une fois que le passcheck est validé, on va regardé si l'utilisateur est un client ou un conseiller grâce à la fonction isAdvisor et on va redirigé l'utilisateur en fonction de son statut
					HashMap<String, Integer> whoIsPersonnMap = new HashMap<String,Integer>();
					whoIsPersonnMap = BDDClient.getPerson_is_advisor();
					boolean whoIsPersonn = Utilitairefct.isAdvisor (whoIsPersonnMap,request.getParameter("clientIdLogin")); 
					 	if (whoIsPersonn == true ){
					 		response.sendRedirect("http://localhost:8080/ProjetBankNew/PageClient");//redirection vers la page Connecté pour les clients
					 	} else {
					 		System.out.println("conseiller");
					 		response.sendRedirect("http://localhost:8080/ProjetBankNew/PageConseiller");//redirection vers la page Connecté pour les conseillers
					 	}
			        
				}else{
					this.getServletContext().getRequestDispatcher( PUBLIC_PATH ).forward( request, response );
					//System.out.println("Encore dans mapage");
					//request.setAttribute("ton_message",tonChampMessage);
					//afficher un message d'erreur
					
				}
	}

}
