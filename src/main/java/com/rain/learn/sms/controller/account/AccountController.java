package com.rain.learn.sms.controller.account;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rain.learn.sms.controller.BaseController;
import com.rain.learn.sms.view.model.OldNewPassword;

@Controller
@RequestMapping(value = "/account")
public class AccountController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private InMemoryUserDetailsManager inMemoryUserManager;

    @RequestMapping(value = "/change-password", method = RequestMethod.GET)
    public String getChangePassword(ModelMap model) {
        return "account/change-password";
    }

    @RequestMapping(value = "/change-password", method = RequestMethod.POST)
    public String changePassword(ModelMap model, @Valid @ModelAttribute("oldNewPassword") OldNewPassword onPassword,
            BindingResult result) {
        logger.debug("old and new password is: {}", onPassword);
        if (result.hasErrors()) {
            logger.warn("Input is invalide");
            return getChangePassword(model);
        }
        try {
            inMemoryUserManager.changePassword(onPassword.getOldPassword(), onPassword.getNewPassword());
        } catch (AuthenticationException e) {
            logger.warn("Access denied", e);
            return getChangePassword(model);
        }
        return "redirect:/index";
    }
}
