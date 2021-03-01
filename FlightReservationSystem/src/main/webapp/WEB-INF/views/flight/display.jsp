<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--import JSTL supplied core tag lib --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--import spring supplied JSP tag lib --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Available Flights</title>
</head>
<body>

	<h5 align="center" style="color: blue; font-family: Calibri">${sessionScope.status}</h5>	
	<table style="background-color: cyan; width:500px ;margin:auto; font-family:Calibri;" ${sessionScope.state}>

			<thead>
				<tr bgcolor="lightblue" align="center">
					<th>Airline</th>
					<th>Departure City</th>
					<th>Arrival City</th>
					<th>Departure Time</th>
					<th></th>
				</tr>
			</thead>
		<tbody>
			<c:forEach var="f" items="${sessionScope.flight_list}">
				<tr bgcolor="white"align="center">
					<td>${f.airline}</td>
					<td>${f.departureCity}</td>
					<td>${f.arrivalCity}</td>
					<td>${f.departureTime}</td>
					<td><a href="<spring:url value='/passenger/details'/>">Select</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>