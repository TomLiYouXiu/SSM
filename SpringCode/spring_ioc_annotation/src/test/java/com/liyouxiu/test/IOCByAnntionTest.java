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
     *
     * @Autowired注解：实现自动装配的注解
     * 1.@Autowired注解能够标识的位置
     *  a>标识在成员变量上不需要设置set和get方法
     *  b>标识在set方法上
     *  c>为当前成员变量的有参构造上
     * 2.@Autowired注解原理
     *  a>默认通过buType的方式，在IOC容器中通过类型匹配某个bean为属性赋值
     *  b>若有多个类型匹配的bean，此时会自动转换为byName的方式实现自动装配的效果
     *  即将要赋值的属性的属性名作为bean的id匹配某个bean为属性赋值
     *  c>若这些bean的id和要赋值的属性的属性名都不一致，此时会报异常
     *  d>此时可以在要赋值的属性上，添加一个注解@Qualifier
     *  通过该注解的value属性值，指定某个bean的id，将这个bean为属性赋值
     */
    @Test
    public void test(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController userController = ioc.getBean(UserController.class);
//        System.out.println(userController);
//        UserService userService = ioc.getBean(UserService.class);
//        System.out.println(userService);
//        UserDao userDao = ioc.getBean(UserDao.class);
//        System.out.println(userDao);
        userController.saveUser();

    }
}
