package ad.rws.campaign.v1.config;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * Created by cyril on 4/15/15.
 */
@Component
public class SecurityAuthenticationManager implements AuthenticationManager {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        if(authentication.getPrincipal() != null) {
            authentication.setAuthenticated(true);
            return authentication;
        }
        return null;
    }
}
