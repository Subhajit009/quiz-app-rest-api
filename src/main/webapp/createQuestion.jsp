<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="insertQuestion" method ="get">
Enter Question Title:<input type = "text" name="question" required><br><br>
Enter Option 1:<input type = "text" name="options" required><br><br>
Enter Option 2:<input type = "text" name="options" required><br><br>
Enter Option 3:<input type = "text" name="options" required><br><br>
Enter Option 4:<input type = "text" name="options" required><br><br>
Enter The Right Option:<input type="text" name="rightAnswer" pattern="[a-d]{1}" required>
<br><br>
<input type="submit">
</form>
<br>
<h2>${message }</h2>

<a href="/questionOperations">Question Library</a>

</body>
</html>