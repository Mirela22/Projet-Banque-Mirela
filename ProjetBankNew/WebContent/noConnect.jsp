<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<title>Accueil</title>

	<link rel="stylesheet" href="/noconnect.css" type="text/css"/>

</head>
	<body>
	
	<h1> Veuillez vous connecter </h1>
	
	<br>
	
		<form method="post" action="BankLogin">
			<div>
				<label for="clientIdLogin"> ClientID </label>
				<input type="text" id="clientIdLogin" name="clientIdLogin" value="" size="30" maxlength="30" ></input>
			</div>
	<br>	
			<div>					
				<label for="passwordLogin"> Password </label>
				<input type="password" id="passwordLogin" name="passwordLogin" value="" size="30" maxlength="60" />
			 </div>
	<br>		 
	         <div>	
				<input type="submit" value="Valider" />
			 </div>
		</form>
	</body>
</html>