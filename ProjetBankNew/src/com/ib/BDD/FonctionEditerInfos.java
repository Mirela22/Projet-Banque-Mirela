package com.ib.BDD;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class FonctionEditerInfos {
	
public static void EditerInfo( String colonne, String value, String idClient){
		
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
            System.out.println("Connexion ok");
            //Execution de la requete
            stat = (Statement)cnx.createStatement();
            System.out.println("Statement ok");
            System.out.println("------------------");
            
            
            
            String query = "UPDATE sac_person SET ? = ? where personal_external_id=?";
            
            PreparedStatement preparedStmt = (PreparedStatement) cnx.prepareStatement(query);
         // Remplissage du paramètre
            System.out.println("query ok");
            preparedStmt.setString(1, colonne);
            preparedStmt.setString(2, value);
            preparedStmt.setString(3, idClient);
            System.out.println("upthhjbhok");
            preparedStmt.executeUpdate();
            System.out.println("execute update ok");
        	//execution de la requête
        	resultat = stat.executeQuery("SELECT * From sac_person");
        	System.out.println("execute  ok");
        	 while(resultat.next()){     	
	        	System.out.println(resultat.getString( "person_external_id"));	
	        	System.out.println(resultat.getString( "person_firstname"));
	        	System.out.println(resultat.getString( "person_lastname"));
	        	System.out.println(resultat.getString( "person_email"));
	        	System.out.println(resultat.getString( "person_password"));
	        	System.out.println(resultat.getString( "person_dob"));
	        	System.out.println(resultat.getString( "person_token"));
	        	System.out.println(resultat.getString( "person_phone_number"));
	        	System.out.println(resultat.getString( "person_created_At"));
	        	System.out.println(resultat.getString( "person_updated_at"));
	        	System.out.println(resultat.getInt( "person_advisor_id"));
	        	System.out.println(resultat.getInt( "person_is_advisor"));
	
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
		
		
	}

}
