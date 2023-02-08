<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype> <!-- html5 표준임을 나타내는 doctype을 추가 -->
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  하이루 내 이름은 ${name1} 입니다 </P>
<p> 내 나이는 ${age} 입니다 </p>
<form action="/spring/" method="post"> <!-- action = "" 써줘도 됨 -->
	<input type = "text " name ="name"><br>
	<input type = "text " age ="age"><br>
	<button>전송</button>
</form>
</body>
</html>
