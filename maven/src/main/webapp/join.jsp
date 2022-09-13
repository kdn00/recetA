<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="header.jsp" %>
	
	<h4 align="center">회원가입</h4>
	<form align="center" method="post" action="JoinCon">

		<input type="text" name="id" placeholder="ID를 입력해주세요"
			data-constraints="@Required"> <br>
		<br> <input type="password" name="pw" placeholder="PW를 입력해주세요"
			data-constraints="@Required"> <br>
		<br> <input type="password" name="pw" placeholder="PW를 다시 입력해주세요"
			data-constraints="@Required"> <br>
		<br> <input type="text" name="name" placeholder="이름을 입력해주세요">
		<br>
		<br> <input type="number" name="tel"
			placeholder="전화번호를 '-'없이 입력해주세요." data-constraints="@Numeric">
		<br>
		<br>
		<button type="submit">회원가입</button>

	</form>

</body>
</html>