<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des comptes</title>
</head>
<body>
<p> Liste des comptes  </p>

        <h1>Liste Comptes Client</h1>
        
        
        
        <p>${listeComptesClient }</p>

<p> Boucle forEach ne marche pas : </p>
        <c:forEach items="${listeComptesClient}" var="message" varStatus="boucle">
            <c:out value="${listeComptesClient}"/>
        </c:forEach>
        
        <a href="http://localhost:8080/ProjetBankNew/PageClient"> Retour à l'accueil Client</a>
</body>
</html>