package com.example.butter.common;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception e) {
        log.error("Exception occurred", e);		
        log.error("Request URL: " + e.getMessage());

        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception", e.getMessage());
        return mv;
    }
}

