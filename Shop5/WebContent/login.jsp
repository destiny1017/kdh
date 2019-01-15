<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.net.URLEncoder" import="java.security.SecureRandom" import="java.math.BigInteger"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="google-signin-client_id" content="896608771512-g2vmktkh0bs70rqjegsm2j9ns3ln3qn3.apps.googleusercontent.com"></meta>
<title>Insert title here</title>
 <script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
 <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
  <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js" ></script>
 <script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
</head>
<body>
<%
    String clientId = "fLSp26sMjcEpF76HNLB7";//애플리케이션 클라이언트 아이디값";
    String redirectURI = URLEncoder.encode("http://localhost:7777/Shop5/callback.jsp", "UTF-8");
    SecureRandom random = new SecureRandom();
    String state = new BigInteger(130, random).toString();
    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
    apiURL += "&client_id=" + clientId;
    apiURL += "&redirect_uri=" + redirectURI;
    apiURL += "&state=" + state;
    session.setAttribute("state", state);
 %>

	<div class="helloId">
	<h1 id="title"> 쇼핑몰 </h1>
	</div><br/>

<center>
	<div class="login">
		<div class="login-screen">
			<div class="app-title">
				<h6>로그인</h6>
			</div>


			<div class="login-form">
				<form action="_login.jsp" id="submit">
				<div class="control-group">
				<input type="text" class="login-field" value="" placeholder="username" name="id">
				</div>
				
				<div class="control-group">
				<input type="password" class="login-field" value="" placeholder="password" name="pw"
					onkeypress="javascript:if(event.keyCode==13){document.getElementById('submit').submit()}">
				</div>

				<input type="submit" value="로그인" class="btn btn-primary btn-large btn-block">
				<p><a class="login-link" href="member_search.jsp"> ID/PW찾기 </a><br>
				<br>
				<!-- 네이버로그인 -->
				<div id="naver_id_login"></div>
				<a href="<%=apiURL%>"><img height="50" src="http://static.nid.naver.com/oauth/small_g_in.PNG"/></a>
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
</body>
</html>