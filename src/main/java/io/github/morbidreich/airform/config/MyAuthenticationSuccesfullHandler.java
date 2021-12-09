package io.github.morbidreich.airform.config;

import io.github.morbidreich.airform.entity.User;
import io.github.morbidreich.airform.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class MyAuthenticationSuccesfullHandler implements AuthenticationSuccessHandler {

	@Autowired
	UserRepo userRepo;

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess
			  (HttpServletRequest request,
			   HttpServletResponse response,
			   Authentication authentication) throws IOException, ServletException {

		String redirectUrl = determineRedirectUrl(authentication);
		redirectStrategy.sendRedirect(request, response, redirectUrl);
	}

	private String determineRedirectUrl(Authentication authentication) {
		Optional<User> userOpt;
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

		Map<String, String> roleToUrlMap = new HashMap<>();

		if (authentication.getPrincipal() instanceof UserDetails) {
			UserDetails ud = (UserDetails) authentication.getPrincipal();


			roleToUrlMap.put("ROLE_ADMIN", "/admin");
			roleToUrlMap.put("ROLE_EMPLOYEE", "/employee");
			roleToUrlMap.put("ROLE_APPLICANT", "/applicant");

			for (GrantedAuthority grantedAuthority : authorities) {
				String roleName = grantedAuthority.getAuthority();
				if (roleToUrlMap.containsKey(roleName))
					return roleToUrlMap.get(roleName);
			}
		}

		throw new IllegalStateException();
	}
}
