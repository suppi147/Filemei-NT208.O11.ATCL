function linkTrigger(link){
	window.location.href= link;	
}

function uploadBar2(){
  	
	const fileInput = document.getElementById('fileToUpload');
    const elem = document.getElementById('myBar');


      const file = fileInput.files[0];
      //if(fileInput.files.length === 0){
		  const formData = new FormData();
      formData.append('file', file);

      const xhr = new XMLHttpRequest();
	  xhr.onreadystatechange = function() {
  	  if (xhr.readyState === 4 && xhr.status === 200) {
    	window.location.href = '/filemei/FilemeiUpload?filename=' + file.name;
  	   }
};
      xhr.open('POST', 'http://localhost:8080/filemei/FilemeiUpload', true);
	  var width = 0;
	  elem.style.visibility = "visible"
      xhr.upload.onprogress = function (e) {
        if (e.lengthComputable && width <= 100) {
          const percentComplete = (e.loaded / e.total) * 100;
          progressBar.value = percentComplete;
          width = Math.round(percentComplete);
      	  elem.style.width = width + '%'; 
      	  elem.innerHTML = width * 1  + '%';
        }
      };
      
      xhr.send(formData);
	 // }
      
      
}
function uploadBar3(){
  	
	const fileInput = document.getElementById('fileToUpload');
    const elem = document.getElementById('myBar');


      const file = fileInput.files[0];
      //if(fileInput.files.length === 0){
		  const formData = new FormData();
      formData.append('file', file);

      const xhr = new XMLHttpRequest();
      xhr.open('POST', 'http://localhost:8080/filemei/UserUpload', true);
	  var width = 0;
	  elem.style.visibility = "visible"
      xhr.upload.onprogress = function (e) {
        if (e.lengthComputable && width <= 100) {
          const percentComplete = (e.loaded / e.total) * 100;
          progressBar.value = percentComplete;
          width = Math.round(percentComplete);
      	  elem.style.width = width + '%'; 
      	  elem.innerHTML = width * 1  + '%';
        }
      };
      
      xhr.send(formData);
	 // }
      
      
}
function uploadBar4() {
  const fileInput = document.getElementById('fileToUpload');
  const elem = document.getElementById('myBar');

  const file = fileInput.files[0];
  const formData = new FormData();
  formData.append('file', file);

  const xhr = new XMLHttpRequest();
  xhr.open('POST', 'http://localhost:8080/filemei/UserUpload', true);

  var width = 0;
  elem.style.visibility = "visible"

  xhr.upload.onprogress = function (e) {
    if (e.lengthComputable && width <= 100) {
      const percentComplete = (e.loaded / e.total) * 100;
      progressBar.value = percentComplete;
      width = Math.round(percentComplete);
      elem.style.width = width + '%';
      elem.innerHTML = width * 1 + '%';
    }
  };

  xhr.onload = function () {
    // Check if the upload was successful (you may need to adjust the condition based on your server's response)
    if (xhr.status >= 200 && xhr.status < 300) {
      // Redirect after successful upload
      window.location.href = "http://localhost:8080/filemei/warehouse/";
    } else {
      // Handle error cases if needed
      console.error('File upload failed:', xhr.statusText);
    }
  };

  // Handle any errors during the request
  xhr.onerror = function () {
    console.error('Request failed');
  };

  xhr.send(formData);
}


