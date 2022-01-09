var selectedRow = null;
function onFormSubmit(e){
    event.preventDefault();
    var formData = readFormData();
    if(selectedRow === null){
        insertNewRecord(formData);
    }
    else{
        updateRecord(formData);
    }
    resetForm();
}

//Retrieve the detail
function readFormData(){
    var formData = {};
    formData["firstname"] = document.getElementById("firstname").value;
    formData["lastname"] = document.getElementById("lastname").value;
    formData["empid"] = document.getElementById("empid").value;
    formData["email"] = document.getElementById("email").value;
    formData["city"] = document.getElementById("city").value;
    formData["mobileno"] = document.getElementById("mobileno").value;
    formData['gender']=getRadioValue('gender');
    formData['role']=getCheckBox('role')
     

    return formData;
}
// Checkbox and Radio
function getRadioValue(theRadioGroup) {
        var elements = document.getElementsByName(theRadioGroup);
        for (var i = 0, l = elements.length; i < l; i++) {
            if (elements[i].checked) {
                return elements[i].value;
            }
        }
    }

    function getCheckBox(thisCheckBoxGroup) {
        checkedValue = [];
        var inputElements = document.getElementsByName(thisCheckBoxGroup);
        for (var i = 0; inputElements[i]; ++i) {
            if (inputElements[i].checked) {
                 checkedValue.push(inputElements[i].value);              
            }

        } return checkedValue;
    }
    
//Insert the detail
function insertNewRecord(data){
    var table = document.getElementById("storedata").getElementsByTagName('tbody')[0];
    var newRow = table.insertRow(table.length);
    var cell1 = newRow.insertCell(0);
        cell1.innerHTML = data.firstname;
    var cell2 = newRow.insertCell(1);
        cell2.innerHTML = data.lastname;
    var cell3 = newRow.insertCell(2);
        cell3.innerHTML = data.empid;
    var cell4 = newRow.insertCell(3);
        cell4.innerHTML = data.email;
    var cell5 = newRow.insertCell(4);
        cell5.innerHTML = data.city;
    var cell6 = newRow.insertCell(5);
        cell6.innerHTML = data.mobileno;
    var cell7 = newRow.insertCell(6);
        cell7.innerHTML = data.gender;
    var cell8 = newRow.insertCell(7);
        cell8.innerHTML = data.role;
    var cell9 = newRow.insertCell(8);
        cell9.innerHTML = ` <a href="#C4" onClick='onEdit(this)'>Edit</a> <a onClick='onDelete(this)'>Delete</a>`
}

//Edit the detail
function onEdit(td){
  
    selectedRow = td.parentElement.parentElement;
    document.getElementById('firstname').value = selectedRow.cells[0].innerHTML;
    document.getElementById('lastname').value = selectedRow.cells[1].innerHTML;
    document.getElementById('empid').value = selectedRow.cells[2].innerHTML;
    document.getElementById('email').value = selectedRow.cells[3].innerHTML;
    document.getElementById('city').value = selectedRow.cells[4].innerHTML;
    document.getElementById('mobileno').value = selectedRow.cells[5].innerHTML;
    document.getElementById('gender').value = selectedRow.cells[6].innerHTML;
    document.getElementById('role').value = selectedRow.cells[7].innerHTML;

}

function updateRecord(formData){
    selectedRow.cells[0].innerHTML = formData.firstname;
    selectedRow.cells[1].innerHTML = formData.lastname;
    selectedRow.cells[2].innerHTML = formData.empid;
    selectedRow.cells[3].innerHTML = formData.email;
    selectedRow.cells[4].innerHTML = formData.city;
    selectedRow.cells[5].innerHTML = formData.mobileno;
    selectedRow.cells[6].innerHTML = formData.gender;
    selectedRow.cells[7].innerHTML = formData.role;
}

//Delete the detail
function onDelete(td){
    if(confirm('Do you want to delete this record?')){
        row = td.parentElement.parentElement;
        document.getElementById('storedata').deleteRow(row.rowIndex);
    }
    resetForm();
}

//Reset the detail
function resetForm(){
    document.getElementById('firstname').value = '';
    document.getElementById('lastname').value = '';
    document.getElementById('empid').value = '';
    document.getElementById('email').value = '';
    document.getElementById('city').value = '';
    document.getElementById('mobileno').value = '';
    document.getElementById('gender').value = '';
    document.getElementById('role').value = '';
}
