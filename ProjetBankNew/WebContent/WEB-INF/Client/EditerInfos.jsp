<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editer des informations</title>
</head>
<body>

<h1> Editer des informations  </h1>

<h2> Informations du client ${NewUser.person_lastnam} ${NewUser.person_firstname} :  </h2>

			
			<p>Email : ${NewUser.person_email}</p>
			
			<form method="post" action="EditerInfos">
				<input type="email" id="person_email" name="person_email" value="Nouveau Mail" size="30" maxlength="30" ></input>
				<input type="text" id="External_id" name="External_id" value="Entrez votre numéro de client" size="30" maxlength="30" ></input>
				<input type="submit" value="Editer" />
			</form>
			
			<p>Mot de Passe: ${NewUser.person_password}</p>
			
			<form method="post" action="EditerInfos">
				<input type="text" id="person_password" name="person_password" value="Nouveau MDP" size="30" maxlength="30" ></input>
				<input type="text" id="External_id" name="External_id" value="Entrez votre numéro de client" size="30" maxlength="30" ></input>
				<input type="submit" value="Editer" />
			</form>
			
			<p>Date de naissance : ${NewUser.person_dob}</p>
			
			<form method="post" action="EditerInfos">
				<input type="date" id="person_dob" name="person_dob" value="Nouvelle DDN" size="30" maxlength="30" ></input>
				<input type="text" id="External_id" name="External_id" value="Entrez votre numéro de client" size="30" maxlength="30" ></input>
				<input type="submit" value="Editer" />
			</form>
			
			<p>Telephone : ${NewUser.person_phone_number}</p>
			
			<form method="post" action="EditerInfos">
				<input type="text" id="person_phone_number" name="person_phone_number" value="Nouveau telephone" size="30" maxlength="30" ></input>
				<input type="text" id="External_id" name="External_id" value="Entrez votre numéro de client" size="30" maxlength="30" ></input>
				<input type="submit" value="Editer" />
			</form>
		
<a href="http://localhost:8080/ProjetBankNew/PageClient"> Retour à l'accueil Client</a>

</body>
</html>