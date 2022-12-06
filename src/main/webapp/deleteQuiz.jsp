<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Showing All Questions</h2>
<c:if test="${quizes.size() == 0}">
     <h3>No New Quizes Available</h3>
</c:if>

<h3>${message}</h3>
<table border=1>

<tr>
 <th>Title</th>
 <th>Options</th>
 <th>Answer</th>
 <th>Marks</th>
 <th>Delete</th>
</tr>
	<c:forEach items="${quizes }" var = "quiz">
<tr>
	<td><c:out value ="${quiz.quest }"></c:out></td>
	<td>
		<ol type="a">
			<li><c:out value ="${quiz.a} "></c:out></li>
			<li><c:out value ="${quiz.b} "></c:out></li>
			<li><c:out value ="${quiz.c} "></c:out></li>
			<li><c:out value ="${quiz.d} "></c:out></li>
		</ol>
	</td>
	<td><c:out value ="${quiz.ansWer}"></c:out></td>
	<td><c:out value ="${quiz.marks}"></c:out></td>
	<td><a href="removeQuiz/${quiz.id}" >Delete</a> </td>
</tr>
	<br>
	</c:forEach>
</table>
 <a href="/quizOperations">Quiz Library</a>
</body>
</html>