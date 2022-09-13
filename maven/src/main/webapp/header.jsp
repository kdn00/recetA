<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
</head>
<body>

	<!-- Top Banner-->
	<!-- Page Header-->
	<!-- RD Navbar-->

<!-- 	<nav class="rd-navbar rd-navbar-modern" data-layout="rd-navbar-fixed"
		data-sm-layout="rd-navbar-fixed" data-md-layout="rd-navbar-fixed"
		data-md-device-layout="rd-navbar-fixed"
		data-lg-layout="rd-navbar-static"
		data-lg-device-layout="rd-navbar-fixed"
		data-xl-layout="rd-navbar-static"
		data-xl-device-layout="rd-navbar-static"
		data-xxl-layout="rd-navbar-static"
		data-xxl-device-layout="rd-navbar-static"
		data-lg-stick-up-offset="56px" data-xl-stick-up-offset="56px"
		data-xxl-stick-up-offset="56px" data-lg-stick-up="true"
		data-xl-stick-up="true" data-xxl-stick-up="true"> -->

		<!-- RD Navbar Panel-->

		<!-- RD Navbar Toggle-->
		<!-- 햄버거 코드 -->
        <button class="rd-navbar-toggle" data-rd-navbar-toggle=".rd-navbar-nav-wrap"><span></span></button>
		<!-- RD Navbar Brand-->
		<div>
			<a style="display: block; " href="index.html"> <img class="brand-logo-dark"
				src="images/recetAlogotest.png" alt="" width="198" height="66" />
			</a>
		</div>

		<!-- c:choose 써서 로그인 전 후로 나눠야할 부분 -->
		<ul>
			<!-- 로그인 -->
			<a href="login.jsp">
			<button>로그인</button>
			</a>
		</ul>


		<!-- RD Navbar Nav-->
		<ul style="text-align: center;">
			<a href="index.html">Home</a>
			<a href="typography.html">오늘의 추천 메뉴</a>
			<a href="contacts.html">레시피</a>
			<a href="about-us.html">공지사항</a>
		</ul>


		<!-- 검색창 -->
		<form action="<!-- 검색 결과 처리 서블릿 파일 -->">
		<ul>
			<input type="text" placeholder="검색어 입력">
			<img  src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png" width="17" height="17">
			</a>
		</ul>
		</form>
	<!-- </nav> -->

</body>
</html>