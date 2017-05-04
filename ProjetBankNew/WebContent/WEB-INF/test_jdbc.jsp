<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta charset="utf-8" />
        <title>Tests JDBC</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/form.css"/>" />
        
        <jsp:useBean id="user" class="com.ib.beans.BeanUser" scope="request"/>
    </head>
    <body>
        <h1>Tests JDBC</h1>
          
        
<ul>
 	<%-- 
		        <c:forEach var="user" items="${NewUser}" >
		           < <li> <c:out value="${user.getPerson_id()}"/>
		             
		            	<c:out value="${user.person_id}"/>
		            	<c:out value="${user.value.person_id}"/>
		            	
		            	 <c:out value="${user.person_firstname}"/>
		            	 <c:out value="${user.person_lastname}"/>
		            	 <c:out value="${user.person_email}"/>
		            	 <c:out value="${user.person_password}"/>
		            	 <c:out value="${user.person_dob}"/>
		            	 <c:out value="${user.person_token}"/>
		            	 <c:out value="${user.person_phone_number}"/>
		           	 
		            </li>
		        </c:forEach>
		--%>        
		 
</ul>        
   
    </body>
</html>