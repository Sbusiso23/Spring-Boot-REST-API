package com.example.demo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;

@Controller
public class RegisterController {
	@Autowired
	UserRepository repo;
	
	/**
	 * Shows register page
	 * 
	 * @return ModelAndView
	 */
	@GetMapping("/register")
	public ModelAndView getForm(ModelMap model) {
		model.addAttribute("user", new User());
		return new ModelAndView("register", model);
	}
	
	/**
	 * Stores the user 
	 * 
	 * @param User user
	 * @param ModelMap model
	 * @return String
	 */
	@PostMapping("/register")
	public User register(@ModelAttribute User user, ModelMap model) {

		model.addAttribute("name", user.getName());
		model.addAttribute("email", user.getEmail());
		
		return user;
	}
}
