package com.mkdk.graoDeCevada.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cerveja")
public class CervejaController {
	
	@GetMapping("/novo")
	public ModelAndView novo() {
		
		ModelAndView mv = new ModelAndView("cerveja/novo");
		
		return mv;
		
	}

}
