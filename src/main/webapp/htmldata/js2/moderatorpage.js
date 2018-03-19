function newItemFunction() {
    var x = document.getElementById("newItemPanel");
    var y = document.getElementById("manageUserPanel");
    var z = document.getElementById("dashboardPanel");
    x.style.display="block";
    y.style.display="none";
    z.style.display="none";
}
function manageUserFunction() {
    var x = document.getElementById("newItemPanel");
    var y = document.getElementById("manageUserPanel");
    var z = document.getElementById("dashboardPanel");
    x.style.display="none";
    y.style.display="block";
    z.style.display="none";
}
function dashboardFunction(){
    var x = document.getElementById("newItemPanel");
    var y = document.getElementById("manageUserPanel");
    var z = document.getElementById("dashboardPanel");
    x.style.display="none";
    y.style.display="none";
    z.style.display="block";
}