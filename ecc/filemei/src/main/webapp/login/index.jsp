<%@ page language="java" contentType="text/html"%>
<%
String userName = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("filemeicookie")) userName = cookie.getValue();
}
}
if(userName != null) response.sendRedirect("/filemei/warehouse/");
%>
  <!DOCTYPE html>
  <html lang="en">
  <head>
	<title>Filemei</title>
  <link href="/filemei/assets/login/login.css" rel="stylesheet" />
  <link rel="shortcut icon" href="/filemei/assets/filemei.ico" type="image/x-icon">
   <script src="/filemei/assets/login/login.js"></script>
  
  </head>
  <body>
  <div class="wrapper">
	<div class="heading">
	<a href="http://localhost:8080/filemei/home/"><h1>Filemei</h1></a>
	<p>Sign In to your account</p>
	</div>
	<form action="/filemei/loginware" method="post">
	<div class="input-group">
	 <input type="text" id="username" name="email" class="input-field" placeholder="Email" required>
	</div>
	<div class="input-group">
	 <input type="password" id="password" name="password" class="input-field" placeholder="Password" required>
	</div>
	
	<div class="input-group row">
	
	 <div class="row">
	 <input type="checkbox" id="remember" hidden>
	 <label for="remember" class="custom-checkbox"></label>
	 <label for="remember">Remember me?</label>
	 </div>
	 
	 <div class="row">
	    <a href="/filemei/login/ForgotPassword.jsp">Forgot password?</a> 
	 </div>
	</div>
	
	
	<div class="input-group">
	<button>Login <i class="fa-solid fa-arrow-right"></i></button>
	</div>
	</form>
	<div class="signup">
	<p>Don't have an account? <a href="/filemei/signup">Sign up.</a></p>
	</div>
	</div>  
  </body>
  </html>