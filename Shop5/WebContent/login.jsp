<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.net.URLEncoder" import="java.security.SecureRandom" import="java.math.BigInteger"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="google-signin-client_id" content="896608771512-g2vmktkh0bs70rqjegsm2j9ns3ln3qn3.apps.googleusercontent.com"></meta>
<!--===============================================================================================-->
	<link rel="icon" type="image/png" href="images/icons/favicon.png"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/themify/themify-icons.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/elegant-font/html-css/style.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/slick/slick.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
<title>Insert title here</title>
 <script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
 <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
  <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js" ></script>
 <script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
</head>
<body class="animsition">

	<!-- Header -->
	<jsp:include page="includes/header.jsp" flush="false" />
	
	<!-- Title Page -->
	<section class="bg-title-page p-t-40 p-b-50 flex-col-c-m" style="background-image: url(images/heading-pages-06.jpg);">
		<h2 class="l-text2 t-center">
			Login
		</h2>
	</section>
	
<%
    String clientId = "fLSp26sMjcEpF76HNLB7";//애플리케이션 클라이언트 아이디값";
    String redirectURI = URLEncoder.encode("http://localhost:8888/Shop5/callback.jsp", "UTF-8");
    SecureRandom random = new SecureRandom();
    String state = new BigInteger(130, random).toString();
    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
    apiURL += "&client_id=" + clientId;
    apiURL += "&redirect_uri=" + redirectURI;
    apiURL += "&state=" + state;
    session.setAttribute("state", state);
 %>

	<div class="helloId">
	</div><br/>

<center>
	<div class="login">
		<div class="login-screen">

			<div class="app-title">
				<h6 class="m-b-20">로그인</h6>
			</div>

			<div class="login-form">
				<form action="_login.jsp" id="submit">
				<div style="background: #efefef; width: 200px;">
				<div class="control-group">
				<input type="text" class="login-field m-b-10  m-t-10 s-text7" value="" placeholder="username" name="id" border=>
				</div>
				
				<div class="control-group">
				<input type="password" class="login-field m-b-10 s-text7" value="" placeholder="password" name="pw"
					onkeypress="javascript:if(event.keyCode==13){document.getElementById('submit').submit()}">
				</div>
				</div><br>

				<input type="submit" value="로그인" class="btn btn-primary btn-large btn-block" style="width: 200px;">
				<p><a class="login-link" href="member_search.jsp"> ID/PW찾기 </a><br>
				<br>
				<!-- 네이버로그인 -->
				<div id="naver_id_login"></div>
				<a href="<%=apiURL%>"><img class="m-b-5" height="50" src="http://static.nid.naver.com/oauth/small_g_in.PNG"/></a>
				<br>
				
				<!-- 카카오로그인 -->
            <a id="kakao-login-btn"></a>
            <a href="http://developers.kakao.com/logout"></a>
            <script type='text/javascript'>
                 //<![CDATA[
                  // 사용할 앱의 JavaScript 키를 설정해 주세요.
                Kakao.init('5c7809c7600e61feeffc16e37ade5569');
                // 카카오 로그인 버튼을 생성합니다.
                Kakao.Auth.createLoginButton({
                  container: '#kakao-login-btn',
                  success: function(authObj) {
                     Kakao.API.request({
                        url: '/v1/user/me',
                        success: function(res) {
                           alert(res.properties.nickname+"님 환영합니다");
                           
                           location.href = "kakaoLogin.jsp?nickname="+res.properties.nickname+"&id="+res.id;
                        },
                        fail: function(error) {
                          alert(JSON.stringify(error));
                        }
                     });
      
                  },
                  fail: function(err) {
                     alert(JSON.stringify(err));
                  }
                });
                function ktout() {
                   Kakao.Auth.logout(function () {
                      setTimeout(function(){
                         location.href="http://localhost:8080/web2/NewFile1.jsp"
                      },1000);
          
                      });
                }
    			
    			
                 //]]>
            	</script>
				<br>
				<div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark"></div>
    			<script>
      			function onSignIn(googleUser) {
        			// Useful data for your client-side scripts:
        			var profile = googleUser.getBasicProfile();
        			console.log("ID: " + profile.getId()); // Don't send this directly to your server!
        			console.log('Full Name: ' + profile.getName());
        			console.log('Given Name: ' + profile.getGivenName());
        			console.log('Family Name: ' + profile.getFamilyName());
        			console.log("Image URL: " + profile.getImageUrl());
        			console.log("Email: " + profile.getEmail());
        			
        			location.href = "googleLogin.jsp?nickname="+profile.getName()+"&id="+profile.getId();
        			// The ID token you need to pass to your backend:
        			var id_token = googleUser.getAuthResponse().id_token;
        			console.log("ID Token: " + id_token);
      			}
    			</script>
				<%-- <script src="https://apis.google.com/js/client:platform.js?onload=startApp"></script> --%>
				<br>
				
				<a class="login-link" href="register.jsp"> 회원가입 </a><br>
				<a class="login-link" href="about.jsp"> 쇼핑몰로 돌아가기 </a>
				
				</form>	
			</div>
				
		</div>
	</div>
</center>

	<!-- Footer -->
	<jsp:include page="includes/footer.jsp" flush="false"/>
	
	<!-- Back to top -->
	<div class="btn-back-to-top bg0-hov" id="myBtn">
		<span class="symbol-btn-back-to-top">
			<i class="fa fa-angle-double-up" aria-hidden="true"></i>
		</span>
	</div>

	<!-- Container Selection -->
	<div id="dropDownSelect1"></div>
	<div id="dropDownSelect2"></div>



<!--===============================================================================================-->
	<script type="text/javascript" src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script type="text/javascript" src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script type="text/javascript" src="vendor/bootstrap/js/popper.js"></script>
	<script type="text/javascript" src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script type="text/javascript" src="vendor/select2/select2.min.js"></script>
	<script type="text/javascript">
		$(".selection-1").select2({
			minimumResultsForSearch: 20,
			dropdownParent: $('#dropDownSelect1')
		});

		$(".selection-2").select2({
			minimumResultsForSearch: 20,
			dropdownParent: $('#dropDownSelect2')
		});
	</script>
<!--===============================================================================================-->
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAKFWBqlKAGCeS1rMVoaNlwyayu0e0YRes"></script>
	<script src="js/map-custom.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>