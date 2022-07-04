package com.ctw.ffn131330.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
class GlobalDefaultExceptionHandler {
    private ExceptionObj buildExceptionObj(HttpServletRequest req, Exception ex) {
        ExceptionObj expObj = new ExceptionObj();
        expObj.setMessage(ex.getMessage());
        expObj.setTimestamp(new Date(System.currentTimeMillis()));
        expObj.setUrl(req.getRequestURL().toString());
        expObj.setExceptionType(ex.getClass().getSimpleName());
        return expObj;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(GenericException.UserExceptions.class)
    public ExceptionObj handleError(HttpServletRequest req, Exception ex) {
//        logger.error("Request: " + req.getRequestURL() + " raised " + ex);
        return this.buildExceptionObj(req,ex);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(GenericException.TestException.class)
    public ExceptionObj forbiddenExp(HttpServletRequest req, Exception ex) {
//        logger.error("Request: " + req.getRequestURL() + " raised " + ex);
        return this.buildExceptionObj(req,ex);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(RuntimeException.class)
    public ExceptionObj genericExp(HttpServletRequest req, Exception ex) {
//        logger.error("Request: " + req.getRequestURL() + " raised " + ex);
        return this.buildExceptionObj(req,ex);
    }

}
