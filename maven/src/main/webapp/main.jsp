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
							</c:otherwise>
						</c:choose>
					</div>
                </div>
                <div class="navbar-nav w-100">
                    <a href="main.jsp" class="nav-item nav-link active"><i class="bi bi-egg-fried"></i>HOME</a>
                    <div class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="bi bi-cup"></i>레시피</a>
                        <div class="dropdown-menu bg-transparent border-0">
                            <a href="PagingCon?b_ctype=korean&page=0" class="dropdown-item">한식</a>
                            <a href="PagingCon?b_ctype=chinese&page=0" class="dropdown-item">중식</a>
                            <a href="PagingCon?b_ctype=japanese&page=0" class="dropdown-item">일식</a>
                            <a href="PagingCon?b_ctype=western&page=0" class="dropdown-item">양식</a>
                            <a href="PagingCon?b_ctype=asia&page=0" class="dropdown-item">동남아시아</a>
                            <a href="PagingCon?b_ctype=fusion&page=0" class="dropdown-item">퓨전</a>
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
	                <form class="d-none d-md-flex ms-4" action="SearchCon" method="post">
	                    <input class="form-control border-0" type="search" name="search" placeholder="검색">
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
	                            <a href="Key_Con" class="dropdown-item">나의 냉장고</a>
	                            <a href="Favorites_LoadCon" class="dropdown-item">즐겨찾기</a>
	                            <c:if test="${loginMember.m_id eq 'admin'}">
	                            <!-- admin만 -->
	                             <a href="Manager.jsp" class="dropdown-item">회원관리</a>
	                             <!-- admin만 끝 -->
	                             </c:if>
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
                            <h4 class="mb-4">메뉴 추천</h4>
                            <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
                                <div class="carousel-indicators">
                                  <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                                  <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
                                  <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
                                </div>
                                
                                <%
	                            	System.out.println("[RandomRecipe]");
	
	                            	request.setCharacterEncoding("UTF-8");
	
	                            	Random rand = new Random();
	                            	int b_code = rand.nextInt(500);
	                            	BasicDAO dao = new BasicDAO();
	                            	Basic randomrecipe = dao.selectRandom(b_code);
	                            	
	                            	int b_code2 = rand.nextInt(500);
	                            	dao = new BasicDAO();
	                            	Basic randomrecipe2 = dao.selectRandom(b_code2);
	                            	
	                            	int b_code3 = rand.nextInt(500);
	                            	dao = new BasicDAO();
	                            	Basic randomrecipe3 = dao.selectRandom(b_code3);
	                            	
	                            	// 6. 명령 후 처리
	                            	if (randomrecipe != null) {
	                            		session.setAttribute("randomrecipe", randomrecipe);
	                            		Basic randomrecipesession = (Basic) session.getAttribute("randomrecipe");
	                            	} else { }
	                            	
	                            	if (randomrecipe2 != null) {
	                            		session.setAttribute("randomrecipe2", randomrecipe2);
	                            		Basic randomrecipesession2 = (Basic) session.getAttribute("randomrecipe2");
	                            	} else { }
	                            	
	                            	if (randomrecipe3 != null) {
	                            		session.setAttribute("randomrecipe3", randomrecipe3);
	                            		Basic randomrecipesession3 = (Basic) session.getAttribute("randomrecipe3");
	                            	} else { }
	                            	%>
	                            <div class="carousel-inner">
                                  <div class="carousel-item active">
                                  	<%-- a태그는 주석처리 해놨다가 레시피 상세 페이지 con파일 완성되면 주석 풀기 --%>
                                    <a href="RecipedetailpageCon?b_code=${randomrecipe.b_code}">
                                    <img src="${randomrecipe.b_url}" height="547" class="d-block w-100" alt="...">
                                    <div class="carousel-caption d-none d-md-block">
								        <span class="btn btn-light"><h4><%= randomrecipe.getB_name()%></h4></span>
								     </div>
                                    </a>
                                  </div>
                                  
                                 
                                  <div class="carousel-item">
                                  <a href="RecipedetailpageCon?b_code=${randomrecipe2.b_code}">
                                    <img src="${randomrecipe2.b_url}" height="547" class="d-block w-100" alt="...">
                                    <div class="carousel-caption d-none d-md-block">
								        <span class="btn btn-light"><h4><%= randomrecipe2.getB_name()%></h4></span>
								     </div>
                                  </a>
                                  </div>
                                  
                                  <div class="carousel-item">
                                  <a href="RecipedetailpageCon?b_code=${randomrecipe3.b_code}">
                                    <img src="${randomrecipe3.b_url}" height="547" class="d-block w-100" alt="...">
                                 	 <div class="carousel-caption d-none d-md-block">
								        <span class="btn btn-light"><h4><%= randomrecipe3.getB_name()%></h4></span>
								     </div>
								   </a>
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
                                <h4>한식</h4><br>
                                <img src="./img/korean.jpg" width="311" height="289">
                            </a>
                        </div>
                    </div>
                    <div class="col-sm-12 col-xl-6">
                        <div class="bg-light rounded h-100 p-4 text-center" >
                            <a href="RecipepageCon?b_ctype=chinese">
                                <h4>중식</h4><br>
                                <img src="img/chinese3.jpg" width="311" height="289">
                                </a>
                        </div>
                    </div>
                    <div class="col-sm-12 col-xl-6">
                        <div class="bg-light rounded h-100 p-4 text-center" >
                            <a href="RecipepageCon?b_ctype=japanese">
                                <h4>일식</h4><br>
                                <img src="./img/japanese.jpg" width="311" height="289">
                            </a>
                        </div>
                    </div>
                    <div class="col-sm-12 col-xl-6">
                        <div class="bg-light rounded h-100 p-4 text-center" >
                            <a href="RecipepageCon?b_ctype=western">
                                <h4>양식</h4><br>
                                <img src="./img/western.jpg" width="311" height="289">
                                </a>
                        </div>
                    </div>
                    <div class="col-sm-12 col-xl-6">
                        <div class="bg-light rounded h-100 p-4 text-center" >
                            <a href="RecipepageCon?b_ctype=asia">
                                <h4>동남아시아</h4><br>
                                <img src="./img/asia.jpg" width="311" height="289">
                                </a>
                        </div>
                    </div>
                    <div class="col-sm-12 col-xl-6">
                        <div class="bg-light rounded h-100 p-4 text-center" >
                            <a href="RecipepageCon?b_ctype=fusion">
                                <h4>퓨전</h4><br>
                                <img src="http://file.okdab.com/UserFiles/searching/recipe/110800.jpg" width="311" height="289">
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