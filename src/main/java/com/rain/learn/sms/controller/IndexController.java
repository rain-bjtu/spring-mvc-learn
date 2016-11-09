package com.rain.learn.sms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(value = { "/index", "/" }, method = RequestMethod.GET)
    public String showLogin(ModelMap model) {
        logger.debug("request index");
        return "/index";
    }
}
