<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>recetA-레시피_동남아시아</title>
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
</head>

<body>
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
                        <h6 class="mb-0">ID</h6>
                        <span>이름</span>
                    </div>
                </div>
                <div class="navbar-nav w-100">
                    <a href="main.jsp" class="nav-item nav-link"><i class="bi bi-egg-fried"></i>HOME</a>
                    <div class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle active" data-bs-toggle="dropdown"><i class="bi bi-cup"></i>레시피</a>
                        <div class="dropdown-menu bg-transparent border-0">
                            <a href="korean.jsp" class="dropdown-item">한식</a>
                            <a href="chinese.jsp" class="dropdown-item">중식</a>
                            <a href="japanese.jsp" class="dropdown-item">일식</a>
                            <a href="western.jsp" class="dropdown-item">양식</a>
                            <a href="asia.jsp" class="dropdown-item active">동남아시아</a>
                            <a href="fusion.jsp" class="dropdown-item">퓨전</a>
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
                    <div class="nav-item dropdown">
                        <a href="signup.jsp" class="nav-link" >
                            <i class="bi bi-person-circle"></i>
                            <span class="d-none d-lg-inline-flex">회원가입</span>
                        </a>
                    </div>                   
                    <div class="nav-item dropdown">
                    <!-- 로그인 후 드롭다운 되는 코드
                    <a href="signin.jsp" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"> -->
                    <a href="signin.jsp" class="nav-link">
                        <i class="bi bi-person-check"></i>
                            <span class="d-none d-lg-inline-flex">로그인</span>
                    </a>
                        
                        <!-- 로그인 후 드롭다운 되는 코드 -->
                        <div class="dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0">
                            <a href="information.jsp" class="dropdown-item">개인정보수정</a>
                            <a href="refrigerator.jsp" class="dropdown-item">나의 냉장고</a>
                            <a href="logout.jsp" class="dropdown-item">로그아웃</a>
                        </div>
                        <!-- 로그인 후 드롭다운 되는 코드 끝 -->
                    </div>
                </div>
            </nav>
            <!-- Navbar End -->

            <!-- Blank Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="row vh-198 rounded align-items-center justify-content-center mx-0">
                <!-- 소분류 -->    
                <form>      
                <table class="table table-bordered" id="table"> 
                    <tr>
                        <td rowspan="5" style="vertical-align:middle;">1분류</td>
                        <td><input type="checkbox" name="b_ftype" value="양념장"> <span> 양념장</span></td>
                        <td><input type="checkbox" name="b_ftype" value="만두/면류"> <span> 만두/면류</span></td>
                        <td><input type="checkbox" name="b_ftype" value="빵/과자"> <span> 빵/과자</span></td>
                        <td><input type="checkbox" name="b_ftype" value="찜"> <span> 찜</span></td>
                        <td><input type="checkbox" name="b_ftype" value="그라탕/리조또"> <span> 그라탕/리조또</span></td>
                    </tr>
                    <tr>                               
                        <td><input type="checkbox" name="b_ftype" value="피자"> <span> 피자</span></td>
                        <td><input type="checkbox" name="b_ftype" value="찌개/전골/스튜"> <span> 찌개/전골/스튜</span></td> 
                        <td><input type="checkbox" name="b_ftype" value="튀김/커틀릿"> <span> 튀김/커틀릿</span></td>
                        <td><input type="checkbox" name="b_ftype" value="밑반찬/김치"> <span> 밑반찬/김치</span></td>  
                        <td><input type="checkbox" name="b_ftype" value="조림"> <span> 조림</span></td>
                    </tr>
                    <tr> 
                        <td><input type="checkbox" name="b_ftype" value="구이"> <span> 구이</span></td>
                        <td><input type="checkbox" name="b_ftype" value="밥"> <span> 밥</span></td>
                        <td><input type="checkbox" name="b_ftype" value="음료"> <span> 음료</span></td>
                        <td><input type="checkbox" name="b_ftype" value="나물/생채/샐러드"> <span> 나물/생채/샐러드</span></td>
                        <td><input type="checkbox" name="b_ftype" value="양식"> <span> 양식</span></td>                         
                    </tr>
                    <tr>                                
                        <td><input type="checkbox" name="b_ftype" value="부침"> <span> 부침</span></td>
                        <td><input type="checkbox" name="b_ftype" value="도시락/간식"> <span> 도시락/간식</span></td>
                        <td><input type="checkbox" name="b_ftype" value="떡/한과"> <span> 떡/한과</span></td>
                        <td><input type="checkbox" name="b_ftype" value="국"> <span> 국</span></td>
                        <td><input type="checkbox" name="b_ftype" value="샌드위치/햄버거"> <span> 샌드위치/햄버거</span></td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" name="b_ftype" value="볶음"> <span> 볶음</span></td>      
                        <td></td><td></td><td></td><td></td>
                    </tr>
                    
                    <!-- 2분류 -->
                    <tr>
                        <td rowspan="3" style="vertical-align:middle;">2분류</td>
                        <td><input type="checkbox" name="b_itype" value="견과류"> <span> 견과류</span></td>
                        <td><input type="checkbox" name="b_itype" value="버섯류"> <span> 버섯류</span></td>    
                        <td><input type="checkbox" name="b_itype" value="쇠고기류"> <span> 쇠고기류</span></td>    
                        <td><input type="checkbox" name="b_itype" value="돼지고기류"> <span> 돼지고기류</span></td>    
                        <td><input type="checkbox" name="b_itype" value="콩류"> <span> 콩류</span></td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" name="b_itype" value="기타"> <span> 기타</span></td>  
                        <td><input type="checkbox" name="b_itype" value="닭고기류"> <span> 닭고기류</span></td>  
                        <td><input type="checkbox" name="b_itype" value="알류"> <span> 알류</span></td>
                        <td><input type="checkbox" name="b_itype" value="해조류"> <span> 해조류</span></td>    
                        <td><input type="checkbox" name="b_itype" value="곡류"> <span> 곡류</span></td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" name="b_itype" value="곡류"> <span> 채소류</span></td>   
                        <td><input type="checkbox" name="b_itype" value="밀가루"> <span> 밀가루</span></td>    
                        <td><input type="checkbox" name="b_itype" value="가곡식품류"> <span> 가곡식품류</span></td> 
                        <td><input type="checkbox" name="b_itype" value="어류/패류"> <span> 어류/패류</span></td>              
                        <td><input type="checkbox" name="b_itype" value="과일류"> <span> 과일류</span></td>     
                    </tr>
                    <tr></tr>
                    <!-- 인분 -->
                    <tr>
                        <td style="vertical-align:middle;">3분류</td>
                        <td><input type="checkbox" name="b_amount" value="1인분"> <span> 1인분</span></td>
                        <td><input type="checkbox" name="b_amount" value="2인분"> <span> 2인분</span></td>
                        <td><input type="checkbox" name="b_amount" value="3인분"> <span> 3인분</span></td>
                        <td><input type="checkbox" name="b_amount" value="4인분"> <span> 4인분</span></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td style="vertical-align:middle;">4분류</td>
                        <td><input type="checkbox" name="b_difficulte" value="초보환영"> <span> 초보환영</span></td>
                        <td><input type="checkbox" name="b_difficulte" value="보통"> <span> 보통</span></td>
                        <td><input type="checkbox" name="b_difficulte" value="어려움"> <span> 어려움</span></td>
                        <td></td><td></td>
                    </tr>
                    <tr>
                        <td rowspan="4" style="vertical-align:middle;">5분류</td>
                        <td><input type="checkbox" name="b_time" value="5분"> <span> 5분</span></td>
                        <td><input type="checkbox" name="b_time" value="10분"> <span> 10분</span></td>
                        <td><input type="checkbox" name="b_time" value="15분"> <span> 15분</span></td>
                        <td><input type="checkbox" name="b_time" value="20분"> <span> 20분</span></td>
                        <td><input type="checkbox" name="b_time" value="25분"> <span> 25분</span></td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" name="b_time" value="30분"> <span> 30분</span></td>
                        <td><input type="checkbox" name="b_time" value="35분"> <span> 35분</span></td>
                        <td><input type="checkbox" name="b_time" value="40분"> <span> 40분</span></td>
                        <td><input type="checkbox" name="b_time" value="50분"> <span> 50분</span></td>
                        <td><input type="checkbox" name="b_time" value="60분"> <span> 60분</span></td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" name="b_time" value="70분"> <span> 70분</span></td>
                        <td><input type="checkbox" name="b_time" value="80분"> <span> 80분</span></td>
                        <td><input type="checkbox" name="b_time" value="90분"> <span> 90분</span></td>
                        <td><input type="checkbox" name="b_time" value="120분"> <span> 120분</span></td>
                        <td><input type="checkbox" name="b_time" value="140분"> <span> 140분</span></td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" name="b_time" value="175분"> <span> 175분</span></td>
                        <td><input type="checkbox" name="b_time" value="180분"> <span> 180분</span></td>
                        <td></td><td></td><td></td>
                    </tr>
                </table>                 
                <div class=" d-flex justify-content-center">
                <button type="submit" class="btn btn-warning rounded-pill m-2">소분류 검색</button>   
                </div> 
                </form>
                      
            </div>
            <!-- 소분류 끝 -->

            <!-- 레시피  -->
            <div class="container-fluid pt-4 px-4">
                <div class="row g-4">
                    <div class="col-sm-12 col-xl-6">
                        <div class="bg-light rounded h-100 p-4 text-center">
                            <a href="#">
                            <img src="./img/aaa.jpg" alt="" width="311" height="289"><br>
                            <button type="button" class="btn btn-outline-link m-2"><h6>레시피명</h6></button>
                            </a>
                        </div>
                    </div>
                    <div class="col-sm-12 col-xl-6">
                        <div class="bg-light rounded h-100 p-4 text-center">
                            <a href="#">
                            <img src="./img/aaa.jpg" alt="" width="311" height="289"><br>
                            <button type="button" class="btn btn-outline-link m-2"><h6>레시피명</h6></button>
                            </a>
                        </div>
                    </div>
                    <div class="col-sm-12 col-xl-6">
                        <div class="bg-light rounded h-100 p-4 text-center">
                            <a href="#">
                            <img src="./img/aaa.jpg" alt="" width="311" height="289"><br>                            
                            <button type="button" class="btn btn-outline-link m-2"><h6>레시피명</h6></button>
                            </a>
                        </div>
                    </div>
                    <div class="col-sm-12 col-xl-6">
                        <div class="bg-light rounded h-100 p-4 text-center">
                            <a href="#">
                            <img src="./img/aaa.jpg" alt="" width="311" height="289"><br>                            
                            <button type="button" class="btn btn-outline-link m-2"><h6>레시피명</h6></button>
                            </a>
                        </div>
                    </div>
                    <div class="col-sm-12 col-xl-6">
                        <div class="bg-light rounded h-100 p-4 text-center">
                            <a href="#">
                            <img src="./img/aaa.jpg" alt="" width="311" height="289"><br>                            
                            <button type="button" class="btn btn-outline-link m-2"><h6>레시피명</h6></button>
                            </a>
                        </div>
                    </div>
                    <div class="col-sm-12 col-xl-6">
                        <div class="bg-light rounded h-100 p-4 text-center">
                            <a href="#">
                            <img src="./img/aaa.jpg" alt="" width="311" height="289"><br>                            
                            <button type="button" class="btn btn-outline-link m-2"><h6>레시피명</h6></button>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- 레시피 끝 -->

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
        <a href="main.jsp" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
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