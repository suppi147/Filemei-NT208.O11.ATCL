<%@ page language="java" contentType="text/html"%>
  <!DOCTYPE html>
  <html lang="en">
  <head>
  <link href="/filemei/assets/login/login.css" rel="stylesheet" />
   <script src="/filemei/assets/login/login.js"></script>
  
  </head>
  <body>
  <div class="wrapper">
	<div class="heading">
	<a href="http://localhost:8080/filemei/home/"><h1>Filemei</h1></a>
	<p>Sign In to your account</p>
	</div>
	
	<div class="input-group">
	 <input type="text" id="username" class="input-field" placeholder="Email" >
	</div>
	
	<div class="input-group">
	 <input type="password" id="password" class="input-field" placeholder="Password" >
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
	<div class="signup">
	<p>Don't have an account? <a href="/filemei/signup">Sign up.</a></p>
	</div>
	</div>  
  </body>
  </html>