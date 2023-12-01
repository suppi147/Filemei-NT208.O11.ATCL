function copy() {

    let copyTexts = document.querySelector(".copy-text");
    
      var copyText = document.getElementById("myInput");
  
    
    copyText.select();
    copyText.setSelectionRange(0, 99999); // For mobile devices
  
     // Copy the text inside the text field
    navigator.clipboard.writeText(copyText.value);
    // Alert the copied text
      copyTexts.classList.add("active");
      setTimeout(function () {	copyTexts.classList.remove("active");}, 1500);
  } 
  function linkTrigger(link){
	window.location.href= link;	
}
