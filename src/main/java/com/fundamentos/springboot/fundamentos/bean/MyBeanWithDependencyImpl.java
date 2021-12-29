package com.fundamentos.springboot.fundamentos.bean;

public class MyBeanWithDependencyImpl implements MyBeanWithDependency{

    private final MyOperation myOperation;

    public MyBeanWithDependencyImpl(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printhWithDependency() {
        int number = 1;
        System.out.println(myOperation.sum(number));
        System.out.println("hola desde la implementacion de un bean con dependencia");
    }
}
