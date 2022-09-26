# 1、Spring简介

## 1.1、Spring概述

官网地址：https://spring.io/

> Spring 是最受欢迎的企业级 Java 应用程序开发框架，数以百万的来自世界各地的开发人员使用
>
> Spring 框架来创建性能好、易于测试、可重用的代码。
>
> Spring 框架是一个开源的 Java 平台，它最初是由 Rod Johnson 编写的，并且于 2003 年 6 月首次在 Apache 2.0 许可下发布。
>
> Spring 是轻量级的框架，其基础版本只有 2 MB 左右的大小。
>
> Spring 框架的核心特性是可以用于开发任何 Java 应用程序，但是在 Java EE 平台上构建 web 应
>
> 用程序是需要扩展的。 Spring 框架的目标是使 J2EE 开发变得更容易使用，通过启用基于 POJO
>
> 编程模型来促进良好的编程实践。

## 1.2、Spring家族

项目列表：https://spring.io/projects

## 1.3、Spring Framework

Spring 基础框架，可以视为 Spring 基础设施，基本上任何其他 Spring 项目都是以 Spring Framework

为基础的。

### 1.3.1、Spring Framework特性

* 非侵入式：使用 Spring Framework 开发应用程序时，Spring 对应用程序本身的结构影响非常

  小。对领域模型可以做到零污染；对功能性组件也只需要使用几个简单的注解进行标记，完全不会

  破坏原有结构，反而能将组件结构进一步简化。这就使得基于 Spring Framework 开发应用程序

  时结构清晰、简洁优雅。

* 控制反转：IOC——Inversion of Control，翻转资源获取方向。把自己创建资源、向环境索取资源

  变成环境将资源准备好，我们享受资源注入。

  面向切面编程：AOP——Aspect Oriented Programming，在不修改源代码的基础上增强代码功

  能。

* 容器：Spring IOC 是一个容器，因为它包含并且管理组件对象的生命周期。组件享受到了容器化

  的管理，替程序员屏蔽了组件创建过程中的大量细节，极大的降低了使用门槛，大幅度提高了开发

  效率。

* 组件化：Spring 实现了使用简单的组件配置组合成一个复杂的应用。在 Spring 中可以使用 XML

  和 Java 注解组合这些对象。这使得我们可以基于一个个功能明确、边界清晰的组件有条不紊的搭

  建超大型复杂应用系统。

* 声明式：很多以前需要编写代码才能实现的功能，现在只需要声明需求即可由框架代为实现。

* 一站式：在 IOC 和 AOP 的基础上可以整合各种企业应用的开源框架和优秀的第三方类库。而且

  Spring 旗下的项目已经覆盖了广泛领域，很多方面的功能性需求可以在 Spring Framework 的基

  础上全部使用 Spring 来实现。

### 1.3.2、Spring Framework五大功能模块

|        功能模块         |                          功能介绍                           |
| :---------------------: | :---------------------------------------------------------: |
|     Core Container      | 核心容器，在 Spring 环境下使用任何功能都必须基于 IOC 容器。 |
|       AOP&Aspects       |                        面向切面编程                         |
|         Testing         |          提供了对 junit 或 TestNG 测试框架的整合。          |
| Data Access/Integration |                提供了对数据访问/集成的功能。                |
|       Spring MVC        |              提供了面向Web应用程序的集成功能。              |

# 2、IOC

## 2.1、IOC容器

### 2.1.1、IOC思想

IOC：Inversion of Control，翻译过来是**反转控制**。

**①获取资源的传统方式**

自己做饭：买菜、洗菜、择菜、改刀、炒菜，全过程参与，费时费力，必须清楚了解资源创建整个过程

中的全部细节且熟练掌握。

在应用程序中的组件需要获取资源时，传统的方式是组件**主动**的从容器中获取所需要的资源，在这样的

模式下开发人员往往需要知道在具体容器中特定资源的获取方式，增加了学习成本，同时降低了开发效

率。

**②反转控制方式获取资源**

点外卖：下单、等、吃，省时省力，不必关心资源创建过程的所有细节。

反转控制的思想完全颠覆了应用程序组件获取资源的传统方式：反转了资源的获取方向——改由容器主

动的将资源推送给需要的组件，开发人员不需要知道容器是如何创建资源对象的，只需要提供接收资源

的方式即可，极大的降低了学习成本，提高了开发的效率。这种行为也称为查找的**被动**形式。

**③DI**

DI：Dependency Injection，翻译过来是**依赖注入**。

DI 是 IOC 的另一种表述方式：即组件以一些预先定义好的方式（例如：setter 方法）接受来自于容器

的资源注入。相对于IOC而言，这种表述更直接。

所以结论是：IOC 就是一种反转控制的思想， 而 DI 是对 IOC 的一种具体实现。

### 2.1.2、IOC容器在Spring中的实现

Spring 的 IOC 容器就是 IOC 思想的一个落地的产品实现。IOC 容器中管理的组件也叫做 bean。在创建

bean 之前，首先需要创建 IOC 容器。Spring 提供了 IOC 容器的两种实现方式：

**①BeanFactory**

这是 IOC 容器的基本实现，是 Spring 内部使用的接口。面向 Spring 本身，不提供给开发人员使用。

**②ApplicationContext**

BeanFactory 的子接口，提供了更多高级特性。面向 Spring 的使用者，几乎所有场合都使用

ApplicationContext 而不是底层的 BeanFactory。

**③ApplicationContext的主要实现类**

![](https://pic.imgdb.cn/item/63313a6e16f2c2beb17ea3ff.jpg)

|             类型名              |                             简介                             |
| :-----------------------------: | :----------------------------------------------------------: |
| ClassPathXmlApplicationContext  |    通过读取类路径下的 XML 格式的配置文件创建 IOC 容器对象    |
| FileSystemXmlApplicationContext |   通过文件系统路径读取 XML 格式的配置文件创建 IOC 容器对象   |
| ConfigurableApplicationContext  | ApplicationContext 的子接口，包含一些扩展方法refresh() 和 close() ，让 ApplicationContext 具有启动、关闭和刷新上下文的能力。 |
|      WebApplicationContext      | 专门为 Web 应用准备，基于 Web 环境创建 IOC 容器对象，并将对象引入存入 ServletContext 域中。 |

## 2.2、基于XML管理bean

### 2.2.1、实验一：入门案例

**①创建Maven Module**

**②引入依赖**

~~~xml
<dependencies>
    <!-- 基于Maven依赖传递性，导入spring-context依赖即可导入当前所需所有jar包 -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.3.1</version>
    </dependency>
    <!-- junit测试 -->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
        <scope>test</scope>
    </dependency>
</dependencies>
~~~

![](https://pic1.imgdb.cn/item/6331581216f2c2beb19e14e2.jpg)

**③创建类HelloWorld**

~~~java
public class HelloWorld {
	public void sayHello(){
		System.out.println("helloworld");
	}
}
~~~

**④创建Spring的配置文件**

![](https://pic1.imgdb.cn/item/6331589416f2c2beb19e9b4b.jpg)

![](https://pic1.imgdb.cn/item/633158ae16f2c2beb19ebf08.jpg)

**⑤在Spring的配置文件中配置bean**

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--
       bean：将对象交给IOC容器管理
       属性：
       id：bean的唯一标识，不能重复
       class：设置bean对象所对应的类型
    -->
    <bean id="helloworld" class="com.liyouxiu.spring.pojo.HelloWorld" ></bean>
</beans>
~~~

**⑥创建测试类测试**

~~~java
package com.liyouxiu.spring.test;

import com.liyouxiu.spring.pojo.HelloWorld;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liyouxiu
 * @date 2022/9/26 18:42
 */
public class HelloWorldTest {
    @Test
    public void test(){
        //获取IOC容器
        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取IOC容器中的bean
        HelloWorld helloworld = (HelloWorld)ioc.getBean("helloworld");
        helloworld.sayHello();

    }
}

~~~

**⑦思路**

![](https://pic1.imgdb.cn/item/6331595716f2c2beb19f6d54.jpg)

**⑧注意**

Spring 底层默认通过反射技术调用组件类的无参构造器来创建组件对象，这一点需要注意。如果在需要

无参构造器时，没有无参构造器，则会抛出下面的异常：

> org.springframework.beans.factory.BeanCreationException: Error creating bean with name
>
> 'helloworld' defined in class path resource [applicationContext.xml]: Instantiation of bean
>
> failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed
>
> to instantiate [com.atguigu.spring.bean.HelloWorld]: No default constructor found; nested
>
> exception is java.lang.NoSuchMethodException: com.atguigu.spring.bean.HelloWorld.<init>
>
> ()

### 2.2.2、实验二：获取bean

**①方式一：根据id获取**

由于 id 属性指定了 bean 的唯一标识，所以根据 bean 标签的 id 属性可以精确获取到一个组件对象。

上个实验中我们使用的就是这种方式。

**②方式二：根据类型获取**

~~~java
package com.liyouxiu.spring.test;

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
     */
    @Test
    public void testIOC(){
        //获取IOC容器
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-ioc.xml");
        //获取bean
//        Student studentOne = (Student)ioc.getBean("studentOne");
        Student student = ioc.getBean(Student.class);
        System.out.println(student);

    }
}
~~~

**③方式三：根据id和类型**

~~~java
package com.liyouxiu.spring.test;

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
}
~~~

**④注意**

当根据类型获取bean时，要求IOC容器中指定类型的bean有且只能有一个

当IOC容器中一共配置了两个：

~~~xml
<bean id="studentOne" class="com.liyouxiu.spring.pojo.Student"></bean>

<bean id="studentTwo" class="com.liyouxiu.spring.pojo.Student"></bean>
~~~

根据类型获取时会抛出异常：

> org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'com.liyouxiu.spring.pojo.Student' available: expected single matching bean but found 2: studentOne,studentTwo

**⑤扩展**

如果组件类实现了接口，根据接口类型可以获取 bean 吗？

> 可以，前提是bean唯一

如果一个接口有多个实现类，这些实现类都配置了 bean，根据接口类型可以获取 bean 吗？

> 不行，因为bean不唯一

**⑥结论**

根据类型来获取bean时，在满足bean唯一性的前提下，其实只是看：『对象 **instanceof** 指定的类

型』的返回结果，只要返回的是true就可以认定为和类型匹配，能够获取到。

即通过bean的类型，bean所继承的类的类型，bean所实现的接口的类型都可以获取bean

### 2.2.3、实验三：依赖注入之setter注入

**①创建学生类Student**

~~~java
package com.liyouxiu.spring.pojo;

/**
 * @author liyouxiu
 * @date 2022/9/26 18:54
 */
public class Student {
    private Integer sid;

    private String sname;

    private Integer age;

    private String gender;

    public Student() {
    }

    public Student(Integer sid, String sname, Integer age, String gender) {
        this.sid = sid;
        this.sname = sname;
        this.age = age;
        this.gender = gender;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
~~~

**②配置bean时为属性赋值**

~~~xml
<bean id="studentOne" class="com.liyouxiu.spring.pojo.Student"></bean>

    <!--
        property：通过成员变量的set方法进行赋值
        name：设置需要的赋值的属性名
        value：设置为属性所赋的值
     -->
    <bean id="studentTwo" class="com.liyouxiu.spring.pojo.Student">
        <property name="sid" value="1"></property>
        <property name="sname" value="李四"></property>
        <property name="age" value="23"></property>
        <property name="gender" value="男"></property>
    </bean>
~~~

**③测试**

~~~java
@Test
    public void testDI(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-ioc.xml");
        Student student = ioc.getBean("studentTwo", Student.class);
        System.out.println(student);
    }
~~~

### 2.2.4、实验四：依赖注入之构造器注入

**①在Student类中添加有参构造**

~~~java
public Student(Integer sid, String sname, Integer age, String gender) {
        this.sid = sid;
        this.sname = sname;
        this.age = age;
        this.gender = gender;
    }
~~~

**②配置bean**

~~~xml
 <bean id="studentThree" class="com.liyouxiu.spring.pojo.Student">
        <constructor-arg value="2"></constructor-arg>
        <constructor-arg value="王五"></constructor-arg>
        <constructor-arg value="24"></constructor-arg>
        <constructor-arg value="男"></constructor-arg>
 </bean>
~~~

> 注意：
>
> constructor-arg标签还有两个属性可以进一步描述构造器参数：
>
> * index属性：指定参数所在位置的索引（从0开始）
>
> * name属性：指定参数名

### 2.2.5、实验五：特殊值处理

**①字面量赋值**

> 什么是字面量？
>
> int a = 10;
>
> 声明一个变量a，初始化为10，此时a就不代表字母a了，而是作为一个变量的名字。当我们引用a
>
> 的时候，我们实际上拿到的值是10。
>
> 而如果a是带引号的：'a'，那么它现在不是一个变量，它就是代表a这个字母本身，这就是字面
>
> 量。所以字面量没有引申含义，就是我们看到的这个数据本身。

~~~xml
<!-- 使用value属性给bean的属性赋值时，Spring会把value属性的值看做字面量 --> <property name="name" value="张三"/>
~~~

**②null值**

~~~xml
<property name="name">
    <null /> 
</property>
~~~

> 注意：
>
> ~~~xml
> <property name="name" value="null"></property>
> ~~~
>
> 以上写法，为name所赋的值是字符串null

**③xml实体**

~~~xml
<!-- 小于号在XML文档中用来定义标签的开始，不能随便使用 -->
<!-- 解决方案一：使用XML实体来代替 --> 
<property name="expression" value="a &lt; b"/>
~~~

**④CDATA节**

~~~xml
<property name="expression">
    <!-- 解决方案二：使用CDATA节 --> 
    <!-- CDATA中的C代表Character，是文本、字符的含义，CDATA就表示纯文本数据 -->
    <!-- XML解析器看到CDATA节就知道这里是纯文本，就不会当作XML标签或属性来解析 -->
    <!-- 所以CDATA节中写什么符号都随意 --> 
    <value><![CDATA[a < b]]></value> 
</property>
~~~

### 2.2.6、实验六：为类类型属性赋值

**①创建班级类Clazz**