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
		<!--[if lt IE 9]>
			<div class="legacy-browser">You are using a Legacy Browser - it is not supported. Please upgrade to <a href="http://windows.microsoft.com/en-US/internet-explorer/downloads/ie-9/worldwide-languages">IE9</a>, Firefox, Safari, Chrome or Opera.</div>
		<![endif]-->
		<h1>Users</h1>
		<form:form action="" method="post" modelAttribute="userCommand">
			<fieldset class="fieldcontainer">
				<legend>New User</legend>

				<div class="block">
					<div class="field">
						<form:label for="firstName" path="firstName">First Name:</form:label>
						<form:errors path="firstName" cssClass="errors" />
						<form:input path="firstName" />
					</div>
	
					<div class="field">
						<form:label for="lastName" path="lastName">Last Name:</form:label>
						<form:errors path="lastName" cssClass="errors" />
						<form:input path="lastName" />
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
					<input class="submit" type="submit" value="Create new user">
				</div>

			</fieldset>
		</form:form>
		<form:form action="" method="put" modelAttribute="userGrid">
			<table>
				<thead><tr><th><input type="checkbox" class="toggleAll" /></th><th>First Name</th><th>Last Name</th><th>Email</th><th>Address</th></tr></thead>
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
								<form:errors path="userMap[${userEntry.key}].firstName" cssClass="errors" />
								<form:input disabled="${!userEntry.value.selected}" path="userMap[${userEntry.key}].firstName" />
							</td>
							<td>
								<form:errors path="userMap[${userEntry.key}].lastName" cssClass="errors" />
								<form:input disabled="${!userEntry.value.selected}" path="userMap[${userEntry.key}].lastName" />
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
	</body>
</html>
