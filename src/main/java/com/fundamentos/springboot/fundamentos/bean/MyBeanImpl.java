package com.fundamentos.springboot.fundamentos.bean;

public class MyBeanImpl implements MyBean{

    @Override
    public void print() {
        System.out.println("hoola desde el bean");
    }
}
