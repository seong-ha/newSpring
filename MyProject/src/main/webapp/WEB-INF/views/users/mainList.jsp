<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<style type="text/css">
	table {
		margin : auto auto;
		border: 3px solid black;
	}
	
	th {
		border: 3px solid black;
		text-align: center;
		font-size: 1.2em;
	}
	
	td {
		border: 1px solid black;
		text-align: center;
	}
	
	thead {
		background-color: lightSkyBlue;
	}
	
	tbody {
		background-color: aquaMarine;
	}
	
	img {
		width: 70px;
		height: 95px;
	}
</style>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>가입일자</th>
				<th>연락처</th>
				<th>이메일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="users">
				<tr>
					<td>${users.userId}</td>
					<td>${users.userName}</td>
					<td><fmt:formatDate pattern="yyyy년 MM월 dd일" value="${users.userDate}"/></td>
					<td>${users.userPhone}</td>
					<td id="email">${users.userEmail}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<div align="center">
		<button type="button" onclick="location.href='${pageContext.request.contextPath}/users/loginForm'">관리자 로그인</button>
	</div>
</body>
</html>
