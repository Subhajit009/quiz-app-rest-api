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




<form action="updateQuizAction" method="get">
		<ol type="1">
<h2>UPDATE QUIZZES</h2>
	<h3>QUIZ LIST</h3>
<c:if test="${questions.size() == 0}">
     <h3>No New Questions Available</h3>
</c:if>
		<c:forEach items="${quizes}" var="quiz">
		<input type="radio" id="${quiz.id}" name="quizId" value="${quiz.id}">
		<label for="${quiz.id}">
		<li><c:out value ="${quiz.quest }"></c:out></li>
			<ol type="a">
				<li><c:out value ="${quiz.a} "></c:out></li>
				<li><c:out value ="${quiz.b} "></c:out></li>
				<li><c:out value ="${quiz.c} "></c:out></li>
				<li><c:out value ="${quiz.d} "></c:out></li>
				<p>Answer: <c:out value ="${quiz.ansWer}"></c:out></p>
			</ol>
		</label>
		<br>
		</c:forEach>
		</ol>
		
	
	<ol type="1">
	<h3>QUESTION LIST</h3>
	<c:if test="${quizes.size() == 0}">
     <h3>No New Quizes Available</h3>
</c:if>
	
		<c:forEach items="${questions }" var = "question">
		<input type="radio" id="${question.id}" name="questId" value="${question.id}">
		<label for="${question.id}">
			<li><c:out value ="${question.quest }"></c:out></li>
			<ol type="a">
				<li><c:out value ="${question.a} "></c:out></li>
				<li><c:out value ="${question.b} "></c:out></li>
				<li><c:out value ="${question.c} "></c:out></li>
				<li><c:out value ="${question.d} "></c:out></li>
				<p>Answer: <c:out value ="${question.ansWer}"></c:out></p>
			</ol>
		</label>
		<br>
		</c:forEach>
	</ol>
	Add new Marks: <input type="number" name="marks">
	<input type="submit">
	</form>
<a href="/quizOperations">Quiz Library</a>
</body>
</html>