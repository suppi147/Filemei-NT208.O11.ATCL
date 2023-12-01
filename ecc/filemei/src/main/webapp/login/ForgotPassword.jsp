<%@ page language="java" contentType="text/html"%>
  <!DOCTYPE html>
  <html lang="en">
  <head>
	<title>Filemei</title>
  <link href="/filemei-1/assets/signup/signup.css" rel="stylesheet" />
  <link rel="shortcut icon" href="/filemei-1/assets/filemei.ico" type="image/x-icon">
  <script src="/filemei-1/assets/signup/signup.js"></script>
  </head>
  <body>
  <div class="wrapper">
	<div class="heading">
	<a href="http://ec2-52-221-209-106.ap-southeast-1.compute.amazonaws.com/filemei-1/home/"><h1>Filemei</h1></a>
	<p>Please enter your email to retrieve your password</p>
	</div>
	<form action="/filemei-1/retrievepasswordware" method="post">
	<div class="input-group">
	 <input type="text" id="email" name="email" class="input-field" placeholder="Email" required>
	</div>
	<div class="input-group">
	<button> Retrieve <i class="fa-solid fa-arrow-right"></i></button>
	</div>
	</form>
	<div class="signup">
	<p>Already have an account? <a href="/filemei-1/login">Login.</a></p>
	</div>
	</div>  
  </body>
  </html>