package com.kh.workPeople.auth.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.kh.workPeople.account.login.model.service.ManagerLoginService;
import com.kh.workPeople.auth.handler.ManagerLoginFailureHandler;
import com.kh.workPeople.auth.handler.ManagerLoginSuccessHandler;

@EnableWebSecurity
public class ManagerSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	private ManagerLoginService managerLoginService;
	private PasswordEncoder passwordEncoder;

	@Autowired
	public ManagerSecurityConfiguration(ManagerLoginService managerLoginService, PasswordEncoder passwordEncoder) {
		this.managerLoginService = managerLoginService;
		this.passwordEncoder = passwordEncoder;
	}
	
	public static final String[] SECURITY_EXCLUDE_PATTERN = {
			   "/css/**"
			 , "/js/**"
			 , "/images/**"
		};

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(SECURITY_EXCLUDE_PATTERN);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/manager/**").hasRole("ADMIN")
			.and()
				.formLogin()
				.loginPage("/account/manager/login")
				.usernameParameter("id")
				.passwordParameter("password")
				.successForwardUrl("/")
				.successHandler(new ManagerLoginSuccessHandler())
				.failureHandler(new ManagerLoginFailureHandler())
			.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/account/manager/logout"))
				.deleteCookies("JESSIONID")
				.invalidateHttpSession(true)
				.logoutSuccessUrl("/main");
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(managerLoginService).passwordEncoder(passwordEncoder);
	}

}
