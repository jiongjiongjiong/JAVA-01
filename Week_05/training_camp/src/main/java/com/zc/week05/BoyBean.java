package com.zc.week05;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BoyBean  {
    private ApplicationContext applicationContext;

    @Bean(name = "boy333")
    public Boy create(){
        return new Boy(18,"my18","boyBean",applicationContext);
    }
}
