package jufou.info.controller;

import jufou.info.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by HQ on 11/3/16.
 */
@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String serviceException(Exception e){
        System.out.println("错误"+e.getMessage());
        e.printStackTrace();
        return "error";
    }
}
