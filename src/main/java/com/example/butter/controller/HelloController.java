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

	@RequestMapping("/portfolio")
	public String portfolio() {
		return "portfolio";
	}
}
