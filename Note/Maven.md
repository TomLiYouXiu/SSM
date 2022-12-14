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

![./images](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAVQAAABWCAYAAACQLW4KAAAABHNCSVQICAgIfAhkiAAAAAlwSFlzAAAN1wAADdcBQiibeAAAABl0RVh0U29mdHdhcmUAd3d3Lmlua3NjYXBlLm9yZ5vuPBoAACAASURBVHic7Z15mBxVuf8/3+pJCAk7CIIsCYGw7/sOoqLyE/G6o6AgXhdcogICGpAdFImIAoKoeBEFAfWqCCgosm8xQFhCgIkg4RKyTsIkM9193t8fp3qmZ9IzXXWqujPw1Od5Oj2ZrnNOdU/XW+95V5kZBQUFBQXZiVb2CRQUFBS8Weho5eSSVgVWyTCFAV02wtRoSasAq2acxsxscR7nU1BQMDJQK2SVpPcB5wHbkl0L7gHuBY43s86s55YFSZOAqcChZLtR1JgNnGRmN+YwV0FBwUomd4Eq6cPADblO6rnWzI5uwbyJkLQ9cAewfs5TzzKzSTnPWVBQsBJohQ31uBbMCfARSaNaNHcSriJ/YQpQbcGcBQUFK4FcBWpsWzwozznrGA1s3aK5h0XSh4C9WzT9sy2at6CgoM3kraHuSXZnzXBs0cK5GyKpAzinhUs83sK5CwoK2kjeAnWfnOcbzCYtnr8RxwJbtXD+QqAWFLxJyFugbpnzfINpq0CVNAb4TouX+VeL5y8oKGgTeQvUHXKebzCbtXj+wXwR2KiF8y8Cnm/h/AUFBW0kN4Ea2xp3ymu+IWjl1nsAklYDTmnxMtNGWtJCQUFBOHlqqNsBY3KcrxFbSlKL16jxFeAtLV7j0RbPX1BQ0EbyFKi75zjXUKxKG+yoktYCTmr1OhQCtaDgTUWeAnW3HOcajnbEop4MrNWGdQqBWlDwJuKNKFC3aeXkkjbAb/dbTeGQKih4k5GLQI1TQlvtkKrRag31W8C4Fq8BhUOqoOBNR14a6nbkU30pCS0TqJI2Az7XqvkHUWz3CwreZORVD7UdDqkardzyn4GvGdAOCoEKLP3xlh+xKsdSlTPH/a5U/tFakzsXrezzKigIIZfyfZIuBz6f/XQSs7aZ5XrRSdoamAGU8px3GLY0s+fatNaIZPlPtzzYqnaHVYmsKlwVrMqrmN6/xonPPriyz6+gIC15bfnbqaFCa4qknE37hGnhkAIwd6AiIpVAJSPqgKiDDRTZbQsvnNjqrLsgen86aZvlV038afdlE3/bdemkw1f2+RSMLDJv+WOHVLu//OOBR/KaTNKuwAfzmi8BbXdISRqLzzSbFD+vg7d7r4lvNePiRw8wP37MA/4NPG1m/5f/WUWTwFAEEuaqJhDAmh2UruZM7c0Z5vJfN4BfTBizvLc0BXES+Lq8kdmHlkyddNzqX3v2561cWtJb8IWH9gLeig/pWwP/t+qKH0uAV4C7gX+ZWaWV59ROJK0O7Ir/7k4ExgLr0v+9XYr/nnYCj5jZCynmvhL4bIOXuoHVgCfxZsb5wIZmVo7H7QfcHp/LRWZ2EuRjQ92e9jmkaozPeb5zia/kNtFy+2l8Eb4POALYBZ8QEfweJS3EV8b6I/CHPMwVZjapL+9NLIs6GGsyTMLJ9ugau8Xxa8CVWdfJSveV4zcUHf8r1e3EBBIYNrX7B9veOnbyU6/ktZ6k9YC31z3SFh1aKule4Gbgf8xsWV7nNhTx920H/I16sFwxvICaDzxnZnMTzLca8EngePz3N/FuWtIc4LfAjxJ8Tx/E34yOwt+sZgB/w9cp3pB+n826+JZOj0mKgEvxwhSgb43MNlRJn6X9X/rLzOyEPCaSdADwzzzmSsHHzOz6vCeVtBHwMeADwL60tqvtNOB84KZQbXv5lVssMlgzFqrzgPUAzEHvEj3cMz9aZ/0xG23NGX9fadpW9xVb7qLI/gi8rT7p2SrgKsJVoFrlG2udOOvirGtJ2hv4Kn63lFd3ivnAT4AfmtmrOc05AEkX4887yfetF9jfzB4eYq6N8TU0jsZr4Vkw4Grgm2a2YLgDJd0OvBM4zMxuj3/3PuB/6w47ysx+3UDm7WFmj0A+F1y7AvrrGZ/jXOflOFdScjNXgL8QJf0ZeAn4PrA/rW8RviteC5ghaf+0g5descX65s0NxOL49dprvUt0f8/8aGdg4tzlcw7O5WwDWHr5lh9QZPcAbxv0Ug+C2iOCA7OsI+kgSfcA9+NviHm2+lkXOA14RtKncpwXAEnvBL5G8u/baPx7HDzPapLOxmuGJ5BdmIL/Cx0PPBmb9YZj5/h5Wt3varLt9/HzDpLWxO9ob8N/Z8vAE7UBeVx07XZIQU4CVdJ78MKnnSwCEtt4hkPSjrEgvR94L60Xoo3YFrhD0vFpBnVEAxsTOqPbDJYv1N0986O9iIWKoffld6rJee2UrU7ofU2T6d/W1XgFGF0znsRPQUWBJG0l6VbgH8B+YWeamLWAX0j6U2xSyItjA8asWf+fWBOcBXyb1nT8eCtwl6Q9G70oaRN8IaTZZjav7qWaQL0Ab7I4AK+wrIZPTx8HPGlmPbUBmS5ASaNpv0MKchCocdWqc7OfSmoezeqQkhRJOhVvi31vPqeVidHAVZK+lHTA0tmjNu2eU7rLlfUigKB7+fzSXb0Lo4HatWzf3M+2CXNPnXSSiR9VlmlrjJpTzDCexF+cAm9DRWAilY1S0ihJ3wIeAw7L89wTcDjwT0mDte5QQhSqXvDOJknnAX/Af66tZDXgRknrNnitJjgHmyF2w5/rdLxzan/gM8APiM1TDNRoM2s0O9C+QPh6xkraMOMcH8Ebu9tNJoeUpHH4Lch55JeYkRffl7RHkgOr2LhqDwe9/p9oo9dfju7tflWPlrs4CEPmwKpgFWG92mn2mRNaXRayj//72tZTrBJ9F3/LW7/yuh73p8s95rVxr5QKiA8SSvw3jbWhe/B9ytrtzK2xDX5XsXaWSeKqbCEhjEdJuhl4FTiV9jmEN6FxB46aQO0zxcXyZUNgeqyBPhW/NBevsdZMCAP+9lkFapbtvhHfqQLZPHRgXAz7rIChhr8QloeuTQb7qaS34reHK2UbnIDReCdAU8wxOhaaHZXXo/0qi0ujXFm4srD4Of551Kj5q+7cfMbszPnytie7qs5yscPJqtCzOOoCuwWxP3UXvmr/CEqq3p9kfkmH4jWahlvPNrMVcHPcqTiUPQkThmviHaetbOg5FJ+NCyDVUxOO9ddmrTbJA/Fzrffbt82si35lbEACSlYNJ4tD6nR8HFdoRsxE4N7AsZ/Gx7Sl5dtmdp6kgwm3vQZpqLEx/C7Czrud7CBpZzObPtxB6lWHM8AEBhbRjYsdVPHD4tdkjKf/i90S/vPf232ZiAtVUt/6RFTdMu5ZMrvjOMHLBmVhFUMViYpBVdD1ltHlpt9DSZ8Afk6+DqesHIy3CSY21Qxir/xOpW2sgvfmX1v3u88C65jZjLrf3YkXqrUEnMuAW82spqmeDJxlZjPrJ88qUEM11NeB7+I9ZH3hMikJ0lDjO/LpAUMfwIcJAYSG8SxIE3RcI7b3/g/5CNPl+K3WAvzfYQzeuL45+W1Bj8LbnYakWparF5pY7Dm3QULVCWDjnM6rIbOP2f7TUYlLvDA1iPqeL3CyrwmNJTJvL40VspoV3IyrOGP2sDsWSV8FptLeWOekfEbSGWY2P2DsSNC0QziIOoFqZnOAOfUHmFkvdR2JzWw5/dt+zOzlRhMHC9RYMG0fOPzO+ISR9A/gQwFzTAxc+4ukr/pvwJfrnEmhrVFC7acnk22bPxf4MT7UY1ot26Oe2AyyHd5r+zmytbNpWsqxWlZVdZqoYPlA7bT2s8BWCFvKjc6Pb3+EIn5qSJj59SLDTFOjDjuWisZihkVCJZ/VVUfZRun8IaYGQNIX8E6MrFTw0SGL8MHzm5DPDXAM/u8dEj74RhWoLfOdZNFQdyR8+3Jj3c/30CaBGmdfnBqw1jW1wN04S2JCwBwQIFAlbQOcGbheGa9VX2hm3cMdGKcqPgZMlvQb4C+Edy1o5EkduF6vqvVC00GH6Bek9cIVY/3A8xiWWR/c8cCSdD0lSvEW368ru74k9rOqNjIzZPKCND5GJa+tYly6wdnPdA41f7zN/3GGU3wZ+AXwV/yNcEnd3MI7TfYFTiTb9vurkqamyaiKS1224u/yKHAfPvtoHv5T3xp/kz6MfPrWhV6/TckiULM4pB6q+znUDhrSAfXrpNculzBQCO/KirGJSQlxSF1EmCayEPiAmd2VdqCZPSDpJOCqgHWB5mFErlfL6wWocxoTec2wsZaaM88esePWEfqDRYwxA5mhSMiYFnVES1zF9pRRJ0hj7bXkz1Elm40bM6TpSNJewM8I2+bPwQvJG8ys2uiAeLc0B6+c3Cjp7cANJLiZNWB9fAD8pSnG5JnQMx9vy73WzF4a6qA41OtbeI06i0N9HUljmykZIWQ5qdAPtIeBge1PUIs/Scc6khLfIeP4s28ErHPBoMIgWQKwU2mocQhSSJypAz4aIkzruAZ/MwlhXrMDrBJ1uzpvPmXWd2UtGuTh9z9XeOnJvXcdH3guK/D8YTutT090i6uwlqsKq8QhWhXmmrNrXYXj4//Xft+XZuoqwirClaPPbfC9x15vNH+c134jYSGFPwO2NrNfDyVMG2FmdwLvwAunENLuEvMSqD8BJpjZ+cMJU/B2SzP7IjAlh3Vb4hzMIlBDNdRpNfspQBzj1dDAm4A0xaZPIX0624vA4BztZilsQzHfzGanHPPNwLWmmtlfA8cCENtZ/xU4fGazA6xs3QOEZlWbubKec2WwXuHih/WK8uLoVVfW75vNmYTp2+0xumdp6QpXYYLFwjF+VK2iU62ic22AkFWfEK09qPCTDS9++vZhlvkl6R1pDjjRzD5Tv7VPQxxZ8YWQscBuktKUr8yaIVkGPmFmn0/7fs3sPHyE0IgjSKBKGoN3YIRwX4PfhaZiJhKo8VYhJDTk1Ni7V0+oQTvVdj+21b4nYJ0X8Z0H8iA0muHxZgdUeqIuV+4Xmq5HE6ysWa53oHZqvXqhvKDjBFfWTo/tsHtm55RVdHm5K9qgX0BSE5LnmNOJVtGq9YLU1QRrLdGgYg+/HlW+OtT8ceGMdwec2olm9v3wd9bHjfiKSWkZh09cSEoWDdUBx5jZdRnmuCbDWPACPXdCNdSdCLe/NhKoocWWk2qoU0hvzJ4O/Lr+F7GQCw1dSrXdNzMH/C7lGg8B7zSzhlvRNMR1bkMD6h9rdoAzW2S9/dt7V9YGrifqdAO3/Mt6FpQWuV5NjDXWfQLPB4BpW+z5ZatyXHV5tJ1VVe7bype51VXZzCpsM3BrDwO3/prX21P60BY/nNXTaP64UlKIULzazKZmeW81YttqaFRBIiEZO6RCbLU1vmtmv8kwHuBWILFJZBALWmE/hXChmEXdb6uGKmkiPv82LWc1yLnPEqoS4pD6Ir424zp4Z9p8GmuN3XjN9G85FhbeJ143LT0k2PJHy6KFDtU7n2SwCBT/X4vLC0svV3u0a52FfQ8GRogk5tGJex4EXCzvnV+zsjSaVhrrdpUxJ+rgD67K5cI7p3zoFN6yX/LnJ6NcKrmPbX7tky8Os8wUYPWUpzab/NuWP9H8kIZsmvC4LNf/c4RHrfRhZgskLSAshLFl3TJCBWqouv/SEJXfQ99gkg6oZ5L+fT5Kf8mutOsNN2cq4hS3X2RYM4hYOz0ncPiTSYR69/+NmgM8VRrnuqNRtjsGhiryP7zWu6i0xCrq24Ka/ydEwPPIxL02EPo10GHmQ56qy9QdjZaTq55YJbqiFhNLnVffTDXv/zKcO3rTXz95x1BrSNqUsMpLZ7VAWwpVUJJ+vlm2++c2MKOFEtqyqGW93EK3/MEOqSF+HypQN5Y0ZD6wpB2AjwfM+/UhKkKFvu/XzGw4zWakMRVfqiyERDeOnZ962LlerVteWNq957WOGZVuPUpZ41xZ/+5Z0NHrytrcYu3V+kKntOTRiXul2iE8svleEXCdwYa1UiYYuIq2d5XoXEd0glVYo35rP2jL/7RVtP/mN864qclSp5Lec9wLZLEjDkVDk0QCkhZLCRWocxlkRstIqPx6qvkhYaTWUGMBlsZ4Xc9QF1voHVX4AP+hjPBnk/5Dv9HMhqrgHypQ3xAto+PiK5fhC1eEksa0MddgAxzbV5aWqIp7DeZjA4sB193ZHL6Yc+IIBoPTZbwdqMlS5ENDZ1a6XVepEpki7lEJqWSRSkTqsCgq2dJKT/SM69EaKvEthuk5Fvc8Ojr52+5jIa1xjhwZOK7VGupN9bVDsxDvokKLUOda4L2ekC3/zoSr2g0Fi5nNk7SYQYVnE7IlDQSqpN2B96ecq5fhQ5VCv0gt+wNmJS66sg++nOEHyV4pPfHNw4xXQDvU/X8f84WGVwxNM17G91dKHFv78OZ7HwB8uyaQ5aUp5msYnEu5dFOlbF6rrLUHBFQCRYZKHEJkyDimyVIfw3vJ07IBcIWk3+E/tyzV18BrmIfik0FCxw+LpPGEO6RuCxzXiE0J11BHlEDNYpAe7mJ7nrAYz6EamIUYvq8YqnhJnESQtgZAjZUuUGMtaiI+7W4i/rPeHV/PMq9UpF5SOEQMDf6stwN+j/HRgccB3hm4Cwmdgg9N2Htt4FdCpVrtUp9VCsA3EecYjFLtrZtR67lqVV+UJbaf3ofZtY1X6SNVt4JBfJbGXTdXBklMFqFKRRkY0gYdwPjAcS8OqsqfKyECNfQDfblJk7DcBGrc7CxthtFSvIlgKFp1I8mFeAs0CS8gN4l/3hqfVrgR4QVd0vB4fdJGAl4YlCM31qCB01LgK5I5EiYbGLpE2CaxMwvFHfYM+wewnowdoT+rVbWIA7zTSgZWUZmIz+381MNDZvJJ2pI3bpGQwSRx1oRe//ea2dLAsY0ILY40lB8nF9qpoTYTKqGet0ZxoSHa6ZVN7lyh7/tVM/tP4Nghib3KB8WPPfHCc2XX2kwZa9vIGamB30kbYEO9A5j60IS9P7Fn5wNDZtfcN2H/94joaGHUHrFzvxvpIrDfxbv/mlGVvv+jem315F2efahZkPxHm7z+RuLfCY4JFah5bvch3I8Tmv2XiFQCVdJYwkOHml1szwTOO0BDjdtCvyvlHIvxbQ2GY6U7pGKzw8fw/coTtRppMylNGxoYr+qF5ySgk0EVgeI6pG8FdjD0DoZIerh7wkGrR0Q/8SLS9f1eXvecgvGdWJuPjQB9ZoB6bdVhnLbr8w8mCZAPdQCNRBYnOCZUoN4TOG4oQjM1R5SGugvhDqlmbyQkXQ5gQ0lrmtniuKRZiEH+bDN7rckxoQI1s/1U0rb4dNIPEv75t4O0GuosfLZL/XvazdADxAK1r6Czf94hfn4vQwhUI7rA4Tbx3Uki6rTU+4RJ2O6xthp32TPqtNXliFsNHhZc3+z8Ja1BeDbZSOTZ4V7M4JDqJX8/wogUqGm9ZFkCeptdbE9Tr1Kk453x8wWkt2c9T5OyZZI2wteeDCFTDylJ1+EdPR9hZAvTHlLeFPfsfKDX0As1keeIcES7OaKHHBFVSvHvBj9H72g0398nHLqzQ5+Pj8ERYf7Ra0SnGzqzX0DXqu570RuHuz6DcRjGhrs9/+DsBG/hYEb23yQtzdoRhV7/03IM5ifuCRVyPc6Nq/O3jLQCNVRLe8XMXhnugLi4bWg86g8l3YavbJ+WkxM4UtrukIrrW07HJyZkbabYDh5r1AmgGY5o+iDhubojmlsnPKnWCcj4mPF3TThkhZhJI5pqRJH1C1IcwqELHPqKIxrXL2jrWpl4wSpgZ4ObSJ4K2rJCxSuBFxIIm9DroFG6eRbyTizKjXYJ1KRC5enA+Tckvd0U4C4zuznBcVluJKnviHF/+7/i4xRbRRWfMXIdcBrenPCjDPMF3Ti8NrqC8FzHES0brJ0OEqwDttp/nfDuDziig12/EI0f0TOOaIYjOqJOY+0zBECftjoddBTo07u/8GDS+rxvFoHqgP9OcFyohpq3QA09j5Y6pCCFDTVuHxJSJR+SX2wty7FtgAMmJzy2bQ4pSUcBPyS/2NBl+HJ6T+CLlszEe3OfbbANu1nS+wmLtw0ybTiih+MtN3XPexs8DBzY4LXa8874zpTcOuHwktAFcVdnRETU3z/lG2BX1JxUru6YOvvqHcL+bcb6e3Y+kKaC0VAx0Ekw/N9iuFDCPKk1Y6xFgiwDXsM7g682s6YVwggXZA81PyQVI1ZDTeOU2oXwrWdSwTIrcP4QbmzW6riOtjikJL0TXwwlizDtwguaO4B/4ouVpBES7WzvgqP0iPmg71F1wnJ/g2tBB/bl38NggdqnvRs6BqJJ9U2onBeU1wt3oKCRk6pe6B4Kbrmw76Q8/aDOu8BLwCeHSXEeccQOqZDiNK81q8QfQKhgb3k8eBqBmsUhlfTOEBo6lRYHnJXkwDjeMzQoPrGQkbQ28CvCY0kX42tx/iC04ntcODzEi7uMwIITB3Xe+fqdE97xYCxEiYXnZgZPNdJOoc/jL4A/TXh/h4im1AvK2MW1VHC5iP46SHjSL3QddVrtpft03pv2wg9pcQLwETN7IHDsymKlRbnUI2lDfKJKWhaY2ZANFfMijUDNEtietMVJuwTqVWb2ZMJj2+WQOpdwwX0v8F9mNjdwfI3QjJ/HstRhdUR/qxeo8fNooGr4thwNBGsUj/24sAn9cQI1orPBpoCNqtNYY8vqCtv+hRE2bDvoHJn9BhSmMHK0wpFyHg1Js4Vvhx1xHuFtN5KyEPh2iuND3/fLQ9R+XYG4CHYSp0AjrgPenoMwBR8GFEKmL6uj9LcG4VF7VImm1Xn2BzxXKUUAhr5Sv4mPj5/piGY7okMbOKmwFR+T9+28e2HAqYeYR/JMv2wnob3U8hZkI0JTHopEAjUurNHy1h9x2E1o6FRSzkhZHKEdN5KvExbP+DxwfMr8+eH4SOC4TF9WR3R/lWjewNCo6CBH6c6BIVUDHq/ePOHDuzqi3Ru8dqJDFw60ltaHUtUewqH/PaDzH78MPPXVAsa0opd9OxgpmuGIrviWVEPdlXBHSdoPNDRjKgkvAFekHNPSP2BcX/bTgWt8No7fzYykXQnPPsn0ZX1355+do/THQcJzW0f0SL2gHBTof5sj+nyDUKjfGdrZiMY3ELSDtdX5RhS6M4CGhVyasr6koM4DK4vYjxBiW2+FQ2pEa6hJbaitzJAazDTgvzKsNxxnpAk+l7Q5YZ5NSP6+307Y1vHfZvb3gHFD0azm51B0Ex4/3Icj+hVwbF2qqYDRoB6LS/bVvfZKt8Y+t4r1fnJQKFSvsO8J+1sDJ1WsPdR6nFgZ7JhDOm/LErb0Ir66V1p2BP6RYd0hkXQosB++5saGDFSEevEmr4XAL1LYckeEVhhnLL41YGjbOmYkFaihd4W5AZWWWhV8O4P07SayOKSSfpkOD5w/t5CbOCQmVFObnjIsqyGO6O+gThuYw3+goXuAQwd5/G9dUFrrPetWFtooyvWC85II+wLY2MHFUSCqc0xZVdhRh3XeckvG054FcTeAdLyLnAWqpHHAlcBRCYccRvLEhJGy3V/pBYqakXTLH5zDGzBm2BTVDJwat2ZOQ5ZmhEmdRAcGrnF/4LhG/AAYsjdXE3LRQt7febOrEl0+yAH1Lkd0e4P00xsqRF9eUlrt9Trb6GtG9GeHPlnvgGrwcA4dc1jnLUHdUweRNI55MJ+SFNogcwXiIi23kVyYQrJSfTVGikNqRGjKw9FUoMZ/rNCMkJAPtBXZUv80sz8FjGvHHTEkpg4GlAkNR9JxpG8VU09uF40jutoRLa8TnhN82miJMh10R2OpEl3/4iobP2uK9l2mVTrqbKPfcugsR6T6wij9NlZhqMfQce/t/FNejfHuDRy3EXBeHicgaUd8JtJ+KYYZwxdTH8wbXUMdOQIV2In2OaSIg9LzTscbrk9UQ+JSgC39IknamOSdJgezfeC4+vXfBfwk4zSPZz2PGh/qvH5Bj8Zc5ogq/bn7pY0d0UtCLIrW6J0zaoOHneNfDpWqitYuq2OeQzOMaI4RHTi4MIr1a6s3O6Jt/1/nH67J63zN7AnCO2ieKOkLoWtLGi1pMr5CVNqU8MvMLFE7kvg7GhKZMJIypEaUQN0lw/yhd6jMTo46bg4MpN6CsKaBkNzUkaol8iA+kcVbLOkYfGWlLFvPCvn+rXittM6PX+nY4N9d0Wr3OKKqI3p3lehWr2na/T0adZGT1nDygnJJNO5lIzrZEV2woic/qlWzOuTIzps+2Du7I802Nymh2q6AyyT9SNJ6iQdJq0g6Hl+7dCo+Rz8Nz5BOwRgR2/1YsIcUC0qTWJSZJAI19AOdl8GzltdFWsFXUgqhHRlSWYK81wKujrsoJEbS5pJ+A1xDWBxlPc/m1Ra4xuRZU1+oKrqlq7Ta/q+MWv+lrmi1NRyl25dEq93VHa16UE2QGhGmiO5ozKuO6K2OaPtYkM41olsc0VlGdLgR7TZ/3bXvvWSLyV96ddIGWYqZDMV1ZEtGOQF4UdINkr4k6RBJm0l6i6RNJW0laXdJn5f0a3xBk6uAzQLWWgQcYWavpxjTTv/JcIx47RSSaSehGmqWO9SwlcNTcKWZzWx+WENa1YywngX4UJbQnPAjgcck/RL4fbwFHUBsutgcn1b6KbyHOa9KVqHb3WFx6GxDnwbGL+4YN36RjbukGnXs5zPwheTLQfsq+9E5L49e79JRVp1l0oKqddwvVafjqESR3oZzP48W2wESX/3qzB/kntpsZp2SLge+nGGaVYEPx49WUQY+amZpCxCFKlR5C9QRbz+FJgJV0iqEN8PK8kZmZxhbowvfNiSUlt+ZzawsaTrZumZugS/0cpak/+CjJLrix3p4G/gaGeYfjlwjMi7c6qQdQe8xRbOBPxo6CsDEgVV0N+gQw2+rnK+PMr3Sob1ktlNVHb7ts2wvEaEInBlS9JqD95347PeaVaPPwneATxAes9xqKsDHzez2gLGFhpqCZlv+7Qm3sWV5I3ls+c8O7b8da3Xt0sz/GLhOIzbGN+87FPgAcACtE6aQs/PwmzO/93gV/cERHVBVdIRTRFURVZWOrEalV5xE34PIVSJ93qHT+mymfa8JQ4tdFP1QEXu1WJhiZgvw6cMjf3QaFwAABZtJREFUkSpwtJndlHZgXNkppNXIwhZUdnpTCNQsDqksb+R5/FY4lOfwRZpD2ZzWO6Rq/DZwnZFA7sWRT5t54TOnzbzgS45ouyp6OHYybeFMz1VVl4svXWZWer+htU1RfU6UmaK/OOm/Db1csY68zBvDYmbXAOe0Y60U9ADHmNlvAsfvHTgu1+QcSZsQFmnwn6QFivKimUANtZ9k6kUfl4LL4pE9JWPBkLal2sY23rsyrLcyaVnDsynPnPeiU7S/k35aVYRJ4x3R4lgL7bZS6XInfaWBdiqH3lNFZ6tDN58y8/xWF9vpw8ym4J19I4HngX3NLEvM7b6B40ZKQH/byyQ2E6g7Bc6bxxsJ3TI8HLK9GUSoTfM/gV0VjwWCikJnJGvKaFcuZ9GA07eZ0uGIji6r4/CKSji0j5OmOTTHEV1TdvqUQ2Oc+uNN48pS0036iquO2eOUGee3s6VOjeMIa2WeJzcAu5pZVjvmPoHj8hZkoYpdntmEiRjSPhrbEXcMnPfOwHH1PEb6xntG8j5Rw7F/4LigZmSxp/hYfMX+LLGpSXkJuBD4Od7meidh7W1ey/Ok6nGK3mb+wjwO+Bnwuqt0HK+Oyu1Iz2F25KrS+mWVx8lF60WuYyHjmHvGI2d0t+qckhCnN58k6Ul80kRoBEcI0/Ap1iHOp0aElOzsJf8dV6hi13aBKrPGGYySIvwFk9ZzuRzY1MwyXWySDiG9YL7YzL6RZd147btJL1QNOMTMgr9MkvYEbgbeFjpHE+bhtadL6hv0SfoZXktOwzLgLSljGlNx6nZnRgbXgb5u8A4jOljYvAufnHLyaducOamq6B0XPjXlslatnxVJ2wIXAO9r8VJP4yMNfmtDXdABSJpH+rJ9vzKzT+Z1DvF5/Ip0dQrAfybb5fl5JGFIrSS+0/4Qb9hOynR84HBmzSUuTXcByYKmF8XHnpR13Zjz8cInKfOBb2YRpgBm9hC+JulZ5GcCqAC34muubmpmFzbodvo1/I4gKd3A5FYKU4Aq0Z6O6IwLnjx9jlP0Ryf9l5O+B3De02c8Gxkt9d5nxcyeMrMj8KmhF5JvmNlC4HJgHzPb1sxuaIHwmELy76EBfwK+mPM5gK9hnMa59DxwbLuFKQyjofYd4JvHDZfyNQZfz/MVfL+cXN9EnF45Hp/VE+EFxBL6BX03vrpT3usKX96s2ZbNgM4cq+bX1l8H+Dheu9kXWD3h0Aq+VOF9+OIdtycJH4vf7+74VsPDsRiYkaaubCgnbn/uGhfN+FYXwNd2OP8omX0H2OviGaeFtCtZ6UgqAe/El/zbF+9sSZo6ugR/03sQuBv4S97fuUZIWgt//Y1lxWvB8DuVBfjc/cUtPI818NE39a2wB58L+F31rHZ8PxvRVKAWrHziC3FL/I1tAj7tFPq/RAvxWvIsvHBfKV+mVvGVHS6MhD0g+KVB1yVPnBLasmREIWkUXnvdFH/DjPB/22V401kXPj15drsKJBdkI7eajAWtIy7g/Ez8eKOGWAXjFH1Y2J2Y/QrpSuBNIVDjG98MWtv2p6CNhHh2Cwraxhd2+r4cmuzQRZc+8c2FVVT64o4XNTNLFBSsFAqBWjCiceiDTvrHjx8/aR6AU/Qnp+i9K/u8CgoaUQjUghHLkdufri7XPblsri9Qfqn1/n6x6z5iZZ5XQcFQFAK1YMTS5bqP7HLd/7z68ZPm13537eOnLpjvlox5+7YntSMBoqAgFYVALRixLHbdk7ts2fcH/35+dclt811X2iy6goKWUwjUghHJNlt95ohu67nn7qemzh/8Wrf1/K7XKsW2v2DEUQjUgpHKZGAF7RTg6ZlXzwdW32arzxRhfwUjikKgFow4ttnqM4cD9z098+oFwxx2J3Bwe86ooCAZhUAtGImcAFzc5JjfEdaorqCgZfx/v2CTW+S1eMcAAAAASUVORK5CYII=)

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

**最后效果**

![](https://pic.imgdb.cn/item/63240a4916f2c2beb1eb646d.jpg)

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

~~~xml
<!-- 根标签  project表示对当前的工程进行配置-->
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">

 <!-- modelVersion 具体的字标签 从Maven2开始就是固定的4.0.0 -->
 <!-- 表示当前pom.xml所采用的的标签结构 -->
  <modelVersion>4.0.0</modelVersion>

  <!-- 坐标信息 也有的叫gav首字母-->
  <!-- groupId 代表的是公司或者组织开发的某一个项目-->
  <groupId>com.liyouxiu.maven</groupId>
  <!--artifactId 代表的是项目的某一个模块  -->
  <artifactId>pro_maven_java</artifactId>
  <!-- version 代表当前模块的版本 -->
  <version>1.0-SNAPSHOT</version>

  <!-- packaging 打包方式 -->
  <!-- 取值是 jar 生成 jar包 说明这是一个java工程-->
  <!-- 取值是 war 生成 war 包 说明这是一个Web工程-->
  <!-- 取值 pom ：说明这个工程用来管理其他工程的工程 -->
  <packaging>jar</packaging>

  <name>pro_maven_java</name>
  <url>http://maven.apache.org</url>

  <!-- 定义我们的属性值 -->
  <properties>
    <!-- project.build.sourceEncoding 在构建过程中我们读取源码时使用的字符集-->
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  </properties>

  <!-- dependencies 来配置我们具体的依赖信息  可以包含多个dependency-->
  <dependencies>
    <!-- dependency 配置具体的依赖信息 -->
    <dependency>
      <!-- 坐标信息 你想要导入那个jar包就配置他的坐标信息即可 -->
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
      <!-- scope 配置当前依赖的范围 -->
      <scope>test</scope>
    </dependency>
  </dependencies>
</project>
~~~

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

# 第六节 实验二：在 Maven 工程中编写代码

## 1、主体程序

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img012.0bcc2c5d.png)

主体程序指的是被测试的程序，同时也是将来在项目中真正要使用的程序。

```java
package com.liyouxiu.maven;
	
public class Calculator {
	
	public int sum(int i, int j){
		return i + j;
	}
	
}
```

## 2、测试程序

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img013.8b57a581.png)

```java
package test.java.com.liyouxiu.maven;
	
import org.junit.Test;
import main.java.com.liyouxiu.maven.Calculator;
	
// 静态导入的效果是将Assert类中的静态资源导入当前类
// 这样一来，在当前类中就可以直接使用Assert类中的静态资源，不需要写类名
import static org.junit.Assert.*;
	
public class CalculatorTest{
	
	@Test
	public void testSum(){
		
		// 1.创建Calculator对象
		Calculator calculator = new Calculator();
		
		// 2.调用Calculator对象的方法，获取到程序运行实际的结果
		int actualResult = calculator.sum(5, 3);
		
		// 3.声明一个变量，表示程序运行期待的结果
		int expectedResult = 8;
		
		// 4.使用断言来判断实际结果和期待结果是否一致
		// 如果一致：测试通过，不会抛出异常
		// 如果不一致：抛出异常，测试失败
		assertEquals(expectedResult, actualResult);

        System.out.println("test method been called");
		
	}
	
}
```

**注意代码路径不要报错**

# 第七节 实验三：执行 Maven 的构建命令

## 1、要求

运行 Maven 中和构建操作相关的命令时，必须进入到 pom.xml 所在的目录。如果没有在 pom.xml 所在的目录运行 Maven 的构建命令，那么会看到下面的错误信息：

```java
The goal you specified requires a project to execute but there is no POM in this directory
```

mvn -v 命令和构建操作无关，只要正确配置了 PATH，在任何目录下执行都可以。而构建相关的命令要在 pom.xml 所在目录下运行——操作哪个工程，就进入这个工程的 pom.xml 目录。

## 2、清理操作

mvn clean

效果：删除 target 目录

![](https://pic.imgdb.cn/item/63242ce016f2c2beb1247a03.jpg)

## 3、编译操作

主程序编译：mvn compile

测试程序编译：mvn test-compile

主体程序编译结果存放的目录：target/classes

测试程序编译结果存放的目录：target/test-classes

![](https://pic.imgdb.cn/item/63242b8416f2c2beb121e8d4.jpg)

## 4、测试操作

mvn test

测试的报告存放的目录：target/surefire-reports

![](https://pic.imgdb.cn/item/63242e7c16f2c2beb127b722.jpg)

## 5、打包操作

mvn package

打包的结果——jar 包，存放的目录：target

![](https://pic.imgdb.cn/item/6324306a16f2c2beb12b0f88.jpg)

## 6、安装操作

mvn install

```log
[INFO] Installing D:\maven-workspace\space201026\pro01-maven-java\target\pro01-maven-java-1.0-SNAPSHOT.jar to D:\maven-rep1026\com\atguigu\maven\pro01-maven-java\1.0-SNAPSHOT\pro01-maven-java-1.0-SNAPSHOT.jar
[INFO] Installing D:\maven-workspace\space201026\pro01-maven-java\pom.xml to D:\maven-rep1026\com\atguigu\maven\pro01-maven-java\1.0-SNAPSHOT\pro01-maven-java-1.0-SNAPSHOT.pom
```

安装的效果是将本地构建过程中生成的 jar 包存入 Maven 本地仓库。这个 jar 包在 Maven 仓库中的路径是根据它的坐标生成的。

坐标信息如下：

```xml
  <groupId>com.atguigu.maven</groupId>
  <artifactId>pro01-maven-java</artifactId>
  <version>1.0-SNAPSHOT</version>
```

在 Maven 仓库中生成的路径如下：

```log
D:\maven-rep1026\com\atguigu\maven\pro01-maven-java\1.0-SNAPSHOT\pro01-maven-java-1.0-SNAPSHOT.jar
```

另外，安装操作还会将 pom.xml 文件转换为 XXX.pom 文件一起存入本地仓库。所以我们在 Maven 的本地仓库中想看一个 jar 包原始的 pom.xml 文件时，查看对应 XXX.pom 文件即可，它们是名字发生了改变，本质上是同一个文件。

![](https://pic.imgdb.cn/item/632431ed16f2c2beb12db6a5.jpg)

# 第八节 实验四：创建 Maven 版的 Web 工程 

## 1、说明

使用 mvn archetype:generate 命令生成 Web 工程时，需要使用一个专门的 archetype。这个专门生成 Web 工程骨架的 archetype 可以参照官网看到它的用法：

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img014.942770a3.png)

参数 archetypeGroupId、archetypeArtifactId、archetypeVersion 用来指定现在使用的 maven-archetype-webapp 的坐标。

## 2、操作

注意：如果在上一个工程的目录下执行 mvn archetype:generate 命令，那么 Maven 会报错：不能在一个非 pom 的工程下再创建其他工程。所以不要再刚才创建的工程里再创建新的工程，**请回到工作空间根目录**来操作。

然后运行生成工程的命令：

```log
mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-webapp -DarchetypeVersion=1.4
```

下面的操作按照提示执行：

TIP

Define value for property 'groupId': com.atguigu.maven Define value for property 'artifactId': pro02-maven-web Define value for property 'version' 1.0-SNAPSHOT: :【直接回车，使用默认值】

Define value for property 'package' com.atguigu.maven: :【直接回车，使用默认值】 Confirm properties configuration: groupId: com.atguigu.maven artifactId: pro02-maven-web version: 1.0-SNAPSHOT package: com.atguigu.maven Y: :【直接回车，表示确认】

## 3、生成的pom.xml

确认打包的方式是war包形式

```xml
<packaging>war</packaging>
```

## 4、生成的Web工程的目录结构

![./images](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAALMAAAB7CAIAAACwzSZ9AAAKpklEQVR42u2df2ybRxnHzyT5AxptY2lJ0NakSZ2gVGZ/ACIjoYAmgRYn7bKBjFppRJOQI7GJRINIoLitWjkCVlY1qIBqIdFqUiSiKaq2JaZUqoamRstYxyhRVdWmSZo1S2k7OihDIr+49733x72vn/Pr2H7f997wfCpZzvX12X7vk+fOzn3t0Pr6OkGQHEJoBgKCZiAwoYtLaAYCgGYgMGgGAoNmIDDlN6P55l5lVav8I8olW+HqV+jFf6saFz99wu8njjhQfjPCS3vue+jbigtkTRGBXipemJd35l+db5j0+4kjDrhgxvt77ns4JtKCttyZm5jfgWaUQna0u3n2+fWhx1y8j/KbsfP9Pfc//C2RFvTK7fn0dbfMSA/XRceVK+0/ePPC/h1q2/m+z+9PEVtjsPHVDLosCIVC+VtAdi5SM74p0oJeuT2Xvt6Ydul8ndub+W08rNpAfrF0soO60n31O6/1byeEaww6/pnx6u9OzWWufO9HyYrKStayurLyq58mGltau2O9+XtsutH9wPanRFrQK7dmzy40uWDG3Mgzj17+rjbw4LmjFSXZuBnKhk9mrK2u/vInQ399Z/qzn2tjcjAtWMuzPx7+WEVFnh5VM54UaUErz625PwjMYE94kuxnMwJ5apQ9ea79C8fPKAXAmDUoca0M0JKQ7rl4tJO1XhgM/aZZrR8GwpqhGjMaO7d/4BK7U6JNQI8c0XtQtFP+V39UXH0iZCHV0fNKzPbA9NuqnR+JvHjQ2iEH91CVmxP2rOmjPbZL0KfoRLlsBmVlefnXPzvAVIj/8FDq54d5UfL32PQeNeMJkRZqzTi3sPP3IjNefJsbaW0gre3qmcoap1g/rJ4OTyYhNEMd2jB8BtVTz5xji5KnJ5V+zCKUHR2c2H3UOiWZI2f8BvM1iW+Mjpsdjn09p2gtGI/8fN8zx2bI3tP0YeuPPwP1KTpR7ptB9OmDCvGJLdUf/ftegVpQGhe6Pln/hEiL9bXlW3OvLza+vFZRDZrBFUnLiTDbzSGxHkaENUM59QcJt/y0LVT5ERVdZ51MqTePaysY9r9EF8hc6mqov+K2oe0lJ9g9cg9A74EMdsw/m5h9ji6Mut5gR14D+ySCE+WJGbwchWuhmbF9D6gFvX538eLqyn8+qmq59dAL5TNDP4lmu3kTqsj3yaRhDISTGcrIDRBWpbjVDJPvCOk9SE5ry17LA8vt3DAj94nTds6J52PnjpEjrIYBfWZ9NoPJkR4fffzJfZVVVQX2uON614P13aAWtOXvs+drtrffWZh6L5w7oahFslUbRfV3NGLMJtwzz5lN7FWda7QsS4s1g3OOe1TqDPXc5TCZaTxhHK+vEhRv+shRrrTkM0Pp9uAr5FKrMqew62xOEfQpOlEemlEEO+ajDzZ0gVrQy5vXztc2PUYvbzSfBc2YbY2Pv8Tqp7GwyP2dgFaghF8n8nOwpRpDizXH2YTN68qhjzwdJy8R/hWQMULWB2DcUUFmWJZBtuUI0KfoRJWT8pvRMB+tqe8UvTt+89rrtU1fo5c3WgRmuPxiDCkQF8yYi9Y0PC56d3zp2h/rmr5KLxfRDLkpvxn1c9GtDd8QvTu+9Lc36nbuppeLn0EzpMYFM2Y7ta2l6/pf4Pk/ypP1EAmtVWxZCo+Xci+I2+DOHQQGzUBg0AwEBs1AYDCJhMCgGQgMmoHAoBkIjHdm/OuSQw6l4uON90cwhyIL3pnxz78451BqvohpA1nw0Ix3nXMoNW1ohix4Z8aH7zrnULaiGdKwYTOKzqF8+GfnHMrWR93IoSDFsDEzTp06deXKlWQyWanvCV1ZWUkkEq2trb29DjmUu+8451C2fQnNkIUNmLG6ujo0NDQ9Pd3W1sbkYFqwluHh4Yq8ORTVDIccisiM7EhH84C2b3ty/WSn2nA5MUmi0VT78cyF/jBJ94WiWkaRNSClsbGasby8fODAAabCoUOHDh8+zIuS/7Z3LzrnULa1QzkUpoEihKVpYIpZQlG0mEEhysqG1xlGnaiurr53716BWlD+8bZzDmVb28uhytwcCqsHfC2wykL/P7kLvSgvxbw24SeRArUgzAynHErFlpYHIi8IOmB1gvmBZrhOka9aqRyjo6P79u2rKjiH8sGfCsqhfKojZ0LJjoxk+vs7CVcqbBOMUlSINrWkR0aa+1GSkvHu/YwP3iooh1L75dydw9zyUlta5Cw9zDWqsfhASsI7M+68VVAOpXb32dLvCykdD82YLiiHUodmyIF3ZtyeLiiHUvcVNEMKPDTjTeccSqhyS2075lCkAHfuIDBoBgKDZiAwaAYCg2YgMGgGAoNmIDBoBgLjvxmYQ5ET/83AHIqcSGCGxzkU5e/1YzHc5+OE/2Z4nUNBMwqjbGZgDmWTUR4zMIey+SiDGf7lUNSdwZOxsaiyz0/Z5Ue0XYHmNvOcpAq3UVC9+fHIwID1JohKeWqGPzkUtj2UDSnbKcrHlNi1vomuk+qAG5uILWZEU+ZNcPFhoWzrDJ9yKEaaQHQ9p2rYaoZ2GG3tJafRDJNyvjbxPIfiZAZRpCBsmgACCWhGPsr8qtXTHIqjGRmzTa0cEawZheP/+xkl5FAcZxNzJmmPx0mKYM0oHP/NwByKnEhgBuZQpMR/MzCHIicSmIE5FCnx3wxETtAMBAbNQGDQDAQGzUBg0AwEBs1AYNAMBEZeMzCH4i/ymoE5FH+R2AzvcijAx1cj8prhYQ4FzQBw3Ywg5FDQDAB3zQhIDgXNAHDRDL9yKNwmPu7zyM3W3G9C4b4tRW03P6A6N64iPFjcSTBxt2b4kkPhN3p2JGdI7DTLo9g3DVu3k5vflmLqBMVViPhguD2ouL7O8CGHoo846eu4Opi43Ht18ELXBNsAnDHqhYZaNoh1NrFMLoKvY8o9OJunkyDixWsTz3MobCM450QiNpYkfOkI24+HBrUZiqugGeXF2xyKqsYYmYpoI0avsznFVuXTfX3kpD4RRLj1AvshDcVVRAcL24OKvO9nlPJ9KJaRsWVWRYvKSDyVsq0dobhK3oOh9qAirxmy5lBE00Tgpw8bEpshaQ4FzfAbWXMoaIbfYA7FX+Q1A/EXNAOBQTMQGDQDgUEzEBg0A4FBMxAYNAOBCZ4ZmEPxhuCZgTkUbwigGR5/H8r/K8Ezo+gcim1rJrBtQ/mxa8LYvqEQN/YXm7sExR9eb9/rM2U91PxvbpMIkfTT8ANoRtE5FODjyM0x4T+ROvdPprbPoRVt/rWZoWzkmeE2F1rNkPwPs8Ezo/gciqVK0FE6Q+Ip0mNs62KfIZx1NCPPqNrNSGR2JbnChGa4Sgnfh8KNhyJGjzJu9m2/jmbkG1TgsGZu3yGa4SolfB+KOSCqGOqw9ep7ys/0GLtGzRUAHx/Z+DrDdM2+5dhyL1IuMwJoRgnfh2JMGnr8JKz93HLUoSRYlijmQsMQRhtcQWnR3eg5gzXDRUrIoRBzFtG/mMD+cyFmEDi1QvJMOsyNuLEgRTNcoJQcCtFXnjO7Bs0CYPl5QzUD6FxUe7T5o/04muEWJeVQCOG/PQ362brO4KYJLvUozJLkXahmwcibtATPDFlzKJuNAJohaQ5lsxE8M2TNoWw2AmgG5lA8IXhmIN6AZiAwaAYCg2YgMP8DCKejFGc0blMAAAAASUVORK5CYII=)

webapp 目录下有 index.jsp

WEB-INF 目录下有 web.xml

## 5、创建 Servlet

### ①在 main 目录下创建 java 目录

![./images](data:image/png;base64,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)

### ②在 java 目录下创建 Servlet 类所在的包的目录

![./images](data:image/png;base64,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)

### ③在包下创建 Servlet 类

```java
package main.java.com.liyouxiu.maven;
	
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
	
public class HelloServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().write("hello maven web");
		
	}
	
}
```

### ④在 web.xml 中注册 Servlet

```xml
  <servlet>
	<servlet-name>helloServlet</servlet-name>
	<servlet-class>com.atguigu.maven.HelloServlet</servlet-class>
  </servlet>
  <servlet-mapping>
	<servlet-name>helloServlet</servlet-name>
	<url-pattern>/helloServlet</url-pattern>
  </servlet-mapping>
```

## 6、在 index.jsp 页面编写超链接

```html
<html>
<body>
<h2>Hello World!</h2>
<a href="helloServlet">Access Servlet</a>
</body>
</html>
```

JSP全称是 Java Server Page，和 Thymeleaf 一样，是服务器端页面渲染技术。这里我们不必关心 JSP 语法细节，编写一个超链接标签即可。

## 7、编译

此时直接执行 mvn compile 命令出错：

DANGER

程序包 javax.servlet.http 不存在

程序包 javax.servlet 不存在

找不到符号

符号: 类 HttpServlet

……

上面的错误信息说明：我们的 Web 工程用到了 HttpServlet 这个类，而 HttpServlet 这个类属于 servlet-api.jar 这个 jar 包。此时我们说，Web 工程需要依赖 servlet-api.jar 包。

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img018.f836f056.png)

## 8、配置对 servlet-api.jar 包的依赖

对于不知道详细信息的依赖可以到https://mvnrepository.com/网站查询。使用关键词搜索，然后在搜索结果列表中选择适合的使用。

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img019.46741083.png)

比如，我们找到的 servlet-api 的依赖信息：

```xml
<!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>3.1.0</version>
    <scope>provided</scope>
</dependency>
```

这样就可以把上面的信息加入 pom.xml。重新执行 mvn compile 命令。

![](https://pic.imgdb.cn/item/632481aa16f2c2beb1aae49c.jpg)

## 9、将 Web 工程打包为 war 包

运行 mvn package 命令，生成 war 包的位置如下图所示：

![./images](data:image/png;base64,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)

![](https://pic.imgdb.cn/item/6324820b16f2c2beb1abac03.jpg)

## 10、将 war 包部署到 Tomcat 上运行

将 war 包复制到 Tomcat/webapps 目录下

![./images](data:image/png;base64,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)

启动 Tomcat：

![./images](data:image/png;base64,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)

![./images](data:image/png;base64,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)

通过浏览器尝试访问：http://localhost:8080/pro-maven-web/index.jsp

# 第九节 实验五：让 Web 工程依赖 Java 工程

## 1、观念

明确一个意识：从来只有 Web 工程依赖 Java 工程，没有反过来 Java 工程依赖 Web 工程。本质上来说，Web 工程依赖的 Java 工程其实就是 Web 工程里导入的 jar 包。最终 Java 工程会变成 jar 包，放在 Web 工程的 WEB-INF/lib 目录下。

## 2、操作

在 pro02-maven-web 工程的 pom.xml 中，找到 dependencies 标签，在 dependencies 标签中做如下配置：

```xml
<!-- 配置对Java工程pro01-maven-java的依赖 -->
<!-- 具体的配置方式：在dependency标签内使用坐标实现依赖 -->
<dependency>
	<groupId>com.liyouxiu.maven</groupId>
	<artifactId>pro_maven_java</artifactId>
	<version>1.0-SNAPSHOT</version>
</dependency>
```

## 3、在 Web 工程中，编写测试代码

### ①补充创建目录

pro_maven_web**\src\test\java\com\atguigu\maven**

### ②确认 Web 工程依赖了 junit

```xml
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
      <scope>test</scope>
    </dependency>
```

### ③创建测试类

把 Java 工程的 CalculatorTest.java 类复制到 pro02-maven-wb**\src\test\java\com\atguigu\maven** 目录下

## 4、执行Maven命令

### ①测试命令

mvn test

说明：测试操作中会提前自动执行编译操作，测试成功就说明编译也是成功的。

### ②打包命令

mvn package

通过查看 war 包内的结构，我们看到被 Web 工程依赖的 Java 工程确实是会变成 Web 工程的 WEB-INF/lib 目录下的 jar 包。

![./images](data:image/png;base64,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)

### ③查看当前 Web 工程所依赖的 jar 包的列表

mvn dependency:list

[INFO] The following files have been resolved:
[INFO]    org.hamcrest:hamcrest-core:jar:1.3:test
[INFO]    javax.servlet:javax.servlet-api:jar:3.1.0:provided
[INFO]    com.liyouxiu.maven:pro_maven_java:jar:1.0-SNAPSHOT:compile
[INFO]    junit:junit:jar:4.12:test

说明：javax.servlet:javax.servlet-api:jar:3.1.0:provided 格式显示的是一个 jar 包的坐标信息。格式是：

groupId:artifactId:打包方式:version:依赖的范围

这样的格式虽然和我们 XML 配置文件中坐标的格式不同，但是本质上还是坐标信息，大家需要能够认识这样的格式，将来从 Maven 命令的日志或错误信息中看到这样格式的信息，就能够识别出来这是坐标。进而根据坐标到Maven 仓库找到对应的jar包，用这样的方式解决我们遇到的报错的情况。

### ④以树形结构查看当前 Web 工程的依赖信息

mvn dependency:tree

[INFO] com.atguigu.maven:pro02-maven-web:war:1.0-SNAPSHOT
[INFO] +- junit:junit:jar:4.12:test
[INFO] | \- org.hamcrest:hamcrest-core:jar:1.3:test
[INFO] +- javax.servlet:javax.servlet-api:jar:3.1.0:provided
[INFO] \- com.atguigu.maven:pro01-maven-java:jar:1.0-SNAPSHOT:compile

我们在 pom.xml 中并没有依赖 hamcrest-core，但是它却被加入了我们依赖的列表。原因是：junit 依赖了hamcrest-core，然后基于依赖的传递性，hamcrest-core 被传递到我们的工程了。

# 第十节 实验六：测试依赖的范围

## 1、依赖范围

标签的位置：dependencies/dependency/**scope**

标签的可选值：**compile**/**test**/**provided**/system/runtime/**import**

### ①compile 和 test 对比

|         | main目录（空间） | test目录（空间） | 开发过程（时间） | 部署到服务器（时间） |
| ------- | ---------------- | ---------------- | ---------------- | -------------------- |
| compile | 有效             | 有效             | 有效             | 有效                 |
| test    | 无效             | 有效             | 有效             | 无效                 |

### ②compile 和 provided 对比

|          | main目录（空间） | test目录（空间） | 开发过程（时间） | 部署到服务器（时间） |
| -------- | ---------------- | ---------------- | ---------------- | -------------------- |
| compile  | 有效             | 有效             | 有效             | 有效                 |
| provided | 有效             | 有效             | 有效             | 无效                 |

### ③结论

compile：通常使用的第三方框架的 jar 包这样在项目实际运行时真正要用到的 jar 包都是以 compile 范围进行依赖的。比如 SSM 框架所需jar包。

test：测试过程中使用的 jar 包，以 test 范围依赖进来。比如 junit。

provided：在开发过程中需要用到的“服务器上的 jar 包”通常以 provided 范围依赖进来。比如 servlet-api、jsp-api。而这个范围的 jar 包之所以不参与部署、不放进 war 包，就是避免和服务器上已有的同类 jar 包产生冲突，同时减轻服务器的负担。说白了就是：“**服务器上已经有了，你就别带啦！**”

## 2、测试

### ①验证 compile 范围对 main 目录有效

main目录下的类：HelloServlet 使用compile范围导入的依赖：pro_liyouxiu_maven

验证：使用compile范围导入的依赖对main目录下的类来说是有效的

有效：HelloServlet 能够使用 pro_liyouxiu_maven 工程中的 Calculator 类

验证方式：在 HelloServlet 类中导入 Calculator 类，然后编译就说明有效。

### ②验证test范围对main目录无效

测试方式：在主体程序中导入org.junit.Test这个注解，然后执行编译。

具体操作：在pro-maven-java\src\main\java\com\atguigu\maven目录下修改Calculator.java

```java
package com.liyouxiu.maven;

import org.junit.Test;

public class Calculator {
	
	public int sum(int i, int j){
		return i + j;
	}
	
}
```

执行Maven编译命令：

```java
[ERROR] /D:/maven-workspace/space201026/pro01-maven-java/src/main/java/com/atguigu/maven/Calculator.java:[3,17] 程序包org.junit不存在
```

### ③验证test和provided范围不参与服务器部署

其实就是验证：通过compile范围依赖的jar包会放入war包，通过test范围依赖的jar包不会放入war包。

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img026.0ad36150.png)

### ④验证provided范围对测试程序有效

测试方式是在pro02-maven-web的测试程序中加入servlet-api.jar包中的类。

修改：**pro02-maven-web**\src\**test**\java\com\atguigu\maven\**CalculatorTest.java**

```java
package com.atguigu.maven;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import org.junit.Test;
import com.atguigu.maven.Calculator;

// 静态导入的效果是将Assert类中的静态资源导入当前类
// 这样一来，在当前类中就可以直接使用Assert类中的静态资源，不需要写类名
import static org.junit.Assert.*;

public class CalculatorTest{
	
	@Test
	public void testSum(){
		
		// 1.创建Calculator对象
		Calculator calculator = new Calculator();
		
		// 2.调用Calculator对象的方法，获取到程序运行实际的结果
		int actualResult = calculator.sum(5, 3);
		
		// 3.声明一个变量，表示程序运行期待的结果
		int expectedResult = 8;
		
		// 4.使用断言来判断实际结果和期待结果是否一致
		// 如果一致：测试通过，不会抛出异常
		// 如果不一致：抛出异常，测试失败
		assertEquals(expectedResult, actualResult);
		
	}
	
}
```

然后运行Maven的编译命令：mvn compile

然后看到编译成功。

# 第十一节 实验七：测试依赖的传递性

## 1、依赖的传递性

### ①概念

A 依赖 B，B 依赖 C，那么在 A 没有配置对 C 的依赖的情况下，A 里面能不能直接使用 C？

### ②传递的原则

在 A 依赖 B，B 依赖 C 的前提下，C 是否能够传递到 A，取决于 B 依赖 C 时使用的依赖范围。

- B 依赖 C 时使用 compile 范围：可以传递
- B 依赖 C 时使用 test 或 provided 范围：不能传递，所以需要这样的 jar 包时，就必须在需要的地方明确配置依赖才可以。

## 2、使用 compile 范围依赖 spring-core

测试方式：让 pro01-maven-java 工程依赖 spring-core

具体操作：编辑 pro01-maven-java 工程根目录下 pom.xml

```xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-core -->
<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-core</artifactId>
	<version>4.0.0.RELEASE</version>
</dependency>
```

使用 mvn dependency:tree 命令查看效果：

[INFO] com.atguigu.maven:pro01-maven-java:jar:1.0-SNAPSHOT
[INFO] +- junit:junit:jar:4.12:test
[INFO] | \- org.hamcrest:hamcrest-core:jar:1.3:test
[INFO] \- org.springframework:spring-core:jar:4.0.0.RELEASE:compile
[INFO] \- commons-logging:commons-logging:jar:1.1.1:compile

还可以在 Web 工程中，使用 mvn dependency:tree 命令查看效果（需要重新将 pro01-maven-java 安装到仓库）：[INFO] com.atguigu.maven:pro02-maven-web:war:1.0-SNAPSHOT
[INFO] +- junit:junit:jar:4.12:test
[INFO] | \- org.hamcrest:hamcrest-core:jar:1.3:test
[INFO] +- javax.servlet:javax.servlet-api:jar:3.1.0:provided
[INFO] \- com.atguigu.maven:pro01-maven-java:jar:1.0-SNAPSHOT:compile
[INFO] \- org.springframework:spring-core:jar:4.0.0.RELEASE:compile
[INFO] \- commons-logging:commons-logging:jar:1.1.1:compile

## 3、验证 test 和 provided 范围不能传递

从上面的例子已经能够看到，pro01-maven-java 依赖了 junit，但是在 pro02-maven-web 工程中查看依赖树的时候并没有看到 junit。

要验证 provided 范围不能传递，可以在 pro01-maven-java 工程中加入 servlet-api 的依赖。

```xml
<dependency>
	<groupId>javax.servlet</groupId>
	<artifactId>javax.servlet-api</artifactId>
	<version>3.1.0</version>
	<scope>provided</scope>
</dependency>
```

效果还是和之前一样：[INFO] com.atguigu.maven:pro02-maven-web:war:1.0-SNAPSHOT
[INFO] +- junit:junit:jar:4.12:test
[INFO] | \- org.hamcrest:hamcrest-core:jar:1.3:test
[INFO] +- javax.servlet:javax.servlet-api:jar:3.1.0:provided
[INFO] \- com.atguigu.maven:pro01-maven-java:jar:1.0-SNAPSHOT:compile
[INFO] \- org.springframework:spring-core:jar:4.0.0.RELEASE:compile
[INFO] \- commons-logging:commons-logging:jar:1.1.1:compile

# 第十二节 实验七：测试依赖的传递性

## 1、依赖的传递性

### ①概念

A 依赖 B，B 依赖 C，那么在 A 没有配置对 C 的依赖的情况下，A 里面能不能直接使用 C？

### ②传递的原则

在 A 依赖 B，B 依赖 C 的前提下，C 是否能够传递到 A，取决于 B 依赖 C 时使用的依赖范围。

- B 依赖 C 时使用 compile 范围：可以传递
- B 依赖 C 时使用 test 或 provided 范围：不能传递，所以需要这样的 jar 包时，就必须在需要的地方明确配置依赖才可以。

## 2、使用 compile 范围依赖 spring-core

测试方式：让 pro01-maven-java 工程依赖 spring-core

具体操作：编辑 pro01-maven-java 工程根目录下 pom.xml

```xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-core -->
<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-core</artifactId>
	<version>4.0.0.RELEASE</version>
</dependency>
```

使用 mvn dependency:tree 命令查看效果：

[INFO] com.atguigu.maven:pro01-maven-java:jar:1.0-SNAPSHOT
[INFO] +- junit:junit:jar:4.12:test
[INFO] | \- org.hamcrest:hamcrest-core:jar:1.3:test
[INFO] \- org.springframework:spring-core:jar:4.0.0.RELEASE:compile
[INFO] \- commons-logging:commons-logging:jar:1.1.1:compile

还可以在 Web 工程中，使用 mvn dependency:tree 命令查看效果（需要重新将 pro01-maven-java 安装到仓库）：

[INFO] com.atguigu.maven:pro02-maven-web:war:1.0-SNAPSHOT
[INFO] +- junit:junit:jar:4.12:test
[INFO] | \- org.hamcrest:hamcrest-core:jar:1.3:test
[INFO] +- javax.servlet:javax.servlet-api:jar:3.1.0:provided
[INFO] \- com.atguigu.maven:pro01-maven-java:jar:1.0-SNAPSHOT:compile
[INFO] \- org.springframework:spring-core:jar:4.0.0.RELEASE:compile
[INFO] \- commons-logging:commons-logging:jar:1.1.1:compile

## 3、验证 test 和 provided 范围不能传递

从上面的例子已经能够看到，pro01-maven-java 依赖了 junit，但是在 pro02-maven-web 工程中查看依赖树的时候并没有看到 junit。

要验证 provided 范围不能传递，可以在 pro01-maven-java 工程中加入 servlet-api 的依赖。

```xml
<dependency>
	<groupId>javax.servlet</groupId>
	<artifactId>javax.servlet-api</artifactId>
	<version>3.1.0</version>
	<scope>provided</scope>
</dependency>
```

效果还是和之前一样：

[INFO] com.atguigu.maven:pro02-maven-web:war:1.0-SNAPSHOT
[INFO] +- junit:junit:jar:4.12:test
[INFO] | \- org.hamcrest:hamcrest-core:jar:1.3:test
[INFO] +- javax.servlet:javax.servlet-api:jar:3.1.0:provided
[INFO] \- com.atguigu.maven:pro01-maven-java:jar:1.0-SNAPSHOT:compile
[INFO] \- org.springframework:spring-core:jar:4.0.0.RELEASE:compile
[INFO] \- commons-logging:commons-logging:jar:1.1.1:compile

# 第十三节 实验八：测试依赖的排除

## 1、概念

当 A 依赖 B，B 依赖 C 而且 C 可以传递到 A 的时候，A 不想要 C，需要在 A 里面把 C 排除掉。而往往这种情况都是为了避免 jar 包之间的冲突。

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img027.2faff879.png)

所以配置依赖的排除其实就是阻止某些 jar 包的传递。因为这样的 jar 包传递过来会和其他 jar 包冲突。

## 2、配置方式

```xml
<dependency>
	<groupId>com.atguigu.maven</groupId>
	<artifactId>pro01-maven-java</artifactId>
	<version>1.0-SNAPSHOT</version>
	<scope>compile</scope>
	<!-- 使用excludes标签配置依赖的排除	-->
	<exclusions>
		<!-- 在exclude标签中配置一个具体的排除 -->
		<exclusion>
			<!-- 指定要排除的依赖的坐标（不需要写version） -->
			<groupId>commons-logging</groupId>
			<artifactId>commons-logging</artifactId>
		</exclusion>
	</exclusions>
</dependency>
```

## 3、测试

测试的方式：在 pro02-maven-web 工程中配置对 commons-logging 的排除

```xml
<dependency>
	<groupId>com.atguigu.maven</groupId>
	<artifactId>pro01-maven-java</artifactId>
	<version>1.0-SNAPSHOT</version>
	<scope>compile</scope>
	<!-- 使用excludes标签配置依赖的排除	-->
	<exclusions>
		<!-- 在exclude标签中配置一个具体的排除 -->
		<exclusion>
			<!-- 指定要排除的依赖的坐标（不需要写version） -->
			<groupId>commons-logging</groupId>
			<artifactId>commons-logging</artifactId>
		</exclusion>
	</exclusions>
</dependency>
```

运行 mvn dependency:tree 命令查看效果：

[INFO] com.atguigu.maven:pro02-maven-web:war:1.0-SNAPSHOT
[INFO] +- junit:junit:jar:4.12:test
[INFO] | \- org.hamcrest:hamcrest-core:jar:1.3:test
[INFO] +- javax.servlet:javax.servlet-api:jar:3.1.0:provided
[INFO] \- com.atguigu.maven:pro01-maven-java:jar:1.0-SNAPSHOT:compile
[INFO] \- org.springframework:spring-core:jar:4.0.0.RELEASE:compile

发现在 spring-core 下面就没有 commons-logging 了。

# 第十四节 实验九：继承

## 1、概念

Maven工程之间，A 工程继承 B 工程

- B 工程：父工程
- A 工程：子工程

本质上是 A 工程的 pom.xml 中的配置继承了 B 工程中 pom.xml 的配置。

## 2、作用

在父工程中统一管理项目中的依赖信息，具体来说是管理依赖信息的版本。

它的背景是：

- 对一个比较大型的项目进行了模块拆分。
- 一个 project 下面，创建了很多个 module。
- 每一个 module 都需要配置自己的依赖信息。

它背后的需求是：

- 在每一个 module 中各自维护各自的依赖信息很容易发生出入，不易统一管理。
- 使用同一个框架内的不同 jar 包，它们应该是同一个版本，所以整个项目中使用的框架版本需要统一。
- 使用框架时所需要的 jar 包组合（或者说依赖信息组合）需要经过长期摸索和反复调试，最终确定一个可用组合。这个耗费很大精力总结出来的方案不应该在新的项目中重新摸索。

通过在父工程中为整个项目维护依赖信息的组合既**保证了整个项目使用规范、准确的 jar 包**；又能够将**以往的经验沉淀**下来，节约时间和精力。

## 3、举例

在一个工程中依赖多个 Spring 的 jar 包

[INFO] +- org.springframework:**spring-core**:jar:**4.0.0**.RELEASE:compile
[INFO] | \- commons-logging:commons-logging:jar:1.1.1:compile
[INFO] +- org.springframework:**spring-beans**:jar:**4.0.0**.RELEASE:compile
[INFO] +- org.springframework:**spring-context**:jar:**4.0.0**.RELEASE:compile
[INFO] +- org.springframework:**spring-expression**:jar:4.0.0.RELEASE:compile
[INFO] +- org.springframework:**spring-aop**:jar:**4.0.0**.RELEASE:compile
[INFO] | \- aopalliance:aopalliance:jar:1.0:compile

使用 Spring 时要求所有 Spring 自己的 jar 包版本必须一致。为了能够对这些 jar 包的版本进行统一管理，我们使用继承这个机制，将所有版本信息统一在父工程中进行管理。

## 4、操作

### ①创建父工程

创建的过程和前面创建 pro-maven-java 一样。

工程名称：pro-maven-parent

工程创建好之后，要修改它的打包方式：

```xml
  <groupId>com.atguigu.maven</groupId>
  <artifactId>pro03-maven-parent</artifactId>
  <version>1.0-SNAPSHOT</version>

  <!-- 当前工程作为父工程，它要去管理子工程，所以打包方式必须是 pom -->
  <packaging>pom</packaging>
```

只有打包方式为 pom 的 Maven 工程能够管理其他 Maven 工程。打包方式为 pom 的 Maven 工程中不写业务代码，它是专门管理其他 Maven 工程的工程。

### ②创建模块工程

模块工程类似于 IDEA 中的 module，所以需要**进入 pro03-maven-parent 工程的根目录**，然后运行 mvn archetype:generate 命令来创建模块工程。

假设，我们创建三个模块工程：

![./images](data:image/png;base64,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)

### ③查看被添加新内容的父工程 pom.xml

下面 modules 和 module 标签是聚合功能的配置

```xml
  <modules>  
    <module>pro_maven_demo01</module>
    <module>pro_maven_demo02</module>
    <module>pro_maven_demo03</module>
  </modules>
```

### ④解读子工程的pom.xml

```xml
<!-- 使用parent标签指定当前工程的父工程 -->
<parent>
	<!-- 父工程的坐标 -->
	<groupId>com.atguigu.maven</groupId>
	<artifactId>pro03-maven-parent</artifactId>
	<version>1.0-SNAPSHOT</version>
</parent>

<!-- 子工程的坐标 -->
<!-- 如果子工程坐标中的groupId和version与父工程一致，那么可以省略 -->
<!-- <groupId>com.atguigu.maven</groupId> -->
<artifactId>pro04-maven-module</artifactId>
<!-- <version>1.0-SNAPSHOT</version> -->
```

### ⑤在父工程中配置依赖的统一管理

```xml
<!-- 使用dependencyManagement标签配置对依赖的管理 -->
<!-- 被管理的依赖并没有真正被引入到工程 -->
<dependencyManagement>
	<dependencies>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-core</artifactId>
			<version>4.0.0.RELEASE</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-beans</artifactId>
			<version>4.0.0.RELEASE</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>4.0.0.RELEASE</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-expression</artifactId>
			<version>4.0.0.RELEASE</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-aop</artifactId>
			<version>4.0.0.RELEASE</version>
		</dependency>
	</dependencies>
</dependencyManagement>
```

### ⑥子工程中引用那些被父工程管理的依赖

关键点：省略版本号

```xml
<!-- 子工程引用父工程中的依赖信息时，可以把版本号去掉。	-->
<!-- 把版本号去掉就表示子工程中这个依赖的版本由父工程决定。 -->
<!-- 具体来说是由父工程的dependencyManagement来决定。 -->
<dependencies>
	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-core</artifactId>
	</dependency>
	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-beans</artifactId>
	</dependency>
	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-context</artifactId>
	</dependency>
	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-expression</artifactId>
	</dependency>
	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-aop</artifactId>
	</dependency>
</dependencies>
```

### ⑦在父工程中升级依赖信息的版本

```xml
			<dependency>
				<groupId>org.springframework</groupId>
				<artifactId>spring-beans</artifactId>
				<version>4.1.4.RELEASE</version>
			</dependency>
```

然后在子工程中运行mvn dependency:list，效果如下：

[INFO] org.springframework:spring-aop:jar:4.1.4.RELEASE:compile
[INFO] org.springframework:spring-core:jar:4.1.4.RELEASE:compile
[INFO] org.springframework:spring-context:jar:4.1.4.RELEASE:compile
[INFO] org.springframework:spring-beans:jar:4.1.4.RELEASE:compile
[INFO] org.springframework:spring-expression:jar:4.1.4.RELEASE:compile

### ⑧在父工程中声明自定义属性

```xml
<!-- 通过自定义属性，统一指定Spring的版本 -->
<properties>
	<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
	
	<!-- 自定义标签，维护Spring版本数据 -->
	<atguigu.spring.version>4.3.6.RELEASE</atguigu.spring.version>
</properties>
```

在需要的地方使用${}的形式来引用自定义的属性名：

```xml
			<dependency>
				<groupId>org.springframework</groupId>
				<artifactId>spring-core</artifactId>
				<version>${atguigu.spring.version}</version>
			</dependency>
```

真正实现“一处修改，处处生效”。

## 5、实际意义

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img037.53c95c38.jpg)

编写一套符合要求、开发各种功能都能正常工作的依赖组合并不容易。如果公司里已经有人总结了成熟的组合方案，那么再开发新项目时，如果不使用原有的积累，而是重新摸索，会浪费大量的时间。为了提高效率，我们可以使用工程继承的机制，让成熟的依赖组合方案能够保留下来。

如上图所示，公司级的父工程中管理的就是成熟的依赖组合方案，各个新项目、子系统各取所需即可。

# 第十五节 实验十：聚合

## 1、聚合本身的含义

部分组成整体

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img029.48831f65.jpg)

动画片《战神金刚》中的经典台词：“我来组成头部！我来组成手臂！”就是聚合关系最生动的体现。

## 2、Maven 中的聚合

使用一个“总工程”将各个“模块工程”汇集起来，作为一个整体对应完整的项目。

- 项目：整体
- 模块：部分

概念的对应关系：

从继承关系角度来看：

- 父工程
- 子工程

从聚合关系角度来看：

- 总工程
- 模块工程

## 3、好处

- 一键执行 Maven 命令：很多构建命令都可以在“总工程”中一键执行。

  以 mvn install 命令为例：Maven 要求有父工程时先安装父工程；有依赖的工程时，先安装被依赖的工程。我们自己考虑这些规则会很麻烦。但是工程聚合之后，在总工程执行 mvn install 可以一键完成安装，而且会自动按照正确的顺序执行。

- 配置聚合之后，各个模块工程会在总工程中展示一个列表，让项目中的各个模块一目了然。

## 4、聚合的配置

在总工程中配置 modules 即可：

```xml
	<modules>  
		<module>pro04-maven-module</module>
		<module>pro05-maven-module</module>
		<module>pro06-maven-module</module>
	</modules>
```

## 5、依赖循环问题

如果 A 工程依赖 B 工程，B 工程依赖 C 工程，C 工程又反过来依赖 A 工程，那么在执行构建操作时会报下面的错误：

DANGER

[ERROR] [ERROR] The projects in the reactor contain a cyclic reference:

这个错误的含义是：循环引用。

# 第十六节 在IDEA中使用maven

## 1、创建 Project

![./images](data:image/png;base64,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)

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img030.7f885903.png)

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img032.9289c76e.png)

## 2、开启自动导入

创建 Project 后，IDEA 会自动弹出下面提示，我们选择**『Enable Auto-Import』**，意思是启用自动导入。

![images](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAVUAAABDCAIAAACjlgFLAAALJElEQVR42u2cX2wUxx3H585psasIH63AUAwKmESxrbq4Ilb70Ie2nIUECKV1lVZFTe4pCkhAVBXJtI9tLEWqaiLFVZ+OVlRNVVcIiUSR7eYBg21cMCLlj6C6GJlQG1CJzzL2nY293dmZnZ3Znb3bvTt293Z/n4fTem535zfz+31nfjO755iiKEjDemA6BgCgGonFYtZjchAjCrf7RDAEAEA1Yxa8+BlbXV2dm5ubmpp6/Pixeuy3tQAAeEFNTU1jYyPW//Xr19W/t27dGo/H/bYKAAAvyOfzt2/fjq2srAwPD+/cuRPEDwDRQV3XT0xMxJ4+fXr+/Pldu3b5bQ8AAJ5y+fLl2PLysjr/g/4BIGpg/S8tLV24cAH0DwBRA+s/n89fvHgR9A8AUQPrP5fLjYyMgP4BIGpg/S8uLo6OjoL+ASBqYP0vLCyMjY2B/gEgamD9P3ny5NKlS6B/AIgaoH8AiC5Y//Pz8+Pj4w71n82vns3Mj07n7s8vq39ufv5L39lUe6Dp+fo18O4gAFQZ7vQ/fH/xd5cfLzw1/xzwK8/FfrHrq9/dXOd3cwAAcIGL/F8V/2/G/mf3S+AYQr/+9tfCPQQoysCx+q40SvVnezu5H1QHloGja7vSHT1XBw83lWWtknk/2d49ju90qMlNw4PfY5XqoirFqf7VtP/1j6f5mX/gR43qZ+c/Pmclahbwpz2bpAsBPQ5UjFBQlEwfDiuhMMiUFs2Z93e3dyNfIswuuN2aVEX6d9s00L+j/P/PN+dO35rjS6z6VznYvPbnLWutl3P6x7FwslPTP4kqWlYF+i8NHyPMrmq3JpWsf+9x2zTQvyP9v/XPh5nZpaK3a0p8+Q8/2GAtp/rv6OhQa0r1z53sRPpQTYuyvUn0mZ4OqFCXaO6hQwYfhdvRIBtQ1IKhw016FT1Xj99p174h5YIZ+h36Xz3TpdVEryXlqf5+1NWVJsYY92fDk2k24wc1VhdfiOgNEbuN2nBl4Cj3PR0KxV6SNKFoXUYhG1Vp7ebgJl0qmMTbLBuLjZ53Zpi5Rdo9k8S9xk00R2bo1YIjLA4ydyxzgei4E2+k3zll2zTnXRQdnOb/B87eXxS3/aTzf91zsbMHNlsv1yM7lULpNK92xJfwkkPEx8lBqggcHJpyhKiRnKqNJ1wxH8pcxsHQ7odIaJJrU3+f3ftRQrg/rYFaKLWWs4ErMuk/e+Q/vAE2+jc3wVFdNoVsJDUcJ+o/24sslzjut+0SGyQtEvTPtU5oKecIBxUhyT3N+rc2zWEXRQeP9U/HdeyGJuy51v6rL73bTgr4gGNZGXW8IXpO/mSA10ITGaXkKjbXCH7V45hWR5SAT9rzsVZOz6dTtJ7uGqexilkUmWx48T1WaG0Lu7N1nhR6ydIEeXu5usyFQopUJP+3ayxvoW2/yWwQLrTqXzi2fNHUV6giq0dEx8mbVlIXRYTS83+p/ovl/3r3p4juW/UJ0Zr/IyTIQJ86kc0kwQZ7IURs9K+foy1Axo0wEhYm40wDxmmc/ptkNrDBjJ8DhYjkk1jLcprrJaEJNMhldUkL9QVRRjoImkyya6xE/5Z++yN602oDP/bJ839DeILOjW61qUjiEdFx0qaV1kURwdv9P24axxlbK3M4cz3ilv2CF1M9PTe68YChSkseozbisZv/2XCT4qwgYcTPG0hPmIVJnwtU3gYacPbzPzWDbQFI1WKjf2ldBQzgs4ni87+lsUIab9NvZPC2S2dQyfq3Oggdk3tEdBwqOLS56qKI4O3zP3EpxwWFdEbVA5RkbvqAYdp40+AWyY70zyNYQfVvvj9ysP6XFWo3NNbb6il7PzRd5ET/ltWvvQGfydfPMv2zi0pb/9va0BkrvP53ov+iFckdV6xpLrooInj0/o+gf0FFhv4NH3f09LR2dxs5c4YtFpmbxYh0qX96f2QaYvgwku82m/b/LTaYC7mVJ33Lgde/4/zfsLBAXaxQTy70zRZJcPMmudr/N/Wb1BEV0L+0ooL7/5LAMHW+yy6KCNF6/7fM59jBf5ut2qmiFw3CQbR+/1Ou/iE6nzHQwx4Trd//lhNebGFZYLsLKBPQv8dES//lQPUPoQmECNf5PwAAoQH0DwDRBfJ/AIguoH8AiC6Q/weR/fv3X7t2zW8rAEpbW9u5c+f8tuKZAPoPIo2NjfF4PJvN+m0IQAmrLyD/DyL19fXq57179/w2BEBbtmxBoH/AS4j+wxpz1UW4fQH5P1KUL46dmH7p7ebDG4LyVs+zizlFWex779ad3e0nW8Vf+OBOmN37zgvwuwYToP/KMPDBxLsbmoe+7/NvhLRAnzxF/gFx2wtzP1lXXfonAj7xQP9XAkqi341oK6V/cp/uhm1qB1a8+QEJFUL49e9N/u+ZU+1CHH91YzLxl9k3fraTfKX+mXywcfB7uarTv7R15XSOa/0//G/yr7Nopu54wUtKszYIocIA/VcG351KZn50UFoO+nen/8wnN99E244/vPXhNwpZAvoPOD7k/1RvBxNnTs/8KxZTZ+NedFedltVzXtn9snYC8co2dJom6saMzWfveurLn59uqP/hg+wZckJDw9Ujm9hvddTZvn5oDV9Cy4k9yboTQ9gGsihAZIr7PbaQGWA6k1jLW6Uoa3qSdd3/prXw1rKTVeV8ayiPCqbubvVva5ikCfK+5fUvNdtiwyT6afOhR3dZl2p15Uk6QI5/+dvER7/SnaX5YjuatbovIKEyd/Tr0rgF/VcG0amT6Y0bcUDcxO6k63A9gJIoh9eWM+uoz1Tdnkb9uBxHz40knRm4cvF8uymukP4n09/cptsw++rbzYfW5/r+9sWe17TIFg2wnDnL0gq6KkYb9VinaQUzqXf9NBNJgb5ysf43tjAcNqFA32L9J2Vm2/Wk0EaL/pkryR2IkVb3WbvC91Bx6IsQ4EP+z+fb0mMcuJxXDPGgu7yAjfIW+flu9M9HPJ7ZyFrANFdbtGGeA/laSLzyFalTlrbXMJlGtT0Flxslzv+OmmDTty26/mVmm1IAPj833FpU/2L/i1Xr2ZPWBN9DxaEvQkC1619T4Hpn+rdZ50vFcwipE/UMSgqR7Vb/0uGGWdg9YzsKVET/Nk0orn87s7m6aF6tl2gjy6Np9/o3xqlAhYpDX4QA/9b/xZzKni2pM1j7YJ08qaNZqFOnardCTHXW/X+pqkUDLGcWyv+N7caBDybRa1gkfY82HW4tknlWRv/yJhToW5b/m80W/qWnmLezXVVtaYPXHaoNpups83+bgSYIoeLEFyEguPq/07Du1Kfahhy3UVRwU8fwIkl6Tft/BPIIkB5bnv+bJgqyzH6lLYGuIbv5X1/64g0q8/6fZfuN9MOPPzXePpD2lZvn/zhn1sYgh02Q962w/yczm/djFxIe+7MSttZg1XVqQw/zRYn7f56ESnT3/4L2/m+Zj7h8Nt5+WnNOuGOugngQKuH2Bei/ItbOvHjEeHLG0s6SCXfMVRDQf5kE8f3/6tI/Eh+zSx+YuyXcMVdBQP9lEkT9A+GOueoi3L4A/QeRcMdcdRFuX4D+g0i4Y666CLcvQP9BhMQcEBxA/4B37Nu3b3h42G8rAMqOHTuuXLnitxXPBNA/AEQX0D8ARJcgvv8DAIA3gP4BILpg/S8sLIyNjYH+ASBqgP4BILpg/S8uLo6OjoL+ASBqYP3ncrmRkRHQPwBEDaz/fD6vzv8tLS21tbV+2wMAgEcoijIxMRFbWlqampqamZlRD/w2CQAAj4jH44lEIra8vKyOBKurqysrK6sa7EBF4fDbYAAAXBDjiOvU1NTwB/8HTB6wVtAHeVUAAAAASUVORK5CYII=)

这个自动导入**一定要开启**，因为 Project、Module 新创建或 pom.xml 每次修改时都应该让 IDEA 重新加载 Maven 信息。这对 Maven 目录结构认定、Java 源程序编译、依赖 jar 包的导入都有非常关键的影响。

另外也可以通过 IDEA 的 Settings 设置来开启：

![images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img004.e823213d.png)

## 3 、配置Maven信息

每次创建 Project 后都需要设置 Maven 家目录位置，否则 IDEA 将使用内置的 Maven 核心程序（不稳定）并使用默认的本地仓库位置。这样一来，我们在命令行操作过程中已下载好的 jar 包就白下载了，默认的本地仓库通常在 C 盘，还影响系统运行。

配置之后，IDEA 会根据我们在这里指定的 Maven 家目录自动识别到我们在 settings.xml 配置文件中指定的本地仓库。

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img033.39a65cee.png)

## 4 、创建Java模块工程

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img034.dcd746ce.png)

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img035.939da5d9.png)

## 5  、创建Web模块工程

### 1、创建模块

按照前面的同样操作创建模块，**此时**这个模块其实还是一个**Java模块**。

### 2、修改打包方式

Web 模块将来打包当然应该是 **war** 包。

```xml
<packaging>war</packaging>
```

### 3、Web 设定

首先打开项目结构菜单：

![images](data:image/png;base64,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)

然后到 Facets 下查看 IDEA 是否已经帮我们自动生成了 Web 设定。正常来说只要我们确实设置了打包方式为 war，那么 IDEA 2019 版就会自动生成 Web 设定。

![images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img006.969793b4.png)

另外，对于 IDEA 2018 诸版本没有自动生成 Web 设定，那么请参照下面两图，我们自己创建：

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img042.32a9d794.png)

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img043.0a913d5c.png)

### 4、借助IDEA生成web.xml

![./images](data:image/png;base64,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)

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img045.dd04540f.png)

### 5、设置 Web 资源的根目录

结合 Maven 的目录结构，Web 资源的根目录需要设置为 src/main/webapp 目录。

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img046.71c20d43.png)

![./images](data:image/png;base64,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)

## 6、其他操作

### 1、在IDEA中执行Maven命令

#### ①直接执行

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img040.ddaaa560.png)

#### ②手动输入

![images](data:image/png;base64,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)

![images](data:image/png;base64,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)

![images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img029.7b9c7a12.png)

![images](data:image/png;base64,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)

如果有需要，还可以给命令后面附加参数：

![images](data:image/png;base64,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)

```sh
# -D 表示后面要附加命令的参数，字母 D 和后面的参数是紧挨着的，中间没有任何其它字符
# maven.test.skip=true 表示在执行命令的过程中跳过测试
mvn clean install -Dmaven.test.skip=true
```

### 2、在IDEA中查看某个模块的依赖信息

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img041.c804be73.png)

### 3、工程导入

Maven工程除了自己创建的，还有很多情况是别人创建的。而为了参与开发或者是参考学习，我们都需要导入到 IDEA 中。下面我们分几种不同情况来说明：

#### ①来自版本控制系统

目前我们通常使用的都是 Git（本地库） + 码云（远程库）的版本控制系统，结合 IDEA 的相关操作方式请点[**这里** (opens new window)](http://heavy_code_industry.gitee.io/code_heavy_industry/pro008-Git/lecture/chapter05/verse03.html)查看**克隆远程库**部分。

#### ②来自工程目录

直接使用 IDEA 打开工程目录即可。下面咱们举个例子：

##### [1]工程压缩包

假设别人发给我们一个 Maven 工程的 zip 压缩包：maven-rest-demo.zip。从码云或GitHub上也可以以 ZIP 压缩格式对项目代码打包下载。

##### [2]解压

如果你的所有 IDEA 工程有一个专门的目录来存放，而不是散落各处，那么首先我们就把 ZIP 包解压到这个指定目录中。

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img008.bb31d9a2.png)

##### [3]打开

只要我们确认在解压目录下可以直接看到 pom.xml，那就能证明这个解压目录就是我们的工程目录。那么接下来让 IDEA 打开这个目录就可以了。

![./images](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAASwAAACICAIAAADS5UFuAAASEUlEQVR42u2de2wUxx3Hx8ZOAAdTgUVqqNNgF7BsNzRQDFJAJDXnYAiiEMckRJg4f4BlHqZRg6CCRAHUQ7SihGCL8AdWqFSCQ+KixHHwggiKK1GnGIXElsEcebiQB1QKTngELF9nd273Zl93e+fdWy/+fv6wzrN7M7uz+9n5zezuXFJPTw9xgNy/nHUiW0bniw85lzkACSYJEgLgLpAQAJeBhAC4DCQEwGUgIQAuYyzhmB1DY8rlu/W3NCmQEACLmEo4r+Npi1m8n/cmJAQgbkwl9H3ypMUshMlvQ0IA4sZUwtkfL6Af9u7d++CDD37xxReVlZVsUVlZ2cKFC5999lll5ZPT3o1PwuD9WS2rRjfXnNnyTcYbWzMaN3e+lZRkZaPjkzDYXD1yx8QzQlX2xVrfww2LzgirciwVZynzQI3tedrLwN/CSBsvH7sca2eII9sQbF43snH+tV3Fdm+DqYTTP/LRD7Nnz37llVdefvnlkydPskVLly5dvHhxaWmpsvK/ZwlWJAwGh720ZkrlGPn/776aW09qV9sjYTAYoGJtbFUSKg7rKssWCZur00vJ4Z5Xi5WUQM0cmlnbXlI5xalTXN67Qj+Xf6zn5UCQUDqPS+vYPxWqaozyRZskDNVkfgxFqzc+sRJOFmbRD+PHjz948OAzzzzz+eefs0XLli1bsmTJE088oaz8ie8j6xLmfNjy3GdJukWjbZHw/Pprrxab5qA/kFa+ZZAJtVA+EnHkEAehUvIr6trD25+YxsHGHZSqro5eHVlW9F9f19pjq3KsftcWCemVaGUDac1fH7tLLkg44chU+iEnJ6ehoWHRokWBQIAtev7552ksWlRUpKzctfD0IJJQupYT5UwSm5fzcRzRmJC388zEHWJbxk5cb0moqbeYv27TztKwZSV5ff35h6lMsW6JCxKO/Ucu/VBSUrJnz57Vq1c3NTUtX768tbW1qqqK9hIXLFigrHx5aWd8Ekp9wuG7N3fWk3A4KgmZ65NWuHiybdbxm/rNsy6hKv6hiAEdC0fPv/j9/Pd/Ji+S0i0eYD4iFWPR8+vpZ95GvlCaMXWGfoWeQvQDfy5aP7GUvduVw4Ip7del0kPBuBiI+0IBN9OVC5j1W1jo9+dvbDDLRwjXHqs6Imh2zeJ5FmFn1ceogosyDI5djlH1Wt0GsRqpg0JVYF246sTcdkyklbCxjs9QUxVihUsSzvt+zYXiKZpL4ZFFDQu5vhCLtK1vp6mE6ft+QT/QrmBubm5nZ+e8efNoXDp9+vQbN25QJxsbG5WVe1b8N44+IRVs5mcZGgmlD1mBmjNbv02K0HJG7xNytaBcfUV52sMS0tPRRy7GcZlXfOO/ziUK7AjTrpciz9ouX8hVGoPtaCeLXufNtHb2hAoSjRI1lARhXVy6Ges+mLtLOqXkaFm1NCywsoXyhYDVG/Gb5sPvIztf1btmserMJGTHqN3PndOhcgXjY2dUvbFugzoTSRV2wsjdZvEUMagKgbWESt3SpXTD+EbVpIgo22l+s/6v6fr0cePGXbly5fbt26rUP/bY1RLW/zr3clkG/y3DxtBiS6g58OqBmX5IqGqX5LZFkVBQXb4Ju4LP/YAtJetoP2j9+ZVda8Uk8apsZZiE3ztlaOHa/EZ+7yQ5uTZMPgmqiLyzyl5z55C+lnT5cBJKnTrNrvWzU6c9RkrdEuONzDaqXovbwF/11LEJb0v4oBhVqSShUrfZAh+gqqKhWOrKVMJb2+6xeFIO3XTbTgkfvVHy2ldnI0Zo7kpI5ChU7KJJ7Rt/ADSnOLd5UmdE0W/9ooYdYmRkJQbW7B2LlPIrQuM00u6IjZl4SnHnATvPXicracH8IjMJDfPRShhvx4w/11XpBhJqI0aikTCubdAGtyKqqxUvoXTl0ldFWDnWt6R1Gz4B1DsYU10NMAnFD7mkPrTOU09PIgcNRmusSsh3wPi4q98SsriFFNK4Uq501aHi46hqsks+bNKwHD1m7DMLSq2dQNq9C12kWT+NOy+VYDXUOK88n0/aJ0obabiFqmoxykcXjhrsmsVKk/Ikfu40pVGBZJs6HA2Hc4YxsxDfNuiGtUP7olyTVBIGDKsiLKG2bnUHKKa6iiJhMBjUfkGXkY0SigMzYuID2dIKQr1Bh5BYuk8YuqXGRQXhEQhFwuJQFbfGNDATLo6Ev6UKRXR9eqI0X4eVDmQMt+yMjrG6LyeXV1hRQeqIPPqiuidmsoVctZjkoxI+vEp416yjCtLk+4SmAzNGxy7HpHqjor/By1KUwFclYbZBVfASEq6bynqGqkY23MO0tJ2JawltBI+t2chAeBjFi1gfV4tK4iS8tOURTcq4l/4V30brJUxPNxhGcuItLcOCHCoraqHxFS1d73dPEML3KtpjGei3dxccrTfn0Nwf1u9dTPuFV5kGI3ykFNOtNkBYIFoXTzRuBl7qBcBlICEALgMJAXAZSAiAy0BCAFwGEgLgMkmnT592exsAGNQ41RJ2dXVNmDDB7b0DYKBDTYGEALgJJATAZSAhAC4DCQFwGUgIQCIQBGHq1KmjRo3SL4ou4dGWjy0W8/jMaZqs7ZLQlqlvAXCRpqam7u7uFStW6Bd5SUJXpr4FwBZ6e3u3bdtWVlaWl5enWeQpCd2Y+hYAu+jo6Kivr9+0aVNKSgqfbklCjV0WV3NAQvOpb+2ebBcAJ9i3b19WVlZJSQmfaFXCmgvXI6yz6ldpiZHQZOpb+yfbBcAJOjs79+/f7/f7hwwZoiR6T0L91LfZDky2C4Dt3LlzZ/v27T6fb8aMGXy69yQk+qlvHZhsFwDbOXDgAP1bXl6uSXdKQurAhQt9DklINFPfOjDZLgD2curUKUEQNmzYkJqaqlnkyZaQ6ObetX2yXQDshRpYUFCQmZmpX+RYSxioudBXjCdmAIiKYxI2V18YvxoSAhAVp+4T2tsnBOAuxhtPzABwF4O3KABwGUgIgMs4K+GCf97sfz4A3N28+/thkBAAN4GEALgMJATAZSAhAC6TUAlLr9Urn68n33d0xNw+kux2DQDgMq5JSPl06EPn7s21nmHw/qyWVQ9kh/67vrfmzNZv8TQ28DyihOw1p7iZNGmSYXpKSkpkCQ05PLLMMD1YMOly2TBFPCZkoL7luc/gIfA2ooQnTpzo6+uL7/vJycnDhw/PzDJ4Se/K11/aJWEwOPqNrblErZykJVm3ufMtvKQLvEyiJbyTlHp0RMmtpKExlSL69uiNkte+Oqt6d56amRWoObPlm+EvrZmS82EnKcv1SYsEWVdmL0u8eLJt1vGboW+dvFk5O0NJdK/+AUi4hGeHTu5NSp1y8z8R8vwmJbMlbRafYiLhMMm9luWfihJWjrnKWkWlhawnGcxSGsFyK2eIWnZ0jnvzf1JMO7oZfUvgKgmVcO6PTSfSflf849F7+26ZZdhHkoURj/+QPIJPNJdwEnlLaQmV1k/2jeReLsvg86Ht3sxjw9VmijlAQuAiCZUws/frMb3fTfjpXIQMu+6d9MnQyZrEyH3CemIuoXkQCwnBACGhEo7o+8H3w9FkYlrWT8lDm+6b25t0j37RQ0W/aZpNDEdHmXWVV8UIU17zphyOhtV96ulJ5KA+RpXaUvIAi0v1H+AncJqESjjz+kc/7/06Qm5tw3578Z5ss6Vm9wlDTd/Vq748FnxeVYZM+a8IIWNHQ0IwoEiohA6hxJ+4Zwi8iDckvLTlkQhLx25ug4TAu0SRMBhs/dva7iW7F49j0d2lt9duJxvkfwlaQgD6TYwS0n/ntMw89ofCgSQhAJ4mkoStO4s2NupS5/uPv1Co/AcJAegnsbWEeiAhAP0kqoSX3pF6gU+Oi6dPiNnWAIiKONtaLH1C6uShrN1W+4SQEICoRJVQZV2sAzOQEICoRJGQcuntNeVfLmODMfxnBiQEoJ9El5Dww6R5VQfUgzSQEIB+YknCCEBCAPpJdAnFEdHy2g7xBuGxmS1z/v7LA689OU5ZmkgJ+Z/jJdIvZTvxs7vBYPO6kTsmcpmL5a4Uf+w+m1ys5baA/Vi3+DvBuh8SBsA6VgZmxJsSM05J4zPTPnZrYCbYXD2ytF0Rj/8pbHtrJKqEimzN1eml5HDPq8WQEPQHq7coyDtuSiiJQU941VkuaUnTdhXbOtGTdQnFDWicDwlBP4kejrbuLKLaLemWJCSig4kfHRVPd9ELMfYLJ8q2VGUzNw6T0tI6aVGFrCuzlyXS4PHYqpzQt/z5GzfWKYmqsqxJyMRrWMTyhIQgfiz0CcWIVOoUEtdGR00kDJ36u3ysq1bBWkWlhfQRQdGJW1kQtayQwkgxpqUeqfqWlvuE4U4pJAT9wRujo+YSMjnUUaLiG1FawRDSSEpAbaaYQ0wSsoKUDiGBhKB/eETCiH1CHzGX0DyINZdQa5RyCVCHo+FNgoSgP5hKKN6gJ/5jYi9Q/z6TGJWyR7qZhIZZp6Sk2Dg6GqiZ8zDdIKPRUeYA/Ye1S9Ka+XI4Gla3ubqa7NLHqFoJ+RzE4FaSrd1v0PcTVxODWe2Ajbx50jJSq/ngxG0V4GniaQn5dymYhIWFhfrV2traEnOfMORGfkVdnTIuExoy5b9ScVhpwaJISNjth7pwSWzwRiOhIv+1XTma+4dte0nlFEgILBHPwMzYyzThy2XSjYpESmi+hYgGgYexdItCeUrG7AFuSAhA3NjzPiEkBCBuLEjIPSJj9j6huxIC4GnuhnAUAE9jzxMzkBCAuLHnZj0kBCBurPQJaTQaujWvRyPhoUOH0tLSHnvsMfoXEgJgBatvUbxQaEnC99577/r168zDc+fOQUIAomKlJdQ8tjbfbz46Sg2kuTEPx44dCwkBiIr9fULFwwkSbu8gAAMdRwZmmIdoCQFQEARh6tSpo0aN0i+KJKEyxZP+zoSC2ego9dD2PmGiJnoKGM7mZHtBYFDR1NTU3d29YsUK/SJTCflfoQi27tTMaqGQsFsUCZzoKWA4m5O9pRA8bTfI6O3t3bZtW1lZWV5enmZRBAnDT43qn1ZTSIyEiZ3oKWA4m5ONRRgWBO56Ojo66uvrN23alJKSwqd7RMKETvQUMJzNyTA38yKiFCrNsiG/sYiId9Cwb9++rKyskpISPjGihAbv1JPItyh4nJfQoYmeAiazOTWb5dbOmRxhNU2hmqlxwGCgs7Nz//79fr9/yJAhSqI3HltL7ERPAePZnES3dblN2K3ZMOPVjAqFhIONO3fubN++3efzzZgxg0/3iIQuTfSkms3J8EKgS4wcOUPCwcyBAwfo3/Lyck26NyQkCZzoyXw2J7PclDnXmmtrc6qkzp6VQiHhoOLUqVOCIGzYsCE1NVWzyDMSkkRN9GQ2m5PcnVPlpi5C7pRaLlS6XrRiYGYwQA0sKCjIzMzUL/KShGZgrB94GksPcBN/6C0K8a69NBvpgJrewl4J09PTDdN7enoSsC9gEIKWEACXiVPCoqKi48ePk4EhIQCeBhIC4DJxPjGzcc4cSAiALUR8lal1pzS/jMFLTGgJAbCLiBJybzNpFkFCAOwCfUIAXOZuuEUBgKeBhAC4jLcllJ7JbJxv98v18W+P0QuKAETGSxLyb6wT9oKsAxJqJnqqiGUaG0gI4sAzErKXZcPvLjRX+7rWSi/LOiFh6C0Hp6XCA3eAeEVCw5d6iTPhqOb9pubq9B0TtfPQ2FoWJBzsGEt45MgR5XNaWlpRUVGSyVnu4vQWRC2hKljlXikMvbPHJRrO18TlaSChUEXCc0lJr/+xd3w1xUktp/hOv1kpfOK0P+8p+NNqzPUEoktIycvLM9NpgEjI3nBXJlwKz3wRenk93FQaTsSkmjXDKBxlb8GH55KSXIpQXIQ5ptSzQqElBNYk1LNw4UL2YaBIKKimk9FOc8a/hm80ERPfGBrOtmYwGalhcTnqYtWlGMwKBQmBZyTkmi9dupmE4ZBS9oqf98w09rM054WBhNK0MYST0MqsUJAQeEVCop/oST06ahCOytMC1waqVhVrY0LNREzFScbhqDqRn3im2aw4Lhy1MisUgYTAMxISTSSpu09oNjAjzh1aF/4KMZr9SVWKBQmJ5qal4cCMtVmhMNcT8JKEAx9eQre3BXgGSGgnyiRRmBUKWAcS2oMcKlfY/itR4K7HG0/MAHAXAwkBcBlICIDLQEIAXMZZCd3eOwC8wf8BmGVCzX3pJA0AAAAASUVORK5CYII=)

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img010.900e648d.png)

##### [4]设置 Maven 核心程序位置

打开一个新的 Maven 工程，和新创建一个 Maven 工程是一样的，此时 IDEA 的 settings 配置中关于 Maven 仍然是默认值：

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img011.d7914ffd.png)

所以我们还是需要像新建 Maven 工程那样，指定一下 Maven 核心程序位置：

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img012.a62a48e8.png)

### 4、模块导入

#### ①情景重现

在实际开发中，通常会忽略模块（也就是module）所在的项目（也就是project）仅仅导入某一个模块本身。这么做很可能是类似这样的情况：比如基于 Maven 学习 SSM 的时候，做练习需要导入老师发给我们的代码参考。

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img013.5f438a0d.png)

#### ②导入 Java 类型模块

##### [1]找到老师发的工程目录

![./images](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAZkAAADqCAIAAAD/Bq9CAAAiw0lEQVR42u2dC5QUxaGGa2E1aqJRgSAqkiAQDxcwhpwoIF5FTHj6woMCIg9hV1BhBRQRH1cCvnjtAgouREAjKgGPN/KIwQeJgkAAk8XrEZcYFQXXlWgkUQywe2umZrqr69HTM9O93V3zfxzH2Zqu6np0/V1V01N/UX19PQEAgJhTBC0DABgAtAwAYALQMgCACRTt3r077DwAAEC+YFwGADABaBkAwASgZcbSs2fPnTt3hp0LECfOO++8V155Jexc5Ai0zFhOPvnkRo0affnll2FnBMSJurq6sLOQI9AyY6FCRl+/+OKLsDMC4sEpp5xCoGUggjAti++lCRqYuF8w0DJjifulCRqYuF8w0DJjifulCRqYuF8w/mhZVVVVv3791qxZ06lTJz587dq1s2fPpq/HH3982CXNi2+++aZv374TJ06kr2HnxStBX5q6Ri8oIlgJBw4cuPDCC5977rlsswQtS+CvltHjaWr0zUknnfT666+zNGkLdezYcf/+/XygFT5p0qQJEyZYmenevftXX30lHJkP0DKZCHbjhieClQAtC4QctIy2xLhx45YsWUKj0IijR4/etWvXCSecQEWEXjRUsITAd999t3PnzpdccgnTMiZtixcvph/5OCo0WMviWLT44lLbfjUEtEyE1iwd1Fx66aWNGzfOOfU81cRqFfr+2muvfeONN5o0aSI3+YgRI6h+MS3jz0iPHDRo0LRp0/K/Z0a2w7s0E7QsgsRXy3wRhEDRatlLL720ZcuWNm3aXHfddRlzT0faltZYk0H2ER0xMWXhw6ncMOmx5oP0PR2oC61oDcFoTlatWrV06VIWzosXcdUydnHQuOwA5ajt66+/tjLWokULejpLMWnKkydPPuecc2gK11xzDbvOWJ6vvvpqmp85c+bQQCsiGyqyWCxBq1DKksp1oqwlF1yaSXlpCtm44IILrNOxlrJqg87QaSlefvllGlhdXW21r9XWn3zyidzoGWPR93x+WMebOnXqzTffTHNFs0QD2QqD7iLp0aOHNUinIbQJaKDQjlZl0sSHDh1K09fVJ9/QfJMJF4DuOtFd+da5+MC77rqLXjN8bVv3eP4woSEy9hfhvMOGDeNLPXz4cNZx5OwJZdy4cSPRa1lWghAKWi07evTos88+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)

##### [2]复制我们想要导入的模块目录

![./images](data:image/png;base64,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)

##### [3]粘贴到我们自己工程目录下

这个工程（project）是我们事先在 IDEA 中创建好的。

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img016.1933c568.png)

------

![./images](data:image/png;base64,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)

##### [4]在 IDEA 中执行导入

![./images](data:image/png;base64,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)

------

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img019.772f07d3.png)

------

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img020.bb620847.png)

------

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img021.ac677293.png)

------

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img022.ac55e275.png)

##### [5]修改 pom.xml

刚刚导入的 module 的父工程坐标还是以前的，需要改成我们自己的 project。

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img023.4ffa60b5.png)

------

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img024.7585bfaa.png)

##### [6]最终效果

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img025.9e3d577f.png)

#### ③导入 Web 类型模块

其它操作和上面演示的都一样，只是多一步：删除多余的、不正确的 web.xml 设置。如下图所示：

![./images](http://heavy_code_industry.gitee.io/code_heavy_industry/assets/img/img026.8dad97d2.png)

# 第十七节 其他核心概念 

## 1、生命周期

### ①作用

为了让构建过程自动化完成，Maven 设定了三个生命周期，生命周期中的每一个环节对应构建过程中的一个操作。

### ②三个生命周期

| 生命周期名称 | 作用         | 各个环节                                                     |
| ------------ | ------------ | ------------------------------------------------------------ |
| Clean        | 清理操作相关 | pre-clean clean post-clean                                   |
| Site         | 生成站点相关 | pre-site site post-site deploy-site                          |
| Default      | 主要构建过程 | validate generate-sources process-sources generate-resources process-resources 复制并处理资源文件，至目标目录，准备打包。 compile 编译项目 main 目录下的源代码。 process-classes generate-test-sources process-test-sources generate-test-resources process-test-resources 复制并处理资源文件，至目标测试目录。 test-compile 编译测试源代码。 process-test-classes test 使用合适的单元测试框架运行测试。这些测试代码不会被打包或部署。 prepare-package package 接受编译好的代码，打包成可发布的格式，如JAR。 pre-integration-test integration-test post-integration-test verify install将包安装至本地仓库，以让其它项目依赖。 deploy将最终的包复制到远程的仓库，以让其它开发人员共享；或者部署到服务器上运行（需借助插件，例如：cargo）。 |

### ③特点

- 前面三个生命周期彼此是独立的。
- 在任何一个生命周期内部，执行任何一个具体环节的操作，都是从本周期最初的位置开始执行，直到指定的地方。（本节记住这句话就行了，其他的都不需要记）

Maven 之所以这么设计其实就是为了提高构建过程的自动化程度：让使用者只关心最终要干的即可，过程中的各个环节是自动执行的。

## 2、插件和目标

### ①插件

Maven 的核心程序仅仅负责宏观调度，不做具体工作。具体工作都是由 Maven 插件完成的。例如：编译就是由 maven-compiler-plugin-3.1.jar 插件来执行的。

### ②目标

一个插件可以对应多个目标，而每一个目标都和生命周期中的某一个环节对应。

Default 生命周期中有 compile 和 test-compile 两个和编译相关的环节，这两个环节对应 compile 和 test-compile 两个目标，而这两个目标都是由 maven-compiler-plugin-3.1.jar 插件来执行的。

## 3、仓库

- 本地仓库：在当前电脑上，为电脑上所有 Maven 工程服务
- 远程仓库：需要联网
  - 局域网：我们自己搭建的 Maven 私服，例如使用 Nexus 技术。
  - Internet
    - 中央仓库
    - 镜像仓库：内容和中央仓库保持一致，但是能够分担中央仓库的负载，同时让用户能够就近访问提高下载速度，例如：Nexus aliyun

建议：不要中央仓库和阿里云镜像混用，否则 jar 包来源不纯，彼此冲突。

专门搜索 Maven 依赖信息的网站：https://mvnrepository.com/

# 未完待续

# [054-单一架构案例-功能演示_ev_哔哩哔哩_bilibili](https://www.bilibili.com/video/BV12q4y147e4?p=54&vd_source=22b7dd3c404bbcce751f278c956b0e5f)

# [代码重工 (gitee.io)](http://heavy_code_industry.gitee.io/code_heavy_industry/pro002-maven/)

