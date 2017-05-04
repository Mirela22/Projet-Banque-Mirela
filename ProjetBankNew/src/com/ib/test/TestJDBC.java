package com.ib.test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class TestJDBC {
	
	/* La liste qui contiendra tous les résultats de nos essais */
    private List<String> messages = new ArrayList<String>();

 public List<String> executerTests( HttpServletRequest request ){
	 
	   try {
	        messages.add( "Chargement du driver..." );
	        Class.forName( "com.mysql.jdbc.Driver" );
	        messages.add( "Driver chargé !" );
	    } catch ( ClassNotFoundException e ) {
	        messages.add( "Erreur lors du chargement : le driver n'a pas été trouvé dans le classpath ! <br/>"
	                + e.getMessage() );
	    }

        
    	Connection cnx = null;
    	Statement stat = null;
    	ResultSet resultat = null;
        try{
            //connection a la BDD
        	
        	messages.add( "Connexion à la base de données..." );
            cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:8889/bdd_sdzee","root","root");
            System.out.println("Connexion ok");
            messages.add( "connection reussie !" );
            
            stat = (Statement)cnx.createStatement();
            System.out.println("Statement ok");
            messages.add( "Objet requête créé !" );
            System.out.println("------------------");
          //selection des colonnes désirées
            
            resultat = stat.executeQuery("SELECT id, email,MDP, nom  FROM USER ;" );
            messages.add( "Requête \"SELECT id, email, MDP, nom FROM USER;\" effectuée !" );

            
          
	           while(resultat.next()){
	        	    int idUtilisateur = resultat.getInt( "id" );
	        	    String emailUtilisateur = resultat.getString( "email" );
	        	    String motDePasseUtilisateur = resultat.getString( "MDP" );
	        	    String nomUtilisateur = resultat.getString( "nom" );
	        	    
	        	    messages.add( "Données retournées par la requête : id = " + idUtilisateur + ", email = " + emailUtilisateur
	                        + ", motdepasse = "
	                        + motDePasseUtilisateur + ", nom = " + nomUtilisateur + "." );
	            
	           }
              
        }catch(SQLException e){
            System.out.println("erreur");
            messages.add( "Erreur lors de la connexion : <br/>"
                    + e.getMessage() );

        } finally {
            messages.add( "Fermeture de l'objet ResultSet." );
            if ( resultat != null ) {
                try {
                    resultat.close();
                } catch ( SQLException ignore ) {
                }
            }
            messages.add( "Fermeture de l'objet Statement." );
            if ( stat != null ) {
                try {
                    stat.close();
                } catch ( SQLException ignore ) {
                }
            }
            messages.add( "Fermeture de l'objet Connection." );
            if ( cnx != null ) {
                try {
                    cnx.close();
                } catch ( SQLException ignore ) {
                }
            }
        }

        return messages;
        } 

}
