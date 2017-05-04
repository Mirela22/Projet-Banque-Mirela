<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Espace Conseiller</title>
</head>
<body>
	<header>
		<div id="entete"><h1> Espace Conseiller </h1></div> 
	</header>
	
	<%-- Menu de l'espace client du conseiller --%>
	<fieldset>
		<legend>Mes Clients</legend>
		<br>
		<form method="get"action="MesClients">
		<input type="submit" value="Consulter la liste des clients">
		</form>
		<br>
		<form method="get"action="SupprClient">
		<input type="submit" value="Supprimer un compte client">
		</form>
		<br>
		<form method="get"action="EditAccount">
		<input type="submit" value="Editer un compte client">
		</form>
		<br>
		<form method="get"action="AjoutAccount">
		<input type="submit" value="Ajouter un compte client">
		</form>
		<br>
		<form method="get"action="ContactClient">
		<input type="submit" value="Echanger avec un client">
		</form>
		<br>
	</fieldset>
	<br>
	<br>
	<fieldset>
		<legend>Les opérations Clients</legend>
		<br>
		<form method="get"action="SupprOP">
		<input type="submit" value="Supprimer une opération">
		</form>
		<br>
		<form method="get"action="ContestOP">
		<input type="submit" value="Voir les opérations contestées">
		</form>
		<br>
	</fieldset>
	
</body>
</html>