<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSP - request(JSP 내장 객체)</title>
</head>
<body>
	<h3>* 내장 객체란? JSP에서 기본적으로 제공하는 객체들로 request, response, out, session, application, page, exception 이 있다.<br>
		Scriptlet tag와 Expression tag에서 사용할 수 있게 암시적으로 선언된 객체이다.</h3>
	<hr>
	<h1>JSP - request (JSP 내장 객체)</h1>
	<h2>request : HttpServletRequest 객체 참조 변수</h2>
	<hr>
	<h2>request.getMethod()</h2>
	<h4> : getMethod() -> 현재 요청 방식 리턴</h4>
	<p>
		request.getMethod() -> <%=request.getMethod() %>
	</p>
	<form action="./request" method="get">
		<button type="submit">GET 전송</button>
	</form>
	<form action="./request" method="post">
		<button type="submit">POST 전송</button>
	</form>
	<hr>
	<h2>request.getParameter(name)</h2>
	<h4>: getParameter(name) -> name 파라미터의 값 리턴</h4>
	<p>
		request.getParameter(name) -> <%=request.getParameter("param_name") %>
		<br>
		name 은 HTML 폼 관련 속성 중 name 속성에 정의한 속성값이다.
		<br>
		(즉, 사용자가 입력한 value 값을 추출한다.)
	</p>
	<form action="./request" method="get">
		<div>
			<input type="text" name="param_name">
		</div>
		<div>
			<button type="submit">전송</button>
		</div>
	</form>
	<%-- <form> 요소 내의 submit 버튼이 눌러지거나 Javascript와 연결되어있는 button을 통해서 submit이 수행된다면
	현재 <form> 안에 사용자가 입력한 모든 내용들이 action 속성에서 명시하는 웹 프로그램 페이지로 전송됩니다. 
	즉, 사용자가 form 내에 입력한 데이터들만 전송되고 그 입력한 데이터들만 열린 페이지의 모~든 메서드에 적용된다--%>
	<hr>
	<h2>request.getParameterValues()</h2>
	<h4> : getParameterValues(name) -> name 파라미터의 값을 배열 형태로 리턴(checkbox 등)</h4>
	<p>
		request.getParameterValues() ->
		<%
			if(request.getParameterValues("param_chk") != null) {
				String[] sArr = request.getParameterValues("param_chk");
				for(String s: sArr) {
		%>
					<%=s + " " %>
		<%
				}
			}
		%>
		<br>name이 중복되었으나 value값이 다를경우 배열에 담아 추출한다.
	</p>
	<form action="./request" method="get">
		<div>
			<input type="checkbox" name="param_chk" value="a">
			<input type="checkbox" name="param_chk" value="b">
			<input type="checkbox" name="param_chk" value="c">
			<input type="checkbox" name="param_chk" value="d">
		</div>
		<div>
			<button type="submit">전송</button>
		</div>
	</form>
	<hr>
	<h2>request.getParameterNames()</h2>
	<h4> : getParameterNames() -> 요청에 포함된 파라미터 이름 리턴(name값 출력)</h4>
	<p>
		request.getParameterNames() ->
		<%
			Iterator<String> iter = request.getParameterNames().asIterator();
			while(iter.hasNext()) {
		%>
				<%=iter.next() + " " %>
		<%
			}
		%>
	</p>
	<form action="./request" method="get">
		<div>
			<input type="text" name="username">
		</div>
		<div>
			<input type="password" name="password">
		</div>
		<div>
			<button type="submit">전송</button>
		</div>
	</form>
	<%-- 위쪽 코드에서 request.getParameterValues()에 있는 체크박스 전송 버튼을 먼저 눌렀다면
		request.getParameterNames() 에서 출력되는 값은 체크박스의 name인 param_chk 이다.
		그 후에 username, password 타입 담긴 전송 버튼을 누르면 그때서야 
		request.getParameterNames()이 출력하는 값이 username, password가 된다.--%>
	<hr>
	<h2>request.setCharacterEncoding()</h2>
	<h4> : setCharacterEncoding() 클라이언트에서 서버로 전달된 값을 지정한 문자 셋으로 변경</h4>
	<p>
		request.setCharacterEncoding("UTF-8") ->
		<%=request.getParameter("param_name") %>
		<br>
		servlet 페이지에서 작성해야 적용됨.
	</p>
	<form action="./request" method="post">
		<div>
			<input type="text" name="param_name">
		</div>
		<button type="submit">전송</button>
	</form>
	<hr>
	<h2>request.getSession()</h2>
	<h4> : getSession() 현재 세션 객체 리턴,
		  사용자정보(로그인정보)를 세션에 담아놓고 관리하는 용도
	</h4>
	<p>
		request.getSession() -> <%=request.getSession() %><br>
		JSESSIONID = "<%=request.getSession().getId() %>"
	</p>
	<form action="./request" method="get">
		<button type="submit">전송</button>
	</form>
</body>
</html>




