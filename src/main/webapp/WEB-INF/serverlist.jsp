<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Bomberman | Serveurs</title>
		<link rel="stylesheet" href="css/style.css" />
	</head>
	<body>
		<%@ include file="menu.jsp" %>
		
		<div class="main">
			<h1>Serveurs</h1>
			
			<c:forEach items="${ servers }" var="server">
				<p><c:out value="${ server.ip }"/> </p>
			</c:forEach>
		</div>
	</body>
</html>