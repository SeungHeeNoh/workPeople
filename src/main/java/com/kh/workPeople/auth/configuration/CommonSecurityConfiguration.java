package com.kh.workPeople.auth.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.header.writers.frameoptions.WhiteListedAllowFromStrategy;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.kh.workPeople.account.login.model.service.ManagerLoginService;
import com.kh.workPeople.auth.handler.ManagerLoginFailureHandler;
import com.kh.workPeople.auth.handler.ManagerLoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class CommonSecurityConfiguration extends WebSecurityConfigurerAdapter {

	private ManagerLoginService managerLoginService;
	
	@Autowired
	public CommonSecurityConfiguration(ManagerLoginService managerLoginService) {
		this.managerLoginService = managerLoginService;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
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
				.antMatchers("/account/manager/login").permitAll()
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
				.logoutRequestMatcher(new AntPathRequestMatcher("/manager/logout"))
				.deleteCookies("JESSIONID")
				.invalidateHttpSession(true)
				.logoutSuccessUrl("/main");
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(managerLoginService).passwordEncoder(passwordEncoder());
	}
}
