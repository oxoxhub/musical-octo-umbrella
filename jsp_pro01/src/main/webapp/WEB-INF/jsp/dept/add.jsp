<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dept.model.DeptDTO" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>부서 추가</title>
</head>
<body>
	<h1>부서 추가 화면</h1>
	<%
		String deptId = "", deptName = "", mngId = "", locId = "";
		if(request.getAttribute("error") != null) {
			DeptDTO data = (DeptDTO)request.getAttribute("data");
			//deptId 변수들을 String 타입으로 선언했기 때문에
			//int타입을 가진 data.getDeptId를 String.valueOf로 String 문자열로 변환해준 것.
			//String.valueOf는 어떠한 값을 넣어도 모두 String문자열로 변환해준다.
			//원래 String타입을 가진 data.getDeptName는 형변환해주지 않았다.
			deptId = String.valueOf(data.getDeptId());
			deptName = data.getDeptName();
			mngId = String.valueOf(data.getMngId());
			locId = String.valueOf(data.getLocId());
	%>
			<script type="text/javascript">
				alert("<%=request.getAttribute("errorMsg") %>");
			</script>
	<%
		}
	%>
	<form action="./add" method="post">
		<div>
			<input type="text" name="deptId" value="<%=deptId %>" placeholder="부서 ID">
		</div>
		<div>
			<input type="text" name="deptName" value="<%=deptName %>" placeholder="부서명">
		</div>
		<div>
			<input type="text" name="mngId" value="<%=mngId %>" placeholder="매니저 ID">
		</div>
		<div>
			<input type="text" name="locId" value="<%=locId %>" placeholder="지역 코드">
		</div>
		<div>
			<button type="submit">저장</button>
		</div>
	</form>
</body>
</html>


