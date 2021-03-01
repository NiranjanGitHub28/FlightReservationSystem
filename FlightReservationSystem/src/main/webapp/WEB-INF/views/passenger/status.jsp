<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--import spirng supplied JSP tag lib --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reservation Success!</title>
</head>
<body>
<h4>Display Reservation Status</h4>
	<h5 style="color: green;">${sessionScope.user_details}</h5>
	<h5>${sessionScope.idmessage}</h5>
	<h5>
		Reservation Done Successfully, Tickets will be sent to you shortly.
		You have been logged out..
	</h5>
</body>
</html>