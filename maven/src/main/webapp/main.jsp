<%@page import="com.recetA.domain.Member"%>
<%@page import="java.util.List"%>
<%@page import="com.recetA.domain.Basic"%>
<%@page import="com.recetA.domain.BasicDAO"%>
<%@page import="java.util.Random"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<link  href="css/style.css"  rel="stylesheet"  type="text/css">
<head>
    <meta charset="utf-8">
    <title>recetA 홈페이지에 오신걸 환영합니다.</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap" rel="stylesheet">
    
    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>

<body>
	<%
	// 로그인 세션 불러오기
	Member loginMember = (Member)session.getAttribute("loginMember");
	System.out.println(loginMember);
	
	//랜덤 메뉴 추천 1개
	System.out.println("[RandomRecipe]");

	// 0. post방식 인코딩
	request.setCharacterEncoding("UTF-8");

	// 1. 파라미터 수집
	// 1-1. 랜덤 추천은 파라미터 수집x
	Random rand = new Random();
	int b_code = rand.nextInt(500);

	// 2. 수집된 데이터를 객체에 담기
	// 2-1. 수집한게 없어서 안 담음

	// 3. Mapper.xml에서 SQL문 만들어 오기
	// 레시피명, 레시피 url 검색

	// 4. BasicDAO에 메소드 생성하기
	// 4-1. 랜덤 레시피 출력 함수 : ArrayList<Basic> selectRandom()

	// 5. BasicDAO에서 생성한 메소드 호출하기
	// 5-1. 랜덤 레시피 분류 출력 함수 : ArrayList<Basic> selectRandom()
	BasicDAO dao = new BasicDAO();
	Basic randomrecipe = dao.selectRandom(b_code);
	System.out.println(randomrecipe.getB_code());
	System.out.println(randomrecipe.getB_name());
	System.out.println(randomrecipe.getB_url());

	// 6. 명령 후 처리
	if (randomrecipe != null) {
		// 정보 유지를 위해 세션에 로그인 정보 저장
		// 1. 세션 객체 생성
		/* HttpSession session = request.getSession(); */

		// 2. 세션에 저장
		session.setAttribute("randomrecipe", randomrecipe);
		Basic randomrecipesession = (Basic) session.getAttribute("randomrecipe");

	} else {

	}
	%>
	<div class="container-xxl position-relative bg-white d-flex p-0">
        <!-- Spinner Start -->
        <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->

        <!-- Sidebar Start -->
        <div class="sidebar pe-4 pb-3">
            <nav class="navbar bg-light navbar-light">
                <a href="main.jsp" class="navbar-brand mx-4 mb-3 navbar bg-danger row rounded">
                    <h3 class="text-primary text-white mb-0"><i class="fa fa-hashtag me-2"></i> recetA</h3>
                </a>
                <div class="d-flex align-items-center ms-4 mb-4">
                    <div class="position-relative">
                        <i class="bi bi-person-check"></i>
                        <!-- <img class="rounded-circle" src="img/user.jpg" alt="" style="width: 40px; height: 40px;"> -->
                        <div class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1"></div>
                    </div>
                    <div class="ms-3">
						<%-- JSTL 방식 --%>
						<c:choose>
							<c:when test="${empty loginMember}">
								<h6 class="mb-0">ID</h6>
								<span>이름</span>
							</c:when>
							<c:otherwise>
								<h6 class="mb-0">${loginMember.m_id}</h6>
								<%-- <span>이름</span> --%>
							</c:otherwise>
						</c:choose>
					</div>
                </div>
                <div class="navbar-nav w-100">
                    <a href="main.jsp" class="nav-item nav-link active"><i class="bi bi-egg-fried"></i>HOME</a>
                    <div class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="bi bi-cup"></i>레시피</a>
                        <div class="dropdown-menu bg-transparent border-0">
                            <a href="RecipepageCon?b_ctype=korean" class="dropdown-item">한식</a>
                            <a href="RecipepageCon?b_ctype=chinese" class="dropdown-item">중식</a>
                            <a href="RecipepageCon?b_ctype=japanese" class="dropdown-item">일식</a>
                            <a href="RecipepageCon?b_ctype=western" class="dropdown-item">양식</a>
                            <a href="RecipepageCon?b_ctype=asia" class="dropdown-item">동남아시아</a>
                            <a href="RecipepageCon?b_ctype=fusion" class="dropdown-item">퓨전</a>
                        </div>
                    </div>
                    <a href="notice.jsp" class="nav-item nav-link"><i class="bi bi-cup-straw"></i>공지사항</a>                    
                </div>
            </nav>
        </div>
        <!-- Sidebar End -->

        <!-- Content Start -->
        <div class="content">
            <!-- Navbar Start -->
            <nav class="navbar navbar-expand bg-light navbar-light sticky-top px-4 py-0">
            	
	                <a href="index.html" class="navbar-brand d-flex d-lg-none me-4">
	                    <h2 class="text-primary mb-0"><i class="fa fa-hashtag"></i></h2>
	                </a>
	                <a href="#" class="sidebar-toggler flex-shrink-0">
	                    <i class="fa fa-bars"></i>
	                </a>
	                <form class="d-none d-md-flex ms-4">
	                    <input class="form-control border-0" type="search" placeholder="Search">
	                </form>
	                <div class="navbar-nav align-items-center ms-auto">
	                <c:choose> 
		                <c:when test="${empty loginMember}">
		                     <div class="nav-item dropdown">
		                        <a href="signup.jsp" class="nav-link" >
		                            <i class="bi bi-person-circle"></i>
		                            <span class="d-none d-lg-inline-flex">회원가입</span>
		                        </a>
		                     </div>
		                     <div class="nav-item dropdown">
		                     <%-- 로그인 후 드롭다운 되는 코드
		                     <a href="signin.jsp" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"> --%>
		                     <a href="signin.jsp" class="nav-link">
		                        <i class="bi bi-person-check"></i>
		                            <span class="d-none d-lg-inline-flex">로그인</span>
		                     </a>
		                </c:when>
	                    <%-- 지워야할 로그아웃 --%>
		                <c:otherwise>
		               		<div class="nav-item dropdown">
		                    <%-- <a href="LogoutCon" class="dropdown-item">로그아웃</a> --%>
		                        
		                        <%-- 로그인 후 드롭다운 되는 코드 --%>
		                        <%-- <div class="dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0">
		                            <a href="information.jsp" class="dropdown-item">개인정보수정</a>
		                            <a href="refrigerator.jsp" class="dropdown-item">나의 냉장고</a>
		                            <a href="LogoutCon" class="dropdown-item">로그아웃</a>
		                        </div> --%>
		                    <div class="nav-item dropdown">
                      		<a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                      			<i class="bi bi-person-bounding-box"></i>  
                            		<span class="d-none d-lg-inline-flex">${loginMember.m_id} 님 환영합니다~!</span>
                       		</a>
                       		<div class="dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0">
                            <a href="information.jsp" class="dropdown-item">개인정보수정</a>
                            <a href="refrigerator.jsp" class="dropdown-item">나의 냉장고</a>
                            <a href="LogoutCon" class="dropdown-item">로그아웃</a>
                            </div>
                   		    </div>
		                </c:otherwise>
	               </c:choose>
	                        <!-- 로그인 후 드롭다운 되는 코드 끝 -->
	                    </div>
	                </div>
               		 
            </nav>
            <!-- Navbar End -->

            <!-- Sale & Revenue  Start 
            <div class="container-fluid pt-4 px-4">
                <div class="row g-4">
                    <img src="https://mediahub.seoul.go.kr/wp-content/uploads/2020/10/d13ea4a756099add8375e6c795b827ab.jpg">
                </div>
            </div>
             Sale & Revenue End -->


            <!-- Sales Chart Start 
            <div class="container-fluid pt-4 px-4">
                <div class="row g-4">
                    ㄴㄴ
                </div>
            </div>
             Sales Chart End -->
            <!-- Recent Sales Start 
            <div class="container-fluid pt-4 px-4">
                <div class="bg-light text-center rounded p-4">
                    ㄴㄴ
                </div>
            </div>
             Recent Sales End -->
            <!-- Widgets Start 
            <div class="container-fluid pt-4 px-4">
                <div class="row g-4">
                    
                    ㄴㄴㄴㄴㄴ
                    
                </div>
            </div>
             Widgets End -->

                <div class="container-fluid pt-4 px-4">
                <div class="row g-4">
                    
                    <div class="col-sm-12">
                        <div class="bg-light rounded h-100 p-4">
                        	<!-- 랜덤 추천 레시피명인데... 이건 레시피명을 띄워야하나 말아야하나 / 이미지 아래에 띄워야하나 -->
                            <h6 class="mb-4"><%=randomrecipe.getB_name()%><%-- 메뉴 추천 --%></h6>
                            <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
                                <div class="carousel-indicators">
                                  <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                                  <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
                                  <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
                                </div>
                                <div class="carousel-inner">
                                  <div class="carousel-item active">
                                  	<%-- a태그는 주석처리 해놨다가 레시피 상세 페이지 con파일 완성되면 주석 풀기 --%>
                                    <%-- <a href="RecipedetailpageCon?b_code="${randomrecipe.b_code}""> --%>
                                    <img src="${randomrecipe.b_url}" height="547" class="d-block w-100" alt="...">
                                    <%-- </a> --%>
                                  </div>
                                  <div class="carousel-item">
                                    <img src="https://news.kbs.co.kr/data/news/2017/01/04/3405677_bH6.jpg" class="d-block w-100" alt="...">
                                  </div>
                                  <div class="carousel-item">
                                    <img src="https://news.kbs.co.kr/data/news/2017/01/04/3405677_bH6.jpg" class="d-block w-100" alt="...">
                                  </div>
                                </div>
                                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                                  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                  <span class="visually-hidden">Previous</span>
                                </button>
                                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                                  <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                  <span class="visually-hidden">Next</span>
                                </button>
                              </div>
                        </div>
                    </div>
                    
                    <div class="col-sm-12 col-xl-6">
                        <div class="bg-light rounded h-100 p-4 text-center" >
                            <a href="RecipepageCon?b_ctype=korean">
                                <h6>한식</h6><br>
                                <img src="./img/aaa.jpg">
                            </a>
                        </div>
                    </div>
                    <div class="col-sm-12 col-xl-6">
                        <div class="bg-light rounded h-100 p-4 text-center" >
                            <a href="RecipepageCon?b_ctype=chinese">
                                <h6>중식</h6><br>
                                <img src="./img/aaa.jpg">
                                </a>
                        </div>
                    </div>
                    <div class="col-sm-12 col-xl-6">
                        <div class="bg-light rounded h-100 p-4 text-center" >
                            <a href="RecipepageCon?b_ctype=japanese">
                                <h6>일식</h6><br>
                                <img src="./img/aaa.jpg">
                            </a>
                        </div>
                    </div>
                    <div class="col-sm-12 col-xl-6">
                        <div class="bg-light rounded h-100 p-4 text-center" >
                            <a href="RecipepageCon?b_ctype=western">
                                <h6>양식</h6><br>
                                <img src="./img/aaa.jpg">
                                </a>
                        </div>
                    </div>
                    <div class="col-sm-12 col-xl-6">
                        <div class="bg-light rounded h-100 p-4 text-center" >
                            <a href="RecipepageCon?b_ctype=asia">
                                <h6>동남아시아</h6><br>
                                <img src="./img/aaa.jpg">
                                </a>
                        </div>
                    </div>
                    <div class="col-sm-12 col-xl-6">
                        <div class="bg-light rounded h-100 p-4 text-center" >
                            <a href="RecipepageCon?b_ctype=fusion">
                                <h6>퓨전</h6><br>
                                <img src="./img/aaa.jpg">
                                </a>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Footer Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="bg-light rounded-top p-4">
                    <div class="row">
                        <div class="col-12 col-sm-6 text-center text-sm-start">
                            &copy; <a href="main.jsp">recetA</a><span>, 팀장:송영지 팀원:강태준, 김기범, 김도연, 김동현</span> 
                        </div>
                        <div class="col-12 col-sm-6 text-center text-sm-end">
                            <!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
                            <!-- Designed By <a href="https://htmlcodex.com">HTML Codex</a> -->
                        </div>
                    </div>
                </div>
            </div>
            <!-- Footer End -->
        </div>
        <!-- Content End -->

        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
    </div>

    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="lib/chart/chart.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/waypoints/waypoints.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="lib/tempusdominus/js/moment.min.js"></script>
    <script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
    <script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
</body>

</html>