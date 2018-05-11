<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IT Returns</title>
</head>
<body>
<h3 align="center">IT RETURNS</h3>
<fieldset>
<form action="ITReturns" method="post">
NAME: <input type="text" name="nam"><br>
GENDER <select name="gen">
<option>Male</option>
<option>Female</option>
</select><br>
SALARY : <input type="text" name="sal"><br>
TAX DEDUCTIONS : <input type="text" name="tax"><br>
<input type="submit" value="Submit">
</form>
</fieldset>
</body>
</html>