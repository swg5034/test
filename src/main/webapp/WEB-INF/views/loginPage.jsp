<%@page import="com.test.dao.MemberDao"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8"%>
<%@ page import = "com.test.*" %>
<%
	HttpSession session = request.getSession();
	String loginId = (String)(session.getAttribute("loginId"));
%>
<html>
<head>
<title>Login</title>
</head>
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
<body>
<form action="login">
	<h2>로그인 페이지</h2>
	ID: <input type="text" id="id" name = "id"/><br/>
	PW: <input type="password" id="pw" name = "pw"/><br/>
	<input type="submit" id="btn-login" value="로그인"/>
</form>
<script>
$(function(){
	$("#btn-login").click(function(){
		var loginId = null;
		loginId = ${loginId};
		if(loginId==null || loginId=='null'){
			alert("로그인 정보가 일치하지않습니다.");
			location.href='/loginPage';
		}else if(loginId!=null || loginId!='null'){
			alert("로그인에 성공하였습니다.");
			location.href='/main';
		}
	})
})
</script>
</body>
</html>
