package com.fundamentos.springboot.fundamentos.bean;

public class MyBeanWithPropertiesImpl implements MyBeanWithProperties {

    private final String nombre;
    private final String apellido;

    public MyBeanWithPropertiesImpl(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String funcion() {
        return nombre + "-" + apellido;
    }
}
