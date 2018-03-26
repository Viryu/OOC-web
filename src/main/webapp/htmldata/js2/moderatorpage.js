function newItemFunction() {
    var x = document.getElementById("newItemPanel");
    var y = document.getElementById("manageUserPanel");
    var z = document.getElementById("dashboardPanel");
    x.style.display="block";
    y.style.display="none";
    z.style.display="none";
}
function manageUserFunction() {
    localStorage.setItem('showManageUser', 'true');
    window.location.href = '/moderatormenu=manageuser';
}

function manageFlightFunction(){
    localStorage.setItem('showFlight','true');
    window.location.href ='/adminpage=showflight';
}

function showUserFunction() {
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

function onLoadAdmin(){
    if(window.location.href.indexOf("adminpage=showflight")<=-1){
        if(localStorage.getItem("showFlight")!==null){
            localStorage.removeItem('showFlight');
        }
    }
    if(localStorage.getItem("showFlight")==='true'){
        showUserFunction();
    }
}
function onLoad() {
    if (window.location.href.indexOf("moderatormenu=manageuser") <= -1) {
        if (localStorage.getItem("showManageUser") !== null) localStorage.removeItem('showManageUser');
    }

    if (localStorage.getItem("showManageUser") === 'true') {
        showUserFunction();
    }
}
function validate() {
    var indate = document.getElementById("dob").value;
    var currdate = new Date();
    var inputteddate = new Date(indate);
    var flag =-1;
    var alertmsg="";
    if (inputteddate>currdate){
        flag=1;
        alertmsg="You can't put future date as your Date of Birth!";
    }

    if (flag==1){
        alert(alertmsg);
        return false;
    }else{
        return true;
    }
}