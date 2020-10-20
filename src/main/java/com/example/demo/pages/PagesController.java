package com.example.demo.pages;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PagesController {
	
	@RequestMapping("/")
	public String home() {
		return "Hello there :-)\n Welcome to Spring Framework";
	}
	
	@RequestMapping("/about")
	public String about() {
		return "About us Page Yay";
	}
}
