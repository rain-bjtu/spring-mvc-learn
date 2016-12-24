package com.rain.learn.sms.service.impl;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.persistence.NoResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;

import com.rain.learn.sms.model.LoggedInUser;
import com.rain.learn.sms.model.UserAuthorityDetails;
import com.rain.learn.sms.service.LoginService;
import com.rain.learn.sms.service.UserService;
import com.rain.learn.sms.util.PasswordHash;
import com.rain.learn.sms.util.StringUtil;

@Service("loginService")
public class LoginServiceImpl implements AuthenticationProvider, LoginService {
    private static Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String password = authentication.getCredentials().toString();
        String username = authentication.getName();
        if (!StringUtil.lengthValid(username, password)) {
            logger.error("Invalid length for username or password, maybe a cracker try to sign in this system...");
            throw new BadCredentialsException("Invalid length for username or password");
        }
        String ipAddress = "";
        try {
            ipAddress = ((WebAuthenticationDetails) authentication.getDetails()).getRemoteAddress();
        } catch (Exception e) {
            logger.warn("Can not get ip address for user " + username + " yet...", e);
        }

        LoggedInUser loggedInUser = new LoggedInUser();
        loggedInUser.setUsername(username);
        loggedInUser.setIpAddress(ipAddress);

        UserAuthorityDetails userDetails = checkUser(loggedInUser, password);
        loggedInUser.setId(userDetails.getId());

        return new UsernamePasswordAuthenticationToken(loggedInUser, password, userDetails.getAuthorities());
    }

    private UserAuthorityDetails checkUser(LoggedInUser user, String password) throws AuthenticationException {
        try {
            UserAuthorityDetails userDetails = userService.getUserAuthorityDetails(user.getUsername());
            if (!PasswordHash.validatePassword(password, userDetails.getPassword())) {
                throw new BadCredentialsException("Incorrect password");
            }
            return userDetails;
        } catch (NoResultException e) {
            logger.warn("No such user: {}", user.getUsername());
            throw new UsernameNotFoundException(String.format("No such user: [%s]", user.getUsername()), e);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            logger.error("Fail to decoder password");
            throw new BadCredentialsException("Fail to decoder password", e);
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    @Override
    public LoggedInUser getLoggedInUser() {
        return (LoggedInUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
