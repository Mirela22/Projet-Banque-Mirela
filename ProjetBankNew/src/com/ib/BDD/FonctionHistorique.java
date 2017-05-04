package com.ib.BDD;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ib.beans.BeanHistorique;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class FonctionHistorique {
	
	/*
	 Création d'une fonction qui va récuperer l'historique des transactions et qui va les insérer dans une liste composée d'objet de type BeanHistorique
	 */
		
	public List<BeanHistorique> recupererHistorique(){
			
			List<BeanHistorique> historique = new ArrayList<BeanHistorique>();
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
	            resultat = stat.executeQuery("SELECT * FROM sac_operation;");
	            //Récupération des données 
	            
		        while(resultat.next()){
		        	
		        	int	ope_id= resultat.getInt("ope_id");	
		        	String ope_type= resultat.getString("ope_type");	
		        	String ope_amount= resultat.getString("ope_amount");	
		        	String ope_description= resultat.getString("ope_description");	
		        	String ope_account_id= resultat.getString("ope_account_id");	
		        	String ope_created_at= resultat.getString("ope_created_at");	
		        	String ope_updated_at= resultat.getString("ope_updated_at");	
		        	int ope_dispute= resultat.getInt("ope_dispute");	
		        	
		        	//creation d'un objet Historique et initialisation de ces paramètres
		        	BeanHistorique myHistorique = new BeanHistorique();
		        	
		        	
		        	myHistorique.setOpe_id(ope_id);
		        	myHistorique.setOpe_account_id(ope_account_id);
		        	myHistorique.setOpe_description(ope_description);
		        	myHistorique.setOpe_amount(ope_amount);
		        	myHistorique.setOpe_created_at(ope_created_at);
		        	myHistorique.setOpe_updated_at(ope_updated_at);
		        	myHistorique.setOpe_dispute(ope_dispute);
		       
		        	
		        	System.out.println(myHistorique.getOpe_id());
		        	System.out.println(myHistorique.getOpe_account_id());
		        	System.out.println(myHistorique.getOpe_amount());
		        	System.out.println(myHistorique.getOpe_description());
		        	System.out.println(myHistorique.getOpe_created_at());
		        	System.out.println(myHistorique.getOpe_updated_at());
		        	System.out.println(myHistorique.getOpe_dispute());
		        	
		        	historique.add(myHistorique);
		            
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
			return historique;
			
		}

}
