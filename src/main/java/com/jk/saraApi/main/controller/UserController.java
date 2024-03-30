package com.jk.saraApi.main.controller;

import com.jk.saraApi.common.CommonController;
import com.jk.saraApi.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping( value = "/user" )
public class UserController extends CommonController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping(value = "/join")
//    public String join(@RequestBody JSONObject param) throws Exception {
    public String join(Map<String, Object> paramMap) throws Exception {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~" + paramMap);

//        System.out.println("~~~~~~~~~~~" + userDTO.getUserId());
//        System.out.println("~~~~~~~~~~~" + userDTO.getUserPwd());

        //int rs = userService.joinProcess(userDTO);


        return "join";
    }

    public UserController() {
        super(UserController.class);
    }

}
