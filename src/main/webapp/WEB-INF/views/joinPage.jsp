<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원가입페이지</h2>
	<form action="loginPage">
		ID: <input type="text" id="id"/><br/>
		PW: <input type="password" id="pw"/><br/>
		NAME: <input type="text" id="name"/><br/>
		<input type="submit" id="btn-submit" value="제출하기"/>
	</form>
</body>
</html>