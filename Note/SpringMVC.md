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

~~~java
@RequestMapping("/test/rest/{username}/{id}")
    public String testRest(@PathVariable("id") Integer id,@PathVariable("username") String username){
        System.out.println("id:"+id+",username:"+username);
        return "success";
    }
~~~

~~~html
<a th:href="@{/test/rest/admin/1}">测试@RequestMapping注解value属性的占位符</a><br>
~~~

# 4、SpringMVC获取请求参数

## 4.1、通过ServletAPI获取

将HttpServletRequest作为控制器方法的形参，此时HttpServletRequest类型的参数表示封装了当前请求的请求报文的对象

~~~java
package com.liyouxiu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liyouxiu
 * @date 2022/10/8 17:16
 */
@Controller
public class TestParamController {

    @RequestMapping("/param/servletAPI")
    public String getParamByServletAPI(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:"+username+",password:"+password);
        return "success";
    }
}

~~~

~~~html
<form th:action="@{/param/servletAPI}" method="post">
    用户名：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
   <input type="submit" value="登录"><br>
</form>
~~~

## 4.2、通过控制器方法的形参获取请求参数

在控制器方法的形参位置，设置和请求参数同名的形参，当浏览器发送请求，匹配到请求映射时，在DispatcherServlet中就会将请求参数赋值给相应的形参

~~~java
package com.liyouxiu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liyouxiu
 * @date 2022/10/8 17:16
 *
 * 获取请求参数的方式
 * 1.通过servletAPI的方式获取
 * 只需要在控制器方法的形参位置设置HttpServletRequest类型的形参
 * 就可以在控制器方法中使用request对象获取请求参数
 *
 * 2.通过控制器方法的形参获取
 * 只需要在控制器方法的形参位置，设置一个形参，形参的名字和请求参数的名字一直即可
 */
@Controller
public class TestParamController {

    @RequestMapping("/param/servletAPI")
    public String getParamByServletAPI(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:"+username+",password:"+password);
        return "success";
    }

    @RequestMapping("/param")
    public String getParam(String username,String password){
        System.out.println("username:"+username+",password:"+password);
        return "success";
    }
}

~~~

~~~html
<form th:action="@{/param}" method="post">
    用户名：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    <input type="submit" value="登录"><br>
</form>
~~~

> 注：
>
> 若请求所传输的请求参数中有多个同名的请求参数，此时可以在控制器方法的形参中设置字符串
>
> 数组或者字符串类型的形参接收此请求参数
>
> 若使用字符串数组类型的形参，此参数的数组中包含了每一个数据
>
> 若使用字符串类型的形参，此参数的值为每个数据中间使用逗号拼接的结果

## 4.3、@RequestParam

@RequestParam是将请求参数和控制器方法的形参创建映射关系

@RequestParam注解一共有三个属性：

* value：指定为形参赋值的请求参数的参数名

* required：设置是否必须传输此请求参数，默认值为true

若设置为true时，则当前请求必须传输value所指定的请求参数，若没有传输该请求参数，且没有设置

defaultValue属性，则页面报错400：Required String parameter 'xxx' is not present；若设置为

false，则当前请求不是必须传输value所指定的请求参数，若没有传输，则注解所标识的形参的值为

null

* defaultValue：不管required属性值为true或false，当value所指定的请求参数没有传输或传输的值

为""时，则使用默认值为形参赋值

~~~java
@RequestMapping("/param")
    public String getParam(
            @RequestParam(value = "userName",required = false,defaultValue = "hello") String username,
                           String password
    ){
        System.out.println("username:"+username+",password:"+password);
        return "success";
    }
~~~

~~~html
<form th:action="@{/param}" method="post">
    用户名：<input type="text" name="userName"><br>
    密码：<input type="password" name="password"><br>
    <input type="submit" value="登录"><br>
</form>
~~~

## 4.4、@RequestHeader

@RequestHeader是将请求头信息和控制器方法的形参创建映射关系

@RequestHeader注解一共有三个属性：value、required、defaultValue，用法同@RequestParam

~~~java
 @RequestMapping("/param")
    public String getParam(
            @RequestParam(value = "userName",required = false,defaultValue = "hello") String username,
                           String password,
            @RequestHeader("referer") String referer
    ){
        System.out.println("username:"+username+",password:"+password+referer);
        return "success";
    }
~~~

## 4.5、@CookieValue

@CookieValue是将cookie数据和控制器方法的形参创建映射关系

@CookieValue注解一共有三个属性：value、required、defaultValue，用法同@RequestParam

~~~java
@RequestMapping("/param")
    public String getParam(
            @RequestParam(value = "userName",required = false,defaultValue = "hello") String username,
                           String password,
            @RequestHeader("referer") String referer,
            //获取cookie
            @CookieValue("JSESSIONID") String jsessionId
    ){
        System.out.println("jsessionId"+jsessionId);
        System.out.println("username:"+username+",password:"+password+referer);
        return "success";
    }
~~~

## 4.6、通过POJO获取请求参数

可以在控制器方法的形参位置设置一个实体类类型的形参，此时若浏览器传输的请求参数的参数名和实体类中的属性名一致，那么请求参数就会为此属性赋值

**pojo**

~~~java
package com.liyouxiu.pojo;

/**
 * @author liyouxiu
 * @date 2022/10/8 20:02
 */
public class User {

    private Integer id;

    private String username;

    private String password;

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}

~~~

~~~java
@RequestMapping("/param/pojo")
    public String getParamByPojo(User user){
        System.out.println(user);
        return "success";
    }
~~~

## 4.7、解决获取请求参数的乱码问题

解决获取请求参数的乱码问题，可以使用SpringMVC提供的编码过滤器CharacterEncodingFilter，但是必须在web.xml中进行注册

~~~xml
<!--配置springMVC的编码过滤器-->
<filter>
    <filter-name>CharacterEncodingFilter</filter-name>
    <filter-class>
		org.springframework.web.filter.CharacterEncodingFilter
    </filter-class>
    <init-param>
        <param-name>encoding</param-name>
        <param-value>UTF-8</param-value>
    </init-param>
    <init-param>
        <param-name>forceEncoding</param-name>
        <param-value>true</param-value>
    </init-param>
</filter>
<filter-mapping>
    <filter-name>CharacterEncodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
~~~

> 注：
>
> SpringMVC中处理编码的过滤器一定要配置到其他过滤器之前，否则无效

# 5、域对象共享数据

## 5.1、使用ServletAPI向request域对象共享数据

~~~java
@RequestMapping("/TestServletAPI")
    public String TestServletAPI(HttpServletRequest request){
        request.setAttribute("testScope","hello servletAPI");
        return "success";
    }
~~~

## 5.2、使用ModelAndView向request域对象共享数据

~~~java
package com.liyouxiu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author liyouxiu
 * @date 2022/10/9 20:18
 *
 * 向域对象共享数据
 * 1.通过ModelAndView向请求域共享数据
 * 使用ModelAndView时，可以使用其Model功能向请求域共享数据
 * 使用View功能设置逻辑视图，但是控制器方法一定要将ModelAndView作为方法的返回值
 */
@Controller
public class TestScopeController {

    @RequestMapping("/test/mav")
    public ModelAndView testMav(){
        /**
         * ModelAndView包含Model和View的功能
         * Model：向请求域中共享数据
         * View：设置逻辑视图实现页面跳转
         */
        ModelAndView mav = new ModelAndView();
        //想请求域中共享数据
        mav.addObject("testRequestScope","Hello,ModelAndView");
        //设置逻辑视图
        mav.setViewName("success");
        return mav;
    }
}

~~~

## 5.3、使用Model向request域对象共享数据

~~~java
@RequestMapping("/test/model")
    public String testModel(Model model){
        model.addAttribute("testRequestScope","Hello,Model");
        return "success";
    }
~~~

## 5.4、使用map向request域对象共享数据

~~~java
@RequestMapping("/test/map")
    public String testMap(Map<String,Object> map){
        map.put("testRequestScope","Hello,map");
        return "success";
    }
~~~

## 5.5、使用ModelMap向request域对象共享数据

~~~java
@RequestMapping("/test/modelmap")
    public String testModelMap(ModelMap modelmap){
        modelmap.addAttribute("testRequestScope","Hello,ModelMap");
        return "success";
    }
~~~

## 5.6、Model、ModelMap、Map的关系

Model、ModelMap、Map类型的参数其实本质上都是 BindingAwareModelMap 类型的

~~~java
public interface Model{} 
public class ModelMap extends LinkedHashMap<String, Object> {} 
public class ExtendedModelMap extends ModelMap implements Model {} 
public class BindingAwareModelMap extends ExtendedModelMap {}
~~~

## 5.7、向session域共享数据

~~~java
@RequestMapping("/test/session")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope","Hello,Session");
        return "success";
    }
~~~

## 5.8、向application域共享数据

~~~java
@RequestMapping("/test/application")
    public String testApplication(HttpSession session){
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("testApplicationScope","Hello,Application");
        return "success";
    }
~~~

# 6、SpringMVC的视图

SpringMVC中的视图是View接口，视图的作用渲染数据，将模型Model中的数据展示给用户

SpringMVC视图的种类很多，默认有转发视图和重定向视图

当工程引入jstl的依赖，转发视图会自动转换为JstlView

若使用的视图技术为Thymeleaf，在SpringMVC的配置文件中配置了Thymeleaf的视图解析器，由此视图解析器解析之后所得到的是ThymeleafView

## 6.1、ThymeleafView

当控制器方法中所设置的视图名称没有任何前缀时，此时的视图名称会被SpringMVC配置文件中所配置的视图解析器解析，视图名称拼接视图前缀和视图

后缀所得到的最终路径，会通过转发的方式实现跳转

~~~java
@RequestMapping("/test/view/thymeleaf")
    public String testThymeleafView(){
        return "success";
    }
~~~

![](https://pic1.imgdb.cn/item/6342d2c316f2c2beb1209276.jpg)

## 6.2、转发视图

SpringMVC中默认的转发视图是InternalResourceView

SpringMVC中创建转发视图的情况：

当控制器方法中所设置的视图名称以"forward:"为前缀时，创建InternalResourceView视图，此时的视图名称不会被SpringMVC配置文件中所配置的视图解析器解析，而是会将前缀"forward:"去掉，剩余部分作为最终路径通过转发的方式实现跳转

例如"forward:/"，"forward:/employee"

~~~java
@RequestMapping("/test/view/forward")
    public String testInternalResourceView(){

        return "forward:/test/model";
    }
~~~

![](https://pic1.imgdb.cn/item/6342d2f616f2c2beb121126d.jpg)

## 6.3、重定向视图

SpringMVC中默认的重定向视图是RedirectView

当控制器方法中所设置的视图名称以"redirect:"为前缀时，创建RedirectView视图，此时的视图名称不会被SpringMVC配置文件中所配置的视图解析器解析，而是会将前缀"redirect:"去掉，剩余部分作为最终路径通过重定向的方式实现跳转

例如"redirect:/"，"redirect:/employee"

~~~java
 @RequestMapping("/test/view/redirect")
    public String testRedirectView(){

        return "redirect:/test/model";
    }
~~~

> 注：
>
> 重定向视图在解析时，会先将redirect:前缀去掉，然后会判断剩余部分是否以/开头，若是则会自动拼接上下文路径

## 6.4、视图控制器view-controller

当控制器方法中，仅仅用来实现页面跳转，即只需要设置视图名称时，可以将处理器方法使用view

controller标签进行表示

~~~xml
	<!--开启MVC注解驱动-->
    <mvc:annotation-driven />
    <!--视图控制器：为当前的请求直接设置视图名称，实现页面跳转-->
    <mvc:view-controller path="/" view-name="index" ></mvc:view-controller>
~~~

> 注：
>
> 当SpringMVC中设置任何一个view-controller时，其他控制器中的请求映射将全部失效，此时需
>
> 要在SpringMVC的核心配置文件中设置开启mvc注解驱动的标签：
>
> <mvc:annotation-driven />

# 7、RESTful

## 7.1、RESTful简介

REST：**Re**presentational **S**tate **T**ransfer，表现层资源状态转移。

**①资源**

资源是一种看待服务器的方式，即，将服务器看作是由很多离散的资源组成。每个资源是服务器上一个可命名的抽象概念。因为资源是一个抽象的概念，所以它不仅仅能代表服务器文件系统中的一个文件、数据库中的一张表等等具体的东西，可以将资源设计的要多抽象有多抽象，只要想象力允许而且客户端应用开发者能够理解。与面向对象设计类似，资源是以名词为核心来组织的，首先关注的是名词。一个资源可以由一个或多个URI来标识。URI既是资源的名称，也是资源在Web上的地址。对某个资源感兴趣的客户端应用，可以通过资源的URI与其进行交互。

**②资源的表述**

资源的表述是一段对于资源在某个特定时刻的状态的描述。可以在客户端-服务器端之间转移（交换）。资源的表述可以有多种格式，例如HTML/XML/JSON/纯文本/图片/视频/音频等等。资源的表述格式可以通过协商机制来确定。请求-响应方向的表述通常使用不同的格式。

**③状态转移**

状态转移说的是：在客户端和服务器端之间转移（transfer）代表资源状态的表述。通过转移和操作资源的表述，来间接实现操作资源的目的。

## 7.2、RESTful的实现

具体说，就是 HTTP 协议里面，四个表示操作方式的动词：GET、POST、PUT、DELETE。

它们分别对应四种基本操作：GET 用来获取资源，POST 用来新建资源，PUT 用来更新资源，DELETE用来删除资源。

REST 风格提倡 URL 地址使用统一的风格设计，从前到后各个单词使用斜杠分开，不使用问号键值对方式携带请求参数，而是将要发送给服务器的数据作为 URL 地址的一部分，以保证整体风格的一致性。

| **操作** |   **传统方式**   |        REST风格         |
| :------: | :--------------: | :---------------------: |
| 查询操作 | getUserById?id=1 |  user/1-->get请求方式   |
| 保存操作 |     saveUser     |   user-->post请求方式   |
| 删除操作 | deleteUser?id=1  | user/1-->delete请求方式 |
| 更新操作 |    updateUser    |   user-->put请求方式    |

~~~java
package com.liyouxiu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author liyouxiu
 * @date 2022/10/10 15:37
 *
 * 查询所有的用户信息---->/user---->get
 * 根据ID查询用户信息---->/user/1---->get
 * 新增用户信息---->/user---->post
 * 修改用户信息---->/user---->put
 * 删除用户信息---->/user/1---->delete
 *
 */
@Controller
public class TestRestController {

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getAllUser(){
        System.out.println("查询所有的用户信息---->/user---->get");
        return "success";
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String getUserById(@PathVariable("id") String id){
        System.out.println("根据ID查询用户信息---->/user/"+id+"---->get");
        return "success";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String insertUser(){
        System.out.println("新增用户信息---->/user---->post");
        return "success";
    }

    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String updateUser(){
        System.out.println("修改用户信息---->/user---->put");
        return "success";
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") String id){
        System.out.println("删除用户信息---->/user/"+id+"---->delete");
        return "success";
    }

}
~~~

## 7.3、HiddenHttpMethodFilter

由于浏览器只支持发送get和post方式的请求，那么该如何发送put和delete请求呢？

SpringMVC 提供了 **HiddenHttpMethodFilter** 帮助我们**将** **POST** **请求转换为** **DELETE** **或** **PUT** **请求**

**HiddenHttpMethodFilter** 处理put和delete请求的条件：

a>当前请求的请求方式必须为post

b>当前请求必须传输请求参数_method

满足以上条件，**HiddenHttpMethodFilter** 过滤器就会将当前请求的请求方式转换为请求参数

_method的值，因此请求参数_method的值才是最终的请求方式

在web.xml中注册**HiddenHttpMethodFilter**

~~~xml
<filter>
    <filter-name>HiddenHttpMethodFilter</filter-name>
    <filter-class>org.springframework.web.filter.HiddenHttpMethodFilter
    </filter-class>
</filter>
<filter-mapping>
    <filter-name>HiddenHttpMethodFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
~~~

~~~html
<form th:action="@{/user}" method="post">
    <input type="hidden" name="_method" value="put">
    <input type="submit" value="修改用户信息">
</form>
<form th:action="@{/user/5}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="删除用户信息">
</form>
~~~

~~~java
@RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String updateUser(){
        System.out.println("修改用户信息---->/user---->put");
        return "success";
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") String id){
        System.out.println("删除用户信息---->/user/"+id+"---->delete");
        return "success";
    }
~~~



> 注：
>
> 目前为止，SpringMVC中提供了两个过滤器：CharacterEncodingFilter和HiddenHttpMethodFilter
>
> 在web.xml中注册时，必须先注册CharacterEncodingFilter，再注册HiddenHttpMethodFilter
>
> 原因：
>
> 在 CharacterEncodingFilter 中通过 request.setCharacterEncoding(encoding) 方法设置字符集的
>
> request.setCharacterEncoding(encoding) 方法要求前面不能有任何获取请求参数的操作
>
> 而 HiddenHttpMethodFilter 恰恰有一个获取请求方式的操作：
>
> ~~~java
> String paramValue = request.getParameter(this.methodParam);
> ~~~

# 8、RESTful案例

## 8.1、准备工作

和传统 CRUD 一样，实现对员工信息的增删改查。

搭建环境

准备实体类

~~~java
package com.liyouxiu.pojo;

/**
 * @author liyouxiu
 * @date 2022/10/11 12:22
 */
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    //1 male, 0 female
    private Integer gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Employee(Integer id, String lastName, String email, Integer gender) {
        super();
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
    }

    public Employee() {
    }
}
~~~

准备dao模拟数据

~~~	java
package com.liyouxiu.dao;

/**
 * @author liyouxiu
 * @date 2022/10/11 12:27
 */


import com.liyouxiu.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;

    static {
        employees = new HashMap<Integer, Employee>();
        employees.put(1001, new Employee(1001, "E-AA", "aa@163.com", 1));
        employees.put(1002, new Employee(1002, "E-BB", "bb@163.com", 1));
        employees.put(1003, new Employee(1003, "E-CC", "cc@163.com", 0));
        employees.put(1004, new Employee(1004, "E-DD", "dd@163.com", 0));
        employees.put(1005, new Employee(1005, "E-EE", "ee@163.com", 1));
    }

    private static Integer initId = 1006;

    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employees.put(employee.getId(), employee);
    }

    public Collection<Employee> getAll() {
        return employees.values();
    }

    public Employee get(Integer id) {
        return employees.get(id);
    }

    public void delete(Integer id) {
        employees.remove(id);
    }
}
~~~

## 8.2、功能清单

|      **功能**       | **URL** **地址** | **请求方式** |
| :-----------------: | :--------------: | :----------: |
|      访问首页√      |        /         |     GET      |
|    查询全部数据√    |    /employee     |     GET      |
|        删除√        |   /employee/2    |    DELETE    |
| 跳转到添加数据页面√ |      /toAdd      |     GET      |
|      执行保存√      |    /employee     |     POST     |
| 跳转到更新数据页面√ |   /employee/2    |     GET      |
|      执行更新√      |    /employee     |     PUT      |

## 8.3、具体功能：访问首页

**①配置view-controller**

~~~xml
<mvc:view-controller path="/" view-name="index"/>
~~~

**②创建页面**

~~~html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
  
  <head>
    <meta charset="UTF-8">
    <title>Title</title>
  </head>
  
  <body>
    <h1>首页</h1>
    <a th:href="@{/employee}">访问员工信息</a>
  </body>

</html>
~~~

## 8.4、具体功能：查询所有员工数据

注：为了能访问到默认的静态资源所以需要在spring的配置文件中添加以下配置

~~~xml
    <!--
        配置默认的servlet处理静态资源
        当前工程的web，xml配置的前端控制器DispatcherServlet的url-pattern是/
        tomcat的web.xml配置的DefaultServlet的url-pattern也是/
        此时，浏览器发送的请求会优先被DispatcherServlet进行处理，但是DispatcherServlet无法处理静态资源
        但是配置了default-servlet-handler，此时浏览器发送的请求都会被DefaultServlet处理
        配置了default-servlet-handler和<mvc:annotation-driven/>浏览器发送的请求会先被
        DispatcherServlet处理，处理不了的，无法处理才会交给DefaultServlet
    -->
    <mvc:default-servlet-handler/>

    <!--开启mvc的注解驱动-->
    <mvc:annotation-driven/>
~~~

**①控制器方法**

~~~java
@RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getAllEmployees(Model model){
        //获取所有的员工信息
        Collection<Employee> allEmployee = employeeDao.getAll();
        //将所有的员工信息在请求域中共享
        model.addAttribute("allEmployee",allEmployee);
        //跳转页面列表
        return "employee_list";
    }
~~~

**②创建employee_list.html**

~~~xml
<!doctype html>
<html lang="ch" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>employee List</title>
    <link rel="stylesheet" th:href="@{/static/css/index_work.css}">
</head>
<body>
<table>
    <tr>
        <th colspan="5">employee list</th>
    </tr>
    <tr>
        <th>id</th>
        <th>lastName</th>
        <th>email</th>
        <th>gender</th>
        <th>options</th>
    </tr>
    <tr th:each="employee : ${allEmployee}">
        <td th:text="${employee.id}"></td>
        <td th:text="${employee.lastName}"></td>
        <td th:text="${employee.email}"></td>
        <td th:text="${employee.gender}"></td>
        <td>
            <a href="">delete</a>
            <a href="">update</a>
        </td>
    </tr>
</table>
</body>
</html>
~~~

## 8.5、具体功能：删除

**①创建处理delete请求方式的表单**

**②删除超链接绑定点击事件**

引入vue.js

~~~html
<script type="text/javascript" th:src="@{/static/js/vue.js}"></script>
~~~

删除超链接

~~~html
<script type="text/javascript">
    var vue = new Vue({
        el:"#app",
        methods:{
            deleteEmployee(){
                //获取form表单
                var from=document.getElementsByTagName("form")[0];
                //将超链接的href属性值赋值给form表单的action属性
                //event.target表示当前触发事件的标签
                from.action = event.target.href;
                //将表单提交
                from.submit();
                //阻止超链接的默认行为
                event.preventDefault();
            }
        }

    });
</script>
~~~

通过vue处理点击事件

~~~html
<!doctype html>
<html lang="ch" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>employee List</title>
    <link rel="stylesheet" th:href="@{/static/css/index_work.css}">
</head>
<body>
<div id="app">
    <table>
        <tr>
            <th colspan="5">employee list</th>
        </tr>
        <tr>
            <th>id</th>
            <th>lastName</th>
            <th>email</th>
            <th>gender</th>
            <th>options（<a th:href="@{to/add}">add</a>）</th>
        </tr>
        <tr th:each="employee : ${allEmployee}">
            <td th:text="${employee.id}"></td>
            <td th:text="${employee.lastName}"></td>
            <td th:text="${employee.email}"></td>
            <td th:text="${employee.gender}"></td>
            <td>
                <a @click="deleteEmployee" th:href="@{'/employee/'+${employee.id}}">delete</a>
                <a th:href="@{'/employee/'+${employee.id}}">update</a>
            </td>
        </tr>
    </table>
    <form  method="post">
        <input type="hidden" name="_method" value="delete">
    </form>
</div>
<script type="text/javascript" th:src="@{/static/js/vue.js}"></script>
<script type="text/javascript">
    var vue = new Vue({
        el:"#app",
        method:{
            deleteEmployee(){
                //获取form表单
                var from=document.getElementsByTagName("form")[0];
                //将超链接的href属性值赋值给form表单的action属性
                //event.target表示当前触发事件的标签
                from.action =  event.target.href;
                //将表单提交
                from.submit();
                //阻止超链接的默认行为
                event.preventDefault();
            }
        }

    })
</script>
</body>
</html>
~~~

**③控制器方法**

~~~java
@RequestMapping(value = "/employee/{id}",method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/employee";
    }
~~~

## 8.6、具体功能：跳转到添加数据页面

**①配置view-controller**

~~~xml
<mvc:view-controller path="to/add" view-name="employee_add"></mvc:view-controller>
~~~

**②创建employee_add.html**

~~~html
<!doctype html>
<html lang="ch" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>add employee</title>
    <link rel="stylesheet" th:href="@{/static/css/index_work.css}">
</head>
<body>
<form th:action="@{/employee}" method="post">
    <table>
       <tr>
           <th colspan="2">add employee</th>
       </tr>
        <tr>
            <td>lastName</td>
            <td>
                <input type="text" name="lastName">
            </td>
        </tr>
       <tr>
           <td>email</td>
           <td>
               <input type="text" name="email">
           </td>
       </tr>
        <tr>
            <td>gender</td>
            <td>
                <input type="radio" name="gender" value="1">male
                <input type="radio" name="gender" value="0">female
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="add">
            </td>
        </tr>

    </table>
</form>
</body>
</html>
~~~

## 8.7、具体功能：执行保存

**①控制器方法**

~~~java
//添加员工信息
    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        //保存员工信息
        employeeDao.save(employee);
        //访问列表功能,采用重定向
        // /employee
        return "redirect:/employee";
    }
~~~

## 8.8、具体功能：跳转到更新数据页面

**①修改超链接**

~~~html
 <a th:href="@{'/employee/'+${employee.id}}">update</a>
~~~

**②控制器方法**

~~~java
@RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") Integer id,Model model){
        //根据ID查询员工信息
        Employee employee = employeeDao.get(id);
        //将员工信息共享到请求域
        model.addAttribute("employee",employee);
        //跳转employee_update.html
        return "employee_update";
    }
~~~

**③创建employee_update.html**

~~~html
<!doctype html>
<html lang="ch" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>update employee</title>
    <link rel="stylesheet" th:href="@{/static/css/index_work.css}">
</head>
<body>
<form th:action="@{/employee}" method="post">
    <input type="hidden" name="_method" value="put">
    <input type="hidden" name="id" th:value="${employee.id}">
    <table>
       <tr>
           <th colspan="2">update employee</th>
       </tr>
        <tr>
            <td>lastName</td>
            <td>
                <input type="text" name="lastName" th:value="${employee.lastName}">
            </td>
        </tr>

       <tr>
           <td>email</td>
           <td>
               <input type="text" name="email" th:value="${employee.email}" >
           </td>
       </tr>
        <tr>
            <td>gender</td>
            <td>
                <input type="radio" name="gender" value="1" th:field="${employee.gender}">male
                <input type="radio" name="gender" value="1" th:field="${employee.gender}">female
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="updata">
            </td>
        </tr>

    </table>
</form>
</body>
</html>
~~~

## 8.9、具体功能：执行更新

**①控制器方法**

~~~java
@RequestMapping(value = "/employee",method = RequestMethod.PUT)
    public String upDateEmployee(Employee employee){
        //保存员工信息
        employeeDao.save(employee);
        //访问列表功能,采用重定向
        // /employee
        return "redirect:/employee";
    }
~~~

# 9、SpringMVC处理ajax请求

## 9.1、@RequestBody

@RequestBody可以获取请求体信息，使用@RequestBody注解标识控制器方法的形参，当前请求的请求体就会为当前注解所标识的形参

赋值

~~~html
<!--此时必须使用post请求方式，因为get请求没有请求体--> 
<form th:action="@{/test/RequestBody}" method="post"> 
    用户名：<input type="text" name="username"><br> 
    密码：<input type="password" name="password"><br> 
    <input type="submit"> 
</form>
~~~

~~~java
@RequestMapping("/test/RequestBody") 
public String testRequestBody(@RequestBody String requestBody){ 
    System.out.println("requestBody:"+requestBody);
    return "success"; 
}
~~~

输出结果：

requestBody:username=admin&password=123456

## 9.2、@RequestBody获取json格式的请求参数

在使用了axios发送ajax请求之后，浏览器发送到服务器的请求参数有两种格式：

1、name=value&name=value...，此时的请求参数可以通过request.getParameter()获取，对应SpringMVC中，可以直接通过控制器方法的形参获取此类请求参数

2、{key:value,key:value,...}，此时无法通过request.getParameter()获取，之前我们使用操作json的相关jar包gson或jackson处理此类请求参数，可以将其转换为指定的实体类对象或map集合。在SpringMVC中，直接使用@RequestBody注解标识控制器方法的形参即可将此类请求参数转换为java对象

使用@RequestBody获取json格式的请求参数的条件：

1、导入jackson的依赖

~~~xml
<dependency> 

	<groupId>com.fasterxml.jackson.core</groupId> 

	<artifactId>jackson-databind</artifactId> 

	<version>2.12.1</version> 

</dependency> 
~~~

2、SpringMVC的配置文件中设置开启mvc的注解驱动

~~~xml
<!--开启mvc的注解驱动--> 

<mvc:annotation-driven /> 
~~~

3、在控制器方法的形参位置，设置json格式的请求参数要转换成的java类型（实体类或map）的参数，并使用@RequestBody注解标识

~~~html
<input type="button" value="测试@RequestBody获取json格式的请求参数" @click="testRequestBody()"><br>
<script type="text/javascript" th:src="@{/js/vue.js}">
</script>
<script type="text/javascript" th:src="@{/js/axios.min.js}">
</script>
<script type="text/javascript">var vue = new Vue({
    el: "#app",
    methods: {
      testRequestBody() {
        axios.post("/SpringMVC/test/RequestBody/json", {
          username: "admin",
          password: "123456"
        }).then(response = >{
          console.log(response.data);
        });
      }
    }
  });</script>
~~~

~~~java
//将json格式的数据转换为map集合 @RequestMapping("/test/RequestBody/json")
public void testRequestBody(@RequestBody Map<String, Object> map, HttpServletResponse response) throws IOException {
	System.out.println(map);
	//{username=admin, password=123456} 
	response.getWriter().print("hello,axios");
}
//将json格式的数据转换为实体类对象 
@RequestMapping("/test/RequestBody/json")
public void testRequestBody(@RequestBody User user, HttpServletResponse response) throws IOException {
	System.out.println(user);
	//User{id=null, username='admin', password='123456', age=null, gender='null'} 
	response.getWriter().print("hello,axios");
}
~~~

## 9.3、@ResponseBody

@ResponseBody用于标识一个控制器方法，可以将该方法的返回值直接作为响应报文的响应体响应到浏览器

~~~java
@RequestMapping("/testResponseBody") 
public String testResponseBody(){
    //此时会跳转到逻辑视图success所对应的页面 
    return "success"; 
}
@RequestMapping("/testResponseBody") 
@ResponseBody 
public String testResponseBody(){ 
    //此时响应浏览器数据success 
    return "success"; 
}
~~~

## 9.4、@ResponseBody响应浏览器json数据

服务器处理ajax请求之后，大多数情况都需要向浏览器响应一个java对象，此时必须将java对象转换为json字符串才可以响应到浏览器，之前我们使用操作json数据的jar包gson或jackson将java对象转换为json字符串。在SpringMVC中，我们可以直接使用@ResponseBody注解实现此功能

@ResponseBody响应浏览器json数据的条件：

1、导入jackson的依赖

~~~xml
<dependency> 
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId> 
    <version>2.12.1</version>
</dependency>
~~~

2、SpringMVC的配置文件中设置开启mvc的注解驱动

~~~xml
<!--开启mvc的注解驱动--> 
<mvc:annotation-driven />
~~~

3、使用@ResponseBody注解标识控制器方法，在方法中，将需要转换为json字符串并响应到浏览器的java对象作为控制器方法的返回值，此时SpringMVC就可以将此对象直接转换为json字符串并响应到浏览器

~~~html
<input type="button"
	   value="测试@ResponseBody响应浏览器json格式的数据"
	   @click="testResponseBody()">
<br>
<script type="text/javascript"
		th:src="@{/js/vue.js}"></script>
<script type="text/javascript"
		th:src="@{/js/axios.min.js}"></script>
<script type="text/javascript">
	var vue = new Vue({ el:"#app", methods:{ testResponseBody(){ axios.post("/SpringMVC/test/ResponseBody/json").then(response=>{ console.log(response.data); }); } } });
</script>
~~~

~~~java
//响应浏览器list集合 
@RequestMapping("/test/ResponseBody/json") 
@ResponseBody 
public List<User> testResponseBody(){ 
    User user1 = new User(1001,"admin1","123456",23,"男"); 
    User user2 = new User(1002,"admin2","123456",23,"男"); 
    User user3 = new User(1003,"admin3","123456",23,"男"); 
    List<User> list = Arrays.asList(user1, user2, user3); 
    return list;
}
//响应浏览器map集合 
@RequestMapping("/test/ResponseBody/json") 
@ResponseBody 
public Map<String, Object> testResponseBody(){ 
    User user1 = new User(1001,"admin1","123456",23,"男"); 
    User user2 = new User(1002,"admin2","123456",23,"男"); 
    User user3 = new User(1003,"admin3","123456",23,"男");
    Map<String, Object> map = new HashMap<>(); 
    map.put("1001", user1); 
    map.put("1002", user2); 
    map.put("1003", user3); 
    return map; 
}
//响应浏览器实体类对象 
@RequestMapping("/test/ResponseBody/json") 
@ResponseBody 
public User testResponseBody(){ 
    return user; 
}
~~~

## 9.5、@RestController注解

@RestController注解是springMVC提供的一个复合注解，标识在控制器的类上，就相当于为类添加了

@Controller注解，并且为其中的每个方法添加了@ResponseBody注解

# 10、文件上传和下载

## 10.1、文件下载

ResponseEntity用于控制器方法的返回值类型，该控制器方法的返回值就是响应到浏览器的响应报文

使用ResponseEntity实现下载文件的功能

~~~java
package com.liyouxiu.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author liyouxiu
 * @date 2022/10/12 16:28
 *
 * ResponseEntity:可以作为控制器
 */
@Controller
public class FileUpAndDownController {

    @RequestMapping("test/down")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("/img/1.png");
        //创建输入流
        InputStream is = new FileInputStream(realPath);
        //创建字节数组
        byte[] bytes = new byte[is.available()];
        //将流读到字节数组中
        is.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=1.png");
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        //关闭输入流
        is.close();
        return responseEntity;
    }

}

~~~

# **还有部分未完成但是不太重要有时间继续完成**