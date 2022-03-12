<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html> 
<head> 
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
	<title>Spring Boot Application with JSP</title> 
</head> 
<body>
	<h3>로그인</h3>
	<form action="/login" method="POST">
		<input type="text" name="username" value="" placeholder="아이디" />
		<br />
		<input type="password" name="password" value="" placeholder="아이디" />
		<br />
		<button>로그인</button>
	</form>
	<a href="/joinForm">회원가입</a>
</body>
</html>
