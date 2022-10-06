package com.liyouxiu.spring.proxy;

/**
 * @author liyouxiu
 * @date 2022/10/3 14:37
 */
public class CalculatorStaticProxy implements Calculator{

    private CalculatorImpl calculatorImpl;

    public CalculatorImpl getCalculatorImpl() {
        return calculatorImpl;
    }

    public void setCalculatorImpl(CalculatorImpl calculatorImpl) {
        this.calculatorImpl = calculatorImpl;
    }

    @Override
    public int add(int i, int j) {
        System.out.println("日志，方法：add,参数："+i+"，"+j);
        int result = calculatorImpl.add(i, j);
        System.out.println("日志，方法：add,结果："+result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        return 0;
    }

    @Override
    public int mul(int i, int j) {
        return 0;
    }

    @Override
    public int div(int i, int j) {
        return 0;
    }
}
