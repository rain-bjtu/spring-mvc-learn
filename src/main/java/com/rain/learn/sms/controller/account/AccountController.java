package com.rain.learn.sms.controller.account;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rain.learn.sms.controller.BaseController;
import com.rain.learn.sms.exception.InvalidDataException;
import com.rain.learn.sms.service.AccountService;
import com.rain.learn.sms.util.StringUtil;
import com.rain.learn.sms.view.model.OldNewPassword;

@Controller
@RequestMapping(value = "/account")
public class AccountController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/change-password", method = RequestMethod.GET)
    public String getChangePassword(ModelMap model) {
        return "account/change-password";
    }

    @RequestMapping(value = "/change-password", method = RequestMethod.POST)
    public String changePassword(ModelMap model, @Valid @ModelAttribute("oldNewPassword") OldNewPassword onPassword,
            BindingResult result) {
        if (result.hasErrors()) {
            logger.warn("Input is invalide");
            return getChangePassword(model);
        }
        try {
            accountService.changePassword(onPassword);
        } catch (InvalidDataException e) {
            logger.warn("Incorrect password", e);
            return getChangePassword(model);
        }
        return "redirect:/index";
    }

    @ResponseBody
    @RequestMapping(value = "/check-password", method = RequestMethod.POST)
    public boolean checkPassword(@ModelAttribute("password") String password) {
        if (!StringUtil.lengthValid(password)) {
            return false;
        }
        return accountService.checkPassword(password);
    }
}
