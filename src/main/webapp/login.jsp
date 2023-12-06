<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 style="color:red">${errorMsg}</h3>
<form action="login">
 <input type="text" name="username" placeholder="Enter username"><br><br>
 <input type="text" name="password" placeholder="Enter password"><br>
 <input type="submit" value="Login">
</form>
</body>
</html>