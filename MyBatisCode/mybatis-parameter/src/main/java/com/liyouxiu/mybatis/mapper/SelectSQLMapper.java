package com.liyouxiu.mybatis.mapper;

import com.liyouxiu.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liyouxiu
 * @date 2022/9/21 21:46
 */
public interface SelectSQLMapper {
    /**
     * 通过用户名模糊查询用户信息
     */
    List<User> getUserByLike(@Param("mohu") String mohu);

    /**
     * 批量删除
     */
    void DeleteMoreUsere(@Param("ids") String ids);//ids:9,10

    /**
     * 动态设置表名
     */
    List<User> getAllUsers(@Param("tableName") String tableName);

    /**
     *添加用户信息并获取自增的主键
     */
    void insertUser(User user);
}
