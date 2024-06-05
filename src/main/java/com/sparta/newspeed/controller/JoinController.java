package com.sparta.newspeed.controller;

import com.sparta.newspeed.dto.JoinDto;
import com.sparta.newspeed.service.JoinService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class JoinController {

    private final JoinService joinService;

    public JoinController(JoinService joinService) {
        this.joinService = joinService;
    }

    @PostMapping ("/signup")
    public String signup (JoinDto joinDto) {

        joinService.signup(joinDto);

        return "ok";
    }
}
