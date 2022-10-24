<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="updateEmpInfo" method="post">
		<table border="1">
			<tr>
				<th>사원번호</th>
				<td><input type="number" id="employeeId" name="employeeId" value="${empInfo.employeeId}" readonly /></td>
			</tr>
			<tr>
				<th>성</th>
				<td><input type="text" id="firstName" name="firstName" value="${empInfo.firstName}" /></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" id="lastName" name="lastName" value="${empInfo.lastName}" /></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" id="email" name="email" value="${empInfo.email}" /></td>
			</tr>
		</table>
		<button type="submit">수정</button>
		<button type="reset">취소</button>
	</form>
</body>
</html>