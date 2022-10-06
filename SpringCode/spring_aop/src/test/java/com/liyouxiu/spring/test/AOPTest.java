package com.liyouxiu.spring.test;

import com.liyouxiu.spring.aop.annotation.Calculator;
import com.liyouxiu.spring.aop.annotation.LoggerAspect;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liyouxiu
 * @date 2022/10/4 14:45
 */
public class AOPTest {

    @Test
    public void testAOPByAnnotation(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-annotation.xml");
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.add(1,0);

    }

}
