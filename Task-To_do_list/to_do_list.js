
function additem(){
    var myitem = document.getElementById("myitem");
    var text = document.getElementById("newList").value;
    if(text=='')
    {
        alert("please Enter the item")
    }
  
    else{
    document.getElementById("newList").value = "";
    var list = document.createElement("li");
    list.innerHTML=text;
    list.className = "i";
    list.addEventListener('click', function(){
        list.classList.toggle('complete');
        document.getElementById('newList').focus();
    })
    myitem.appendChild(list);
    document.getElementById('newList').focus();
    
}
}
function clearall(){
    var elements = document.querySelectorAll(".i");
    for(var x of elements){
        x.remove();
    }
}

function clearComplete(){
    var elements = document.querySelectorAll(".complete");
    for(var x of elements){
        x.remove();
    }
}

function save(){
    var saveList = document.getElementById("myitem").innerHTML;
    localStorage.setItem("saveList", JSON.stringify(saveList));
    myitem.innerHTML="";
}

function showsaved(){
    var savedList = localStorage.getItem("saveList");
    document.getElementById("myitem").innerHTML = JSON.parse(savedList);
}