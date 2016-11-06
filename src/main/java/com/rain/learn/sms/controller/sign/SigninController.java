package com.rain.learn.sms.controller.sign;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rain.learn.sms.controller.BaseController;

@Controller
@RequestMapping(value = "/sign")
public class SigninController extends BaseController {

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String showLogin(ModelMap model) {
        return "/sign/signin";
    }
}
