package com.fundamentos.springboot.fundamentos.bean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyBeanWithDependencyImpl implements MyBeanWithDependency{

    private final MyOperation myOperation;

    public MyBeanWithDependencyImpl(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printhWithDependency() {
        log.info("Hemos ingresado al metodo printhWithDependency");
        int number = 1;
        log.debug("El numero enviado como parametro a la dependendia es: "+number);
        System.out.println(myOperation.sum(number));
        System.out.println("hola desde la implementacion de un bean con dependencia");
    }
}
