package com.liyouxiu.spring.controller;

import com.liyouxiu.spring.service.BookService;
import com.liyouxiu.spring.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author liyouxiu
 * @date 2022/10/5 14:07
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private CheckoutService checkoutService;
    public void buyBook(Integer userID,Integer bookID){
        bookService.buyBook(userID, bookID);
    }

    public void checkout(Integer userID,Integer[] bookIDs){
        checkoutService.checkout(userID, bookIDs);;
    }
}
