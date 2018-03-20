<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <link href="htmldata\css\bootstrap.css" rel="stylesheet" id="bootstrap-css">
    <link rel="stylesheet" type="text/css" href="htmldata\css2\loginpage.css">
</head>
<!------ Include the above in your HEAD tag ---------->
<div class="container">
    <div class="col-md-4">
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
                            <input class="form-control" placeholder="E-mail" name="username" type="username" value="${email}">
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="Password" name="password" type="password" value="${password}">
                        </div>
                        <input class="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                        <div class="checkbox">
                            <label>
                                <input name="remember" type="checkbox" value="Remember Me">Remember Me
                            </label>
                        </div>
                        <div class="form-group">
                            <li><a href="/register">Dont have an account yet? Register</a></li>
                        </div>
                        <!-- Change this to a button or input when using this as a form -->
                        <input type="submit" value="Login" class="btn btn-info btn-block">
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>
</html>