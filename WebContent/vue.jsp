<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Voici les données que la page de traitement était censée enregistrer :<br />
First Name : ${param.firstname}<br />
Last Name : <%= request.getParameter("lastname") %><br />
Email : <%= request.getParameter("email") %><br />
</body>
</html>