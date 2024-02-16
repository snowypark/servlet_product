<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
    <%
	String value4 = (String)request.getAttribute("key");
	String value41 = (String) application.getAttribute("key");
	String value442 = (String) session.getAttribute("key");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>
	
	<input type="text" placeholder="username"> 
	<input type="password" placeholder="password"> 
	<input type="text" placeholder="name"> 
	<input type="email" placeholder="email"> 
	
	<button onclick="handleSignupSubmit();">회원가입</button>
	
	<script src="/product/static/js/signup.js"></script>
	
</body>
</html>