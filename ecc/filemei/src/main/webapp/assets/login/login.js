function linkTrigger(link){
	window.location.href= link;	
}
function check() {
  if (document.getElementById('password').value !=
    document.getElementById('re-password').value) {
	document.getElementById('password').value="";
	document.getElementById('re-password').value="";
    alert("password not match.");
    return false;
  }
  return true;
}