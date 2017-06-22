<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<c:choose>
<c:when test="${empty member}">
<h1><a href="./member/memberLogin">LOGIN</a></h1>
<h1><a href="./member/memberJoin">회원가입</a></h1>
</c:when>
<c:otherwise>
<h1><a href="./member/memberLogout">로그아웃</a></h1>
<h1><a href="./member/memberPage">마이페이지</a></h1>
</c:otherwise>
</c:choose>
</body>
</html>
