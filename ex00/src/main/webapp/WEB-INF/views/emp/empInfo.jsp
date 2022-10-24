<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 포맥과 관련된 tag(숫자,날짜) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="updateSal" method="post">
		<table border="1">
			<tr>
				<th>사원번호</th>
				<td><input type="number" id="employeeId" name="employeeId" value="${empInfo.employeeId}" readonly /></td>
			</tr>
			<tr>
				<th>성</th>
				<td>${empInfo.firstName}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${empInfo.lastName}</td>
			</tr>
			<tr>
				<th>입사일</th>
				<td><fmt:formatDate value="${empInfo.hireDate}" pattern="yyyy년 MM월 dd일" /></td>
			</tr>
			<tr>
				<th>부서번호</th>
				<td>${empInfo.departmentId}</td>
			</tr>
			<tr>
				<th>직업</th>
				<td>${empInfo.jobId}</td>
			</tr>
			<tr>
				<th>급여</th>
				<td><fmt:formatNumber value="${empInfo.salary}" type="currency" currencySymbol="$"/></td>
			</tr>
		</table>
		<button type="submit">연봉 인상</button>
	</form>
	<form action="updateForm" method="post">
		<input type="hidden" name="employeeId" value="${empInfo.employeeId}">
		<button type="submit">사원정보수정</button>
	</form>
	
	<script type="text/javascript">
		function updateEmpInfo(empId) {
			$('#empInfo').prop('action', 'updateForm').
		}
	</script>
</body>
</html>