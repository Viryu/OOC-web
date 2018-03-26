<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<script src="htmldata/js/jquery-3.2.1.min.js"></script>
<link href="htmldata/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="htmldata/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="htmldata/css2/moderatorpage.css">
<script src="htmldata/js2/adminpage.js"></script>
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
    $(document).ready(onLoadAdmin);
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
            <%--<a class="navbar-brand" href="#">WeTravel</a>--%>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/adminpage">Dashboard</a></li>
                <%--<li><a href="pages.html">Pages</a></li>--%>
                <%--<li><a href="posts.html">Posts</a></li>--%>
                <%--<li><a href="users.html">Users</a></li>--%>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="index.html">Welcome, <sec:authentication property="name"/></a></li>
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
                <h1><span class="glyphicon glyphicon-cog" aria-hidden="true"></span> ${airline} <small>Manage your sales</small></h1>
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
                    <button class="list-group-item" onclick="newItemFunction()"><span class="glyphicon glyphicon-plane" aria-hidden="true"></span> Add New Flight</button>
                    <button class="list-group-item" onclick="showFlightFunction()"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Manage Flight</button>
                </div>

            </div>

            <div class="col-md-9">
                <!--Latest User-->
                <div class="panel panel-default" id="newItemPanel" style="display:none;">
                    <div class="panel-heading" style="background-color:  #095f59;">
                        <h3 class="panel-title">Add New Flight</h3>
                    </div>
                    <div class="panel-body">
                        <form action="/admininsert" method="post" onsubmit="return validate()">
                            <h4>Airline : </h4><input name="airline" type="text" id="airline" value="${airline}" class="form-control" readonly>
                            <h4>Flight No : </h4><input name="flightno" type="text" id="flightno" value="${flightno}" minlength="5" maxlength="6" class="form-control" required>
                            <h4>From : </h4><input name="startdestination" type="text" id="startdestination" value="${startdestination}" class="form-control" required>
                            <h4>To : </h4><input name="enddestination" type="text" id="enddestination" value="${enddestination}" class="form-control" required>
                            <h4>Date of Departure : </h4><input name="departuredate" type="date" id="departuredate" value="${departuredate}" class="form-control" required>
                            <h4>Departure Time : </h4><input name="departuretime" type="time" id="departuretime" value="${departuretime}" placeholder="Departure Time" class="form-control" required>
                            <h4>Arrival Date : </h4><input name="arrivaldate" type="date" id="arrivaldate" value="${arrivaldate}" class="form-control" required>
                            <h4>Arrival Time : </h4><input type="time" name="arrivaltime" value="${arrivaltime}" class="form-control" required>
                            <h4>Seats : </h4><input name="seatleft" type="number" id="seats" value="${seatleft}" class="form-control"required min="40">
                            <h4>Price : </h4><input name="price" type="text" id="price" value="${price}" class="form-control" required>
                            <input class="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                            <h4></h4><input type="submit" class="btn btn-primary">
                        </form>
                    </div>
                </div>

                <div class="panel panel-default" id="manageFlightPanel" style="display:none;">
                    <div class="panel-heading" style="background-color:  #095f59;">
                        <h3 class="panel-title">Manage Flight</h3>
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
                                <th>Seat Max</th>
                                <th>Price</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="flight" items="${flights}">
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
                                    <td>${flight.seatmax}</td>
                                    <td>${flight.price}</td>
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
