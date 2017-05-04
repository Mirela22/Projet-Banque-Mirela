package com.ib.BDD;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/*
 Cette fonction prend en argument un IDClient et parcourt la table sac_accounts en s�lectionnant uniquement 
 les ID correspondant � l'ID entr�e en param�tre. Tout les Account_type correspondant � cet ID sont ajouter dans une liste
 ListeComptesClient, qui est ensuite retourn�e
 */

public class FonctionListeComptesClient {
	
	private List<String> listeComptesClient = new ArrayList<String>();

	 public List<String> afficherListeComptesClient( int IDClient ){
		 
		   try {
		        Class.forName( "com.mysql.jdbc.Driver");
		        System.out.println("Driver ok");
		    } catch ( ClassNotFoundException e ) {
		    	
		       }

	        
	    	Connection cnx = null;
	    	PreparedStatement stat = null;
	    	ResultSet resultat = null;
	        try{
	            //connection a la BDD
	            cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/societe_agricole_test","root","root");
	            System.out.println("connection ok");
//il faut changer le 1 par ID entr� en param�tre 
	            String query = "SELECT account_type  FROM sac_accounts where account_customer_id = 1 ";
	            stat = (PreparedStatement)cnx.prepareStatement(query) ;
	            System.out.println("statement ok");
	            //selection des colonnes d�sir�es
//il faut changer le 1 par ID entr� en param�tre                
	            resultat = stat.executeQuery("SELECT account_type  FROM sac_accounts where account_customer_id = 1 ");
	            System.out.println("execute Querry ok");    
	          
		           while(resultat.next()){
		        	    
		        	    String account_type = resultat.getString( "account_type" );
		       		        	    
		        	    listeComptesClient.add(account_type);
		        	    System.out.println(account_type);
		            
		           }
	              
	        }catch(SQLException e){
	            System.out.println("erreur");
	            listeComptesClient.add( " bibi Erreur lors de la connexion : <br/>"
	                    + e.getMessage() );

	        } finally {
	        	
	            if ( resultat != null ) {
	                try {
	                    resultat.close();
	                } catch ( SQLException ignore ) {
	                }
	            }
	          
	            if ( stat != null ) {
	                try {
	                    stat.close();
	                } catch ( SQLException ignore ) {
	                }
	            }
	           
	            if ( cnx != null ) {
	                try {
	                    cnx.close();
	                } catch ( SQLException ignore ) {
	                }
	            }
	        }

	        return listeComptesClient;
	        } 

}
