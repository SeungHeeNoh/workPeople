package com.kh.workPeople.auth.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.kh.workPeople.account.login.model.service.LoginService;
import com.kh.workPeople.auth.handler.MemberLoginFailureHandler;
import com.kh.workPeople.auth.handler.MemberLoginSuccessHandler;

@EnableWebSecurity
@Order(Ordered.HIGHEST_PRECEDENCE)
public class UserSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	private LoginService loginService;
	private PasswordEncoder passwordEncoder;

	@Autowired
	public UserSecurityConfiguration(LoginService loginService, PasswordEncoder passwordEncoder) {
		this.loginService = loginService;
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
			.requestMatchers()
				.antMatchers("/account/member/**")
				.antMatchers("/member/**")
			.and()
				.authorizeRequests()
				.antMatchers("/persoanl/**").hasRole("PERSONAL")
				.antMatchers("/company/**").hasRole("COMPANY")
			.and()
				.formLogin()
				.loginPage("/account/member/login")
				.usernameParameter("id")
				.passwordParameter("password")
				.successForwardUrl("/main")
				.successHandler(new MemberLoginSuccessHandler(loginService))
				.failureHandler(new MemberLoginFailureHandler(loginService))
			.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
				.deleteCookies("JESSIONID", "remember-me")
				.invalidateHttpSession(true)
				.logoutSuccessUrl("/main")
			.and()
				.rememberMe()
				.rememberMeParameter("remember-me")
				.tokenValiditySeconds(60*60*24*15)
				.userDetailsService(loginService);
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(loginService).passwordEncoder(passwordEncoder);
	}

}
