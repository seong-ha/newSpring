<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>elTest</title>
</head>
<body>
	<table>
		<tr>
			<th>el 내장객체</th>
			<th>thymeleaf</th>
		</tr>
		<tr>
			<td><%=request.getParameter("name") %></td>
			<td>${param.name}</td>
		</tr>
	</table>

</body>
</html>