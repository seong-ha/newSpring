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
		<label for="userId">아이디</label>
		<input type="text" name="userId" required/>
		<label for="userPassword">비밀번호</label>
		<input type="password" name="userPassword" required/>
		<button onclick="check()">로그인</button>
	</div>
	<script type="text/javascript">
		function check() {
			let id = $('input[name="userId"]');
			let pw = $('input[name="userPassword"]');
			console.log(id.val());
			if (id.val() == "") {
				alert("아이디가 입력되지 않았습니다.");
				id.focus();
				return false;
			} else if (pw.val() == "") {
				alert("비밀번호가 입력되지 않았습니다.");
				pw.focus();
				return false;
			}
			
			$.ajax({
                url : 'http://localhost/shj/users/loginCheck',
                type : 'post',
                data : { "userId" : id.val(),
						 "userPassword" : pw.val() },
                success : function (data) {
                	// 반환 코드별로 메세지 alert.
                    if (data == 'id') {
                    	alert('존재하지 않는 아이디입니다.');
                    	id.val('');
                    	pw.val('');
                    	$(id).focus();
                    } else if (data == 'pw') {
                    	alert('비밀번호가 틀렸습니다.');
                    	pw.val('');
                    	$(pw).focus();
                    } else if (data == 'type') {
                    	alert('관리자가 아닙니다.');
                    	id.val('');
                    	pw.val('');
                    	$(id).focus();
                    } else {
                    	alert("정상적으로 로그인되었습니다.");
                    	location.href = 'login';
                    }
                },
                error : function (reject) {
                    console.log(reject);
                }
            });
			return false;
		}
	</script>
</body>
</html>