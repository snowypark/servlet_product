<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%
	// 스크립트릿
	List<String> names = List.of("김준일","김준이","김준삼");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>hello</h1>
	<ul>
		<% for(String name : names) {
		%>
		
			<li>${name}</li>
		<%           
			}
		%>
	</ul>
	
</body>
</html>