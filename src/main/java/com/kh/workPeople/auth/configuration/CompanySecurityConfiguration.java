package com.kh.workPeople.auth.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.kh.workPeople.account.login.model.service.CompanyLoginService;
import com.kh.workPeople.auth.handler.MemberLoginFailureHandler;
import com.kh.workPeople.auth.handler.MemberLoginSuccessHandler;
import com.kh.workPeople.auth.handler.WebAccessDeniedHandler;

@EnableWebSecurity
@Order(1)
public class CompanySecurityConfiguration extends WebSecurityConfigurerAdapter {

	private CompanyLoginService companyLoginService;
	private PasswordEncoder passwordEncoder;
	private MemberLoginSuccessHandler memberLoginSuccessHandler;
	private MemberLoginFailureHandler memberLoginFailureHandler;
	private WebAccessDeniedHandler webAccessDeniedHandler;

	@Autowired
	public CompanySecurityConfiguration(CompanyLoginService companyLoginService, PasswordEncoder passwordEncoder,
									          MemberLoginSuccessHandler memberLoginSuccessHandler, MemberLoginFailureHandler memberLoginFailureHandler, WebAccessDeniedHandler webAccessDeniedHandler) {
		this.companyLoginService = companyLoginService;
		this.passwordEncoder = passwordEncoder;
		this.memberLoginSuccessHandler = memberLoginSuccessHandler;
		this.memberLoginFailureHandler = memberLoginFailureHandler;
		this.webAccessDeniedHandler = webAccessDeniedHandler;
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(CommonSecurityConfiguration.SECURITY_EXCLUDE_PATTERN);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.requestMatchers()
				.antMatchers("/account/member/company/**")
				.antMatchers("/company/**")
			.and()
				.authorizeRequests()
				.antMatchers("/company/**").hasRole("COMPANY")
			.and()
				.formLogin()
				.loginPage("/account/member/company/login")
				.usernameParameter("id")
				.passwordParameter("password")
				.successForwardUrl("/main")
				.successHandler(memberLoginSuccessHandler)
				.failureHandler(memberLoginFailureHandler)
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
				.userDetailsService(companyLoginService)
			.and()
				.exceptionHandling()
				.accessDeniedHandler(webAccessDeniedHandler);
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(companyLoginService).passwordEncoder(passwordEncoder);
	}
}
