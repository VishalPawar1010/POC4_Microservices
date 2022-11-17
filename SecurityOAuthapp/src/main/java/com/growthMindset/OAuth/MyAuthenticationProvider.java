package com.growthMindset.OAuth;

import java.util.Arrays;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
	
//	for custom authentication provider

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String userName = authentication.getName();
	    String password = authentication.getCredentials().toString();
	    
	    if ("tom".equals(userName) && "cruise".equals(password)) {
	    	return new UsernamePasswordAuthenticationToken(userName, password, Arrays.asList());
	    }else {
	    	 throw new BadCredentialsException("Invalid username or Password");
	    }
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
