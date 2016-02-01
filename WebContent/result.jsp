<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kévin Giroux & Cyril Lefebvre</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
	<legend>Bonus calculation</legend>
	<div>
		<table class="table table-striped">
			<thead>
				<th>SSN</th>
				<th>Multiplier</th>
				<th>Bonus</th>
			</thead>
			<tbody>
				<c:forEach items="${listResult}" var="result">
					<tr>
						<td><c:out value="${result.ssn }"></c:out></td>
						<td><c:out value="${result.multiplier }"></c:out></td>
						<td><c:out value="${result.bonus }"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<p>${data.ssn}</p>
		<p>${data.multiplier}</p>
		<p><c:out value="${data.bonus}" default="Le multiplier n'est pas renseigné !" /></p>
	</div>
</body>
</html>