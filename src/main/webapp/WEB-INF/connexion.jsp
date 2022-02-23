<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
</head>
<body>
	<%@ include file="menu.jsp" %>
	<p>Connexion</p>
	
	<form method="post" action="">
	
		<p>
			<label for="login">Login:</label>
			<input type="text" name="login" id="login"/>
		</p>
		
		<p>
			<label for="password">Password:</label>
			<input type="password" name="password" id="password">
		</p>
		
		<input type="submit"/>
	</form>
	
	<c:if test="${ !empty form.res }"><p><c:out value="${ form.res }"/></p></c:if>
</body>
</html>