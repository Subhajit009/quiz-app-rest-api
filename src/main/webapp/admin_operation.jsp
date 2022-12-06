<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h4>${message }</h4>

	<form action="checkLogin" method="POST">
		<table>
			<tr>
			<th>USERNAME</th>
			<td><input type ="text" name ="adminUsername"></td>
			</tr>
			<tr>
			<th>PASSWORD</th>
			<td><input type ="number" name ="adminPasscode"></td>
			</tr>
			<tr>
			<td><input type ="submit"></td>
			</tr>
		</table>
	</form>
	<a href="/">Back</a>
</body>
</html>