<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Bomberman | Votre profil</title>
		<link rel="stylesheet" href="css/style.css" />
	</head>
	<body>
		<%@ include file="menu.jsp" %>
		
		<div class="main">
			<h1>Profil de <c:out value="${ user.pseudo }"/></h1>
		
			<div class="table--container">
				<table class="table">
					<tr>
						<th>Nombre de parties jouées</th>
						<th>Nombre de parties gagnées</th>
						<th>Ratio</th>
					</tr>
					<tr>
						<td><c:out value="${ played }"/></td>
						<td><c:out value="${ won }"/></td>
						<td><c:out value="${ ratio }"/></td>
					</tr>
				</table>
			</div>
			
			<div class="data--container">
				
			</div>
		</div>
		
		<%@ include file="footer.jsp" %>
	</body>
</html>