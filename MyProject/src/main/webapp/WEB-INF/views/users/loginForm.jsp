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
	<div align="center">
		<form id="loginForm" action="login" onsubmit="return check()">
			<label for="userId">아이디</label>
			<input type="text" name="userId"/>
			<label for="userPassword">비밀번호</label>
			<input type="text" name="userPassword"/>
			<input type="submit" value="등록">
		</form>
	</div>
	<script type="text/javascript">
		function check() {
			$.ajax({
                url : 'http://localhost:8081/users/loginCheck',
                type : 'post',
                data : $('#loginForm').serialize(),
                success : function (data) {
                	console.log('★★★★★★★★★★★★★★★★★★★★★★★★');
                    if (data == 'id') {
                    	alert('아이디가 틀렸습니다.');
                    	$('input[name="userId"]').focus();
                    	return false;
                    } else if (data == 'pw') {
                    	alert('비밀번호가 틀렸습니다.');
                    	$('input[name="userPassword"]').focus();
                    	return false;
                    } else {
                    	alert("정상적으로 로그인되었습니다.");
                    	return true;
                    }
                },
                error : function (reject) {
                    console.log(reject);
                }
            });
		}
	</script>
</body>
</html>