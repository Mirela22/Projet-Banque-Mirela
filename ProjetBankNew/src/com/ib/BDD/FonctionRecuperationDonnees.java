package com.ib.BDD;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ib.beans.BeanUser;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class FonctionRecuperationDonnees {
	

	/*
	création de la fonction qui va permettre de récuperer les élements de la table sac_person 
	et qui va les ajouter à une liste qui se compose d'objet de type BeanUser
	 */
	
	public List<BeanUser> recupererToutLesUtilisateurs(){
		
		List<BeanUser> users = new ArrayList<BeanUser>();
		//chargement du driver
		try {
	        Class.forName( "com.mysql.jdbc.Driver");
	    } catch ( ClassNotFoundException e ) {
	    }
		Connection cnx = null;
    	Statement stat = null;
    	ResultSet resultat = null;
    	try{
            //connection a la BDD
            cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/societe_agricole_test","root","root");
            stat = (Statement)cnx.createStatement();    
            //Execution de la requete
            resultat = stat.executeQuery("SELECT * FROM sac_person;");
            //Récupération des données 
            
	        while(resultat.next()){
	        	
	        	int	person_id= resultat.getInt("person_id");
	        	String person_external_id = resultat.getString( "person_external_id" );	
	        	String person_firstname= resultat.getString( "person_firstname" );
	        	String person_lastname= resultat.getString( "person_lastname" );
	        	String person_email= resultat.getString( "person_email" );
	        	String person_password= resultat.getString( "person_password" );
	        	String person_dob= resultat.getString( "person_dob" );
	        	String person_token= resultat.getString( "person_token" );
	        	String person_phone_number= resultat.getString( "person_phone_number" );
	        	String  person_created_At= resultat.getString( "person_created_At" );
	        	String person_updated_at= resultat.getString( "person_updated_at" );
	        	int person_advisor_id= resultat.getInt( "person_advisor_id" );
	        	int person_is_advisor= resultat.getInt( "person_is_advisor" );
	        	
	        	//creation d'un objet personne et initialisation de ces paramètres
	        	BeanUser newUser = new BeanUser();
	        	
	        	newUser.setPerson_id(person_id);
	        	newUser.setPerson_external_id(person_external_id);
	        	newUser.setPerson_firstname(person_firstname);
	        	newUser.setPerson_lastnam(person_lastname);
	        	newUser.setPerson_email(person_email);
	        	newUser.setPerson_password(person_password);
	        	newUser.setPerson_dob(person_dob);
	        	newUser.setPerson_token(person_token);
	        	newUser.setPerson_phone_number(person_phone_number);
	        	newUser.setPerson_created_At(person_created_At);
	        	newUser.setPerson_updated_at(person_updated_at);
	        	newUser.setPerson_advisor_id(person_advisor_id);
	        	newUser.setPerson_is_advisor(person_is_advisor);
	        	
	        	System.out.println(newUser.getPerson_id());
	        	System.out.println(newUser.getPerson_firstname());
	        	users.add(newUser);
	            
	           }
              
        }catch(SQLException e){
        } finally {
        	// Fermeture de la connexion
              try {
            	  if ( resultat != null ) 
                    resultat.close();
                  if ( stat != null ) 
                    stat.close();
                  if ( cnx != null ) 
                    cnx.close();
               }catch( SQLException ignore ) {
               }
          }
		return users;
		
	}
	
	
	/*
	création de la fonction qui va permettre de récuperer les élements de la table sac_person 
	correspondant à UN SEUL UTILISATEUR
	 */
	
	public static BeanUser recupererUN_Utilisateur(String IdClient){
		
		BeanUser newUser = new BeanUser();
		//chargement du driver
		try {
	        Class.forName( "com.mysql.jdbc.Driver");
	    } catch ( ClassNotFoundException e ) {
	    }
		Connection cnx = null;
    	PreparedStatement stat = null;
    	ResultSet resultat = null;
    	try{
            //connection a la BDD
            cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/societe_agricole_test","root","root");
            
            
            //Execution de la requete
            String request = "SELECT * FROM sac_person WHERE person_external_id =?";
            stat= (PreparedStatement) cnx.prepareStatement(request);
            System.out.println("ok");
            stat.setString(1, IdClient);
         // Remplissage du paramètre.			
        	//preparedStatement.setString(1,monID);
        
        	//execution de la requête
        	resultat = stat.executeQuery();
        	 while(resultat.next()){     	
	        	int	person_id= resultat.getInt("person_id");
	        	String person_external_id = resultat.getString( "person_external_id" );	
	        	 String person_firstname= resultat.getString( "person_firstname" );
	        	 String person_lastname= resultat.getString( "person_lastname" );
	        	 String person_email= resultat.getString( "person_email" );
	        	 String person_password= resultat.getString( "person_password" );
	        	 String person_dob= resultat.getString( "person_dob" );
	        	 String person_token= resultat.getString( "person_token" );
	        	 String person_phone_number= resultat.getString( "person_phone_number" );
	        	 String  person_created_At= resultat.getString( "person_created_At" );
	        	 String person_updated_at= resultat.getString( "person_updated_at" );
	        	int person_advisor_id= resultat.getInt( "person_advisor_id" );
	        	int person_is_advisor= resultat.getInt( "person_is_advisor" );
	        	
	        	//creation d'un objet personne et initialisation de ces paramètres
	        	System.out.println(person_firstname);	
	        	System.out.println(person_lastname);
	        	
	        	
	        	newUser.setPerson_id(person_id);
	        	newUser.setPerson_external_id(person_external_id);	
	        	newUser.setPerson_firstname(person_firstname);
	        	newUser.setPerson_lastnam(person_lastname);
	        	newUser.setPerson_email(person_email);
	        	newUser.setPerson_password(person_password);
	        	newUser.setPerson_dob(person_dob);
	        	newUser.setPerson_token(person_token);
	        	newUser.setPerson_phone_number(person_phone_number);
	        	newUser.setPerson_created_At(person_created_At);
	        	newUser.setPerson_updated_at(person_updated_at);
	        	newUser.setPerson_advisor_id(person_advisor_id);
	        	newUser.setPerson_is_advisor(person_is_advisor);
	        	
	        	System.out.println(newUser.getPerson_id());
	        	System.out.println(newUser.getPerson_firstname());
	        	System.out.println(newUser.getPerson_lastnam());
	        	//System.out.println(resultat.getString("nom"));

        	 }  
              
        }catch(SQLException e){
        } finally {
        	// Fermeture de la connexion
              try {
            	  if ( resultat != null ) 
                    resultat.close();
                  if ( stat != null ) 
                    stat.close();
                  if ( cnx != null ) 
                    cnx.close();
               }catch( SQLException ignore ) {
               }
          }
		return newUser;
		
	}

}
