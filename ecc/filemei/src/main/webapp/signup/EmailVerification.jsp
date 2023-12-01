<%@ page language="java" contentType="text/html"%>
  <!DOCTYPE html>
  <html lang="en">
  <head>
  <title>Filemei-1</title>
  <link href="/filemei-1-1/assets/signup/signup.css" rel="stylesheet" />
  <script src="/filemei-1-1/assets/signup/signup.js"></script>
  <link rel="shortcut icon" href="/filemei-1-1/assets/filemei-1.ico" type="image/x-icon">
  
  
  </head>
  <body>
  <div class="wrapper">
    <div class="heading">
    <a href="http://localhost:8080/filemei-1/home/"><h1>Filemei</h1></a>
    <p>Let verify your email first</p>
    </div>
    <form action="/filemei-1/codeware" method="post">
    <div class="input-group">
     <input type="text" id="code" name="code" class="input-field" placeholder="What is the code?" required>
    </div>
    <div class="input-group">
    <button> Check <i class="fa-solid fa-arrow-right"></i></button>
    </div>
    </form>
    <div class="signup">
    <p>Already have an account? <a href="/filemei-1/login">Login.</a></p>
    </div>
    </div>  
  </body>
  </html>

