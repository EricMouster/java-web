<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib	prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Project Page</title>
</head>
<body>
<c:forEach var="ii" begin="10" end="15" >
	${ ii }
</c:forEach>
<% for (int i=0; i<5; i++) { %>
	<%= i %>
<% } %>
</body>
</html>