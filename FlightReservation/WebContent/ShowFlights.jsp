<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String day=request.getParameter("day");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from Flight where weekdays LIKE '%"+day+"%';");
%>
<table border="1px" align="center">
<caption>Flights Available</caption>
<tr>
<th>Flight_Number</th>
<th>Flight_Name</th>
<th>Day</th>
</tr>
<% while(rs.next()) { %>
<tr>
<td> <%= rs.getInt(1) %> </td>
<td> <%= rs.getString(2) %> </td>
<td> <%= rs.getString(3) %> </td>
</tr>
<% } %>
</table>
</body>
</html>