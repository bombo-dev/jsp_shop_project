package com.kgitbank.rentcar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontController {

	@RequestMapping(value= {"/", "/index.do"})
	public String index() {
		return "index";
	}
	
	
}
