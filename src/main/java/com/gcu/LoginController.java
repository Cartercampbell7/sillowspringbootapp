package com.gcu;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.business.SecurityServiceInterface;
import com.gcu.model.LoginModel;

// Class to handle login operations, security validation, and post-mapping
@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	SecurityServiceInterface securityService;

	@GetMapping("/")
	public String displayLogin(Model model) {
		// Display login form
		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", new LoginModel());
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
		
		// Check for validation errors
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "Login Form");
			return "login";
		}
		if(securityService.isAuthenticated(loginModel))
		{
			model.addAttribute("model", loginModel);
			return "loginSuccess";
		}
		else
		{
			return "login";
		}
	}


}
