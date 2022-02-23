<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
</head>
<body>
	<%@ include file="menu.jsp" %>
	<p>Sign Up</p>
	
	<form method="post" action="">
	
		<p>
			<label for="login">Login(Used for the connection !):</label>
			<input type="text" name="login" id="login"/>
		</p>
		
		<p>
			<label for="pseudo">Pseudo:</label>
			<input type="text" name="login" id="login"/>
		</p>
		
		<p>
			<label for="password">Password:</label>
			<input type="password" name="password" id="password">
		</p>
		
		<input type="submit"/>
	</form>
	
	<p> <a href="/BombermanJEE/connexion">Connexion</a> </p>
	
</body>
</html>