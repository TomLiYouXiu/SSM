package com.liyouxiu.spring.aop.xml;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author liyouxiu
 * @date 2022/10/4 17:41
 */
@Component
public class ValidateAspect {
    public void BeforeMethod(){
        System.out.println("ValidateAspect----->前置通知");
    }
}
