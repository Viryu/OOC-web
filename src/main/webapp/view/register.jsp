<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="htmldata\css\bootstrap.css">
<link href="htmldata\css2\register.css" rel="stylesheet" id="bootstrap-css">
<script src="htmldata\js\bootstrap.js"></script>
<script src="htmldata\js2\register.js"></script>
<div class="container">
    <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Register</h3>
                    <c:if test="${not empty error_register}">
                        <h5 class="text-danger">${error_register}</h5>
                    </c:if>
                </div>
                <div class="panel-body">
                    <form role="form" action="/register=newuser" method = "post" onsubmit="return validate()">
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="text" name="first_name" id="first_name" value="${first_name}" class="form-control input-sm" placeholder="First Name" minlength="3" required>
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="text" name="last_name" id="last_name" value="${last_name}" class="form-control input-sm" placeholder="Last Name" minlength="3" required>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <input type="email" name="email" id="email" value="${email}" class="form-control input-sm" placeholder="Email Address" required>
                            <input type="date" name="dob" id="dob" value="${dob}"  class="form-control input-sm" required>
                            <input type="text" name="phone_number" id="phone_number" value="${phone_number}" class="form-control input-sm" placeholder ="Phone Number" minlength="10" maxlength="12" required>
                        </div>

                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="password" name="password" id="password" class="form-control input-sm" placeholder="Password" minlength="5" required>
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="password" name="password_confirmation" id="password_confirmation" class="form-control input-sm" placeholder="Confirm Password" minlength="5" required>
                                </div>
                            </div>
                        </div>
                        <input class="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                        <input type="submit" value="Register" class="btn btn-info btn-block">
                        <button type="button" class="btn btn-info btn-block" onclick="homeredirect()">Return To Home</button>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
