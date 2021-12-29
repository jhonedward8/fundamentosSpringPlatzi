package com.fundamentos.springboot.fundamentos.configuration;

import com.fundamentos.springboot.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
    @Bean
    public MyBean beanOperation (){
        return new MyBeanTwoImpl();
    }

    @Bean
    public MyOperation beanOperationOperation(){
        return new MyOperationImpl();
    }

    @Bean
    public MyBeanWithDependency beanOperationBeanWithDependency(MyOperation myOperation){
        return new MyBeanWithDependencyImpl(myOperation);
    }

}
