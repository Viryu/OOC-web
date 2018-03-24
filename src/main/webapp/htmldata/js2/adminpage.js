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
