package com.ib.BDD;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.HashMap;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class BDDClient {

	 // récuperation de mot de passe et stockage dans une map qui contient l'ID et le mot de passe
    public static HashMap<String,String> getClientIDPassword(){
       
        HashMap<String, String> ClientIDPassword = new HashMap<String,String>();
        
        try{
            //connection a la BDD
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver ok");
            
            Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/societe_agricole_test","root","root");
            System.out.println("Connexion ok");
            
            Statement stat = (Statement)cnx.createStatement();
            System.out.println("Statement ok");
            System.out.println("------------------");
          //selection des colonnes désirées
            stat.executeQuery("SELECT person_external_id,password From sac_person");
            ResultSet resultat = stat.executeQuery("SELECT person_external_id,password From sac_person");
          
           while(resultat.next()){
               System.out.print(resultat.getObject(1)+" "); //ClientID
               System.out.print(resultat.getObject(2)+" "); //password
              
               String key = (String)resultat.getObject(1);
               String passwordBdd = (String)resultat.getObject(2);
              //stockage dans la MAP
               ClientIDPassword.put(key, passwordBdd);
               System.out.println();
           }
           resultat.close();
           stat.close();
           cnx.close();
            
        }catch(Exception e){
            System.out.println("erreur");
        }
        return ClientIDPassword;
        
    }
    
  //cette fonction parcoure la bdd et retourne tous les couples ID/access token de la bdd
    public static HashMap<String,String> getClientIDAccess(){
        
        
        
        HashMap<String, String> ClientIDAccess = new HashMap<String,String>();
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver ok");
            
            Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/societe_agricole_test","root","root");
            System.out.println("Connexion ok");
            
            Statement stat = (Statement)cnx.createStatement();
            System.out.println("Statement ok");
            System.out.println("------------------");
          
            stat.executeQuery("SELECT person_external_id,person_token From sac_person");
            ResultSet resultat = stat.executeQuery("SELECT person_external_id,person_token From sac_person");
          
           while(resultat.next()){
               System.out.print(resultat.getObject(1)+" "); //ClientID
               System.out.print(resultat.getObject(2)+" "); //Access_Token
              
               String key = (String)resultat.getObject(1);
               String Access_Token = (String)resultat.getObject(2);
              
               ClientIDAccess.put(key, Access_Token);
               System.out.println();
           }
           resultat.close();
           stat.close();
           cnx.close();
            
        }catch(Exception e){
            System.out.println("erreur");
        }
        return ClientIDAccess;
        
    }
	
    // permet d'ajouter à un client un nouvel access token lors de la création du cookie
		public static void Ajout_Access(String Acces,String Id){
            Connection cnx = null;
            try{
                
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver ok");
                
                cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/societe_agricole_test","root","root");
                System.out.println("Connexion ok");
                
                Statement stat = (Statement)cnx.createStatement();
                System.out.println("Statement ok");
                System.out.println("------------------");
              
                String query = "UPDATE sac_person SET person_token=? where person_external_id=?";
               PreparedStatement preparedStmt = (PreparedStatement) cnx.prepareStatement(query);
               
               preparedStmt.setString(1, Acces);
               preparedStmt.setString(2, Id);
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
		
		//cette fonction parcour la bdd et retourne tous les couples ID/Person_is_advisor
		public static HashMap<String,Integer> getPerson_is_advisor(){
	                
	        HashMap<String,Integer> ID_Person_is_advisor = new HashMap<String,Integer>();
	        
	        try{
	            
	            Class.forName("com.mysql.jdbc.Driver");
	            System.out.println("Driver ok");
	            
	            Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/societe_agricole_test","root","root");
	            System.out.println("Connexion ok");
	            
	            Statement stat = (Statement)cnx.createStatement();
	            System.out.println("Statement ok");
	            System.out.println("------------------");
	          
		        stat.executeQuery("SELECT person_external_id, person_is_advisor From sac_person");
	            ResultSet resultat = stat.executeQuery("SELECT person_external_id, person_is_advisor From sac_person");
	          
	           while(resultat.next()){
	               System.out.print(resultat.getObject(1)+" "); //person_external_id
	               System.out.print(resultat.getObject(2)+" "); //person_is_advisor
	              
	               String person_external_id = (String)resultat.getObject(1);
	               Integer person_is_advisor = (Integer)resultat.getObject(2);
	              
	               ID_Person_is_advisor.put(person_external_id, person_is_advisor);
	               System.out.println();
	           }
	           resultat.close();
	           stat.close();
	           cnx.close();
	            
	        }catch(Exception e){
	            System.out.println("erreur");
	        }
	        return ID_Person_is_advisor;
	        
	    }

        
}
