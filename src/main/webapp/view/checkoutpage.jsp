<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="htmldata/js/jquery-3.2.1.min.js"></script>
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
        <div class="panel-body">
            <h5>${errMsg}</h5>
            <form class="form-horizontal" action="/receipt" method="post">
            <c:forEach begin="1" end="${passengeramount}" varStatus="loop">
            <label >Passenger Name</label>
                <div class="form-group">
                    <div class="col-sm-2">
                        <select class="form-control" id="namePrefix" name="namePrefix[]">
                            <option selected value="Mr.">Mr.</option>
                            <option value="Ms.">Ms.</option>
                            <option value="Mrs.">Mrs.</option>
                        </select>
                    </div>
                    <div class="col-sm-8">
                        <input type="text" class="form-control"  id="passengername${loop.index}" name="passengername[]" placeholder="Passenger Name">
                    </div>
                </div>
                <label for="idType">Identification Type</label>
                <div class="form-group">
                    <div class="col-sm-2">
                        <select class="form-control" id="idType" name="idtype[]">
                            <option selected>Identity Card</option>
                            <option>Passport</option>
                            <option>Driving License</option>
                        </select>
                    </div>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="idnumber${loop.index}" name="idnumber[]" placeholder="Identification Number" >
                    </div>
                </div>
                <%--<div class="col-sm-2">--%>
                    <%--<button type="button" class="btn btn-primary" onclick="addPassenger()" id="addPassengerBtn">Add New Passenger</button>--%>
                <%--</div>--%>
                </c:forEach>
                <div class="row">
                    <div class="col-sm-2">
                        <input class="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                        <button type="submit" class="btn btn-primary">Purchase Ticket</button>
                    </div>
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
                    <span>${flightid.startdestination}</span><i class="fa fa-long-arrow-right"></i><span>${flightid.enddestination}</span>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-2">
                    <span>Ticket Price:</span>
                </div>
                <div class="col-sm-8">
                    <span>${pricetopay}</span>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-2">
                    <span>Current Balance:</span>
                </div>
                <div class="col-sm-8">
                    <span>${userbalance}</span>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-2">
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#topUpModal">Top-Up Balance</button>
                </div>
            </div>
        </div>
        </form>
    </div>
    <div id="topUpModal" class="modal fade" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Top-Up Balance</h4>
                </div>
                <div class="modal-body">
                    <form action="/checkout=topup" method="post" class="form-horizontal">
                        <div class="form-group">
                            <div class="col-md-12">
                                <label>Top-Up Method</label>
                                <select class="form-control" name="topUpMethod">
                                    <option>Debit Card</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12">
                                <label>Amount Of Top-Up</label>
                                <input type="number" class="form-control" name="inputamount" value="${inputamount}" required >
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12">
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
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">Cancel Top Up</button>
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