<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book My Flight.com</title>
</head>
<body>
<h3>Welcome to Book My Flight.com</h3>
<span style="color:red;"><% 	if(null!=request.getAttribute("error"))
    {
        out.println(request.getAttribute("error"));
    }
%></span>
<fieldset>
<legend>Booking Details</legend>
<form action="ViewDetails.jsp">
Flight Number:<br> <input type="text" name="fno"><br>
Date : <br> <input type="text" name="dat"><br>
Name : <br> <input type="text" name="nam"><br>
Phone Number: <br> <input type="text" name="phn"><br>
<input type="submit" value="Reserve">
</form>
</fieldset>
<fieldset>
<legend>Flight Details</legend>
<form action="ShowFlights.jsp">
Enter Day<br>
<input type="text" name="day"><br>
<input type="submit" value="Show Flights">
</form>
</fieldset>
</body>
</html>