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

function onLoad() {
    if (window.location.href.indexOf("moderatormenu=manageuser") <= -1) {
        if (localStorage.getItem("showManageUser") !== null) localStorage.removeItem('showManageUser');
    }
    if (localStorage.getItem("showManageUser") === 'true') {
        showUserFunction();
    }
}