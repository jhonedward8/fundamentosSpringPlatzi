package com.fundamentos.springboot.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImpl implements ComponentDependency{

    @Override
    public void saludar() {
        System.out.println("hola componente two");
    }
}
