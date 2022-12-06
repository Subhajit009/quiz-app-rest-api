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
<h2>SHOWING ALL QUESTIONS</h2>
<c:if test="${quizes.size() == 0}">
     <h3>No New Quizes Available</h3>
</c:if>

<ol type="1">
	<c:forEach items="${quizes }" var = "question">
	
	<li><c:out value ="${question.quest }"></c:out></li>
	<ol type="a">
		<li><c:out value ="${question.a} "></c:out></li>
		<li><c:out value ="${question.b} "></c:out></li>
		<li><c:out value ="${question.c} "></c:out></li>
		<li><c:out value ="${question.d} "></c:out></li>
		<p>Answer: <c:out value ="${question.ansWer}"></c:out></p>
		<p>Marks: <c:out value ="${question.marks}"></c:out></p>
	</ol>
	<br>
	</c:forEach>
</ol>

<a href="/quizOperations">Quiz Library</a>
</body>
</html>