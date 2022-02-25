<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Bomberman | Accueil</title>
		<link href="css/style.css" rel="stylesheet">
	</head>
	<body>
	
		<%@ include file="menu.jsp" %>
		<p>Accueil</p>
		
		<c:if test="${ !empty user.pseudo }">
			<p><c:out value="Bonjour ${ user.pseudo }"/></p>
		</c:if>
		
	</body>
</html>