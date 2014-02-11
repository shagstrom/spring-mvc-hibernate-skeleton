<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@
	taglib prefix="form" uri="http://www.springframework.org/tags/form" %><%@
	taglib prefix="spring" uri="http://www.springframework.org/tags"
%><!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Users</title>
		<link rel="stylesheet" href="<c:url value='/styles/default.css'/>">
	</head>
	<body>
		<h1>Login</h1>
		<form action="<c:url value='j_spring_security_check' />" method="POST">
			<fieldset class="fieldcontainer">
				<legend>Enter username and password</legend>

				<div class="block">
					<div class="field">
						<label>Username:</label>
						<input type="text" name="j_username">
					</div>
	
					<div class="field">
						<label>Password:</label>
						<input type="password" name="j_password">
					</div>

				</div>

				<div class="field vertical">
					<input type="submit" value="Login">
				</div>

			</fieldset>
		</form>
	</body>
</html>
