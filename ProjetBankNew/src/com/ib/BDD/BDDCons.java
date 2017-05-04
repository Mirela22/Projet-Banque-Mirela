package com.ib.BDD;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class BDDCons {
	
	// cette fonction permet d'ajouter des comptes utilisateurs
	
		public static void Ajout_Account(String External_ID,String firstname,String lastname,String email,String password,String dob,String phone){
	        Connection cnx = null;
	        try{
	            
	            Class.forName("com.mysql.jdbc.Driver");
	            System.out.println("Driver ok");
	            
	            cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/societe_agricole_test","root","root");
	            System.out.println("Connexion ok");
	            
	            Statement stat = (Statement)cnx.createStatement();
	            System.out.println("Statement ok");
	            System.out.println("------------------");
	          
	            String query = "INSERT INTO sac_person SET ,person_external_id=?,person_firstname=?,person_lastname=?,person_email=?,person_password=?,person_dob=?,person_phone_number=?";
	           PreparedStatement preparedStmt = (PreparedStatement) cnx.prepareStatement(query);
	           
	           preparedStmt.setString(1, External_ID);
	           preparedStmt.setString(2, firstname);
	           preparedStmt.setString(3, lastname);
	           preparedStmt.setString(4, email);
	           preparedStmt.setString(5, password);
	           preparedStmt.setString(6, dob);
	           preparedStmt.setString(7, phone);

	           
	           preparedStmt.executeUpdate();
	            
	            
	            ResultSet resultat = stat.executeQuery("SELECT person_external_id,person_token From sac_person");
	          
	            while(resultat.next()){
	                System.out.println(resultat.getString("person_external_id"));
	                System.out.println(resultat.getString("person_token"));
	           }
	            resultat.close();
	            stat.close();
	            cnx.close();
	            
	        }catch(Exception e){
	            System.out.println("erreur");
	        }
		}

}
