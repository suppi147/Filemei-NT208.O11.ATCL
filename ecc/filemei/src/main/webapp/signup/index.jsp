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
	<p>Let create an filemei account</p>
	</div>
	
	<div class="input-group">
	 <input type="text" id="username" class="input-field" placeholder="What is your email address?" >
	</div>
	
	<div class="input-group">
	 <input type="password" id="password" class="input-field" placeholder="Create a password" >
	</div>
	
	
	
	<div class="input-group">
	<button onclick="linkTrigger('/filemei/signup/EmailVerification.jsp')">Sign Up <i class="fa-solid fa-arrow-right"></i></button>
	</div>
	<div class="signup">
	<p>Already have an account? <a href="/filemei/login">Login.</a></p>
	</div>
	</div>  
  </body>
  </html>