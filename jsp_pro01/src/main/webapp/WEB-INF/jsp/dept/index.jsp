<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, dept.model.DeptDTO" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>부서 조회 결과</title>
	<link href="/jsp01/static/css/default.css">
	<script src="jsp01/static/js/default.js"></script>
</head>
<script type="text/javascript">
window.onload = function() {
	var form = document.forms[0];
	//document.forms : 모든 form태그가 나온다
	form.addEventListner("submit",formCheck);
}

function formCheck(e) {
	var f = e.target;
	e.preventDefault();
	
	if(f.search.value.trim() === "") {
		f.search.value = f.search.value.trim();
		return;
	}
	f.submit();
}

</script>
<body>
	<h1>부서 조회 결과</h1>
	<div>
		<button type="button" onclick="location.href='./depts/add'">추가</button>
	</div>
	<div>
		<form action="./depts" method="get">
		<!-- action은 폼의 데이터를 서버로 보낼때 해당 데이터가 도착할 URL을 명시한다.
			처음에 조회 버튼을 눌렀을 때 전체 부서조회 결과가 나오는 이유는 mvc.jsp의 부서조회 버튼을 눌렀고
			그 순간 getParameter는 null이 된다. 사용자가 입력한 값이 없기때문에 처음엔 input name="search"의 value값이 null이다.
			DeptController의 로직에 의해서 getParameter가 null이면 datas = service.getAll();을 수행하게 만들었기 때문에
			부서 전체 조회 결과가 화면에 출력되어 나온 것이다.
			만약 action의 경로를 잘못 적으면 404오류 페이지가 나온다. (오류 메시지 : 요청된 리소스 [/jsp01/dept]은(는) 가용하지 않습니다.)
		 -->
			<div>
				<input type="text" name="search">
				<button type="submit">조회</button>
			</div>
		</form>
	</div>
	<table>
		<tr>
			<th>DeptId</th>
			<th>DeptName</th>
			<th>MngId</th>
			<th>LocId</th>
		</tr>
		<% 
			if(request.getAttribute("datas") != null){
				List<DeptDTO> datas = (List<DeptDTO>)request.getAttribute("datas"); //다운캐스팅
				for(DeptDTO data: datas) { 
		%>
				<tr>
					<td><%=data.getDeptId() %></td>
					<td><%=data.getDeptName() %></td>
					<td><%=data.getMngId() %></td>
					<td><a href="./locs?search=<%=data.getLocId() %>"><%=data.getLocId() %></a></td>
					<td>
						<button type="button" onclick="location.href='./depts/mod?id=<%=data.getDeptId() %>'">수정</button>
						<button type="button" onclick="location.href='./depts/del?id=<%=data.getDeptId() %>'">삭제</button>
					</td>
				</tr>
		<% 
				}
			} else {
		%>
			<tr>
					<td colspan="4">검색 결과가 없습니다.</td>
			</tr>
		<%
			}
		%>
		<%--System.out.println("dept jsp 테스트"); --%>
	</table>
	<%
		if(request.getAttribute("pageList") != null) {
			List<Integer> pageList = (List<Integer>) request.getAttribute("pageList");
			int currentPage = (int)(request.getAttribute("page"));
	%>
			<ul> 
	<%
			if(currentPage - 1 > 0) {
	%>
				<li><a href="./depts?page=<%=currentPage - 1 %>">Prev</a></li>
	<%
			}
			int i = currentPage - 1;
			int maxPage = i + 5 > pageList.size() ? pageList.size() : i + 5;
			for(; i < maxPage; i++) {
	%>
				<li><a href="./depts?page=<%=pageList.get(i) %>"><%=pageList.get(i) %></a></li>
	<%			
			}
			if(currentPage + 1 <= pageList.size()) {
	%>
				<li><a href="./depts?page=<%=currentPage + 1 %>">Next</a></li>
	<%
			} 
	%>
			</ul>
	<% 
		}
	%>
	
</body>
</html>


