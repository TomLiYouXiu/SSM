[代码重工 (gitee.io)](http://heavy_code_industry.gitee.io/code_heavy_industry/pro002-maven/)



# 第一节 为什么要学习Maven？

## 1、Maven 作为依赖管理工具

### ①jar 包的规模

随着我们使用越来越多的框架，或者框架封装程度越来越高，项目中使用的jar包也越来越多。项目中，一个模块里面用到上百个jar包是非常正常的。

比如下面的例子，我们只用到 SpringBoot、SpringCloud 框架中的三个功能：

- Nacos 服务注册发现
- Web 框架环境
- 图模板技术 Thymeleaf



最终却导入了 106 个 jar 包：

> org.springframework.security:spring-security-rsa:jar:1.0.9.RELEASE:compile
> com.netflix.ribbon: ribbon:jar:2.3.0:compile
> org.springframework.boot:spring-boot-starter-thymeleaf:jar:2.3.6.RELEASE:compile
> commons-configuration:commons-configuration:jar:1.8:compile
> org.apache.logging.log4j:log4j-api:jar:2.13.3:compile
> org.springframework:spring-beans:jar:5.2.11.RELEASE:compile
> org.springframework.cloud:spring-cloud-starter-netflix-ribbon:jar:2.2.6.RELEASE:compile
> org.apache.tomcat.embed:tomcat-embed-websocket:jar:9.0.39:compile
> com.alibaba.cloud:spring-cloud-alibaba-commons:jar:2.2.6.RELEASE:compile
> org.bouncycastle:bcprov-jdk15on:jar:1.64:compile
> org.springframework.security:spring-security-crypto:jar:5.3.5.RELEASE:compile
> org.apache.httpcomponents:httpasyncclient:jar:4.1.4:compile
> com.google.j2objc:j2objc-annotations:jar:1.3:compile
> com.fasterxml.jackson.core:jackson-databind:jar:2.11.3:compile
> io.reactivex:rxjava:jar:1.3.8:compile
> ch.qos.logback:logback-classic:jar:1.2.3:compile
> org.springframework:spring-web:jar:5.2.11.RELEASE:compile
> io.reactivex:rxnetty-servo:jar:0.4.9:runtime
> org.springframework:spring-core:jar:5.2.11.RELEASE:compile
> io.github.openfeign.form:feign-form-spring:jar:3.8.0:compile
> io.github.openfeign.form:feign-form:jar:3.8.0:compile
> com.netflix.ribbon:ribbon-loadbalancer:jar:2.3.0:compile
> org.apache.httpcomponents:httpcore:jar:4.4.13:compile
> org.thymeleaf.extras:thymeleaf-extras-java8time:jar:3.0.4.RELEASE:compile
> org.slf4j:jul-to-slf4j:jar:1.7.30:compile
> com.atguigu.demo:demo09-base-entity:jar:1.0-SNAPSHOT:compile
> org.yaml:snakeyaml:jar:1.26:compile
> org.springframework.boot:spring-boot-starter-logging:jar:2.3.6.RELEASE:compile
> io.reactivex:rxnetty-contexts:jar:0.4.9:runtime
> org.apache.httpcomponents:httpclient:jar:4.5.13:compile
> io.github.openfeign:feign-core:jar:10.10.1:compile
> org.springframework.boot:spring-boot-starter-aop:jar:2.3.6.RELEASE:compile
> org.hdrhistogram:HdrHistogram:jar:2.1.9:compile
> org.springframework:spring-context:jar:5.2.11.RELEASE:compile
> commons-lang:commons-lang:jar:2.6:compile
> io.prometheus:simpleclient:jar:0.5.0:compile
> ch.qos.logback:logback-core:jar:1.2.3:compile
> org.springframework:spring-webmvc:jar:5.2.11.RELEASE:compile
> com.sun.jersey:jersey-core:jar:1.19.1:runtime
> javax.ws.rs:jsr311-api:jar:1.1.1:runtime
> javax.inject:javax.inject:jar:1:runtime
> org.springframework.cloud:spring-cloud-openfeign-core:jar:2.2.6.RELEASE:compile
> com.netflix.ribbon:ribbon-core:jar:2.3.0:compile
> com.netflix.hystrix:hystrix-core:jar:1.5.18:compile
> com.netflix.ribbon:ribbon-transport:jar:2.3.0:runtime
> org.springframework.boot:spring-boot-starter-json:jar:2.3.6.RELEASE:compile
> org.springframework.cloud:spring-cloud-starter-openfeign:jar:2.2.6.RELEASE:compile
> com.fasterxml.jackson.module:jackson-module-parameter-names:jar:2.11.3:compile
> com.sun.jersey.contribs:jersey-apache-client4:jar:1.19.1:runtime
> io.github.openfeign:feign-hystrix:jar:10.10.1:compile
> io.github.openfeign:feign-slf4j:jar:10.10.1:compile
> com.alibaba.nacos:nacos-client:jar:1.4.2:compile
> org.apache.httpcomponents:httpcore-nio:jar:4.4.13:compile
> com.sun.jersey:jersey-client:jar:1.19.1:runtime
> org.springframework.cloud:spring-cloud-context:jar:2.2.6.RELEASE:compile
> org.glassfish:jakarta.el:jar:3.0.3:compile
> org.apache.logging.log4j:log4j-to-slf4j:jar:2.13.3:compile
> com.fasterxml.jackson.datatype:jackson-datatype-jsr310:jar:2.11.3:compile
> org.springframework.cloud:spring-cloud-commons:jar:2.2.6.RELEASE:compile
> org.aspectj:aspectjweaver:jar:1.9.6:compile
> com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery:jar:2.2.6.RELEASE:compile
> com.google.guava:listenablefuture:jar:9999.0-empty-to-avoid-conflict-with-guava:compile
> com.alibaba.spring:spring-context-support:jar:1.0.10:compile
> jakarta.annotation:jakarta.annotation-api:jar:1.3.5:compile
> org.bouncycastle:bcpkix-jdk15on:jar:1.64:compile
> com.netflix.netflix-commons:netflix-commons-util:jar:0.3.0:runtime
> com.fasterxml.jackson.core:jackson-annotations:jar:2.11.3:compile
> com.google.guava:guava:jar:29.0-jre:compile
> com.google.guava:failureaccess:jar:1.0.1:compile
> org.springframework.boot:spring-boot:jar:2.3.6.RELEASE:compile
> com.fasterxml.jackson.datatype:jackson-datatype-jdk8:jar:2.11.3:compile
> com.atguigu.demo:demo08-base-api:jar:1.0-SNAPSHOT:compile
> org.springframework.cloud:spring-cloud-starter-netflix-archaius:jar:2.2.6.RELEASE:compile
> org.springframework.boot:spring-boot-autoconfigure:jar:2.3.6.RELEASE:compile
> org.slf4j:slf4j-api:jar:1.7.30:compile
> commons-io:commons-io:jar:2.7:compile
> org.springframework.cloud:spring-cloud-starter:jar:2.2.6.RELEASE:compile
> org.apache.tomcat.embed:tomcat-embed-core:jar:9.0.39:compile
> io.reactivex:rxnetty:jar:0.4.9:runtime
> com.fasterxml.jackson.core:jackson-core:jar:2.11.3:compile
> com.google.code.findbugs:jsr305:jar:3.0.2:compile
> com.netflix.archaius:archaius-core:jar:0.7.6:compile
> org.springframework.boot:spring-boot-starter-web:jar:2.3.6.RELEASE:compile
> commons-codec:commons-codec:jar:1.14:compile
> com.netflix.servo:servo-core:jar:0.12.21:runtime
> com.google.errorprone:error_prone_annotations:jar:2.3.4:compile
> org.attoparser:attoparser:jar:2.0.5.RELEASE:compile
> com.atguigu.demo:demo10-base-util:jar:1.0-SNAPSHOT:compile
> org.checkerframework:checker-qual:jar:2.11.1:compile
> org.thymeleaf:thymeleaf-spring5:jar:3.0.11.RELEASE:compile
> commons-fileupload:commons-fileupload:jar:1.4:compile
> com.netflix.ribbon:ribbon-httpclient:jar:2.3.0:compile
> com.netflix.netflix-commons:netflix-statistics:jar:0.1.1:runtime
> org.unbescape:unbescape:jar:1.1.6.RELEASE:compile
> org.springframework:spring-jcl:jar:5.2.11.RELEASE:compile
> com.alibaba.nacos:nacos-common:jar:1.4.2:compile
> commons-collections:commons-collections:jar:3.2.2:runtime
> javax.persistence:persistence-api:jar:1.0:compile
> com.alibaba.nacos:nacos-api:jar:1.4.2:compile
> org.thymeleaf:thymeleaf:jar:3.0.11.RELEASE:compile
> org.springframework:spring-aop:jar:5.2.11.RELEASE:compile
> org.springframework.boot:spring-boot-starter:jar:2.3.6.RELEASE:compile
> org.springframework.boot:spring-boot-starter-tomcat:jar:2.3.6.RELEASE:compile
> org.springframework.cloud:spring-cloud-netflix-ribbon:jar:2.2.6.RELEASE:compile
> org.springframework:spring-expression:jar:5.2.11.RELEASE:compile
> org.springframework.cloud:spring-cloud-netflix-archaius:jar:2.2.6.RELEASE:compile

而如果使用 Maven 来引入这些 jar 包只需要配置三个『**依赖**』：

```xml
    <!-- Nacos 服务注册发现启动器 -->
    <dependency>
        <groupId>com.alibaba.cloud</groupId>
        <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
    </dependency>

    <!-- web启动器依赖 -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- 视图模板技术 thymeleaf -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
```

### ②jar 包的来源

- 这个jar包所属技术的官网。官网通常是英文界面，网站的结构又不尽相同，甚至找到下载链接还发现需要通过特殊的工具下载。
- 第三方网站提供下载。问题是不规范，在使用过程中会出现各种问题。
  - jar包的名称
  - jar包的版本
  - jar包内的具体细节
- 而使用 Maven 后，依赖对应的 jar 包能够**自动下载**，方便、快捷又规范。

### ③jar 包之间的依赖关系

框架中使用的 jar 包，不仅数量庞大，而且彼此之间存在错综复杂的依赖关系。依赖关系的复杂程度，已经上升到了完全不能靠人力手动解决的程度。另外，jar 包之间有可能产生冲突。进一步增加了我们在 jar 包使用过程中的难度。

下面是前面例子中 jar 包之间的依赖关系：

![images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img006.ab4f2e31.png)

而实际上 jar 包之间的依赖关系是普遍存在的，如果要由程序员手动梳理无疑会增加极高的学习成本，而这些工作又对实现业务功能毫无帮助。

而使用 Maven 则几乎不需要管理这些关系，极个别的地方调整一下即可，极大的减轻了我们的工作量。

## 2、Maven 作为构建管理工具

### ①你没有注意过的构建

你可以不使用 Maven，但是构建必须要做。当我们使用 IDEA 进行开发时，构建是 IDEA 替我们做的。

### ②脱离 IDE 环境仍需构建

![images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img010.74e515e5.png)

## 3、结论

- **管理规模庞大的 jar 包，需要专门工具。**
- **脱离 IDE 环境执行构建操作，需要专门工具。**



# 第二节 什么是 Maven？

Maven 是 Apache 软件基金会组织维护的一款专门为 Java 项目提供**构建**和**依赖**管理支持的工具。

![./images](data:image/png;base64,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)

## 1、构建

Java 项目开发过程中，构建指的是使用**『原材料生产产品』**的过程。

- 原材料

  - Java 源代码

  - 基于 HTML 的 Thymeleaf 文件

  - 图片

  - 配置文件

  - ###### ……

- 产品

  - 一个可以在服务器上运行的项目

构建过程包含的主要的环节：

- 清理：删除上一次构建的结果，为下一次构建做好准备
- 编译：Java 源程序编译成 *.class 字节码文件
- 测试：运行提前准备好的测试程序
- 报告：针对刚才测试的结果生成一个全面的信息
- 打包
  - Java工程：jar包
  - Web工程：war包
- 安装：把一个 Maven 工程经过打包操作生成的 jar 包或 war 包存入 Maven 仓库
- 部署
  - 部署 jar 包：把一个 jar 包部署到 Nexus 私服服务器上
  - 部署 war 包：借助相关 Maven 插件（例如 cargo），将 war 包部署到 Tomcat 服务器上

## 2、依赖

如果 A 工程里面用到了 B 工程的类、接口、配置文件等等这样的资源，那么我们就可以说 A 依赖 B。例如：

- junit-4.12 依赖 hamcrest-core-1.3
- thymeleaf-3.0.12.RELEASE 依赖 ognl-3.1.26
  - ognl-3.1.26 依赖 javassist-3.20.0-GA
- thymeleaf-3.0.12.RELEASE 依赖 attoparser-2.0.5.RELEASE
- thymeleaf-3.0.12.RELEASE 依赖 unbescape-1.1.6.RELEASE
- thymeleaf-3.0.12.RELEASE 依赖 slf4j-api-1.7.26



依赖管理中要解决的具体问题：

- jar 包的下载：使用 Maven 之后，jar 包会从规范的远程仓库下载到本地
- jar 包之间的依赖：通过依赖的传递性自动完成
- jar 包之间的冲突：通过对依赖的配置进行调整，让某些jar包不会被导入

## 3、Maven 的工作机制

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img003.f9cc536c.png)

# 第三节 Maven核心程序解压与配置

## 1、Maven 官网地址

首页：

[Maven – Welcome to Apache Maven(opens new window)](https://maven.apache.org/)

下载页面：

[Maven – Download Apache Maven(opens new window)](https://maven.apache.org/download.cgi)

下载链接：

![images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img015.9ab3ebd3.png)

具体下载地址：https://dlcdn.apache.org/maven/maven-3/3.8.4/binaries/apache-maven-3.8.4-bin.zip

## 2、解压Maven核心程序

核心程序压缩包：apache-maven-3.8.4-bin.zip，解压到**非中文、没有空格**的目录。例如：

![images](data:image/png;base64,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)

在解压目录中，我们需要着重关注 Maven 的核心配置文件：**conf/settings.xml**

## 3、指定本地仓库

本地仓库默认值：用户家目录/.m2/repository。由于本地仓库的默认位置是在用户的家目录下，而家目录往往是在 C 盘，也就是系统盘。将来 Maven 仓库中 jar 包越来越多，仓库体积越来越大，可能会拖慢 C 盘运行速度，影响系统性能。所以建议将 Maven 的本地仓库放在其他盘符下。配置方式如下：

```xml
<!-- localRepository
 The path to the local repository maven will use to store artifacts.

 Default: ${user.home}/.m2/repository
<localRepository>/path/to/local/repo</localRepository>
-->
<localRepository>D:\maven-repository</localRepository>

user 用户下的.m2目录用来存放jar包
```

本地仓库这个目录，我们手动创建一个空的目录即可。

**记住**：一定要把 localRepository 标签**从注释中拿出来**。

**注意**：本地仓库本身也需要使用一个**非中文、没有空格**的目录。

## 4、配置阿里云提供的镜像仓库

Maven 下载 jar 包默认访问境外的中央仓库，而国外网站速度很慢。改成阿里云提供的镜像仓库，**访问国内网站**，可以让 Maven 下载 jar 包的时候速度更快。配置的方式是：

### ①将原有的例子配置注释掉

```xml
<!-- <mirror>
  <id>maven-default-http-blocker</id>
  <mirrorOf>external:http:*</mirrorOf>
  <name>Pseudo repository to mirror external repositories initially using HTTP.</name>
  <url>http://0.0.0.0/</url>
  <blocked>true</blocked>
</mirror> -->
```

### ②加入我们的配置

将下面 mirror 标签整体复制到 settings.xml 文件的 mirrors 标签的内部。

```xml
	<mirror>
		<id>nexus-aliyun</id>
		<mirrorOf>central</mirrorOf>
		<name>Nexus aliyun</name>
		<url>http://maven.aliyun.com/nexus/content/groups/public</url>
	</mirror>
```

## 5、配置 Maven 工程的基础 JDK 版本

如果按照默认配置运行，Java 工程使用的默认 JDK 版本是 1.5，而我们熟悉和常用的是 JDK 1.8 版本。修改配置的方式是：将 profile 标签整个复制到 settings.xml 文件的 profiles 标签内。

```xml
	<profile>
	  <id>jdk-1.8</id>
	  <activation>
		<activeByDefault>true</activeByDefault>
		<jdk>1.8</jdk>
	  </activation>
	  <properties>
		<maven.compiler.source>1.8</maven.compiler.source>
		<maven.compiler.target>1.8</maven.compiler.target>
		<maven.compiler.compilerVersion>1.8</maven.compiler.compilerVersion>
	  </properties>
	</profile>
```

# 第四节 配置环境变量

## 1、检查 JAVA_HOME 配置是否正确

Maven 是一个用 Java 语言开发的程序，它必须基于 JDK 来运行，需要通过 JAVA_HOME 来找到 JDK 的安装位置。

![./images](data:image/png;base64,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)

可以使用下面的命令验证：

```shell
C:\Users\Administrator>echo %JAVA_HOME%
D:\software\Java

C:\Users\Administrator>java -version
java version "1.8.0_141"
Java(TM) SE Runtime Environment (build 1.8.0_141-b15)
Java HotSpot(TM) 64-Bit Server VM (build 25.141-b15, mixed mode)
```

## 2、配置 MAVEN_HOME

![./images](data:image/png;base64,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)

TIP

配置环境变量的规律：

XXX_HOME 通常指向的是 bin 目录的上一级

PATH 指向的是 bin 目录

## 3、配置PATH

![./images](data:image/png;base64,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)

## 4、验证

```bash
C:\Users\Administrator>mvn -v
Apache Maven 3.8.4 (9b656c72d54e5bacbed989b64718c159fe39b537)
Maven home: D:\software\apache-maven-3.8.4
Java version: 1.8.0_141, vendor: Oracle Corporation, runtime: D:\software\Java\jre
Default locale: zh_CN, platform encoding: GBK
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
```

# 第五节 实验一：根据坐标创建 Maven 工程

## 1、Maven 核心概念：坐标

### ①数学中的坐标

![./images](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAh0AAAHGCAYAAADQcTmWAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAAFxEAABcRAcom8z8AAA2sSURBVHhe7d0/jyTVFcbhBYdOsDZxiMgcgRxaSCZxQmIyE0JEipNNnKwsIdnREpFuuo4g88oJtuwMWfABkLD8ARb4BPienr6otj3/dqfOu1PdzyMddXdNMySj5kfdW9U/uQO3xztjfj7mP7tXAAANXhnz5Zhvdq8AAJrcH/PDft6rAwAAa3t1zLdjZnTU8zrzAQCwqgdjZnDMeTgGAGA1b42ZZzcOw+ONMQAAq/h8TAXGck9HneWox/oZAMCNfTim4qKuWKk9HDM66nkdq+d1GS0AwHOrsJhLKvNqlRkdpY7V83oPAMBzm8spyyWUZXSUum9Hva73AgA8s+UlsrWRdDqMjtpIWq/rvfXPAAA8k0/HVEzUpbJLh9FR5qbS+mcAAK6tNobOsxeHNwA7LzqWG0yXZ0UAAC5UAXHZPo3zoqPM/R++lwUAuJZ5I7B5ieyhi6KjzEtone0AAK6l7s1x0abQy6KjNpXWZbTnxQoAwDO5LDoA2LiX948AAK1EBwAQIToAgAjRwTG5N+bxft6sA1f4aMx8/906AACchptuJH13zPwdn9SBS1RkzPdWdAAAJ2RGwE08GVO/ox4vO3uxDJR6DgCckDWio5ZMrhMTX4yp91ScAAAnZo3oeH3M/D2P6sA5Xhsz33PVMgwAcIRmCNzUPItRc94SS204nT+vSAEATswMgZu6ar/G12PqZxUnAMAJWis66uzG3FB6uMSyXH6xgRQATtRa0VFqr8b8fbWHY5rHr7q6BQA4YmtGx/KMxgd1YG+eAbGBFABO2JrRUeaG0rl34+0x899hAykAnLC1o6POcMzfWUsstb+jnttACgAnbu3oWN7qfBkgNpACwImbUbCm5cbR+fttIAWAE9cRHfVts/P31thACgC0REeZNwOruc5X3gMAR647OuoRAKAlOpaXyS7v1wEAnLCO6Hg8Zv5eG0gBgJ21o2O5idQGUgDgRzeNjjqTMc9mVHDMy2Trcfn9KwDAibtpdBxeHjun9nUAAPxoRsLzOoyOOsMhOABuiZf2j3AbzOB43r/LWlr5xdnTnX/tHwEAnjLPUABwhF7ePwIAtBIdAECE6AAAIkQHABAhOgCACNEBAESIDgAgQnQAABGiAwCIEB0AQIToAAAiRAcAECE6AIAI0QEARIgOACBCdAAAEaIDAIgQHQBAhOgAACJEBwAQIToAgAjRAQBEiA4AIEJ0AAARogMAiBAdAECE6AAAIkQHABAhOgCACNEBAESIDgAgQnQAABGiAwCIEB0AQIToAAAiRAcAECE6AIAI0QEARIgOACBCdAAAEaIDAIgQHQBAhOgAACJEBwAQIToAgAjRAQBEiA4AIEJ0AAARogMAiBAdAECE6AAAIkQHABAhOgCACNEBAESIDgAgQnQAABGiAwCIEB0AQIToAAAiRAcAECE6AIAI0QEARIgOACBCdAAAEaIDAIgQHQBAhOgAACJEBwAQIToAgAjRAQBEiA4AIEJ0AAARogMAiBAdAECE6AAAIkQHABAhOgCACNEBAESIDgAgQnQAABGiAwCIEB0AQIToAAAiRAcAECE6AIAI0QEARIgOACBCdAAAEaIDAIgQHQBAhOgAACJEBwAQIToAgAjRAQBEiA4AIEJ0AAARogMAiBAdAECE6AAAIkQHABAhOgCACNEBAESIDgAgQnQAABGiAwCIEB0AQIToAAAiRAcAECE6AIAI0QEARIgOACBCdAAAEaIDAIgQHQBAhOgAACJEBwAQIToAgAjRAQBEiA4AIEJ0AAARogMAiBAdAECE6AAAIkQHABAhOgCACNEBAESIDgAgQnQAABGiAwCIEB0AQIToAAAiRAcAECE6AIAI0QEARIgOACBCdAAAEaIDAIgQHQBAhOgAACJEBwAQIToAgAjRAQBEiA4AIEJ0AAARogMAiBAdAECE6AAAIkQHABAhOgCACNEBAESIDgAgQnQAABGiAwCIEB0AQIToAAAiRAcAECE6AIAI0QEARIgOACBCdAAAEaIDAIgQHQBAhOgAACJEBwAQIToAgAjRAQBEiA4AIEJ0AAARogMAiBAdAECE6AAAIkQHABAhOgCACNEBAESIDgAgQnQAABGiAwCIEB0AQIToAAAiRAcAECE6AIAI0QEARIgOACBCdAAAEaIDAIgQHQBAhOgAACJEBwAQIToAgAjRAQBEiA4AIEJ0AAARogMAiBAdAECE6AAAIkQHABAhOgCACNEBAESIDgAgQnQAABGiAwCIEB0AQIToAAAiRAcAECE6AIAI0QEARIgOACBCdAAA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)

使用 x、y、z 三个**『向量』**作为空间的坐标系，可以在**『空间』**中唯一的定位到一个**『点』**。

### ②Maven中的坐标

#### [1]向量说明

使用三个**『向量』**在**『Maven的仓库』**中**唯一**的定位到一个**『jar』**包。

- **groupId**：公司或组织的 id
- **artifactId**：一个项目或者是项目中的一个模块的 id
- **version**：版本号

#### [2]三个向量的取值方式

- groupId：公司或组织域名的倒序，通常也会加上项目名称
  - 例如：com.atguigu.maven
- artifactId：模块的名称，将来作为 Maven 工程的工程名
- version：模块的版本号，根据自己的需要设定
  - 例如：SNAPSHOT 表示快照版本，正在迭代过程中，不稳定的版本
  - 例如：RELEASE 表示正式版本

举例：

- groupId：com.atguigu.maven
- artifactId：pro01-atguigu-maven
- version：1.0-SNAPSHOT

### ③坐标和仓库中 jar 包的存储路径之间的对应关系

坐标：

```xml
  <groupId>javax.servlet</groupId>
  <artifactId>servlet-api</artifactId>
  <version>2.5</version>
```

上面坐标对应的 jar 包在 Maven 本地仓库中的位置：

```text
Maven本地仓库根目录\javax\servlet\servlet-api\2.5\servlet-api-2.5.jar
```

一定要学会根据坐标到本地仓库中找到对应的 jar 包。

## 2、实验操作

### ①创建目录作为后面操作的工作空间

例如：D:\maven-workspace\space201026

WARNING

此时我们已经有了三个目录，分别是：

- Maven 核心程序：中军大帐
- Maven 本地仓库：兵营
- 本地工作空间：战场

### ②在工作空间目录下打开命令行窗口

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img010.7f3addf6.png)

### ③使用命令生成Maven工程

![images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img008.be45c9ad.png)

运行 **mvn archetype:generate** 命令

下面根据提示操作

TIP

Choose a number or apply filter (format: [groupId:]artifactId, case sensitive contains): 7:【直接回车，使用默认值】

Define value for property 'groupId': com.atguigu.maven

Define value for property 'artifactId': pro01-maven-java

Define value for property 'version' 1.0-SNAPSHOT: :【直接回车，使用默认值】

Define value for property 'package' com.atguigu.maven: :【直接回车，使用默认值】

Confirm properties configuration: groupId: com.atguigu.maven artifactId: pro01-maven-java version: 1.0-SNAPSHOT package: com.atguigu.maven Y: :【直接回车，表示确认。如果前面有输入错误，想要重新输入，则输入 N 再回车。】

### ④调整

Maven 默认生成的工程，对 junit 依赖的是较低的 3.8.1 版本，我们可以改成较适合的 4.12 版本。

自动生成的 App.java 和 AppTest.java 可以删除。

```xml
<!-- 依赖信息配置 -->
<!-- dependencies复数标签：里面包含dependency单数标签 -->
<dependencies>
	<!-- dependency单数标签：配置一个具体的依赖 -->
	<dependency>
		<!-- 通过坐标来依赖其他jar包 -->
		<groupId>junit</groupId>
		<artifactId>junit</artifactId>
		<version>4.12</version>
		
		<!-- 依赖的范围 -->
		<scope>test</scope>
	</dependency>
</dependencies>
```

### ⑤自动生成的 pom.xml 解读

```xml
  <!-- 当前Maven工程的坐标 -->
  <groupId>com.atguigu.maven</groupId>
  <artifactId>pro01-maven-java</artifactId>
  <version>1.0-SNAPSHOT</version>
  
  <!-- 当前Maven工程的打包方式，可选值有下面三种： -->
  <!-- jar：表示这个工程是一个Java工程  -->
  <!-- war：表示这个工程是一个Web工程 -->
  <!-- pom：表示这个工程是“管理其他工程”的工程 -->
  <packaging>jar</packaging>

  <name>pro01-maven-java</name>
  <url>http://maven.apache.org</url>

  <properties>
	<!-- 工程构建过程中读取源码时使用的字符集 -->
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  </properties>

  <!-- 当前工程所依赖的jar包 -->
  <dependencies>
	<!-- 使用dependency配置一个具体的依赖 -->
    <dependency>
	
	  <!-- 在dependency标签内使用具体的坐标依赖我们需要的一个jar包 -->
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
	  
	  <!-- scope标签配置依赖的范围 -->
      <scope>test</scope>
    </dependency>
  </dependencies>
```

## 3、Maven核心概念：POM

### ①含义

POM：**P**roject **O**bject **M**odel，项目对象模型。和 POM 类似的是：DOM（Document Object Model），文档对象模型。它们都是模型化思想的具体体现。

### ②模型化思想

POM 表示将工程抽象为一个模型，再用程序中的对象来描述这个模型。这样我们就可以用程序来管理项目了。我们在开发过程中，最基本的做法就是将现实生活中的事物抽象为模型，然后封装模型相关的数据作为一个对象，这样就可以在程序中计算与现实事物相关的数据。

### ③对应的配置文件

POM 理念集中体现在 Maven 工程根目录下 **pom.xml** 这个配置文件中。所以这个 pom.xml 配置文件就是 Maven 工程的核心配置文件。其实学习 Maven 就是学这个文件怎么配置，各个配置有什么用。

## 4、Maven核心概念：约定的目录结构

### ①各个目录的作用

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img011.621b1ac3.png)

另外还有一个 target 目录专门存放构建操作输出的结果。

### ②约定目录结构的意义

Maven 为了让构建过程能够尽可能自动化完成，所以必须约定目录结构的作用。例如：Maven 执行编译操作，必须先去 Java 源程序目录读取 Java 源代码，然后执行编译，最后把编译结果存放在 target 目录。

### ③约定大于配置

Maven 对于目录结构这个问题，没有采用配置的方式，而是基于约定。这样会让我们在开发过程中非常方便。如果每次创建 Maven 工程后，还需要针对各个目录的位置进行详细的配置，那肯定非常麻烦。

目前开发领域的技术发展趋势就是：约定大于配置，配置大于编码。

