package com.growthMindset.springcloud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.growthMindset.springcloud.model.Coupon;
import com.growthMindset.springcloud.repos.CouponRepo;

@Controller
public class CouponController {
	
	 @Autowired
	    private AuthenticationManager authenticationManager;
	
	@Autowired
	private CouponRepo repo;
	
//	@GetMapping("/")
//	public String index() {
//		return "index";
//	}
	
	@GetMapping("/showCreateCoupon")
	public String showCreateCoupon() {
		return "createCoupon";
	}
	
	@PostMapping("/saveCoupon")
	public String save(Coupon coupon) {
		System.out.println("before");
		repo.save(coupon);
		System.out.println("middle");
		return "createResponse";
		
	}
	
	@GetMapping("/showGetCoupon")
	public String showGetCoupon() {
		return "getCoupon";
	}
	
	@PostMapping("/getCoupon")
	public ModelAndView gtCoupon(String code) {
		ModelAndView mav = new ModelAndView("couponDetails");
		mav.addObject(repo.findByCode(code));
		return mav;
	}
	
}
