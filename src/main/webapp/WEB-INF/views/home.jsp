<%@page import="com.test.dao.MemberDao"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8"%>
<%@ page import = "com.test.*" %>
<html>
<head>
<title>home</title>
</head>
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
<body>
<input type="button" id="login-page" onClick="location.href='loginPage'" value="로그인"/>&nbsp;&nbsp;
<input type="button" id="join-page" onClick="location.href='joinPage'" value="회원가입"/>

</body>
</html>



