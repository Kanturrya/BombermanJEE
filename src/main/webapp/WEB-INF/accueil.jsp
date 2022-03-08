<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Bomberman | Accueil</title>
		<link href="css/style.css" rel="stylesheet">
	</head>
	<body>
		<%@ include file="menu.jsp" %>
		
		<div class="main">
			<h1>Accueil</h1>
			
			
			<div class="accueil--container">
				<div class="presentation">
					<p><b>
						<c:if test="${ !empty user.pseudo }">
							<c:out value="Bonjour ${ user.pseudo }!"/>
						</c:if>
						<c:if test="${ empty user.pseudo }">
							<c:out value="Bonjour!"/>
						</c:if>
					 </b></p>
					 <p>Bienvenue sur le site de Bomberman JEE, un projet r�alis� qui s'inscrit dans les mati�res R�seaux & Web Avanc�s.</p>
					 <p>Ce projet a �t� r�alis� par <b>Bertherat Guillaume</b> & <b>Horion Antoine</b> dans le cadre du Master Informatique de l'Universit� d'Angers.</p>
					 <p>Sur ce site Internet, vous aurez acc�s � diff�rentes fonctionnalit�s, tels que la liste des serveurs disponibles, le classement des joueurs, etc.</p>
				 </div>
			 </div>
		</div>
		
		<%@ include file="footer.jsp" %>
	</body>
</html>