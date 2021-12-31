package com.fundamentos.springboot.fundamentos.configuration;

import com.fundamentos.springboot.fundamentos.service.UserService;
import com.fundamentos.springboot.fundamentos.usecase.GetUser;
import com.fundamentos.springboot.fundamentos.usecase.GetUserImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public GetUser getUser(UserService userService){
        return  new GetUserImpl(userService);
    }
}
