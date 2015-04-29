package ad.rws.campaign.v1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by cyril on 4/15/15.
 */
@Component
public class SecurityFilter extends GenericFilterBean {

    private AuthenticationManager authenticationManager;

    @Autowired
    public SecurityFilter(SecurityAuthenticationManager securityAuthenticationManager) {
        this.authenticationManager = securityAuthenticationManager;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //TODO: Do something security related here
        PreAuthenticatedAuthenticationToken requestAuthentication = new PreAuthenticatedAuthenticationToken("FAKE", null);
        Authentication responseAuthentication = this.authenticationManager.authenticate(requestAuthentication);
        if (responseAuthentication == null || !responseAuthentication.isAuthenticated()) {
            return;
        }

        SecurityContextHolder.getContext().setAuthentication(responseAuthentication);

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
