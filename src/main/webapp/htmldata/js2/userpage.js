function topUpPanelFunction() {
    var x = document.getElementById("topUpPanel");
    var y = document.getElementById("transactionHistoryPanel");
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

function transactionHistoryPanelFunction() {
    var x = document.getElementById("topUpPanel");
    var y = document.getElementById("transactionHistoryPanel");
    var z = document.getElementById("dashboardPanel");
    x.style.display="none";
    y.style.display="block";
    z.style.display="none";
}

function dashboardFunction(){
    var x = document.getElementById("topUpPanel");
    var y = document.getElementById("transactionHistoryPanel");
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