<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
</head>
<body>
	<!-- 
private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private double salary;
	private double commissionPct;
	private int managerId;
	private int departmentId;
 -->



	<div id="id"></div>
	<button type="button" onclick="location.href='insertForm'">사원등록</button>
	<br>
	<table border="1">
		<thead>
			<tr>
				<th>employee_id</th>
				<th>first_name</th>
				<th>last_name</th>
				<th>email</th>
				<th>phone_number</th>
				<th>hire_date</th>
				<th>job_id</th>
				<th>salary</th>
				<th>commission_pct</th>
				<th>manager_id</th>
				<th>department_id</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${empInfoList}" var="empInfo">
				<tr name="${empInfo.employeeId}">
					<!-- onclick="location.href='info?employeeId=${empInfo.employeeId}'" -->
					<td>${empInfo.employeeId}</td>
					<td>${empInfo.firstName}</td>
					<td>${empInfo.lastName}</td>
					<td>${empInfo.email}</td>
					<td>${empInfo.phoneNumber}</td>
					<td>${empInfo.hireDate}</td>
					<td>${empInfo.jobId}</td>
					<td>${empInfo.salary}</td>
					<td>${empInfo.commissionPct}</td>
					<td>${empInfo.managerId}</td>
					<td>${empInfo.departmentId}</td>
					<td><button>삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<form id='input'>
			<input type="hidden" name="employeeId">
		</form>
	</div>

	<script type="text/javascript">
		// insert, update에 대한 성공실패 메세지 alert
		let message = '${msg}';
		if (message != null && message != '') {
			alert('${msg}');
		}
		
		/* 
		let empList = [];
		let emp = {};
		<c:forEach items="${empInfoList}" var="empInfo">
			emp = {
				employeeId : '${empInfo.employeeId}',
				firstName : '${empInfo.firstName}',
				lastName : '${empInfo.lastName}',
				email : '${empInfo.email}',
				phoneNumber : '${empInfo.phoneNumber}',
				hireDate : '${empInfo.hireDate}',
				jobId : '${empInfo.jobId}',
				salary : '${empInfo.salary}',
				commissionPct : '${empInfo.commissionPct}',
				managerId : '${empInfo.managerId}',
				departmentId : '${empInfo.departmentId}'
			};
			empList.push(emp);
		</c:forEach>
		let table = $('<table border="1"/>');
		
		$(empList).each(function(idx, obj) {
			let tr = $('<tr/>');
			
			$(tr).append($('<td/>').text(obj.employeeId));
			$(tr).append($('<td/>').text(obj.firstName));
			$(tr).append($('<td/>').text(obj.lastName));
			$(tr).append($('<td/>').text(obj.email));
			$(tr).append($('<td/>').text(obj.phoneNumber));
			$(tr).append($('<td/>').text(obj.hireDate));
			$(tr).append($('<td/>').text(obj.jobId));
			$(tr).append($('<td/>').text(obj.salary));
			$(tr).append($('<td/>').text(obj.commissionPct));
			$(tr).append($('<td/>').text(obj.managerId));
			$(tr).append($('<td/>').text(obj.departmentId));
		
			$(table).append(tr);
		});
		
		$('#id').append(table);
		
		*/
		
		// 마우스오버아웃때 색넣기
		$(document).ready(function() {
			$('tbody tr:not(:first)').on({
				'mouseover' : function() {
					let target = event.currentTarget;
					$(target).css('background-color', 'aquaMarine');
				},
				'mouseout' : function() {
					let target = event.currentTarget;
					$(target).css('background-color', 'white');
				}
			});
		})

		// ajax는 데이터만 조작가능해서 페이지 전환 안됨.
		
		// td클릭하면 해당 사원번호로 사원정보상세보기
		$('tbody td').click(function() {
			let empId = $(this).parent().attr('name');
			$('#input > input').val(empId);
			$('#input').prop('action', 'info').prop('method', 'get').submit();
		});
		
		// 삭제버튼 누르면 ajax로 DB에서 삭제하고 돌아와서 해당 tr로 remove해주기
		$('tbody td button').click(function (event) {
			let tr = $(this).parent().parent();
		  // let empId = $(this).parent().parent().attr('name');
		    let empId = $(this).closest('tr').attr('name')
			
			$.ajax({
				url : 'delete/' + empId,
				// delete/ + date타입하면 date가 쿼리스트링형태가 되어버리므로 포맷오류난다. 그래서 쓰면 안된다.
				success : function (data) {
					alert(data);
					$(tr).remove();
				},
				error : function (reject) {
					console.log('통신실패', reject);
				}
			});
			
			// 이벤트 전파 막기.
			// event.stopPropagation();
			return false;
		});
	</script>
</body>
</html>