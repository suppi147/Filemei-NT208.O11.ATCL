<%@ page language="java" contentType="text/html"%>
<html lang="en">
  <head>
    <meta charset="utf-8" />

    <title>Filemei</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/filemei/assets/download/download.css" rel="stylesheet" />
    <script src="/filemei/assets/download/download.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Bungee&display=swap" rel="stylesheet">
    
    <link rel="shortcut icon" href="/assets/filemei.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
<div class="headline">
  <div class="headline-right">
    <a href="http://localhost:8080/filemei/home/"><h1>filemei</h1></a>
  </div>
  <div class="headline-left">
    <div class="button-right">
      <button class="button-login" onclick="linkTrigger('/filemei/login')">Login</button>
    </div>
    <div class="button-left">
      <button class="button-four" onclick="linkTrigger('/filemei/signup')">Sign Up</button>
    </div>
  </div>
</div>
<div class="wrapper">
  <div class="container">
    <a href="http://localhost:8080/filemei/home/" style="text-decoration: none;">
      <h2>Super simple file sharing!</h2>
    </a>
    <p>You can share this link with your friends, so they can download it too&#9989;</p>
    <div>
       <!-- The text field -->
       <div class="copy-text">    
        <input disabled="disabled" type="text" class="textbox" value="http://localhost:8080/filemei/FilemeiDownload?filename=${requestScope.filename}" id="myInput">
        <button onclick="copy()" ><i class="fa fa-clone" ></i></button>
      </div>
    </div>
    <form id="FilemeiDownload" action="FilemeiDownload?filename=${requestScope.filename}" method="get">
      <input type="hidden" name="filename" value="${requestScope.filename}" >
      <button class="button-three" type="submit" form="FilemeiDownload" >Download</button>
    </form>
    
  </div>
</div>
</body>
</html>