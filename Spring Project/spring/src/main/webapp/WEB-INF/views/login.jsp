<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype> <!-- html5 표준임을 나타내는 doctype을 추가 -->
<html>
<head>
	<title>Home</title>
</head>
<body>

<form action="/spring/login" method="post"> <!-- action = "" 써줘도 됨 -->
	<input type = "text " name ="id"><br>
	<input type = "password " name ="pw"><br>
	<button>회원가입</button>
</form>
</body>
</html>
