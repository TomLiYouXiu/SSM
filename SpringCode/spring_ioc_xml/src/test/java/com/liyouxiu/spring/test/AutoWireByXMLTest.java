package com.liyouxiu.spring.test;

import com.liyouxiu.spring.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liyouxiu
 * @date 2022/9/30 15:38
 */
public class AutoWireByXMLTest {

    /**
     * 自动装配
     * 根据指定的策略，在IOC容器中匹配某个bean，自动为bean中的类类型的属性或者接口类型的属性进行赋值
     *
     * 可以通过bean便签中的autowire属性设置自动装配
     * 自动装配的策略
     * 1.no，default：表示不装配。即bean中的属性不会自动匹配某个bean为属性赋值，此时属性使用默认值
     * 2.byType：根据需要赋值的属性类型，在IOC容器中匹配某个bean，为属性赋值
     * 3.byName：将要赋值的属性名作为bean的id在IOC容器中匹配某个bean为属性赋值
     *
     */
    @Test
    public void testAutoWire(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-autowire-xml.xml");
        UserController userController = ioc.getBean(UserController.class);
        userController.saveUser();
    }
}
