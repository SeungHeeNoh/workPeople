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

import com.kh.workPeople.account.login.model.service.MemberLoginService;
import com.kh.workPeople.auth.handler.MemberLoginFailureHandler;
import com.kh.workPeople.auth.handler.MemberLoginSuccessHandler;

@EnableWebSecurity
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MemberSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	private MemberLoginService memberLoginService;
	private PasswordEncoder passwordEncoder;

	@Autowired
	public MemberSecurityConfiguration(MemberLoginService memberLoginService, PasswordEncoder passwordEncoder) {
		this.memberLoginService = memberLoginService;
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
				.antMatchers("/personal/**")
				.antMatchers("/company/**")
			.and()
				.authorizeRequests()
				.antMatchers("/personal/**").hasRole("PERSONAL")
				.antMatchers("/company/**").hasRole("COMPANY")
			.and()
				.formLogin()
				.loginPage("/account/member/login")
				.usernameParameter("id")
				.passwordParameter("password")
				.successForwardUrl("/main")
				.successHandler(new MemberLoginSuccessHandler(memberLoginService))
				.failureHandler(new MemberLoginFailureHandler(memberLoginService))
			.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/account/member/logout"))
				.deleteCookies("JESSIONID", "remember-me")
				.invalidateHttpSession(true)
				.logoutSuccessUrl("/main")
			.and()
				.rememberMe()
				.rememberMeParameter("remember-me")
				.tokenValiditySeconds(60*60*24*15)
				.userDetailsService(memberLoginService);
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(memberLoginService).passwordEncoder(passwordEncoder);
	}

}
