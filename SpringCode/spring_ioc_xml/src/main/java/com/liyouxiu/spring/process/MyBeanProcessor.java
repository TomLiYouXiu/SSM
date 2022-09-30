package com.liyouxiu.spring.process;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author liyouxiu
 * @date 2022/9/30 11:01
 */
public class MyBeanProcessor implements BeanPostProcessor {

    //此方法在bean的生命周期之前执行
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanProcessor---->后置处理器postProcessBeforeInitialization方法");
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    //此方法在bean的生命周期之后执行
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanProcessor---->后置处理器postProcessAfterInitialization方法");
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
