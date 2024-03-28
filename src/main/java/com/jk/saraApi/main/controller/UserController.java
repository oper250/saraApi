package com.jk.saraApi.main.controller;

import com.jk.saraApi.main.dto.UserDTO;
import com.jk.saraApi.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/join")
    public String joinP() {

        return "join";
    }

    @PostMapping("/joinProcess")
    public String joinProcess(UserDTO userDTO) throws Exception {
        int rs = userService.joinProcess(userDTO);

        return "redirect: /login";
    }
}
