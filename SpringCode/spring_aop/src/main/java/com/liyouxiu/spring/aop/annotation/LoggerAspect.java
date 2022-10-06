package com.liyouxiu.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author liyouxiu
 * @date 2022/10/4 14:24
 * 1.在切面中，需要通过指定的注解将方法标识为通知方法
 * @Before ：前置通知，在目标方法执行之前执行
 * @After ：后置通知 ，在目标对象的finally子句中执行的
 * @AfterReturning ：返回通知，在目标对象方法返回值之后执行
 *@AfterThrowing ：异常通知，在目标对象方法的catch子句中执行
 *
 *
 * 2.切入点表达式：设置在标识通知的注解的value属性中
 * execution(public int com.liyouxiu.spring.aop.annotation.CalculatorImpl.add(int,int)
 * execution(* com.liyouxiu.spring.aop.annotation.*.*(..)
 * 第一个*表示任意的访问修饰符和返回值类型
 * 第二个*表示类中的任意方法
 * ..表示任意的参数列表
 * 类的地方也可以使用*，表示包下所有的类
 *
 * 3.获取连接点的信息
 * 在通知方法的参数位置设置JoinPoint类型的参数，就可以获取连接点所对应的方法的信息
 * //获取连接点所对应的签名信息
 * Signature signature = joinPoint.getSignature();
 * //获取连接点所对应的方法参数
 * Object[] args = joinPoint.getArgs();
 *
 * 4.重用切入点表达式
 * @Pointcut 声明一个公共的切入点表达式
 * @Pointcut("execution(* com.liyouxiu.spring.aop.annotation.*.*(..))")
 * public void pointCut(){}
 * 使用方式@After("pointCut()")
 *
 */
@Component //注解保证这个切面类能够放入IOC容器
@Aspect //将当前组件标识为切面
public class LoggerAspect {

    //公共切入点表达式（切入点表达式重用）
    @Pointcut("execution(* com.liyouxiu.spring.aop.annotation.*.*(..))")
    public void pointCut(){}

    //前置通知 标准写法 @Before("execution(方法返回值 具体位置下的某个方法)")
//    @Before("execution(public int com.liyouxiu.spring.aop.annotation.CalculatorImpl.add(int,int))")
    @Before("execution(* com.liyouxiu.spring.aop.annotation.*.*(..))")
    public void beforeAdviceMethod(JoinPoint joinPoint) {
        //获取连接点所对应的签名信息
        Signature signature = joinPoint.getSignature();
        //获取连接点所对应的方法参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect,方法："+signature.getName()+"，参数："+Arrays.toString(args));
    }

    @After("pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect ，方法："+signature.getName()+"，执行完毕");
    }

    //在返回通知中要获取目标对象方法的返回值，只需要通过@AfterReturning注解的returning属性就可以将
    //通知方法的某个参数指定为接受目标对象方法的返回值的参数
    @AfterReturning(value = "pointCut()",returning = "result")
    public void AfterReturningAdviceMethod(JoinPoint joinPoint,Object result){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect，方法："+signature.getName()+",结果："+result);
    }

    //在异常通知中要获取目标对象方法的返回值，只需要通过@AfterThrowing注解的throwing属性就可以将
    //异常方法的某个参数指定为接受目标对象方法的返回值的参数
    @AfterThrowing(value = "pointCut()",throwing = "e")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint,Exception e){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法："+signature.getName()+"，异常："+e);
    }

    @Around("pointCut()")
    //环绕通知的方法的返回值一定要和目标对象的返回值一致
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
