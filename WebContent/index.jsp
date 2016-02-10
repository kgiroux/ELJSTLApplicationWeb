<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kévin Giroux & Cyril Lefebvre</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
	<legend>Bonus calculation</legend>
	<form method="POST"
		action="<%=request.getContextPath()%>/CalculateBonus10">
		<c:forEach var="i" begin="1" end="2">
			<div class="row">
				<div class="col-lg-6">
					<label for="SSN">Security Social Number : </label> <input
						type="text" name="SSN_${i}" required>
				</div>
				<div class="col-lg-6">
					<label for="multiplier">Multiplier bonus : </label> <input
						type="text" name="multiplier_${i}">
				</div>
			</div>
			<c:forEach var="j" begin="1" end="2">
				<div class="row">
					<div class="col-lg-6"></div>
					<div class="col-lg-6">
						<label for="multiplier">Multiplier bonus : </label> <input
							type="text" name="multiplier_${i}">
					</div>
				</div>
			</c:forEach>
		</c:forEach>
		<input type="submit" class="btn btn-lg-6 btn-primary" /> <input
			type="reset" class="btn btn-lg-6 btn-danger" />
	</form>
	<legend>Affiche bonus</legend>
	<form method="POST"
		action="<%=request.getContextPath()%>/CalculateBonus11">
		<div class="row">
			<div class="col-lg-2">
				<input type="text" name="SSN" required>
			</div>
			<div class="col-lg-1">
				<input type="submit" class="btn btn-lg-6 btn-primary" />
			</div>
		</div>
		<table class="table table-striped">
			<thead>
				<th>Bonus</th>
			</thead>
			<tbody>
				<c:forEach items="${listResult}" var="result">
					<tr>
						<td>${!empty result.bonus ? result.bonus : "Bonus vide !"}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>
</html>