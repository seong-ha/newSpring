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
				<c:if test="${type == 0}">
					<th>비번</th>
				</c:if>
				<th>이름</th>
				<th>가입일자</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="users">
				<tr>
					<td>${users.userId}</td>
					<c:if test="${type == 0}">
						<td>${users.userPassword}</td>
					</c:if>
					<td>${users.userName}</td>
					<td><fmt:formatDate pattern="yyyy년 MM월 dd일" value="${users.userDate}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
