package com.sparta.newspeed.controller;

import com.sparta.newspeed.dto.SignupDto;
import com.sparta.newspeed.service.SignupService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class JoinController {

    private final SignupService signupService;

    public JoinController(SignupService signupService) {
        this.signupService = signupService;
    }

    @PostMapping ("/signup")
    public String signup (SignupDto signupDto) {

        signupService.signup(signupDto);

        return "ok";
    }
}
