package com.zc.week05;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: zhangc
 * @date: 2021/2/20
 * @desc:
 */
public class SpringDemo01 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Boy boy001 = (Boy) context.getBean("boy222");
        boy001.print();

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("com.zc.week05");
        Boy boy002 = (Boy) annotationConfigApplicationContext.getBean("boy333");
        boy002.print();
    }
}
