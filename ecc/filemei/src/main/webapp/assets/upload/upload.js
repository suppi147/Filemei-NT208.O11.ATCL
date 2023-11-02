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
