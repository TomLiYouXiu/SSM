package com.liyouxiu.spring.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author liyouxiu
 * @date 2022/10/4 17:41
 */
@Component
@Aspect
@Order(1)
public class ValidateAspect {


//    @Before("execution(* com.liyouxiu.spring.aop.annotation.CalculatorImpl.*(..))")
    @Before("com.liyouxiu.spring.aop.annotation.LoggerAspect.pointCut()")
    public void BeforeMethod(){
        System.out.println("ValidateAspect----->前置通知");
    }
}
