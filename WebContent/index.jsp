<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>  
	<head>  
		<meta charset="ISO-8859-1">  
		<title>Home page / Login</title>  
	</head>  
	<body>
	<style>  
	body {
   background-image: url('https://cdn4.vectorstock.com/i/1000x1000/52/33/calculator-with-icons-on-background-vector-22445233.jpg');
   background-repeat: no-repeat;
   background-attachment: fixed;
   background-size: cover;
 }
</style>
    
	<form action="Login" method = "post">  
		<label>Name </label><input type="text" name="uname">
		<label>Password </label><input type="text" name="pwd">
		<p style = "color:red"><%= request.getAttribute("error") == null ? "" : request.getAttribute("error") %></p>   
		<input type="submit" value="Send">  
	</form>  
	</body>  
</html> 