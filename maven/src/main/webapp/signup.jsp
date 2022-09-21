<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<link  href="css/style.css"  rel="stylesheet"  type="text/css">
<head>
    <meta charset="utf-8">
    <title>💕recetA-회원가입💕</title>
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

<script>
        function check_pw(){
            var pw = document.getElementById('floatingPassword').value;
            var SC = ["!","@","#","$","%"];
            var check_SC = 0;
            
            if(document.getElementById('floatingPassword').value !='' && document.getElementById('floatingPassword2').value!=''){
                if(document.getElementById('floatingPassword').value==document.getElementById('floatingPassword2').value){
                    document.getElementById('check').innerHTML='비밀번호가 일치합니다.'
                    document.getElementById('check').style.color='blue';
                }
                else{
                    document.getElementById('check').innerHTML='비밀번호가 일치하지 않습니다.';
                    document.getElementById('check').style.color='firebrick';
                }
            }
        }
    </script>
<script>
	function signup() {
		var pw = document.getElementById('floatingPassword').value;
		var SC = ["!","@","#","$","%","^","&","*"];
        var check_SC = 0;
		if(pw.length < 6 || pw.length>16){
            window.alert('비밀번호는 6글자 이상, 16글자 이하만 이용 가능합니다.');
            document.getElementById('pw').value='';
            return false;
        }
        for(var i=0;i<SC.length;i++){
            if(pw.indexOf(SC[i]) != -1){
                check_SC = 1;
            }
        }
        if(check_SC == 0){
            window.alert('!,@,#,$,%,^,&,* 의 특수문자가 들어가 있지 않습니다.')
            document.getElementById('pw').value='';
            return false;
        }
        if(document.getElementById('floatingPassword').value !='' && document.getElementById('floatingPassword2').value!=''){
            if(document.getElementById('floatingPassword').value==document.getElementById('floatingPassword2').value){
            	window.alert('회원가입 성공');
            	document.getElementById('frm').submit();
            }
            else{
            	window.alert('비밀번호가 일치하지 않습니다.');
            	return false;
            }
        }
	}
</script>

<body>
    <div class="container-xxl position-relative bg-white d-flex p-0">
        <!-- Spinner Start -->
        <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->

        <!-- Sign Up Start -->
        <div class="container-fluid">
            <div class="row h-100 align-items-center justify-content-center" style="min-height: 100vh;">
                <div class="col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4">
                    <div class="bg-light rounded p-4 p-sm-5 my-4 mx-3">
                        <div class="d-flex align-items-center justify-content-between mb-3">
                            <a href="main.jsp" class="">
                                <h3 class="text-primary"><i class="fa fa-hashtag me-2"></i> recetA</h3>
                            </a>
                            <h3>회원가입</h3>
                        </div>
                        <form id="frm" action="JoinCon" method="post">
                        <div class="form-floating mb-3">
                            <input type="text" name="id" class="form-control" id="floatingInput" placeholder="ID">
                            <label for="floatingInput">ID</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="password" name="pw" class="form-control" id="floatingPassword" placeholder="Password" onchange="check_pw()">
                            <label for="floatingPassword">Password (특수문자 포함 6자 이상)</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="password" name="pw2" class="form-control" id="floatingPassword2" placeholder="Password" onchange="check_pw()">
                            <label for="floatingPassword">Password Check</label>
                            &nbsp;<span id="check"></span>
                        </div>
                        <!-- <div class="form-floating mb-3">
                            <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
                            <label for="floatingPassword">Password 확인</label>
                        </div> -->
                        <div class="form-floating mb-3">
                            <input type="text" name="name" class="form-control" id="floatingText" placeholder="NAME">
                            <label for="floatingText">Name</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="num" name="tel" class="form-control" id="floatingInput" placeholder="-없이입력">
                            <label for="floatingInput">Tel</label>
                        </div>
                        </form>
                        <a href="#" onclick="return signup()" class="btn btn-primary py-3 w-100 mb-4">회원가입</a>
                        <p class="text-center mb-0">Already have an Account? <a href="signin.jsp">로그인</a></p>      
                    </div>
                </div>
            </div>
        </div>
        <!-- Sign Up End -->
    </div>
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