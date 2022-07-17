<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dept.model.DeptDTO" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>부서 수정</title>
	<%@ include file="../module/head.jsp" %>
</head>
<script>
function existCheck(name, value) {
	$.ajax({
		type: "get",
		url: "/ajax/existsCheck",
		data: {
			name: name,
			value: value
		},
		dataType: "json",
		success: function(data, status) {
			var form = document.forms[0];
			if(data.errCode === "notExists") {
				if(form[name].nextElementSibling === null) {					
					var label = document.createElement("label");
					label.setAttribute("class", "input-label-error");
					label.innerText = data.errMessage;
					form[name].after(label);
				} else {
					form[name].nextElementSibling.setAttribute("class", "input-label-error");
					form[name].nextElementSibling.innerText = data.errMessage;
				}
			} else if(data.errCode == "exists") {
				if(form[name].nextElementSibling === null) {	
					var label = document.createElement("label");
					label.setAttribute("class", "input-label-ok");
					label.innerText = data.errMessage;
					form[name].after(label);
				} else {
					form[name].nextElementSibling.setAttribute("class", "input-label-ok");
					form[name].nextElementSibling.innerText = data.errMessage;
				}
			}
		}
	});
}
</script>
<body>
	<section class="container">
		<form class="small-form" action="./mod" method="post">
			<input type="hidden" name="deptId" value="${data.deptId}" readonly>
			<div class="input-form wide">
				<input class="input-text" type="text" name="deptName" value="${data.deptName}" placeholder="부서명">
			</div>
			<div class="input-form wide">
				<input class="input-text" type="text" name="mngId" onchange="existCheck(this.name, this.value)" value="${data.mngId}" placeholder="매니저 ID">
			</div>
			<div class="input-form wide">
				<input class="input-text" type="text" name="locId" onchange="existCheck(this.name, this.value)" value="${data.locId}" placeholder="지역 코드">
			</div>
			<div class="input-form wide form-right">
				<button class="btn btn-outline btn-ok" type="submit">수정</button>
			</div>
		</form>
	</section>
	<% System.out.println("mod jsp 2"); %>
</body>
</html>


