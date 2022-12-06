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

<c:if test="${questions.size() == 0}">
     <h3>No New Questions Available</h3>
</c:if>


<form action="addMarks" method="post">
<ol type="1">
	<c:forEach items = "${questions }" var ="question">
	<li><c:out value ="${question.quest }"></c:out></li>
		<ol type="a">
			<li><c:out value ="${question.a} "></c:out></li>
			<li><c:out value ="${question.b} "></c:out></li>
			<li><c:out value ="${question.c} "></c:out></li>
			<li><c:out value ="${question.d} "></c:out></li>
			<p>Answer: <c:out value ="${question.ansWer}"></c:out></p>
			
		</ol>
		<br>
	</c:forEach>
</ol>
		
	<label for="id">Choose a question to add:</label>
	<select name="id">
	<c:forEach items = "${questions }" var ="question">
	  <option value="${question.id}"><c:out value ="${question.quest }"></c:out></option>

	</c:forEach>
	</select>
	
	Enter the marks: <input type="number" name="marks" >
	<button type="submit">Add</button>
</form>

<h2>${message }</h2>
<a href="quizOperations">Quiz Library</a>
</body>
</html>