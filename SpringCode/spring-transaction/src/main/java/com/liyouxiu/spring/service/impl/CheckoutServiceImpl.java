package com.liyouxiu.spring.service.impl;

import com.liyouxiu.spring.service.BookService;
import com.liyouxiu.spring.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liyouxiu
 * @date 2022/10/6 9:47
 */
@Service
public class CheckoutServiceImpl implements CheckoutService {
    @Autowired
    private BookService bookService;
    @Override
//    @Transactional
    public void checkout(Integer userID, Integer[] bookIDs) {
        for (Integer bookID : bookIDs) {
            bookService.buyBook(userID,bookID);
        }
    }
}
