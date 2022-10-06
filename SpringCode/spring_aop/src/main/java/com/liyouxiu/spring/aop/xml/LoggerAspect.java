package com.liyouxiu.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author liyouxiu
 * @date 2022/10/4 14:24
 *
 */
@Component //注解保证这个切面类能够放入IOC容器
public class LoggerAspect {
    public void beforeAdviceMethod(JoinPoint joinPoint) {
        //获取连接点所对应的签名信息
        Signature signature = joinPoint.getSignature();
        //获取连接点所对应的方法参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect,方法："+signature.getName()+"，参数："+Arrays.toString(args));
    }


    public void afterAdviceMethod(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect ，方法："+signature.getName()+"，执行完毕");
    }


    public void AfterReturningAdviceMethod(JoinPoint joinPoint,Object result){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect，方法："+signature.getName()+",结果："+result);
    }


    public void afterThrowingAdviceMethod(JoinPoint joinPoint,Exception e){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法："+signature.getName()+"，异常："+e);
    }


    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint){
        Object result=null;
        try {
            System.out.println("环绕通知---->前置通知");
            //表示目标对象方法的执行
            result = joinPoint.proceed();
            System.out.println("环绕通知---->返回通知");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知---->异常通知");
        }finally{
            System.out.println("环绕通知---->后置通知");
        }
        return result;
    }

}
