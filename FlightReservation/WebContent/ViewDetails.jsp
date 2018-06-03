<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String n=request.getParameter("nam");
	String d=request.getParameter("dat");
	int fn=Integer.parseInt(request.getParameter("fno"));
	String p=request.getParameter("phn");
	int s=new Random().nextInt(500+1);
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("select fno from Flight");
	int flag=0;
	while(rs.next()){
		if(fn==rs.getInt(1)) {
			flag=1;
			break;
		}
	}
	if(flag==0){
		request.setAttribute("error","*Invaild Flight number" );
		RequestDispatcher rd= request.getRequestDispatcher("ReserveOnline.jsp");
		rd.forward(request, response);
	}
	else{
		int i=0;
		try{
		PreparedStatement ps=con.prepareStatement("insert into SeatReservation values(?,?,?,?,?)");
		ps.setInt(1, fn);
		ps.setString(2, d);
		ps.setInt(3,s);
		ps.setString(4, n);
		ps.setInt(5, Integer.parseInt(p));
		i=ps.executeUpdate();
		}catch(Exception e){
			out.println("<span style='color:red;'>*Booking Error</span>");
		}
		if(i>0)
		{
		out.println("<h4>Booking Details:</h4>");
		out.println("<h5>Name : "+n+"<br>");
		out.println("Phone Number : "+p+"<br>");
		out.println("Date : "+d+"<br>");
		out.println("Flight Number : "+fn+"<br>");
		out.println("Seat Number : "+s+"</h5><br>");
		}
		
		
		
	}
%>
</body>
</html>