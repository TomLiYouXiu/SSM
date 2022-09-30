package com.liyouxiu.spring.test;

import com.liyouxiu.spring.pojo.Clazz;
import com.liyouxiu.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liyouxiu
 * @date 2022/9/26 21:53
 */
public class IOCByXMLTest {
    /**
     * 获取bean的三种方法
     * 1.根据bean的id获取
     * 2.根据bean的类型获取
     * 注意：根据类型获取bean时，要求IOC容器中有且只有一个类型匹配的bean
     * 若没有任何一个类型符合也会报错
     * 3.根据bean的id和类型获取
     */
    @Test
    public void testIOC(){
        //获取IOC容器
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-ioc.xml");
        //获取bean
//        Student studentOne = (Student)ioc.getBean("studentOne");

//        Student student = ioc.getBean(Student.class);

        Student studentOne = ioc.getBean("studentOne", Student.class);
        System.out.println(studentOne);

    }

    @Test
    public void testDI(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-ioc.xml");
//        Student student = ioc.getBean("studentTwo", Student.class);

//        Student student = ioc.getBean("studentFive", Student.class);
//        System.out.println(student);

//        Clazz clazz = ioc.getBean("clazzOne", Clazz.class);
//        System.out.println(clazz);

//        Student student = ioc.getBean("studentSix", Student.class);
//        System.out.println(student);

        Student student = ioc.getBean("studentSeven", Student.class);
        System.out.println(student);

    }
}
