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
			
			<div class="table--container">
				<table class="table">
					<tr>
						<th>ID</th>	<th>IP</th> <th> Port </th>
					</tr>
					<c:forEach items="${ servers }" var="server">
						<tr>
							<td><c:out value="${ server.id }"/></td>
							<td><c:out value="${ server.ip}"/></td>
							<td><c:out value="${ server.port }"/></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</body>
</html>