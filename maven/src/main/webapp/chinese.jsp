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
    <title>recetA-레시피_중식</title>
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
	Member loginMember = (Member)session.getAttribute("loginMember"); %>
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
                    <h3 class="text-primary text-white"><i class="fa fa-hashtag me-2"></i> recetA</h3>
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
                    <a href="main.jsp" class="nav-item nav-link"><i class="bi bi-egg-fried"></i>HOME</a>
                    <div class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle active" data-bs-toggle="dropdown"><i class="bi bi-cup"></i>레시피</a>
                        <div class="dropdown-menu bg-transparent border-0">
                            <a href="RecipepageCon?b_ctype=korean" class="dropdown-item">한식</a>
                            <a href="RecipepageCon?b_ctype=chinese" class="dropdown-item active">중식</a>
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
                            <a href="refrigerator.jsp" class="dropdown-item">나의 냉장고</a>
                            <!-- admin만 -->
	                        <a href="#" class="dropdown-item">회원관리</a>
	                        <!-- admin만 끝 -->
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

            <!-- Blank Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="row vh-198 rounded align-items-center justify-content-center mx-0">
                    
                        <div class="bg-light rounded h-100 p-2 text-center" style="margin-bottom: 2%; ">
                            <span><h2>중식</h2></span>
                        </div>
                    <br>
                <!-- 소분류 -->    
                <form action="RecipesmallpageCon" method="post">  
                <table class="table table-bordered" id="table"> 
                    <tr>
                        <td rowspan="3" style="vertical-align:middle;">1분류</td>
                        <td><input type="hidden" name="b_ctype" value="chinese"><input type="checkbox" name="b_ftype" value="양념장"> <span> 양념장</span></td>
                        <td><input type="checkbox" name="b_ftype" value="만두/면류"> <span> 만두/면류</span></td>
                        <td><input type="checkbox" name="b_ftype" value="빵/과자"> <span> 빵/과자</span></td>
                        <td><input type="checkbox" name="b_ftype" value="찜"> <span> 찜</span></td>
                        <td><input type="checkbox" name="b_ftype" value="그라탕/리조또"> <span> 그라탕/리조또</span></td>                             
                        <td><input type="checkbox" name="b_ftype" value="피자"> <span> 피자</span></td>
                        <td><input type="checkbox" name="b_ftype" value="찌개/전골/스튜"> <span> 찌개/전골/스튜</span></td>
                    </tr>
                    <tr>   
                        <td><input type="checkbox" name="b_ftype" value="튀김/커틀릿"> <span> 튀김/커틀릿</span></td>
                        <td><input type="checkbox" name="b_ftype" value="밑반찬/김치"> <span> 밑반찬/김치</span></td>  
                        <td><input type="checkbox" name="b_ftype" value="조림"> <span> 조림</span></td>
                        <td><input type="checkbox" name="b_ftype" value="구이"> <span> 구이</span></td>
                        <td><input type="checkbox" name="b_ftype" value="밥"> <span> 밥</span></td>
                        <td><input type="checkbox" name="b_ftype" value="음료"> <span> 음료</span></td>
                        <td><input type="checkbox" name="b_ftype" value="나물/생채/샐러드"> <span> 나물/생채/샐러드</span></td>
                    </tr>
                    <tr> 
                        <td><input type="checkbox" name="b_ftype" value="양식"> <span> 양식</span></td>                                                   
                        <td><input type="checkbox" name="b_ftype" value="부침"> <span> 부침</span></td>
                        <td><input type="checkbox" name="b_ftype" value="도시락/간식"> <span> 도시락/간식</span></td>
                        <td><input type="checkbox" name="b_ftype" value="떡/한과"> <span> 떡/한과</span></td>
                        <td><input type="checkbox" name="b_ftype" value="국"> <span> 국</span></td>
                        <td><input type="checkbox" name="b_ftype" value="샌드위치/햄버거"> <span> 샌드위치/햄버거</span></td>
                        <td><input type="checkbox" name="b_ftype" value="볶음"> <span> 볶음</span></td>
                    </tr>
                    
                    <!-- 2분류 -->
                    <tr>
                        <td rowspan="3" style="vertical-align:middle;">2분류</td>
                        <td><input type="checkbox" name="b_itype" value="견과류"> <span> 견과류</span></td>
                        <td><input type="checkbox" name="b_itype" value="버섯류"> <span> 버섯류</span></td>    
                        <td><input type="checkbox" name="b_itype" value="쇠고기류"> <span> 쇠고기류</span></td>    
                        <td><input type="checkbox" name="b_itype" value="돼지고기류"> <span> 돼지고기류</span></td>    
                        <td><input type="checkbox" name="b_itype" value="콩류"> <span> 콩류</span></td>
                        <td><input type="checkbox" name="b_itype" value="기타"> <span> 기타</span></td>  
                        <td><input type="checkbox" name="b_itype" value="닭고기류"> <span> 닭고기류</span></td>                        
                    </tr>
                    <tr>
                        <td><input type="checkbox" name="b_itype" value="알류"> <span> 알류</span></td>
                        <td><input type="checkbox" name="b_itype" value="해조류"> <span> 해조류</span></td>    
                        <td><input type="checkbox" name="b_itype" value="곡류"> <span> 곡류</span></td>
                        <td><input type="checkbox" name="b_itype" value="곡류"> <span> 채소류</span></td>   
                        <td><input type="checkbox" name="b_itype" value="밀가루"> <span> 밀가루</span></td>    
                        <td><input type="checkbox" name="b_itype" value="가곡식품류"> <span> 가곡식품류</span></td> 
                        <td><input type="checkbox" name="b_itype" value="어류/패류"> <span> 어류/패류</span></td>
                    </tr>
                    <tr>             
                        <td><input type="checkbox" name="b_itype" value="과일류"> <span> 과일류</span></td>
                        <td></td><td></td><td></td><td></td><td></td><td></td>  
                    </tr>
                    <tr></tr>
                    <!-- 인분 -->
                    <tr>
                        <td style="vertical-align:middle;">3분류</td>
                        <td><input type="checkbox" name="b_amount" value="1인분"> <span> 1인분</span></td>
                        <td><input type="checkbox" name="b_amount" value="2인분"> <span> 2인분</span></td>
                        <td><input type="checkbox" name="b_amount" value="3인분"> <span> 3인분</span></td>
                        <td><input type="checkbox" name="b_amount" value="4인분"> <span> 4인분</span></td>
                        <td></td><td></td><td></td>
                    </tr>
                    <tr>
                        <td style="vertical-align:middle;">4분류</td>
                        <td><input type="checkbox" name="b_difficulte" value="초보환영"> <span> 초보환영</span></td>
                        <td><input type="checkbox" name="b_difficulte" value="보통"> <span> 보통</span></td>
                        <td><input type="checkbox" name="b_difficulte" value="어려움"> <span> 어려움</span></td>
                        <td></td><td></td><td></td><td></td>
                    </tr>
                    <tr>
                        <td rowspan="3" style="vertical-align:middle;">5분류</td>
                        <td><input type="checkbox" name="b_time" value="5분"> <span> 5분</span></td>
                        <td><input type="checkbox" name="b_time" value="10분"> <span> 10분</span></td>
                        <td><input type="checkbox" name="b_time" value="15분"> <span> 15분</span></td>
                        <td><input type="checkbox" name="b_time" value="20분"> <span> 20분</span></td>
                        <td><input type="checkbox" name="b_time" value="25분"> <span> 25분</span></td>
                        <td><input type="checkbox" name="b_time" value="30분"> <span> 30분</span></td>
                        <td><input type="checkbox" name="b_time" value="35분"> <span> 35분</span></td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" name="b_time" value="40분"> <span> 40분</span></td>
                        <td><input type="checkbox" name="b_time" value="50분"> <span> 50분</span></td>
                        <td><input type="checkbox" name="b_time" value="60분"> <span> 60분</span></td>
                        <td><input type="checkbox" name="b_time" value="70분"> <span> 70분</span></td>
                        <td><input type="checkbox" name="b_time" value="80분"> <span> 80분</span></td>
                        <td><input type="checkbox" name="b_time" value="90분"> <span> 90분</span></td>
                        <td><input type="checkbox" name="b_time" value="120분"> <span> 120분</span></td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" name="b_time" value="140분"> <span> 140분</span></td>
                        <td><input type="checkbox" name="b_time" value="175분"> <span> 175분</span></td>
                        <td><input type="checkbox" name="b_time" value="180분"> <span> 180분</span></td>
                        <td></td><td></td><td></td><td></td>
                    </tr>
                </table>                 
                <div class=" d-flex justify-content-center">
                <button type="submit" class="btn btn-warning rounded-pill m-2" id="btn">소분류 검색</button>   
                </div> 
                </form>                      
            </div>
            <!-- 소분류 끝 -->
			<!-- 여기부터 복사 붙여넣기 -->
            <!-- 레시피  -->
            <div class="container-fluid pt-4 px-4">
                <div class="row g-4">
                <!-- 소분류 세션 진행 -->
                <%
              		
                // 소분류 세션 null 확인하기
               	// 1. selectbFtype 세션 null 확인하기
               	if(session.getAttribute("selectbFtype")!=null){
               		List<Basic> selectbFtype = (List) session.getAttribute("selectbFtype");
               		
               		for(int i=0; i<selectbFtype.size(); i++){ %>
               		<div class="col-sm-12 col-xl-6">
                        <div class="bg-light rounded h-100 p-4 text-center">
                            <a href="RecipedetailpageCon?b_code=<%=selectbFtype.get(i).getB_code()%>">
                            <img src="<%=selectbFtype.get(i).getB_url() %>" alt="" width="311" height="289"><br>
                            <button type="button" class="btn btn-outline-link m-2"><h6><%= selectbFtype.get(i).getB_name()%></h6></button>
                            </a>
                        </div>
                    </div>
                    <%}
               		}// selectbFtype 세션 null 확인 끝
               	
               	// 2. selectbItype 세션 null 확인하기
               	if(session.getAttribute("selectbItype")!=null){
               		List<Basic> selectbItype = (List) session.getAttribute("selectbItype");
               		
               		for(int i=0; i<selectbItype.size(); i++){ %>
               		<div class="col-sm-12 col-xl-6">
                        <div class="bg-light rounded h-100 p-4 text-center">
                            <a href="RecipedetailpageCon?b_code=<%=selectbItype.get(i).getB_code()%>">
                            <img src="<%=selectbItype.get(i).getB_url() %>" alt="" width="311" height="289"><br>
                            <button type="button" class="btn btn-outline-link m-2"><h6><%= selectbItype.get(i).getB_name()%></h6></button>
                            </a>
                        </div>
                    </div>
                    <%}
               		}// selectbItype 세션 null 확인 끝
               	
               	// 3. selectbTime 세션 null 확인하기
               	if(session.getAttribute("selectbTime")!=null){
               		List<Basic> selectbTime = (List) session.getAttribute("selectbTime");
               		
               		for(int i=0; i<selectbTime.size(); i++){ %>
               		<div class="col-sm-12 col-xl-6">
                        <div class="bg-light rounded h-100 p-4 text-center">
                            <a href="RecipedetailpageCon?b_code=<%=selectbTime.get(i).getB_code()%>">
                            <img src="<%=selectbTime.get(i).getB_url() %>" alt="" width="311" height="289"><br>
                            <button type="button" class="btn btn-outline-link m-2"><h6><%= selectbTime.get(i).getB_name()%></h6></button>
                            </a>
                        </div>
                    </div>
                    <%}
               		}// selectbTime 세션 null 확인 끝
               	
               	// 4. selectbAmount 세션 null 확인하기
               	if(session.getAttribute("selectbAmount")!=null){
               		List<Basic> selectbAmount = (List) session.getAttribute("selectbAmount");
               		
               		for(int i=0; i<selectbAmount.size(); i++){ %>
               		<div class="col-sm-12 col-xl-6">
                        <div class="bg-light rounded h-100 p-4 text-center">
                            <a href="RecipedetailpageCon?b_code=<%=selectbAmount.get(i).getB_code()%>">
                            <img src="<%=selectbAmount.get(i).getB_url() %>" alt="" width="311" height="289"><br>
                            <button type="button" class="btn btn-outline-link m-2"><h6><%= selectbAmount.get(i).getB_name()%></h6></button>
                            </a>
                        </div>
                    </div>
                    <%}
               		}// selectbAmount 세션 null 확인 끝
               	
               	// 5. selectbDifficulte 세션 null 확인하기
               	if(session.getAttribute("selectbDifficulte")!=null){
               		List<Basic> selectbDifficulte = (List) session.getAttribute("selectbDifficulte");
               		
               		for(int i=0; i<selectbDifficulte.size(); i++){ %>
               		<div class="col-sm-12 col-xl-6">
                        <div class="bg-light rounded h-100 p-4 text-center">
                            <a href="RecipedetailpageCon?b_code=<%=selectbDifficulte.get(i).getB_code()%>">
                            <img src="<%=selectbDifficulte.get(i).getB_url() %>" alt="" width="311" height="289"><br>
                            <button type="button" class="btn btn-outline-link m-2"><h6><%= selectbDifficulte.get(i).getB_name()%></h6></button>
                            </a>
                        </div>
                    </div>
                    <%}
               		}// selectbDifficulte 세션 null 확인 끝
               	
               	
                // 소분류 먼저 if로 null값 확인 후 대분류 null 확인 진행
                // 소분류con에서 대분류 세션을 지우고 진행할 것임
              	if (session.getAttribute("bigbasic") != null) {
              		List<Basic> bigbasic = (List) session.getAttribute("bigbasic");
              		for(int i=0; i<bigbasic.size(); i++){ %>
                    <div class="col-sm-12 col-xl-6">
                        <div class="bg-light rounded h-100 p-4 text-center">
                            <a href="RecipedetailpageCon?b_code=<%=bigbasic.get(i).getB_code()%>">
                            <img src="<%=bigbasic.get(i).getB_url() %>" alt="" width="311" height="289"><br>
                            <button type="button" class="btn btn-outline-link m-2"><h6><%= bigbasic.get(i).getB_name()%></h6></button>
                            </a>
                        </div>
                    </div>
                    <%} }  %>
                    
                </div>
            </div>
            <!-- 레시피 끝 -->
            <!-- 여기까지 복사 붙여넣기 -->

            <!-- 페이지 번호 -->
            <nav aria-label="Page navigation" class="d-flex justify-content-center">
                <ul class="pagination">
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
            <!-- 페이지 번호 끝 -->                
            </div>
            <!-- Blank End -->

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