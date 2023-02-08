<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype> <!-- html5 표준임을 나타내는 doctype을 추가 -->
<html>
<head>
	<title>Home</title>
</head>
<body>
<!-- 
필드의 이름을 썼을 때 필드를 직접 호출하는게 아니라, getter를 호출한다 
ex)xxx.name을 쓰면 xxx.getName()이 호출된다.
-->
${info1.name},${info1.num}
</body>
</html>
