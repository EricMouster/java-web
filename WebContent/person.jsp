<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib	prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page import="person.Person"%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<link href="https://unpkg.com/ionicons@4.1.2/dist/css/ionicons.min.css" rel="stylesheet">
<title>Insert title here</title>
<style>
	.icon {
		font-size: 1.5rem;
		vertical-align: middle;
	}
</style>
</head>
<body style="margin: 100px;">
	<div class="container">
		<% if (request.getAttribute("error") == "true") { %>
			<div class="alert alert-danger">Merci de remplir le formulaire</div>
		<% } %>
		<div class="row" style="margin-bottom: 15px;">
			<form action="person" method="POST">
				<input type="hidden" class="form-control" name="id" id="personId">
				<div class="row">
				  <div class="col-3">
				    <input id="firstname" type="text" class="form-control" placeholder="First name" name="firstname">
				  </div>
				  <div class="col-3">
				    <input type="text" class="form-control" placeholder="Last name" name="lastname" id="lastname">
				  </div>
				  <div class="col-4">
				    <input type="text" class="form-control" placeholder="email" name="email" id="email">
				  </div>
					<button type="submit" class="btn btn-primary col-2" id="send">Add <i class="icon ion-md-checkmark-circle"></i></button>
				</div>
			</form>
		</div>
		<div class="row">
			<table class="table table-striped">
				<thead class="thead-dark">
					<tr>
						<th scope="col">#</th>
						<th scope="col">Prénom</th>
						<th scope="col">Nom</th>
						<th scope="col">Email</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="person" items="${ persons }">
						<tr>
							<th scope="row">${person.id}</td>
							<td>${person.firstName}</td>
							<td>${person.lastName}</td>
							<td>${person.email}</td>
							<td><button type="button" class="btn btn-danger actionDelete" data-personid="${person.id}">Delete <i class="icon ion-md-trash"></i></button>
							<button
								type="button"
								class="btn btn-primary actionEdit"
								data-personid="${person.id}"
								data-personfirstname="${person.firstName}"
								data-personlastname="${person.lastName}"
								data-personemail="${person.email}"
							>Edit <i class="icon ion-md-create"></i></button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<script type="text/javascript">
		let elementsDelete = document.getElementsByClassName("actionDelete")
		let elementsEdit = document.getElementsByClassName("actionEdit")
		for (element of elementsDelete) {
			element.addEventListener('click', (elem) => {
				let personId = elem.target.getAttribute("data-personid")
				window.location = "http://localhost:8080/test/person/delete?id="+personId
			})
		}
		for (element of elementsEdit) {
			element.addEventListener('click', (elem) => {
				let personId = elem.target.getAttribute("data-personid")
				let personFirstName = elem.target.getAttribute("data-personfirstname")
				let personLastName = elem.target.getAttribute("data-personlastname")
				let personEmail = elem.target.getAttribute("data-personemail")
				document.getElementById("personId").value = personId
				document.getElementById("firstname").value = personFirstName
				document.getElementById("lastname").value = personLastName
				document.getElementById("email").value = personEmail
				document.getElementById("send").innerHTML = "Edit <i class=\"icon ion-md-checkmark-circle\"></i>";
			})
		}
	</script>
</body>
</html>