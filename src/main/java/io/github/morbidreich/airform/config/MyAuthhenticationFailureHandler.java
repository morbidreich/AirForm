package io.github.morbidreich.airform.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyAuthhenticationFailureHandler implements AuthenticationFailureHandler {
	@Override
	public void onAuthenticationFailure(
			  HttpServletRequest request,
			  HttpServletResponse response,
			  AuthenticationException exception) throws IOException, ServletException {

		RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
		redirectStrategy.sendRedirect(request, response, "/loginfailed");

	}
}
