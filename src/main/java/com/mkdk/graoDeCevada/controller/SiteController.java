package com.mkdk.graoDeCevada.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class SiteController {

	@GetMapping("/")
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("site/index");
		
		return mv;
	}
}
