<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Bomberman | S'enregistrer</title>
	<link rel="stylesheet" href="css/style.css" />
	</head>
	<body>
		<%@ include file="menu.jsp" %>
		<p>Sign Up</p>
		
		<form method="post" action="">
		
			<p>
				<label for="login">Identifiant:</label>
				<input type="text" name="login" id="login"/>
			</p>
			
			<p>
				<label for="pseudo">Pseudo:</label>
				<input type="text" name="pseudo" id="pseudo"/>
			</p>
			
			<p>
				<label for="password">Mot de passe:</label>
				<input type="password" name="password" id="password">
			</p>
			
			<input type="submit"/>
		</form>
		
		<p> <a href="/BombermanJEE/connexion">Connexion</a> </p>
		
	</body>
</html>