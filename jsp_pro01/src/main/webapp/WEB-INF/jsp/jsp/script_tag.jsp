<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %> 
<%-- 
	<%@ 지시자 태그(Directive tag) %> 는 JSP page전체에 영향을 미치는 정보를 기술할 때 쓰임
	<%@ 지시자 [속성 명=“value”] ... %> 
--%>
<%! 
	// 멤버 변수
	private String name = "Hello";

	// 메서드
	public String hello() {
		return "Hello";
	}
%> <%-- <%! 선언문 태그(Declaration tag) %> --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSP - Script Tag</title>
</head>
<body>
	<h1>JSP  - Script Tag</h1>
	<%-- <% 코드(Scriptlet tag) %> , <%= 표현식(Expression tag) :out.print()의 역할 수행 %> --%>
	<ul>
	<%
		//주석
		for(int i = 0; i < 5; i++) {
			Random rd = new Random();
	%>
		<li><%=rd.nextInt(100) %></li>
	<%
		}
	%>
	</ul>
	<br>
	<input type="text" value="<%=name %>"><br>
	<input type="text" value="<%=hello() %>">
</body>
</html>



