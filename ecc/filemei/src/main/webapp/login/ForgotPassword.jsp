<%@ page language="java" contentType="text/html"%>
  <!DOCTYPE html>
  <html lang="en">
  <head>
	<title>Filemei</title>
  <link href="/filemei/assets/signup/signup.css" rel="stylesheet" />
  <link rel="shortcut icon" href="/filemei/assets/filemei.ico" type="image/x-icon">
  <script src="/filemei/assets/signup/signup.js"></script>
  </head>
  <body>
  <div class="wrapper">
	<div class="heading">
	<a href="http://ec2-54-251-199-76.ap-southeast-1.compute.amazonaws.com/filemei/home/"><h1>Filemei</h1></a>
	<p>Please enter your email to retrieve your password</p>
	</div>
	<form action="/filemei/retrievepasswordware" method="post">
	<div class="input-group">
	 <input type="text" id="email" name="email" class="input-field" placeholder="Email" required>
	</div>
	<div class="input-group">
	<button> Retrieve <i class="fa-solid fa-arrow-right"></i></button>
	</div>
	</form>
	<div class="signup">
	<p>Already have an account? <a href="/filemei/login">Login.</a></p>
	</div>
	</div>  
  </body>
  </html>