<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="htmldata/js/jquery-3.2.1.min.js"></script>
<link href="htmldata/css/bootstrap.css" rel="stylesheet" id="bootstrap-css">
<script src="htmldata/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="htmldata/css/fontawesome.css">
<link rel="stylesheet" type="text/css" href="htmldata/css/w3.css">
<link rel="stylesheet" type="text/css" href="htmldata/css2/bookingpage.css">


<html>
<head>
    <div class="collapse navbar-collapse" id="app-navbar-collapse">
        <!-- Left Side Of Navbar -->
        <ul class="nav navbar-nav">
            <li><img src="htmldata/img/logo.png" alt="Logo" style="width:100px;height:50px"></li>
            <li><a href="/">Home</a></li>
            <li><a href="/booking">Order Ticket</a></li>
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
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-2">
            </div>
            <div class="col-md-8">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <p class="text-center">Order Your Ticket Here!</p>
                        <p class="text-center">Airplane Ticket</p>
                    </div>
                    <div class="panel-body">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>Airline</th>
                                <th>Flight No</th>
                                <th>Flight From</th>
                                <th>Flight Destination</th>
                                <th>Date of Departure</th>
                                <th>Departure Time</th>
                                <th>Arrival Date</th>
                                <th>Arrival Time</th>
                                <th>Seats Left</th>
                                <th>Price</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="flight" items="${flighttickets}">
                                <tr>
                                    <td>${flight.airline}</td>
                                    <td>${flight.flightno}</td>
                                    <td>${flight.startdestination}</td>
                                    <td>${flight.enddestination}</td>
                                    <td>${flight.departuredate}</td>
                                    <td>${flight.departuretime}</td>
                                    <td>${flight.arrivaldate}</td>
                                    <td>${flight.arrivaltime}</td>
                                    <td>${flight.seatleft}</td>
                                    <td>${flight.price}</td>
                                    <td><form action = "/checkout" method = "post">
                                        <input class="hidden" name="flightid" value="${flight.flightid}">
                                        <input class="hidden" name="pricetopay" value="${flight.price}">
                                        <input class="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                                    <button type="submit" class="btn btn-primary">Book</button>
                                    </form>
                                    </td>
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