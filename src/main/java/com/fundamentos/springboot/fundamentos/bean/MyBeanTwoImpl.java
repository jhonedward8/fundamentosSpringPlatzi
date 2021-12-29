package com.fundamentos.springboot.fundamentos.bean;

public class MyBeanTwoImpl implements MyBean{
    @Override
    public void print() {
        System.out.println("hola desde bean 2");
    }
}
