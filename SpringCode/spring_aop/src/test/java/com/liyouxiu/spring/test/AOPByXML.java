package com.liyouxiu.spring.test;

import com.liyouxiu.spring.aop.xml.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liyouxiu
 * @date 2022/10/4 21:06
 */
public class AOPByXML {
    @Test
    public void testAOPByXML(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("aop-xml.xml");
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.add(1,1);
    }
}
