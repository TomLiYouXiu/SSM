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
<property name="gender">
            <null></null>
</property>
~~~

> 注意：
>
> ~~~xml
> <property name="gender" value="null"></property>
> ~~~
>
> 以上写法，为name所赋的值是字符串null

**③xml实体**

~~~xml
<!-- 小于号在XML文档中用来定义标签的开始，不能随便使用 -->
<!-- 解决方案一：使用XML实体来代替 --> 
<property name="sname" value="&lt;赵六&gt;"></property>
~~~

**④CDATA节**

~~~xml
<!-- 解决方案二：使用CDATA节 -->
<!-- CDATA中的C代表Character，是文本、字符的含义，CDATA就表示纯文本数据 -->
<!-- XML解析器看到CDATA节就知道这里是纯文本，就不会当作XML标签或属性来解析 -->
<!-- 所以CDATA节中写什么符号都随意 -->
<property name="sname" >
    <value><![CDATA[<赵六>]]></value>
</property>
~~~

### 2.2.6、实验六：为类类型属性赋值

**①创建班级类Clazz**

~~~java
package com.liyouxiu.spring.pojo;

/**
 * @author liyouxiu
 * @date 2022/9/27 16:17
 */
public class Clazz {
    private Integer cid;

    private String cname;

    public Clazz() {
    }

    public Clazz(Integer cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                '}';
    }
}

~~~

**②修改Student类**

在Student类中添加以下代码：

~~~java
private Clazz clazz;
public Clazz getClazz() {
        return clazz;
    }

public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }
~~~

**③方式一：引用外部已声明的bean**

配置Clazz类型的bean：

~~~xml
<bean name="clazzOne" class="com.liyouxiu.spring.pojo.Clazz">
        <property name="cid" value="001"></property>
        <property name="cname" value="计算机科学与技术一班"></property>
    </bean>
~~~

为Student中的clazz属性赋值：

~~~xml
bean name="studentFive" class="com.liyouxiu.spring.pojo.Student">
        <property name="sid" value="4"></property>
        <property name="sname" value="马七"></property>
        <property name="age" value="23"></property>
        <property name="gender" value="男"></property>
		<!--ref:引用IOC容器中的某个bean的id        -->
        <property name="clazz" ref="clazzOne"></property>
    </bean>
~~~

错误演示：

> 如果错把ref属性写成了value属性，会抛出异常： Caused by: java.lang.IllegalStateException:
>
> Cannot convert value of type 'java.lang.String' to required type
>
> 'com.atguigu.spring.bean.Clazz' for property 'clazz': no matching editors or conversion
>
> strategy found
>
> 意思是不能把String类型转换成我们要的Clazz类型，说明我们使用value属性时，Spring只把这个
>
> 属性看做一个普通的字符串，不会认为这是一个bean的id，更不会根据它去找到bean来赋值

**④方式二：内部bean**

~~~xml
<bean name="studentFive" class="com.liyouxiu.spring.pojo.Student">
        <property name="sid" value="4"></property>
        <property name="sname" value="马七"></property>
        <property name="age" value="23"></property>
        <property name="gender" value="男"></property>
<!--        &lt;!&ndash;ref:引用IOC容器中的某个bean的id        &ndash;&gt;-->
<!--        <property name="clazz" ref="clazzOne"></property>-->
<!--        &lt;!&ndash;级联的方式，要保证提前为clazz属性赋值或者实例化        &ndash;&gt;-->
<!--        <property name="clazz.cid" value="101"></property>-->
<!--        <property name="clazz.cname" value="数字媒体一班"></property>-->
        <property name="clazz">
            <!--内部bean只能在当前的内部使用，不能通过IOC容器获取            -->
            <bean id="clazzInner" class="com.liyouxiu.spring.pojo.Clazz">
                <property name="cname" value="土木工程一班"></property>
                <property name="cid" value="301"></property>
            </bean>
        </property>
</bean>
~~~

**③方式三：级联属性赋值**

~~~xml
   <bean name="studentFive" class="com.liyouxiu.spring.pojo.Student">
        <property name="sid" value="4"></property>
        <property name="sname" value="马七"></property>
        <property name="age" value="23"></property>
        <property name="gender" value="男"></property>
        <!--ref:引用IOC容器中的某个bean的id        -->
        <property name="clazz" ref="clazzOne"></property>
        <!--级联的方式，要保证提前为clazz属性赋值或者实例化        -->
        <property name="clazz.cid" value="101"></property>
        <property name="clazz.cname" value="数字媒体一班"></property>
    </bean>
~~~

### 2.2.7、实验七：为数组类型属性赋值

**①修改Student类**

在Student类中添加以下代码：

~~~java
private String[] hobby;
public String[] getHobby() {
        return hobby;
    }
public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }
~~~

**②配置bean**

~~~xml
<bean name="studentFive" class="com.liyouxiu.spring.pojo.Student">
        <property name="sid" value="4"></property>
        <property name="sname" value="马七"></property>
        <property name="age" value="23"></property>
        <property name="gender" value="男"></property>
<!--        &lt;!&ndash;ref:引用IOC容器中的某个bean的id        &ndash;&gt;-->
<!--        <property name="clazz" ref="clazzOne"></property>-->
<!--        &lt;!&ndash;级联的方式，要保证提前为clazz属性赋值或者实例化        &ndash;&gt;-->
<!--        <property name="clazz.cid" value="101"></property>-->
<!--        <property name="clazz.cname" value="数字媒体一班"></property>-->
        <property name="clazz">
            <!--内部bean只能在当前的内部使用，不能通过IOC容器获取            -->
            <bean id="clazzInner" class="com.liyouxiu.spring.pojo.Clazz">
                <property name="cname" value="土木工程一班"></property>
                <property name="cid" value="301"></property>
            </bean>
        </property>
        <property name="hobby">
            <array>
                <value>抽烟</value>
                <value>喝酒</value>
                <value>烫头</value>
            </array>
        </property>
    </bean>
~~~

**③List集合类型的bean**

~~~xml
<!--配置一个集合类型的bean，需要使用util的约束    -->
    <util:list id="studentList">
        <ref bean="studentFive"></ref>
        <ref bean="studentFour"></ref>
        <ref bean="studentThree"></ref>
    </util:list>
    <bean name="clazzOne" class="com.liyouxiu.spring.pojo.Clazz">
        <property name="cid" value="001"></property>
        <property name="cname" value="计算机科学与技术一班"></property>

<!--        <property name="students">-->
<!--            <list>-->
<!--                <ref bean="studentFive"></ref>-->
<!--                <ref bean="studentFour"></ref>-->
<!--                <ref bean="studentThree"></ref>-->
<!--            </list>-->
<!--        </property>-->
        <property name="students" ref="studentList"></property>
    </bean>
~~~

**④Map集合类型的bean**

~~~xml
<bean id="teacherOne" class="com.liyouxiu.spring.pojo.Teacher">
        <property name="tid" value="5001"></property>
        <property name="tname" value="杰伦"></property>
    </bean>
    <bean id="teacherTwo" class="com.liyouxiu.spring.pojo.Teacher">
        <property name="tid" value="5002"></property>
        <property name="tname" value="学友"></property>
    </bean>
    <util:map id="teacherMap">
        <entry key="数学老师" value-ref="teacherOne"></entry>
        <entry key="英语老师" value-ref="teacherTwo"></entry>
    </util:map>
    <bean name="studentSix" class="com.liyouxiu.spring.pojo.Student">
        <property name="sid" value="4"></property>
        <property name="sname" value="马八"></property>
        <property name="age" value="23"></property>
        <property name="gender" value="男"></property>
        <property name="hobby">
            <array>
                <value>抽烟</value>
                <value>喝酒</value>
                <value>烫头</value>
            </array>
        </property>
        <property name="teacherMap" ref="teacherMap"></property>
<!--        <property name="teacherMap" >-->
<!--            <map>-->
<!--                <entry key="数学老师" value-ref="teacherOne"></entry>-->
<!--                <entry key="英语老师" value-ref="teacherTwo"></entry>-->
<!--            </map>-->
<!--        </property>-->
    </bean>
~~~

### 2.2.9、实验九：p命名空间

引入p命名空间后，可以通过以下方式为bean的各个属性赋值

~~~xml
<bean id="studentSeven" class="com.liyouxiu.spring.pojo.Student"
          p:sid="008" p:sname="小黑"  p:teacherMap-ref="teacherMap">
</bean>
~~~

### 2.2.10、实验十：引入外部属性文件

**①加入依赖**

~~~xml
<!-- MySQL驱动 -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.38</version>
        </dependency>
        <!-- 数据源 -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.0.31</version>
        </dependency>
~~~

**②创建外部属性文件**

~~~properties
driver=com.mysql.jdbc.Driver
url=jdbc:mysql://localhost:3306/ssm
username=root
password=root
~~~

**③引入属性文件**

~~~xml
 <!--引入jdbc.properti文件 ,可以通过${key}的方式访问value-->
    <context:property-placeholder location="jdbc.properties"></context:property-placeholder>
~~~

**④配置bean**

~~~xml
 <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="driverClassName" value="${jdbc.driver}"></property>
        <property name="url" value="${jdbc.url}"></property>
        <property name="username" value="${jdbc.username}"></property>
        <property name="password" value="${jdbc.password}"></property>
    </bean>
~~~

### 2.2.11、实验十一：bean的作用域

**①概念**

在Spring中可以通过配置bean标签的scope属性来指定bean的作用域范围，各取值含义参加下表：

|       取值        |                **含义**                 | **创建对象的时机** |
| :---------------: | :-------------------------------------: | :----------------: |
| singleton（默认） | 在IOC容器中，这个bean的对象始终为单实例 |  IOC容器初始化时   |
|     prototype     |      这个bean在IOC容器中有多个实例      |     获取bean时     |

如果是在WebApplicationContext环境下还会有另外两个作用域（但不常用）：

| **取值** |       **含义**       |
| :------: | :------------------: |
| request  | 在一个请求范围内有效 |
| session  | 在一个会话范围内有效 |

**②配置bean**

~~~xml
 <!-- scope属性：取值singleton（默认值），bean在IOC容器中只有一个实例，IOC容器初始化时创建 对象 --> 
 <!-- scope属性：取值prototype，bean在IOC容器中可以有多个实例，getBean()时创建对象 -->
    <bean id="student" class="com.liyouxiu.spring.pojo.Student" scope="prototype">
        <property name="sid" value="205"></property>
        <property name="sname" value="小狗"></property>
    </bean>
~~~

### 2.2.12、实验十二：bean的生命周期

**①具体的生命周期过程**

* bean对象创建（调用无参构造器）

* 给bean对象设置属性
* bean对象初始化之前操作（由bean的后置处理器负责）
* bean对象初始化（需在配置bean时指定初始化方法）
* bean对象初始化之后操作（由bean的后置处理器负责）
* bean对象就绪可以使用
* bean对象销毁（需在配置bean时指定销毁方法）
* IOC容器关闭

**②修改类User**

~~~java
package com.liyouxiu.spring.pojo;

/**
 * @author liyouxiu
 * @date 2022/9/28 22:15
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer age;

    public User() {
        System.out.println("生命周期：1、创建对象");
    }

    public User(Integer id, String username, String password, Integer age) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        System.out.println("生命周期：2、依赖注入");
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void initMethod() {
        System.out.println("生命周期：3、初始化");
    }

    public void destroyMethod() {
        System.out.println("生命周期：5、销毁");
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\'' + ", age=" + age + '}';
    }
}

~~~

> 注意其中的initMethod()和destroyMethod()，可以通过配置bean指定为初始化和销毁的方法

**③配置bean**

~~~xml
 <bean id="user" class="com.liyouxiu.spring.pojo.User" init-method="initMethod" destroy-method="destroyMethod">
        <property name="id" value="1"></property>
        <property name="username" value="小李"></property>
        <property name="password" value="root"></property>
        <property name="age" value="20"></property>
    </bean>
~~~

**④测试**

~~~java
package com.liyouxiu.spring.test;

import com.liyouxiu.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liyouxiu
 * @date 2022/9/29 21:56
 */
public class LifeCycleTest {
    /**
     * 1.实力化
     * 2.依赖注入
     * 3.初始化 需要通过init-method属性指定初始化的方法
     * 4.IOC容器关闭时销毁 需要通过destroy-method属性指定销毁的方法
     *
     * 注意：若bean的作用域为单例时，生命周期的前三个步骤会在获取IOC容器时执行
     * 注意：若bean的作用域为多例时，生命周期的前三个步骤会在获取bean时执行
     */
    @Test
    public void test(){
        //ConfigurableApplicationContext 是ApplicationContext的子接口，扩展了刷新和关闭容器的方法
        ConfigurableApplicationContext ioc=new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        User user = ioc.getBean(User.class);
        System.out.println(user);
        ioc.close();


    }
}
~~~

**⑤bean的后置处理器**

bean的后置处理器会在生命周期的初始化前后添加额外的操作，需要实现BeanPostProcessor接口，且配置到IOC容器中，需要注意的是，bean后置处理器不是单独针对某一个bean生效，而是针对IOC容器中所有bean都会执行创建bean的后置处理器：

~~~java
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
~~~

**在IOC容器中配置后置处理器：**

~~~xml
<bean id="MyBeanProcessor" class="com.liyouxiu.spring.process.MyBeanProcessor"></bean>
~~~

### 2.2.13、实验十三：FactoryBean

**①简介**

FactoryBean是Spring提供的一种整合第三方框架的常用机制。和普通的bean不同，配置一个FactoryBean类型的bean，在获取bean的时候得到的并不是class属性中配置的这个类的对象，而是getObject()方法的返回值。通过这种机制，Spring可以帮我们把复杂组件创建的详细过程和繁琐细节都屏蔽起来，只把最简洁的使用界面展示给我们。

将来我们整合Mybatis时，Spring就是通过FactoryBean机制来帮我们创建SqlSessionFactory对象的。

**②创建类UserFactoryBean**

~~~java
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

~~~

**③配置bean**

~~~xml
<bean class="com.liyouxiu.spring.factory.UserFactoryBean">
~~~

**④测试**

~~~java
package com.liyouxiu.spring.test;

import com.liyouxiu.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liyouxiu
 * @date 2022/9/30 11:19
 */
public class FactoryBeanTest {
    @Test
    public void testFactoryBean(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-factory.xml");
        User user = ioc.getBean(User.class);
        System.out.println(user);
    }
}
~~~

### 2.2.14、实验十四：基于xml的自动装配

> 自动装配：
>
> 根据指定的策略，在IOC容器中匹配某一个bean，自动为指定的bean中所依赖的类类型或接口类型属性赋值

**①场景模拟**

创建类UserController

~~~java
package com.liyouxiu.spring.controller;

import com.liyouxiu.spring.service.UserService;

/**
 * @author liyouxiu
 * @date 2022/9/30 14:57
 */
public class UserController  {
    private UserService  userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void saveUser(){
         userService.saveUser();
    }
}

~~~

创建接口UserService

~~~java
package com.liyouxiu.spring.service;

/**
 * @author liyouxiu
 * @date 2022/9/30 14:58
 */
public interface UserService {

    /**
     * 保存用户信息
     */
    void saveUser();
}

~~~

创建类UserServiceImpl实现接口UserService

~~~java
package com.liyouxiu.spring.impl;

import com.liyouxiu.spring.dao.UserDao;
import com.liyouxiu.spring.service.UserService;

/**
 * @author liyouxiu
 * @date 2022/9/30 14:59
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}

~~~

创建接口UserDao

~~~java
package com.liyouxiu.spring.dao;

/**
 * @author liyouxiu
 * @date 2022/9/30 15:00
 */
public interface UserDao {
    /**
     * 保存用户信息
     */
    void saveUser();
}

~~~

创建类UserDaoImpl实现接口UserDao

~~~java
package com.liyouxiu.spring.impl;

import com.liyouxiu.spring.dao.UserDao;

/**
 * @author liyouxiu
 * @date 2022/9/30 15:07
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser() {
        System.out.println("保存成功");
    }
}
~~~

**②配置bean**

> 使用bean标签的autowire属性设置自动装配效果
>
> 自动装配方式：byType
>
> byType：根据类型匹配IOC容器中的某个兼容类型的bean，为属性自动赋值
>
> 若在IOC中，没有任何一个兼容类型的bean能够为属性赋值，则该属性不装配，即值为默认值null
>
> 若在IOC中，有多个兼容类型的bean能够为属性赋值，则抛出异常
>
> NoUniqueBeanDefinitionException

~~~xml
<bean id="UserController" class="com.liyouxiu.spring.controller.UserController" autowire="byType">
<!--        <property name="userService" ref="userService"></property>-->
    </bean>

    <bean id="userService" class="com.liyouxiu.spring.impl.UserServiceImpl" autowire="byType">
<!--        <property name="userDao" ref="userDao"></property>-->
    </bean>

    <bean id="userDao" class="com.liyouxiu.spring.impl.UserDaoImpl"></bean>
~~~

> 自动装配方式：byName
>
> byName：将自动装配的属性的属性名，作为bean的id在IOC容器中匹配相对应的bean进行赋值

~~~xml
 <bean id="UserController" class="com.liyouxiu.spring.controller.UserController" autowire="byName">
<!--        <property name="userService" ref="userService"></property>-->
    </bean>

    <bean id="userService" class="com.liyouxiu.spring.impl.UserServiceImpl" autowire="byName">
<!--        <property name="userDao" ref="userDao"></property>-->
    </bean>

    <bean id="userDao" class="com.liyouxiu.spring.impl.UserDaoImpl"></bean>
~~~

**③测试**

~~~java
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
~~~

## 2.3、基于注解管理bean

### 2.3.1、实验一：标记与扫描

**①注解**

和 XML 配置文件一样，注解本身并不能执行，注解本身仅仅只是做一个标记，具体的功能是框架检测到注解标记的位置，然后针对这个位置按照注解标记的功能来执行具体操作。

本质上：所有一切的操作都是Java代码来完成的，XML和注解只是告诉框架中的Java代码如何执行。

举例：元旦联欢会要布置教室，蓝色的地方贴上元旦快乐四个字，红色的地方贴上拉花，黄色的地方贴上气球。

![](https://pic1.imgdb.cn/item/6336a4cd16f2c2beb174c1dc.jpg)

班长做了所有标记，同学们来完成具体工作。墙上的标记相当于我们在代码中使用的注解，后面同学们做的工作，相当于框架的具体操作。

**②扫描**

Spring 为了知道程序员在哪些地方标记了什么注解，就需要通过扫描的方式，来进行检测。然后根据注解进行后续操作。

**③新建Maven Module**

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

**④创建Spring配置文件**

**⑤标识组件的常用注解**

> @Component：将类标识为普通组件 
>
> @Controller：将类标识为控制层组件 
>
> @Service：将类标识为业务层组件 
>
> @Repository：将类标识为持久层组件

问：以上四个注解有什么关系和区别？

![](https://pic1.imgdb.cn/item/6336ee7116f2c2beb1c0447f.jpg)

通过查看源码我们得知，@Controller、@Service、@Repository这三个注解只是在@Component注解的基础上起了三个新的名字。

对于Spring使用IOC容器管理这些组件来说没有区别。所以@Controller、@Service、@Repository这三个注解只是给开发人员看的，让我们能够便于分辨组件的作用。

注意：虽然它们本质上一样，但是为了代码的可读性，为了程序结构严谨我们肯定不能随便胡乱标记。

**⑥创建组件**

创建控制层组件

~~~java
package com.liyouxiu.spring.controller;

import org.springframework.stereotype.Controller;

/**
 * @author liyouxiu
 * @date 2022/9/30 21:12
 */
@Controller
public class UserController {
}

~~~

创建接口UserService

~~~java
package com.liyouxiu.spring.service;

/**
 * @author liyouxiu
 * @date 2022/9/30 21:13
 */
public interface UserService {
}

~~~

创建业务层组件UserServiceImp

~~~java
package com.liyouxiu.spring.service.impl;

import com.liyouxiu.spring.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author liyouxiu
 * @date 2022/9/30 21:14
 */
@Service
public class UserServiceImpl implements UserService {

}

~~~

创建接口UserDao

~~~java
package com.liyouxiu.spring.dao;

/**
 * @author liyouxiu
 * @date 2022/9/30 21:17
 */
public interface UserDao {
}

~~~

创建持久层组件UserDaoImpl

~~~java
package com.liyouxiu.spring.dao.impl;

import com.liyouxiu.spring.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @author liyouxiu
 * @date 2022/9/30 21:18
 */
@Repository
public class UserDaoImpl implements UserDao {
}
~~~

**⑦扫描组件**

情况一：最基本的扫描方式

~~~xml
 <!--扫描组件    -->
    <context:component-scan
            base-package="com.liyouxiu.spring">

    </context:component-scan>
~~~

情况二：指定要排除的组件

~~~xml
    <!--
            context:exclude-filter：排除扫描
            type：设置排除扫描的方式
            type=“annotation|assignable”
            annotation：根据注解的类型进行排除，expression需要设置排除的注解的全类名
            assignable：根据类的类型进行排除，expression需要设置排除的类的全类名


    -->
    <!--扫描组件    -->
    <context:component-scan base-package="com.liyouxiu.spring" use-default-filters="false">
<!--        <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>-->
<!--        <context:exclude-filter type="assignable" expression="com.liyouxiu.spring.controller.UserController"/>-->
        
    </context:component-scan>
~~~

情况三：仅扫描指定组件

~~~xml
<!--
            context:include-filter:包含扫描
            注意：需要在context:component-scan标签中设置use-default-filters="false“
            use-default-filters="true“（默认） 所设置的包下所有的类都需要扫描，此时可以使用排除扫描
            use-default-filters="false" 所设置的包下所有的类都不需要扫描，此时可以使用包含扫描
    -->
    <!--扫描组件    -->
    <context:component-scan base-package="com.liyouxiu.spring" use-default-filters="false">
<!--        <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>-->
<!--        <context:exclude-filter type="assignable" expression="com.liyouxiu.spring.controller.UserController"/>-->
        <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
    </context:component-scan>
~~~

**⑧测试**

~~~java
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

~~~

**⑨组件所对应的bean的id**

在我们使用XML方式管理bean的时候，每个bean都有一个唯一标识，便于在其他地方引用。现在使用注解后，每个组件仍然应该有一个唯一标识。

> 默认情况
>
> 类名首字母小写就是bean的id。例如：UserController类对应的bean的id就是userController。
>
> 自定义bean的id可通过标识组件的注解的value属性设置自定义的bean的id
>
> @Service("userService")//默认为userServiceImpl public class UserServiceImpl implements
>
> UserService {}

### 2.3.2、实验二：基于注解的自动装配

**①场景模拟**

参考基于xml的自动装配

> 在UserController中声明UserService对象
>
> 在UserServiceImpl中声明UserDao对象

**②@Autowired注解**

在成员变量上直接标记@Autowired注解即可完成自动装配，不需要提供setXxx()方法。以后我们在项目中的正式用法就是这样。

~~~java
package com.liyouxiu.spring.controller;

import com.liyouxiu.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author liyouxiu
 * @date 2022/9/30 21:12
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    public void saveUser(){
        userService.saveUser();
    }

}
~~~

~~~java
package com.liyouxiu.spring.service.impl;

import com.liyouxiu.spring.dao.UserDao;
import com.liyouxiu.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liyouxiu
 * @date 2022/9/30 21:14
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}
~~~

**③@Autowired注解其他细节**

> @Autowired注解可以标记在构造器和set方法上

~~~java
package com.liyouxiu.spring.controller;

import com.liyouxiu.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author liyouxiu
 * @date 2022/9/30 21:12
 */
@Controller
public class UserController {

//    @Autowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void saveUser(){
        userService.saveUser();
    }

}
~~~

**④@Autowired工作流程**

![](https://pic1.imgdb.cn/item/633941ec16f2c2beb1e399ef.jpg)

* 首先根据所需要的组件类型到IOC容器中查找
  * 能够找到唯一的bean：直接执行装配
  * 如果完全找不到匹配这个类型的bean：装配失败
  * 和所需类型匹配的bean不止一个
    * 没有@Qualifier注解：根据@Autowired标记位置成员变量的变量名作为bean的id进匹配
      * 能够找到：执行装配
      * 找不到：装配失败
    * 使用@Qualifier注解：根据@Qualifier注解中指定的名称作为bean的id进行匹配
      * 能够找到：执行装配
      * 找不到：装配失败

> @Autowired中有属性required，默认值为true，因此在自动装配无法找到相应的bean时，会装配失败
>
> 可以将属性required的值设置为true，则表示能装就装，装不上就不装，此时自动装配的属性为默认值
>
> 但是实际开发时，基本上所有需要装配组件的地方都是必须装配的，用不上这个属性。

# 3、AOP

## 3.1、场景模拟

### 3.1.1、声明接口

声明计算器接口Calculator，包含加减乘除的抽象方法

~~~java
package com.liyouxiu.spring.proxy;

/**
 * @author liyouxiu
 * @date 2022/10/2 17:08
 */
public interface Calculator {
    int add(int i, int j);

    int sub(int i, int j);

    int mul(int i, int j);

    int div(int i, int j);
}
~~~

### 3.1.2、创建实现类

![](https://pic1.imgdb.cn/item/6339567416f2c2beb1fd6b7a.jpg)

~~~java
package com.liyouxiu.spring.proxy;

/**
 * @author liyouxiu
 * @date 2022/10/2 17:09
 */
public class CalculatorImpl implements Calculator{
    @Override
    public int add(int i, int j) {
        int result =i+j;
        System.out.println("方法内部，result："+result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result =i-j;
        System.out.println("方法内部，result："+result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result =i*j;
        System.out.println("方法内部，result："+result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result =i/j;
        System.out.println("方法内部，result："+result);
        return result;
    }
}
~~~

### 3.1.3、创建带日志功能的实现类

![](https://pic1.imgdb.cn/item/6339596216f2c2beb100a48c.jpg)

~~~java
package com.liyouxiu.spring.proxy;

/**
 * @author liyouxiu
 * @date 2022/10/2 17:09
 */
public class CalculatorImpl implements Calculator{
    @Override
    public int add(int i, int j) {
        System.out.println("日志，方法：add,参数："+i+"，"+j);
        int result =i+j;
        System.out.println("方法内部，result："+result);
        System.out.println("日志，方法：add,结果："+result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("日志，方法：sub,参数："+i+"，"+j);
        int result =i-j;
        System.out.println("方法内部，result："+result);
        System.out.println("日志，方法：sub,结果："+result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("日志，方法：mul,参数："+i+"，"+j);
        int result =i*j;
        System.out.println("方法内部，result："+result);
        System.out.println("日志，方法：mul,结果："+result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("日志，方法：div,参数："+i+"，"+j);
        int result =i/j;
        System.out.println("方法内部，result："+result);
        System.out.println("日志，方法：div,结果："+result);
        return result;
    }
}
~~~

### 3.1.4、提出问题

**①现有代码缺陷**

针对带日志功能的实现类，我们发现有如下缺陷：

* 对核心业务功能有干扰，导致程序员在开发核心业务功能时分散了精力

* 附加功能分散在各个业务功能方法中，不利于统一维护

**②解决思路**

解决这两个问题，核心就是：解耦。我们需要把附加功能从业务功能代码中抽取出来。

**③困难**

解决问题的困难：要抽取的代码在方法内部，靠以前把子类中的重复代码抽取到父类的方式没法解决。所以需要引入新的技术。

## 3.2、代理模式

### 3.2.1、概念

**①介绍**

二十三种设计模式中的一种，属于结构型模式。它的作用就是通过提供一个代理类，让我们在调用目标方法的时候，不再是直接对目标方法进行调用，而是通过代理类**间接**调用。让不属于目标方法核心逻辑的代码从目标方法中剥离出来——**解耦**。调用目标方法时先调用代理对象的方法，减少对目标方法的调用和打扰，同时让附加功能能够集中在一起也有利于统一维护。

![](https://pic1.imgdb.cn/item/63395a6616f2c2beb101a5b1.jpg)

使用代理后：

![](https://pic1.imgdb.cn/item/63395a8216f2c2beb101c125.jpg)

**②生活中的代理**

广告商找大明星拍广告需要经过经纪人

合作伙伴找大老板谈合作要约见面时间需要经过秘书

房产中介是买卖双方的代理

**③相关术语**

代理：将非核心逻辑剥离出来以后，封装这些非核心逻辑的类、对象、方法。

目标：被代理“套用”了非核心逻辑代码的类、对象、方法。

### 3.2.2、静态代理

创建静态代理类：

~~~java
package com.liyouxiu.spring.proxy;

/**
 * @author liyouxiu
 * @date 2022/10/3 14:37
 */
public class CalculatorStaticProxy implements Calculator{

    private CalculatorImpl calculatorImpl;

    public CalculatorImpl getCalculatorImpl() {
        return calculatorImpl;
    }

    public void setCalculatorImpl(CalculatorImpl calculatorImpl) {
        this.calculatorImpl = calculatorImpl;
    }

    @Override
    public int add(int i, int j) {
        System.out.println("日志，方法：add,参数："+i+"，"+j);
        int result = calculatorImpl.add(i, j);
        System.out.println("日志，方法：add,结果："+result);
        return result;
    }
//以下为省略书写 
    @Override
    public int sub(int i, int j) {
        return 0;
    }

    @Override
    public int mul(int i, int j) {
        return 0;
    }

    @Override
    public int div(int i, int j) {
        return 0;
    }
}
~~~

> 静态代理确实实现了解耦，但是由于代码都写死了，完全不具备任何的灵活性。就拿日志功能来说，将来其他地方也需要附加日志，那还得再声明更多个静态代理类，那就产生了大量重复的代码，日志功能还是分散的，没有统一管理。
>
> 提出进一步的需求：将日志功能集中到一个代理类中，将来有任何日志需求，都通过这一个代理类来实现。这就需要使用动态代理技术了。

### 3.2.3、动态代理

动态代理有两种

* JDK 动态代理 要求必须有接口，最终生成的代理类和目标类实现相同的接口

  在com.sun.proxy包下，类名为$proxy2

* cglib动态代理 最终生成的代理类会继承目标类并且和目标类在相同的包下

![](https://pic1.imgdb.cn/item/633a81d516f2c2beb1a8a2c8.jpg)

生产代理对象的工厂类：

~~~java
package com.liyouxiu.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author liyouxiu
 * @date 2022/10/3 14:50
 */
public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     *
     * @ClassLoader loader:指定加载动态生成的代理类的类加载器
     * Class<?>[] interfaces：获取目标对象所实现的接口的class对象的数组
     * InvocationHandler h：设置代理类中的抽象方法如何重写
     */

    public Object getProxy(){
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                try {
                    System.out.println("日志，方法："+method.getName()+",参数："+ Arrays.toString(args));
                    /**
                     * proxy表示代理对象
                     * method表示要执行的方法
                     * args表示要执行的参数的列表
                     */
                    result = method.invoke(target, args);
                    System.out.println("日志，方法："+method.getName()+",结果："+ result);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("日志，方法："+method.getName()+",异常："+ e);
                } finally {
                    System.out.println("日志，方法："+method.getName()+",方法执行完毕：");
                }
                return result;
            }
        };
        return Proxy.newProxyInstance(classLoader,interfaces,h);
    }
}
~~~

测试

~~~java
import com.liyouxiu.spring.proxy.Calculator;
import com.liyouxiu.spring.proxy.CalculatorImpl;
import com.liyouxiu.spring.proxy.ProxyFactory;
import org.junit.Test;

/**
 * @author liyouxiu
 * @date 2022/10/3 14:32
 */
public class TestCalculator {

    @Test
    public void testCalculator(){
//        CalculatorImpl calculator = new CalculatorImpl();
//        calculator.add(1,2);
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator)proxyFactory.getProxy();
        proxy.add(1,2);

    }
}
~~~

## 3.3、AOP概念及相关术语

### 3.3.1、概述

AOP（Aspect Oriented Programming）是一种设计思想，是软件设计领域中的面向切面编程，它是面向对象编程的一种补充和完善，它以通过预编译方式和运行期动态代理方式实现在不修改源代码的情况下给程序动态统一添加额外功能的一种技术。

### 3.3.2、相关术语

**①横切关注点**

从每个方法中抽取出来的同一类非核心业务。在同一个项目中，我们可以使用多个横切关注点对相关方法进行多个不同方面的增强。

这个概念不是语法层面天然存在的，而是根据附加功能的逻辑上的需要：有十个附加功能，就有十个横切关注点。

![](https://pic1.imgdb.cn/item/633a861216f2c2beb1b022e6.jpg)

**②通知**

每一个横切关注点上要做的事情都需要写一个方法来实现，这样的方法就叫通知方法。

* 前置通知：在被代理的目标方法**前**执行

* 返回通知：在被代理的目标方法**成功结束**后执行（**寿终正寝**）

* 异常通知：在被代理的目标方法**异常结束**后执行（**死于非命**）

* 后置通知：在被代理的目标方法**最终结束**后执行（**盖棺定论**）

* 环绕通知：使用try...catch...finally结构围绕**整个**被代理的目标方法，包括上面四种通知对应的所有位置

![](https://pic1.imgdb.cn/item/633a864816f2c2beb1b08643.jpg)

**③切面**

封装通知方法的类。

![](https://pic1.imgdb.cn/item/633a866916f2c2beb1b0c002.jpg)

**④目标**

被代理的目标对象。

**⑤代理**

向目标对象应用通知之后创建的代理对象。

**⑥连接点**

这也是一个纯逻辑概念，不是语法定义的。

把方法排成一排，每一个横切位置看成x轴方向，把方法从上到下执行的顺序看成y轴，x轴和y轴的交叉点就是连接点。

![](https://pic1.imgdb.cn/item/633a86a916f2c2beb1b132ad.jpg)

**⑦切入点**

定位连接点的方式。

每个类的方法中都包含多个连接点，所以连接点是类中客观存在的事物（从逻辑上来说）。

如果把连接点看作数据库中的记录，那么切入点就是查询记录的 SQL 语句。

Spring 的 AOP 技术可以通过切入点定位到特定的连接点。

切点通过 org.springframework.aop.Pointcut 接口进行描述，它使用类和方法作为连接点的查询条件。

### 3.3.3、作用

简化代码：把方法中固定位置的重复的代码**抽取**出来，让被抽取的方法更专注于自己的核心功能，提高内聚性。

代码增强：把特定的功能封装到切面类中，看哪里有需要，就往上套，被**套用**了切面逻辑的方法就被切面给增强了。

## 3.4、基于注解的AOP

### 3.4.1、技术说明

![](https://pic1.imgdb.cn/item/633a8c9f16f2c2beb1bcf6cb.jpg)

动态代理（InvocationHandler）：JDK原生的实现方式，需要被代理的目标类必须实现接口。因

为这个技术要求**代理对象和目标对象实现同样的接口**（兄弟两个拜把子模式）。

* cglib：通过**继承被代理的目标类**（认干爹模式）实现代理，所以不需要目标类实现接口。

* AspectJ：本质上是静态代理，**将代理逻辑**“织入”**被代理的目标类编译得到的字节码文件**，所以最终效果是动态的。weaver就是织入器。Spring只是借用了AspectJ中的注解。

### 3.4.2、准备工作

**①添加依赖**

在IOC所需依赖基础上再加入下面依赖即可

~~~xml
<!-- spring-aspects会帮我们传递过来aspectjweaver -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-aspects</artifactId>
    <version>5.3.1</version>
</dependency>
~~~

**②准备被代理的目标资源**

接口：

~~~java
package com.liyouxiu.spring.aop.annotation;

/**
 * @author liyouxiu
 * @date 2022/10/2 17:08
 */
public interface Calculator {
    int add(int i, int j);

    int sub(int i, int j);

    int mul(int i, int j);

    int div(int i, int j);
}
~~~

实现类：

~~~java
package com.liyouxiu.spring.aop.annotation;

/**
 * @author liyouxiu
 * @date 2022/10/2 17:09
 */
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int i, int j) {
        int result = i + j;
        System.out.println("方法内部，result：" + result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i - j;
        System.out.println("方法内部，result：" + result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = i * j;
        System.out.println("方法内部，result：" + result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i / j;
        System.out.println("方法内部，result：" + result);
        return result;
    }
}
~~~

### 3.4.3、创建切面类并配置

~~~java
package com.liyouxiu.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author liyouxiu
 * @date 2022/10/4 14:24
 * 1.在切面中，需要通过指定的注解将方法标识为通知方法
 * @Before ：前置通知，在目标方法执行之前执行
 * @After ：后置通知 ，在目标对象的finally子句中执行的
 * @AfterReturning ：返回通知，在目标对象方法返回值之后执行
 *@AfterThrowing ：异常通知，在目标对象方法的catch子句中执行
 *
 *
 * 2.切入点表达式：设置在标识通知的注解的value属性中
 * execution(public int com.liyouxiu.spring.aop.annotation.CalculatorImpl.add(int,int)
 * execution(* com.liyouxiu.spring.aop.annotation.*.*(..)
 * 第一个*表示任意的访问修饰符和返回值类型
 * 第二个*表示类中的任意方法
 * ..表示任意的参数列表
 * 类的地方也可以使用*，表示包下所有的类
 *
 * 3.获取连接点的信息
 * 在通知方法的参数位置设置JoinPoint类型的参数，就可以获取连接点所对应的方法的信息
 * //获取连接点所对应的签名信息
 * Signature signature = joinPoint.getSignature();
 * //获取连接点所对应的方法参数
 * Object[] args = joinPoint.getArgs();
 *
 * 4.重用切入点表达式
 * @Pointcut 声明一个公共的切入点表达式
 * @Pointcut("execution(* com.liyouxiu.spring.aop.annotation.*.*(..))")
 * public void pointCut(){}
 * 使用方式@After("pointCut()")
 *
 */
@Component //注解保证这个切面类能够放入IOC容器
@Aspect //将当前组件标识为切面
public class LoggerAspect {

    //公共切入点表达式（切入点表达式重用）
    @Pointcut("execution(* com.liyouxiu.spring.aop.annotation.*.*(..))")
    public void pointCut(){}

    //前置通知 标准写法 @Before("execution(方法返回值 具体位置下的某个方法)")
//    @Before("execution(public int com.liyouxiu.spring.aop.annotation.CalculatorImpl.add(int,int))")
    @Before("execution(* com.liyouxiu.spring.aop.annotation.*.*(..))")
    public void beforeAdviceMethod(JoinPoint joinPoint) {
        //获取连接点所对应的签名信息
        Signature signature = joinPoint.getSignature();
        //获取连接点所对应的方法参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect,方法："+signature.getName()+"，参数："+Arrays.toString(args));
    }

    @After("pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect ，方法："+signature.getName()+"，执行完毕");
    }

    //在返回通知中要获取目标对象方法的返回值，只需要通过@AfterReturning注解的returning属性就可以将
    //通知方法的某个参数指定为接受目标对象方法的返回值的参数
    @AfterReturning(value = "pointCut()",returning = "result")
    public void AfterReturningAdviceMethod(JoinPoint joinPoint,Object result){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect，方法："+signature.getName()+",结果："+result);
    }

    //在异常通知中要获取目标对象方法的返回值，只需要通过@AfterThrowing注解的throwing属性就可以将
    //异常方法的某个参数指定为接受目标对象方法的返回值的参数
    @AfterThrowing(value = "pointCut()",throwing = "e")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint,Exception e){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法："+signature.getName()+"，异常："+e);
    }

}

~~~

在Spring的配置文件中配置：

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/aop https://www.springframework.org/schema/aop/spring-aop.xsd">

<!--
    AOP的注意事项
    切面类和目标类都需要交给IOC容器管理
    切面类必须通过@aspect注解标识为一个切面
    在spring中的配置文件中设置 <aop:aspectj-autoproxy />开启基于注解的AOP
-->
    <context:component-scan base-package="com.liyouxiu.spring.aop.annotation" ></context:component-scan>

    <!-- 开启基于注解的AOP   -->
    <aop:aspectj-autoproxy />
</beans>
~~~

### 3.4.4、各种通知

* 前置通知：使用@Before注解标识，在被代理的目标方法**前**执行

* 返回通知：使用@AfterReturning注解标识，在被代理的目标方法**成功结束**后执行（**寿终正寝**）

* 异常通知：使用@AfterThrowing注解标识，在被代理的目标方法**异常结束**后执行（**死于非命**）

* 后置通知：使用@After注解标识，在被代理的目标方法**最终结束**后执行（**盖棺定论**）

* 环绕通知：使用@Around注解标识，使用try...catch...finally结构围绕**整个**被代理的目标方法，包括上面四种通知对应的所有位置

> 各种通知的执行顺序：
>
> * Spring版本5.3.x以前：
>   * 前置通知
>   * 目标操作
>   * 后置通知
>   * 返回通知或异常通知
> * Spring版本5.3.x以后：
>   * 前置通知
>   * 目标操作
>   * 返回通知或异常通知
>   * 后置通知

### 3.4.5、切入点表达式语法

**①作用**

![](https://pic1.imgdb.cn/item/633bdad516f2c2beb1ae12aa.jpg)

**②语法细节**

* 用*号代替“权限修饰符”和“返回值”部分表示“权限修饰符”和“返回值”不限

* 在包名的部分，一个“*”号只能代表包的层次结构中的一层，表示这一层是任意的。
  * 例如：*.Hello匹配com.Hello，不匹配com.atguigu.Hello

* 在包名的部分，使用“*..”表示包名任意、包的层次深度任意

* 在类名的部分，类名部分整体用*号代替，表示类名任意

* 在类名的部分，可以使用*号代替类名的一部分
  * 例如：*Service匹配所有名称以Service结尾的类或接口

* 在方法名部分，可以使用*号表示方法名任意

* 在方法名部分，可以使用*号代替方法名的一部分
  * 例如：*Operation匹配所有方法名以Operation结尾的方法

* 在方法参数列表部分，使用(..)表示参数列表任意

* 在方法参数列表部分，使用(int,..)表示参数列表以一个int类型的参数开头

* 在方法参数列表部分，基本数据类型和对应的包装类型是不一样的
  * 切入点表达式中使用 int 和实际方法中 Integer 是不匹配的

* 在方法返回值部分，如果想要明确指定一个返回值类型，那么必须同时写明权限修饰符
  * 例如：execution(public int *..*Service.*(.., int)) 正确*
  * 例如：execution(* int *..*Service.*(.., int)) 错误

![](https://pic1.imgdb.cn/item/633bdb5f16f2c2beb1af1bee.jpg)

### 3.4.6、重用切入点表达式

**①声明**

~~~java
//公共切入点表达式（切入点表达式重用）
    @Pointcut("execution(* com.liyouxiu.spring.aop.annotation.*.*(..))")
    public void pointCut(){}
~~~

**②在同一个切面中使用**

~~~java
@After("pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect ，方法："+signature.getName()+"，执行完毕");
    }
~~~

**③在不同切面中使用**

~~~java
@After("com.liyouxiu.spring.aop.annotation.LoggerAspect.pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect ，方法："+signature.getName()+"，执行完毕");
    }
~~~

### 3.4.7、获取通知的相关信息

**①获取连接点信息**

获取连接点信息可以在通知方法的参数位置设置JoinPoint类型的形参

~~~java
@Before("execution(* com.liyouxiu.spring.aop.annotation.*.*(..))")
    public void beforeAdviceMethod(JoinPoint joinPoint) {
        //获取连接点所对应的签名信息
        Signature signature = joinPoint.getSignature();
        //获取连接点所对应的方法参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect,方法："+signature.getName()+"，参数："+Arrays.toString(args));
    }
~~~

**②获取目标方法的返回值**

@AfterReturning中的属性returning，用来将通知方法的某个形参，接收目标方法的返回值

~~~java
//在返回通知中要获取目标对象方法的返回值，只需要通过@AfterReturning注解的returning属性就可以将
    //通知方法的某个参数指定为接受目标对象方法的返回值的参数
    @AfterReturning(value = "pointCut()",returning = "result")
    public void AfterReturningAdviceMethod(JoinPoint joinPoint,Object result){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect，方法："+signature.getName()+",结果："+result);
    }
~~~

**③获取目标方法的异常**

@AfterThrowing中的属性throwing，用来将通知方法的某个形参，接收目标方法的异常

~~~java
//在异常通知中要获取目标对象方法的返回值，只需要通过@AfterThrowing注解的throwing属性就可以将
    //异常方法的某个参数指定为接受目标对象方法的返回值的参数
    @AfterThrowing(value = "pointCut()",throwing = "e")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint,Exception e){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法："+signature.getName()+"，异常："+e);
    }
~~~

### 3.4.8、环绕通知

~~~java
 @Around("pointCut()")
    //环绕通知的方法的返回值一定要和目标对象的返回值一致
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint){
        Object result=null;
        try {
            System.out.println("环绕通知---->前置通知");
            //表示目标对象方法的执行
            result = joinPoint.proceed();
            System.out.println("环绕通知---->返回通知");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知---->异常通知");
        }finally{
            System.out.println("环绕通知---->后置通知");
        }
        return result;
    }
~~~

### 3.4.9、切面的优先级

相同目标方法上同时存在多个切面时，切面的优先级控制切面的**内外嵌套**顺序。

* 优先级高的切面：外面

* 优先级低的切面：里面

使用@Order注解可以控制切面的优先级：

* @Order(较小的数)：优先级高

* @Order(较大的数)：优先级低

![](https://pic1.imgdb.cn/item/633bfc4816f2c2beb1e88dd4.jpg)

## 3.5、基于XML的AOP（了解）

### 3.5.1、准备工作

参考基于注解的AOP环境

### 3.5.2、实现

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/aop https://www.springframework.org/schema/aop/spring-aop.xsd">

    <context:component-scan base-package="com.liyouxiu.spring.aop.xml"></context:component-scan>

    <!--设置公共的切入点表达式 -->

    <aop:config>
        <aop:pointcut id="pointCut" expression="execution(* com.liyouxiu.spring.aop.annotation.CalculatorImpl.*(..))"/>
        <!--  将IOC容器中的某个bean设置为切面 -->
        <aop:aspect ref="loggerAspect">
            <aop:before method="beforeAdviceMethod" pointcut-ref="pointCut"></aop:before>
            <aop:after method="afterAdviceMethod" pointcut-ref="pointCut"></aop:after>
            <aop:after-returning method="AfterReturningAdviceMethod" returning="result" pointcut-ref="pointCut"></aop:after-returning>
            <aop:after-throwing method="afterThrowingAdviceMethod" throwing="e" pointcut-ref="pointCut"></aop:after-throwing>
            <aop:around method="aroundAdviceMethod" pointcut-ref="pointCut"></aop:around>
        </aop:aspect>
        <aop:aspect ref="validateAspect">
            <aop:before method="BeforeMethod" pointcut-ref="pointCut"></aop:before>
        </aop:aspect>
    </aop:config>



</beans>
~~~

# 4、声明式事务

## 4.1、JdbcTemplate

### 4.1.1、简介

Spring 框架对 JDBC 进行封装，使用 JdbcTemplate 方便实现对数据库操作

### 4.1.2、准备工作

~~~xml
 <dependencies>
        <!-- 基于Maven依赖传递性，导入spring-context依赖即可导入当前所需所有jar包 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>5.3.1</version>
        </dependency>
        <!-- Spring 持久化层支持jar包 -->
        <!-- Spring 在执行持久化层操作、与持久化层技术进行整合过程中，需要使用orm、jdbc、tx三个 jar包 -->
        <!-- 导入 orm 包就可以通过 Maven 的依赖传递性把其他两个也导入 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-orm</artifactId>
            <version>5.3.1</version>
        </dependency>
        <!-- Spring 测试相关 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <version>5.3.1</version>
        </dependency>
        <!-- junit测试 -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
        <!-- MySQL驱动 -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.18</version>
        </dependency>
        <!-- 数据源 -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.0.31</version>
        </dependency>
    </dependencies>
~~~

**②创建jdbc.properties**

~~~properties
jdbc.user=root
jdbc.password=root
jdbc.url=jdbc:mysql://localhost:3306/ssm
jdbc.driver=com.mysql.jdbc.Driver
~~~

**③配置Spring的配置文件**

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">

    <!--引入jdbc.properties -->
    <context:property-placeholder location="classpath:jdbc.properties"></context:property-placeholder>
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="driverClassName" value="${jdbc.driver}"></property>
        <property name="url" value="${jdbc.url}"></property>
        <property name="username" value="${jdbc.user}"></property>
        <property name="password" value="${jdbc.password}"></property>
    </bean>
    <bean  class="org.springframework.jdbc.core.JdbcTemplate">
        <property name="dataSource" ref="dataSource">

        </property>
    </bean>

</beans>
~~~

### 4.1.3、测试

**①在测试类装配** **JdbcTemplate**

~~~java
package com.liyouxiu.spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author liyouxiu
 * @date 2022/10/5 9:59
 */
//指定当前测试类在spring的测试环境中执行，此时就可以通过注入的方式直接来获取IOC容器中的bean
@RunWith(SpringJUnit4ClassRunner.class)
//设置Spring的测试环境的配置文件
@ContextConfiguration("classpath:spring-JdbcTemplate.xml")
public class JDBCTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    

}
~~~

**②测试增删改功能**

~~~java
@Test
    public void testInsert(){
        String sql="insert into t_user values(null,?,?,?,?,?)";
        jdbcTemplate.update(sql,"root","123",23,"女","123@qq.com");

    }
~~~

**③查询一条数据为实体类对象**

~~~java
 @Test
    public void testGetUserById(){
        String sql="select * from t_user where id = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 1);
        System.out.println(user);
    }
~~~

**④查询多条数据为一个list集合**

~~~java
 @Test
    public void testGetAllUser(){
        String sql="select * from t_user";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        users.forEach(System.out::println);
    }
~~~

**⑤查询单行单列的值**

~~~java
 @Test
    public void testGetCount(){
        String sql = "select count(*) from t_user";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }
~~~

## 4.2、声明式事务概念

### 4.2.1、编程式事务

事务功能的相关操作全部通过自己编写代码来实现：

~~~java
Connection conn = ...; 

try {
    
    // 开启事务：关闭事务的自动提交 
    conn.setAutoCommit(false); 
    // 核心操作 
    
    // 提交事务 
    conn.commit(); 
}catch(Exception e){ 
    
    // 回滚事务 
    conn.rollBack(); 

}finally{
    
    // 释放数据库连接 conn.close(); 
}
~~~

编程式的实现方式存在缺陷：

* 细节没有被屏蔽：具体操作过程中，所有细节都需要程序员自己来完成，比较繁琐。

* 代码复用性不高：如果没有有效抽取出来，每次实现功能都需要自己编写代码，代码就没有得到复用。   

### 4.2.2、声明式事务

既然事务控制的代码有规律可循，代码的结构基本是确定的，所以框架就可以将固定模式的代码抽取出来，进行相关的封装。

封装起来后，我们只需要在配置文件中进行简单的配置即可完成操作。

* 好处1：提高开发效率

* 好处2：消除了冗余的代码

* 好处3：框架会综合考虑相关领域中在实际开发环境下有可能遇到的各种问题，进行了健壮性、性 能等各个方面的优化

所以，我们可以总结下面两个概念：

* **编程式**：**自己写代码**实现功能 

* **声明式**：通过**配置**让**框架**实现功能

## 4.3、基于注解的声明式事务

### 4.3.1、准备工作

**①加入依赖**

~~~xml
 <dependencies>
        <!-- 基于Maven依赖传递性，导入spring-context依赖即可导入当前所需所有jar包 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>5.3.1</version>
        </dependency>
        <!-- Spring 持久化层支持jar包 -->
        <!-- Spring 在执行持久化层操作、与持久化层技术进行整合过程中，需要使用orm、jdbc、tx三个 jar包 -->
        <!-- 导入 orm 包就可以通过 Maven 的依赖传递性把其他两个也导入 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-orm</artifactId>
            <version>5.3.1</version>
        </dependency>
        <!-- Spring 测试相关 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <version>5.3.1</version>
        </dependency>
        <!-- junit测试 -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
        <!-- MySQL驱动 -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.18</version>
        </dependency>
        <!-- 数据源 -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.0.31</version>
        </dependency>
    </dependencies>
~~~

**②创建jdbc.properties**

~~~properties
jdbc.user=root
jdbc.password=root
jdbc.url=jdbc:mysql://localhost:3306/ssm
jdbc.driver=com.mysql.jdbc.Driver
~~~

**③配置Spring的配置文件**

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">

    <!--引入jdbc.properties -->
    <context:property-placeholder location="classpath:jdbc.properties"></context:property-placeholder>
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="driverClassName" value="${jdbc.driver}"></property>
        <property name="url" value="${jdbc.url}"></property>
        <property name="username" value="${jdbc.user}"></property>
        <property name="password" value="${jdbc.password}"></property>
    </bean>
    <bean  class="org.springframework.jdbc.core.JdbcTemplate">
        <property name="dataSource" ref="dataSource">

        </property>
    </bean>

</beans>
~~~

**④创建表**

~~~sql
CREATE TABLE `t_book` ( `book_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键', `book_name` varchar(20) DEFAULT NULL COMMENT '图书名称', `price` int(11) DEFAULT NULL COMMENT '价格', `stock` int(10) unsigned DEFAULT NULL COMMENT '库存（无符号）', PRIMARY KEY (`book_id`) ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8; insert into `t_book`(`book_id`,`book_name`,`price`,`stock`) values (1,'斗破苍 穹',80,100),(2,'斗罗大陆',50,100); CREATE TABLE `t_user` ( `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键', `username` varchar(20) DEFAULT NULL COMMENT '用户名', `balance` int(10) unsigned DEFAULT NULL COMMENT '余额（无符号）', PRIMARY KEY (`user_id`) ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8; insert into `t_user`(`user_id`,`username`,`balance`) values (1,'admin',50);
~~~

**⑤创建组件**

创建BookController：

~~~java
package com.liyouxiu.spring.controller;

import com.liyouxiu.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author liyouxiu
 * @date 2022/10/5 14:07
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    public void buyBook(Integer userID,Integer bookID){
        bookService.buyBook(userID, bookID);
    }
}

~~~

创建接口BookService：

~~~java
package com.liyouxiu.spring.service;


/**
 * @author liyouxiu
 * @date 2022/10/5 14:08
 */

public interface BookService {
    void buyBook(Integer userID, Integer bookID);
}

~~~

创建实现类BookServiceImpl： 

~~~java
package com.liyouxiu.spring.service.impl;

import com.liyouxiu.spring.dao.BookDao;
import com.liyouxiu.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liyouxiu
 * @date 2022/10/5 14:08
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    @Transactional
    public void buyBook(Integer userID, Integer bookID) {
        //查询图书的价格
        Integer price=bookDao.getPriceByBookId(bookID);
        //更新图书的库存
        bookDao.updateStock(bookID);
        //更新用户的余额
        bookDao.updateBalance(userID,price);
    }
}

~~~

创建接口BookDao：

~~~java
package com.liyouxiu.spring.dao;

/**
 * @author liyouxiu
 * @date 2022/10/5 14:09
 */
public interface BookDao {
    /**
     * 根据图书的ID查询图书的价格
     * @param bookID
     * @return
     */
    Integer getPriceByBookId(Integer bookID);

    /**
     * 更新图书的库存
     * @param bookID
     */
    void updateStock(Integer bookID);

    /**
     * 更新用户的余额
     * @param userID
     * @param bookID
     */
    void updateBalance(Integer userID, Integer price);
}

~~~

创建实现类BookDaoImpl：

~~~java

~~~

```java
package com.liyouxiu.spring.dao.impl;

import com.liyouxiu.spring.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author liyouxiu
 * @date 2022/10/5 14:10
 */
@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer getPriceByBookId(Integer bookID) {
        String sql="select price from t_book where book_id = ?";
        return jdbcTemplate.queryForObject(sql,Integer.class,bookID);
    }

    @Override
    public void updateStock(Integer bookID) {
        String sql="update t_book set stock = stock - 1 where book_id = ?";
        jdbcTemplate.update(sql,bookID);
    }

    @Override
    public void updateBalance(Integer userID, Integer price) {
        String sql = "update t_user set balance = balance - ? where user_id = ?";
        jdbcTemplate.update(sql,price,userID);
    }
}
```

### 4.3.2、测试无事务情况

**①创建测试类**

~~~java
package com.liyouxiu.spring.test;

import com.liyouxiu.spring.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author liyouxiu
 * @date 2022/10/5 14:32
 *
 * 声明式事务的配置步骤：
 * 1.在spring的配置文件中配置事务管理器
 * 2.开启事务的注解驱动
 * 在需要被事务管理的方法上或者类上，添加@Transactional注解，该方法就会被事务管理
 * @Transactional注解标识位置
 * 1.标识在方法上
 * 2.标识在类上，则类中的所有方法都会被事务管理
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx-annotation.xml")
public class TXByAnnotationTest {
    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook(){
        bookController.buyBook(1,1);
    }

}
~~~

**②模拟场景**

用户购买图书，先查询图书的价格，再更新图书的库存和用户的余额

假设用户id为1的用户，购买id为1的图书

用户余额为50，而图书价格为80

购买图书之后，用户的余额为-30，数据库中余额字段设置了无符号，因此无法将-30插入到余额字段

此时执行sql语句会抛出SQLException

**③观察结果**

因为没有添加事务，图书的库存更新了，但是用户的余额没有更新

显然这样的结果是错误的，购买图书是一个完整的功能，更新库存和更新余额要么都成功要么都失败

### 4.3.3、加入事务

**①添加事务配置**

在Spring的配置文件中添加配置：

~~~xml
<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <property name="dataSource" ref="dataSource"></property>
</bean>
<!--开启事务的注解驱动 
通过注解@Transactional所标识的方法或标识的类中所有的方法，都会被事务管理器管理事务
 -->
<!-- transaction-manager属性的默认值是transactionManager，如果事务管理器bean的id正好就 是这个默认值，则可以省略这个属性 -->
<tx:annotation-driven transaction-manager="transactionManager" />
~~~

注意：导入的名称空间需要 **tx** **结尾**的那个。

**②添加事务注解**

因为service层表示业务逻辑层，一个方法表示一个完成的功能，因此处理事务一般在service层处理

在BookServiceImpl的buybook()添加注解@Transactional

**③观察结果**

由于使用了Spring的声明式事务，更新库存和更新余额都没有执行

### 4.3.4、@Transactional注解标识的位置

* @Transactional标识在方法上，咋只会影响该方法

* @Transactional标识的类上，咋会影响类中所有的方法

### 4.3.5、事务属性：只读

**①介绍**

对一个查询操作来说，如果我们把它设置成只读，就能够明确告诉数据库，这个操作不涉及写操作。这样数据库就能够针对查询操作来进行优化。

**②使用方式**

~~~java
 @Transactional(readOnly = true)
    public void buyBook(Integer userID, Integer bookID) {
        //查询图书的价格
        Integer price=bookDao.getPriceByBookId(bookID);
        //更新图书的库存
        bookDao.updateStock(bookID);
        //更新用户的余额
        bookDao.updateBalance(userID,price);
    }
~~~

**③注意**

对增删改操作设置只读会抛出下面异常：

Caused by: java.sql.SQLException: Connection is read-only. Queries leading to data modificationare not allowed

### 4.3.6、事务属性：超时

**①介绍**

事务在执行过程中，有可能因为遇到某些问题，导致程序卡住，从而长时间占用数据库资源。而长时间占用资源，大概率是因为程序运行出现了问题（可能是Java程序或MySQL数据库或网络连接等等）。此时这个很可能出问题的程序应该被回滚，撤销它已做的操作，事务结束，把资源让出来，让其他正常程序可以执行。

概括来说就是一句话：超时回滚，释放资源。

**②使用方式**

~~~java
@Transactional(
//            readOnly = true
            timeout = 3
    )
    public void buyBook(Integer userID, Integer bookID) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //查询图书的价格
        Integer price = bookDao.getPriceByBookId(bookID);
        //更新图书的库存
        bookDao.updateStock(bookID);
        //更新用户的余额
        bookDao.updateBalance(userID, price);
    }
~~~

**③观察结果**

执行过程中抛出异常：

org.springframework.transaction.**TransactionTimedOutException**: Transaction timed out:deadline was Fri Jun 04 16:25:39 CST 2022

### 4.3.7、事务属性：回滚策略

**①介绍**

声明式事务默认只针对运行时异常回滚，编译时异常不回滚。

可以通过@Transactional中相关属性设置回滚策略

* rollbackFor属性：需要设置一个Class类型的对象

* rollbackForClassName属性：需要设置一个字符串类型的全类名

* noRollbackFor属性：需要设置一个Class类型的对象 

* rollbackFor属性：需要设置一个字符串类型的全类名

**②使用方式**

~~~java
@Transactional(
//            readOnly = true
//            timeout = 3
//              noRollbackFor = ArithmeticException.class
            noRollbackForClassName = "java.lang.ArithmeticException"
    )
    public void buyBook(Integer userID, Integer bookID) {
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //查询图书的价格
        Integer price = bookDao.getPriceByBookId(bookID);
        //更新图书的库存
        bookDao.updateStock(bookID);
        //更新用户的余额
        bookDao.updateBalance(userID, price);
        System.out.println(1/0);
    }
~~~

**③观察结果**

虽然购买图书功能中出现了数学运算异常（ArithmeticException），但是我们设置的回滚策略是，当出现ArithmeticException不发生回滚，因此购买图书的操作正常执行

### 4.3.8、事务属性：事务隔离级别

**①介绍**

数据库系统必须具有隔离并发运行各个事务的能力，使它们不会相互影响，避免各种并发问题。一个事务与其他事务隔离的程度称为隔离级别。SQL标准中规定了多种事务隔离级别，不同隔离级别对应不同的干扰程度，隔离级别越高，数据一致性就越好，但并发性越弱。

隔离级别一共有四种：

* 读未提交：READ UNCOMMITTED

允许Transaction01读取Transaction02未提交的修改。

* 读已提交：READ COMMITTED、 

要求Transaction01只能读取Transaction02已提交的修改。

* 可重复读：REPEATABLE READ 

确保Transaction01可以多次从一个字段中读取到相同的值，即Transaction01执行期间禁止其它事务对这个字段进行更新。

* 串行化：SERIALIZABLE

确保Transaction01可以多次从一个表中读取到相同的行，在Transaction01执行期间，禁止其它事务对这个表进行添加、更新、删除操作。可以避免任何并发问题，但性能十分低下。

各个隔离级别解决并发问题的能力见下表：

|   **隔离级别**   | **脏读** | **不可重复读** | **幻读** |
| :--------------: | :------: | :------------: | :------: |
| READ UNCOMMITTED |    有    |       有       |    有    |
|  READ COMMITTED  |    无    |       有       |    有    |
| REPEATABLE READ  |    无    |       无       |    有    |
|   SERIALIZABLE   |    无    |       无       |    无    |

各种数据库产品对事务隔离级别的支持程度：

|   **隔离级别**   | **Oracle** | **MySQL** |
| :--------------: | :--------: | :-------: |
| READ UNCOMMITTED |     ×      |     √     |
|  READ COMMITTED  |  √(默认)   |     √     |
| REPEATABLE READ  |     √×     |  √(默认)  |
|   SERIALIZABLE   |     √      |     √     |

**②使用方式**

### 4.3.9、事务属性：事务传播行为

**①介绍**

当事务方法被另一个事务方法调用时，必须指定事务应该如何传播。例如：方法可能继续在现有事务中运行，也可能开启一个新事务，并在自己的事务中运行。

**②测试**

创建接口CheckoutService：

~~~java
package com.liyouxiu.spring.service;

/**
 * @author liyouxiu
 * @date 2022/10/6 9:47
 */
public interface CheckoutService {
    /**
     * 结账
     * @param userID
     * @param bookIDs
     */
    void checkout(Integer userID, Integer[] bookIDs);
}

~~~



创建实现类CheckoutServiceImpl：

~~~java
package com.liyouxiu.spring.service.impl;

import com.liyouxiu.spring.service.BookService;
import com.liyouxiu.spring.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liyouxiu
 * @date 2022/10/6 9:47
 */
@Service
public class CheckoutServiceImpl implements CheckoutService {
    @Autowired
    private BookService bookService;
    @Override
    @Transactional
    public void checkout(Integer userID, Integer[] bookIDs) {
        for (Integer bookID : bookIDs) {
            bookService.buyBook(userID,bookID);
        }
    }
}

~~~



在数据库中将用户的余额修改为100元

**③观察结果**

可以通过@Transactional中的propagation属性设置事务传播行为

修改BookServiceImpl中buyBook()上，注解@Transactional的propagation属性

@Transactional(propagation = Propagation.REQUIRED)，默认情况，表示如果当前线程上有已经开启的事务可用，那么就在这个事务中运行。经过观察，购买图书的方法buyBook()在checkout()中被调用，checkout()上有事务注解，因此在此事务中执行。所购买的两本图书的价格为80和50，而用户的余额为100，因此在购买第二本图书时余额不足失败，导致整个checkout()回滚，即只要有一本书买不了，就都买不了

@Transactional(propagation = Propagation.REQUIRES_NEW)，表示不管当前线程上是否有已经开启的事务，都要开启新事务。同样的场景，每次购买图书都是在buyBook()的事务中执行，因此第一本图书购买成功，事务结束，第二本图书购买失败，只在第二次的buyBook()中回滚，购买第一本图书不受影响，即能买几本就买几本

## 4.4、基于XML的声明式事务

### 4.3.1、场景模拟

参考基于注解的声明式事务

### 4.3.2、修改Spring配置文件

将Spring配置文件中去掉tx:annotation-driven 标签，并添加配置：

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context" xmlns:tx="http://www.springframework.org/schema/tx"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd http://www.springframework.org/schema/aop https://www.springframework.org/schema/aop/spring-aop.xsd">

    <!--扫描组件    -->
    <context:component-scan base-package="com.liyouxiu.spring"></context:component-scan>
    <!--引入jdbc.properties -->
    <context:property-placeholder location="classpath:jdbc.properties"></context:property-placeholder>
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="driverClassName" value="${jdbc.driver}"></property>
        <property name="url" value="${jdbc.url}"></property>
        <property name="username" value="${jdbc.user}"></property>
        <property name="password" value="${jdbc.password}"></property>
    </bean>
    <bean  class="org.springframework.jdbc.core.JdbcTemplate">
        <property name="dataSource" ref="dataSource"></property>
    </bean>

    <!--配置事务管理器    -->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"></property>
    </bean>

    <!--配置事务通知 -->
    <tx:advice id="tx" transaction-manager="transactionManager">
        <tx:attributes>
            <tx:method name="buyBook" />
        </tx:attributes>
    </tx:advice>

    <aop:config>
        <aop:advisor advice-ref="tx" pointcut="execution(* com.liyouxiu.spring.service.impl.*.*(..))"></aop:advisor>
    </aop:config>
</beans>
~~~

老师给的配置文件

~~~xml
<aop:config>
    <!-- 配置事务通知和切入点表达式 -->
    <aop:advisor advice-ref="txAdvice" pointcut="execution(* com.atguigu.spring.tx.xml.service.impl.*.*(..))"></aop:advisor>
</aop:config>
<!-- tx:advice标签：配置事务通知 -->
<!-- id属性：给事务通知标签设置唯一标识，便于引用 -->
<!-- transaction-manager属性：关联事务管理器 -->
<tx:advice id="txAdvice" transaction-manager="transactionManager">
    <tx:attributes>
        <!-- tx:method标签：配置具体的事务方法 -->
        <!-- name属性：指定方法名，可以使用星号代表多个字符 -->
        <tx:method name="get*" read-only="true"/>
        <tx:method name="query*" read-only="true"/>
        <tx:method name="find*" read-only="true"/>
        <!-- read-only属性：设置只读属性 -->
        <!-- rollback-for属性：设置回滚的异常 -->
        <!-- no-rollback-for属性：设置不回滚的异常 -->
        <!-- isolation属性：设置事务的隔离级别 -->
        <!-- timeout属性：设置事务的超时属性 -->
        <!-- propagation属性：设置事务的传播行为 -->
        <tx:method name="save*" read-only="false" rollback- for="java.lang.Exception" propagation="REQUIRES_NEW"/>
        <tx:method name="update*" read-only="false" rollback- for="java.lang.Exception" propagation="REQUIRES_NEW"/>
        <tx:method name="delete*" read-only="false" rollback- for="java.lang.Exception" propagation="REQUIRES_NEW"/>
    </tx:attributes>
</tx:advice>
~~~

注意：基于xml实现的声明式事务，必须引入aspectJ的依赖

> ~~~xml
> <dependency>
>     <groupId>org.springframework</groupId>
>     <artifactId>spring-aspects</artifactId>
>     <version>5.3.1</version>
> </dependency>
> ~~~