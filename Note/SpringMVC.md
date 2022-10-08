# 1、SpringMVC简介

## 1.1、什么是MVC

MVC是一种软件架构的思想，将软件按照模型、视图、控制器来划分

M：Model，模型层，指工程中的JavaBean，作用是处理数据

JavaBean分为两类：

* 一类称为实体类Bean：专门存储业务数据的，如 Student、User 等

* 一类称为业务处理 Bean：指 Service 或 Dao 对象，专门用于处理业务逻辑和数据访问。

V：View，视图层，指工程中的html或jsp等页面，作用是与用户进行交互，展示数据

C：Controller，控制层，指工程中的servlet，作用是接收请求和响应浏览器

MVC的工作流程： 用户通过视图层发送请求到服务器，在服务器中请求被Controller接收，Controller调用相应的Model层处理请求，处理完毕将结果返回到Controller，Controller再根据请求处理的结果找到相应的View视图，渲染数据后最终响应给浏览器

## 1.2、什么是SpringMVC

SpringMVC是Spring的一个后续产品，是Spring的一个子项目

SpringMVC 是 Spring 为表述层开发提供的一整套完备的解决方案。在表述层框架历经 Strust、WebWork、Strust2 等诸多产品的历代更迭之后，目前业界普遍选择了 SpringMVC 作为 Java EE 项目表述层开发的**首选方案**。

注：三层架构分为表述层（或表示层）、业务逻辑层、数据访问层，表述层表示前台页面和后台

servlet

## 1.3、SpringMVC的特点

* **Spring** **家族原生产品**，与 IOC 容器等基础设施无缝对接

* **基于原生的**Servlet**，通过了功能强大的**前端控制器**DispatcherServlet**，对请求和响应进行统一处理

* 表述层各细分领域需要解决的问题**全方位覆盖**，提供**全面解决方案**

* **代码清新简洁**，大幅度提升开发效率

* 内部组件化程度高，可插拔式组件**即插即用**，想要什么功能配置相应组件即可

* **性能卓著**，尤其适合现代大型、超大型互联网项目要求

# 2、入门案例

## 2.1、开发环境

IDE：idea 2019.2

构建工具：maven3.5.4

服务器：tomcat8.5

Spring版本：5.3.1

## 2.2、创建maven工程

**①添加web模块**

**②打包方式：war**

**③引入依赖**

~~~xml
<dependencies>
    <!-- SpringMVC -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>5.3.1</version>
    </dependency>
    <!-- 日志 -->
    <dependency>
        <groupId>ch.qos.logback</groupId>
        <artifactId>logback-classic</artifactId>
        <version>1.2.3</version>
    </dependency>
    <!-- ServletAPI -->
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>javax.servlet-api</artifactId>
        <version>3.1.0</version>
        <scope>provided</scope>
    </dependency>
    <!-- Spring5和Thymeleaf整合包 -->
    <dependency>
        <groupId>org.thymeleaf</groupId>
        <artifactId>thymeleaf-spring5</artifactId>
        <version>3.0.12.RELEASE</version>
    </dependency>
</dependencies>
~~~

注：由于 Maven 的传递性，我们不必将所有需要的包全部配置依赖，而是配置最顶端的依赖，其他靠传递性导入。

![](https://pic1.imgdb.cn/item/633e41cf16f2c2beb13c4b10.jpg)

## 2.3、配置web.xml

注册SpringMVC的前端控制器DispatcherServlet

**①默认配置方式**

此配置作用下，SpringMVC的配置文件默认位于WEB-INF下，默认名称为<servlet-name>-servlet.xml，例如，以下配置所对应SpringMVC的配置文件位于WEB-INF下，文件名为springMVC-servlet.xml

自己写的

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">
    <!--配置SpringMVC的前端控制器DispatcherServlet-->
    <servlet>
        <servlet-name>SpringMVC</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    </servlet>
    <!--
        <url-pattern>中/和/*的区别
         /:匹配浏览器向服务器发送的所有请求（不包括JSP）
         /*:匹配浏览器向服务器发送的所有请求（包括JSP）
    -->
    <servlet-mapping>
        <servlet-name>SpringMVC</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
</web-app>
~~~

老师写的

~~~xml
<!-- 配置SpringMVC的前端控制器，对浏览器发送的请求统一进行处理 -->
<servlet>
    <servlet-name>springMVC</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet
    </servlet- class>
</servlet>
<servlet-mapping>
    <servlet-name>springMVC</servlet-name>
    <!--设置springMVC的核心控制器所能处理的请求的请求路径 /*所匹配的请求可以是/login或.html或.js或.css方式的请求路径 但是/不能匹配.jsp请求路径的请求 -->
    <url-pattern>/</url-pattern>
</servlet-mapping>
~~~

**②扩展配置方式**

可通过init-param标签设置SpringMVC配置文件的位置和名称，通过load-on-startup标签设置SpringMVC前端控制器DispatcherServlet的初始化时间

~~~xml
<!-- 配置SpringMVC的前端控制器，对浏览器发送的请求统一进行处理 -->
<servlet>
    <servlet-name>springMVC</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet
    </servlet- class>
    <!-- 通过初始化参数指定SpringMVC配置文件的位置和名称 -->
    <init-param>
        <!-- contextConfigLocation为固定值 -->
        <param-name>contextConfigLocation</param-name>
        <!-- 使用classpath:表示从类路径查找配置文件，例如maven工程中的 src/main/resources -->
        <param-value>classpath:springMVC.xml</param-value>
    </init-param>
    <!--作为框架的核心组件，在启动过程中有大量的初始化操作要做 而这些操作放在第一次请求时才执行会严重影响访问速度 因此需要通过此标签将启动控制DispatcherServlet的初始化时间提前到服务器启动时 -->
    <load-on-startup>1</load-on-startup>
</servlet>
<servlet-mapping>
    <servlet-name>springMVC</servlet-name>
    <!--设置springMVC的核心控制器所能处理的请求的请求路径 /所匹配的请求可以是/login或.html或.js或.css方式的请求路径 但是/不能匹配.jsp请求路径的请求 -->
    <url-pattern>/</url-pattern>
</servlet-mapping>
~~~

> 注：
>
> <url-pattern>标签中使用/和/*的区别：
>
> /所匹配的请求可以是/login或.html或.js或.css方式的请求路径，但是/不能匹配.jsp请求路径的请求
>
> 因此就可以避免在访问jsp页面时，该请求被DispatcherServlet处理，从而找不到相应的页面
>
> /*则能够匹配所有请求，例如在使用过滤器时，若需要对所有请求进行过滤，就需要使用 `/*`的写法

## 2.4、创建请求控制器

由于前端控制器对浏览器发送的请求进行了统一的处理，但是具体的请求有不同的处理过程，因此需要创建处理具体请求的类，即请求控制器

请求控制器中每一个处理请求的方法成为控制器方法

因为SpringMVC的控制器由一个POJO（普通的Java类）担任，因此需要通过@Controller注解将其标识为一个控制层组件，交给Spring的IoC容器管理，此时SpringMVC才能够识别控制器的存在

~~~java
package com.liyouxiu.controller;

import org.springframework.stereotype.Controller;

/**
 * @author liyouxiu
 * @date 2022/10/7 10:54
 */
@Controller
public class HelloController {
}
~~~

## 2.5、创建SpringMVC的配置文件

~~~xml
<!-- 配置Thymeleaf视图解析器 -->
<bean id="viewResolver" class="org.thymeleaf.spring5.view.ThymeleafViewResolver">
    <property name="order" value="1"/>
    <property name="characterEncoding" value="UTF-8"/>
    <property name="templateEngine">
        <bean class="org.thymeleaf.spring5.SpringTemplateEngine">
            <property name="templateResolver">
                <bean class="org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver">
                    <!-- 视图前缀 -->
                    <property name="prefix" value="/WEB-INF/templates/"/>
                    <!-- 视图后缀 -->
                    <property name="suffix" value=".html"/>
                    <property name="templateMode" value="HTML5"/>
                    <property name="characterEncoding" value="UTF-8" />
                </bean>
            </property>
        </bean>
    </property>
</bean>
<!--
处理静态资源，例如html、js、css、jpg 若只设置该标签，则只能访问静态资源，
其他请求则无法访问此时必须设置<mvc:annotation-driven/>
解决问题 
-->
<mvc:default-servlet-handler/>
<!-- 开启mvc注解驱动 -->
<mvc:annotation-driven>
    <mvc:message-converters>
        <!-- 处理响应中文内容乱码 -->
        <bean class="org.springframework.http.converter.StringHttpMessageConverter">
            <property name="defaultCharset" value="UTF-8" />
            <property name="supportedMediaTypes">
                <list>
                    <value>text/html</value>
                    <value>application/json</value>
                </list>
            </property>
        </bean>
    </mvc:message-converters>
</mvc:annotation-driven>
~~~

## 2.6、测试HelloWorld

**①实现对首页的访问**

在请求控制器中创建处理请求的方法

~~~java
package com.liyouxiu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liyouxiu
 * @date 2022/10/7 10:54
 */
@Controller
public class HelloController {
    //@RequestMapping 注解：处理请求和控制器之间的映射关系
    //@RequestMapping注解的value属性可以通过请求地址匹配请求，/ 表示的当前工程的上下文路径
    @RequestMapping("/")
    public String protal(){
        //将逻辑视图返回
        return "index";
    }
}    
~~~

**②通过超链接跳转到指定页面**

在主页index.html中设置超链接

~~~html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://wwww.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
</head>
<body>
  <h1>index.html</h1>
  <a th:href="@{/hello}">测试SpringMVC</a></br>
  <a href="/hello">测试绝对路径</a>
</body>
</html>
~~~

在请求控制器中创建处理请求的方法

~~~java
 @RequestMapping("/hello")
    public String hello(){
        return "success";
    }
~~~

## 2.7、总结

浏览器发送请求，若请求地址符合前端控制器的url-pattern，该请求就会被前端控制器DispatcherServlet处理。前端控制器会读取SpringMVC的核心配置文件，通过扫描组件找到控制器，将请求地址和控制器中@RequestMapping注解的value属性值进行匹配，若匹配成功，该注解所标识的控制器方法就是处理请求的方法。处理请求的方法需要返回一个字符串类型的视图名称，该视图名称会被视图解析器解析，加上前缀和后缀组成视图的路径，通过Thymeleaf对视图进行渲染，最终转发到视图所对应页面

# 3、@RequestMapping注解

## 3.1、@RequestMapping注解的功能

从注解名称上我们可以看到，@RequestMapping注解的作用就是将请求和处理请求的控制器方法关联起来，建立映射关系。

SpringMVC 接收到指定的请求，就会来找到在映射关系中对应的控制器方法来处理这个请求。

## 3.2、@RequestMapping注解的位置

@RequestMapping标识一个类：设置映射请求的请求路径的初始信息

@RequestMapping标识一个方法：设置映射请求请求路径的具体信息

~~~java
package com.liyouxiu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liyouxiu
 * @date 2022/10/7 16:07
 *
 *
 * @RequestMapping标识一个类：设置映射请求的请求路径的初始信息
 * @RequestMapping标识一个方法：设置映射请求请求路径的具体信息
 *
 */
@Controller
@RequestMapping("/test")
public class TestRequestMappingController {

    //此时控制器的方法所匹配的请求路径为/test/hello
    @RequestMapping("/hello")
    public String hello(){
        return "success";
    }
}
~~~

## 3.3、@RequestMapping注解的value属性

@RequestMapping注解的value属性通过请求的请求地址匹配请求映射

@RequestMapping注解的value属性是一个字符串类型的数组，表示该请求映射能够匹配多个请求地址所对应的请求

@RequestMapping注解的value属性必须设置，至少通过请求地址匹配请求映射

~~~html
<a th:href="@{/hello}">测试@RequestMapping标识的位置</a><br>
<a th:href="@{/abc}">测试@RequestMapping注解的value属性</a>
~~~

~~~java
//此时控制器的方法所匹配的请求路径为/test/hello
    @RequestMapping(
            value = {"/hello","/abc"}
    )
    public String hello(){
        return "success";
    }
~~~

## 3.4、@RequestMapping注解的method属性

@RequestMapping注解的method属性通过请求的请求方式（get或post）匹配请求映射

@RequestMapping注解的method属性是一个RequestMethod类型的数组，表示该请求映射能够匹配多**种请求方式的请求**

若当前请求的请求地址满足请求映射的value属性，但是请求方式不满足method属性，则浏览器报错

405：Request method 'POST' not supported

~~~html
<form th:action="@{/hello}" method="post">
    <input type="submit" value="测试@RequestMapping注解的method属性">

~~~

~~~java
@RequestMapping(
            value = {"/hello","/abc"},
            method = RequestMethod.POST
    )
    public String hello(){
        return "success";
    }
~~~

> 注：
>
> 1、对于处理指定请求方式的控制器方法，SpringMVC中提供了@RequestMapping的派生注解
>
> 处理get请求的映射-->@GetMapping
>
> 处理post请求的映射-->@PostMapping
>
> 处理put请求的映射-->@PutMapping
>
> 处理delete请求的映射-->@DeleteMapping
>
> 2、常用的请求方式有get，post，put，delete
>
> 但是目前浏览器只支持get和post，若在form表单提交时，为method设置了其他请求方式的字符
>
> 串（put或delete），则按照默认的请求方式get处理
>
> 若要发送put和delete请求，则需要通过spring提供的过滤器HiddenHttpMethodFilter，在
>
> RESTful部分会讲到

## 3.5、@RequestMapping注解的params属性（了解）

@RequestMapping注解的params属性通过请求的请求参数匹配请求映射

@RequestMapping注解的params属性是一个字符串类型的数组，可以通过四种表达式设置请求参数

和请求映射的匹配关系

"param"：要求请求映射所匹配的请求必须携带param请求参数

"!param"：要求请求映射所匹配的请求必须不能携带param请求参数

"param=value"：要求请求映射所匹配的请求必须携带param请求参数且param=value

"param!=value"：要求请求映射所匹配的请求必须携带param请求参数但是param!=value

~~~html
<!doctype html>
<html lang="ch" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
</head>
<body>
<h1>index.html</h1>
<a th:href="@{/hello}">测试@RequestMapping标识的位置</a><br>
<a th:href="@{/abc}">测试@RequestMapping注解的value属性</a>
<form th:action="@{/hello}" method="post">
    <input type="submit" value="测试@RequestMapping注解的method属性">
</form>
<a th:href="@{/hello?username=admin}">测试@RequestMapping注解的params属性</a><br>
<a th:href="@{/hello(username='admin')}">测试@RequestMapping注解的params属性</a>
</body>
</html>
~~~

~~~java
package com.liyouxiu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author liyouxiu
 * @date 2022/10/7 16:07
 *
 *1.
 * @RequestMapping标识一个类：设置映射请求的请求路径的初始信息
 * @RequestMapping标识一个方法：设置映射请求请求路径的具体信息
 *
 * 2.
 *  @RequestMapping 注解value属性
 *  作用：通过请求的请求路径匹配请求
 *  value属性是数组类型，即当前浏览器所发送的请求路径匹配的value属性中的任何一个值
 *  则当前请求就会被注解所标识的方法进行处理
 *
 *  3.
 *  @RequestMapping 注解method属性
 *  作用：通过请求的请求方式匹配请求
 *  method属性是RequestMethod类型的数组，即当前浏览器所发送的请求方式的method属性中的任何一个请求方式
 *  则当前请求就会被注解所标识的方法进行处理
 *  若浏览器所发送的请求请求路径匹配，但是请求方式不匹配则报错如下
 *  405：Request method 'POST' not supported
 *
 *  4.
 *  在@RequestMapping的基础上，结合请求方式的一些派生注解
 *  @GetMapping,@PostMapping,@DeleteMapping,@PutMapping
 *
 *  5.
 *  @RequestMapping注解的params属性
 *  作用：通过请求的参数匹配请求，即浏览器发送的请求的请求参数必须满足params属性的设置
 *  params可以使用四种表达式
 *  “params”：表示当前所匹配请求参数中必须携带param参数
 *  “!params”：表示当前所匹配请求参数中一定不能携带param参数
 *  “params=value”：表示当前所匹配请求参数中必须携带param参数且值必须为value
 *  “params!=value”：表示当前所匹配请求参数中可以不携带param参数，但是若携带值不能是value
 */
@Controller
//@RequestMapping("/test")
public class TestRequestMappingController {

    //此时控制器的方法所匹配的请求路径为/test/hello
    @RequestMapping(
            value = {"/hello","/abc"},
            method = {RequestMethod.POST,RequestMethod.GET},
            params = {"username","!password","age=20"}
    )
    public String hello(){
        return "success";
    }
}
~~~

> 注：
>
> 若当前请求满足@RequestMapping注解的value和method属性，但是不满足params属性，此时
>
> 页面回报错400：Parameter conditions "username, password!=123456" not met for actual
>
> request parameters: username={admin}, password={123456}

## 3.6、@RequestMapping注解的headers属性（了解）

@RequestMapping注解的headers属性通过请求的请求头信息匹配请求映射

@RequestMapping注解的headers属性是一个字符串类型的数组，可以通过四种表达式设置请求头信息和请求映射的匹配关系

~~~java
package com.liyouxiu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author liyouxiu
 * @date 2022/10/7 16:07
 *
 *1.
 * @RequestMapping标识一个类：设置映射请求的请求路径的初始信息
 * @RequestMapping标识一个方法：设置映射请求请求路径的具体信息
 *
 * 2.
 *  @RequestMapping 注解value属性
 *  作用：通过请求的请求路径匹配请求
 *  value属性是数组类型，即当前浏览器所发送的请求路径匹配的value属性中的任何一个值
 *  则当前请求就会被注解所标识的方法进行处理
 *
 *  3.
 *  @RequestMapping 注解method属性
 *  作用：通过请求的请求方式匹配请求
 *  method属性是RequestMethod类型的数组，即当前浏览器所发送的请求方式的method属性中的任何一个请求方式
 *  则当前请求就会被注解所标识的方法进行处理
 *  若浏览器所发送的请求请求路径匹配，但是请求方式不匹配则报错如下
 *  405：Request method 'POST' not supported
 *
 *  4.
 *  在@RequestMapping的基础上，结合请求方式的一些派生注解
 *  @GetMapping,@PostMapping,@DeleteMapping,@PutMapping
 *
 *  5.
 *  @RequestMapping注解的params属性
 *  作用：通过请求的参数匹配请求，即浏览器发送的请求的请求参数必须满足params属性的设置
 *  params可以使用四种表达式
 *  “params”：表示当前所匹配请求参数中必须携带param参数
 *  “!params”：表示当前所匹配请求参数中一定不能携带param参数
 *  “params=value”：表示当前所匹配请求参数中必须携带param参数且值必须为value
 *  “params!=value”：表示当前所匹配请求参数中可以不携带param参数，但是若携带值不能是value
 */
@Controller
//@RequestMapping("/test")
public class TestRequestMappingController {

    //此时控制器的方法所匹配的请求路径为/test/hello
    @RequestMapping(
            value = {"/hello","/abc"},
//            method = {RequestMethod.POST,RequestMethod.GET},
//            params = {"username","!password","age=20"}
            headers = {"referer"}
    )
    public String hello(){
        return "success";
    }
}
~~~

"header"：要求请求映射所匹配的请求必须携带header请求头信息

"!header"：要求请求映射所匹配的请求必须不能携带header请求头信息

"header=value"：要求请求映射所匹配的请求必须携带header请求头信息且header=value

"header!=value"：要求请求映射所匹配的请求必须携带header请求头信息且header!=value

若当前请求满足@RequestMapping注解的value和method属性，但是不满足headers属性，此时页面

显示404错误，即资源未找到

## 3.7、SpringMVC支持ant风格的路径

？：表示任意的单个字符

*：表示任意的0个或多个字符

**：表示任意层数的任意目录

注意：在使用**时，只能使用`/**/`xxx的方式

~~~java
 @RequestMapping("/a?a/test/ant")
    public String testAnt(){
        return "success";
    }
~~~

~~~html
<a th:href="@{/aaa/test/ant}">测试@RequestMapping注解支持ant风格注解</a><br>
~~~

## 3.8、SpringMVC支持路径中的占位符（重点）

原始方式：/deleteUser?id=1

rest方式：/user/delete/1

SpringMVC路径中的占位符常用于RESTful风格中，当请求路径中将某些数据通过路径的方式传输到服务器中，就可以在相应的@RequestMapping注解的value属性中通过占位符{xxx}表示传输的数据，在通过@PathVariable注解，将占位符所表示的数据赋值给控制器方法的形参

