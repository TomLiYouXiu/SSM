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