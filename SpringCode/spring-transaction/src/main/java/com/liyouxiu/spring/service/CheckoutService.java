package com.liyouxiu.spring.service;

/**
 * @author liyouxiu
 * @date 2022/10/6 9:47
 */
public interface CheckoutService {
    /**
     * 结账
     * @param userID
     * @param bookIDs
     */
    void checkout(Integer userID, Integer[] bookIDs);
}
