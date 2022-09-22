package com.liyouxiu.mybatis.mapper;

import com.liyouxiu.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {

    /**
     * 根据ID查询用户信息
     */
    User getUserById(@Param("id") int id );

    /**
     * 查询所有用户信息
     */
    List<User> getAllUsers();

    /**
     *查询用户的总数量
     * @return
     * 在MyBatis中，对于Java中常用的类型都设置了类型别名
     * 例如： java.lang.Integer-->int|integer
     * 例如： int-->_int|_integer
     * 例如： Map-->map,List-->list
     */
    Integer getCount();

    /**
     *根据ID查询用户信息为map集合
     */
    Map<String,Object> getUserByIdToMap(@Param("id") Integer id);

    /**
     * 查询所有的用户信息为map集合
     * @return
     *若查询的数据有多条的时候，并且要将每条数据转换为map集合
     * 1.将map接口的返回值设置为泛型为map的list集合
     * 结果： [{password=123456, gender=男, id=1, age=23, email=123456@qq.com, username=root},
     *         {password=admin, gender=男, id=2, age=22, email=123456@qq.com, username=liyouxiu},
     *         {password=admin, gender=男, id=3, age=23, email=123456@qq.com, username=小明}]
     * 2.可以将每条数据转换的map集合放在一个大的map集合中，但是必须通过@MapKey注解
     * 将查询的某个字段的值作为map的键
     *    @MapKey("id")
     *     Map<String, Object> getAllToMap();
     * 结果：{1={password=123456, gender=男, id=1, age=23, email=123456@qq.com, username=root},
     *         2={password=admin, gender=男, id=2, age=22, email=123456@qq.com, username=liyouxiu},
     *         3={password=admin, gender=男, id=3, age=23, email=123456@qq.com, username=小明}}
     */

//    List<Map<String,Object>> getAllToMap();
    @MapKey("id")
    Map<String,Object> getAllToMap();

    /**
     *
     */
}
