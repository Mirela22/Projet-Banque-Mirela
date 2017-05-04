<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form method="get" action="BankLogin">
	
		<div>
			<label for="External_ID"> External ID </label>
			<input type="text" id="External_ID" name="External_ID" value="" size="30" maxlength="30" ></input>
			
			<br/>
			<label for="firstname"> Prenom </label>
			<input type="text" id="firstname" name="firstname" value="" size="30" maxlength="30" ></input>
			
			<br/>
			<label for="lastname"> Nom de famille </label>
			<input type="text" id="lastname" name="lastname" value="" size="30" maxlength="30" ></input>
			
			<br/>
			<label for="email"> email</label>
			<input type="text" id="email" name="email" value="" size="30" maxlength="30" ></input>
			
			
			<br/>
			<label for="password"> Password</label>
			<input type="text" id="password" name="password" value="" size="30" maxlength="30" ></input>
			
			<br/>
			
			<br/>
			<label for="dob"> dob</label>
			<input type="text" id="dob" name="dob" value="" size="30" maxlength="30" ></input>
			
			<br/>
			<label for="phone"> Numéro de téléphone</label>
			<input type="text" id="phone" name="phone" value="" size="30" maxlength="30" ></input>
		
			
		 </div>
		 
         <div>	
		
			<input type="submit" value="Valider" />
			
		</div>
		
	</form>
</body>
</html>