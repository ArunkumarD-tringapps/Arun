var head = document.getElementsByClassName("heading");
var i;

for (i = 0; i < head.length; i++) {
  head[i].addEventListener("click", function() {
    this.classList.toggle("active-header");
    var height = this.nextElementSibling;
    if (height.style.maxHeight) {
      height.style.maxHeight = null;
    } else {
      height.style.maxHeight = height.scrollHeight + "px";
    } 
  });
}
