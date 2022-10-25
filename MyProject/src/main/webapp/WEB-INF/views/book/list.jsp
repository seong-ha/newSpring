<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
				<th>도서번호</th>
				<th>도서명</th>
				<th>표지</th>
				<th>출판일자</th>
				<th>금액</th>
				<th>출판사</th>
				<th>도서소개</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="book">
				<tr>
					<td>${book.bookNo}</td>
					<td>${book.bookName}</td>
					<td><img src="<c:url value='/resources/images/${book.bookCoverimg}'/>"></td>
					<td><fmt:formatDate pattern="yyyy년 MM월 dd일" value="${book.bookDate}"/></td>
					<td><fmt:formatNumber value="${book.bookPrice}"/></td>
					<td>${book.bookPublisher}</td>
					<td>${book.bookInfo}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>