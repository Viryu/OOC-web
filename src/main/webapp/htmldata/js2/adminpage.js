function newItemFunction() {
    var x = document.getElementById("newItemPanel");
    var y = document.getElementById("manageFlightPanel");
    x.style.display="block";
    y.style.display="none";
}

function manageFlightFunction(){
    localStorage.setItem('showFlight','true');
    window.location.href ='/adminpage=showflight';
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

function onLoadAdmin(){
    if(window.location.href.indexOf("adminpage=showflight")<=-1){
        if(localStorage.getItem("showFlight")!==null){
            localStorage.removeItem('showFlight');
        }
    }
    showFlightFunction();
    if(localStorage.getItem("showFlight")==='true'){
        showFlightFunction();
    }
}