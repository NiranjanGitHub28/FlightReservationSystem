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
<h5 align="center" style="color: blue">Enter Card Details : </h5>
	<form:form method="post" modelAttribute="passenger">
		<table style=" margin: auto;">
			<tr>
				<td>Card Number(16 digits)</td>
				<td><form:input type="text" path="details.cardNumber" /></td>
				<td><form:errors path="details.cardNumber"/></td>
			</tr>
			<tr>
				<td>Card Holder Name</td>
				<td><form:input type="name" path="details.holderName" /></td>
				<td><form:errors path="details.holderName"/></td>
			</tr>
			<tr>
				<td>Expiry Date</td>
				<td><form:input  type="date" path="details.expiryDate" /></td>
			</tr>
			<tr>
				<td>CVV(3 digits)</td>
				<td><form:input type="number" path="details.cvv" /></td>
				<td><form:errors path="details.cvv"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Enter" /></td>
			</tr>
			</table>
	</form:form>
</body>
</html>