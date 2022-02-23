<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bomberman Accueil</title>
</head>
<body>
	
	<%@ include file="menu.jsp" %>
	<p>Accueil</p>
	
	<c:if test="${ !empty form.res }"><p><c:out value="${ form.res }"/></p></c:if>
	
</body>
</html>