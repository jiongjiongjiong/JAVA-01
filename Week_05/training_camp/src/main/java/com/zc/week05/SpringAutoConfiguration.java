package com.zc.week05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: zhangc
 * @date: 2021/2/20
 * @desc:
 */
@Configuration
public class SpringAutoConfiguration {

    @Bean
    public Klass klass(){
        return new Klass();
    }
}
