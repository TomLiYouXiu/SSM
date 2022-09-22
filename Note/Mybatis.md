# 1.MyBatis简介

### 1.1MyBatis特性

1） MyBatis 是支持定制化 SQL、存储过程以及高级映射的优秀的持久层框架

2） MyBatis 避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集

3） MyBatis可以使用简单的XML或注解用于配置和原始映射，将接口和Java的POJO（Plain Old Java

Objects，普通的Java对象）映射成数据库中的记录

4） MyBatis 是一个 半自动的ORM（Object Relation Mapping

### 1.2下载安装

下载地址[mybatis/mybatis-3: MyBatis SQL mapper framework for Java (github.com)](https://github.com/mybatis/mybatis-3)

### 1.3和其他持久化层的对比

* JDBC
  *  SQL 夹杂在Java代码中耦合度高，导致硬编码内伤
  * 维护不易且实际开发需求中 SQL 有变化，频繁修改的情况多见
  * 代码冗长，开发效率低

* Hibernate 和 JPA
  * 操作简便，开发效率高
  * 程序中的长难复杂 SQL 需要绕过框架
  * 内部自动生产的 SQL，不容易做特殊优化
  * 基于全映射的全自动框架，大量字段的 POJO 进行部分映射时比较困难。
  * 反射操作太多，导致数据库性能下降

* MyBatis
  * 轻量级，性能出色
  * SQL 和 Java 编码分开，功能边界清晰。Java代码专注业务、SQL语句专注数据
  * 开发效率稍逊于HIbernate，但是完全能够接受

# 2.环境搭建

## 2.1开发环境

IDE：idea 2021.1

构建工具：maven 3.6.3

MySQL版本：MySQL 5

MyBatis版本：MyBatis 3.5.10

MySQL不同版本的注意事项

1、驱动类driver-class-name

MySQL 5版本使用jdbc5驱动，驱动类使用：com.mysql.jdbc.Driver

MySQL 8版本使用jdbc8驱动，驱动类使用：com.mysql.cj.jdbc.Driver

2、连接地址url

MySQL 5版本的url：

jdbc:mysql://localhost:3306/ssm

MySQL 8版本的url：

jdbc:mysql://localhost:3306/ssm?serverTimezone=UTC

否则运行测试用例报告如下错误：

java.sql.SQLException: The server time zone value 'ÖÐ¹ú±ê×¼Ê±¼ä' is unrecognized or

represents more

## 2.2创建maven工程

**①打包方式：jar**

~~~xml
<packaging>jar</packaging>
~~~

**②引入依赖**

~~~xml
<dependencies>
    <!-- Mybatis核心 -->
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>3.5.10</version>
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
        <version>8.0.16</version>
    </dependency>
</dependencies>
~~~

## 2.3java代码

**get set 方法IDEA快捷键 Ctrl+Ins**

### 2.3.1.实体类代码

~~~java
package com.liyouxiu.mybatis.pojo;

public class User {
    private Integer id;

    private String username;

    private String password;

    private Integer age;

    private String gender;

    private String email;


    public User() {
    }

    public User(Integer id, String username, String password, Integer age, String gender, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

~~~

### 2.3.2测试代码

~~~java
package com.liyouxiu.mybatis.test;

import com.liyouxiu.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest {
    @Test
    public void testInsert() throws IOException {
        //获取核心配置文件的输入流
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder =new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(is);
        //获取sql的会话对象SqlSession，是Mybatis提供的操作数据库对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper的代理实现对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用mapper接口中的方法，实现添加用户信息的功能
        int i = mapper.insertUser();
        System.out.println("结果"+i);
        sqlSession.close();
    }

}
~~~



## 2.4创建MyBatis的核心配置文件

> 习惯上命名为mybatis-config.xml，这个文件名仅仅只是建议，并非强制要求。将来整合Spring
>
> 之后，这个配置文件可以省略，所以大家操作时可以直接复制、粘贴。
>
> 核心配置文件主要用于配置连接数据库的环境以及MyBatis的全局配置信息
>
> 核心配置文件存放的位置是src/main/resources目录下

查看官方文档快速开始

~~~xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
<!--    配置连接数据库环境-->
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/ssm?serverTimezone=UTC"/>
                <property name="username" value="$root"/>
                <property name="password" value="$root"/>
            </dataSource>
        </environment>
    </environments>

<!--  引入mybatis的映射文件  -->
    <mappers>
        <mapper resource="mappers/UserMapper.xml"/>
    </mappers>
    
</configuration>
~~~

## 2.5创建mapper接口

> MyBatis中的mapper接口相当于以前的dao。但是区别在于，mapper仅仅是接口，我们不需要提供实现类。

> 命名规则一般为操作的表+Mapper  列如 UserMapper

~~~java
package com.liyouxiu.mybatis.mapper;

public interface UserMapper {

    int insertUser(); //添加功能测试

}
~~~

## 2.6创建MyBatis的映射文件

相关概念：**ORM**（**O**bject **R**elationship **M**apping）对象关系映射。主要写的是SQL语句

* 对象：Java的实体类对象

* 关系：关系型数据库

* 映射：二者之间的对应关系

| java概念 | 数据库概念 |
| -------- | ---------- |
| 类       | 表         |
| 属性     | 字段、列   |
| 对象     | 记录、行   |



> 1、映射文件的命名规则：
>
> 表所对应的实体类的类名+Mapper.xml
>
> 例如：表t_user，映射的实体类为User，所对应的映射文件为UserMapper.xml
>
> 因此一个映射文件对应一个实体类，对应一张表的操作
>
> MyBatis映射文件用于编写SQL，访问以及操作表中的数据
>
> MyBatis映射文件存放的位置是src/main/resources/mappers目录下
>
> 2、 MyBatis中可以面向接口操作数据，要保证两个一致：
>
> a>mapper接口的全类名和映射文件的命名空间（namespace）保持一致
>
> b>mapper接口中方法的方法名和映射文件中编写SQL的标签的id属性保持一致

~~~xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!--此时的名字要和你的全类名保持一致-->
<mapper namespace="com.liyouxiu.mybatis.mapper.UserMapper">
<!--
    mapper接口要保证两个一致
    1.mapper接口的全类名和映射文件的namespace一致
    2.mapper接口中的方法的方法名要和映射文件中的sql保持一致
-->

    <!--  int insertUser();  -->
    <!--  方法名要和id保持一致  -->
    <insert id="insertUser">
        insert into t_user values (null,'admin','123456',23,'男','123456@qq.com')
    </insert>

</mapper>
~~~

## 2.7测试代码

~~~java
package com.liyouxiu.mybatis.test;

import com.liyouxiu.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest {
    @Test
    public void testInsert() throws IOException {
        //获取核心配置文件的输入流
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder =new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(is);
        //获取sql的会话对象SqlSession，不会自动提交事务,是Mybatis提供的操作数据库对象
        //SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取sql的会话对象SqlSession，自动提交事务，是Mybatis提供的操作数据库对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper的代理实现对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //提供sql以及唯一标识找到sql并执行，唯一标识是  namespace.sqlid
        int insert = sqlSession.insert("com.liyouxiu.mybatis.mapper.UserMapper.insertUser");
        //调用mapper接口中的方法，实现添加用户信息的功能
        int i = mapper.insertUser();
        System.out.println("结果"+i);
        //提交事务
        sqlSession.commit();
        //关闭 sqlSession
        sqlSession.close();
    }

}
~~~

> SqlSession：代表Java程序和**数据库**之间的**会话**。（HttpSession是Java程序和浏览器之间的会话）
>
> SqlSessionFactory：是“生产”SqlSession的“工厂”。
>
> 工厂模式：如果创建某一个对象，使用的过程基本固定，那么我们就可以把创建这个对象的
>
> 相关代码封装到一个“工厂类”中，以后都使用这个工厂类来“生产”我们需要的对象。

## 2.8加入log4j日志功能

### **①加入依赖**

~~~xml
<!-- log4j日志 -->
<dependency>
    <groupId>log4j</groupId>
    <artifactId>log4j</artifactId>
    <version>1.2.17</version>
</dependency>
~~~

### ②加入log4j的配置文件

> log4j的配置文件名为log4j.xml，存放的位置是src/main/resources目录下

~~~xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE log4j:configuration SYSTEM "log4j.dtd">
<log4j:configuration
    xmlns:log4j="http://jakarta.apache.org/log4j/">
    <appender name="STDOUT" class="org.apache.log4j.ConsoleAppender">
        <param name="Encoding" value="UTF-8" />
        <layout class="org.apache.log4j.PatternLayout">
            <param name="ConversionPattern" value="%-5p %d{MM-dd HH:mm:ss,SSS} %m (%F:%L) \n" />
        </layout>
    </appender>
    <logger name="java.sql">
        <level value="debug" />
    </logger>
    <logger name="org.apache.ibatis">
        <level value="info" />
    </logger>
    <root>
        <level value="debug" />
        <appender-ref ref="STDOUT" />
    </root>
</log4j:configuration>
~~~

> **日志的级别**
>
> FATAL(致命)>ERROR(错误)>WARN(警告)>INFO(信息)>DEBUG(调试)
>
> 从左到右打印的内容越来越详细

# 3.核心文件配置详解

> 核心配置文件中的标签必须按照固定的顺序：
>
> properties?,settings?,typeAliases?,typeHandlers?,objectFactory?,objectWrapperFactory?,refl
>
> ectorFactory?,plugins?,environments?,databaseIdProvider?,mappers?

~~~xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

    <!--MyBatis核心配置文件中，标签的顺序： properties?,settings?,typeAliases?,
    typeHandlers?, objectFactory?,objectWrapperFactory?,reflectorFactory?,
    plugins?,environments?,databaseIdProvider?,mappers? -->

    <!-- 引入properties文件此后就可以在当前文件中使用${key}的方式访问value -->
    <properties resource="jdbc.properties" />

    <!--
    typeAlias设置类型别名，即为某个具体的类型设置一个别名
    在MyBatis的范围中，就可以使用别名表示某个具体的类型
     -->
    <typeAliases>
        <!--
        type：设置需要起别名的类型
        alias：设置某个类型的别名
              -->
<!--        <typeAlias type="com.liyouxiu.mybatis.pojo.User" alias="abc"></typeAlias>-->
        <!--   不写alias默认的别名就是类名   且不区分大小写    -->
<!--        <typeAlias type="com.liyouxiu.mybatis.pojo.User" ></typeAlias>-->
        <!-- 通过包来设置类型别名，指定的包下所有的类型都拥有，默认别名 -->
        <package name="com.liyouxiu.mybatis.pojo"/>
    </typeAliases>

    <!--    配置连接数据库环境-->
    <!--environment：配置某个具体的环境 属性：id：表示连接数据库的环境的唯一标识，不能重复 -->
    <environments default="development">
        <environment id="development">
            <!--transactionManager：设置事务管理方式
            属性：type="JDBC|MANAGED"
            JDBC：表示当前环境中，执行SQL时，使用的是JDBC中原生的事务管理方式，事务的提交或回滚需要手动处理
            MANAGED：被管理，例如Spring -->
            <transactionManager type="JDBC"/>
            <!--dataSource：配置数据源
            属性：type：设置数据源的类型 type="POOLED|UNPOOLED|JNDI"
            POOLED：表示使用数据库连接池缓存数据库连接
            UNPOOLED：表示不使用数据库连接池
            JNDI：表示使用上下文中的数据源 -->
            <dataSource type="POOLED">
                <!--设置连接数据库的驱动-->
                <property name="driver" value="${jdbc.driver}"/>
                <!--设置连接数据库的连接地址-->
                <property name="url" value="${jdbc.url}"/>
                <!--设置连接数据库的用户名-->
                <property name="username" value="${jdbc.username}"/>
                <!--设置连接数据库的密码-->
                <property name="password" value="${jdbc.password}"/>
            </dataSource>
        </environment>
        
        <environment id="test">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/ssm"/>
                <property name="username" value="root"/>
                <property name="password" value="root"/>
            </dataSource>
        </environment>
    </environments>

<!--  引入mybatis的映射文件  -->
    <mappers>
<!--        <mapper resource="mappers/UserMapper.xml"/>-->
        <!--
        以包的方式来引入隐射文件，但是要满足两个条件
            1.mapper接口和映射文件所在的包必须一致
            2.mapper接口的名字和映射文件的名字必须保持一致
            注意问题 发现测试无法通过是先将maven项目clean下 在重新compile
             -->
        <package name="com.liyouxiu.mybatis.mapper"/>
    </mappers>

</configuration>
~~~

## 3.1properties配置文件

~~~properties
jdbc.driver=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/ssm
jdbc.username=root
jdbc.password=root
~~~

**引用方式在Mybatis-cofig.xml文件中使用**



# 4.Mybatis增删改查

## utils工具代码

~~~java
package com.liyouxiu.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
    public static SqlSession getsqlSession(){
        SqlSession sqlSession = null;
        try {
            //获取核心配置文件的输入流
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //获取SqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            //获取SqlSessionFactory
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            //获取SqlSession对象
            sqlSession = sqlSessionFactory.openSession(true);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return  sqlSession;
    }
}
~~~

直接在测试类中进行引用即可



**先写好接口，统一在xml文件中进行配置，最后在test中进行调用**

## 4.1、新增

~~~xml
    <!--  int insertUser();  -->
    <!--  方法名要和id保持一致  -->
    <insert id="insertUser">
        insert into t_user values (null,'admin','123456',23,'男','123456@qq.com')
    </insert>
~~~

## 4.2、删除

~~~xml
    <!--    void deleteUser();-->
    <delete id="deleteUser">
        delete from t_user where id=3
    </delete>
~~~

## 4.3、修改

~~~xml
    <!--  void testUpdate();  -->
    <update id="testUpdate">
        update t_user set username='root',password='123' where id=3
    </update>
~~~

## 4.4、查询一个实体类对象

~~~xml
    <select id="getUserById" resultType="com.liyouxiu.mybatis.pojo.User">
        select * from t_user where id=1
    </select>
~~~

## 4.5、查询list集合

~~~xml
    <!--    List<User> getAllUsers();-->
    <select id="getAllUsers" resultType="com.liyouxiu.mybatis.pojo.User">
        select * from t_user
    </select>
~~~

# 5、MyBatis获取参数值的两种方式

> MyBatis获取参数值的两种方式：**${}**和**#{}**
>
> ${}的本质就是字符串拼接，#{}的本质就是占位符赋值
>
> ${}使用字符串拼接的方式拼接sql，若为字符串类型或日期类型的字段进行赋值时，需要手动加单引号；但是#{}使用占位符赋值的方式拼接sql，此时为字符串类型或日期类型的字段进行赋值时，可以自动添加单引号

## 5.1、单个字面量类型的参数

> #{}的本质是占位符赋值   ${}的本质是字符串拼接
>
> 若mapper接口中的方法参数为单个的字面量类型
>
> 此时可以使用${}和#{}以任意的名称获取参数的值，注意${}需要手动加单引号

~~~xml
	<!--    User GetUserByUsername(String username);-->
    <select id="GetUserByUsername" resultType="User">
        select * from t_user where username=#{username}
    </select>
~~~

## 5.2、多个字面量类型的参数

> 若mapper接口中的方法参数为多个时
>
> 此时MyBatis会自动将这些参数放在一个map集合中，以arg0,arg1...为键，以参数为值；
>
> 以param1,param2...为键，以参数为值；因此只需要通过${}和#{}访问map集合的键就可以获取相对应的值，注意${}需要手动加单引号

~~~xml
    <!--    User checkLogin(String username, String password);-->
    <select id="checkLogin" resultType="User">
        select * from t_user where username =#{arg0} and password =#{arg1}
    </select>
~~~

## 5.3、map集合类型的参数

> 若mapper接口中的方法需要的参数为多个时，此时可以手动创建map集合，将这些数据放在map中
>
> 只需要通过${}和#{}访问map集合的键就可以获取相对应的值，注意${}需要手动加单引号

**接口**

~~~java
    /*
     * 以map集合验证登录
     * */
    User checkLoginByMap(Map<String,Object> map);
~~~

**映射文件**

~~~xml
    <!--    User checkLoginByMap(Map<String,Object> map);-->
    <select id="checkLoginByMap" resultType="User">
        select * from t_user where username = #{username} and password = #{password}
    </select>
~~~

**测试类**

~~~java
    @Test
    public void TestcheckLoginByMap(){
        SqlSession sqlSession = SqlSessionUtil.getsqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("username","root");
        map.put("password","123456");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }
~~~

## 5.4、实体类类型的参数

> 若mapper接口中的方法参数为实体类对象时
>
> 此时可以使用${}和#{}，通过访问实体类对象中的属性名获取属性值，注意${}需要手动加单引号

~~~xml
    <!--    void insertUser(User user);-->
    <insert id="insertUser">
        insert into t_user values (null,#{username},#{password},#{age},#{gender},#{email})
    </insert>
~~~

## 5.5、使用@Param标识参数

> 可以通过@Param注解标识mapper接口中的方法参数
>
> 此时，会将这些参数放在map集合中，以@Param注解的value属性值为键，以参数为值；以param1,param2...为键，以参数为值；只需要通过${}和#{}访问map集合的键就可以获取相对应的值，
>
> 注意${}需要手动加单引号

**接口**

~~~java
User checkLoginByParam(@Param("username") String username, @Param("password") String password);
~~~

**映射文件**

~~~xml
<!--    User checkLoginByParam(@Param("username") String username, @Param("password") String password);-->
    <select id="checkLoginByParam" resultType="User">
        select * from t_user where username= #{username} and password = #{password}
    </select>
~~~

# 6、MyBatis的各种查询功能

## 6.1、查询一个实体类对象

~~~java
/**
     * 根据ID查询用户信息
     */
    User getUserById(@Param("id") int id );
~~~

~~~xml
    <!--  User getUserById(@Param("id") int id );  -->
    <select id="getUserById" resultType="User">
        select * from t_user where id=#{id}
    </select>
~~~

## 6.2、查询一个list集合

~~~java
    /**
     * 查询所有用户信息
     * @return
     */
    List<User> getAllUsers();
~~~

~~~xml
    <!--    List<User> getAllUsers();-->
    <select id="getAllUsers" resultType="User">
        select * from t_user
    </select>
~~~

> **当查询的数据为多条时，不能使用实体类作为返回值，否则会抛出异常**
>
> TooManyResultsException；但是若查询的数据只有一条，可以使用实体类或集合作为返回值

## 6.3、查询单个数据

~~~java
    /**
     *查询用户的总数量
     * @return 
     * 在MyBatis中，对于Java中常用的类型都设置了类型别名 
     * 例如： java.lang.Integer-->int|integer 
     * 例如： int-->_int|_integer
     * 例如： Map-->map,List-->list
     */
    Integer getCount();
~~~

~~~xml
    <!--    Integer getCount();-->
    <select id="getCount" resultType="Integer">
        select count(*) from t_user
    </select>
~~~

## 6.4、查询一条数据为map集合

~~~java
    /**
     *根据ID查询用户信息为map集合
     */
    Map<String,Object> getUserByIdToMap(@Param("id") Integer id);
~~~

~~~xml
    <!--    Map<String,Object> getUserByIdToMap(@Param("id") Integer id);-->
    <select id="getUserByIdToMap" resultType="map">
        select * from t_user where id=#{id}
    </select>
~~~

~~~
查询结果
{password=123456, gender=男, id=1, age=23, email=123456@qq.com, username=root}
~~~

## 6.5、查询多条数据为map集合

### ①方式一

~~~java
/**
     * 查询所有的用户信息为map集合
     * @return
     *若查询的数据有多条的时候，并且要将每条数据转换为map集合
     * 1.将map接口的返回值设置为泛型为map的list集合
     * 结果： [{password=123456, gender=男, id=1, age=23, email=123456@qq.com, username=root},
     *         {password=admin, gender=男, id=2, age=22, email=123456@qq.com, username=liyouxiu},
     *         {password=admin, gender=男, id=3, age=23, email=123456@qq.com, username=小明}]
     * 
     */

    List<Map<String,Object>> getAllToMap();
~~~

~~~xml
    <!--    Map<String,Object> getAllToMap();-->
    <select id="getAllToMap" resultType="map">
        select * from t_user
    </select>
~~~

### ②方式二

~~~~java
/**
     * 查询所有的用户信息为map集合
     * @return
     *若查询的数据有多条的时候，并且要将每条数据转换为map集合2.可以将每条数据转换的map集合放在一个大的map集合中，但是必须通过		 *	@MapKey注解
     * 将查询的某个字段的值作为map的键
     *    @MapKey("id")
     *     Map<String, Object> getAllToMap();
     * 结果：{1={password=123456, gender=男, id=1, age=23, email=123456@qq.com, username=root},
     *         2={password=admin, gender=男, id=2, age=22, email=123456@qq.com, username=liyouxiu},
     *         3={password=admin, gender=男, id=3, age=23, email=123456@qq.com, username=小明}}
     */
    @MapKey("id")
    Map<String,Object> getAllToMap();
~~~~

~~~xml
    <!--    Map<String,Object> getAllToMap();-->
    <select id="getAllToMap" resultType="map">
        select * from t_user
    </select>
~~~

# 7、特殊SQL的执行

## 7.1、模糊查询

~~~java
    /**
     * 通过用户名模糊查询用户信息
     */
    List<User> getUserByLike(@Param("mohu") String mohu);
~~~

~~~xml
    <!--    List<User> getUserByLike(@Param("mohu") String mohu);-->
    <select id="getUserByLike" resultType="User">
        <!--select * from t_user where username like '%${mohu}%'-->
        <!--select * from t_user where username like concat('%{#mohu}%')-->
        select * from t_user where username like "%"#{mohu}"%"
    </select>
~~~

## 7.2、批量删除

~~~java
    /**
     * 批量删除
     */
    void DeleteMoreUsere(@Param("ids") String ids);//ids:9,10
~~~

~~~xml
    <!--    void DeleteMoreUsere(@Param("ids") String ids); //ids:9,10-->
    <delete id="DeleteMoreUsere">
        delete from t_user where id in(${ids})
    </delete>
~~~

## 7.3、动态设置表名

~~~java
    /**
     * 动态设置表名
     */
    List<User> getAllUsers(@Param("tableName") String tableName);
~~~

~~~xml
    <!--   List<User> getAllUsers(@Param("tableName") String tableName);-->
    <select id="getAllUsers" resultType="User">
        select * from ${tableName}
    </select>
~~~

## 7.4、添加功能获取自增的主键

> 场景模拟：
>
> t_clazz(clazz_id,clazz_name)
>
> t_student(student_id,student_name,clazz_id)
>
> 1、添加班级信息
>
> 2、获取新添加的班级的id
>
> 3、为班级分配学生，即将某学的班级id修改为新添加的班级的id

~~~java
/*** 添加用户信息 
* @param user 
* @return 
* useGeneratedKeys：设置使用自增的主键 
* keyProperty：因为增删改有统一的返回值是受影响的行数，因此只能将获取的自增的主键放在传输的参 数user对象的某个属性中 
*/ 
int insertUser(User user);
~~~

~~~xml
    <!--    void insertUser(User user);-->
    <insert id="insertUser" useGeneratedKeys="true" keyProperty="id" >
        insert into t_user values (null,#{username},#{password},#{age},#{gender},#{email})
    </insert>
~~~

# 8、自定义映射resultMap

## 8.1、resultMap处理字段和属性的映射关系

> 若字段名和实体类中的属性名不一致，则可以通过resultMap设置自定义映射

~~~xml
<!--resultMap：设置自定义映射 
属性： 
id：表示自定义映射的唯一标识 
type：查询的数据要映射的实体类的类型 子
标签： 
id：设置主键的映射关系 
result：设置普通字段的映射关系
association：设置多对一的映射关系 
collection：设置一对多的映射关系 
属性： 
property：设置映射关系中实体类中的属性名 
column：设置映射关系中表中的字段名 
-->
<resultMap id="userMap" type="User">
    <id property="id" column="id"></id>
    <result property="userName" column="user_name"></result>
    <result property="password" column="password"></result>
    <result property="age" column="age"></result>
    <result property="sex" column="sex"></result>
</resultMap>
<!--List<User> testMohu(@Param("mohu") String mohu);-->
<select id="testMohu" resultMap="userMap">
    <!--select * from t_user where username like '%${mohu}%'--> 
    select id,user_name,password,age,sex from t_user where user_name like concat('%',#{mohu},'%') 
</select>
~~~

> 若字段名和实体类中的属性名不一致，但是字段名符合数据库的规则（使用_），实体类中的属性名符合Java的规则（使用驼峰）
>
> 此时也可通过以下两种方式处理字段名和实体类中的属性的映射关系
>
> a>可以通过为字段起别名的方式，保证和实体类中的属性名保持一致
>
> b>可以在MyBatis的核心配置文件中设置一个全局配置信息mapUnderscoreToCamelCase，可
>
> 以在查询表中数据时，自动将_类型的字段名转换为驼峰
>
> 例如：字段名user_name，设置了mapUnderscoreToCamelCase，此时字段名就会转换为
>
> userName

## 8.2、多对一映射处理

> 场景模拟：
>
> 查询员工信息以及员工所对应的部门信息

