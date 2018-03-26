<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="htmldata/js/jquery-3.2.1.min.js"></script>
<link href="htmldata/css/bootstrap.css" rel="stylesheet" id="bootstrap-css">
<script src="htmldata/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="htmldata/css2/receiptpage.css">
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
    <div class="container">
        <div class="panel panel-default">
            <div class="panel-heading">
                <label>Purchase Receipt</label>
            </div>
            <div class="panel-body">
                <div class="row">
                    <input type="hidden" name="pricetopay" value="${pricetopay}">
                    <input type="hidden" name="userid" value="${userid}">
                    <div class="col-md-6">
                        <i class="fa fa-plane"></i><label>${flight.startdestination}</label><i class="fa fa-long-arrow-right"></i><label>${flight.enddestination}</label>
                    </div>
                    <div class="col-md-6">
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <i class="fa fa-clock-o"></i><label>${flight.departuretime}</label><i class="fa fa-long-arrow-right"></i><label>${flight.arrivaltime}</label>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <i class="fa fa-calender"></i><label>${flight.departuredate}</label>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col-md-6">
                        <label>Your Booking Code:</label>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <label>(Booking Code)</label>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col-md-6">
                        <label>Total Price: ${price}</label>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <label>Purchase Date: ${transaction.transactiondate}</label>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col-md-6">
                        <label>Passenger List:</label>
                    </div>
                </div>



                <div class="row">
                    <div class="col-md-6">
                        <label>1.(Passenger 1)</label>
                    </div>
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