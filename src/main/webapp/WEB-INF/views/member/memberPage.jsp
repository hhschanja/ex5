<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<p>아이디: ${member.id }</p>
<p>비밀번호: ${member.pw }</p>
<p>이름: ${member.name }</p>
<p>나이: ${member.age }</p>
<p>신분: ${member.grade }</p>

<!-- ★★★★★ 정말 중요한 경로 ★★★★★ -->
<!-- 현재 있는 곳이 member이니까 하나 올라가면 루트가 되잖아 루트의 resources가 되는거지 -->
<a href="../resources/upload/${member.filename}"><img style="width: 200px; height: 200px;" alt="" src="../resources/upload/${member.filename}"></a>

<p>${member.oriname}</p>


</body>
</html>