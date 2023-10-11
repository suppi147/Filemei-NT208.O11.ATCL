function linkTrigger(link){
	window.location.href= link;	
}
function uploadFile() {
	alert(1);
	/*
	const fileInput = document.getElementById('fileToUpload');
    const progressBar = document.getElementById('progressBar');
    let formData = new FormData();
    formData.append("file", fileInput.files[0]);
    await fetch('FilemeiUpload', {
      method: "POST", 
      body: formData
    }); 
    alert('The file upload with Ajax and Java was a success!');
    */
  }

function uploadBar2(){
	const fileInput = document.getElementById('fileToUpload');
    const elem = document.getElementById('myBar');


      const file = fileInput.files[0];
      const formData = new FormData();
      formData.append('file', file);

      const xhr = new XMLHttpRequest();

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
}
