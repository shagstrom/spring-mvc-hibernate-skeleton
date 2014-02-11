<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%@
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
		<h1>Users</h1>
		<form:form action="" method="post" modelAttribute="userCommand">
			<fieldset class="fieldcontainer">
				<legend>New User</legend>

				<div class="block">
					<div class="field">
						<form:label for="name" path="name">Name:</form:label>
						<form:errors path="name" cssClass="errors" />
						<form:input path="name" />
					</div>
	
					<div class="field">
						<form:label for="password" path="password">Password:</form:label>
						<form:errors path="password" cssClass="errors" />
						<form:input path="password" />
					</div>

					<div class="field vertical">
						<form:label for="email" path="email">Email:</form:label>
						<form:errors path="email" cssClass="errors" />
						<form:input path="email" />
					</div>
				</div>

				<div class="field">
					<form:label for="address" path="address">Address:</form:label>
					<form:errors path="address" cssClass="errors" />
					<form:textarea path="address" />
				</div>

				<div class="field vertical">
					<input type="submit" value="Create new user">
				</div>

			</fieldset>
		</form:form>
		<form:form action="" method="put" modelAttribute="userGrid">
			<table>
				<thead><tr><th><input type="checkbox" class="toggleAll" /></th><th>Name</th><th>Password</th><th>Email</th><th>Address</th></tr></thead>
				<tbody>
					<c:forEach var="userEntry" items="${userGrid.userMap}" varStatus="row">
						<tr>
							<td>
								<form:input cssClass="disablable-hidden" disabled="${!userEntry.value.selected}" path="userMap[${userEntry.key}].id" />
								<c:if test="${userMap[userEntry.key].selected}">
									<input type="checkbox" checked="checked" class="rowSelector" />
								</c:if>
								<c:if test="${!userMap[userEntry.key].selected}">
									<input type="checkbox" class="rowSelector" />
								</c:if>
							</td>
							<td>
								<form:errors path="userMap[${userEntry.key}].name" cssClass="errors" />
								<form:input disabled="${!userEntry.value.selected}" path="userMap[${userEntry.key}].name" />
							</td>
							<td>
								<form:errors path="userMap[${userEntry.key}].password" cssClass="errors" />
								<form:input disabled="${!userEntry.value.selected}" path="userMap[${userEntry.key}].password" />
							</td>
							<td>
								<form:errors path="userMap[${userEntry.key}].email" cssClass="errors" />
								<form:input disabled="${!userEntry.value.selected}" path="userMap[${userEntry.key}].email" />
							</td>
							<td>
								<form:errors path="userMap[${userEntry.key}].address" cssClass="errors" />
								<form:input disabled="${!userEntry.value.selected}" path="userMap[${userEntry.key}].address" />
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<p>
				<input type="submit" value="Update all enabled users">
			</p>
		</form:form>
		<script src="<c:url value='/scripts/lib/prototype.js'/>"></script>
		<script src="<c:url value='/scripts/lib/RowSelector.js'/>"></script>
		<script src="<c:url value='/scripts/user.js'/>"></script>
	</body>
</html>
