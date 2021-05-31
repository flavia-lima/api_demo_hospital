package br.com.sudv.enfermeiros.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {
    @GetMapping("/")
    public String showSignUpForm() {
        return "index";
    }
}
