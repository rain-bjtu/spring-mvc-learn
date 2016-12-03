package com.rain.learn.sms.service.impl;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.InvalidCookieException;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.util.DigestUtils;

public class IPTokenBasedRememberMeServicesImpl extends TokenBasedRememberMeServices {
    private static Logger logger = LoggerFactory.getLogger(IPTokenBasedRememberMeServicesImpl.class);

    public IPTokenBasedRememberMeServicesImpl(String key, UserDetailsService userDetailsService) {
        super(key, userDetailsService);
        // TODO Auto-generated constructor stub
    }

    private static final ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<HttpServletRequest>();

    public HttpServletRequest getContext() {
        return requestHolder.get();
    }

    public void setContext(HttpServletRequest context) {
        requestHolder.set(context);
    }

    protected String getUserIPAddress(HttpServletRequest request) {
        return request.getRemoteAddr();
    }

    @Override
    public void onLoginSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication successfulAuthentication) {
        try {
            setContext(request);
            logger.info("1111111111111111111111111");
            super.onLoginSuccess(request, response, successfulAuthentication);
        } finally {
            setContext(null);
        }
    }

    @Override
    protected String makeTokenSignature(long tokenExpiryTime, String username, String password) {
        logger.info("22222222222222222222222");
        return DigestUtils
                .md5DigestAsHex((username + ":" + tokenExpiryTime + ":" + password + ":" + getKey() + ":" + getUserIPAddress(getContext()))
                        .getBytes());
    }

    @Override
    protected void setCookie(String[] tokens, int maxAge, HttpServletRequest request, HttpServletResponse response) {
        // append the IP adddress to the cookie
        for (String s : tokens) {
            logger.debug("origin tokens: {}", s);
        }
        String[] tokensWithIPAddress = Arrays.copyOf(tokens, tokens.length + 1);
        tokensWithIPAddress[tokensWithIPAddress.length - 1] = getUserIPAddress(request);
        logger.info("333333333333333333333333333");
        for (String s : tokensWithIPAddress) {
            logger.debug("add ip tokens: {}", s);
        }
        super.setCookie(tokensWithIPAddress, maxAge, request, response);
    }

    @Override
    protected UserDetails processAutoLoginCookie(String[] cookieTokens, HttpServletRequest request,
            HttpServletResponse response) {
        try {
            setContext(request);
            // take off the last token
            logger.info("444444444444444444444444444444");
            String ipAddressToken = cookieTokens[cookieTokens.length - 1];
            if (!getUserIPAddress(request).equals(ipAddressToken)) {
                throw new InvalidCookieException("Cookie IP Address did not contain a matching IP (contained '"
                        + ipAddressToken + "')");
            }
            return super
                    .processAutoLoginCookie(Arrays.copyOf(cookieTokens, cookieTokens.length - 1), request, response);
        } finally {
            setContext(null);
        }
    }
}
