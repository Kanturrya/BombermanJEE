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
			
			
			
			<div class="form--container">
				<h1>Modifier ses informations</h1>
				<form class="form" method="post" action="">
					<p>
						<label for="login">Pseudo:</label>
						<input type="text" name="pseudo" id="pseudo"/>
					</p>
					
					<p>
						<label for="password">Nouveau mot de passe:</label>
						<input type="password" name="new_password" id="new_password">
					</p>
					
					<p>
						<label for="password">Mot de passe actuel:</label>
						<input type="password" name="cur_password" id="cur_password">
					</p>
					
					<input class="form--submit" type="submit" value="Valider"/>
					
					<c:if test="${ !empty status1 }">
						<p><c:out value="${ status1 }"/></p>
					</c:if>
					<c:if test="${ !empty status2 }">
						<p><c:out value="${ status2 }"/></p>
					</c:if>
				</form>
			</div>
		</div>
		
		<%@ include file="footer.jsp" %>
	</body>
</html>