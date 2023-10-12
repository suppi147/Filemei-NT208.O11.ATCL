<%@ page language="java" contentType="text/html"%>
  <!DOCTYPE html>
  <html lang="en">
  <head>
    <meta charset="utf-8">

    <title>Filemei</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="/filemei/assets/upload/upload.css" rel="stylesheet">
    <script src="/filemei/assets/upload/upload.js"></script>
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
    <div class="button-right">
      <button class="button-three" onclick="linkTrigger('/filemei/login')">Login</button>
    </div>
    <div class="button-left">
      <button class="button-four" onclick="linkTrigger('/filemei/signup')">Sign Up</button>
    </div>
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
          <form id="FilemeiUpload" action="/filemei/FilemeiUpload" method="post" enctype="multipart/form-data" class="hidden">
            <input type="file" name="fileToUpload" id="fileToUpload" multiple>
          </form>
          <progress id="progressBar" max="100" value="0" style="display:none;"></progress>
      </div>
    </div>
    <div class="w3-light-grey" style="visibility:hidden;">
  			<div id="myBar" class="w3-container w3-blue w3-round-xlarge" style="width:0%;">0%</div>
	  </div>
    <button id="submit" class="button-two" type="submit" onclick="uploadBar2();emptyAlertdanger();">Upload</button>
    
  </div>
</div>
</body>
</html>
    