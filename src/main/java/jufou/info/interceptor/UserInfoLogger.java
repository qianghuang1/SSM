package jufou.info.interceptor;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

/**
 * Created by HQ on 10/18/16.
 */
@Aspect
@Component
public class UserInfoLogger {
    public UserInfoLogger(){
        System.out.println("UserInfoLogger Created");
    }
    @Pointcut("execution(* jufou.info.impl.UserServiceImpl.getUserNickname())")
    private void anyMethod(){

    }
    @Before("anyMethod()")
    public void doAccessCheck(){
        System.out.println("前置通知");
    }

    @AfterReturning("anyMethod()")
    public void doAfter(){
        System.out.println("后置通知");
    }

}
