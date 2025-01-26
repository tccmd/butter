package com.example.butter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/")
	public String hello() {
		return "index";
	}

    @RequestMapping("/about")
	public String about() {
		return "about";
	}

    @RequestMapping("/services")
	public String services() {
		return "services";
	}

    @RequestMapping("/portfolio")
	public String portfolio() {
		return "portfolio";
	}

    @RequestMapping("/pricing")
	public String pricing() {
		return "pricing";
	}

    @RequestMapping("/blog")
	public String blog() {
		return "blog";
	}

    @RequestMapping("/contact")
	public String contact() {
		return "contact";
	}

	@RequestMapping("/service-details")
	public String serviceDetails() {
		return "service-details";
	}

	@RequestMapping("/blog-details")
	public String blogDetails() {
		return "blog-details";
	}

	@RequestMapping("/team")
	public String team() {
		return "team";
	}

	@RequestMapping("/testimonials")
	public String testimonials() {
		return "testimonials";
	}


	@GetMapping("/main")
    public String main() {
        return "main/main";
    }

	@GetMapping("/layout")
    public String layout() {
        return "layout/default_layout";
    }

	@GetMapping("/test")
    public String test() {
        return "fragment/config";
    }
}
