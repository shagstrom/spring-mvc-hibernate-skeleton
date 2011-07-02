<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false"%>
<html>
	<head>
		<title>Users</title>
		<link rel="stylesheet" href="<c:url value='/styles/default.css' />" type="text/css" />
		<script type="text/javascript" src="<c:url value='/scripts/lib/prototype.js' />"></script>
		<script type="text/javascript" src="<c:url value='/scripts/lib/RowSelector.js' />"></script>
		<script type="text/javascript" src="<c:url value='/scripts/user.js' />"></script>
	</head>
	<body>
		<h1>Users</h1>
		<form:form action="" method="post" modelAttribute="userCommand">
			<fieldset class="fieldcontainer">
				<legend>New User</legend>

				<div class="block">
					<div class="field">
						<form:label for="name" path="name">Name:</form:label>
						<form:errors path="name" cssClass="error" /><br />
						<form:input path="name" />
					</div>
	
					<div class="field vertical">
						<form:label for="email" path="email">Email:</form:label>
						<form:errors path="email" cssClass="error" /><br />
						<form:input path="email" />
					</div>
				</div>

				<div class="field">
					<form:label for="address" path="address">Address:</form:label>
					<form:errors path="address" cssClass="error" /><br />
					<form:textarea path="address" />
				</div>

				<div class="field vertical">
					<input type="submit" value="Create new user">
				</div>

			</fieldset>
		</form:form>
		<form:form action="" method="put" modelAttribute="usersCommand">
			<table>
				<thead><tr><th><input type="checkbox" class="toggleAll" /></th><th>Name</th><th>Email</th><th>Address</th></tr></thead>
				<tbody>
					<c:forEach var="user" items="${usersCommand.userCommands}" varStatus="row">
						<tr>
							<td>
								<form:checkbox cssClass="rowSelector" path="userCommands[${row.index}].selected" />
							</td>
							<td>
								<form:errors path="userCommands[${row.index}].name" cssClass="error" />
								<form:input disabled="${!user.selected}" path="userCommands[${row.index}].name" />
							</td>
							<td>
								<form:errors path="userCommands[${row.index}].email" cssClass="error" />
								<form:input disabled="${!user.selected}" path="userCommands[${row.index}].email" />
							</td>
							<td>
								<form:errors path="userCommands[${row.index}].address" cssClass="error" />
								<form:input disabled="${!user.selected}" path="userCommands[${row.index}].address" />
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<p>
				<input type="submit" value="Update all enabled users">
			</p>
		</form:form>
	</body>
</html>
