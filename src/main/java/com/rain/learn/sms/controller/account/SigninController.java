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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rain.learn.sms.controller.BaseController;
import com.rain.learn.sms.view.model.LoginUser;

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

        return "forward:forward-security-check";
    }

    /**
     * this handler method just used to test post forward between two handler method and test RedirectAttributes can
     * bind to loginUser for redirect
     * forward --> use post/get
     * redirect --> use get, and discard request parameters
     * internal forward will directly forward to other handler method, will not pass to filter, so will not pass to
     * spring security which use filter
     * redirect will send 302 to client and then let client send the redirect request, the request will pass to filter
     * first, and then pass to the right handler method
     * 
     * @param model
     * @param request
     * @param response
     * @param loginUser
     * @throws IOException
     */
    @RequestMapping(value = "/forward-security-check", method = { RequestMethod.GET, RequestMethod.POST })
    public void forLoginForward(ModelMap model, HttpServletRequest request, HttpServletResponse response,
            @Valid @ModelAttribute("loginUser") LoginUser loginUser) throws IOException {
        String url = "../j_spring_security_check";
        String username = "username";
        String usernameValue = loginUser.getUsername();
        String password = "password";
        String passwordValue = loginUser.getPassword();
        // String usernameValue = loginUser.getUsername();
        // String password = "password";
        // String passwordValue = loginUser.getPassword();
        logger.debug("user name is {}", request.getParameter(username));
        logger.debug("password is {}", request.getParameter(password));
        logger.debug("user name is {}", loginUser.getUsername());
        logger.debug("password is {}", loginUser.getPassword());

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
    }

    /**
     * this handler method used to test RedirectAttributes
     * when refresh, RedirectAttributes attributes will be removed?
     * 
     * @param model
     * @param request
     * @param response
     * @param loginUser
     * @param result
     * @param ra
     * @return
     * @throws IOException
     * @throws ServletException
     */
    @RequestMapping(value = "/login-test", method = RequestMethod.POST)
    public String validateLogin(ModelMap model, HttpServletRequest request, HttpServletResponse response,
            @Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result, RedirectAttributes ra)
            throws IOException, ServletException {

        if (result.hasErrors()) {
            logger.debug("post login with error occur");
            return showLogin(model);
        }

        ra.addFlashAttribute("loginUser", loginUser);

        return "redirect:forward-security-check";
    }
}
