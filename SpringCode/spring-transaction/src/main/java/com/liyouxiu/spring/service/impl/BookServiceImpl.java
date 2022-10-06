package com.liyouxiu.spring.service.impl;

import com.liyouxiu.spring.dao.BookDao;
import com.liyouxiu.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * @author liyouxiu
 * @date 2022/10/5 14:08
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
//    @Transactional(
////            readOnly = true
////            timeout = 3
////              noRollbackFor = ArithmeticException.class
////            noRollbackForClassName = "java.lang.ArithmeticException"
//            propagation = Propagation.REQUIRES_NEW
//    )
    public void buyBook(Integer userID, Integer bookID) {
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //查询图书的价格
        Integer price = bookDao.getPriceByBookId(bookID);
        //更新图书的库存
        bookDao.updateStock(bookID);
        //更新用户的余额
        bookDao.updateBalance(userID, price);
//        System.out.println(1/0);
    }
}
