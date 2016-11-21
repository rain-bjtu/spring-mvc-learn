package com.rain.learn.sms.controller.account;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rain.learn.sms.controller.BaseController;
import com.rain.learn.sms.vo.LoginUser;

@Controller
@RequestMapping(value = "/account")
public class SigninController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(SigninController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin(ModelMap model) {
        logger.debug("request login");
        if (!model.containsAttribute("loginUser")) {
            model.addAttribute("loginUser", new LoginUser());
        }
        return "account/signin";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String validateLogin(ModelMap model, HttpServletRequest request, HttpServletResponse response,
            @Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result) throws IOException,
            ServletException {

        if (result.hasErrors()) {
            logger.debug("post login with error occur");
            return showLogin(model);
        }

        String url = "../j_spring_security_check";
        String username = "username";
        String usernameValue = request.getParameter(username);
        String password = "password";
        String passwordValue = request.getParameter(password);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<form name='submit' method='post'  action='" + url + "' >");
        out.println("<input type='hidden' name='" + username + "' value='" + usernameValue + "'>");
        out.println("<input type='hidden' name='" + password + "' value='" + passwordValue + "'>");
        out.println("</form>");
        out.println("<script>");
        out.println("  document.submit.submit()");
        out.println("</script>");
        logger.debug("post login without error");
        return null;
    }
}
