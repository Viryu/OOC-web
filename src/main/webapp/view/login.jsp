<%@ page contentType="text/html;charset=UTF-8"%>
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
                <h5 class="text-danger">${errMsg}</h5>
            </div>
            <div class="panel-body">
                <form role="form" method="post" action="/login=new">
                    <fieldset>
                        <div class="form-group">
                            <input class="form-control" placeholder="E-mail" name="email" type="email" value="${email}">
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="Password" name="password" type="password" value="${password}">
                        </div>
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