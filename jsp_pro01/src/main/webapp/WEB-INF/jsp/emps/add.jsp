<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>직원 추가</title>
	<%@ include file="../module/head.jsp" %>
</head>
<script>
function dupCheck(name, value) {
	$.ajax({
		type: "get",
		url: "/ajax/dupCheck",
		data: {
			name: name,
			value: value
		},
		dataType: "json",
		success: function(data, status) {
			var form = document.forms[0];
			if(data.errCode === "duplicate") {
				if(form[name].nextElementSibling === null) {
					var label = document.createElement("label");
					label.setAttribute("class", "input-label-error");
					label.innerText = data.errMessage;
					form[name].after(label);					
				} else {
					form[name].nextElementSibling.setAttribute("class", "input-label-error");
					form[name].nextElementSibling.innerText = data.errMessage;
				}
			} else if(data.errCode == "notDuplicate") {
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

function existsCheck(name, value) {
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
	<h1>직원 추가 화면</h1>
	<section class="container">
		<form class="small-form" action="./add" method="post">
			<div class="input-form wide">
				<label class="input-label">직원 ID</label>
				<input class="input-text" type="text" name="empId" onchange="dupCheck(this.name, this.value);" value="${data.empId}">
			</div>
			<div class="input-form wide">
				<label class="input-label">이름</label>
				<input class="input-text" type="text" name="empName" value="${data.empName}">
			</div>
			<div class="input-form wide">
				<label class="input-label">이메일</label>
				<input class="input-text" type="text" name="email" onchange="dupCheck(this.name, this.value);" value="${data.email}">
			</div>
			<div class="input-form wide">
				<label class="input-label">전화번호</label>
				<input class="input-text" type="text" name="phone" value="${data.phone}">
			</div>
			<div class="input-form wide">
				<label class="input-label">직급 ID</label>
				<input class="input-text" type="text" name="jobId" onchange="existsCheck(this.name, this.value);" value="${data.jobId}">
			</div>
			<div class="input-form wide">
				<label class="input-label">급여</label>
				<input class="input-text" type="text" name="salary" value="${data.salary}">
			</div>
			<div class="input-form wide">
				<label class="input-label">보너스</label>
				<input class="input-text" type="text" name="commission" value="${data.commission}">
			</div>
			<div class="input-form wide">
				<label class="input-label">매니저 ID</label>
				<input class="input-text" type="text" name="mngId" onchange="existsCheck(this.name, this.value);" value="${data.mngId}">
			</div>
			<div class="input-form wide">
				<label class="input-label">부서 ID</label>
				<input class="input-text" type="text" name="deptId" onchange="existsCheck(this.name, this.value);" value="${data.deptId}">
			</div>
			<div class="input-form wide form-right">
				<button class="btn btn-outline btn-ok" type="submit">저장</button>
				<button class="btn btn-outline btn-cancel" type="button" onclick="location.href='../emps'">취소</button>
			</div>
		</form>
	</section>
</body>
</html>