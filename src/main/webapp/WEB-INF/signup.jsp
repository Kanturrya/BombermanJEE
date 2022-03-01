<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Bomberman | S'enregistrer</title>
	<link rel="stylesheet" href="css/style.css" />
	</head>
	<body>
		<%@ include file="menu.jsp" %>
		
		<div class="main">
			<h1>S'enregistrer</h1>
	
			<div class="form--container">
				<form class="form" method="post" action="">
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
					
					<input class="form--submit" type="submit" value="Valider"/>
				</form>
				
				<p>Déjà un compte? <a href="/BombermanJEE/connexion">Se connecter</a></p>
			</div>
		</div>		
	</body>
</html>