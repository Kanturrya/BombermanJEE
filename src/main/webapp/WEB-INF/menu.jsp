<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
</head>
<body>

	<c:if test="${ !empty sessionScope }">
		<p>Bonjour ${ sessionScope.user.pseudo }</p>
	</c:if>
	
	<ul>
		<li><a href="/BombermanJEE/">Accueil</a></li>
		<li><a href="/BombermanJEE/profil">Profil</a></li>
		<li><a href="/BombermanJEE/connexion">Connexion</a></li>
		<li><a href="/BombermanJEE/classement">Classement</a></li>
		<li><a href="/BombermanJEE/serverlist">Liste Serveurs</a></li>
		<li><a href="/BombermanJEE/signup">Sign Up</a></li>
	</ul>
	
	<c:if test="${ !empty sessionScope }">
		<form method="get" action="connexion">
			<input type="submit" name="logout" id="logout" value="LogOut"/>
		</form>
	</c:if>
	
</body>
</html>