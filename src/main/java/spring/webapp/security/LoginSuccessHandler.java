package spring.webapp.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    private final int SESSION_TIMEOUT_IN_SECONDS = 60 * 30;
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        request.getSession().setMaxInactiveInterval(SESSION_TIMEOUT_IN_SECONDS);
        DefaultSavedRequest defaultSavedRequest = (DefaultSavedRequest) request.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST");
        if(defaultSavedRequest != null){
            String targetURL = defaultSavedRequest.getRedirectUrl();
            redirectStrategy.sendRedirect(request, response, targetURL);
        }
        else {
            if (authentication.getAuthorities().toArray()[0].toString().equals("ROLE_admin")) {
                redirectStrategy.sendRedirect(request, response, "/adminpage");
            }if(authentication.getAuthorities().toArray()[0].toString().equals("ROLE_moderator")){
                redirectStrategy.sendRedirect(request,response,"/moderatormenu");
            } else {
                redirectStrategy.sendRedirect(request, response, "/");
            }
        }
    }
}
