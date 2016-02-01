<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kévin Giroux & Cyril Lefebvre</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
	<legend>Bonus calculation</legend>
	<form method="POST" action="<%=request.getContextPath()%>/test_servlet">
		<label for="SSN">Security Social Number : </label>
		<input type="text" name="SSN" id="SSN">
		</br>
		<label for="multiplier">Multiplier bonus :  </label>
		<input type="text" name="multiplier" id="multiplier">
		</br>
		<input type=submit class="btn btn-lg-6 btn-primary">
	</form>
</body>
</html>