<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Historique</title>
</head>
<body>

<p> Historique  </p>
<p> 
<c:forEach var="user" items="${historique.rows}">
 
    <c:out value="${user.ope_id}" />
 
    <c:out value="${user.ope_account_id}" />
 
    <c:out value="${user.ope_description}" />
 
</c:forEach>
 
        
 </p>
<a href="http://localhost:8080/ProjetBankNew/PageClient"> Retour à l'accueil Client</a>

</body>>
</html>