<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<script src="htmldata/js/jquery-3.2.1.min.js"></script>
<link href="htmldata/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="htmldata/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="htmldata/css/fontawesome.css">
<link rel="stylesheet" type="text/css" href="htmldata/css2/userpage.css">
<script src="htmldata/js2/userpage.js"></script>
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
            <ul class = "nav navbar-nav navbar-left">
                <li><a href="/" class="font-weight-bold">Home</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="/user">Welcome, <sec:authentication property="name"/></a></li>
                <sec:authorize access="isAuthenticated()">
                    <li>
                        <form action="/logout" id="logout" method="post">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                            <input type="submit" value="Logout" class="btn btn-danger btn-block">
                        </form>
                    </li>
                </sec:authorize>
            </ul>
        </div>
    </div>
</nav>


<header id="header">
    <div class="container">
        <div class="row">
            <div class="col-md-10">
                <h1><span class="glyphicon glyphicon-cog" aria-hidden="true"></span> <sec:authentication property="name"/> <small>Manage Your Profile</small></h1>
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
                    <button class="list-group-item" onclick="topUpPanelFunction()"><span class="glyphicon glyphicon-euro" aria-hidden="true"></span> Top Up Balance</button>
                    <button class="list-group-item" onclick="updateinformationFunction()"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Update Information</button>
                </div>
            </div>
            <div class="col-md-9">
                <div class="panel panel-default" id="dashboardPanel">
                    <div class="panel-heading" style="background-color:  #337ab7;">
                        <h3 class="panel-title">Dashboard</h3>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-6">
                                <label class="userInformation">User Information:</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>First Name: ${userinfo.firstName}</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Last Name: ${userinfo.lastName}</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Date of Birth: ${userinfo.dob}</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Email: ${user.email}</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Phone Number: ${userinfo.phoneNumber}</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Current Balance: ${userbalance.balance} </label>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default" id="topUpPanel" style="display:none;">
                    <div class="panel-heading" style="background-color:  #337ab7;">
                        <h3 class="panel-title">Top Up Balance</h3>
                    </div>
                    <div class="panel-body">
                        <form action="/inputbalance" method="post" class="form-horizontal">
                            <div class="form-group">
                                <div class="col-md-6">
                                    <label>Top-Up Method</label>
                                    <select class="form-control" name="topUpMethod">
                                        <option>Debit Card</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-6">
                                    <label>Amount Of Top-Up</label>
                                    <input type="number" class="form-control" name="inputamount" value="${inputamount}" required >
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-6">
                                    <label>Card Owner</label>
                                    <input type="text" class="form-control" name="cardOwner" required minlength="2">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-4">
                                    <input class="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                                    <button type="submit" class="btn btn-primary">Top Up Balance</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="panel panel-default" id="transactionHistoryPanel" style="display:none;">
                    <div class="panel-heading" style="background-color:  #337ab7;">
                        <h3 class="panel-title">Transaction History</h3>
                    </div>
                    <div class="panel-body">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>No.</th>
                                <th>Date</th>
                                <th>Ticket Amount</th>
                                <th>Booking Code</th>
                                <th>Flight Number</th>
                                <th>Total Price</th>
                            </tr>
                            </thead>
                            <tbody>
                            <th>(No.)</th>
                            <th>(Date)</th>
                            <th>(Ticket Amount)</th>
                            <th>(Booking Code)</th>
                            <th>(Flight Number)</th>
                            <th>(Total Price)</th>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="panel panel-default" id="updateInformation" style="display:none;">
                    <div class="panel-heading" style="background-color:  #337ab7;">
                        <h3 class="panel-title">Update Personal Information</h3>
                    </div>
                    <div class="panel-body">
                        <form action="/user=updateinfo" method="post" class="form-horizontal" onsubmit="return validate()">
                            <div class="form-group">
                                <div class="col-md-6">
                                    <label>First Name</label>
                                    <input type="text" class="form-control" name="firstNameUpdate" value="${userinfo.firstName}" required minlength="3">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-6">
                                    <label>Last Name</label>
                                    <input type="text" class="form-control" name="lastNameUpdate" value="${userinfo.lastName}" required minlength="3">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-6">
                                    <label>Date of Birth</label>
                                    <input type="date" class="form-control" name="dobUpdate" value="${userinfo.dob}"  id="dobUpdate" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-6">
                                    <label>Phone Number</label>
                                    <input type="text" class="form-control" name="phoneNumberUpdate" value="${userinfo.phoneNumber}"  required minlength="10" maxlength="12">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-4">
                                    <input class="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                                    <button type="submit" class="btn btn-primary">Update Information</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
