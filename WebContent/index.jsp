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
	<form method="POST" action="<%=request.getContextPath()%>/test_servlet">
		<c:forEach var="i" begin="1" end="5">
			<label for="SSN">Security Social Number : </label>
			<input type="text" name="SSN" required>
			</br>
			<label for="multiplier">Multiplier bonus :  </label>
			<input type="text" name="multiplier">
			</br>
			
		</c:forEach>
		<input type="submit" class="btn btn-lg-6 btn-primary"/>
			<input type="reset" class="btn btn-lg-6 btn-danger"/>
	</form>
</body>
</html>