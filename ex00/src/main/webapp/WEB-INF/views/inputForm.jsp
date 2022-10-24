<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
</head>
<body>
	<form action="users" method="post">
		<label for="">이름</label>
		<input type="text" name="name">
		<label for="">나이</label>
		<input type="number" name="age">
		<button type="submit">전송</button>
	</form>
	<p>리스트로 처리</p>
	<form action="userList" method="post">
		<label for="">이름1</label>
		<input type="text" name="list[0].name">
		<label for="">나이1</label>
		<input type="number" name="list[0].age">
		
		<label for="">이름2</label>
		<input type="text" name="list[1].name">
		<label for="">나이2</label>
		<input type="number" name="list[1].age">
		
		<button type="submit">전송</button>
	</form>
	<br>
	<button onclick="javasecript:ajaxUserList();">ajax</button>
	<script>
		function ajaxUserList() {
			let data = [
				{ "name" : "한국이", "age" : 20 },
				{ "name" : "신정판", "age" : 30 }
			];
			
			$.ajax({
				url : "userList",
				type : 'post',
				contentType : "application/json",
				data : JSON.stringify(data),
				success : function (data) {
					console.log('성공', data);
				},
				error : function (reject) {
					console.log('실패', reject);
				}
			});
		};
	</script>
</body>
</html>