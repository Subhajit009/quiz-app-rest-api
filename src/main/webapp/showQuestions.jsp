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

<c:if test="${allQuestions.size() == 0}">
     <h3>No New Questions Available</h3>
</c:if>

<ol type="1">
	<c:forEach items="${allQuestions }" var = "question">
	<li><c:out value ="${question.quest }"></c:out></li>
	<ol type="a">
		<li><c:out value ="${question.a} "></c:out></li>
		<li><c:out value ="${question.b} "></c:out></li>
		<li><c:out value ="${question.c} "></c:out></li>
		<li><c:out value ="${question.d} "></c:out></li>
		<p><c:out value ="${question.ansWer}"></c:out></p>
	</ol>
	<br>
	</c:forEach>
</ol>

<a href="/questionOperations">Question Library</a>
</body>
</html>