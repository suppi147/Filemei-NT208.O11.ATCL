function UserFileUpload() {
  const fileInput = document.getElementById('fileToUpload');
  const elem = document.getElementById('myBar');

  const file = fileInput.files[0];
  const formData = new FormData();
  formData.append('file', file);

  const xhr = new XMLHttpRequest();
  xhr.open('POST', 'http://ec2-52-221-209-106.ap-southeast-1.compute.amazonaws.com/filemei/UserUpload', true);

  var width = 0;
  elem.style.visibility = "visible";

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
      window.location.href = "http://ec2-52-221-209-106.ap-southeast-1.compute.amazonaws.com/filemei/warehouse/";
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


function shareLink(link, email) {
  var recipientEmail = prompt("Enter recipient's email:");

  if (recipientEmail === null || recipientEmail === "") {
    return;
  }

  // Create a URL object from the link
  var url = new URL(link);

  // Extract the filename from the pathname
  var filename = url.searchParams.get('filename');

  // Append data to the URL parameters
  url.searchParams.append('recipientEmail', recipientEmail);
  url.searchParams.append('filename', filename);
  url.searchParams.append('userEmail', email);

  fetch('http://ec2-52-221-209-106.ap-southeast-1.compute.amazonaws.com/filemei/shareware?' + url.searchParams.toString(), {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json',
    },
  })
  .then(response => response.json())
  .then(data => {
    console.log('Success:', data);
  })
  .catch((error) => {
    console.error('Error:', error);
    alert('Share successful!');
  });
}
