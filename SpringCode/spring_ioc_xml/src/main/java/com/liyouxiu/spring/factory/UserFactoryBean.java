package com.liyouxiu.spring.factory;

import com.liyouxiu.spring.pojo.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author liyouxiu
 * @date 2022/9/30 11:14
 *
 * FactoryBean是一个接口，需要通过创建一个类实现接口
 * 其中有三个方法
 * getObject：通过一个对象交给IOC容器管理
 * getObjectType：设置所提供对象的类型
 * isSingleton：所提供的的对象是否为单例
 * 当FactoryBean的实现配置为bean时，会将当前类中的Object所返回的对象交给IOC容器管理
 *
 */
public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
