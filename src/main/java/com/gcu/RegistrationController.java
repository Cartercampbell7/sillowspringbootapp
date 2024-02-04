package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.business.SecurityServiceInterface;
import com.gcu.model.LoginModel;

@Controller
@RequestMapping("/register")
public class RegistrationController 
{
    @Autowired
    SecurityServiceInterface securityService;

    @GetMapping("/")
	public String displayRegistration(Model model) {
		// Display login form
		model.addAttribute("title", "Registration Form");
		model.addAttribute("loginModel", new LoginModel());
		return "registration";
	}

    @PostMapping("/success")
    public String registrationSuccess(Model model, LoginModel loginModel)
    {
        model.addAttribute("loginModel", loginModel);
        securityService.addUser(loginModel);
        return "registrationSuccess";
    }
}
