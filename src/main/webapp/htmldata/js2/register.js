function homeredirect() {
    location.href = "/";

}
function homeredirect() {
    location.href = "/";

}
function validate() {
    var flag=-1;
    var alertmsg="";
    var password = document.getElementById("password").value;
    var passwordconf = document.getElementById("password_confirmation").value;
    var inputtedDate = document.getElementById("dob").value;
    var date = new Date();
    var indate = new Date(inputtedDate);


    if (password!=passwordconf){
        alertmsg="Password does not match!";
        flag=1;
    }
    if (indate>date){
        alertmsg= "You cant input future date";
        flag=1;
    }
    if (flag==1){
        alert(alertmsg);
        return false;
    }else{
        return true;
    }



}