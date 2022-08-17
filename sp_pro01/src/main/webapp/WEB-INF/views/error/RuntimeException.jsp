<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!-- isErrorPage는 에러페이지라고 선언을 해준 것 -->
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>서버 오류</title>
</head>
<body>
	<%=exception.getMessage()%>
	<!-- 에러페이지라고 선언을하면 exception 사용 가능. -->
</body>
</html>