package com.rain.learn.sms.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.hibernate.QueryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rain.learn.sms.exception.ServiceFailedException;

public class BaseController {
    private static Logger logger = LoggerFactory.getLogger(BaseController.class);

    @ResponseBody
    @ExceptionHandler({ SQLException.class, DataAccessException.class, QueryException.class, HibernateException.class })
    public String handleDBError(HttpServletRequest req, Exception exception) {
        logger.error("DB-related exception: Request[" + req.getRequestURL() + "]", exception);
        return "exception";
    }

    @ResponseBody
    @ExceptionHandler({ ServiceFailedException.class })
    public String handleServiceError(HttpServletRequest req, Exception exception) {
        logger.error("Service failed exception: Request[" + req.getRequestURL() + "]", exception);
        return "exception";
    }

    @ExceptionHandler({ IllegalStateException.class })
    public String handleRuntimeError(HttpServletRequest req, Exception exception) {
        logger.error("Runtime exception: Request[" + req.getRequestURL() + "]", exception);
        return "error/500";
    }

    @ExceptionHandler({ Exception.class })
    public String handleError(HttpServletRequest req, Exception exception) {
        logger.error("Exception: Request[" + req.getRequestURL() + "]", exception);
        return "error/500";
    }

}
