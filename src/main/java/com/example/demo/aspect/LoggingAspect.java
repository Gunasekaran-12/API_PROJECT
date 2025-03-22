package com.example.demo.aspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(* com.example.demo.services.UserService.getUser(..))")
    public void beforeMethod() {
        System.out.println(" [Before] Method Execution Started");
    }

    @After("execution(* com.example.demo.services.UserService.getUser(..))")
    public void afterMethod() {
        System.out.println(" [After] Method Execution Completed");
    }
}