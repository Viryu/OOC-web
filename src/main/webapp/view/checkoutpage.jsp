<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<script src"htmldata/js/jquery-3.2.1.min.js"></script>
<script src="htmldata/js2/checkoutpage.js"></script>
<link href="htmldata/css/bootstrap.css" rel="stylesheet" id="bootstrap-css">
<script src="htmldata/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="htmldata/css2/transactionpage.css">
<link rel="stylesheet" type="text/css" href="htmldata/css/fontawesome.css">
<link rel="stylesheet" type="text/css" href="htmldata/css/w3.css">


<html>
<head>
    <div class="collapse navbar-collapse" id="app-navbar-collapse">
        <!-- Left Side Of Navbar -->
        <ul class="nav navbar-nav">
            <li><img src="htmldata/img/logo.png" alt="Logo" style="width:100px;height:50px"></li>
            <li><a href="/">Home</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <sec:authorize access="isAuthenticated()">
                <li>
                    <form action="/logout" id="logout" method="post">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                        <input type="submit" value="Logout" class="btn btn-danger btn-block">
                    </form>
                </li>
            </sec:authorize>
            <sec:authorize access="isAnonymous()">
                <li><a href="/login" class="btn btn-success btn-block">Login</a></li>
                <li><a href="/register" class="btn btn-warning btn-block">Register</a></li>
            </sec:authorize>
        </ul>
    </div>
</head>
<body>
<section id="mainbody">
    <div class="w3-container w3-teal"><h1>Check Out</h1></div>
    <div class="panel panel-default" id="passengerContainer">
        <div class="panel-body" id="passengerNumber1">
            <label for="passenger">Passenger Name</label>

            <form class="form-horizontal">
                <div class="form-group">
                    <div class="col-sm-2">
                        <select class="form-control" id="namePrefix">
                            <option>Mr.</option>
                            <option>Ms.</option>
                            <option>Mrs.</option>
                        </select>
                    </div>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="passengerName" placeholder="Passenger Name">
                    </div>
                </div>
                <label for="idType">Identification Type</label>
                <div class="form-group">
                    <div class="col-sm-2">
                        <select class="form-control" id="idType">
                            <option>Identity Card</option>
                            <option>Passport</option>
                            <option>Driving License</option>
                        </select>
                    </div>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="idNumber" placeholder="Identification Number">
                    </div>
                </div>
                <div class="col-sm-2">
                    <button type="button" class="btn btn-primary" onclick="addPassenger()" id="addPassengerBtn">Add New Passenger</button>
                </div>
            </form>


        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-body">
            <div class="row">
                <div class="col-sm-2">
                    <span>Ticket Details:</span>
                </div>
                <div class="col-sm-8">
                    <span>(Starting Destination)</span><i class="fa fa-long-arrow-right"></i><span>(Final Destination)</span>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-2">
                    <span>Ticket Price:</span>
                </div>
                <div class="col-sm-8">
                    <span>(Ticket Price)</span>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-2">
                    <span>Current Balance:</span>
                </div>
                <div class="col-sm-8">
                    <span>(Current Account Balance)</span>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-2">
                    <button type="button" class="btn btn-primary">Purchase Ticket</button>
                </div>
            </div>
        </div>

    </div>
</section>
</body>
<section id="footer">
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12 mt-2 mt-sm-2 text-center text-white">
                <p class="h6">&copy All right Reversed.</p>
            </div>
            </hr>
        </div>
    </div>
</section>
</html>