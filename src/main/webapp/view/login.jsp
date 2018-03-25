<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <link href="htmldata\css\bootstrap.css" rel="stylesheet" id="bootstrap-css">
    <link rel="stylesheet" type="text/css" href="htmldata\css2\loginpage.css">
    <script src="htmldata\js2\login.js"></script>
</head>
<!------ Include the above in your HEAD tag ---------->
<div class="container">
    <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Sign In</h3>
                </div>
                <div class="panel-body">
                    <c:if test="${not empty error_login}">
                        <div class="alert alert-danger">
                                ${error_login}
                        </div>
                    </c:if>
                    <form action="#" th:action="@{/login}" method="post">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="E-mail" name="username" type="email" value="${email}">
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Password" name="password" type="password" value="${password}">
                            </div>
                            <input class="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                            <div class="checkbox">
                                <label>
                                    <input name="remember-me" type="checkbox">Remember Me
                                </label>
                            </div>
                            <div class="form-group">
                                <a href="/register">Dont have an account yet? Register Here!</a>
                            </div>
                            <!-- Change this to a button or input when using this as a form -->
                            <input type="submit" value="Login" class="btn btn-info btn-block">
                            <button type="button" class="btn btn-info btn-block" onclick="homeredirect()">Return To Home</button>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>

    </div>

</div>
</html>