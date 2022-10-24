<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<style type="text/css">
	table, thead, tbody, tr, th {
		border: 3px solid black;
	}
	
	th {
		background-color: skyblue;
	}
	
	td {
		border: 1px solid black;
	}
</style>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>게시글 번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${fbList}" var="fbvo">
			<tr>
				<td>${fbvo.bno}</td>
				<td>${fbvo.title}</td>
				<td>${fbvo.writer}</td>
				<td><fmt:formatDate value="${fbvo.regdate}" pattern="yyyy년 MM월 dd일"/></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<form id="boardInfo" action="info" method="get">
		<input type="hidden" name="bno" value="">
	</form>
	<script type="text/javascript">
		let resultMsg = '${msg}';
		if (resultMsg != null && resultMsg != '') {
			alert(resultMsg);	
		}
		
		// 마우스오버아웃때 색넣기
		$('tbody tr').on({
			'mouseover' : function() {
				let target = event.currentTarget;
				$(target).css('background-color', 'aquaMarine');
			},
			'mouseout' : function() {
				let target = event.currentTarget;
				$(target).css('background-color', 'white');
			}
		});
		
		$('tbody td').click(function () {
			let bno = $(this).parent().children().eq(0).text();
			$('#boardInfo input').val(bno);
			$('#boardInfo').submit();
		})
	</script>
</body>
</html>