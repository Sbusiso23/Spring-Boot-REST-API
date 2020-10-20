<!Doctype html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
	<head>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	</head>
	<body>
		<form:form action="/register" modelAttribute="user" method="POST">
			<form:label path="name">Name</form:label>
			<form:input type="text" path="name"/><br/>
			
			<form:label path="email">Email</form:label>
			<form:input type="email" path="email"/><br/>
			
			<form:label path="password">Password</form:label>
			<form:input type="password" path="password"/><br/>
			
			<form:label path="password_rpt">Confirm Password</form:label>
			<form:password type="password" path="password_rpt" /><br/><br/>
			
			<input type="submit" class="btn btn-primary" value="Register">
		</form:form>
	</body>
</html>