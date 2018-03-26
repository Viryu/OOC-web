<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<script src="htmldata/js/jquery-3.2.1.min.js"></script>
<link href="htmldata/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="htmldata/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="htmldata/css2/moderatorpage.css">
<script src="htmldata/js2/moderatorpage.js"></script>
<!------ Include the above in your HEAD tag ---------->
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap core CSS -->
</head>

<body>
<script type="text/javascript">
    $(document).ready(onLoad);
</script>
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <img src="htmldata/img/logowhite.png" alt="logo" style="Height: 35px;width: 100px;">
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/moderatormenu">Dashboard</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="index.html">Welcome, Moderator</a></li>
                <sec:authorize access="isAuthenticated()">
                    <li>
                        <form action="/logout" id="logout" method="post">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                            <input type="submit" value="Logout" class="btn btn-danger btn-block">
                        </form>
                    </li>
                </sec:authorize>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>


<header id="header">
    <div class="container">
        <div class="row">
            <div class="col-md-10">
                <h1><span class="glyphicon glyphicon-cog" aria-hidden="true"></span> Moderator <small>Manage Site</small></h1>
            </div>
            <div class="col-md-2">

            </div>
        </div>
    </div>
</header>
<br>

<section id="breadcrumb">
    <div class="container">
        <ol class="breadcrumb">
            <li class="active">Dashboard</li>
        </ol>
    </div>
</section>


<section id="main">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <div class="list-group">
                    <button class="list-group-item active main-color-bg" onclick="dashboardFunction()"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span> Dashboard</button>
                    <button class="list-group-item" onclick="newItemFunction()"><span class="glyphicon glyphicon-plane" aria-hidden="true"></span> Add New Admin</button>
                    <button class="list-group-item" onclick="manageUserFunction()"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Manage User</button>
                </div>

            </div>

            <div class="col-md-9">
                <div class="panel panel-default" id="dashboardPanel">
                    <div class="panel-heading" style="background-color:  #095f59;">
                        <h3 class="panel-title">Dashboard</h3>
                    </div>
                    <div class="panel-body">
                        <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>No</th>
                            <th>Balance</th>
                            <th>Date of Transaction</th>
                            <th>UserId</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="record" items="${record}" varStatus="loop">
                            <tr>
                                <td>${loop.index+1}</td>
                                <td>${record.balance}</td>
                                <td>${record.transactiondate}</td>
                                <td>${record.userid}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                        </table>
                    </div>
                </div>
                <!--Latest User-->
                <div class="panel panel-default" id="newItemPanel" style="display:none;">
                    <div class="panel-heading" style="background-color:  #095f59;">
                        <h3 class="panel-title">Add New Admin</h3>
                    </div>
                    <div class="panel-body">
                        <form action="/moderatorinsert" method="post" onsubmit="return validate()">
                            <h4>First Name : </h4><input name="first_name" type="text" id="first_name" value="${first_name}" class="form-control" required minlength="3">
                            <h4>Last Name : </h4><input name="last_name" type="text" id="last_name" value="${last_name}" class="form-control" required minlength="3">
                            <h4>Phone Number : </h4><input name="phone_number" type="text" id="phone_number" value="${phone_number}" class="form-control" required minlength="10" maxlength="12">
                            <h4>Email : </h4><input name="email" type="text" id="email" value="${email}" class="form-control" required>
                            <h4>Password : </h4><input name="password" type="password" id="password" value="${password}" class="form-control" required minlength="5">
                            <h4>DOB : </h4><input name="dob" type="date" id="dob" value="${dob}" class="form-control" required>
                            <h4>Airline : </h4><input type="text" name="airline" id="airline" value="${airline}" class="form-control" required>
                            <input class="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                            <h4></h4><input type="submit" class="btn btn-primary">
                        </form>
                    </div>
                </div>

                <div class="panel panel-default" id="manageUserPanel" style="display:none;">
                    <div class="panel-heading" style="background-color:  #095f59;">
                        <h3 class="panel-title">Manage User</h3>
                    </div>
                    <div class="panel-body">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Email</th>
                                    <th>Password</th>
                                    <th>Role</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="userInfo" items="${userinfolist}">
                                <tr>
                                    <td>${userInfo.email}</td>
                                    <td>${userInfo.password}</td>
                                    <td>${userInfo.role}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
