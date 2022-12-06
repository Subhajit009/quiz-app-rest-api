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

<c:if test="${allQuestions.size() == 0}">
     <h3>No New Questions Available</h3>
</c:if>

<table border=2>

<tr>
 <th>Title</th>
 <th>Options</th>
 <th>Answer</th>
 <th>Action</th>
</tr>
	<c:forEach items="${allQuestions }" var = "question">
<tr>
	<td><c:out value ="${question.quest }"></c:out></td>
	<td>
		<ol type="a">
			<li><c:out value ="${question.a} "></c:out></li>
			<li><c:out value ="${question.b} "></c:out></li>
			<li><c:out value ="${question.c} "></c:out></li>
			<li><c:out value ="${question.d} "></c:out></li>
		</ol>
	</td>
	<td><c:out value ="${question.ansWer}"></c:out></td>
	<td> <a href="editQuestion/${question.id}" >Edit</a> | <a href="delete/${question.id}" >Delete</a> </td>
</tr>
	<br>
	</c:forEach>
</table>
<h3>${message}</h3>

 <a href="/questionOperations">Question Library</a>
</body>
</html>