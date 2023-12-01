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
	<p>Let verify your email first</p>
	</div>
	<form action="/filemei/codeware" method="post">
	<div class="input-group">
	 <input type="text" id="code" name="code" class="input-field" placeholder="What is the code?" required>
	</div>
	<div class="input-group">
	<button> Check <i class="fa-solid fa-arrow-right"></i></button>
	</div>
	</form>
	<div class="signup">
	<p>Already have an account? <a href="/filemei/login">Login.</a></p>
	</div>
	</div>  
  </body>
  </html>