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
