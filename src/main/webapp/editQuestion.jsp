<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Editing the question: ${question.quest}</h2>
<form action="/editQuestion" method ="POST">
Enter Question Title:<input type = "text" name="question" required><br>
Enter Option 1:<input type = "text" name="option" required><br>
Enter Option 2:<input type = "text" name="option" required><br>
Enter Option 3:<input type = "text" name="option" required><br>
Enter Option 4:<input type = "text" name="option" required><br>
Enter The Right Option:<input type="text" name="rightAnswer" pattern="[a-d]{1}" required>
<br>
<input type="hidden" name="id" value ="${ question.id}">
<input type="submit" value ="Update Question">
</form>

</body>
</html>