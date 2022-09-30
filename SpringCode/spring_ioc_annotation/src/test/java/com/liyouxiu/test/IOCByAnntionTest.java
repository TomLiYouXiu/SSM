package com.liyouxiu.test;

import com.liyouxiu.spring.controller.UserController;
import com.liyouxiu.spring.dao.UserDao;
import com.liyouxiu.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liyouxiu
 * @date 2022/9/30 21:21
 */
public class IOCByAnntionTest {
    /**
     *@Component：将类标识为普通组件
     *
     * @Controller：将类标识为控制层组件
     *
     * @Service：将类标识为业务层组件
     *
     * @Repository：将类标识为持久层组件
     */
    @Test
    public void test(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController userController = ioc.getBean(UserController.class);
        System.out.println(userController);
//        UserService userService = ioc.getBean(UserService.class);
//        System.out.println(userService);
//        UserDao userDao = ioc.getBean(UserDao.class);
//        System.out.println(userDao);

    }
}
