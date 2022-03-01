<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Bomberman | Classement</title>
		<link rel="stylesheet" href="css/style.css" />
	</head>
	<body>
		<%@ include file="menu.jsp" %>
		
		<div class="main">
			<h1>Classement des joueurs</h1>
			
			<div class="ranking--container">
				<table class="ranking--table">
					<tr>
						<th>Pseudo</th>	<th>Nombre de parties gagnées</th>
					</tr>
					<c:forEach items="${ rank }" var="rank">
						<tr>
							<td><c:out value="${ rank.pseudo }"/></td> <td><c:out value="${ rank.nbGameWon }"/></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</body>
</html>