<div class="menu--container">
	<a href="/BombermanJEE/index">Accueil</a>
	<a href="/BombermanJEE/ranking">Classement</a>
	<a href="/BombermanJEE/serverlist">Serveurs</a>
	<c:if test="${ !empty sessionScope }">
		<a href="/BombermanJEE/profil">Profil</a>
		<a href="/BombermanJEE/logout">Se déconnecter</a>
	</c:if>
	<c:if test="${ empty sessionScope }">
		<a href="/BombermanJEE/connexion">Connexion</a>
		<a href="/BombermanJEE/register">S'enregistrer</a>
	</c:if>
</div>

