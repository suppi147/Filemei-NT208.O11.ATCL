<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html lang="en">
  <head>
    <meta charset="utf-8" />

    <title>Filemei</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/filemei/assets/style.css" rel="stylesheet" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Bungee&display=swap" rel="stylesheet">
    
    <link rel="shortcut icon" href="/filemei/assets/filemei.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
<div class="headline">
  <div class="headline-right">
    <a href="#"><h1>filemei</h1></a>
  </div>
  <div class="headline-left">
    <a title="login" href="/login"><button class="button-three">Login</button></a>
    <a title="signup" href="/signup"><button class="button-four">Sign Up</button></a>
  </div>
</div>
<div class="wrapper">
  <div class="container">
    <a href="#" style="text-decoration: none;">
      <h2>Super simple file sharing!</h2>
    </a>
    <p>Upload as many files as you like up to <strong>1 GB</strong> and get a link to share&#128230;</p>
    <div class="upload-container">
      <div class="border-container">          
          <form id="FilemeiUpload" action="/upload" method="post" enctype="multipart/form-data" class="hidden">
            <input type="file" name="fileToUpload" id="fileToUpload" multiple>
          </form>
      </div>
    </div>
    <button id="submit" class="button-two" type="submit" form="FilemeiUpload">Upload</button>
  </div>
</div>
<footer>
  <p style="color:#eae7e7;">Copyright by <a href="https://www.youtube.com/watch?v=xvFZjo5PgG0" style="color:#eae7e7;">Group 7</a> | All right reserved</p>
</footer>
</body>
</html>
    