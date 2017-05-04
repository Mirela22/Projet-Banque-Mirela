<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page connection client</title>

<link rel="stylesheet" href="/connect.css" type="text/css"/>
</head>
<body>
	<h3> Vous êtes connecté </h3>
	
	<div id="conteneur">
	
			<form method="get" action="ListeDesComptes">
				<input type="submit" value="Liste des comptes" />
			</form>
			
			<form method="get" action="EditerInfos ">
				<input type="submit" value="Editer des Informations" />
			</form>
			
			<form method="get" action="Historique">
				<input type="submit" value="Historique des opérations bancaires" />
			</form>
			
			<form method="get" action="Contester ">
				<input type="submit" value="Contester une opération bancaire" />
			</form>
			
			<form method="get" action="Contacter ">
				<input type="submit" value="Contacter votre conseiller" />
			</form>	
	
	</div>	
	
	
	
	
	<a href="http://localhost:8080/ProjetBankNew/PageClient"> Retour à l'accueil Client</a>
</body>
</html>