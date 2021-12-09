package io.github.morbidreich.airform.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	MyAuthenticationSuccesfullHandler myAuthSuccesHandler;

	@Autowired
	MyAuthhenticationFailureHandler myAuthFailureHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication()
				  .dataSource(dataSource)
				  .usersByUsernameQuery("SELECT user_name, password, active FROM user WHERE user_name = ?")
				  .authoritiesByUsernameQuery("SELECT user_name, roles FROM user WHERE user_name = ?");

//		uses jdbc authentication with default database schema, if u wanna use other schema then
//    u need to use ### se above
//
//		auth.jdbcAuthentication()
//				  .dataSource(dataSource);


// set configuration on the auth object - IN MEMORY

//		auth.inMemoryAuthentication()
//				  .withUser("applicant")
//				  .password("applicant")
//				  .roles("APPLICANT")
//				  .and()
//				  .withUser("employee")
//				  .password("employee")
//				  .roles("EMPLOYEE")
//				  .and()
//				  .withUser("admin")
//				  .password("admin")
//				  .roles("ADMIN");



//    JDBC AUTHENTICATION with default sprint schema

//		auth.jdbcAuthentication()
//				  .dataSource(dataSource)
//				  .withDefaultSchema()
//				  .withUser(
//							 User.withUsername("applicant")
//										.password("applicant")
//									   .roles("APPLICANT")
//
//				  )
//				  .withUser(
//							 User.withUsername("admin")
//									   .password("admin")
//									   .roles("ADMIN")
//				  )
//				  .withUser(
//							 User.withUsername("employee")
//									   .password("employee")
//									   .roles("EMPLOYEE")
//				  );
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				  .antMatchers("/admin").hasRole("ADMIN")
				  .antMatchers("/employee").hasAnyRole("EMPLOYEE", "ADMIN")
				  .antMatchers("/applicant/**").hasAnyRole("APPLICANT", "EMPLOYEE", "ADMIN")
				  .antMatchers("/").permitAll()
				  .antMatchers("/h2-console").permitAll()
				  .and()
				  .formLogin()
				  .successHandler(myAuthSuccesHandler)
				  .failureHandler(myAuthFailureHandler);

		http.logout()
				  .logoutSuccessUrl("/");



		//this is to enable h2 in memory console acces during runtime
		http.csrf().disable();
		http.headers().frameOptions().disable();
	}


	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
