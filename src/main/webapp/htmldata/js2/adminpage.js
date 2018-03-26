function newItemFunction() {
    var x = document.getElementById("newItemPanel");
    var y = document.getElementById("manageFlightPanel");
    x.style.display="block";
    y.style.display="none";
}

function showFlightFunction() {
    var x = document.getElementById("newItemPanel");
    var y = document.getElementById("manageFlightPanel");
    x.style.display="none";
    y.style.display="block";
}

function dashboardFunction(){
    var x = document.getElementById("newItemPanel");
    var y = document.getElementById("manageFlightPanel");
    x.style.display="none";
    y.style.display="none";
}
function manageFlight() {
    localStorage.setItem('showFlight', 'true');
    window.location.href = '/adminpage';
}
function onLoadAdmin(){
    if(window.location.href.indexOf("adminpage")<=-1){
        if(localStorage.getItem("showFlight")!==null){
            localStorage.removeItem('showFlight');
        }
    }
    if(localStorage.getItem("showFlight")==='true'){
        showFlightFunction();
    }
}
function validate(){
    var currDate = new Date();
    var dDate = document.getElementById("departuredate").value;
    var aDate = document.getElementById("arrivaldate").value;
    var departureDate = new Date(dDate);
    var arrivalDate = new Date(aDate);
    var departTime = document.getElementById("departuretime").value;
    var arrivalTime = document.getElementById("arrivaltime").value;
    var test1 = new Date();
    var test2 = new Date();
    test1.setTime(departTime);
    test2.setTime(arrivalTime);
    var flag =-1;
    var alertmsg = "";
    if (departureDate<currDate){
        alertmsg = " You can't set a flight schedule at the past date";
        flag=1;
    }
    if (arrivalDate<departureDate){
        alertmsg = " You can't travel back through time , Check the date again ";
        flag =1;
    }

    if (flag==1){
        alert(alertmsg);
        return false;
    }else{
        return true;
    }
}
