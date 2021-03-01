<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--import spring suppiled JSP tag lib for URL rewriting --%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign In!</title>
</head>
<body>
<h4 align="center">Flights Search Form!</h4>
<h5 align="center" style="color: blue;">${sessionScope.message}</h5>
	<form  method="post">
		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>From</td>
				<td><input type="text" name="departureCity" /></td>
			</tr>
			<tr>
				<td>To</td>
				<td><input type="text" name="arrivalCity" /></td>
			</tr>
			<tr>
				<td>Departure Date</td>
				<td><input type="date" name="departureDate" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Search" /></td>
			</tr>
		</table>
	</form>
</body>
</html>