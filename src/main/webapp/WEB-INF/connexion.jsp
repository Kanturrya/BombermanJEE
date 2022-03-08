<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Bomberman | Connexion</title>
		<link rel="stylesheet" href="css/style.css" />
	</head>
	<body>
		<%@ include file="menu.jsp" %>
		
		<div class="main">
			<h1>Connexion</h1>
			
			<div class="form--container">
				<c:if test="${ !empty status }">
					<p><c:out value="${ status }"/></p>
				</c:if>
				
				<form class="form" method="post" action="">
					<p>
						<label for="login">Identifiant:</label>
						<input type="text" name="login" id="login" placeholder="Identifiant"/>
					</p>
					
					<p>
						<label for="password">Mot de passe:</label>
						<input type="password" name="password" id="password" placeholder="Mot de passe">
					</p>
					
					<input class="form--submit" type="submit" value="Valider"/>
				</form>
				
				<p>Pas de compte? <a href="/BombermanJEE/register">S'enregistrer.</a></p>
			</div>
		</div>
		
		<%@ include file="footer.jsp" %>
	</body>
</html>