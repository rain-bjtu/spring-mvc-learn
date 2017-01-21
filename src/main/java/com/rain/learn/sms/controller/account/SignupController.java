package com.rain.learn.sms.controller.account;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rain.learn.sms.controller.BaseController;
import com.rain.learn.sms.ebo.UserEbo;
import com.rain.learn.sms.service.UserService;
import com.rain.learn.sms.util.PasswordHash;
import com.rain.learn.sms.view.model.RegisterUser;

@Controller
@RequestMapping(value = "/account")
public class SignupController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private SessionAuthenticationStrategy sessionStrategy;

    private static Logger logger = LoggerFactory.getLogger(SignupController.class);

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterPage(ModelMap model) {
        if (logger.isDebugEnabled()) {
            logger.debug("get register page");
        }
        return "account/signup";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(ModelMap model, HttpServletRequest request, HttpServletResponse response,
            @Valid @ModelAttribute("registerUser") RegisterUser user, BindingResult result) {
        if (logger.isDebugEnabled()) {
            logger.debug(user.toString());
        }
        if (result.hasErrors() || userService.exist(user.getUsername())) {
            logger.warn("Input is invalid: {}", result.toString());
            return showRegisterPage(model);
        }

        // TODO check user.verification

        try {
            saveUser(user);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            logger.warn("Can't hash password");
            return showRegisterPage(model);
        }
        doAutoLogin(user.getUsername(), request, response);

        return "redirect:/index";
    }

    private void saveUser(RegisterUser registerUser) throws NoSuchAlgorithmException, InvalidKeySpecException {
        UserEbo user = new UserEbo();
        user.setName(registerUser.getUsername());
        user.setPassword(PasswordHash.hashPassword(registerUser.getPassword()));
        userService.saveAsUser(user);
    }

    private void doAutoLogin(String username, HttpServletRequest request, HttpServletResponse response) {
        UserDetails details = userService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, "empty",
                details.getAuthorities());

        token.setDetails(new WebAuthenticationDetails(request));

        sessionStrategy.onAuthentication(token, request, response);
        SecurityContextHolder.getContext().setAuthentication(token);
    }
}
