function searchFun(){
    var key=document.querySelector("#searchBox").value.toUpperCase();
    var myItems=document.querySelectorAll(".card");
    for(let i of myItems){
      var inItems=i.querySelector("h4").innerText.toUpperCase();
      if(inItems.indexOf(key)>-1){
        i.style.display=""
      }
      else{
        i.style.display="none"
      }
    }
  }
