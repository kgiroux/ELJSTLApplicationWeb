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
				<th>Bonus</th>
			</thead>
			<tbody>
				<c:forEach items="${listResult}" var="result">
					<tr>
						<td>${result.ssn}</td>
						<td>${!empty result.bonus ? result.bonus : "Bonus vide !"}</td>
					 
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>