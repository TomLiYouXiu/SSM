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
