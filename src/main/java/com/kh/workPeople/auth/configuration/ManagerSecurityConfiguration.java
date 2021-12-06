package com.kh.workPeople.auth.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.kh.workPeople.account.login.model.service.ManagerLoginService;
import com.kh.workPeople.auth.handler.ManagerLoginFailureHandler;
import com.kh.workPeople.auth.handler.ManagerLoginSuccessHandler;
import com.kh.workPeople.auth.handler.WebAccessDeniedHandler;

@EnableWebSecurity
public class ManagerSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	private ManagerLoginService managerLoginService;
	private PasswordEncoder passwordEncoder;
	private SessionRegistry sessionRegistry;
	private ManagerLoginSuccessHandler managerLoginSuccessHandler;
	private ManagerLoginFailureHandler managerLoginFailureHandler;
	private WebAccessDeniedHandler webAccessDeniedHandler;

	@Autowired
	public ManagerSecurityConfiguration(ManagerLoginService managerLoginService, PasswordEncoder passwordEncoder, SessionRegistry sessionRegistry,
										ManagerLoginSuccessHandler managerLoginSuccessHandler, ManagerLoginFailureHandler managerLoginFailureHandler, WebAccessDeniedHandler webAccessDeniedHandler) {
		this.managerLoginService = managerLoginService;
		this.sessionRegistry = sessionRegistry;
		this.passwordEncoder = passwordEncoder;
		this.managerLoginSuccessHandler = managerLoginSuccessHandler;
		this.managerLoginFailureHandler = managerLoginFailureHandler;
		this.webAccessDeniedHandler = webAccessDeniedHandler;
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(CommonSecurityConfiguration.SECURITY_EXCLUDE_PATTERN);
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
				.successHandler(managerLoginSuccessHandler)
				.failureHandler(managerLoginFailureHandler)
			.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/account/manager/logout"))
				.deleteCookies("JESSIONID")
				.invalidateHttpSession(true)
				.logoutSuccessUrl("/main")
			.and()
				.exceptionHandling()
				.accessDeniedHandler(webAccessDeniedHandler)
			.and()
				.sessionManagement()
				.maximumSessions(1)
				.maxSessionsPreventsLogin(false)
				.expiredUrl("/account/member/personal/login")
				.sessionRegistry(sessionRegistry);
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(managerLoginService).passwordEncoder(passwordEncoder);
	}

}
