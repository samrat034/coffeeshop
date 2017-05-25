package edu.mum.coffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorHandlerController { 
	
	@RequestMapping("/404.html")
	public String error404(Model model){
		return "error404";
	}

}
