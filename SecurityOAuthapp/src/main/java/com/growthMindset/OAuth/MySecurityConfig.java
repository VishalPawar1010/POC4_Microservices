package com.growthMindset.OAuth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter{
	
//	For using custom userDetailsService and passwordEncoder
	
	@Autowired
	@Lazy
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private MyAuthenticationProvider authenticationProvider;
	
//	@Autowired
//	@Lazy
//	private UserDetailsService userDetailsService;


	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		
//		InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//		
//		UserDetails user = User.withUsername("tom").password(passwordEncoder.encode("cruise")).authorities("read").build();
//		userDetailsService.createUser(user);
//	
//		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
//		
//		
//	}
	
//	for depreciated -> extends WebSecurityConfigurerAdapter
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.authenticationProvider(authenticationProvider);
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin();
		http.authorizeRequests().antMatchers("/hello").authenticated();
		
	}
	
//	@Bean
//	public AuthenticationManager authManager(HttpSecurity http, PasswordEncoder passwordEncoder,
//			UserDetailsService userDetailService) throws Exception {
//		return http.getSharedObject(AuthenticationManagerBuilder.class).authenticationProvider(authenticationProvider)
//				.build();
//	}
//
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.httpBasic();
//		http.authorizeRequests().anyRequest().authenticated();
//		return http.build();
//
//	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


}
