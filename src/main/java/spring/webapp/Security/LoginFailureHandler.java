package spring.webapp.Security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class LoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        String errorMessage = "";
        String email = request.getParameter("username");
        List<Class> invalidInputExceptions = Arrays.asList(InternalAuthenticationServiceException.class, BadCredentialsException.class);
        request.getSession().setAttribute("email", email);

        if(email.isEmpty()) errorMessage = "Please type an email";
        else if (request.getParameter("password").isEmpty()) errorMessage = "Please type a password";
        else if (invalidInputExceptions.contains(exception.getClass())) errorMessage = "Invalid username or password";
        else errorMessage = exception.getClass().toString();

        if (!errorMessage.isEmpty()) request.getSession().setAttribute("error_login", errorMessage);
        response.sendRedirect("/login?error");
    }
}