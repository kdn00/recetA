<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 헤더 모듈화 해서 불러오기 -->
	<%@ include file="header.jsp" %>
	
	<h4 align="center">로그인</h4>
	<form style="text-align: center" method="post" action="LoginCon">
		<input type="text" name="id" placeholder="ID를 입력해주세요" data-constraints="@Required">
		<br><br>
		<input type="password" name="pw" placeholder="PW를 입력해주세요" data-constraints="@Required">
		<br><br>
		<button type="submit">로그인</button>
	</form>
	<br>
	<div align="center">
	<a href="join.jsp">
		<button>회원가입</button>
	</a>
	</div>
</body>
</html>