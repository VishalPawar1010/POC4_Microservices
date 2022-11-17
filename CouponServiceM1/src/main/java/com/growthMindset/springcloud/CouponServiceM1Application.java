package com.growthMindset.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan
//@EnableJpaRepositories("com.growthMindset.springcloud.repos")
public class CouponServiceM1Application {

	public static void main(String[] args) {
		SpringApplication.run(CouponServiceM1Application.class, args);
	}

}
