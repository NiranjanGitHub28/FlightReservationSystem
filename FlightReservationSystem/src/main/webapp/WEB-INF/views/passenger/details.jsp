<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--import spring suppiled JSP tag lib for URL rewriting --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%--import , for the form binding tech , spring supplied form tag lib  --%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5 align="center" style="color: blue;">${sessionScope.message}</h5>
<h5 align="center" style="color: blue; font-family: Calibri">${sessionScope.chosen}</h5>
	<form:form method="POST" modelAttribute="passenger">
		<table style=" margin: auto;">

			<tr>
				<td>Passenger Name : </td>
				<td><form:input  path="name" /></td>
				<td><form:errors path="name"/></td>
			</tr>
			<tr>
				<td>Email : </td>
				<td><form:input  path="email" /></td>
				<td><form:errors path="email"/></td>
			</tr>
			<tr>
				<td>Phone No. : </td>
				<td><form:input  type="text" path="phoneNos" /></td>
				<td><form:errors path="phoneNos"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Enter Details" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>