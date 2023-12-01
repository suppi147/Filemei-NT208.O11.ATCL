<%@ page language="java" contentType="text/html"%>
  <!DOCTYPE html>
  <html lang="en">
  <head>
  <title>Filemei</title>
  <link href="/filemei/assets/signup/signup.css" rel="stylesheet" />
  <script src="/filemei/assets/signup/signup.js"></script>
  <link rel="shortcut icon" href="/filemei/assets/filemei.ico" type="image/x-icon">
  
  </head>
  
  <body>
  <div class="wrapper">
	<div class="heading">
	<a href="http://ec2-52-221-209-106.ap-southeast-1.compute.amazonaws.com/filemei/home/"><h1>Filemei</h1></a>
	<p>Let create an filemei account</p>
	</div>
	<form action="/filemei/signupware" method="post" onsubmit="return CheckPassIdentical();">	
	<div class="input-group">
	<input type="text" id="username" name="email" class="input-field" placeholder="What is your email address?" required>
	 <input type="password" id="password" name="password" class="input-field" placeholder="Create a password" required>
	  <input type="password" id="re-password" name="re-password" class="input-field" placeholder="Enter the password again" required>
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