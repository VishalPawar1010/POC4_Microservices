package com.growthMindset.OAuth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String hello() {
		return "App for OAuth implementation";
	}
	
	@GetMapping("/bye")
	public String bye() {
		return "Good Bye";
	}


}
