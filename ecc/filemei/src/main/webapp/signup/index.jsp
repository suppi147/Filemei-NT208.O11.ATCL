<%@ page language="java" contentType="text/html"%>
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
	<p>Let create an filemei account</p>
	</div>
	<form action="action.jsp" method="post">
	<div class="input-group">
	 <input type="text" id="username" name="email" class="input-field" placeholder="What is your email address?" required>
	</div>
	
	<div class="input-group">
	 <input type="password" id="password" name="password" class="input-field" placeholder="Create a password" required>
	</div>
	<div class="input-group">
	<button>Sign Up <i class="fa-solid fa-arrow-right"></i></button>
	</div>
	</form>
	<div class="signup">
	<p>Already have an account? <a href="/filemei/login">Login.</a></p>
	</div>
	</div>  
  </body>
  </html>