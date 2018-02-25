<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Save Customer</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">

</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Releationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Customer</h3>

		<form:form action="saveCustomer" modelAttribute="customer"
			method="POST">
			
			<form:hidden path="id"/>

			<table>
				<tbody>

					<tr>
						<td>First Name</td>
						<td><form:input path="firstName"></form:input>
					</tr>
					<tr>
						<td>Last Name</td>
						<td><form:input path="lastName"></form:input>
					</tr>
					<tr>
						<td>Email</td>
						<td><form:input path="email"></form:input>
					</tr>

					<tr>
						<td></td>
						<td><input type="submit" value="Save"></td>
					</tr>

				</tbody>
			</table>

		</form:form>

		<div style="clear: both;">
			<p>
				<a href="${pageContext.request.contextPath}/customer/list"></a>
			</p>
		</div>

	</div>

</body>
</html>