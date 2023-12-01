<%@ page import = "DBController.SessionAction" import = "CreateUserController.LinkInteraction" language="java" contentType="text/html"%>
<%
String[] filelinklist = new String[100];
String seszion = "";
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("filemeicookie")) seszion = cookie.getValue();
}
}
if(seszion.equals("null") || seszion.equals("") || seszion == null){ response.sendRedirect("/filemei/login/"); return;}

SessionAction checkemail= new SessionAction();
String emailuser = checkemail.GetEmailBySession(seszion);
LinkInteraction linkInteraction = new LinkInteraction();
for(int i = 0; i < linkInteraction.getNumberofId(emailuser); i++){
	filelinklist[i]=linkInteraction.GetLinkById(emailuser, i+1);
}
%>
  <!DOCTYPE html>
  <html lang="en">
<head>
    <meta charset="utf-8">
    <title>Filemei</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="/filemei/assets/warehouse/warehouse.css" rel="stylesheet">
    <script src="/filemei/assets/warehouse/warehouse.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Bungee&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="/filemei/assets/filemei.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
<div class="headline">
  <div class="headline-right">
    <a href="/filemei/home"><h1>filemei</h1></a>
  </div>
  <div class="headline-left">
    <div class="button-right">
  <div class="dropdown">
  <button class="dropbtn">Hi, <%= emailuser %></button>
  <div class="dropdown-content">
  <a href="http://ec2-52-221-209-106.ap-southeast-1.compute.amazonaws.com/filemei/warehouse/">Warehouse</a>
  <a href="http://ec2-52-221-209-106.ap-southeast-1.compute.amazonaws.com/filemei/warehouse/share.jsp">Share</a>
  <a href="http://ec2-52-221-209-106.ap-southeast-1.compute.amazonaws.com/filemei/logoutware">Sign out</a>
  </div>
</div>
</div>
  </div>
</div>
<div class="wrapper-table">
  <div class="container-table">
    <div class="upload-container-table">
      
      <table border="1">
		<thead>
		        <tr>
		            <th>ID</th>
		            <th style="text-align: center;">Link</th>
		            <th style="width: 132px; text-align: center;">Share</th>
		        </tr>
		    </thead>
		    <tbody>
		        <% for(int i = 0; i < linkInteraction.getNumberofId(emailuser); i++) { %>
		            <tr>
		                <td><%= i + 1 %></td>
		                <td><a href="<%= filelinklist[i] %>"><%= filelinklist[i] %></a></td>
						<td><button class="share-btn share-button" onclick="shareLink('<%= filelinklist[i] %>', '<%= emailuser %>')">Share</button></td>
		                
		            </tr>
		        <% } %>
		    </tbody>
		</table>        
          <form id="userfileToUpload" action="/filemei/UserUpload" method="post" enctype="multipart/form-data" class="hidden">
            
          </form>
          <progress id="progressBar" max="100" value="0" style="display:none;"></progress>
    </div>
    <div class="w3-light-grey" style="visibility:hidden;">
  			<div id="myBar" class="w3-container w3-blue w3-round-xlarge" style="width:0%;">0%</div>
	  </div>
	  <div class="upload-container">
      <div class="border-container">
	  <input type="file" name="fileToUpload" id="fileToUpload" multiple>
	  </div>
	  </div>
    <button id="submit" class="upload-button" type="submit" onclick="UserFileUpload();">Upload</button>
    
  </div>
</div>
</body>
</html>
    