<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
</head>
<body>
	<form id="insertForm" action="insert" method="post" onsubmit="return formOption()">
		<div>
			<h3>게시글 등록</h3>
		</div>
		<table>
			<tr>
				<th>글 번호</th>
				<td><input type="number" name="bno" value="${no}" readonly></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="contents"></textarea></td>
			</tr>
			<tr>
				<th>첨부이미지</th>
				<td><input type="text" name="image"></td>
			</tr>
		</table>
		<button type="submit">등록</button>
		<button type="button" onclick="location.href='list'">목록</button>
	</form>
	<script type="text/javascript">
		$(document).ready(function () {
			/* $('button[type="submit"]').click(formOption); */
			$('button:contains("목록")').click(function () {
				location.href='list';
			});
		});
		
		function formOption() {
			
			let title = $('input[name="title"]');
			let writer = $('input[name="writer"]');
			let contents = $('textarea[name="contents"]');
			
			if (title.val() == "") {
				alert("제목이 입력되지 않았습니다.");
				title.focus();
				return false;
			} else if (writer.val() == "") {
				alert("작성자가 입력되지 않았습니다.");
				writer.focus();
				return false;
			} else if (contents.val() == "") {
				alert("내용이 입력되지 않았습니다.");
				contents.focus();
				return false;
			}
			
			return true;
		}
	</script>
</body>
</html>