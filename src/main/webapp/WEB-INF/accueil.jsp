<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bomberman Accueil</title>
</head>
<body>
	
	<%@ include file="menu.jsp" %>
	<p>Accueil</p>
	
	<c:if test="${ !empty user.login }"><p><c:out value="Hello ${ user.login }, ${ user.pseudo }"/></p></c:if>
	
</body>
</html>